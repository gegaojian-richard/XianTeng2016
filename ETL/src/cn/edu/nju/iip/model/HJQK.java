package cn.edu.nju.iip.model;

import java.util.Date;

/**
 * 公路水运建设市场从业企业 获奖情况表对应实体
 * 
 * @author wangqiang
 * 
 */
public class HJQK {
	private String award_id;
	// 企业id
	private String corp_Id;
	// 文号
	private String code;
	// 奖项名称
	private String name;
	// 获奖年度
	private String year;
	// 奖项等级类别
	private String type;
	// 奖项等级
	private String type_Name;
	// 所属行业
	private String industry;
	// 颁奖单位
	private String unit;
	// 颁奖日期
	private String pDate;
	// 录入时间
	private Date cdate;
	// 数据交换入库时间时间
	private Date udate;
	// 来源
	private String data_Source;
	//附件名
	private String fileName;
	//网站名称
    private String webName;
    //正文内容
    private String webContent;
    //关注度等级
    private String webLevel;
    //标题
    private String webTitle;
    //企业名
  	private String corp_Name;
	
	
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getWebContent() {
		return webContent;
	}
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	public String getWebLevel() {
		return webLevel;
	}
	public void setWebLevel(String webLevel) {
		this.webLevel = webLevel;
	}
	public String getWebTitle() {
		return webTitle;
	}
	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}
	public String getCorp_Name() {
		return corp_Name;
	}
	public void setCorp_Name(String corp_Name) {
		this.corp_Name = corp_Name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getAward_id() {
		return award_id;
	}
	public void setAward_id(String award_id) {
		this.award_id = award_id;
	}
	public String getCorp_Id() {
		return corp_Id;
	}
	public void setCorp_Id(String corp_Id) {
		this.corp_Id = corp_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_Name() {
		return type_Name;
	}
	public void setType_Name(String type_Name) {
		this.type_Name = type_Name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getData_Source() {
		return data_Source;
	}
	public void setData_Source(String data_Source) {
		this.data_Source = data_Source;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
