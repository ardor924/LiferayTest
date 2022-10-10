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

package BoardService.service.persistence;

import BoardService.model.REP;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rep service. This utility wraps <code>BoardService.service.persistence.impl.REPPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see REPPersistence
 * @generated
 */
public class REPUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(REP rep) {
		getPersistence().clearCache(rep);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, REP> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<REP> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<REP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<REP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<REP> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static REP update(REP rep) {
		return getPersistence().update(rep);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static REP update(REP rep, ServiceContext serviceContext) {
		return getPersistence().update(rep, serviceContext);
	}

	/**
	 * Returns all the reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching reps
	 */
	public static List<REP> findBybno(long bno) {
		return getPersistence().findBybno(bno);
	}

	/**
	 * Returns a range of all the reps where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @return the range of matching reps
	 */
	public static List<REP> findBybno(long bno, int start, int end) {
		return getPersistence().findBybno(bno, start, end);
	}

	/**
	 * Returns an ordered range of all the reps where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reps
	 */
	public static List<REP> findBybno(
		long bno, int start, int end,
		OrderByComparator<REP> orderByComparator) {

		return getPersistence().findBybno(bno, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reps where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reps
	 */
	public static List<REP> findBybno(
		long bno, int start, int end, OrderByComparator<REP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBybno(
			bno, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	public static REP findBybno_First(
			long bno, OrderByComparator<REP> orderByComparator)
		throws BoardService.exception.NoSuchREPException {

		return getPersistence().findBybno_First(bno, orderByComparator);
	}

	/**
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep, or <code>null</code> if a matching rep could not be found
	 */
	public static REP fetchBybno_First(
		long bno, OrderByComparator<REP> orderByComparator) {

		return getPersistence().fetchBybno_First(bno, orderByComparator);
	}

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	public static REP findBybno_Last(
			long bno, OrderByComparator<REP> orderByComparator)
		throws BoardService.exception.NoSuchREPException {

		return getPersistence().findBybno_Last(bno, orderByComparator);
	}

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep, or <code>null</code> if a matching rep could not be found
	 */
	public static REP fetchBybno_Last(
		long bno, OrderByComparator<REP> orderByComparator) {

		return getPersistence().fetchBybno_Last(bno, orderByComparator);
	}

	/**
	 * Returns the reps before and after the current rep in the ordered set where bno = &#63;.
	 *
	 * @param rno the primary key of the current rep
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public static REP[] findBybno_PrevAndNext(
			long rno, long bno, OrderByComparator<REP> orderByComparator)
		throws BoardService.exception.NoSuchREPException {

		return getPersistence().findBybno_PrevAndNext(
			rno, bno, orderByComparator);
	}

	/**
	 * Removes all the reps where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	public static void removeBybno(long bno) {
		getPersistence().removeBybno(bno);
	}

	/**
	 * Returns the number of reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching reps
	 */
	public static int countBybno(long bno) {
		return getPersistence().countBybno(bno);
	}

	/**
	 * Caches the rep in the entity cache if it is enabled.
	 *
	 * @param rep the rep
	 */
	public static void cacheResult(REP rep) {
		getPersistence().cacheResult(rep);
	}

	/**
	 * Caches the reps in the entity cache if it is enabled.
	 *
	 * @param reps the reps
	 */
	public static void cacheResult(List<REP> reps) {
		getPersistence().cacheResult(reps);
	}

	/**
	 * Creates a new rep with the primary key. Does not add the rep to the database.
	 *
	 * @param rno the primary key for the new rep
	 * @return the new rep
	 */
	public static REP create(long rno) {
		return getPersistence().create(rno);
	}

	/**
	 * Removes the rep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep that was removed
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public static REP remove(long rno)
		throws BoardService.exception.NoSuchREPException {

		return getPersistence().remove(rno);
	}

	public static REP updateImpl(REP rep) {
		return getPersistence().updateImpl(rep);
	}

	/**
	 * Returns the rep with the primary key or throws a <code>NoSuchREPException</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public static REP findByPrimaryKey(long rno)
		throws BoardService.exception.NoSuchREPException {

		return getPersistence().findByPrimaryKey(rno);
	}

	/**
	 * Returns the rep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep, or <code>null</code> if a rep with the primary key could not be found
	 */
	public static REP fetchByPrimaryKey(long rno) {
		return getPersistence().fetchByPrimaryKey(rno);
	}

	/**
	 * Returns all the reps.
	 *
	 * @return the reps
	 */
	public static List<REP> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the reps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @return the range of reps
	 */
	public static List<REP> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the reps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reps
	 */
	public static List<REP> findAll(
		int start, int end, OrderByComparator<REP> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>REPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reps
	 */
	public static List<REP> findAll(
		int start, int end, OrderByComparator<REP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the reps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of reps.
	 *
	 * @return the number of reps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static REPPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<REPPersistence, REPPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(REPPersistence.class);

		ServiceTracker<REPPersistence, REPPersistence> serviceTracker =
			new ServiceTracker<REPPersistence, REPPersistence>(
				bundle.getBundleContext(), REPPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}