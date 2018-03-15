#javaweb入门笔记(1)-Tomcat
---
**javaweb入门笔记(1)-Tomcat**
 
* Tomcat的下载和安装
* Tomcat目录层次结构 
* Tomcat的启动
* Tomcat的官方配置
* web应用
* Tomcat的体系结构
* 参考链接

##Tomcat的下载和安装
* [Tomcat官网](http://tomcat.apache.org/)
* 安装:下载加压即可.
##Tomcat目录层次结构
* bin : 存放启动和关闭Tomcat的脚本文件
* conf : 存放Tomcat服务器的各种配置文件
* lib : 存放Tomcat服务器支撑的jar包
* logs : 存放Tomcat的日志文件
* temp : Tomcat运行时生成的临时文件
* **webapps : web应用虽在目录，即供外界访问的web资源的存放目录**
* work : Tomcat工作目录
##Tomcat的启动
``%CATALINA_HOME%/RUNNING.txt``有详细步骤，简单来说，已经配置好JDK环境的话，windows下直接双击Tomcat目录下的bin/startup.bat就行了.默认端口是:8080端口.
若此端口被占用，想改端口：可以在tomcat的conf/server.xml(服务器配置文件)的Connector标签.

常见启动问题:

	* JAVA_HOME环境变量
	* JAVA_HOME环境变量
	* Catalina_home环境变量的设置问题

##Tomcat的官方配置


多种配置方式
 
* webapps/manager/META-INF/context.xml
* $CATALINA_BASE/conf/[enginename]/[hostname]/   **该文件将始终优先于Web应用程序的META-INF目录中打包的任何context.xml文件。**
* conf/server.xml **不建议将<Context>元素直接放在server.xml文件中,在conf/server.xml不重新启动Tomcat的情况下无法重新加载主 文件。**

具体参考[Context配置](http://tomcat.apache.org/tomcat-8.0-doc/config/context.html#Defining_a_context)
##web应用
1. web应用与web应用所在的目录一个web应用由多个静态web资源和动态web资源组成;组成web应用的这些文件会由一个目录组织起来，这个目录称为**web应用所在目录**
2. 虚拟目录的映射把主机上的资源映射到服务器对外提供的访问路径上
3. 如:tomcat的``conf/server.xml`` : ``<Host>``元素 - >``<Context>``，一个对应``<Context>``一个web应用。
``<Context path="/virtual-path" docBase="webapps-path" />``，重启网络服务器
4. WEB应用的组成结构
>
	mail---------------------------Web应用所在目录
       |----html、jsp、css、js等文件，根目录下的文件外界可以直接访问
          |----WEB-INF目录(不能通过外界直接访问)
                    |---------classes目录(java类)
                    |---------lib目录(java类运行所需的jar包)
                    |---------web.xml(web应用的配置文件) 
>
##Tomcat的体系结构
![Tomcat的结构体系](https://images2015.cnblogs.com/blog/740688/201509/740688-20150912000438200-1168172436.jpg)

>
   
	<Server>代表整个Servlet容器组件，是最顶层元素，可以包含一个或多个<Service>元素
        <Service>包含一个<Engine>元素以及一个或多个<Connector>元素，这些<Connector>共享一个<Engine>
            <Connector/>代表和客户程序实际交互的组件，负责接收客户请求，以及向客户返回响应
            <Engine>每个<Service>元素只能包含一个<Engine>元素，它处理在同一个<Service>中所有<Connector>接收到的客户请求
                      <Host>在一个<Engine>中可以包含多个<Host>,它代表一个虚拟主机(即一个服务器程序可以部署在多个有不同IP的服务器主机上)，它可以包含一个或多个应用
                              <Context>使用最频繁的元素，代表了运行在虚拟主机上的单个web应用
                     </Host>
           </Engine>
      </Service>
	</Server>
>

* Tomcat的HTTPS的连接器
``keytool -genkey alias tomcat -keyalg RSA``得到``.keystore``文件
* Tomcat管理平台主页 - > Tomcat Manager

相关权限和用户配置在``conf/tomcat-users.xml``
##相关知识
1. 域名和主机名的区别
| 域名| sina.com | | -------：| ：----：| ：----：| | 主机名| www.sina.com |
2. url中主机名的作用：
 * 用于访问DNS服务器获取IP
 * 用于告诉代理服务器要访问哪个主机名


##参考链接
[Tomcat的安装、配置、优化及负载均衡详解](http://www.cnblogs.com/rocomp/p/4802396.html)