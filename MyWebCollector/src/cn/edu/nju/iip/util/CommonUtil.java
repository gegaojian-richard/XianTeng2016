package cn.edu.nju.iip.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.iip.model.Url;

public class CommonUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(CommonUtil.class);

	/**
	 * 从excel导入url信息
	 */
	public static List<Url> importFromXls() {
		Workbook workbook = null;
		List<Url> url_list = new ArrayList<Url>();
		try {
			workbook = Workbook.getWorkbook(new File(System
					.getProperty("user.dir") + "/resources/url_source_V3.1.xls"));
		} catch (Exception e) {
			logger.error("importFromXls error!", e);
		}
		Sheet sheet = workbook.getSheet(1);
		int rowCount = sheet.getRows();
		for (int i = 1; i < rowCount; i++) {
			Url Url = new Url();
			String webname = sheet.getCell(1, i).getContents().trim();
			String link = sheet.getCell(4, i).getContents();
			Url.setLink(link);
			Url.setWebname(webname);
			url_list.add(Url);
		}
		workbook.close();
		return url_list;
	}

	/**
	 * 抽取待爬取url的主域名
	 * 
	 * @return
	 */
	public static String extractSourceUrl() {
		String source_url = null;

		return source_url;
	}

	public static List<String> importUnitName() {
		Workbook workbook = null;
		List<String> list = new ArrayList<String>();
		try {
			workbook = Workbook.getWorkbook(new File(System
					.getProperty("user.dir") + "/resources/公路企业基本信息.xls"));
		} catch (Exception e) {
			logger.error("importFromXls error!", e);
		}
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		for (int i = 1; i < rowCount; i++) {
			String UnitName = sheet.getCell(2, i).getContents().trim();
			if (UnitName.contains("公司")) {
				list.add(UnitName);
			}
		}
		return list;
	}
	
	public static List<String> importUrl() {
		Workbook workbook = null;
		List<String> list = new ArrayList<String>();
		try {
			workbook = Workbook.getWorkbook(new File(System
					.getProperty("user.dir") + "/resources/url_source_V3.1.xls"));
		} catch (Exception e) {
			logger.error("importFromXls error!", e);
		}
		Sheet sheet = workbook.getSheet(2);
		int rowCount = sheet.getRows();
		for (int i = 1; i < rowCount; i++) {
			String url = sheet.getCell(4, i).getContents().trim();
			if(url.endsWith("/")){
				url = url.substring(0,url.length()-1);
			}
			list.add(url);
		}
		return list;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		String time = dateFormat.format(now);
		return time;
	}

	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			logger.info("所删除的文件不存在！");
		}
	}

	public static void readTxt() {
		List<String> list = importUrl();
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"C:/Users/wangqiang/Desktop/test.xls"));
			WritableSheet sheet = book.createSheet("第一页", 0);
			BufferedReader in = new BufferedReader(new FileReader("resources/url.txt"));
			String s = in.readLine();
			int n = 0;
			while (s != null) {
				if (s.length() > 0) {
					String[] str = s.split(" ");
					String url = "http://"+str[1];
					if(url.endsWith("/")){
						url = url.substring(0,url.length()-1);
					}
					if(!list.contains(url)) {
						String[] names = str[0].split("--");
						String webname = names[0];
						String press  = names[1];
					    sheet.addCell(new Label(0, n, webname));
					    sheet.addCell(new Label(1, n, "新闻网站"));
					    sheet.addCell(new Label(2, n, press));
					    sheet.addCell(new Label(3, n, url));
					    n++;
					}
				}
				s = in.readLine();
			}
			logger.info("n=" + n);
			in.close();
			// 写入数据
			book.write();
			// 关闭文件
			book.close();
		} catch (Exception e) {
			logger.info("readTxt error", e);
		}
	}
	public static void main(String[] args) {
		readTxt();
		//importUrl();

	}

}
