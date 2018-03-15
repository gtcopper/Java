#javaweb入门笔记(5)-Cookie和Session
----
##Cookie和Session
* Cookie 
* Session
  + 实现原理
  + 案例


Cookie是客户端及时，Session是服务器端技术

API: [javax.servlet.http:Class Cookie](http://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html)

[javax.servlet.http:Interface HttpSession](http://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html)

**Cookie**

* Cookie是由服务器创建，然后通过响应发送给客户端的一个键值对
* Cookie是服务器保存在客户端的数据！
* 浏览器一般只允许存放300个cookie，每个站点最多存放20个，每个cookie大小限制为4KB

1.Cookie与请求头和响应头

* 服务器向客户端发送Cookie的响应头为Set-Cookie，例如：Set-Cookie:cookiename=cookievalue
* 客户端向服务器发送Cookie的请求头为Cookie，例如：Cookie:cookiename=cookievalue

2.Servlet中向客户端发送Cookie
>
 	Cookie cookie1 = new Cookie("test1","123");
 	Cookie cookie2 = new Cokkie("test2","456");
 	respone.addCookie(cookie1);
 	response.addCookie(cookie2);


3.Servlet获取从客户端发送过来的Cookie

	Cookie[] cookies =  request.getCookies();
	if(cs!=null) {
		for(Cookie c : cookies) {
			System.out.print(c.getName()+" : "+ c.getValue());
		}
	}

Cookie生命周期和细节:

1. Cookie的maxAge
  * 当服务器创建Cookie对象后，可以调用setMaxAge()方法设置Cookie的最大生命。
  * maxAge **> 0**：表示Cookie在客户端硬盘上保存的最大时间，单位为**秒**；
  * maxAge **< 0**：表示Cookie不会被浏览器保存到硬盘上，而只在浏览器内存中存活，一旦客户端**关闭浏览器**，那么Cookie就消失；
  * maxAge**==0**：表示**删除Cookie**，例如客户端硬盘已经存在名为abc的Cookie，如果服务器再向客户端发送名为abc，并且maxAge为0的Cookie，那么表示删除客户端上的名为abc的Cookie。


2. Cookie的Path
 * 浏览器在访问BServlet时，是否要带上AServlet保存的Cookie呢？这要看Cookie的path了。
  现有资源如下：
>
  	http://localhost:8080/hello/servlet/AServlet
  	http://localhost:8080/hello/servlet/BServlet，保存名为xxx的Cookie
  	http://loclahost:8080/hello/servlet/CServlet，保存名为yyy的Cookie
  	http://loclahost:8080/hello/servlet/user/DServlet, 保存名为zzz的Cookie

>
	// 没有设置Cookie的path
  	AServlet {
     	Cookie c = new Cookie("xxx", "XXX");
     	response.addCookie(c);
  	}
  	// 设置了Cookie的path为/hello
  	CServlet {
     	Cookie c = new Cookie("yyy", "YYY");
     	c.setPath="/hello";
    	response.addCookie(c);
  	}
	//没有设置默认为该Sevlet的路径
  	DServlet {
    	Cookie c = new Cookie("zzz", "ZZZ");
    	resposne.addCookie(c);
  	}	

* 当访问AServlet时，是否要带上xxx这个Cookie呢？因为AServlet的访问路径为/hello/servlet/BServlet，它包含了xxx的path，即/hello/servlet，所以需要带上。

* 当访问AServlet时，是否要带上yyy这个Cookie呢？因为AServlet的访问路径为/hello/servlet/BServlet，它包含了xxx的path，即/hello，所以需要带上。

* 当访问AServlet时，是否要带上zzz这个Cookie呢？因为AServlet的访问路径为/hello/servlet/BServlet，它不包含zzz的path，即/hello/servlet/user，所以不会带上。

3.Cookie的domain

Cookie的path是在同一主机中指定共享Cookie，如果主机不同那么就一定不能共享Cookie，无论path是什么。
  如果希望不同的二级域名中可以共享Cookie，那么就要设置Cookie的domain了。

  例如：news.baidu.com、tieba.baidu.com、zhidao.baidu.com，它们的域名不同，但百度希望它们之间可以共享Cookie，那么就要设置domain了。

 1). 设置Cookie的path为“/”，例如：``cookie.setPath("/")``;

 2). 设置Cookie的domain，例如：``cookie.setDomain(".baidu.com")``，其中domain中没有指定域名前缀！

在news.baidu.com主机中的某个项目中保存了Cookie

  在tieba.baidu.com主机中某个项目中获取Cookie(需要两个虚拟主机)

4.**Cookie保存中文**

Cookie的name和value都是不能保存中文的，但可以先把中文转换成URL编码，然后在保存到Cookie的name和value中。
>
  	String name = "姓名";
  	String value = "李华";
  	name = URLEncoder.encode(name,"UTF-8");
  	value = URLEncoder.encode(value,"UTF-8");
	Cookie c = new Cookie(name, value);
 	response.addCookie(c);

 在获取Cookie时，再使用URL解码即可。


	 Cookie[] cs = request.getCookies();
	 if(cs!=null) {
	 for (Cookie c : cs) {
		String name = URLEncoder.decode(c.getName(),"UTF-8");
		String value = URLEncoder.decode(c.getValue(),"UTF-8");
		System.out.println(name + "=" + value);
		}
	}

**HttpSession**

1. **获取HttpSession**
 * HttpSession session = request.getSession();
 * HttpSession session = request.getSession(false);//只获取不创建

2. **域功能**
 * session是域对象，所以有setAttribute()和getAttribute()等方法
  服务器会为每个会话创建一个session对象，所以session中的数据可供当前会话中所有servlet共享。

3. **登录案例**
 * 请求功能：
 * 如果登录功能，在session中保存user对象
 * 访问index1.jsp，查看session中是否存在user对象，如果存在，说明已经登录过。
 * 访问index2.jsp，查看session中是否存在user对象，如果存在，说明已经登录过。
 * 如果关闭了浏览器，那么会话结束，再打开浏览器就开始了一个新会话，那么直接访问index1.jsp或index2.jsp时，session是新的，没有保存user对象，那么表示还没有登录。

4. **session的原理**
 * session是依赖Cookie实现的。
 * session是服务器端对象
 *  当用户第一次使用session时（表示第一次请求服务器），服务器会创建session，并创建一个Cookie，在Cookie中保存了session的id，发送给客户端。这样客户端就有了自己session的id了。但这个Cookie只在浏览器内存中存在，也就是说，在关闭浏览器窗口后，Cookie就会丢失，也就丢失了sessionId。
 *  当用户第二次访问服务器时，会在请求中把保存了sessionId的Cookie发送给服务器，服务器通过sessionId查找session对象，然后给使用。也就是说，只要浏览器容器不关闭，无论访问服务器多少次，使用的都是同一个session对象。这样也就可以让多个请求共享同一个session了。
 *  当用户关闭了浏览器窗口后，再打开浏览器访问服务器，这时请求中没有了sessionId，那么服务器会创建一个session，再把sessionId通过Cookie保存到浏览器中，也是一个新的会话开始了。原来的session会因为长时间无法访问而失效。
 *  当用户打开某个服务器页面长时间没动作时，这样session会超时失效，当用户再有活动时，服务器通过用户提供的sessionId已经找不到session对象了，那么服务器还是会创建一个新的session对象，再把新的sessionId保存到客户端。这也是一个新的会话开始了。
 *  设置session超时时间
 >
     web.xml文件中配置如下：
    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>


5.session与浏览器

* session对象是保存在服务器端的，而sessionId是通过Cookie保存在客户端的。
* 因为Cookie不能在多个浏览器中共享，所以session也不能在多个浏览器中共享。也就是说，使用IE登录后，再使用FireFox/其他浏览器访问服务器还是没有登录的状态。
* 而且同时打开多个相同浏览器的窗口，是在使用同一session。如果你使用的是老浏览器，例如IE6，那么就会每个窗口一个session。

6.session的API

* String getId();//获取sessionId；
* int getMaxInactiveInterval();//获取session可以的最大不活动时间（秒），默认为30分钟。当session在30分钟内没有使用，那么Tomcat会在session池中移除这个session；
* void setMaxInactiveInterval(int interval);//设置session允许的最大不活动时间（秒），如果设置为1秒，那么只要session在1秒内不被使用，那么session就会被移除；
* long getCreationTime();//返回session的创建时间，返回值为当前时间的毫秒值；
* long getLastAccessedTime();//返回session的最后活动时间，返回值为当前时间的毫秒值；
* void invalidate();//让session失效！调用这个方法会被session失效，当session失效后，客户端再次请求，服务器会给客户端创建一个新的session，并在响应中给客户端新session的sessionId；
* boolean isNew();//查看session是否为新。当客户端第一次请求时，服务器为客户端创建session，但这时服务器还没有响应客户端，也就是还没有把sessionId响应给客户端时，这时session的状态为新。

7.URL重写

 * session依赖Cookie，这是因为服务器需要把sessionId保存到客户端。如果用户的浏览器关闭了Cookie功能，那么session不能使用了！
 * 还可以在浏览器关闭了Cookie后使用URL重写的方法保存sessionId，这需要在每个URL后面都加上sessionId！这样用户的请求中就包含了sessionId，服务器就可以通过sessionId找到对应的session对象了。
 * 使用response.encodeURL()方法对URL进行编码，这样URL中会**智能的添加sessionId**。
 * 当浏览器支持cookie时，response.encodeURL()方法不会在URL后追加sessionId
 * 当浏览器不支持cookie时，response.encodeURL()方法会在URL后追加sessionId

8.用户案例

* 用户登录
* 防止表单重复提交
* 一次性验证码的校验

建议:

 * 一般大型网站不用session,使用cookie,减小服务器压力
 * 若浏览器禁用cookie,需使用url自带sessionid，相关方法:encodeURL和encodeRedirectURL
 * 禁止表单重复提交：在javascript或者服务器实现。javascript防不死，用户可通过修改js、自建表单提交，刷新页面，后退等方法重复提交；服务器实现是给每个表单一个随机表单号
 * 生成表单号使用“令牌发生器”，为保证唯一性(减小重复概率)，使用单例。
 * base64编码，三字节变四字节，每6位变8位(一字节)，高位补零，每字节最大值为63，故得名。
 * md5，常用于保存密码(可能为防止破解会加随机数)，校验数据完整性


##三个域对象

* ServletContet
* Request
* Session

容器选用经验：

 * 数据显示完了就没用了，则选用Request
 * 数据除了显示外，稍后还会用，则选用Session
 * 数据除了显示外，不仅稍后会用，还会给别人用，则选用ServletContext