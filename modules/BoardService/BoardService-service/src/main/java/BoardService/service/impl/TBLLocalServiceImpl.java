/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package BoardService.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import BoardService.model.TBL;
import BoardService.service.TBLLocalServiceUtil;
import BoardService.service.base.TBLLocalServiceBaseImpl;

/**
 * The implementation of the tbl local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>BoardService.service.TBLLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TBLLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=BoardService.model.TBL",
	service = AopService.class
)
public class TBLLocalServiceImpl extends TBLLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>BoardService.service.TBLLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BoardService.service.TBLLocalServiceUtil</code>.
	 */
	// 게시판 PK 자동증가
	public TBL addTblWithIncrement (TBL tbl) {
		long bno = this.counterLocalService.increment(TBL.class.toString());
		tbl.setBno(bno);
		return this.addTBL(tbl);
	}
	
	//  게시판 PK 업데이트
	public TBL updateTblWithTbl(TBL tbl) {
		return this.tblLocalService.updateTBL(tbl);
	}
	// 조회수 증가
		public boolean addHitTBL(long bno) {

			TBL tbl;
			try {
				tbl = TBLLocalServiceUtil.getTBL(bno);
				int hit = tbl.getHit();
						
				tbl.setHit(++hit);
				
				tbl = TBLLocalServiceUtil.updateTBL(tbl);
				
				System.out.print("Hit UP!");
				System.out.println("Hit:"+hit);
				
			} catch (PortalException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
			
	}
		
	/*-------------------------------------------검색관련 메서드---------------------------------------------------------------------------*/	
		// 제목검색 결과 리스트
		public List<TBL> getTBLListBySuebject(String searchKeyword,int cntPerPage,int initRowNumber){
			List<TBL> list = this.tblPersistence.findBysubject("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);
			return list;
		}
		// 내용검색 결과 리스트 
		public List<TBL> getTBLListByContents(String searchKeyword,int cntPerPage,int initRowNumber){
			List<TBL> list = this.tblPersistence.findBycontents("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);
			return list;
		}
		// 작성자 하여 결과 리스트 
		public List<TBL> getTBLListByWriter(String searchKeyword,int cntPerPage,int initRowNumber){
			List<TBL> list = this.tblPersistence.findBywriter("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);
			return list;
		}
		
		
		// 검색 결과 [리스트]
		public List<TBL> getTBLListBySearch(String searchKeyword,String option,int cntPerPage,int initRowNumber){
			
			List<TBL> board_search_list  = null;
			
			if(option.equals("keyword_S".trim())) {	// 제목검색 결과 리스트
				board_search_list = this.tblPersistence.findBysubject("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);

			}if(option.equals("keyword_C".trim())) { // 내용검색 결과 리스트 	
				board_search_list = this.tblPersistence.findBycontents("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);
				
			}if(option.equals("keyword_W".trim())) { // 작성자 하여 결과 리스트	
				board_search_list = this.tblPersistence.findBywriter("%" + searchKeyword + "%", initRowNumber, initRowNumber+cntPerPage);
		}
			return board_search_list;
		}
		
		
		
		
		
		
		
		
		
		// 검색결과 [갯수] 
		public List<TBL> getTBLListTotalCnt(String searchKeyword,String option){
			List<TBL> listTotal  = null;

			
			if(option.equals("keyword_S".trim())) {	
				listTotal = this.tblPersistence.findBysubject("%" + searchKeyword + "%");

			}if(option.equals("keyword_C".trim())) {	
				listTotal = this.tblPersistence.findBycontents("%" + searchKeyword + "%");
				
			}if(option.equals("keyword_W".trim())) {	
				listTotal = this.tblPersistence.findBywriter("%" + searchKeyword + "%");
		}

			return listTotal;

		}
		
		

		
	}