#javaweb入门笔记(3)-Servlet
----
##javaweb入门笔记(3)-Servlet
 * 什么是Servlet
 * 实现Servlet的方式
 * Servlet第一例
 * Servlet生命周期
 * ServletConfig
 * GenericServlet
 * HttpServlet
 * <url-pattern>
 * Servlet细节
 * ServletContext
 * 获取类路径资源
 
##什么是Servlet
 * Servlet是JavaWeb三大组件之一（Servlet、Filter、Listener）
 * Servlet是用来处理客户端请求的动态资源
 * Servlet的任务有：
    + 获取请求数据
    + 处理请求
    + 完成响应
 * Servlet接口方法
   + void init(ServletConfig)//初始化
   + void service(ServletRequest,ServletResponse)//处理事务
   + void destory() //摧毁Servlet
   + ServletConfig getServletConfig() // 返回ServletConfig对象
   + String getServletInfo() //返回有关servlet的信息，如作者、版本和版权
##实现Servlet的方式
	* 实现Servlet接口（不方便）
	* 继承GenericServlet类（不方便）
	* 继承HttpServlet类（方便）
##Servlet第一例
在webapps目录下创建firstservlet目录，它就是我们的应用目录了，然后在firstservlet目录中创建准备JavaWeb应用所需内容：

* 创建/firstservlet/WEB-INF目录；
* 创建/firstservlet/WEB-INF/classes目录；
* 创建/firstservlet/WEB-INF/lib目录；
* 创建/firstservlet/WEB-INF/web.xml文件；

完成Servlet需要分为两步：

* 编写FirstServlet类实现Servlet接口；
* 配置web.xml文件.

FirstServlet:


	import cn.copper.*;
	import java.io.*;
	import javax.servlet.*;
	public class FirstServlet implements Servlet {
	public void init(ServletConfig config) throws ServletException {}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		System.out.println("FirstServlet~~");	
	}
	public void destory(){}
	public ServletConfig  getServletConfig() {return null;}
	public String getServletInfo(){return null;}
	}

配置web.xml文件
>
	<Servlet>
		<Servlet-name>FirstServlet</Servlet-name>
		<Servlet-class>cn.copper.servlet.FirstServlet</Servlet-class>
		<load-on-startup>1</load-on-startup>//服务器启动次序，数字越低越先启动(非负整数)
	</Servet>
	<Servlet-mapping>
		<Servlet-name>FirstServlet</Servlet-name>
		<url-pattern>/FirstServlet</url-pattern>
	</Servlet-mapping>

	

**注意:编译HelloServlet时需要导入servlet-api.jar，因为Servlet.class等类都在servlet-api.jar中。**

DOS界面编译: javac -classpath D:/tomcat7/lib/servlet-api.jar(Tomcat servlet-api.jar包所在路径) -d . HelloServlet.java

FirstServlet.class放到/firstServlet/WEB-INF/classes/目录(cn.copper.servlet)下，然后启动Tomcat，在浏览器中访问：http://localhost:8080/firstServlet/FirstServlet即可在控制台上看到输出-----FirstServlet~~！
##Servlet生命周期
Servlet接口一共5个方法，但其中只有三个是生命周期方法：

  * void init(ServletConfig)
  * void service(ServletRequest,ServletResponse)
  * void destory()

时序图:
![](https://camo.githubusercontent.com/4add5ddf8c0da7d49f0167902fab4c81f56ee167/687474703a2f2f3778706836642e636f6d312e7a302e676c622e636c6f7564646e2e636f6d2f6a6176617765625f736572766c65742d6c6966656379636c652e706e67)

1). 服务器创建Servlet：

  * 当Servlet第一次被请求时，或服务器启动时，服务器会创建Servlet实例。
  * 服务器默认是在servlet第一次被请求时创建Servlet实例，如果希望服务器启动时就创建Servlet实现需要在web.xml中配置
  * 服务器只为一个类型的Servlet创建一个实例对象，所以Servlet是单例的；
 

2). 服务器初始化Servlet：

  * 当服务器创建Servlet实例后会马上调用Servlet的init(ServletConfig)方法，完成对Servlet的初始化；
  * init(ServletConfig)只会被调用一次
  * 服务器会在调用init()方法时传递ServletConfig参数

3). 服务器使用Servlet处理请求：

  * 当Servlet被请求时，服务器会调用Servlet的service(ServletRequest,ServletResponse)方法
  * service(ServletRequest,ServletResponse)方法每处理一次请求，就会被调用一次，所以它可能会被调用N次
  * 因为Servlet是单例的，所以可能在同一时刻一个Servlet对象会被多个请求同时访问，所以这可能出现线程案例问题
  * Servlet不是线程案例的，这有助与提高效率，但不能让Servlet具有状态，以免多个线程争抢数据

4). 服务器销毁Servlet

  * 服务器通常不会销毁Servlet，通常只有在服务器关闭时才会销毁Servlet
  * 服务器会在销毁Servlet之前调用Servlet的destory()方法
  * 可以在destory()方法中给出释放Servlet占有的资源，但通常Servlet是没什么可要释放的，所以该方法一般都是空的
##ServletConfig
ServletConfig是Servlet中的init()方法的参数类型，服务器会在调用init()方法时传递ServletConfig对象给init()方法。
ServletConfig对象封装了Servlet在web.xml中的配置信息，它对应<servlet>元素。ServletConfig类的功能有：

* String getServletName()：获取Servlet配置名，即<servlet-name>的值；
* ServletContext getServletContext()：获取ServletContext对象(上下文对象);
* String getInitParameter(String name)：获取初始化参数
* Enumeration getInitParameterNames()：获取所有初始化参数的名称

在web.xml文件中，配置<servlet>时可以为<servlet>配置0~N个初始化参数，例如：
>
	<Servlet>
		<Servlet-name>FirstServlet</Servlet-name>
		<Servlet-class>cn.copper.servlet.FirstServlet</Servlet-class>
		<init-param>
    		<param-name>p1</param-name>
    		<param-value>v1</param-value>
  		</init-param>
 	 	<init-param>
    		<param-name>p2</param-name>
    		<param-value>v2</param-value>
  		</init-param>
	</Servet>
	<Servlet-mapping>
		<Servlet-name>FirstServlet</Servlet-name>
		<url-pattern>/FirstServlet</url-pattern>
	</Servlet-mapping>

	
##GenericServlet
GenericServlet是Servlet接口的实现类，但它是一个抽象类，它唯一的抽象方法就是service()方法
  GenericServlet实现了Servlet方法：

* 实现了String getServletInfo()方法
* 实现了void destory()方法，空实现
* 实现了void init(ServletConfig)方法，用来保存ServletConfig参数
* 实现了ServletConfig getServletConfig()方法

 GenericServlet实现了ServletConfig接口：

* 实现了ServletContext getServletContext()方法
* 实现了String getInitParameter()方法
* 实现了String getServletName()方法
* 实现了Enumeration getInitParameterNames()方法

GenericServlet添加了init()方法：

  * 该方法会被init(ServletConfig)方法调用
  * 如果希望对Servlet进行初始化，那么应该覆盖init()方法，而不是init(ServletConfig)方法
##HttpServlet
HttpServlet是GenericServlet的子类，它专注HTTP请求

HttpServlet类的方法：

* 实现了void service(ServletRequest,ServletResponse)方法，实现内容是：
 + 把ServletRequest强转成HttpServletRequest
 + 把ServletResponse强转成HttpServletResponse
 + 调用本类添加的void service(HttpServletRequest,HttpServletResponse)方法
* 添加了void service(HttpServletRequest,HttpServletResponse)方法，内容是：
 + 调用request的getMethod()获取请求方式
 + 如果请求方式为GET，那么调用本类添加的doGet(HttpServletRequest,HttpServletResponse)方法
 + 如果请求方式为POST，那么调用本类添加的doPost(HttpServletRequest,HttpServletResponse)方法
* 添加了doGet(HttpServletRequest,HttpServletResponse)方法，内容是响应405，表示错误，所以我们应该去覆盖这个方法
* 添加了doPost(HttpServletRequest,HttpServletResponse)方法，内容是响应405，表示错误，所以我们应该去覆盖这个方法

　如果是通过继承HttpServlet类来自定义Sevlet的话，那么：

  * 不要去覆盖void service(ServletRequest,ServletResponse)
  * 不要去覆盖void service(HttpServletRequest, HttpServletResponse)
  * 而应该去覆盖doGet()或doPost()方法。
##<url-pattern>
<url-pattern>是<servlet-mapping>的子元素，用来绑定Servlet的访问路径
  可以在一个<servlet-mapping>中给出多个<url-pattern>，也就是说一个Servlet可以有多个访问路径：
>
  	<servlet-mapping>
    <servlet-name>xxx</servlet-name>
    <url-pattern>/helo1<url-pattern>
    <url-pattern>/hello2<url-pattern>
  	</servlet-mapping>
>
  还可以在<url-pattern>中使用通配符，即"*"。

  * <url-pattern>/*<url-pattern>：表示匹配任何路径
  * <url-pattern>/do/*<url-pattern>：表示匹配以/do开头的任何路径
  * <url-pattern>*.do<url-pattern>：表示匹配任何以“.do”结尾的路径

注意：

* 通配符要么在开头，要么在结尾，不能在中间，例如：/*.do就是错误的使用。
* 如果不使用通配符，那么<url-pattern>必须以“/”开头，例如：<url-pattern>abc</url-pattern>就是错误的
##Servlet细节
* 不要在Servlet中创建成员！创建局部变量即可！(一个类型的Servlet只有一个实例对象，Servlet多人访问是**线程不安全的**)
* 可以创建无状态成员！
* 可以创建有状态的成员，但状态必须为只读的！
##ServletContext
ServletContext是Servlet三大域对象之一.

ServletContext在服务器启动时创建，在服务器关闭时销毁，一个JavaWeb应用只创建一个ServletContext对象.

1. **主要功能**
  * 存取数据
  * 读取web.xml中的应用初始化参数
  * 读取应用资源(在整个Web应用的动态资源之间共享数据)
2. **获取ServletContext对象**

 在HttpServlet中可以通过以下方法来获取ServletContext对象:

* ``ServletContext sc = this.getServletContext();``
* ``ServletContext sc = this.getServletConfig().getServletContext();``


3.**存取数据**

在一个JavaWeb应用中，只有一个ServletContext对象，所以在ServletContext中保存的数据可以共整个JavaWeb应用中的动态资源共享
  ServletContext是Servlet三大域对象之一，域对象内部有一个Map，用来保存数据.

* ``void setAttribute(String name, Object value);``//用来添加或替换ServletContext域数据
* ``Object getAttribute(String name);``//通过名称来获取域数据
* ``void removeAttribute(String name);``//通过名称移除域数据
* ``Enumeration<String> getAttributeNames();``//获取所有ServletContext域数据的名称


4.**读取web.xml中配置的应用初始化参数**
>
	<context-param>
		<param-name>a</param-name>
		<param-value>1</param-value>
	</context-param>
	<context-param>
		<param-name>b</param-name>
		<param-value>2</param-value>
	</context-param>

* ``ServletContext.getInitParameter("a");``  ->1
* ``ServletContext.getInitParameter("b");``	->2
* ``ServletContext.getInitParameterNames();`` //返回Enurmation<Stirng>,包含a和b.

5.获取项目资源

* ``String getRealPath(String path);``//返回真实路径
``String path =  ServletContext.getRealPath("/WEB-INF/a.jpg");``
返回值为/WEB-INF/a.jpg真实路径，即磁盘路径：D:/tomcat7/wabapps/hello/WEB-INF/a.jpg
* ``InputStream getResourcesAsStream(String path);``//获取资源输入流
``InputStream in  = ServletContext.getResoureAsStream("a.jpg");``
返回的是a.jpg的输入流对象，可以从流中得到a.jpg的数据.
* ``Set<String> getResourcePaths(String path);``//获取指定目录下的所有资源路径
	
	``Set<String> paths = ServletContext.getResourcePaths("/WEB-INF");``
返回如下字符串:
>   
	/WEB-INF/lib/
    /WEB-INF/classes/
    /WEB-INF/web.xml
    /WEB-INF/a.jpg
>
	
##获取类路径资源 
可以通过Class类的对象来获取类路径下的资源，对应JavaWeb应用的类路径就是classes目录下的资源

* ``InputStream in = this.getClass().getResourceAsStream("a.jpg");``

 获取的是：/WEB-INF/classes/cn/copper/servlet/a.jpg，即与**当前Servlet.class**同目录下的资源.

* ``InputStream in = this.getClass().getResourceAsStream("/a.jpg");``
 
获取的是：/WEB-INF/classes/a.jpg，即类路径的根目录下的资源，类路径的根目录就是**/classes**目录.