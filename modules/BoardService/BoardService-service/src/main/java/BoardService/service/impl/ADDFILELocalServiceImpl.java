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

import BoardService.model.ADDFILE;
import BoardService.model.REP;
import BoardService.model.TBL;
import BoardService.service.base.ADDFILELocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the addfile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>BoardService.service.ADDFILELocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILELocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=BoardService.model.ADDFILE",
	service = AopService.class
)
public class ADDFILELocalServiceImpl extends ADDFILELocalServiceBaseImpl {
	
	
	public ADDFILE addADDFILEWithIncrement(ADDFILE addFile) {
		long fno = this.counterLocalService.increment(ADDFILE.class.toString());
		addFile.setFno(fno);
		return this.addADDFILE(addFile);
	}
	
	
	// 해당 게시글의 파일만 가져오기
	public List<ADDFILE> getfileListBybno(long bno){
		List<ADDFILE> list = this.addfilePersistence.findBybno(bno);
		return list;
	}
	
	
	
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>BoardService.service.ADDFILELocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BoardService.service.ADDFILELocalServiceUtil</code>.
	 */
}