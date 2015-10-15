package com.mmy.file.paser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 行解析器
 * 	解析单行文本并放置到map容器中
 * 		如果map容器中已经很有了相同手机号的值就添加到那个手机号所在的集合中
 * 		如果map容器中没有那个手机号就新建一个集合连同手机号一起放进集合中
 * @author tarena-mmy
 *
 */
public class LinePaser {
	
	/**
	 * 单行数据处理器
	 * @param line 被处理的数据行
	 * @param map 存放处理完成后的结果的容器
	 */
	public void linePase(String line,Map<String, List<String>> map){
		//将一行文件按照逗号进行分割
		String[] strs= line.split(",");
		//临时记录一个手机号
		String tempPhoneNumber = strs[0];
		//临时记录一个手机号的所有上网流量
		List<String> list;
		//如果map容器中有以这个手机号为key的键值对就将其上的集合拿出来，并将本行中的内容添加到集合中
		//然后从map中移除以这个手机号为key的键值对，重新添加一个手机号为key，以最新的集合为value的键值对
		if (map.containsKey(tempPhoneNumber)) {
			list = map.get(tempPhoneNumber);
			list.add(strs[1]+","+strs[2]);
			map.remove(tempPhoneNumber);
			map.put(tempPhoneNumber, list);
		}else{//如果map容器中没有以这个手机号为key的键值对，就新建一个集合，将流量添加到集合中，然后将手机号和集合添加到map中
			List<String> flows = new ArrayList<String>();
			flows.add(strs[1]+","+strs[2]);
			map.put(tempPhoneNumber,flows);
		}
	}

}
 