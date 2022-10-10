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

import BoardService.model.TBL;

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
 * The persistence utility for the tbl service. This utility wraps <code>BoardService.service.persistence.impl.TBLPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TBLPersistence
 * @generated
 */
public class TBLUtil {

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
	public static void clearCache(TBL tbl) {
		getPersistence().clearCache(tbl);
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
	public static Map<Serializable, TBL> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TBL> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TBL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TBL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TBL update(TBL tbl) {
		return getPersistence().update(tbl);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TBL update(TBL tbl, ServiceContext serviceContext) {
		return getPersistence().update(tbl, serviceContext);
	}

	/**
	 * Returns all the tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the matching tbls
	 */
	public static List<TBL> findBysubject(String subject) {
		return getPersistence().findBysubject(subject);
	}

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
	public static List<TBL> findBysubject(String subject, int start, int end) {
		return getPersistence().findBysubject(subject, start, end);
	}

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
	public static List<TBL> findBysubject(
		String subject, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return getPersistence().findBysubject(
			subject, start, end, orderByComparator);
	}

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
	public static List<TBL> findBysubject(
		String subject, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBysubject(
			subject, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBysubject_First(
			String subject, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBysubject_First(subject, orderByComparator);
	}

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBysubject_First(
		String subject, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBysubject_First(
			subject, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBysubject_Last(
			String subject, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBysubject_Last(subject, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBysubject_Last(
		String subject, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBysubject_Last(subject, orderByComparator);
	}

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public static TBL[] findBysubject_PrevAndNext(
			long bno, String subject, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBysubject_PrevAndNext(
			bno, subject, orderByComparator);
	}

	/**
	 * Removes all the tbls where subject LIKE &#63; from the database.
	 *
	 * @param subject the subject
	 */
	public static void removeBysubject(String subject) {
		getPersistence().removeBysubject(subject);
	}

	/**
	 * Returns the number of tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the number of matching tbls
	 */
	public static int countBysubject(String subject) {
		return getPersistence().countBysubject(subject);
	}

	/**
	 * Returns all the tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the matching tbls
	 */
	public static List<TBL> findBywriter(String writer) {
		return getPersistence().findBywriter(writer);
	}

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
	public static List<TBL> findBywriter(String writer, int start, int end) {
		return getPersistence().findBywriter(writer, start, end);
	}

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
	public static List<TBL> findBywriter(
		String writer, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return getPersistence().findBywriter(
			writer, start, end, orderByComparator);
	}

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
	public static List<TBL> findBywriter(
		String writer, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBywriter(
			writer, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBywriter_First(
			String writer, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBywriter_First(writer, orderByComparator);
	}

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBywriter_First(
		String writer, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBywriter_First(writer, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBywriter_Last(
			String writer, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBywriter_Last(writer, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBywriter_Last(
		String writer, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBywriter_Last(writer, orderByComparator);
	}

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public static TBL[] findBywriter_PrevAndNext(
			long bno, String writer, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBywriter_PrevAndNext(
			bno, writer, orderByComparator);
	}

	/**
	 * Removes all the tbls where writer LIKE &#63; from the database.
	 *
	 * @param writer the writer
	 */
	public static void removeBywriter(String writer) {
		getPersistence().removeBywriter(writer);
	}

	/**
	 * Returns the number of tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching tbls
	 */
	public static int countBywriter(String writer) {
		return getPersistence().countBywriter(writer);
	}

	/**
	 * Returns all the tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the matching tbls
	 */
	public static List<TBL> findBycontents(String contents) {
		return getPersistence().findBycontents(contents);
	}

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
	public static List<TBL> findBycontents(
		String contents, int start, int end) {

		return getPersistence().findBycontents(contents, start, end);
	}

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
	public static List<TBL> findBycontents(
		String contents, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return getPersistence().findBycontents(
			contents, start, end, orderByComparator);
	}

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
	public static List<TBL> findBycontents(
		String contents, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycontents(
			contents, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBycontents_First(
			String contents, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBycontents_First(
			contents, orderByComparator);
	}

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBycontents_First(
		String contents, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBycontents_First(
			contents, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	public static TBL findBycontents_Last(
			String contents, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBycontents_Last(
			contents, orderByComparator);
	}

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	public static TBL fetchBycontents_Last(
		String contents, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().fetchBycontents_Last(
			contents, orderByComparator);
	}

	/**
	 * Returns the tbls before and after the current tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param bno the primary key of the current tbl
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public static TBL[] findBycontents_PrevAndNext(
			long bno, String contents, OrderByComparator<TBL> orderByComparator)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findBycontents_PrevAndNext(
			bno, contents, orderByComparator);
	}

	/**
	 * Removes all the tbls where contents LIKE &#63; from the database.
	 *
	 * @param contents the contents
	 */
	public static void removeBycontents(String contents) {
		getPersistence().removeBycontents(contents);
	}

	/**
	 * Returns the number of tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the number of matching tbls
	 */
	public static int countBycontents(String contents) {
		return getPersistence().countBycontents(contents);
	}

	/**
	 * Caches the tbl in the entity cache if it is enabled.
	 *
	 * @param tbl the tbl
	 */
	public static void cacheResult(TBL tbl) {
		getPersistence().cacheResult(tbl);
	}

	/**
	 * Caches the tbls in the entity cache if it is enabled.
	 *
	 * @param tbls the tbls
	 */
	public static void cacheResult(List<TBL> tbls) {
		getPersistence().cacheResult(tbls);
	}

	/**
	 * Creates a new tbl with the primary key. Does not add the tbl to the database.
	 *
	 * @param bno the primary key for the new tbl
	 * @return the new tbl
	 */
	public static TBL create(long bno) {
		return getPersistence().create(bno);
	}

	/**
	 * Removes the tbl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl that was removed
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public static TBL remove(long bno)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().remove(bno);
	}

	public static TBL updateImpl(TBL tbl) {
		return getPersistence().updateImpl(tbl);
	}

	/**
	 * Returns the tbl with the primary key or throws a <code>NoSuchTBLException</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	public static TBL findByPrimaryKey(long bno)
		throws BoardService.exception.NoSuchTBLException {

		return getPersistence().findByPrimaryKey(bno);
	}

	/**
	 * Returns the tbl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl, or <code>null</code> if a tbl with the primary key could not be found
	 */
	public static TBL fetchByPrimaryKey(long bno) {
		return getPersistence().fetchByPrimaryKey(bno);
	}

	/**
	 * Returns all the tbls.
	 *
	 * @return the tbls
	 */
	public static List<TBL> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TBL> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TBL> findAll(
		int start, int end, OrderByComparator<TBL> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TBL> findAll(
		int start, int end, OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tbls from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tbls.
	 *
	 * @return the number of tbls
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TBLPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TBLPersistence, TBLPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TBLPersistence.class);

		ServiceTracker<TBLPersistence, TBLPersistence> serviceTracker =
			new ServiceTracker<TBLPersistence, TBLPersistence>(
				bundle.getBundleContext(), TBLPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}