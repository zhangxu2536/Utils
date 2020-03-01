package com.zhangxu.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//��ҳ������
public class PageUtil {
	
	private List list;//����
	private int pageSize=2;//ÿҳ��ʾ����
	private int pageNum;//��ǰҳ��
	private int startIndex;//��ʼ�±�����
	private int totalPage;//��ҳ��
	private int totalRecords;//�ܼ�¼��
	private int firstPage;//��һҳ
	private int lastPage;//���һҳ
	private int previousPage;//��һҳ
	private int nextPage;//��һҳ
	private String url="";//��Ҫ��ҳ������
	private String like="";//���ڼ�¼ģ������
	//��ʾ��ҳ��
	private int startPage;
	private int endPage;
	/**
	 * @param totalRecords  �ܼ�¼��
	 * @param pageNum ��ǰҳ
	 * @param request 
	 * @param likeCondition  ģ������ 
	 */
	public PageUtil(int totalRecords,int pageNum,HttpServletRequest request,String... likeCondition) {
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		this.firstPage=1;
		
		//��Ҫ�����ʼ�±�����
		startIndex = (pageNum -1)*pageSize;
		//��Ҫ�������ҳ��
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
		
		//��һҳ
		if(this.pageNum > 1) {
			this.previousPage = this.pageNum-1;
		}else {
			this.previousPage = this.firstPage;
		}
		
		if(totalPage == 0) {
			totalPage = 1;
		}
		this.lastPage=this.totalPage;
		//��һҳ
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
		
		/*�ܼ�¼��:${page.totalRecords }     ��ǰҳ${page.pageNum }/��ҳ��${page.totalPage }
		<a href="${page.url }?pageNum=${page.firstPage}${page.name}">��ҳ</a>
		<a href="${page.url }?pageNum=${page.previousPage}${page.name}">��һҳ</a>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="num">
			<a href="${page.url }?pageNum=${num }${page.name}">${num }</a>
		</c:forEach>
		<a href="${page.url }?pageNum=${page.nextPage}${page.name}">��һҳ</a>
		<a href="${page.url }?pageNum=${page.lastPage}${page.name}">βҳ</a>*/
		
		String title = "�ܼ�¼��:"+totalRecords+"  ��ǰҳ"+pageNum+"/��ҳ��"+totalPage;
		String sy = "<a href='"+url+"?pageNum="+firstPage+like+"'>��ҳ</a>";
		String syy = "<a href='"+url+"?pageNum="+previousPage+like+"'>��һҳ</a>";
		String xyy = "<a href='"+url+"?pageNum="+nextPage+like+"'>��һҳ</a>";
		String wy = "<a href='"+url+"?pageNum="+lastPage+like+"'>βҳ</a>";
		
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
