package cn.copper.io;

import java.io.File;

public class FileTest2 {

	/**
	 * 删除带有内容的目录
	 * @param args
	 */
	public static void main(String[] args) {
		
		File dir  = new File("e:\\test");
		
		//System.out.println(dir.delete());//目录中包含内容不能直接删除
		
		removeDir(dir);
		
		
	}
	/**
	 * 递归实现目录的删除
	 * @param dir
	 */
	public static void removeDir(File dir)
	{
		if(dir.exists() && dir.isDirectory())
		{
			File[] files = dir.listFiles();//如果目錄是系統級的，java沒有權限處理，會返回Null，需要做健壯性檢測，否則會出現空指針異常
			
			if(files != null){
			if(files.length == 0)
			{
				dir.delete();
				return;
			}
			
			for(File f : files)
			{
				
				if(f.isDirectory())
				{
					removeDir(f);
					//System.out.println(f.delete());
				}else
				{
					System.out.println(f.delete());
				}
				
				}
			}
			System.out.println(dir.delete());
		}
	}
	
}
