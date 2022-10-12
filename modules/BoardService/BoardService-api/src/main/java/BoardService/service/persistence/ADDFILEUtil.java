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

import BoardService.model.ADDFILE;

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
 * The persistence utility for the addfile service. This utility wraps <code>BoardService.service.persistence.impl.ADDFILEPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILEPersistence
 * @generated
 */
public class ADDFILEUtil {

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
	public static void clearCache(ADDFILE addfile) {
		getPersistence().clearCache(addfile);
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
	public static Map<Serializable, ADDFILE> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ADDFILE> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ADDFILE> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ADDFILE> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ADDFILE> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ADDFILE update(ADDFILE addfile) {
		return getPersistence().update(addfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ADDFILE update(
		ADDFILE addfile, ServiceContext serviceContext) {

		return getPersistence().update(addfile, serviceContext);
	}

	/**
	 * Returns all the addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching addfiles
	 */
	public static List<ADDFILE> findBybno(long bno) {
		return getPersistence().findBybno(bno);
	}

	/**
	 * Returns a range of all the addfiles where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @return the range of matching addfiles
	 */
	public static List<ADDFILE> findBybno(long bno, int start, int end) {
		return getPersistence().findBybno(bno, start, end);
	}

	/**
	 * Returns an ordered range of all the addfiles where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addfiles
	 */
	public static List<ADDFILE> findBybno(
		long bno, int start, int end,
		OrderByComparator<ADDFILE> orderByComparator) {

		return getPersistence().findBybno(bno, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addfiles where bno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param bno the bno
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addfiles
	 */
	public static List<ADDFILE> findBybno(
		long bno, int start, int end,
		OrderByComparator<ADDFILE> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBybno(
			bno, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	public static ADDFILE findBybno_First(
			long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws BoardService.exception.NoSuchADDFILEException {

		return getPersistence().findBybno_First(bno, orderByComparator);
	}

	/**
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	public static ADDFILE fetchBybno_First(
		long bno, OrderByComparator<ADDFILE> orderByComparator) {

		return getPersistence().fetchBybno_First(bno, orderByComparator);
	}

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	public static ADDFILE findBybno_Last(
			long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws BoardService.exception.NoSuchADDFILEException {

		return getPersistence().findBybno_Last(bno, orderByComparator);
	}

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	public static ADDFILE fetchBybno_Last(
		long bno, OrderByComparator<ADDFILE> orderByComparator) {

		return getPersistence().fetchBybno_Last(bno, orderByComparator);
	}

	/**
	 * Returns the addfiles before and after the current addfile in the ordered set where bno = &#63;.
	 *
	 * @param fno the primary key of the current addfile
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public static ADDFILE[] findBybno_PrevAndNext(
			long fno, long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws BoardService.exception.NoSuchADDFILEException {

		return getPersistence().findBybno_PrevAndNext(
			fno, bno, orderByComparator);
	}

	/**
	 * Removes all the addfiles where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	public static void removeBybno(long bno) {
		getPersistence().removeBybno(bno);
	}

	/**
	 * Returns the number of addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching addfiles
	 */
	public static int countBybno(long bno) {
		return getPersistence().countBybno(bno);
	}

	/**
	 * Caches the addfile in the entity cache if it is enabled.
	 *
	 * @param addfile the addfile
	 */
	public static void cacheResult(ADDFILE addfile) {
		getPersistence().cacheResult(addfile);
	}

	/**
	 * Caches the addfiles in the entity cache if it is enabled.
	 *
	 * @param addfiles the addfiles
	 */
	public static void cacheResult(List<ADDFILE> addfiles) {
		getPersistence().cacheResult(addfiles);
	}

	/**
	 * Creates a new addfile with the primary key. Does not add the addfile to the database.
	 *
	 * @param fno the primary key for the new addfile
	 * @return the new addfile
	 */
	public static ADDFILE create(long fno) {
		return getPersistence().create(fno);
	}

	/**
	 * Removes the addfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile that was removed
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public static ADDFILE remove(long fno)
		throws BoardService.exception.NoSuchADDFILEException {

		return getPersistence().remove(fno);
	}

	public static ADDFILE updateImpl(ADDFILE addfile) {
		return getPersistence().updateImpl(addfile);
	}

	/**
	 * Returns the addfile with the primary key or throws a <code>NoSuchADDFILEException</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public static ADDFILE findByPrimaryKey(long fno)
		throws BoardService.exception.NoSuchADDFILEException {

		return getPersistence().findByPrimaryKey(fno);
	}

	/**
	 * Returns the addfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile, or <code>null</code> if a addfile with the primary key could not be found
	 */
	public static ADDFILE fetchByPrimaryKey(long fno) {
		return getPersistence().fetchByPrimaryKey(fno);
	}

	/**
	 * Returns all the addfiles.
	 *
	 * @return the addfiles
	 */
	public static List<ADDFILE> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the addfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @return the range of addfiles
	 */
	public static List<ADDFILE> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the addfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addfiles
	 */
	public static List<ADDFILE> findAll(
		int start, int end, OrderByComparator<ADDFILE> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addfiles
	 */
	public static List<ADDFILE> findAll(
		int start, int end, OrderByComparator<ADDFILE> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the addfiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of addfiles.
	 *
	 * @return the number of addfiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ADDFILEPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ADDFILEPersistence, ADDFILEPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ADDFILEPersistence.class);

		ServiceTracker<ADDFILEPersistence, ADDFILEPersistence> serviceTracker =
			new ServiceTracker<ADDFILEPersistence, ADDFILEPersistence>(
				bundle.getBundleContext(), ADDFILEPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}