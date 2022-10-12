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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TBLLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TBLLocalService
 * @generated
 */
public class TBLLocalServiceWrapper
	implements ServiceWrapper<TBLLocalService>, TBLLocalService {

	public TBLLocalServiceWrapper(TBLLocalService tblLocalService) {
		_tblLocalService = tblLocalService;
	}

	@Override
	public boolean addHitTBL(long bno) {
		return _tblLocalService.addHitTBL(bno);
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
	@Override
	public BoardService.model.TBL addTBL(BoardService.model.TBL tbl) {
		return _tblLocalService.addTBL(tbl);
	}

	@Override
	public BoardService.model.TBL addTblWithIncrement(
		BoardService.model.TBL tbl) {

		return _tblLocalService.addTblWithIncrement(tbl);
	}

	/**
	 * Creates a new tbl with the primary key. Does not add the tbl to the database.
	 *
	 * @param bno the primary key for the new tbl
	 * @return the new tbl
	 */
	@Override
	public BoardService.model.TBL createTBL(long bno) {
		return _tblLocalService.createTBL(bno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tblLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public BoardService.model.TBL deleteTBL(long bno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tblLocalService.deleteTBL(bno);
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
	@Override
	public BoardService.model.TBL deleteTBL(BoardService.model.TBL tbl) {
		return _tblLocalService.deleteTBL(tbl);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tblLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tblLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tblLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tblLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tblLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tblLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public BoardService.model.TBL fetchTBL(long bno) {
		return _tblLocalService.fetchTBL(bno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tblLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tblLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tblLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tblLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tbl with the primary key.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl
	 * @throws PortalException if a tbl with the primary key could not be found
	 */
	@Override
	public BoardService.model.TBL getTBL(long bno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tblLocalService.getTBL(bno);
	}

	@Override
	public java.util.List<BoardService.model.TBL> getTBLListByContents(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return _tblLocalService.getTBLListByContents(
			searchKeyword, cntPerPage, initRowNumber);
	}

	@Override
	public java.util.List<BoardService.model.TBL> getTBLListBySearch(
		String searchKeyword, String option, int cntPerPage,
		int initRowNumber) {

		return _tblLocalService.getTBLListBySearch(
			searchKeyword, option, cntPerPage, initRowNumber);
	}

	@Override
	public java.util.List<BoardService.model.TBL> getTBLListBySuebject(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return _tblLocalService.getTBLListBySuebject(
			searchKeyword, cntPerPage, initRowNumber);
	}

	@Override
	public java.util.List<BoardService.model.TBL> getTBLListByWriter(
		String searchKeyword, int cntPerPage, int initRowNumber) {

		return _tblLocalService.getTBLListByWriter(
			searchKeyword, cntPerPage, initRowNumber);
	}

	@Override
	public java.util.List<BoardService.model.TBL> getTBLListTotalCnt(
		String searchKeyword, String option) {

		return _tblLocalService.getTBLListTotalCnt(searchKeyword, option);
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
	@Override
	public java.util.List<BoardService.model.TBL> getTBLs(int start, int end) {
		return _tblLocalService.getTBLs(start, end);
	}

	/**
	 * Returns the number of tbls.
	 *
	 * @return the number of tbls
	 */
	@Override
	public int getTBLsCount() {
		return _tblLocalService.getTBLsCount();
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
	@Override
	public BoardService.model.TBL updateTBL(BoardService.model.TBL tbl) {
		return _tblLocalService.updateTBL(tbl);
	}

	@Override
	public BoardService.model.TBL updateTblWithTbl(BoardService.model.TBL tbl) {
		return _tblLocalService.updateTblWithTbl(tbl);
	}

	@Override
	public TBLLocalService getWrappedService() {
		return _tblLocalService;
	}

	@Override
	public void setWrappedService(TBLLocalService tblLocalService) {
		_tblLocalService = tblLocalService;
	}

	private TBLLocalService _tblLocalService;

}