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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import BoardService.model.REP;
import BoardService.service.base.REPLocalServiceBaseImpl;

/**
 * The implementation of the rep local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>BoardService.service.REPLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see REPLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=BoardService.model.REP",
	service = AopService.class
)
public class REPLocalServiceImpl extends REPLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>BoardService.service.REPLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BoardService.service.REPLocalServiceUtil</code>.
	 */
	
	
	public List<REP> getREPListBybno(long bno ,int offset,int limit){
		List<REP> list = this.repPersistence.findBybno(bno, offset, offset+limit);
		return list;
	}

	
	
}