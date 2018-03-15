#javaweb入门笔记(6)-JSP
----

**JSP**

 * JSP的调用和运行原理
 * JSP的语法
 * JSP指令
 * JSP九大内置对象
 * JSP动态标签
 * JSP与JavaBean

**1.JSP的调用和运行原理**

* JSP：Java Server Pages，一种动态web资源的开发技术
* JSP本质上是一个**Servlet.**
* 每个JSP页面在第一次被访问时，WEB容器会把请求交给**JSP引擎**(即一个JAVA程序)处理。JSP引擎先将JSP翻译成一个**_jspServlet**(实质也是一个servlet)，然后按照servlet的调用方式进行调用。
* 服务器会将jsp先翻译成servlet，这个servlet位于tomcat服务器**work**目录，这jsp类的父类是``org.apache.jasper.runtime.HttpJspBase``,这个HttpJspBase类继承自**HttpServlet.**
* 向服务器发请求会调用servlet的service方法;同样地，访问jsp会调用这个JSP类的**_jspService方法。**
* JSP中的标签语言会在**_jspService方法中通过out.write()写出来**；JSP中的Java代码会原封不动的搬到_jspService方法中。
* 在_jspService方法中提前准备好了一些对象供JSP调用，如：``out,page,application,request,response``等等。
* 由于第一次访问时会翻译成servlet，所以第一次访问较慢。

2.**JSP语法**

 * <%...%>：Java语句；
 * <%=…%>：Java表达式；//相当于out.print();
 * <%!...%>：Java定义类成员；//内容会放到_jspService()方法之外，被类直接包含.

3.**JSP指令**

JSP有三大指令：

  * page指令
  * include指令
  * taglib指令

1).**page** --> <%@page language="java" info="xxx"...%>

* pageEncoding和contentType：
 + pageEncoding：它指定当前jsp页面的编码.在服务器要把jsp编译成.java时需要使用pageEncoding!
 + contentType：它表示添加一个响应头：Content-Type！等同与response.setContentType("text/html;charset=utf-8");
 + 如果两个属性只提供一个，那么另一个的默认值为设置那一个。
 + 如果两个属性都**没有设置**，那么默认为ISO-8859-1.

* import：导包！可以出现多次.
* errorPage和isErrorPage
 + errorPage：当前页面如果抛出异常，那么要转发到哪一个页面，由errorPage来指定
 + isErrorPage：它指定当前页面是否为处理错误的页面！当该属性为true时，这个页面会设置状态码为500！**而且这个页面可以使用9大内置对象中的exception!**
>
	<error-page>
  		<error-code>404</error-code>
  		<location>/error/errorPage.jsp</location>
    </error-page>
    <error-page>
        <error-code>500</error-code>
        <location>/error/errorPage.jsp</location>
      </error-page>
    <error-page>
        <exception-type>java.lang.RuntimeException</exception-type>
        <location>/index.jsp</location>
    </error-page>


* autoFlush和buffer
 + autoFlush：指定jsp的输出流缓冲区满时，是否自动刷新！默认为true，如果为false，那么在缓冲区满时抛出异常！
 + buffer：指定缓冲区大小，默认为8kb，通常不需要修改！
* isELIgnored：是否忽略el表达式，默认值为false，不忽略，即支持！
* page指令的其他属性
 + language：指定当前jsp编译后的语言类型，默认值为java。
 + info：信息！
 + isThreadSafe：当前的jsp是否支持并发访问！
 + session：当前页面是否支持session，如果为false，那么当前页面就没有session这个内置对象！
 + extends：让jsp生成的servlet去继承该属性指定的类！

* 在web.xml页面中配置<jsp-config>也可以完成很多page指定的功能！

>
	<jsp-config>
		<jsp-property-group>
			<url-pattern>*.jsp</url-pattern><!-- 对所有jsp脚本进行配置-->
			<el-ignored>true</el-ignored><!--忽略el表达式-->
			<page-encoding>UTF-8</page-encoding><!-- 设置编码-->
			<scripting-invalid>true</scripting-invalid><!--禁用Java脚本！如果在JSP页面中使用了Java脚本就会抛出异常。-->
		</jsp-property-group>
	</jsp-config>

2).**include指令** --> 静态包含

* 与RequestDispatcher的include()方法的功能相似！
* <%@include%> 它是在jsp编译成java文件时完成的！**他们共同生成一个java(就是一个servlet)文件，然后再生成一个class！**
* RequestDispatcher的include()是一个方法，包含和被包含的是**两个servlet**，即**两个.class**！他们只是把响应的**内容在运行时合并了**！
* 作用：把页面分解了，使用包含的方式组合在一起，这样一个页面中不变的部分，就是一个独立jsp，而我们只需要处理变化的页面。

3).**taglib指令** --> 导入标签库

* 两个属性：
 + prefix：指定标签库在本页面中的前缀！由我们自己来起名称！
 + uri: 指定标签库的位置！
 + <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>//jstl标签库

4.**九个内置对象**

无需在jsp中声明即可使用的9个对象

* out（JspWriter）：等同于response.getWriter()，用来向客户端发送文本数据；
* config（ServletConfig）：对应“真身”中的ServletConfig；
* page (当前Jsp真身类型) :  当前JSP页面的“this”，即当前对象，引用为Object类型；
* pageContext（pageContext） : 页面上下文对象，四大域对象之一
* request(HttpServletRequest): 即HttpServletRequest类的对象；
* response(HttpServletResponse) :即HttpServletResponse类的对象；
* session(HttpSession) :即HttpSession类的对象；不是每个JSP页面中都可以使用，如果在某个JSP页面中设置<%@page session=”false”%>，说明这个页面不能使用session。
* application(ServletContext) : 即ServletContext类的对象；
* exception（Throwable）：只有在错误页面中可以使用这个对象；

**PageContext对象**

pageContext对象:是JSP技术中最重要的一个对象，它代表JSP页面的运行环境

* 自身是一个域对象，可用来保存数据(page域存的东西只能在页面范围内拿得出来)
* 封装了对其他8大隐式对象的引用(主要用于自定义标签开发)
* 封装了web开发中的一些常用操作(**提供管理所有域的入口**)，如：引入和跳转其他资源、检索其他域对象中的属性等

javaweb中的四个域:

* application域:应用程序范围,servletContext,对应的常量PageContext.APPLICATION_SCOPE
* session域:会话范围,session,对应的常量PageContext.SESSION_SCOPE
* resquet域:请求范围,request,对应的常量PageContext.REQUEST_SCOPE
* page域:页面范围,pageContext,对应的常量PageContext.PAGE_SCOPE

管理其他域功能:

>
   	pageContext.setAttribute("x", "X");
	pageContext.setAttribute("x", "XX", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("x", "XXX", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("x", "XXXX", PageContext.APPLICATION_SCOPE);



``findAttribute(java.lang.String name)``查找各个域中的属性,
会依次从page,request,session,application域中寻找相应的属性，找到为止。page域的优先级最高


**jsp动态标签**

**<jsp:include>**  --> <jsp:include page="xxx"/>，用来包含指定的页面。

标签内部使用的是RequestDispatcher#include()方法完成的包含(编译成两个Servlet)

**<jsp:forward>**  --><jsp:forward page="xxx"/>，用来**转发**到指定页面

在<jsp:forwad>标签下面的内容不会被执行。

**<jsp:param>** --<jsp:include>和<jsp:forward>的子标签，用来向其他页面传递参数。

>
	<jsp:include page="/b.jsp">
		<jsp:param value="XXX" name="username"/> 
	</jsp:include><!--在b.jsp中可以使用request.getParameter("username")来获取参数值。-->


**JSP与JavaBean**

JavaBean是一个遵循特定写法的java类，JavaBean常用于封装数据，具有如下热点：

* 该java类必须有一个无参的构造函数
* 属性必须私有化
* 私有化的属性必须通过public类型的方法暴露给其他程序，并且方法的命名也必须遵循一定的命名规范(get/set/is)。

JavaBean主要是用来通过**反射**操作的类！

* 因为需要通过**Class的newInstance()方法**来创建类的实例，所以要求类必须提供public的无参构造器
* 因为需要通过反射来操作属性，所以需要提供getter/setter方法。

**内省**

内省依赖反射，内省比反射简化一点点，用来操作JavaBean.
已有对象：Map、Class<User>

1 通过Class对象获取BeanInfo

* BeanInfo info = Introspector.getBeanInfo(User.class);

2.通过BeanInfo获取所有属性描述符对象
 
* PropertyDescriptor[] pd = info.getPropertyDescriptors();

3.PropertyDescriptor：

* String name getName()：获取当前属性名称
* Method getReadMethod()：获取get方法反射对象
* Method getWriteMethod()：获取set方法反射对象

**common-utils**

beanutils比内省要简单很多，而且还要强大很多，它底层依赖内省。

1. jar包
 * commons-beanutils.jar、commons-logging.jar

2. 通过反射设置Javabean
>
	Class<User> clazz =  User.class;
	Object user = clazz.newInstance();
	BeanUtils.setPropertt(user, "username", "admin");
	BeanUtils.setProperty(user, "password", "admin123"); 
>

3.获取属性值

* 
String username = BeanUtils.getProperty(user, "username");

4.把Map数据封装到JavaBean对象中
>
 	Map<String,String> map = new HashMap<String,String>();
	map.put("username", "admin");
	map.put("password", "admin123");
	User user = new User();
	BeanUtils.populate(user, map); 

//要求：map的key名称必须与User类的属性名称相同。不要无法赋值！


JSP中提供了三个关于JavaBean的标签：

* <jsp:useBean>
* <jsp:setProperty>
* <jsp:getProperty>

<jsp:useBean>:用于在JSP页面中查找或实例化一个JavaBean组件

 * ``<jsp:useBean id="user1" class="cn.copper.domain.User" />``//默认page域查找，找不到就创建.

可以通过scope属性来指定操作的域:
>
	<jsp:useBean id="user1" class="cn.copper.domain.User" scope="page"/>
	<jsp:useBean id="user2" class="cn.copper.domain.User" scope="request"/>
	<jsp:useBean id="user3" class="cn.copper.domain.User" scope="session"/>
	<jsp:useBean id="user4" class="cn.copper.domain.User" scope="applicatioin"/>


<jsp:setProperty>

设置属性

* <jsp:setProperty property="username" name="user1" value="admin"/>
* name：指定名为user1的JavaBean
* property：指定要设置的属性名称
* value：指定要设置的属性值
* **注意**:可用请求参数给bean属性赋值，支持8种基本数据类型的转换
* 在标签中将property="*"，用所有请求参数为bean赋值，请求参数名称和bean属性名称必须要一致

<jsp:getProperty>

获取属性

* <jsp:getProperty property="username" name="user1"/>
输出user1这个javaBean的username属性值.