package com.kew.page;

import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;

public class PageUtil {
	
	public static final int FIRST_PAGE = 1;
	
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	public static RowBounds get(Integer pageNo, Integer pageSize) {
		if(pageNo == null || pageNo < FIRST_PAGE) {
			pageNo = FIRST_PAGE;
		}
		if(pageSize == null || pageSize <DEFAULT_PAGE_SIZE) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		int first = getFirst(pageNo, pageSize);
		int last = getLast(first, pageSize);
		return new RowBounds(first, last);
	}
	
	private static int getFirst(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	private static int getLast(int first, int pageSize) {
		return first + pageSize;
	}
	
	public static int begin(int pageNo, int pageSize){
		return getFirst(pageNo,pageSize);
	}
	
	public static int end(int pageNo, int pageSize){
		return getLast(getFirst(pageNo,pageSize),pageSize);
	}
	

	
	
	
	/**
	 * 通过总行数和每页页数得到总页数
	 * 
	 * @param totalPage
	 *            totalPage
	 * @param perPage
	 *            perPage
	 * @return 总页数
	 */
	private static int getTotalPage(int totalPage, int perPage) {
		if (perPage != 0) {
			if (totalPage % perPage != 0) {
				return totalPage / perPage + 1;
			} else {
				return totalPage / perPage;
			}

		} else {
			return 0;
		}
	}
	
	/**
	 * 验证请求过来的页面数是否符合要求
	 * 
	 * @param requestPage
	 *            requestPage
	 * @return int
	 */
	public static int validateRequestPage(String requestPage) {
		int currentPage = 1;
		if (!StringUtils.isEmpty(requestPage)) {
			try {
				currentPage = Integer.parseInt(requestPage);
			} catch (Exception e) {
				currentPage = 1;
			}
		}
		return currentPage;
	}

	/**
	 * 验证当前页数是否在该对象范围之内
	 * 
	 * @param currentPage
	 *            currentPage
	 * @param totalPage
	 *            totalPage
	 * @return int
	 */
	private static int validateTotalPage(int currentPage, int totalPage) {
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}

		return currentPage;
	}

	/**
	 * 不经过打印字符串
	 * 
	 * @param myCurrentPage
	 *            myCurrentPage
	 * @param totalRow
	 *            totalRow
	 * @param perPage
	 *            perPage
	 * @return pageObject
	 */
	public static PageObject makePageObject(String myCurrentPage, int totalRow,
			int perPage) {
		// 验证下请求过来的当前页数是否符合要求
		int currentPage = validateRequestPage(myCurrentPage);
		// 通过总行数和每页页数得到总页数
		int totalPage = PageUtil.getTotalPage(totalRow, perPage);
		// 验证当前页数是否在总页数区间范围内
		currentPage = PageUtil.validateTotalPage(currentPage, totalPage);
		PageObject pageObject = new PageObject();
		pageObject.setCurrentPage(currentPage);
		pageObject.setTotalPage(totalPage);
		pageObject.setPerPage(perPage);
		pageObject.setTotalRow(totalRow);
		return pageObject;
	}

}
