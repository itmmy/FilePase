package com.mmy.file.compute;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.paser.FilePaser;

/**
 * 文件内容处理器 
 * 	对文件解析器中解析出来的数据进行运算
 * 
 * @author tarena-mmy
 * 
 */
public class FileCompute {

	/**
	 * 
	 * 计算每个手机号的总流量，并将结果放置在一个新的map容器中
	 * @param map 盛放结果数据的容器
	 */
	public Map<String,Long> computeAllFlow(Map<String, List<String>> map) {
		//构造一个结果数据容器
		Map<String, Long> tempMap = new HashMap<String, Long>();
		//循环计算每个手机号的总流量
		for (String key : map.keySet()) {
			//根据手机号获取对应的所有上网记录的集合
			List<String> list = map.get(key);
			//创建一个临时变量，用于记录某个手机号的总上网流量
			long allFlow = 0L;
			//对集合中所有记录进行累加
			for (int i = 0; i < list.size(); i++) {
				//因为单条记录中既包含上行流量又包含下行流量，所以通过逗号将其分割开来
				String [] flows = list.get(i).split(",");
				//将字符串类型的上下行流量通过long类型的包装类转换成long类型的上下行流量，并且进行累加
				allFlow = allFlow+Long.parseLong(flows[0])+Long.parseLong(flows[1]);
			}
			tempMap.put(key, allFlow);			
		}		
		return tempMap;
	}

	public static void main(String[] args) {
		FilePaser filePaser = new FilePaser();
		FileCompute compute = new FileCompute();
		File file = new AutoFileLoader(new Configurer()).getFile();
		Map<String, List<String>> map = filePaser.pase(file);
		System.out.println(map.size());
		Map<String,Long> sdfsdf = compute.computeAllFlow(map);
		
	}

}
