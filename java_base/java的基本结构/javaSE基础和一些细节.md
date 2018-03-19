#JavaSE基础和一些细节

* 数据类型
* 运算符
* 字符串
* 输入与输出
* 控制流程
* 大数值
* 数组


1.数据类型

* java没有任何无符号(unsigned)形式的int,long,short或byte类型
* float类型的数值要有一个**后缀F或f**(3.14F),没有后缀的默认为double型
* 所有"非数值"的值都认为是不相同的.
  + 不能通过``if(x == Double.NaN)``判断，这个语句无论什么情况都是false。
  + 可以通过``if(Double.isNaN(x))``判断
* 浮点数值不适用于无法接受舍入误差的金融计算中
  + 浮点数职采用二进制系统表示
  + 不允许有任何舍入误差应该使用**BigDecimal**类
* 注释中注意\u
  + //\u00A0 is a new line 会产生语法错误,\u00A0会替换为一个换行符
  + //Look inside c:\users 也产生语法错误,\u后未跟着4个十六进制数
* char类型描述了UTF-16编码中的一个代码单元
 + 不建议使用char类型
* 整型值和布尔值之间不能相互转换
 + ``if(x =0)``//C++可以编译运行，结果总为false，在java中不能通过编译

2.运算符

* 整数被0除会产生一个异常，而浮点数被0除会得到无穷大或NaN结果.
* strictfp关键字标记的方法必须使用严格的浮点计算来生成结果
  + ``public static strictpt void main(String[] args)``//main方法中的所有指令都将使用严格的浮点计算
* 
* ![数值类型之间的合法转换](http://img.blog.csdn.net/20171026231349804)
* 6个实心箭头，表示无信息丢失的转换，3个虚箭头，表示可能有精度损失的转换
 +  
>
	int n = 123456789;
	float f = n;//损失精度，int包含的位数比float所能表示的范围多,float有效数位6~7位


* 如果将一个数值从一种类型强制转换为另一种类型，而有超出了目标类型的表示范围，结果会得到一个完全不同的值.
 + (byte) 300 的实际值为44.

3.字符串

* String的subString(a,b)方法,**左包右不包**，子串长度为b-a;
* String.join()用分隔符组合字符串
>
  String all = String.join(" / ","S","M","L","XL");
  //"S / M /L /XL"


* String类对象为**不可变字符串**
  +  不能直接修改字符串其他位字符，但可以通过字符串实现.
  +  编译器可以让字符串共享(常量池，同一字符串位置相同)

* 不要使用 == 运算符检测两个字符串是否相等
  + ==只能确定两个字符串是否放在同一位置
  + 应该使用s.equals("...")
  + 忽略大小写s.equalsIgnoreCase("...")

* String trim()//返回一个 删除所有空格的字符串

4.输入与输出

*  
>        
       Scanner in = new Scanner(System.in);
		//读取缓冲区一行内容
		System.out.println("Hello, what's your name?");
		String name = in.nextLine();
>

* ``int age = in.nextInt();``//读取整数
* ``String c = in.next();``////读取一个字符，以空格为分隔符
* 输入控制台的东西是显示的，要想不显示，使用Console这个类
* 注意:语句本身是没有错的。问题的关键是这段代码若是在eclipse的运行就会有问题，而如果你用命令行的方式，先编译后运行就没有问题了。


		Console cs = System.console();
		
		if(cs == null) {
			System.out.println("输入不能为空: ");
			return;
		}
		
		String name = cs.readLine("User name :");
		System.out.println(name);
		char[] password = cs.readPassword("Password : ");
		System.out.println(cs);


*文件的输入与输出

* 读取文件
 + ``Scanner in = new Scanner(Paths.get("myFile.txt"),"UTF-8");``//得到输出流
 + ``Scanner in = new Scanner("myFile.txt");``/不进行文件读取，将字符串解释为数据，而不是文件名
* 写入文件
 + ``PrintWriter out = new PrintWriter("myFile.txt","UTF-8");
 + 只需提供文件名和字符编码
 + 如果文件不存在，创建文件
* 指定相对路径("myFile.txt")
 + 文件位于java虚拟机启动的相对位置
 + 命令启动 ： 启动路径就是命令解释器的当前路径
 + IDE启动 ： 启动路径由IDE控制

5.控制流程

* switch...case
 + case标签可以是:
   * 类型为char,byte,short,或int的常量表达式
   * 枚举常量  
    >
    	enum Size {SMALL,MEDIUM,LARGE,BIG_LARGE}; 
		Size s = Size.SMALL;
		switch(s) ...
	>
   * java SE 7开始，case标签还可以是字符串字面量

6.大数值

* BigInteger类实现了任意精度的整数运算
 + 使用静态的valueOf方法可以将普通数值转化为大数值
 + 不能使用算术运算符(如: + 和 *)处理大数,需要使用add，subtract,multipy,divide,mod(余数)方法
 	>
		BigInteger a = BigInteger.valueOf(100);
		BigInteger b = BigInteger.valueOf(200);
		BigInteger c = a.add(b);
		BigInteger d = c.multiply(b.add(BigInteger.valueOf(2)));//d=c*(b+2)
	>
* BigDecimal类实现了任意精度的浮点数运算

7.数组

* 初始化匿名数组
 + new int[] {1,2,3,4}
* java中，允许数组长度为0，0与null不同。
* 数组拷贝
 + Arrays.copyOf(,)方法//第一个参数是需要被拷贝的数组,第二个参数是新数组长度,若小于原始数组长度，只拷贝前面的数据元素,若大于原始数组长度，其他数据元素被赋值为0.


参考 ： 《java核心技术卷I》