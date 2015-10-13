package com.mmy.file.tool;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import com.mmy.conf.Configurer;
import com.mmy.var.AllParameter;

/**
 * 文件工具类
 * 
 * @author tarena-mmy
 * 
 */
public class FileTool {
	/**
	 * 获取指定文件中的内容
	 * 
	 * @param file
	 *            给定的文件
	 * @return 文件内容的字符串表现形式
	 */
	public static String getFileContent(File file) {
		// 表示在给定目录下，指定的文件确实存在
		if (file.exists()) {
			try {
				FileReader reader = new FileReader(file);
				char[] chars = new char[(int) file.length()];
				reader.read(chars);
				return new String(chars);
			} catch (Exception e) {
				System.out.println("获取文件内容出现异常：" + e.getMessage());
				return "";
			}
		}
		System.out.println("指定目录下文件不存在");
		return "";
	}

	/**
	 * 自己制造包含测试数据的测试文件 根据配置文件中指定的地址将生成好的测试数据放置进入指定的文件内
	 * 
	 * @param conf
	 */
	public static void makeTestFile(Configurer conf) {
		//记录创建测试文件的开始时间 即：1970年1月1日到现在的毫秒值
		Long start = System.currentTimeMillis();
		
		//从配置器中获取要处理的文件所在的地址
		String filePath = conf.getConfigContext().get(AllParameter.LOADFILEPATH);
		//根据上述地址创建一个file对象
		File file = new File(filePath);
		//如果上述地址中文件已存在就将其删除
		if (file.exists()) {
			//将文件删除
			file.delete();
		} 
		
		//创建文件写入器，将我们自己生成好的测试数据写入测试文件内
		try {
			FileWriter writer = new FileWriter(file);
			String temp = makeData(Long.parseLong(conf.getConfigContext().get(AllParameter.LINENUMS)));
			writer.write(temp);
			writer.close();
		} catch (Exception e) {
			System.out.println("写入文件异常："+e.getMessage());
		}
		
		//记录创建测试文件的结束时间 即：1970年1月1日到现在的毫秒值
		Long stop = System.currentTimeMillis();
		//输出创建测试文件所花费的总时间
		System.out.println("创建测试文件一共耗时："+(stop-start)+"毫秒");
	}

	/**
	 * 根据配置文件中的指定条数创建测试数据
	 * @param lineNums 配置文件中指定的数据条数 即：一条就是一行
	 * @return 所有数据放置在一起的一个完整字符串
	 */
	private static String makeData(long lineNums) {
		//记录创建测试数据的开始时间 即：1970年1月1日到现在的毫秒值
		Long start = System.currentTimeMillis();
		//创建手机号数组
		long[] phonenumbers = { 15012345671l, 15012345672l, 15012345673l,
				15012345674l, 15012345675l, 15012345676l, 15012345677l,
				15012345678l, 15012345679l, 15012345670l };
		//构造一个随机数产生器 以当前系统时间毫秒值为因子
		Random random = new Random(System.currentTimeMillis());
		//构造一个StringBuffer对象
		StringBuffer buffer = new StringBuffer();
		//在创建大量数据的时候，用于提示用户当前的创建进度
		long temp =1;
		if (lineNums>=10) {
			temp = lineNums/10;
		}
		//循环创建单行数据并追加到StringBuffer对象中
		for (int i = 0; i < lineNums; i++) {
			buffer.append(phonenumbers[random.nextInt(10)]+","+random.nextInt(512)+","+random.nextInt(512)+System.lineSeparator());
			if (i%temp==0) {
				System.out.println("已经生成了"+i+"条数据");
			}
		}
		//记录创建测试数据的结束时间 即：1970年1月1日到现在的毫秒值
		Long stop = System.currentTimeMillis();
		//输出创建测试数据所耗费的总时间
		System.out.println("生成"+lineNums+"条测试数据一共耗时："+(stop-start)+"毫秒");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		makeTestFile(configurer);
	}
	
}
