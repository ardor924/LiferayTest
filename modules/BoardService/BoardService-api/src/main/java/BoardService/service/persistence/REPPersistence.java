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

import BoardService.exception.NoSuchREPException;

import BoardService.model.REP;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see REPUtil
 * @generated
 */
@ProviderType
public interface REPPersistence extends BasePersistence<REP> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link REPUtil} to access the rep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching reps
	 */
	public java.util.List<REP> findBybno(long bno);

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
	public java.util.List<REP> findBybno(long bno, int start, int end);

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
	public java.util.List<REP> findBybno(
		long bno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<REP>
			orderByComparator);

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
	public java.util.List<REP> findBybno(
		long bno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<REP> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	public REP findBybno_First(
			long bno,
			com.liferay.portal.kernel.util.OrderByComparator<REP>
				orderByComparator)
		throws NoSuchREPException;

	/**
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep, or <code>null</code> if a matching rep could not be found
	 */
	public REP fetchBybno_First(
		long bno,
		com.liferay.portal.kernel.util.OrderByComparator<REP>
			orderByComparator);

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	public REP findBybno_Last(
			long bno,
			com.liferay.portal.kernel.util.OrderByComparator<REP>
				orderByComparator)
		throws NoSuchREPException;

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep, or <code>null</code> if a matching rep could not be found
	 */
	public REP fetchBybno_Last(
		long bno,
		com.liferay.portal.kernel.util.OrderByComparator<REP>
			orderByComparator);

	/**
	 * Returns the reps before and after the current rep in the ordered set where bno = &#63;.
	 *
	 * @param rno the primary key of the current rep
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public REP[] findBybno_PrevAndNext(
			long rno, long bno,
			com.liferay.portal.kernel.util.OrderByComparator<REP>
				orderByComparator)
		throws NoSuchREPException;

	/**
	 * Removes all the reps where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	public void removeBybno(long bno);

	/**
	 * Returns the number of reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching reps
	 */
	public int countBybno(long bno);

	/**
	 * Caches the rep in the entity cache if it is enabled.
	 *
	 * @param rep the rep
	 */
	public void cacheResult(REP rep);

	/**
	 * Caches the reps in the entity cache if it is enabled.
	 *
	 * @param reps the reps
	 */
	public void cacheResult(java.util.List<REP> reps);

	/**
	 * Creates a new rep with the primary key. Does not add the rep to the database.
	 *
	 * @param rno the primary key for the new rep
	 * @return the new rep
	 */
	public REP create(long rno);

	/**
	 * Removes the rep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep that was removed
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public REP remove(long rno) throws NoSuchREPException;

	public REP updateImpl(REP rep);

	/**
	 * Returns the rep with the primary key or throws a <code>NoSuchREPException</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	public REP findByPrimaryKey(long rno) throws NoSuchREPException;

	/**
	 * Returns the rep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep, or <code>null</code> if a rep with the primary key could not be found
	 */
	public REP fetchByPrimaryKey(long rno);

	/**
	 * Returns all the reps.
	 *
	 * @return the reps
	 */
	public java.util.List<REP> findAll();

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
	public java.util.List<REP> findAll(int start, int end);

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
	public java.util.List<REP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<REP>
			orderByComparator);

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
	public java.util.List<REP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<REP> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the reps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of reps.
	 *
	 * @return the number of reps
	 */
	public int countAll();

}