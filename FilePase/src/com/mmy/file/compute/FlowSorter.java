package com.mmy.file.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 总流量排序器
 * 
 * @author tarena-mmy
 * 
 */
public class FlowSorter {

	/**
	 * 对处理好的结果数据进行排序
	 * 
	 * @param map
	 *            盛放结果数据的容器
	 * @return 有一定顺序的结果
	 */
	public List<String> sortFlowList(Map<String, Long> map) {
		// 将结果容器中的数据放置到数据中，等待进行排序
		long[] allFlows = new long[map.size()];
		int tmp = 0;
		for (String key : map.keySet()) {
			allFlows[tmp] = map.get(key);
			tmp++;
		}

		// 冒泡排序
		for (int i = 0; i < allFlows.length - 1; i++) {
			for (int j = 0; j < allFlows.length - i - 1; j++) {
				if (allFlows[j] < allFlows[j + 1]) {
					long temp = allFlows[j];
					allFlows[j] = allFlows[j + 1];
					allFlows[j + 1] = temp;
				}
			}
		}

		//放置有序的结果
		List<String> list = new ArrayList<>();
		for (int i = 0; i < allFlows.length; i++) {
			for (String key : map.keySet()) {
				if (allFlows[i] == map.get(key)) {
					list.add(key);
					list.add(allFlows[i] + "");
				}
			}
		}
		return list;
	}

}
