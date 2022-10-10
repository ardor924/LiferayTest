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

import BoardService.exception.NoSuchTBLException;

import BoardService.model.TBL;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tbl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TBLUtil
 * @generated
 */
@ProviderType
public interface TBLPersistence extends BasePersistence<TBL> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TBLUtil} to access the tbl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the matching tbls
	 */
	public java.util.List<TBL> findBysubject(String subject);

	/**
	 * Returns a range of all the tbls where subject LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param subject the subject
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @return the range of matching tbls
	 */
	public java.util.List<TBL> findBysubject(
		String subject, int start, int end);

	/**
	 * Returns an ordered range of all the tbls where subject LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param subject the subject
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBysubject(
		String subject, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tbls where subject LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param subject the subject
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBysubject(
		String subject, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBysubject_First(
			String subject,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBysubject_First(
		String subject,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBysubject_Last(
			String subject,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBysubject_Last(
		String subject,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public TBL[] findBysubject_PrevAndNext(
			long bno, String subject,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Removes all the tbls where subject LIKE &#63; from the database.
	 *
	 * @param subject the subject
	 */
	public void removeBysubject(String subject);

	/**
	 * Returns the number of tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the number of matching tbls
	 */
	public int countBysubject(String subject);

	/**
	 * Returns all the tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the matching tbls
	 */
	public java.util.List<TBL> findBywriter(String writer);

	/**
	 * Returns a range of all the tbls where writer LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @return the range of matching tbls
	 */
	public java.util.List<TBL> findBywriter(String writer, int start, int end);

	/**
	 * Returns an ordered range of all the tbls where writer LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBywriter(
		String writer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tbls where writer LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBywriter(
		String writer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBywriter_First(
			String writer,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBywriter_First(
		String writer,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBywriter_Last(
			String writer,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBywriter_Last(
		String writer,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public TBL[] findBywriter_PrevAndNext(
			long bno, String writer,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Removes all the tbls where writer LIKE &#63; from the database.
	 *
	 * @param writer the writer
	 */
	public void removeBywriter(String writer);

	/**
	 * Returns the number of tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching tbls
	 */
	public int countBywriter(String writer);

	/**
	 * Returns all the tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the matching tbls
	 */
	public java.util.List<TBL> findBycontents(String contents);

	/**
	 * Returns a range of all the tbls where contents LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param contents the contents
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @return the range of matching tbls
	 */
	public java.util.List<TBL> findBycontents(
		String contents, int start, int end);

	/**
	 * Returns an ordered range of all the tbls where contents LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param contents the contents
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBycontents(
		String contents, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tbls where contents LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param contents the contents
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tbls
	 */
	public java.util.List<TBL> findBycontents(
		String contents, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBycontents_First(
			String contents,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBycontents_First(
		String contents,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public TBL findBycontents_Last(
			String contents,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public TBL fetchBycontents_Last(
		String contents,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public TBL[] findBycontents_PrevAndNext(
			long bno, String contents,
			com.liferay.portal.kernel.util.OrderByComparator<TBL>
				orderByComparator)
		throws NoSuchTBLException;

	/**
	 * Removes all the tbls where contents LIKE &#63; from the database.
	 *
	 * @param contents the contents
	 */
	public void removeBycontents(String contents);

	/**
	 * Returns the number of tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the number of matching tbls
	 */
	public int countBycontents(String contents);

	/**
	 * Caches the tbl in the entity cache if it is enabled.
	 *
	 * @param tbl the tbl
	 */
	public void cacheResult(TBL tbl);

	/**
	 * Caches the tbls in the entity cache if it is enabled.
	 *
	 * @param tbls the tbls
	 */
	public void cacheResult(java.util.List<TBL> tbls);

	/**
	 * Creates a new tbl with the primary key. Does not add the tbl to the database.
	 *
	 * @param bno the primary key for the new tbl
	 * @return the new tbl
	 */
	public TBL create(long bno);

	/**
	 * Removes the tbl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl that was removed
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public TBL remove(long bno) throws NoSuchTBLException;

	public TBL updateImpl(TBL tbl);

	/**
	 * Returns the tbl with the primary key or throws a <code>NoSuchTBLException</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public TBL findByPrimaryKey(long bno) throws NoSuchTBLException;

	/**
	 * Returns the tbl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl, or <code>null</code> if a tbl with the primary key could not be found
	 */
	public TBL fetchByPrimaryKey(long bno);

	/**
	 * Returns all the tbls.
	 *
	 * @return the tbls
	 */
	public java.util.List<TBL> findAll();

	/**
	 * Returns a range of all the tbls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @return the range of tbls
	 */
	public java.util.List<TBL> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tbls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tbls
	 */
	public java.util.List<TBL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tbls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TBLModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tbls
	 * @param end the upper bound of the range of tbls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tbls
	 */
	public java.util.List<TBL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tbls from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tbls.
	 *
	 * @return the number of tbls
	 */
	public int countAll();

}