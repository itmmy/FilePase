package com.mmy.file.loader;

import java.io.File;

/**
 * Winodws操作系统的文件加载器
 *   文件路径中的单斜杠需要转换成双斜杠
 * @author tarena-mmy
 *
 */
public class WindowsFileLoader implements FileLoader{

	/**
	 * 要加载的文件的地址
	 */
	private String filePath;
	
	public WindowsFileLoader(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * 将windows操作系统中的目录上的单"\"转换成能被java识别的双"\\"
	 */
	public File loadFile() {
		return new File(filePath.replace("\\", "\\\\"));
	}

}
