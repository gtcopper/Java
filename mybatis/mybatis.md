# Mybatis

### Mybatis哪里使用了反射机制？

### Mybatis数据库表与配置文件是如何实现映射关系的？

### Mybatis缓存机制(一级，二级原理和作用)

### spring整合mybatis,mybatis一级缓存失效？

### Mybatis中collection和association区别
* collection用于一对多关系，例如一个部门对应多个员工
```
<resultMap type="com.hw.entity.Dept" id="deptinfo"><!-- 如果不用resultMap则不写 -->
        <result column="did" property="did" />
        <result column="dname" property="dname" />
        <!-- mybatis中 1方配置多方 -->
        <collection property="per" ofType="com.hw.entity.Person">
            <result column="pid" property="pid" />
            <result column="pname" property="pname" />
            <result column="psex" property="psex" />
            <result column="skilled" property="skilled" />
            <result column="degree" property="degree" />
            <result column="jobtime" property="jobtime" javaType="java.sql.Date" jdbcType="DATE" />
            <result column="resume" property="resume" />
            <result column="filepath" property="filepath" />
        </collection>
    </resultMap>
```
* association用于多对一关系。例如多个员工对应一个部门

### Mybatis原理
* [MyBatis原理深入解析](https://www.jianshu.com/p/ec40a82cae28)
* [深入理解Mybatis](https://blog.csdn.net/luanlouis/article/details/40422941)