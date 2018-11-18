```java
package egovframework.example.employee.service;

public class PagingVO {
	private long rows;			// 한페이지에 나올 로우 수
	private long page;			// 현재 페이지
	private long totalPage;		// 총 페이지개수
	private long nowStartPage;	// 현재 화면에서의 처음 페이지
	private long nowEndPage;	// 현재 화면에서의 끝 페이지
	private long pageScale;		// 1~5, 6~10 아래 페이징 으로 한화면에 보여질 페이지 수.
	private long pageGroup;		// 페이징숫자 리스트 밑에 페이징 그룹임 1,2,3,4,5 페이지가 1그룹, 6~10페이지가 2그룹...
	private long prePage;		// 전 페이지
	private long nextPage;		// 다음 페이지
	private String searchCol;	// 검색할 컬럼
	private String searchVal;	// 검색할 값(컬럼안에 있는 값)
	private String searchSex;		// 다중검색: 성별	
	private String searchTechLev;	// 다중검색: 기술등급
	
	public String getSearchSex() {
		return searchSex;
	}

	public void setSearchSex(String searchSex) {
		this.searchSex = searchSex;
	}

	public String getSearchTechLev() {
		return searchTechLev;
	}

	public void setSearchTechLev(String searchTechLev) {
		this.searchTechLev = searchTechLev;
	}

	public PagingVO() {
		this.rows			= 5;	
		this.page			= 1;	
		this.totalPage		= 1;	
		this.nowStartPage	= 1;	
		this.nowEndPage		= 1;	
		this.pageScale		= 5;
	}
	
	public String getSearchCol() {
		return searchCol;
	}

	public void setSearchCol(String searchCol) {
		this.searchCol = searchCol;
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	public long getRows() {
		return rows;
	}

	public void setRows(long rows) {
		this.rows = rows;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getNowStartPage() {
		return nowStartPage;
	}

	public void setNowStartPage(long nowStartPage) {
		this.nowStartPage = nowStartPage;
	}

	public long getNowEndPage() {
		return nowEndPage;
	}

	public void setNowEndPage(long nowEndPage) {
		this.nowEndPage = nowEndPage;
	}

	public long getPageScale() {
		return pageScale;
	}

	public void setPageScale(long pageScale) {
		this.pageScale = pageScale;
	}

	public long getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(long pageGroup) {
		this.pageGroup = pageGroup;
	}

	public long getPrePage() {
		return prePage;
	}

	public void setPrePage(long prePage) {
		this.prePage = prePage;
	}

	public long getNextPage() {
		return nextPage;
	}

	public void setNextPage(long nextPage) {
		this.nextPage = nextPage;
	}

	public void pageCal() {		// 페이지 계산 메서드.
		
		// 페이징숫자 리스트 밑에 페이징 그룹임 1,2,3,4,5 페이지가 1그룹, 6~10페이지가 2그룹...
		// this.page 현재 페이지를 가져와서 어떤 그룹에 속하는지를 구하는 공식
		this.pageGroup = (int) Math.ceil((double)this.page / this.pageScale);
		
		// start와 endPage는 1, 5 또는 6, 10을 구함.	(PageScale을 한화면에 5페이지씩 보이게 함)
		this.nowStartPage = (this.pageGroup - 1) * this.pageScale + 1;  // 1, 6, 11, 16.....
		
		this.nowEndPage = this.nowStartPage + this.pageScale - 1 > this.totalPage ?
				this.totalPage : this.nowStartPage + this.pageScale - 1; // 5, 10, 15,......
		
		// pre 와 next는 2그룹(6,7,8,9,10p) 기준 예)
		// prePage = 현재 nowStartPage가 1과 같으면 1, 아니면: 현재보이는 페이지그룹의 첫번째 번호에서 -1 => 6-1=5 로 1그룹의 5페이지로 가기.
		// nextPage = 총페이지수와 같으면 총페이지수로 가고, 아니면 현재보이는 페이지그룹의 마지막 번호 +1 => 10+1=11 로 3그룹의 첫번째 번호로 감.
		this.prePage	= this.nowStartPage == 1 ? 1 : this.nowStartPage - 1;
		this.nextPage	= this.nowEndPage >= this.totalPage ? this.totalPage : this.nowEndPage + 1;
	}

	// toString 해줘야 컨트롤러에서 시스아웃 찍어볼수 있음.
	@Override
	public String toString() {
		return "PagingVO [rows=" + rows + ", page=" + page + ", totalPage=" + totalPage + ", nowStartPage="
				+ nowStartPage + ", nowEndPage=" + nowEndPage + ", pageScale=" + pageScale + ", pageGroup=" + pageGroup
				+ ", prePage=" + prePage + ", nextPage=" + nextPage + "]";
	}
	

}
```
