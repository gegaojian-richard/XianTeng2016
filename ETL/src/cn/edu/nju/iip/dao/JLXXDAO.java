package cn.edu.nju.iip.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.iip.etl.ConstructComETL;
import cn.edu.nju.iip.model.JLXX;
import cn.edu.nju.iip.model.RawHtml;

public class JLXXDAO extends DAO{
	
	private static final Logger logger = LoggerFactory.getLogger(JLXXDAO.class);

	@Override
	public boolean saveData(RawHtml raw_html) {
		try {
			JLXX Data = new JLXX();
			Data.setUnit(raw_html.getSource());
			Data.setcDate(new Date());// 录入时间
			Data.setpDate(raw_html.getCrawltime());
			Data.setCorp_Id(raw_html.getUnitName());
			Data.setData_Source(raw_html.getUrl());
			Data.setContent(raw_html.getContent());
			if(!extractField(Data)) {
				return false;
			}
			begin();
			getSession().save(Data);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			logger.error("TBBZDAO saveData failed!", e);
		}
		return false;
	}
	
	/**
	 * 抽取正文字段
	 * @param Data
	 */
	public boolean extractField(JLXX Data) {
		String content = Data.getContent();
		String[] sentences = content.split("[\\s。？]+");
		for (String sentence : sentences) {
			if (sentence.contains("奖")&&(sentence.contains("关于")||sentence.contains("名单")||sentence.contains("决定")||sentence.contains("通知"))) {
				if(sentence.contains("关于")) {
					int index = sentence.indexOf("关于");
					sentence = sentence.substring(index);
				}
				if (sentence.length() > 50) {
					sentence = sentence.substring(0, 50);
				}
				sentence = sentence.replace(".doc", "");
				Data.setName(sentence);
				logger.info("sentence="+sentence);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ConstructComETL road_JLXX_etl = new ConstructComETL("道路运输企业", "获奖",new JLXXDAO());
		Thread thread = new Thread(road_JLXX_etl);
		thread.start();
	}

}