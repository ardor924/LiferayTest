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
 * Provides a wrapper for {@link REPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see REPLocalService
 * @generated
 */
public class REPLocalServiceWrapper
	implements REPLocalService, ServiceWrapper<REPLocalService> {

	public REPLocalServiceWrapper(REPLocalService repLocalService) {
		_repLocalService = repLocalService;
	}

	/**
	 * Adds the rep to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect REPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rep the rep
	 * @return the rep that was added
	 */
	@Override
	public BoardService.model.REP addREP(BoardService.model.REP rep) {
		return _repLocalService.addREP(rep);
	}

	/**
	 * Creates a new rep with the primary key. Does not add the rep to the database.
	 *
	 * @param rno the primary key for the new rep
	 * @return the new rep
	 */
	@Override
	public BoardService.model.REP createREP(long rno) {
		return _repLocalService.createREP(rno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _repLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect REPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rno the primary key of the rep
	 * @return the rep that was removed
	 * @throws PortalException if a rep with the primary key could not be found
	 */
	@Override
	public BoardService.model.REP deleteREP(long rno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _repLocalService.deleteREP(rno);
	}

	/**
	 * Deletes the rep from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect REPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rep the rep
	 * @return the rep that was removed
	 */
	@Override
	public BoardService.model.REP deleteREP(BoardService.model.REP rep) {
		return _repLocalService.deleteREP(rep);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _repLocalService.dynamicQuery();
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

		return _repLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.REPModelImpl</code>.
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

		return _repLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.REPModelImpl</code>.
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

		return _repLocalService.dynamicQuery(
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

		return _repLocalService.dynamicQueryCount(dynamicQuery);
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

		return _repLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public BoardService.model.REP fetchREP(long rno) {
		return _repLocalService.fetchREP(rno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _repLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _repLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _repLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _repLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rep with the primary key.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep
	 * @throws PortalException if a rep with the primary key could not be found
	 */
	@Override
	public BoardService.model.REP getREP(long rno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _repLocalService.getREP(rno);
	}

	@Override
	public java.util.List<BoardService.model.REP> getREPListBybno(
		long bno, int page) {

		return _repLocalService.getREPListBybno(bno, page);
	}

	/**
	 * Returns a range of all the reps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.REPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reps
	 * @param end the upper bound of the range of reps (not inclusive)
	 * @return the range of reps
	 */
	@Override
	public java.util.List<BoardService.model.REP> getREPs(int start, int end) {
		return _repLocalService.getREPs(start, end);
	}

	/**
	 * Returns the number of reps.
	 *
	 * @return the number of reps
	 */
	@Override
	public int getREPsCount() {
		return _repLocalService.getREPsCount();
	}

	/**
	 * Updates the rep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect REPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rep the rep
	 * @return the rep that was updated
	 */
	@Override
	public BoardService.model.REP updateREP(BoardService.model.REP rep) {
		return _repLocalService.updateREP(rep);
	}

	@Override
	public REPLocalService getWrappedService() {
		return _repLocalService;
	}

	@Override
	public void setWrappedService(REPLocalService repLocalService) {
		_repLocalService = repLocalService;
	}

	private REPLocalService _repLocalService;

}