package comshz.test;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadConfFile {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		File confFile = new File("D:\\all.conf");
		//表示配置文件存在
		if (confFile.exists()) {
			try {
				FileReader reader = new FileReader(confFile);
				char[] chars = new char[5000];
				reader.read(chars);
				String confStr = new String(chars);
				String[] confStrs = confStr.split(System.lineSeparator());
				for (int i = 0; i < confStrs.length; i++) {
					String[] confs = confStrs[i].split("=");
					map.put(confs[0], confs[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("配置文件不存在");
		}
		
		System.out.println(map.get("OS"));
	}

}
