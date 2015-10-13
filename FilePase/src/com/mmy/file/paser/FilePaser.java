package com.mmy.file.paser;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.tool.FileTool;


/**
 * 文件解析器 类似于hadoop的mapper
 * 	将数据解析后放置到map容器中，将相同手机号的数据放置在一起
 * @author tarena-mmy
 *
 */
public class FilePaser {
	//创建行解析器对象
	LinePaser linePaser = new LinePaser();	
	/**
	 * 解析一个指定的存储于硬盘上的文件
	 * @param file 指定的文件
	 * @return 一个内存中的map类型的数据容器（容器中包含了硬盘上的文件中的内容）
	 */
	public Map<String, List<String>> pase(File file){
		//通过FileTool工具类获取文件中的内容（字符串形式）
		String fileContent = FileTool.getFileContent(file);
		//将文件中的内容按照行分隔符进行分割，并将结果放入一个字符串数组中
		String[] strs = fileContent.split(System.lineSeparator());
		//构造一个map类型的数据容器，用于盛放解析好的数据，便于文件处理器进行数据处理
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//利用行解析器循环处理字符串数组中的内容，放置到map容器中
		for (int i = 0; i < strs.length; i++) {
			linePaser.linePase(strs[i], map);
		}
		return map;
	}
	
	public static void main(String[] args) {
		File file = new AutoFileLoader(new Configurer()).getFile();
		FilePaser filePaser = new FilePaser();
		filePaser.pase(file);
	}
}
