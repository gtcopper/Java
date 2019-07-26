# Mybatis缓存及原理

### MyBatis缓存机制(一级，二级原理和作用)
* MyBatis**默认开启一级缓存**(**sqlSession**级别)，**默认关闭二级缓存**(**mapper**级别)
* 增删改操作，无论是否进行提交sqlSession.commit()，均会清空一级、二级缓存，使查询再次从DB中select。
* 一级缓存
  * 操作数据库需要使用sqlSession对象，第一次sqlSession从数据库中读取，之后在sqlSession对象内存区域有一个`HashMap`用于存储缓存数据。
  * 当执行SQL中间发生增删改时，Mybatis会清空sqlSession缓存。
  * 一级缓存作用范围有**SESSION**和**STATEMENT**两种。默认是SESSION。不想使用一级缓存可以设置作用范围为STATEMENT，这样每次执行完一个mapper语句都会讲缓存清空。
  * 如果需要更改一级缓存的范围，可以在Mybatis的配置文件中，通过`localCacheScope`指定。 
* 二级缓存
  * 二级缓存指的是mapper映射文件。二级缓存作用域是同一个namespace下的mapper映射内容，多个sqlSession共享。
  * Mybatis需要手动设置启用二级缓存。
  ```
	<settings>
 	 <setting name="cacheEnabled" value="false" />
	</settings>
  ```
  * cacheEnabled默认是不启用的，只有在该值为true的时候，底层使用的`Executor`才是支持二级缓存的CachingExecutor。
  * 具体可以看org.apache.ibatis.session.Configuration的newExecutor方法实现。 
  ```
	public Executor newExecutor(Transaction transaction) {
    	return newExecutor(transaction, defaultExecutorType);}

	public Executor newExecutor(Transaction transaction, ExecutorType executorType) {
    	executorType = executorType == null ? defaultExecutorType : executorType;
    	executorType = executorType == null ? ExecutorType.SIMPLE : executorType;
    	Executor executor;
	    if (ExecutorType.BATCH == executorType) {
	      executor = new BatchExecutor(this, transaction);
	    } else if (ExecutorType.REUSE == executorType) {
	      executor = new ReuseExecutor(this, transaction);
	    } else {
	      executor = new SimpleExecutor(this, transaction);
	    }
	    if (cacheEnabled) {//只有cacheEnabled为true时才开启二级缓存
	      executor = new CachingExecutor(executor);
	    }
	    executor = (Executor) interceptorChain.pluginAll(executor);
	    return executor;
  }
  ```
  * 要使用二级缓存除了上面一个配置外，我们还需要在我们每个DAO对应的Mapper.xml文件中定义需要使用的cache。
  ```
	<mapper namespace="...UserMapper">
    <cache/><!-- 加上该句即可，使用默认配置、还有另外一种方式，在后面写出 -->
</mapper>
  ```
  * 具体可以看org.apache.ibatis.executor.CachingExecutor类的以下实现 
其中使用的cache就是我们在对应的Mapper.xml中定义的cache。
 ```
	 public <E> List<E> query(MappedStatement ms, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, CacheKey key, BoundSql boundSql)
      throws SQLException {
	    Cache cache = ms.getCache();
	    if (cache != null) { //第一个条件 定义需要使用的cache
	      flushCacheIfRequired(ms);
	      if (ms.isUseCache() && resultHandler == null) { //第二个条件 需要当前查询语句配置了使用cache的，即下面源码的useCache()是返回true的  默认是true
	        ensureNoOutParams(ms, parameterObject, boundSql);
	        @SuppressWarnings("unchecked")
	        List<E> list = (List<E>) tcm.getObject(cache, key);
	        if (list == null) {
	          list = delegate.<E> query(ms, parameterObject, rowBounds, resultHandler, key, boundSql);
	          tcm.putObject(cache, key, list); // issue #578. Query must be not synchronized to prevent deadlocks
	        }
	        return list;
	      }
	    }
	    return delegate.<E> query(ms, parameterObject, rowBounds, resultHandler, key, boundSql);
  }
 ```
 * 还有一个条件就是需要当前的查询语句是配置了使用cache的，即上面源码的useCache()是返回true的，默认情况下所有select语句的useCache都是true，如果我们在启用了二级缓存后，有某个查询语句是我们不想缓存的，则可以通过指定其useCache为false来达到对应的效果。
 ```
	<select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.String" useCache="false">
        select
        <include refid="Base_Column_List"/>
        from tuser
        where id = #{id,jdbcType=VARCHAR}
    </select>
 ```

### spring整合MyBatis,MyBatis一级缓存失效？
* 当Mybatis整合Spring后，直接通过Spring注入Mapper的形式，如果**不是在同一个`事务`**中每个Mapper的每次查询操作都对应一个全新的SqlSession实例，这个时候就不会有一级缓存的命中，但是在**同一个`事务`**中时共用的是同一个SqlSession。

参考文章->[你真的懂Mybatis缓存机制吗](https://yq.aliyun.com/articles/608941)