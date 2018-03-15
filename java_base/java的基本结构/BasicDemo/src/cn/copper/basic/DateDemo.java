package cn.copper.basic;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

public class DateDemo {

	@Test
	public void test() {
		
		System.out.println(new Date());
		System.out.println(new Date().toString());
		
	}
	
	@Test
	public void test2(){
		
		LocalDate date = LocalDate.now();
		
		//System.out.println(date);
		
		int month =  date.getMonthValue();
		int today = date.getDayOfMonth();
		
		//System.out.println(today);
		
		
		date =date.minusDays(today-1);//今天-(today-1) = 上个月底+1
		//System.out.println(date);
		
		DayOfWeek weekday =  date.getDayOfWeek();
		
		int  value = weekday.getValue();//1 = Monday , ... 7 = Sunday
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i =1;i<value;i++)
			System.out.printf("    ");//四个空格，三个字符+一个空格
		
		while(date.getMonthValue() == month) {
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth() == today) {
				System.out.printf("*");
			}else {
				System.out.printf(" ");
			}
			date = date.plusDays(1);
			if(date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
			
		}
		if(date.getDayOfWeek().getValue() != 1) 
		{
			System.out.println();
		}
		
	}
	@Test
	public void test3() {
		LocalDate date = LocalDate.now();
		
		int month = date.getMonthValue();
		
		int today = date.getDayOfMonth();
		
		date = date.minusDays(today-1);
		
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i =1;i<value;i++)
			System.out.printf("    ");
		while(date.getMonthValue() == month) {
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth() == today) {
				System.out.printf("*");
			}else {
				System.out.printf(" ");
			}
			date = date.plusDays(1);
			if(date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
		}
		if(date.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
	}
	
}
