# MyBatis

### MyBatis哪里使用了反射机制？

### MyBatis数据库表与配置文件是如何实现映射关系的？

### MyBatis中collection和association区别
* collection用于一对多关系，例如一个部门对应多个员工
* JavaBean为Set时，使用collection
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
```
<resultMap type="com.hw.entity.Person" id="personinfo"><!-- 如果不用resultMap则不写 -->
        <result column="pid" property="pid" />
        <result column="pname" property="pname" />
        <result column="psex" property="psex" />
        <result column="skilled" property="skilled" />
        <result column="degree" property="degree" />
        <result column="jobtime" property="jobtime" javaType="java.sql.Date"
            jdbcType="DATE" />
        <result column="resume" property="resume" />
        <result column="filepath" property="filepath" />
        <!--多对一的关系, property: 指的是属性的值, javaType：指的是属性的类型 -->
        <association property="dept" javaType="com.hw.entity.Dept">
            <result column="did" property="did" />
            <result column="dname" property="dname" />
        </association>
    </resultMap>
```
* 关联(Association）关系是类与类之间的联接，它使一个类知道另一个类的属性和方法。关联可以是双向的，也可以是单向的。在Java语言中，关联关系一般使用成员变量来实现。
### Mybatis原理
* [MyBatis原理深入解析](https://www.jianshu.com/p/ec40a82cae28)
* [深入理解Mybatis](https://blog.csdn.net/luanlouis/article/details/40422941)