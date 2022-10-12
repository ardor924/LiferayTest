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
 * Provides a wrapper for {@link ADDFILELocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILELocalService
 * @generated
 */
public class ADDFILELocalServiceWrapper
	implements ADDFILELocalService, ServiceWrapper<ADDFILELocalService> {

	public ADDFILELocalServiceWrapper(ADDFILELocalService addfileLocalService) {
		_addfileLocalService = addfileLocalService;
	}

	/**
	 * Adds the addfile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ADDFILELocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addfile the addfile
	 * @return the addfile that was added
	 */
	@Override
	public BoardService.model.ADDFILE addADDFILE(
		BoardService.model.ADDFILE addfile) {

		return _addfileLocalService.addADDFILE(addfile);
	}

	@Override
	public BoardService.model.ADDFILE addADDFILEWithIncrement(
		BoardService.model.ADDFILE addFile) {

		return _addfileLocalService.addADDFILEWithIncrement(addFile);
	}

	/**
	 * Creates a new addfile with the primary key. Does not add the addfile to the database.
	 *
	 * @param fno the primary key for the new addfile
	 * @return the new addfile
	 */
	@Override
	public BoardService.model.ADDFILE createADDFILE(long fno) {
		return _addfileLocalService.createADDFILE(fno);
	}

	/**
	 * Deletes the addfile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ADDFILELocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addfile the addfile
	 * @return the addfile that was removed
	 */
	@Override
	public BoardService.model.ADDFILE deleteADDFILE(
		BoardService.model.ADDFILE addfile) {

		return _addfileLocalService.deleteADDFILE(addfile);
	}

	/**
	 * Deletes the addfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ADDFILELocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile that was removed
	 * @throws PortalException if a addfile with the primary key could not be found
	 */
	@Override
	public BoardService.model.ADDFILE deleteADDFILE(long fno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addfileLocalService.deleteADDFILE(fno);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addfileLocalService.dynamicQuery();
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

		return _addfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.ADDFILEModelImpl</code>.
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

		return _addfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.ADDFILEModelImpl</code>.
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

		return _addfileLocalService.dynamicQuery(
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

		return _addfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _addfileLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public BoardService.model.ADDFILE fetchADDFILE(long fno) {
		return _addfileLocalService.fetchADDFILE(fno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _addfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the addfile with the primary key.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile
	 * @throws PortalException if a addfile with the primary key could not be found
	 */
	@Override
	public BoardService.model.ADDFILE getADDFILE(long fno)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addfileLocalService.getADDFILE(fno);
	}

	/**
	 * Returns a range of all the addfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardService.model.impl.ADDFILEModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addfiles
	 * @param end the upper bound of the range of addfiles (not inclusive)
	 * @return the range of addfiles
	 */
	@Override
	public java.util.List<BoardService.model.ADDFILE> getADDFILEs(
		int start, int end) {

		return _addfileLocalService.getADDFILEs(start, end);
	}

	/**
	 * Returns the number of addfiles.
	 *
	 * @return the number of addfiles
	 */
	@Override
	public int getADDFILEsCount() {
		return _addfileLocalService.getADDFILEsCount();
	}

	@Override
	public java.util.List<BoardService.model.ADDFILE> getfileListBybno(
		long bno) {

		return _addfileLocalService.getfileListBybno(bno);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _addfileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the addfile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ADDFILELocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addfile the addfile
	 * @return the addfile that was updated
	 */
	@Override
	public BoardService.model.ADDFILE updateADDFILE(
		BoardService.model.ADDFILE addfile) {

		return _addfileLocalService.updateADDFILE(addfile);
	}

	@Override
	public ADDFILELocalService getWrappedService() {
		return _addfileLocalService;
	}

	@Override
	public void setWrappedService(ADDFILELocalService addfileLocalService) {
		_addfileLocalService = addfileLocalService;
	}

	private ADDFILELocalService _addfileLocalService;

}