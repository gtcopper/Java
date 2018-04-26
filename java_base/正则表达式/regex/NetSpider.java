package cn.copper.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetSpider {

	public static void main(String[] args) throws IOException {
		
		/**
		 * 网络爬虫
		 * 获取网络中的邮件地址
		 */
		
		File file = new File("");
		
		String regex = "\\w+@\\w+(\\.\\w+)+";
		
		URL url = new URL("http://dq.tieba.com/p/5044199525"); 
		
		List<String> list = getMails(url,regex);
		
		for(String mail : list)
		{
			System.out.println(mail);
		}
		
	}

	public static List<String> getMails(URL url,String regex) throws IOException {
		
		List<String> list = new ArrayList<String>() ;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m ;
		
		String line = null;
		
		while((line = bf.readLine()) != null){
			
			m = p.matcher(line);
			
			while(m.find())
			{
				//System.out.println(m.group());
				
				list.add(m.group());
			}
			
		}
		bf.close();
		return list;
	}
	
}
