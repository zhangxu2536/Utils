package com.zhangxu.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//分页工具类
public class PageUtil {
	
	private List list;//数据
	private int pageSize=2;//每页显示条数
	private int pageNum;//当前页数
	private int startIndex;//开始下标索引
	private int totalPage;//总页数
	private int totalRecords;//总记录数
	private int firstPage;//第一页
	private int lastPage;//最后一页
	private int previousPage;//上一页
	private int nextPage;//下一页
	private String url="";//需要分页的请求
	private String like="";//用于记录模糊条件
	//显示的页码
	private int startPage;
	private int endPage;
	/**
	 * @param totalRecords  总记录数
	 * @param pageNum 当前页
	 * @param request 
	 * @param likeCondition  模糊条件 
	 */
	public PageUtil(int totalRecords,int pageNum,HttpServletRequest request,String... likeCondition) {
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		this.firstPage=1;
		
		//需要求出开始下标索引
		startIndex = (pageNum -1)*pageSize;
		//需要计算出总页数
		totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
		
		
		if(totalPage<=9) {
			startPage=1;
			endPage=totalPage;
		}else {
			startPage=pageNum-4;
			endPage = pageNum+4;
			
			if(startPage < 1) {
				startPage=1;
				endPage = 9;
			}
			
			if(endPage > totalPage) {
				endPage = totalPage;
				startPage = totalPage-8;
			}
		}
		
		//上一页
		if(this.pageNum > 1) {
			this.previousPage = this.pageNum-1;
		}else {
			this.previousPage = this.firstPage;
		}
		
		if(totalPage == 0) {
			totalPage = 1;
		}
		this.lastPage=this.totalPage;
		//下一页
		if(this.pageNum < this.lastPage) {
			this.nextPage = this.pageNum+1;
		}else {
			this.nextPage = this.lastPage;
		}
		
		if(likeCondition.length>0) {
			for (int i = 0; i < likeCondition.length; i++) {
				String str = request.getParameter(likeCondition[i]);
				if(str != null) {
					like +="&"+likeCondition[i]+"="+str;
				}
			}
		}else {
			like="";
		}
		
		/*总记录数:${page.totalRecords }     当前页${page.pageNum }/总页数${page.totalPage }
		<a href="${page.url }?pageNum=${page.firstPage}${page.name}">首页</a>
		<a href="${page.url }?pageNum=${page.previousPage}${page.name}">上一页</a>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="num">
			<a href="${page.url }?pageNum=${num }${page.name}">${num }</a>
		</c:forEach>
		<a href="${page.url }?pageNum=${page.nextPage}${page.name}">下一页</a>
		<a href="${page.url }?pageNum=${page.lastPage}${page.name}">尾页</a>*/
		
		String title = "总记录数:"+totalRecords+"  当前页"+pageNum+"/总页数"+totalPage;
		String sy = "<a href='"+url+"?pageNum="+firstPage+like+"'>首页</a>";
		String syy = "<a href='"+url+"?pageNum="+previousPage+like+"'>上一页</a>";
		String xyy = "<a href='"+url+"?pageNum="+nextPage+like+"'>下一页</a>";
		String wy = "<a href='"+url+"?pageNum="+lastPage+like+"'>尾页</a>";
		
		request.setAttribute("title", title);
		request.setAttribute("sy", sy);
		request.setAttribute("syy", syy);
		request.setAttribute("xyy", xyy);
		request.setAttribute("wy", wy);
		
		request.setAttribute("fenye", title+sy+syy+xyy+wy);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	
}
