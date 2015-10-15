package com.mmy.file.loader;

import java.io.File;

/**
 * Linux操作系统文件加载器
 *   文件地址中的斜杠为正常的斜杠，不需要替换
 * @author tarena-mmy
 *
 */
public class LinuxFileLoader implements FileLoader{
	
	/**
	 * 要加载的文件的地址
	 */
	private String filePath;
	
	public LinuxFileLoader(String filePath){
		this.filePath = filePath;
	}

	@Override
	public File loadFile() {
		return new File(filePath);
	}

}
