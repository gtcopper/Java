package cn.copper.io;

import java.io.File;
import java.io.FileFilter;

public class FileFilterBySuffix implements FileFilter {

	private String suffix;
	public FileFilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(suffix );
	}

}
