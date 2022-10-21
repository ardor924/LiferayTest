package InitModuleProject.model;

public class BoardPagingVO {
	
	// 기본 게시판 요소
	private long bno;
	private String subject;
	private String writer;
	private String contents;
	private String regDate;
	private int hit;
	

	
	// 페이지
	private int initPage;			// 시작페이지
	private int currentPage;  		// 현재페이지
	private int totalPage; 			// 전체페이지
	private int prevPage; 			// 이전페이지로
	private int nextPage; 			// 다음페이지로
	
	// 블럭
	private int blockStart; 		//	시작블럭
	private int blockEnd; 			//	끝블럭
	private int blockCurrentLocation;// 현재 블럭위치
	private int blockSize = 10; 			//  표시할 블록의갯수
	
	// 게시글수
	private int cntPerPage; 			// 전체 게시글수
	private int cntPerTotal; 			// 페이지당 게시글수
	

	// 페이지별 시작번호
	private int initRowNumber; 			// 페이지별 시작번호
	
	
	// 게시판가짜번호
	private int number; 


	// 기본생성자
	public BoardPagingVO(){};
	
	// 인자 생성자
	public BoardPagingVO(int cntPerTotal, int currentPage, int cntPerPage) {
		this.cntPerTotal = cntPerTotal; //
		this.cntPerPage = cntPerPage;
		this.currentPage = currentPage;
		
		// 객체 생성시에 paging 처리 계산
		setValue(cntPerTotal, cntPerPage);
	}
	
	// 계산
	public void setValue(int cntPerTotal, int cntPerPage) {
		this.totalPage = (int) Math.ceil((double)cntPerTotal/cntPerPage);
		this.initPage = (currentPage - 1)*cntPerPage;
		this.blockCurrentLocation = (currentPage-1)/blockSize;
		this.blockStart = (blockSize*blockCurrentLocation)+1;
		this.blockEnd = blockStart + (blockSize - 1);
		
		if(blockEnd > totalPage) blockEnd = totalPage;
		
		this.prevPage = blockStart - 1;
		this.nextPage = blockEnd + 1;
		
		if(nextPage > totalPage) nextPage = totalPage;
		
		//this.number = cntPerTotal - (currentPage -1) * cntPerPage;
		this.number = cntPerTotal - (currentPage -1) * cntPerPage;
		
		/* if(prevPage < blockStart) prevPage = 1; */ //문제없을시 삭제예정 
		// 행번호 출력하기
		// totalCnt 107 (11page)
//		1 페이지 -> 107 ~ 98
//		2 페이지 -> 97 ~ 88
//		3 페이지 -> 87 ~ 78
//		4 페이지 -> 77 ~ 68
//		~~~
//		1페이지의 startRowNum = totalCnt - 0
//		2페이지의 startRowNum = totalCnt - 10
//		3페이지의 startRowNum = totalCnt - 20
		
		// 페이지별 행시작번호 구하기
		 initRowNumber = (currentPage-1)*cntPerPage; // 오름차순
		 // initRowNumber = cntPerTotal - (currentPage-1)*cntPerPage;
		// initEndRowNumber = cntPerTotal-(currentPage-1)*cntPerPage; // 내림차순
		// initRowNumber = cntPerTotal-(currentPage-1)*cntPerPage; // 내림차순
	}

	
	// 전체생성자
	public BoardPagingVO(long bno, String subject, String writer, String contents, String regDate, int hit,
			int initPage, int currentPage, int totalPage, int prevPage, int nextPage, int blockStart, int blockEnd,
			int blockCurrentLocation, int blockSize, int cntPerPage, int cntPerTotal, int initRowNumber , int number) {
		super();
		this.bno = bno;
		this.subject = subject;
		this.writer = writer;
		this.contents = contents;
		this.regDate = regDate;
		this.hit = hit;
		this.initPage = initPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.blockStart = blockStart;
		this.blockEnd = blockEnd;
		this.blockCurrentLocation = blockCurrentLocation;
		this.blockSize = blockSize;
		this.cntPerPage = cntPerPage;
		this.cntPerTotal = cntPerTotal;
		this.initRowNumber = initRowNumber;
		this.number = number;
	}
	
	
	
	// Getter & Setter
	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getInitPage() {
		return initPage;
	}

	public void setInitPage(int initPage) {
		this.initPage = initPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public void setBlockStart(int blockStart) {
		this.blockStart = blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	public int getBlockCurrentLocation() {
		return blockCurrentLocation;
	}

	public void setBlockCurrentLocation(int blockCurrentLocation) {
		this.blockCurrentLocation = blockCurrentLocation;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getCntPerTotal() {
		return cntPerTotal;
	}

	public void setCntPerTotal(int cntPerTotal) {
		this.cntPerTotal = cntPerTotal;
	}

	public int getInitRowNumber() {
		return initRowNumber;
	}

	public void setInitRowNumber(int initRowNumber) {
		this.initRowNumber = initRowNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "BoardPagingVO [bno=" + bno + ", subject=" + subject + ", writer=" + writer + ", contents=" + contents
				+ ", regDate=" + regDate + ", hit=" + hit + ", initPage=" + initPage + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", blockStart="
				+ blockStart + ", blockEnd=" + blockEnd + ", blockCurrentLocation=" + blockCurrentLocation
				+ ", blockSize=" + blockSize + ", cntPerPage=" + cntPerPage + ", cntPerTotal=" + cntPerTotal
				+ ", initRowNumber=" + initRowNumber + ", number=" + number + "]";
	}
	
	

	
	
	


	
}