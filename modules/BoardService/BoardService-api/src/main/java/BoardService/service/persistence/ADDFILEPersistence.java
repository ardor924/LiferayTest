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

import BoardService.exception.NoSuchADDFILEException;

import BoardService.model.ADDFILE;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the addfile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILEUtil
 * @generated
 */
@ProviderType
public interface ADDFILEPersistence extends BasePersistence<ADDFILE> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ADDFILEUtil} to access the addfile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching addfiles
	 */
	public java.util.List<ADDFILE> findBybno(long bno);

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
	public java.util.List<ADDFILE> findBybno(long bno, int start, int end);

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
	public java.util.List<ADDFILE> findBybno(
		long bno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator);

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
	public java.util.List<ADDFILE> findBybno(
		long bno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	public ADDFILE findBybno_First(
			long bno,
			com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
				orderByComparator)
		throws NoSuchADDFILEException;

	/**
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	public ADDFILE fetchBybno_First(
		long bno,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator);

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	public ADDFILE findBybno_Last(
			long bno,
			com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
				orderByComparator)
		throws NoSuchADDFILEException;

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	public ADDFILE fetchBybno_Last(
		long bno,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator);

	/**
	 * Returns the addfiles before and after the current addfile in the ordered set where bno = &#63;.
	 *
	 * @param fno the primary key of the current addfile
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public ADDFILE[] findBybno_PrevAndNext(
			long fno, long bno,
			com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
				orderByComparator)
		throws NoSuchADDFILEException;

	/**
	 * Removes all the addfiles where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	public void removeBybno(long bno);

	/**
	 * Returns the number of addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching addfiles
	 */
	public int countBybno(long bno);

	/**
	 * Caches the addfile in the entity cache if it is enabled.
	 *
	 * @param addfile the addfile
	 */
	public void cacheResult(ADDFILE addfile);

	/**
	 * Caches the addfiles in the entity cache if it is enabled.
	 *
	 * @param addfiles the addfiles
	 */
	public void cacheResult(java.util.List<ADDFILE> addfiles);

	/**
	 * Creates a new addfile with the primary key. Does not add the addfile to the database.
	 *
	 * @param fno the primary key for the new addfile
	 * @return the new addfile
	 */
	public ADDFILE create(long fno);

	/**
	 * Removes the addfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile that was removed
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public ADDFILE remove(long fno) throws NoSuchADDFILEException;

	public ADDFILE updateImpl(ADDFILE addfile);

	/**
	 * Returns the addfile with the primary key or throws a <code>NoSuchADDFILEException</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	public ADDFILE findByPrimaryKey(long fno) throws NoSuchADDFILEException;

	/**
	 * Returns the addfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile, or <code>null</code> if a addfile with the primary key could not be found
	 */
	public ADDFILE fetchByPrimaryKey(long fno);

	/**
	 * Returns all the addfiles.
	 *
	 * @return the addfiles
	 */
	public java.util.List<ADDFILE> findAll();

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
	public java.util.List<ADDFILE> findAll(int start, int end);

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
	public java.util.List<ADDFILE> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator);

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
	public java.util.List<ADDFILE> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ADDFILE>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the addfiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of addfiles.
	 *
	 * @return the number of addfiles
	 */
	public int countAll();

}