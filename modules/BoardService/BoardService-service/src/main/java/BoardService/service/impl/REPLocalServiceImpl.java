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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import BoardService.model.REP;
import BoardService.service.REPLocalServiceUtil;
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
	
	
	OrderByComparator<REP> getOrderComperator(long bno){
		

		OrderByComparator<REP> reply_order_list = OrderByComparatorFactoryUtil.create("REP", "bno".equals("desc"));
		//reply_order_list.getOrderByConditionValues(bno);
		//reply_order_list.getOrderBy();
	
		return reply_order_list;
	}
	
	public List<REP> getREPListBybno(long bno){
		List<REP> reply_list = this.repPersistence.findBybno(bno, 0, REPLocalServiceUtil.getREPsCount());		
		
		return reply_list;
	}
	
	
	
	
//	// 해당 게시글의 댓글만 가져오기
//	public List<REP> getREPListBybno(long bno ,int offset,int limit){
//		
//		// DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(REP.class, "rep",PortalClassLoaderUtil.getClassLoader());
//		// userQuery.addOrder(OrderFactoryUtil.desc("rep.rno"));
//		
//		// List<REP> reply_list = REPLocalServiceUtil.dynamicQuery(userQuery);
//		//List<REP> reply_list = this.repPersistence.findBybno(bno, offset, offset+limit, getOrderComperator(bno));
//		List<REP> reply_list = this.repPersistence.findBybno(bno, 0, REPLocalServiceUtil.getREPsCount());
//		
//		return reply_list;
//	}


	
}