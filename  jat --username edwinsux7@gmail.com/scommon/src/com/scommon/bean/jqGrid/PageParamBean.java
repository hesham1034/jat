
package com.scommon.bean.jqGrid;   
/**   
 * ClassName:PageBean   
 * Function: 分布参数bean
 *   
 * @author   sux   
 * @version  1.0, 2011-8-19   
 * @since    scommon1.0   
 */
public class PageParamBean {
	/**
	 * 当前页码
	 */
	private Integer page;
	/**
	 * 每页显示的记录数
	 */
	private Integer rows;
	/**
	 * 用于排序的列名的参数名称 
	 */
	private String sidx;
	/**
	 * 排序方式
	 */
	private String sord;
	
	/**
	 *  开始的记录数
	 */
	private Integer start;
	
	private Integer totalrows;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public Integer getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}
	public Integer getStart() {
		return (page-1)*rows+1;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
}
   
