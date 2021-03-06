# java常用API---集合框架

* Collection接口
* List接口
* Set接口
* Map接口





### Colletion接口
* 所有集合的根类
* Collection集合中存储的是对象的引用
* 集合中不能存储基本数据类型，但JDK1.5后可以通过自动装箱存储基本数据类型包装类.

### List接口
* 有序的Collection,通过索引操作集合中的元素,集合中可以存放重复的元素.
* List可以通过迭代，通过遍历再通过get方法得到
* 支持CURD操作
* 子类 ：
  + Vector :   长度可变的数组结构,Vector是同步的,故查询效率较低,被ArrayList替代.
  + ArrayList ： 长度可变的数组结构，查询速度快,增删较慢(要移动大量元素的位置),类似于Vector,但它是不同步的
  + LinkedList : 链表结构,不同步的，增删速度快，查询速度慢
* 

* 注意:
 + 1. list集合在Iterator迭代时不允许进行线性修改(迭代结果不确定)，否则会抛出 jav.util.ConcurrentModificationException异常  
 + 解决：在迭代时，不要使用集合的方法操作元素 通过Iterator子接口ListIterator解决,可以在迭代器中CRUD操作,只有List接口中存在.


### Set接口
* **无序**的Collection,不包含重复元素,方法和Collection方法一致
* 只有一个取出元素的方法，Iterator迭代
* 子类 ：
  + HashSet : 数组中存储的是元素和hash值对应关系，查询速度比数组快,不同步
  + HashSet重复元素不能存入，保证元素**唯一性**
  + Hash(hashCode())值一致时会产生hash冲突，从而会比较元素内容是否相同(equals方法),相同这不存入,不相同则存入(继续通过hash算法存入，---拉链法，在同一位置多增一条链存储).
  + TreeSet : 结果按自然顺序排列,使用的是二叉树结构，通过比较方法(CompareTo)判断是否是重复元素
  + 需要覆盖hashCode,equals,同时实现Comparable接口,建立自然排序,还可以复写toString()方法.
  + LinkedHashSet : HashSet的子类，能保证效率和有序(即按存入顺序取出)

### Map接口

* 内部存储 键Key 值value
* 键只能对应一个值(键的唯一性)
* keySet方法获取所有的键(key的集合).
* entrySet方法返回的是键值对(映射关系),类型为Map.Entry.
* map集合没有迭代器,map集合也不能被foreach遍历.
>
	for(Map.Entry<String,String> e : map.entrySet())//通过增强Set集合实现
		{
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " = " + value);
		}

* values方法返回所有键的值，类型为Collection<?>,值不需要保证唯一性.
* Map子类 ：
 + Hashtable : 数据结构 ： 哈希表 ，存入的键值必须是非null, 线程是同步的
     + Properties : 属性集，键和值都是字符串 ,可以结合流进行数据操作.
 + HashMap : 数据结构 ： 哈希表 , 存入的键值可以为空 ,线程是不同步的.
     + LinkedHashMap :  数据结构 ： 基于链表(有序)+哈希表(存入与取出顺序一致)
 + TreeMap(红黑树) :   数据结构 ： 二叉树，线程是非同步的,可进行排序.
 