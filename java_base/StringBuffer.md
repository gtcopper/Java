#StringBuffer/StringBuilder
---
1. 
 * StringBuffer是线程安全的可变字符串
 * StringBuilder是线程不安全的可变字符串； 和StringBuffer的功能一样。就是效率高一些，但是不安全。
2. 构造方法:
	* A:StringBuffer sb = new StringBuffer();//构造一个没有字符的字符串缓冲区，并构造了16个字符的初始容量。 
		
	B:StringBuffer sb = new StringBuffer(int capacity);//构造一个没有字符的字符串缓冲区，并构造指定的初始容量。

	C:StringBuffer sb = new StringBuffer(String str);//构造一个初始化为指定字符串内容的字符串缓冲区。
3. 成员方法
  * 追加功能 :
   public StringBuffer append(String str);//追加字符串
   public StringBuffer insert(int offset,String str);//在指定位置插入字符串
  * 删除功能 : 
   public StringBuffer deleteCharAt(int index);//删除指定位置字符
   public StringBuffer delete(int start,int end);//删除从指定开始到结束的字符，**左包右不包**.
  * 替换功能 : 
   public StringBuffer replace(int start,int end,String str);//以字符串替代从指定开始到结束的字符
  * 反转功能 : 
  public StringBuffer reverse();//使这个字符序列被序列的反转所取代
 * 截取功能 : 
  public String substring(int start):从指定索引到末尾的字符串public String substring(int start,int end):从指定索引开始到指定索引结束的字符串 .
 * 返回位置 :
 public int lastIndexOf(String str);//返回指数在这个字符串的指定子字符串最右边的发生