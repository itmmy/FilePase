package com.mmy.app;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.compute.FileCompute;
import com.mmy.file.compute.FlowPrinter;
import com.mmy.file.compute.FlowSorter;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.paser.FilePaser;

/**
 * 应用程序的总入口
 * @author tarena-mmy
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("应用程序开始启动");
		long start = System.currentTimeMillis();
		//构造配置器，读取配置文件内容
		Configurer configurer = new Configurer();
		
//		//使用文件工具类利用配置器上的信息自动化构造测试文件
//		FileTool.makeTestFile(configurer);
		
		//依据配置器构造自动加载器，根据配置文件中配置的操作系统自动加载数据文件
		AutoFileLoader fileLoader = new AutoFileLoader(configurer);
		File dataFile = fileLoader.getFile();
		
		//构造文件解析器,解析构造好的测试文件
		FilePaser filePaser = new FilePaser();
		Map<String, List<String>> map = filePaser.pase(dataFile);
		
		//构造文件内内容处理器,处理解析的结果
		FileCompute fileCompute = new FileCompute();
		Map<String, Long> tempMap = fileCompute.computeAllFlow(map);
		
		//创建总流量排序器，将处理好的结果进行排序
		FlowSorter flowSorter = new FlowSorter();
//		Map<String, Long> resultMap = flowSorter.sortFlow(tempMap);
		List<String> list = flowSorter.sortFlowList(tempMap);
		
		//创建总流量输出器，将排序好的结果进行输出
		FlowPrinter flowPrinter = new FlowPrinter();
//		flowPrinter.printFlow(resultMap);
		flowPrinter.printFlowList(list);
		long stop = System.currentTimeMillis();
		System.out.println("总耗时："+(stop-start)+"毫秒");
	}

}
