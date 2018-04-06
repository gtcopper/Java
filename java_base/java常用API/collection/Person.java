package cn.copper.collection;

public class Person implements Comparable {

	private String name;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	
//	/**
//	 * 建立人对象的hash值算法
//	 * 通过姓名，年龄计算哈希值
//	 */
//	@Override
//	public int hashCode() {
//		
//		return this.name.hashCode()+this.age*31;//避免出现哈希值重复
//	}
//


//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("....");
//		if(this == obj)
//			return true;
//		if(!(obj instanceof Person))
//		{
//			throw new ClassCastException();
//		}
//		
//		Person p = (Person) obj;
//		
//		return this.name.equals(p.name) && this.age == p.age;
//	}



	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Person))
		throw new ClassCastException();
		
		Person p =(Person)o;
		/**
		 * 主要条件相同，则比较次要条件
		 */
		int temp = this.age - p.age;
		
		return temp ==0 ?this.name.compareTo(p.name):this.age -p.age;
	}
	
	
	
}
