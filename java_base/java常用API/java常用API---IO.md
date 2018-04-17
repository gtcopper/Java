# java常用API----IO



* java的I/O技术依赖于JVM调用windows执行.



### File
* File.Separator ---获取系统的文件分隔符 -- /   \\.
* boolean b1 = file.createNewFile();//文件存在返回false，存在IOException
* boolean b2 = file.delete();//**不进入回收站**,文件存在返回false ：文件不存在或文件正在被使用
* 删除目录时，boolean b6 = dir.delete();//删除目录时，如果目录中有内容，无法直接删除,在该目录为空时，才可以删除.
* File的listFiles方法，返回文件数组对象。它有两个重载的方法
  + listFiles(FileNameFilter filter)//通过文件名过滤,FileNameFilter 文件名过滤器接口
  + listFiles(FileFilter filter)//通过文件过滤，过滤的是文件对象,也是一个过滤器接口.
  + 两个过滤器接口都只需实现一个方法bolean  accept()//过滤条件
  + FileNameFilter中的accept方法接收accept(File dir,String name)//文件夹和文件名
  + FileFilter中的accept方法接收accept(File pathName)//文件路径

### OutputStream
* 所有输出**字节流**的超类
* 
`` File file = new File(dir,"file.txt");``
`` FileOutputStream out = new FileOutputStream(file,true);//第二个参数，是否续写``

* BufferedOutputStream 输出字节流缓冲区 ,构造函数接收一个输出字节流,内部通过数组实现缓冲.

###InputStream
* 所有输入字节流的超类

		FileInputStream in = new FileInputStream("tempFile\\file.txt");
		int ch =  0;
		while((ch = in.read())!=-1)
		{
			System.out.println("ch = " +(char) ch);//单个字节读取
		}
>


		FileInputStream in = new FileInputStream(file);
		byte[] buffer =new byte[1024];//定义为1024的整数倍
		int len = 0;
		while((len = in.read(buffer))!= -1)
		{
			System.out.println(new String(buffer,0,len));//多个字节读取，将结果先放到缓冲区
		}
		in.available();//获取文件的估计大小，一般只用来获取大小，不作为衡量缓冲区大小的量(防止大小过大，int溢出)

* BufferedInputStream 输入字节流缓冲区 ,构造函数接收一个输入字节流,内部通过数组实现缓冲.


### Reader
* Reader : 读取字符流的抽象超类
* FileReader : 处理(读取)文件的字符流数据,构造方法使用默认的编码表和缓冲区.
* 需要自己指定值 : 可以在FileInputStream中构造InputStreamWriter(字符流通向字节流的桥梁,按照指定的charset编码表转换字节)
* BufferedReader 输入字符流缓冲区，构造函数接收一个字符流,内部通过数组实现缓冲.
  + 包含 int read()  
  + int read(char[] cbuf, int off, int len)  //将字符读入一个数组的一部分，缓冲区的实现方式。
  + String readLine()


### Writer
* Writer : 写入字符流的抽象超类
* FileWriter :  处理(写入)文件的字符流数据,构造方法使用默认的编码表和缓冲区.
* 需要自己指定值 : 可以在FileoutputStream中构造OutputStreamWriter(字符流通向字节流的桥梁,按照指定的charset编码表转换字节)

>
	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("tempFile\\test2.txt"), "utf-8");
		osw.write("dsadsa我来了");
		osw.flush();
		osw.close();


* BufferedWriter 输出字符流缓冲区 ，构造函数接收一个输出字符流,内部通过数组实现缓冲.