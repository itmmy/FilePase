package com.mmy.file.compute;

import java.util.List;

/**
 * 排序后的手机流量使用情况的格式化输出器
 * @author tarena-mmy
 *
 */
public class FlowPrinter {
	/**
	 * 按照从前往后的顺序输出List集合中每个手机号的流量的使用情况
	 * @param list 存放有序结果集的容器
	 */
	public void printFlowList(List<String> list){
		int temp = 1;
		for (int i = 0; i < list.size(); i++) {
			System.out.println("总流量第"+ temp++ +"名的手机号为"+list.get(i)+"\t总流量为："+list.get(++i));
		}
	}

}
