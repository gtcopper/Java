#java对象与类细节

* 类之间的关系
* 对象与对象变量
* 构造器相关
* 封装
* final实例域
* 工厂方法

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