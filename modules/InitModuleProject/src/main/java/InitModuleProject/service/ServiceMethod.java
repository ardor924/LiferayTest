package InitModuleProject.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import BoardService.model.TBL;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.model.BoardPagingVO;

public class ServiceMethod {
	
	
	// START : 더미데이터 생성
	public void getDummy(){
		
		// 테이블생성 
		TBL tbl = TBLLocalServiceUtil.createTBL(0);
		ServiceMethod serviceMethod = new ServiceMethod();
		String strDate = serviceMethod.getStrNowDate(); 

		// 더미데이터 생성		
		  for(int dummy=1;dummy<=224;dummy++) {
		  
		  tbl.setBno(dummy);
		  tbl.setSubject("test");
		  tbl.setWriter("admin");
		  tbl.setContents("contents");
		  tbl.setRegDate(strDate);
		  tbl.setHit(0);
		  tbl = TBLLocalServiceUtil.addTBL(tbl);
		  }
	 
	}
	// END : 더미데이터 생성	
		
		
	/*---------------------------------------날짜 포맷---------------------------------------------------------*/	
		
	public String getStrNowDate() {
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		String strDate = sdf.format(nowDate);
		
		return strDate;
	}
		
	/*---------------------------------------ID 권한---------------------------------------------------------*/	
		
		// 유저 ID Number 가져오기
		public int getUserIdNumber(RenderRequest renderRequest,RenderResponse renderResponse) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();

			int userNumber = (int) user.getUserId();

			return userNumber;
			
			}
		
		// 유저 세팅
		public boolean setUserIdtoName(RenderRequest renderRequest,RenderResponse renderResponse, int userNumber) {
			
			try {
				
				// 비회원
				if(userNumber == 20105) { // 게스트
					renderRequest.setAttribute("userName", "guest");
					System.out.println("userName : guest");
					return true;
					
				// 관리자	
				}if(userNumber == 20130) { // 관리자
					renderRequest.setAttribute("userName", "admin");
					System.out.println("userName : admin");
					return true;	
					
				// 일반회원	
				}else{				
					ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
					User user = themeDisplay.getUser();
					String userName = user.getScreenName();
					renderRequest.setAttribute("userName", userName);
					System.out.println("userName : "+userName);
					return true;
					}
				
			} catch (Exception e) {
				System.out.println("Fail to get userNumber");
				return false;
			}


		}
			
		
		
	/*---------------------------------------검색결과---------------------------------------------------------*/	

		
		
			// 파라미터를 받아온후 검색한 결과 리스트 리턴
			public List<TBL> getSearchResultList(String searchKeyword,String option, int initRowNumber,int cntPerTotal,int currentPage, int cntPerPage){

		
				System.out.println("initRowNumber : "+initRowNumber);
				System.out.println("currentPage : "+currentPage);
				System.out.println("cntPerTotal : "+cntPerTotal);
				System.out.println("cntPerPage : "+cntPerPage);
				System.out.println("searchKeyword : "+searchKeyword);
		
				List<TBL>  board_list = TBLLocalServiceUtil.getTBLListBySearch(searchKeyword, option, cntPerPage, initRowNumber);
				
				
				


				System.out.println("SIZE:"+board_list.size());
				
				return board_list;
			}
			
			
			
			// 검색 키워드 파라미터를 받아와서 종류별로 리턴
			public String getOptionToSearchKeyword(String option, String keyword) {
				
				String searchKeyword = null;
				
				if(option.equals("keyword_S".trim())) {	
					searchKeyword = keyword;
					
				}if(option.equals("keyword_W".trim())) {	
					 searchKeyword = keyword;
				
				}if(option.equals("keyword_C".trim())) {	
					 searchKeyword = keyword;
			}

				return searchKeyword;

			}
			
			// 페이지 계산 결과
			public BoardPagingVO getBoardPagingResult(int cntPerTotal,int currentPage,int cntPerPage) {
				
				BoardPagingVO bp = new BoardPagingVO(cntPerTotal, currentPage, cntPerPage);
				return bp;
			}
			
			
			// 옵션별(검색어 유무)로 전체게시글 갯수 분기로 리턴
			public int getcntPerTotalBySearchkeyword(String searchKeyword,String option, int cntPerPage, int initRowNumber) {
				Integer total = null;
				
				if(searchKeyword == null || option == null) {
					total = TBLLocalServiceUtil.getTBLsCount();
				}else {
					List<TBL> totalList = TBLLocalServiceUtil.getTBLListTotalCnt(searchKeyword, option);
					total = totalList.size();
				}
				
				return total;
			}
			


			
			
			
	/*---------------------------------------------------------------------------------------------------------------------------------*/		
			
			
			
			// 검색 키워드 파라미터를 받아와서 칼럼명으로 리턴
						public String getOptionToColumnName(String option, String keyword) {
							
							String columnName = null;
							
							if(option.equals("keyword_S".trim())) {	
								columnName = "subject";
								
							}if(option.equals("keyword_W".trim())) {	
								columnName = "writer";
							
							}if(option.equals("keyword_C".trim())) {	
								columnName = "contents";
						}

							return columnName;

						}
			
			
			
			
			
			// 순서정렬한 게시판 목록 결과 호출
			public List<TBL> getOrderListResult(String ORDER, int cntPerPage, int initRowNumber, String searchKeyword, String columnName){
				
				List<TBL> board_list = null;
				
				
				// 검색어 없는경우
				if(searchKeyword == null)  	
				
				{
				if(ORDER.equals("") || ORDER == null) {	 // 기본(디폴트) 내림차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.desc("tbl.bno"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("bnoDown")) { // 번호 내림차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.desc("tbl.bno"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("bnoUp")) { // 번호 오름차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.asc("tbl.bno"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("regDown")) { // 등록일짜 내림차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.desc("tbl.regDate"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("regUp")) { // 등록일짜 오름차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.asc("tbl.regDate"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("hitDown")) { // 조회수 내림차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.desc("tbl.hit"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
					
				}if(ORDER.equals("hitUp")) { // 조회수 오름차순
					DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
					userQuery.addOrder(OrderFactoryUtil.asc("tbl.hit"));
					board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);			
				}
				
				// 검색어 있는경우
				}else {

					if(ORDER.equals("") || ORDER == null) {	 // 기본(디폴트) 내림차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.desc("tbl.bno"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("bnoDown")) { // 번호 내림차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.desc("tbl.bno"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("bnoUp")) { // 번호 오름차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.asc("tbl.bno"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("regDown")) { // 등록일짜 내림차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.desc("tbl.regDate"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("regUp")) { // 등록일짜 오름차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.asc("tbl.regDate"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("hitDown")) { // 조회수 내림차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.desc("tbl.hit"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);
						
					}if(ORDER.equals("hitUp")) { // 조회수 오름차순
						DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(TBL.class, "tbl",PortalClassLoaderUtil.getClassLoader());
						userQuery.add(RestrictionsFactoryUtil.like("tbl."+columnName, "%" + searchKeyword + "%"));
						userQuery.addOrder(OrderFactoryUtil.asc("tbl.hit"));
						board_list = TBLLocalServiceUtil.dynamicQuery(userQuery,initRowNumber, initRowNumber+cntPerPage);			
					}
					
					
					
				}
				
					System.out.println("columnName : : : > >"+columnName);
					System.out.println("SearchKeyword : : : > >"+searchKeyword);
					System.out.println("ORDER : "+ORDER);
					System.out.println("cntPerPage : "+cntPerPage);
					System.out.println("initRowNumber : "+initRowNumber);
					System.out.println("size : "+board_list.size());
					System.out.println(board_list.toString());
				
				
				return board_list;
			}
			
			

	}
