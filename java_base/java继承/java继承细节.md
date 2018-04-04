# java继承细节


### 在 equals() 中使用 getClass 进行类型判断
* 我们在覆写 equals() 方法时，**一般都是推荐使用 getClass 来进行类型判断，不是使用 instanceof**。我们都清楚 instanceof 的作用是判断其左边对象是否为其右边类的实例，返回 boolean 类型的数据。**可以用来判断继承中的子类的实例是否为父类的实现**。

父类: Person

 	public class Person {
        protected String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(String name){
            this.name = name;
        }

        public boolean equals(Object object){
            if(object instanceof Person){
                Person p = (Person) object;
                if(p.getName() == null || name == null){
                    return false;
                }
                else{
                    return name.equalsIgnoreCase(p.getName ());
                }
            }
            return false;
       }
    }


子类 : Employee

	public class Employee extends Person{
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Employee(String name,int id){
            super(name);
            this.id = id;
        }

        /**
         * 重写equals()方法
         */
        public boolean equals(Object object){
            if(object instanceof Employee){
                Employee e = (Employee) object;
                return super.equals(object) && e.getId() == id;//多了id比较
            }
            return false;
        }
    }

测试类
>
 	 public class Test {
        public static void main(String[] args) {
            Employee e1 = new Employee("chenssy", 23);
            Employee e2 = new Employee("chenssy", 24);
            Person p1 = new Person("chenssy");
            System.out.println(p1.equals(e1));
            System.out.println(p1.equals(e2));
            System.out.println(e1.equals(e2));
        }
    }

上面定义了两个员工和一个普通人，虽然他们同名，但是他们肯定不是同一人，所以按理来说输出结果应该全部都是 false，但是事与愿违，结果是：**true、true、false**。

*  p1.equals(e1)，是**调用 p1 的 equals 方法**，该方法使用 instanceof 关键字来检查 e1 是否为 Person 类，这里我们再看看 instanceof：判断其左边对象是否为其右边类的实例，**也可以用来判断继承中的子类的实例是否为父类的实现。他们两者存在继承关系**，肯定会返回 true 了，而两者 name 又相同，所以结果肯定是 true。

* 出现上面的情况就是使用了关键字 **instanceof**，这是非常容易“专空子”的。故在覆写 equals 时推荐使用** getClass** 进行类型判断。而不是使用 instanceof。
* 即  父类 :Person的equals方法判断条件应该改为 if (object.getClass() == this.getClass()) {...}。