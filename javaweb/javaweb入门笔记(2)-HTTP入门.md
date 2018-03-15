#javaweb入门笔记(2)-HTTP入门
----
**javaweb入门笔记(2)-HTTP入门**

* **Request(请求)**
 * 请求头字段
* **Response(响应)**
 * 响应状态行
 * 响应头字段
 
---
##Request(请求)
一个完整的**HTTP请求**包括：一个请求行、若干请求头、以及实体内容.每部分内容占一行。


![HTTP请求](http://jbcdn2.b0.upaiyun.com/2016/10/c0cdafd8bdb8d0c87b3c35498aa0417f.png)

**请求行**：请求行是请求消息的第一行，由三部分组成：分别是请求方法（GET/POST/DELETE/PUT/HEAD）、请求资源的URI路径、HTTP的版本号
``GET /index.html HTTP/1.1``


**请求头**：请求头中的信息有和缓存相关的头（Cache-Control，If-Modified-Since）、客户端身份信息（User-Agent）等等


	Cache-Control:max-age=0
	Cookie:gsScrollPos=; _ga=GA1.2.329038035.1465891024; _gat=1
	If-Modified-Since:Sun, 01 March 2018 11:19:03 GMT
	User-Agent:Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36

###请求头字段

 * Accept:用于告诉服务器，客户机支持的**数据类型**
 * Accept-Charset:用于告诉服务器，客户机采用的**编码**
 * Accept-Encoding:用于告诉服务器，客户机支持**数据压缩**格式
 * Accept-Language:客户机的**语言环境**
 * Host:客户机通过这个头告诉服务器，想访问的**主机名**
 * If-Modified-Since:客户机通过这个头告诉服务器，资源的**缓存时间**
 * Refer:客户机通过这个头告诉服务器，它是从**哪个资源访问服务器**的(防盗链)
 * User-Agent:客户机通过这个头告诉服务器，**客户机的软件环境**
 * Cookie:客户机通过这个头**向服务器带数据**
 * Connection:这个请求完了，**是保持连接还是关闭**
 * Range:断点下载
  	+ bytes=n1-n2,传输范围n1到n2字节
  	+ bytes=n-，传输web资源中第n个字节以后的所有内容
  	+ bytes=n,传输最后n个字节

**消息体**：请求体是客户端发给服务端的请求数据，这部分数据并不是每个请求必须的。
##Response(响应)
一个HTTP响应代表服务器向客户端回送的数据，包括：一个状态行、若干消息头、以及实体内容
响应状态行.每部分内容占一行。
![HTTP响应](http://jbcdn2.b0.upaiyun.com/2016/10/fb7d113c2dd70ef44cd93efffb172b51.png)
**状态行**：状态行位于相应消息的第一行，有HTTP协议版本号，状态码和状态说明三部分构成。
``HTTP/1.1 200 OK``
![响应状态码](https://camo.githubusercontent.com/11b8dccb06e9b7b2fcbd479107cf068eb9ce711b/687474703a2f2f3778706836642e636f6d312e7a302e676c622e636c6f7564646e2e636f6d2f6a6176617765625f48747470526573706f6e73655374617475732e706e67)
详细可参考
[HTTP 状态消息](http://www.w3school.com.cn/tags/html_ref_httpmessages.asp)

**响应头**：响应头是服务器传递给客户端用于说明服务器的一些信息，以及将来继续访问该资源时的策略。

	Connection:keep-alive
	Content-Encoding:gzip
	Content-Type:text/html; charset=utf-8
	Date:Fri, 24 March 2018 06:23:31 GMT
	Server:nginx/1.9.12
	Transfer-Encoding:chunked

###响应头字段
 * Location:这个头配合302状态码使用，用于告诉客户机找谁**(location和302实现请求重定向)**
 * Server:服务器通过这个头，告诉浏览器**服务器的类型**
 * Content-Encoding:服务器通过这个头，**数据的压缩格式 (相关java知识:GZIPOutputStream,包装流/底层流)**
 * Content-Length:服务器通过这个头，告诉浏览器**回送数据的长度**
 * Content-Type:服务器通过这个头，告诉浏览器**回送数据的类型**
 * Last-Modified:服务器通过这个头，告诉浏览器**当前资源的缓存时间**
 * Refresh:服务器通过这个头，告诉浏览器隔**多长时间刷新一次**
 * Content-Disposition:服务器通过这个头，告诉浏览器以**下载方式**打开
 * Transfer-Encoding:服务器通过这个头，告诉浏览器数据的**传送格式**
 * Etag:**缓存相关的头部，用于实时性要求高的系统**
 * Expires:服务器通过这个头，告诉浏览器把回送的**资源缓存多长时间，-1或0则不缓存**
 * Cache-Control和Pragma:no-cache,服务器通过这两个头，也是控制浏览器**不要缓存数据**
 * Connection:断开连接/保持连接
 * Date:当前时间
 * Accept-Ranges:用来说明web服务器是否支持range。支持返回bytes;不支持返回none
 * Content-Range:制定了返回web资源的字节范围，格式：n1-n2/n_total

**参考链接**[一次完整的 HTTP 请求过程](http://blog.jobbole.com/106632/)

[#HTTP协议学习# （一）request 和response 解析](https://www.cnblogs.com/bukudekong/archive/2014/07/09/3834020.html)