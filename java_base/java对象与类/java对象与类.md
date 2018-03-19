#java对象与类细节

* 类之间的关系
* 对象与对象变量
* 构造器相关
* 封装
* final实例域
* 工厂方法
* 方法参数
* 对象构造

1.类之间的关系

* 依赖 ("uses-a")
* 聚合 ("has-a")
* 继承 ("is-a")

2.对象与对象变量

* ``Date deadline；``//对象变量不是对象,需要通过new操作符转化成对象.
* 一个对象变量并没有实际包含一个对象，而仅仅引用一个对象.
* 局部变量不会自动初始化为null;
* 所有java对象都存储在堆中,当一个对象包含另一个对象变量时，这个变量依然包含着指向另一个堆对象的指针.

3.构造器相关

* 不能对一个已经存在的对象调用构造器来达到重新设置实例域的目的
  +  ``Employee  james =  new Employee("aaa",100000);``
  +  ``james.Employee("aaa",200000);//error
* 不要在构造器中定义与实例域重名的局部变量
>
	public Employee(String n,double s) 
	{
		String name = n;//error
		double salary = s;//error
	}//构建了局部变量name,salary;只能在构造器内部访问，屏蔽了同名的实例域

4.封装

* 不要编写返回引用可变对象的访问器方法,破坏封装性
>
 	class Employee
	{
  	private Date hireDay;
  	...
 	 public Date gtHireDay()
 		{
			return hireDay;//Bad
 		}
	}


Date类有一个**更改器方法**setTime,可以设置毫秒值.

* 如果需要返回一个可变对象的引用，应该首先对它进行clone(副本).

>
 	class Employee
	{
  	private Date hireDay;
  	...
 	 public Date gtHireDay()
 		{
			return (Date)hireDay.clone();
 		}
	}

5.final实例域

* 对于可变的类，fianl关键字只表示，当前对象变量不在指示其他对象，但是对象可以更改
 + ``private final StringBuilder evaluations;``//当前对象变量不在指示其他StringBuilder对象

6.工厂方法

* NumberFormat类,生成不同风格的格式化对象
>
		NumberFormat currentFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		double x = 0.1;
		System.out.println(currentFormatter.format(x));//$0.10
		System.out.println(percentFormatter.format(x));//10%


* 使用NumberFormat类不利用构造器完成的原因
  + 无法命名构造器。构造器名与累名一致，但是有两个不同的实例。
  + 使用构造器时，无法改变所构造的对象类型。而Factory方法将返回一个DecimalFormat类对象，这是NumberFormat的子类.

7.方法参数

* java中一个方法可以修改**传递引用**所对应的变量值，而不能修改**传递值**调用所对应的变量值。
>
	publicstatic void tripleValue(double x)//doesn't work
	{
		x = 3*x;
	}
>
* java程序总是采用按值调用。方法得到的是参数的一个拷贝，方法不能修改传递给它的任何参数变量的内容。

User对象类
>
	public class User {  
    private String name;  
    private int age;  
    public User(String name, int age) {  
        this.name=name;  
        this.age=age;  
    	}  
    public String getName() {  
        return name;  
    	}  
    public void setName(String name) {  
        this.name = name;  
    	}  
    public int getAge() {  
        return age;  
    	}  
    public void setAge(int age) {  
        this.age = age;  
    	}  
	}  
>


执行类:
>  
	/** 
 	* java中的按值调用  
 	*/  
	public class CallByValue {  
    private static User user=null;  
    private static User stu=null;    
    /** 
     * 交换两个对象 
     * @param x 
     * @param y 
     */  
    public static void swap(User x,User y){  
        User temp =x;  
        x=y;  
        y=temp;  
    }    
    public static void main(String[] args) {  
        user = new User("user",26);  
        stu = new User("stu",18);  
        System.out.println("调用前user的值："+user.toString());  
        System.out.println("调用前stu的值："+stu.toString());  
        swap(user,stu);  
        System.out.println("调用后user的值："+user.toString());  
        System.out.println("调用后stu的值："+stu.toString());  
    	}  
	}  


结果为:

>
	调用前user的值：User [name=user, age=26]
	调用前stu的值：User [name=stu, age=18]
	调用后user的值：User [name=user, age=26]
	调用后stu的值：User [name=stu, age=18]


我们发现user和stu的值并没有发生变化，也就是方法并没有改变存储在变量user和stu中的对象引用。swap方法的参数x和y被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝的值而已.


* java中方法参数的使用情况：
 + 一个方法不能修改一个基本数据类型的参数(即数值或布尔值)
 + 一个方法可以改变一个对象参数的状态
 + 一个方法不能让对象参数引用一个新的对象

8.对象构造

* 方法的签名: 要完整地描述一个方法，需要指出方法名以及参数类型
  + **返回类型不是方法签名的一部分**。不能有名字相同，参数类型相同，返回类型却不同的方法
* 调用另一个构造器
 +  this(...)
 >
 	publc Employee(double s)
 	{
  		//call Enployee(String ,double)
  		this("Employee #"+nextId,s);//调用另一个构造器
  		nerxtId++; 
 	}

* 初始化快

>
	public class User {
	private static int nextId;

    private  int id;  
    private String name;  
    private int age;  
	//初始化块
    {
       id = nextId;
       nextId++;
    }
    public User(String name, int age) {  
        this.name=name;  
        this.age=age;  
    	}  
    public String getName() {  
        return name;  
    	}  
    public void setName(String name) {  
        this.name = name;  
    	}  
    public int getAge() {  
        return age;  
    	}  
    public void setAge(int age) {  
        this.age = age;  
    	}  
	}  


* 程序首先运行初始化块，然后才运行构造器的主体部分
* 即使在类后面定义，仍可以在初始化快中设置域
* 对于只需要初始化一次的代码块，可以使用静态代码块 static{}.


参考 ： 《java核心技术卷I》