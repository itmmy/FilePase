package com.mmy.conf;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.mmy.file.tool.FileTool;
import com.mmy.var.AllParameter;

/**
 * 应用程序的配置器 作用是从配置文件上读取信息，将读取到的信息放到内存中以供其他对象使用
 * 
 * @author tarena-mmy
 * 
 */
public class Configurer {

	// 存放配置数据的容器
	public Map<String, String> configContext = new HashMap<>();

	// 配置器的构造方法
	public Configurer() {
		// 创建一个 文件对象 基于配置文件的地址
		File confFile = new File(AllParameter.CONFFILEPATH);
		// 配置文件存在的情况下进行配置文件中内容的读取
		if (confFile.exists()) {
			//获取文件中的内容
			String allConf = FileTool.getFileContent(confFile);
			// 将配置文件中的内容按照换行符分割成多行
			String[] confs = allConf.split(System.lineSeparator());
			// 对每行数据都按照“=”进行切分，将切分后的配置项的名字和值放入map中
			for (int i = 0; i < confs.length; i++) {
				//当一行字符串以#开头时为注释，不以#开头的才是真正的配置信息
				if (confs[i].indexOf("#")!=0) {					
					String[] temp = confs[i].split("=");
					//将配置项的名字和配置项的值去除两边的空格后再放置到map中
					configContext.put(temp[0].trim(),temp[1].trim());
				}
			}
		} else {
			System.out.println("配置文件不存在");
		}
	}
	
	

	public Map<String, String> getConfigContext() {
		return configContext;
	}



	public static void main(String[] args) {
//		Configurer conf = new Configurer();
//		System.out.println(conf.map.get("FileLoaderPath"));
//		System.out.println(conf.map.get("OS"));
		
		//测试语法
		System.out.println("#dddddd".indexOf("#"));
	}
}
