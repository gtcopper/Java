#javaweb入门笔记(4)-Request和Response
----
##Request和Response
* Response对象
* Request对象
* 路径
* 编码

Request和Response对象

* 服务器接受到请求后，会创建Request和Respnse对象，将请求数据封装到Request对象中;
* 然后调用Servlet的service方法，将Request和Response对象传递给service()方法;
* 在service()方法中，可以通过Request对象获取请求数据，再通过Response对象响应给客户端;
* 每次请求服务器都会创建新的Request和Response对象(每个请求有自己的Request和Response对象).

**Response对象**

1. Response功能:
  * 设置响应头
  * 设置(发送)状态码
  * 设置响应正文
  * 重定向

**设置响应头**

 + ``response.setHeader("Content-type","text/html;charset=UTF-8");//设置响应编码``
 + ``response.setContentType("text/html;charset=UTF-8");//设置响应编码(默认调用setHeader和setCharacterEncoding)``
 + ··response.setHeader("Refresh","10;https://www.github.com");``//10秒刷新到github首页
 
**设置(发送)状态码**

+ ``response.setStatus(200);//设置成功响应码``
+ ``response.sendError(404,"您要查找的页面不存在");//发送404错误，让Tomcat跳转到错误页面显示``
+ ``response.sendError(505,"服务器内部错误");//发送505错误让Tomcat跳转到错误页面显示``

**设置响应正文**

repsonse一共提供了**两个响应流对象**：

* ``PrintWriter out = response.getWriter();//获取字符流``
* ``ServletOutputStream out = reponse.getOutputStream();//获取字节流``

响应正文内容为字符，那么使用``response.getWriter()``，如果响应内容是字节，例如**下载**时，那么可以使用``response.getOutputStream()``。

**注意:**在一个请求中，不能同时使用这两个流！也就是说，要么你使用``repsonse.getWriter()``，要么使用``response.getOutputStream()``，但不能同时使用这两个流。不然会抛出**IllegalStateException**异常。

**response的字符编码**

* response默认字符编码是**ISO-8859-1**;
* 通常浏览器默认使用编码**GBK**;
* ``response.setCharacterEncoding("UTF-8");//设置response.getWriter()的字符编码``


**注意:**如果希望通知客户端使用UTF-8来解读响应数据，那么还是使用response.setContentType("text/html;charset=UTF-8")方法比较好，因为这个方法不只会调用response.setCharaceterEncoding("UTF-8")，还会设置content-type响应头，客户端浏览器会使用content-type头来解读响应数据。

**response字符流缓冲区**

* response.getWriter()是PrintWriter类型，存在字符流缓冲区，默认大小为8KB,
* 当字符流写入数据后，数据可能只在缓冲区，没有立即发送给浏览器.
* 可以调用``response.flushBuffer();``或``response.getWtiter().flush();``刷新缓冲区，发送数据给浏览器。

**重定向**

1. 响应码为302表示重定向;
2. 完成重定向的第二步是设置Location头，指定第二个请求的URL地址。

方法一:

``response.setStatus(302);``
``response.setHeader("Location","https://www.github.com");``

方法二:

``response.sendRedirect("https://www.github.com");``

如果要重定向的URL是在同一个服务器内，那么可以使用相对路径
``response.sendRedirect("/hello/FirstServlet");``

**重定向相关细节**

* 重定向是两次请求
* 重定向不局限与当前应用，也可以是其他应用，例如重定向到github.
* 重定向的响应头为302，并且必须要有Location响应头；
* 重定向就不要再使用response.getWriter()或response.getOutputStream()输出数据，不然可能会出现异常；(重定向与response对象同时使用)


**Request**

1. Request对象功能

   * 封装(获取)请求头
   * 封装(获取)请求参数
   * Servlet三大域对象之一,可以把它当成Map来添加获取数据
   * **请求包含和请求转发**

2.Request域方法

* ``void setAttribute(String name, Object value);//添加或修改request域属性``
* ``Object getAttribute(String name);//得到request域属性``
* ``void removeAttribute(String name);//移除request域属性``
* ``Enumeration getAttributesNames();//获取request域所有属性名

3.Request获取请求头数据

*  ``String getHeader(String name);//获取指定名称request的请求头``
*  ``int getIntHeader(String name);//获取指定名称request的请求头，并将它转化成int型``
*  ``Enumeration getHeaderNames();//获取所有请求头的名称`` 

4.Request获取请求数据其他方法

重点:

* ``String getMethod();//获取请求方法``
* ``String getContextPath();//获取上下文路径``
* ``void setCharacterEncoding(String);//设置请求编码``
* ``String getRemoteAddr();//获取客户端IP地址``


相关方法:

* ``int getContentLength();//获取请求体字节数``
* ``Locale getLocale();//获取locale,如中国zh_CN.``
* ``String getCharacterEncoding()：获取请求体编码，在没有调用setCharacterEncoding()之前该方法返回null``
* ``String getQueryString()：获取请求参数列表，例如：username=aaa&password=123``
* ``String getRequestURI()：返回请求URI路径，从应用名称开始，到参数之前这一段，例如：/hello/FirstServlet``
* ``StringBuffer getRequestURL()：整个请求URL，不包含参数部分``
*  ``String getServletPath()：返回Servlet路径，从应用名称后开始，到参数之前这一段，不包含应用名称。``
* `` String getServerName()：返回主机名，例如：localhost``
*  ``int getServerPort()：返回服务器端口号，例如：8080``

5.**获取请求参数**

获取请求链接上的参数

* ``String getParameter(String name);//获取指定参数的值，若存在多个，只取第一个``
* ``String[] getParameterValues(String name);//返回指定参数的多个值``
* ``Enumeration getParameterNames();//获取所有请求参数的名称``
* ``Map getParameterMap;//获取所有请求参数，将数据封装到Map集合中``

6.**请求包含和请求转发**

* 请求包含和请求转发都是一个request请求，访问两个Servlet
* 请求包含和请求转发都是有一个Servlet去调用执行另一个Servlet
* 请求包含和请求转发都可以共享request中的数据，因为都是同一个request请求。

* **从AServlet请求转发到BServlet**
  + 在AServlet中可以设置响应头
  + 在AServlet中不能使用响应流输出

* 如果在AServlet中执行了响应操作，那么有两种可能：
  + 如果在AServlet中响应的数据导致response提交，那么在转发时抛出异常；
  + 如果在AServlet中响应的数据没有导致response提交，那么response中的数据会被清空。

* **从AServlet请求包含到BServlet**
  + 在AServlet中可以设置响应头
  + 在AServlet中能使用响应流输出

* 请求转发和请求包含都要使用RequestDispatcher对象：RequestDispatcher rd = request.getRequestDispatcher("/BServlet");
* 请求转发执行RequestDispatcher的forward()方法：rd.forward(request,response);
* 请求转发执行RequestDispatcher的include()方法：rd.include(request,response);
* **请求转发和请求包含的路径都是服务器端路径，相对当前应用**

7.请求转发与重定向

 * 请求转发是一个请求，而重定向是两个请求
 * 请求转发，是使用RequestDispatcher来完成，重定向使用response对象来完成
 * **请求转发的路径都是服务器端路径，而重定向是客户端路径，需要给出应用名称**
 * 请求转发在浏览器地址栏中的地址是第一个Servlet的路径，而重定向在地址栏中的地址是第二个请求的Servlet的路径
 * 请求转发中的两个Servlet是可以共享request数据的，而重定向因为是两个请求，所以不能共享request数据
 * 请求转发只能转发到本应用的其他Servlet，而重定向可以重定向到其他应用中。

8.request.getParameter()和request.getAttribute()

* getParameter()是获取客户端参数，它是从客户端传递给服务器的数据。
* getAttribute()是获取服务器端自己设置的数据，而不是客户端的数据。
* request没有setParameter()方法，不能自己设置参数，参数都由客户端传递
* request有setAttribute()方法，在getAttribute()之前，需要先setAttribute()才能获取到。
* getAttribute()和setAttribute()是用来在请求转发和请求包含中的多个Servlet中共享数据。

**路径**

1. 客户端路径和服务器端路径
  * 客户端路径需要给出应用名称，例如：/hello/AServlet
  * 服务器端路径无需给出应用名称，例如：/AServlet

2. 客户端路径

 	1).页面中都是客户端路径：

   + 超链接的href
   + 表单的action
   + <img>的src

	2).重定向也是客户端路径：

		* response.sendRedirect("/hello/BServlet");
3. 服务器路径
 
	* <url-pattern>
	* 请求转发和请求包含
	* ServletContext获取资源等

**乱码**

请求编码:

* 客户端发送的数据编码：由浏览器来决定：
  + 如果是在地址栏中直接给出url，那么一般都是默认为GBK，但这个可能不太大。
  + 如果是通过页面上的表单或超链接发出请求，那么由当前页面的编码来决定发送的参数的编码。

* 无论浏览器发送过来的是什么编码的数据，Tomcat都默认使用ISO-8859-1来解码
  + **POST**：可以使用request.setCharacterEncoding()方法来设置请求体数据的编码，因为POST请求参数在请求体中，所以是可以设置编码的。在使用request.getParameter()方法获取参数之前，先使用request.setCharacterEncoding()方法来设置编码即可。
  + **GET**：没有方法可以设置它，因为参数在url中。所以使用request.getParameter()获取到的数据一定是错误的使用了iso-8859-1解码的。可以再使用iso-8859-1把字符串转回到byte[]，再重新使用正确的编码来解码即可。
  ``String s = request.getParameter("s");//使用iso-8859-1错误的解码了``
  ``byte[] bytes = s.getBytes("ISO-8859-1");//退回错误的解码，让字符串通过iso-8859-1返回到字节数据，即还原字节数据``
  ``s = new String(bytes, "UTF-8");//重新使用正确的utf-8来解码。``


**防盗链**
读取referer请求头，不合要求则重定向。
 
