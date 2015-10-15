package com.mmy.file.loader;

import java.io.File;

import com.mmy.conf.Configurer;
import com.mmy.var.AllParameter;

/**
 * 自动化文件加载器
 * 	根据配置文件中配置的操作系统类型选择适合操作系统的文件加载器
 * @author tarena-mmy
 *
 */
public class AutoFileLoader {
	
	//配置文件中配置的操作系统
	private String OS;
	//配置文件中需要加载的配置文件的地址
	private String filePath;
	
	public AutoFileLoader(Configurer configurer){
		this.OS = configurer.getConfigContext().get(AllParameter.OS);
		this.filePath = configurer.getConfigContext().get(AllParameter.LOADFILEPATH);
	}
	
	/**
	 * 根据配置文件中配置的地址和操作系统获取不同类型的文件加载器进行文件加载
	 * @return
	 */
	public File getFile(){
		switch (OS) {
		case AllParameter.OS_WINDOWS:
			return new WindowsFileLoader(filePath).loadFile();
			
		case AllParameter.OS_Linux:
			return new LinuxFileLoader(filePath).loadFile();

		default:
			return null;
		}
	}

}
