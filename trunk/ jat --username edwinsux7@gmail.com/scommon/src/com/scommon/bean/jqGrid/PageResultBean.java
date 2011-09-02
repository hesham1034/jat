
package com.scommon.bean.jqGrid;   

import java.util.List;

/**   
 * ClassName:PageResultBean   
 * Function: 分页结果bean 
 *   
 * @author   sux   
 * @version  1.0, 2011-8-19   
 * @since    scommon1.0   
 */
public class PageResultBean {
	/**
	 * 当前页码
	 */
	private Integer page;
	/**
	 * 总页数
	 */
	private Integer total;
	/**
	 * 记录总数
	 */
	private Integer records;
	/**
	 * 当页记录集合
	 */
	private List rows;
	
	
	public PageResultBean(int page,int num, int records, List rows) {
		this.page = page;
		this.records = records;
		this.rows = rows;
		this.total = ((records%num == 0) ? (records/num)  : ((records/num)+1));
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
   
