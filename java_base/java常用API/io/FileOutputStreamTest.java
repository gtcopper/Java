package cn.copper.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
/**
 * 按学生总成绩排序写入文件信息
 * @author Administrator
 *
 */
public class FileOutputStreamTest {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");//系统换行符

	public static void main(String[] args) throws IOException {
		
		Set<Student> s = new TreeSet<Student>(Collections.reverseOrder());//反转
		
		s.add(new Student("aaa",80,99,88));
		s.add(new Student("bbd",70,90,88));
		s.add(new Student("asw",90,97,88));
		s.add(new Student("wqe",85,95,88));
		
		
		File dir = new File("tempFile");
		if(!dir.exists())
		{
			dir.mkdir();
		}
		
		File destFile = new File(dir,"student_info.txt");
		
		writeToFile(s,destFile);
		
//		FileOutputStream in = null;
//		
//		try {
//			in = new FileOutputStream("e:\\test.txt");
//			
//			for (Iterator it = s.iterator(); it.hasNext();) {
//				Student student = (Student) it.next();
//				String temp = student.toString()+LINE_SEPARATOR;
//				in.write(temp.getBytes());
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally
//		{
//			try {
//				if(in != null)
//				{
//					in.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	public static void writeToFile(Set<Student> s, File destFile) {
		
		
		FileOutputStream out = null;	
			try {
				out = new FileOutputStream(destFile);
				for(Student stu :s)
				{
					String info = stu.getName()+"\t" +stu.getSum()+LINE_SEPARATOR;
					out.write(info.getBytes());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				if(out != null)
				{
					try {
						out.close();
					} catch (IOException e) {
						throw new RuntimeException("系统资源关闭失败....");
					}
				}
			}
		
	}
	
}
