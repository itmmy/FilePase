package com.mmy.file.loader;

import java.io.File;

/**
 * 文件加载器接口
 * 	有Windows和Linux操作系统的具体实现 
 *  用户使用时使用自动化加载器，其根据配置文件中描述的操作系统，自动选择合适的加载器进行文件加载
 * @author tarena-mmy
 *
 */
public interface FileLoader {
	
	/**
	 * 获取一个文件对象
	 * @return
	 */
	public File loadFile();

}
