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
>