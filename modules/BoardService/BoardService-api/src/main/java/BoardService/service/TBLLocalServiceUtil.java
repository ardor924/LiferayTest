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

package BoardService.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TBL. This utility wraps
 * <code>BoardService.service.impl.TBLLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TBLLocalService
 * @generated
 */
public class TBLLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>BoardService.service.impl.TBLLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean addHitTBL(long bno) {
		return getService().addHitTBL(bno);
	}

	/**
	 * Adds the tbl to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TBLLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tbl the tbl
	 * @return the tbl that was added
	 */
	public static BoardService.model.TBL addTBL(BoardService.model.TBL tbl) {
		return getService().addTBL(tbl);
	}

	/**
	 * Creates a new tbl with the primary key. Does not add the tbl to the database.
	 *
	 * @param bno the primary key for the new tbl
	 * @return the new tbl
	 */
	public static BoardService.model.TBL createTBL(long bno) {
		return getService().createTBL(bno);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tbl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TBLLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl that was removed
	 * @throws PortalException if a tbl with the primary key could not be found
	 */
	public static BoardService.model.TBL deleteTBL(long bno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTBL(bno);
	}

	/**
	 * Deletes the tbl from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TBLLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tbl the tbl
	 * @return the tbl that was removed
	 */
	public static BoardService.model.TBL deleteTBL(BoardService.model.TBL tbl) {
		return getService().deleteTBL(tbl);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.TBLModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.TBLModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static BoardService.model.TBL fetchTBL(long bno) {
		return getService().fetchTBL(bno);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tbl with the primary key.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl
	 * @throws PortalException if a tbl with the primary key could not be found
	 */
	public static BoardService.model.TBL getTBL(long bno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTBL(bno);
	}

	public static java.util.List<BoardService.model.TBL> getTBLListByContents(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return getService().getTBLListByContents(
			searchKeyword, cntPerPage, initRowNumber);
	}

	public static java.util.List<BoardService.model.TBL> getTBLListBySearch(
		String searchKeyword, String option, int cntPerPage,
		int initRowNumber) {

		return getService().getTBLListBySearch(
			searchKeyword, option, cntPerPage, initRowNumber);
	}

	public static java.util.List<BoardService.model.TBL> getTBLListBySuebject(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return getService().getTBLListBySuebject(
			searchKeyword, cntPerPage, initRowNumber);
	}

	public static java.util.List<BoardService.model.TBL> getTBLListByWriter(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return getService().getTBLListByWriter(
			searchKeyword, cntPerPage, initRowNumber);
	}

	public static java.util.List<BoardService.model.TBL> getTBLListTotalCnt(
		String searchKeyword, String option) {

		return getService().getTBLListTotalCnt(searchKeyword, option);
	}

	/**
	 * Returns a range of all the tbls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.TBLModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @return the range of tbls
	 */
	public static java.util.List<BoardService.model.TBL> getTBLs(
		int start, int end) {

		return getService().getTBLs(start, end);
	}

	/**
	 * Returns the number of tbls.
	 *
	 * @return the number of tbls
	 */
	public static int getTBLsCount() {
		return getService().getTBLsCount();
	}

	/**
	 * Updates the tbl in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TBLLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tbl the tbl
	 * @return the tbl that was updated
	 */
	public static BoardService.model.TBL updateTBL(BoardService.model.TBL tbl) {
		return getService().updateTBL(tbl);
	}

	public static TBLLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TBLLocalService, TBLLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TBLLocalService.class);

		ServiceTracker<TBLLocalService, TBLLocalService> serviceTracker =
			new ServiceTracker<TBLLocalService, TBLLocalService>(
				bundle.getBundleContext(), TBLLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}