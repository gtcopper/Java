package cn.copper.io;

import java.io.File;
import java.io.FileFilter;
/**
 * 过滤文件夹,过滤的是文件对象
 * @author Administrator
 *
 */
public class FileFilterByDir implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.isDirectory();
	}

}
