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

package BoardService.service.persistence.impl;

import BoardService.exception.NoSuchTBLException;

import BoardService.model.TBL;
import BoardService.model.impl.TBLImpl;
import BoardService.model.impl.TBLModelImpl;

import BoardService.service.persistence.TBLPersistence;
import BoardService.service.persistence.impl.constants.HHL_PROJECTPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the tbl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TBLPersistence.class)
public class TBLPersistenceImpl
	extends BasePersistenceImpl<TBL> implements TBLPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TBLUtil</code> to access the tbl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TBLImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysubject;
	private FinderPath _finderPathWithPaginationCountBysubject;

	/**
	 * Returns all the tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the matching tbls
	 */
	@Override
	public List<TBL> findBysubject(String subject) {
		return findBysubject(
			subject, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TBL> findBysubject(String subject, int start, int end) {
		return findBysubject(subject, start, end, null);
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
	@Override
	public List<TBL> findBysubject(
		String subject, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return findBysubject(subject, start, end, orderByComparator, true);
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
	@Override
	public List<TBL> findBysubject(
		String subject, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		subject = Objects.toString(subject, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBysubject;
		finderArgs = new Object[] {subject, start, end, orderByComparator};

		List<TBL> list = null;

		if (useFinderCache) {
			list = (List<TBL>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TBL tbl : list) {
					if (!StringUtil.wildcardMatches(
							tbl.getSubject(), subject, '_', '%', '\\', true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TBL_WHERE);

			boolean bindSubject = false;

			if (subject.isEmpty()) {
				sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
			}
			else {
				bindSubject = true;

				sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TBLModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubject) {
					queryPos.add(subject);
				}

				list = (List<TBL>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBysubject_First(
			String subject, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBysubject_First(subject, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectLIKE");
		sb.append(subject);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the first tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBysubject_First(
		String subject, OrderByComparator<TBL> orderByComparator) {

		List<TBL> list = findBysubject(subject, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBysubject_Last(
			String subject, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBysubject_Last(subject, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectLIKE");
		sb.append(subject);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the last tbl in the ordered set where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBysubject_Last(
		String subject, OrderByComparator<TBL> orderByComparator) {

		int count = countBysubject(subject);

		if (count == 0) {
			return null;
		}

		List<TBL> list = findBysubject(
			subject, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TBL[] findBysubject_PrevAndNext(
			long bno, String subject, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		subject = Objects.toString(subject, "");

		TBL tbl = findByPrimaryKey(bno);

		Session session = null;

		try {
			session = openSession();

			TBL[] array = new TBLImpl[3];

			array[0] = getBysubject_PrevAndNext(
				session, tbl, subject, orderByComparator, true);

			array[1] = tbl;

			array[2] = getBysubject_PrevAndNext(
				session, tbl, subject, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TBL getBysubject_PrevAndNext(
		Session session, TBL tbl, String subject,
		OrderByComparator<TBL> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TBL_WHERE);

		boolean bindSubject = false;

		if (subject.isEmpty()) {
			sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
		}
		else {
			bindSubject = true;

			sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TBLModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSubject) {
			queryPos.add(subject);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tbl)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TBL> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tbls where subject LIKE &#63; from the database.
	 *
	 * @param subject the subject
	 */
	@Override
	public void removeBysubject(String subject) {
		for (TBL tbl :
				findBysubject(
					subject, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tbl);
		}
	}

	/**
	 * Returns the number of tbls where subject LIKE &#63;.
	 *
	 * @param subject the subject
	 * @return the number of matching tbls
	 */
	@Override
	public int countBysubject(String subject) {
		subject = Objects.toString(subject, "");

		FinderPath finderPath = _finderPathWithPaginationCountBysubject;

		Object[] finderArgs = new Object[] {subject};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TBL_WHERE);

			boolean bindSubject = false;

			if (subject.isEmpty()) {
				sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
			}
			else {
				bindSubject = true;

				sb.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubject) {
					queryPos.add(subject);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SUBJECT_SUBJECT_2 =
		"tbl.subject LIKE ?";

	private static final String _FINDER_COLUMN_SUBJECT_SUBJECT_3 =
		"(tbl.subject IS NULL OR tbl.subject LIKE '')";

	private FinderPath _finderPathWithPaginationFindBywriter;
	private FinderPath _finderPathWithPaginationCountBywriter;

	/**
	 * Returns all the tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the matching tbls
	 */
	@Override
	public List<TBL> findBywriter(String writer) {
		return findBywriter(writer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TBL> findBywriter(String writer, int start, int end) {
		return findBywriter(writer, start, end, null);
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
	@Override
	public List<TBL> findBywriter(
		String writer, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return findBywriter(writer, start, end, orderByComparator, true);
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
	@Override
	public List<TBL> findBywriter(
		String writer, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		writer = Objects.toString(writer, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBywriter;
		finderArgs = new Object[] {writer, start, end, orderByComparator};

		List<TBL> list = null;

		if (useFinderCache) {
			list = (List<TBL>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TBL tbl : list) {
					if (!StringUtil.wildcardMatches(
							tbl.getWriter(), writer, '_', '%', '\\', true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TBL_WHERE);

			boolean bindWriter = false;

			if (writer.isEmpty()) {
				sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
			}
			else {
				bindWriter = true;

				sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TBLModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWriter) {
					queryPos.add(writer);
				}

				list = (List<TBL>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBywriter_First(
			String writer, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBywriter_First(writer, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("writerLIKE");
		sb.append(writer);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the first tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBywriter_First(
		String writer, OrderByComparator<TBL> orderByComparator) {

		List<TBL> list = findBywriter(writer, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBywriter_Last(
			String writer, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBywriter_Last(writer, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("writerLIKE");
		sb.append(writer);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the last tbl in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBywriter_Last(
		String writer, OrderByComparator<TBL> orderByComparator) {

		int count = countBywriter(writer);

		if (count == 0) {
			return null;
		}

		List<TBL> list = findBywriter(
			writer, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TBL[] findBywriter_PrevAndNext(
			long bno, String writer, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		writer = Objects.toString(writer, "");

		TBL tbl = findByPrimaryKey(bno);

		Session session = null;

		try {
			session = openSession();

			TBL[] array = new TBLImpl[3];

			array[0] = getBywriter_PrevAndNext(
				session, tbl, writer, orderByComparator, true);

			array[1] = tbl;

			array[2] = getBywriter_PrevAndNext(
				session, tbl, writer, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TBL getBywriter_PrevAndNext(
		Session session, TBL tbl, String writer,
		OrderByComparator<TBL> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TBL_WHERE);

		boolean bindWriter = false;

		if (writer.isEmpty()) {
			sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
		}
		else {
			bindWriter = true;

			sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TBLModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWriter) {
			queryPos.add(writer);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tbl)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TBL> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tbls where writer LIKE &#63; from the database.
	 *
	 * @param writer the writer
	 */
	@Override
	public void removeBywriter(String writer) {
		for (TBL tbl :
				findBywriter(
					writer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tbl);
		}
	}

	/**
	 * Returns the number of tbls where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching tbls
	 */
	@Override
	public int countBywriter(String writer) {
		writer = Objects.toString(writer, "");

		FinderPath finderPath = _finderPathWithPaginationCountBywriter;

		Object[] finderArgs = new Object[] {writer};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TBL_WHERE);

			boolean bindWriter = false;

			if (writer.isEmpty()) {
				sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
			}
			else {
				bindWriter = true;

				sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWriter) {
					queryPos.add(writer);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WRITER_WRITER_2 =
		"tbl.writer LIKE ?";

	private static final String _FINDER_COLUMN_WRITER_WRITER_3 =
		"(tbl.writer IS NULL OR tbl.writer LIKE '')";

	private FinderPath _finderPathWithPaginationFindBycontents;
	private FinderPath _finderPathWithPaginationCountBycontents;

	/**
	 * Returns all the tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the matching tbls
	 */
	@Override
	public List<TBL> findBycontents(String contents) {
		return findBycontents(
			contents, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TBL> findBycontents(String contents, int start, int end) {
		return findBycontents(contents, start, end, null);
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
	@Override
	public List<TBL> findBycontents(
		String contents, int start, int end,
		OrderByComparator<TBL> orderByComparator) {

		return findBycontents(contents, start, end, orderByComparator, true);
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
	@Override
	public List<TBL> findBycontents(
		String contents, int start, int end,
		OrderByComparator<TBL> orderByComparator, boolean useFinderCache) {

		contents = Objects.toString(contents, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBycontents;
		finderArgs = new Object[] {contents, start, end, orderByComparator};

		List<TBL> list = null;

		if (useFinderCache) {
			list = (List<TBL>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TBL tbl : list) {
					if (!StringUtil.wildcardMatches(
							tbl.getContents(), contents, '_', '%', '\\',
							true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TBL_WHERE);

			boolean bindContents = false;

			if (contents.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_3);
			}
			else {
				bindContents = true;

				sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TBLModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContents) {
					queryPos.add(contents);
				}

				list = (List<TBL>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBycontents_First(
			String contents, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBycontents_First(contents, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentsLIKE");
		sb.append(contents);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the first tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBycontents_First(
		String contents, OrderByComparator<TBL> orderByComparator) {

		List<TBL> list = findBycontents(contents, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl
	 * @throws NoSuchTBLException if a matching tbl could not be found
	 */
	@Override
	public TBL findBycontents_Last(
			String contents, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		TBL tbl = fetchBycontents_Last(contents, orderByComparator);

		if (tbl != null) {
			return tbl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentsLIKE");
		sb.append(contents);

		sb.append("}");

		throw new NoSuchTBLException(sb.toString());
	}

	/**
	 * Returns the last tbl in the ordered set where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tbl, or <code>null</code> if a matching tbl could not be found
	 */
	@Override
	public TBL fetchBycontents_Last(
		String contents, OrderByComparator<TBL> orderByComparator) {

		int count = countBycontents(contents);

		if (count == 0) {
			return null;
		}

		List<TBL> list = findBycontents(
			contents, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TBL[] findBycontents_PrevAndNext(
			long bno, String contents, OrderByComparator<TBL> orderByComparator)
		throws NoSuchTBLException {

		contents = Objects.toString(contents, "");

		TBL tbl = findByPrimaryKey(bno);

		Session session = null;

		try {
			session = openSession();

			TBL[] array = new TBLImpl[3];

			array[0] = getBycontents_PrevAndNext(
				session, tbl, contents, orderByComparator, true);

			array[1] = tbl;

			array[2] = getBycontents_PrevAndNext(
				session, tbl, contents, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TBL getBycontents_PrevAndNext(
		Session session, TBL tbl, String contents,
		OrderByComparator<TBL> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TBL_WHERE);

		boolean bindContents = false;

		if (contents.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_3);
		}
		else {
			bindContents = true;

			sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TBLModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindContents) {
			queryPos.add(contents);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tbl)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TBL> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tbls where contents LIKE &#63; from the database.
	 *
	 * @param contents the contents
	 */
	@Override
	public void removeBycontents(String contents) {
		for (TBL tbl :
				findBycontents(
					contents, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tbl);
		}
	}

	/**
	 * Returns the number of tbls where contents LIKE &#63;.
	 *
	 * @param contents the contents
	 * @return the number of matching tbls
	 */
	@Override
	public int countBycontents(String contents) {
		contents = Objects.toString(contents, "");

		FinderPath finderPath = _finderPathWithPaginationCountBycontents;

		Object[] finderArgs = new Object[] {contents};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TBL_WHERE);

			boolean bindContents = false;

			if (contents.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_3);
			}
			else {
				bindContents = true;

				sb.append(_FINDER_COLUMN_CONTENTS_CONTENTS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContents) {
					queryPos.add(contents);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTENTS_CONTENTS_2 =
		"tbl.contents LIKE ?";

	private static final String _FINDER_COLUMN_CONTENTS_CONTENTS_3 =
		"(tbl.contents IS NULL OR tbl.contents LIKE '')";

	public TBLPersistenceImpl() {
		setModelClass(TBL.class);

		setModelImplClass(TBLImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the tbl in the entity cache if it is enabled.
	 *
	 * @param tbl the tbl
	 */
	@Override
	public void cacheResult(TBL tbl) {
		entityCache.putResult(
			entityCacheEnabled, TBLImpl.class, tbl.getPrimaryKey(), tbl);

		tbl.resetOriginalValues();
	}

	/**
	 * Caches the tbls in the entity cache if it is enabled.
	 *
	 * @param tbls the tbls
	 */
	@Override
	public void cacheResult(List<TBL> tbls) {
		for (TBL tbl : tbls) {
			if (entityCache.getResult(
					entityCacheEnabled, TBLImpl.class, tbl.getPrimaryKey()) ==
						null) {

				cacheResult(tbl);
			}
			else {
				tbl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tbls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TBLImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tbl.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TBL tbl) {
		entityCache.removeResult(
			entityCacheEnabled, TBLImpl.class, tbl.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TBL> tbls) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TBL tbl : tbls) {
			entityCache.removeResult(
				entityCacheEnabled, TBLImpl.class, tbl.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TBLImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tbl with the primary key. Does not add the tbl to the database.
	 *
	 * @param bno the primary key for the new tbl
	 * @return the new tbl
	 */
	@Override
	public TBL create(long bno) {
		TBL tbl = new TBLImpl();

		tbl.setNew(true);
		tbl.setPrimaryKey(bno);

		return tbl;
	}

	/**
	 * Removes the tbl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl that was removed
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	@Override
	public TBL remove(long bno) throws NoSuchTBLException {
		return remove((Serializable)bno);
	}

	/**
	 * Removes the tbl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tbl
	 * @return the tbl that was removed
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	@Override
	public TBL remove(Serializable primaryKey) throws NoSuchTBLException {
		Session session = null;

		try {
			session = openSession();

			TBL tbl = (TBL)session.get(TBLImpl.class, primaryKey);

			if (tbl == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTBLException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tbl);
		}
		catch (NoSuchTBLException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TBL removeImpl(TBL tbl) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tbl)) {
				tbl = (TBL)session.get(TBLImpl.class, tbl.getPrimaryKeyObj());
			}

			if (tbl != null) {
				session.delete(tbl);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tbl != null) {
			clearCache(tbl);
		}

		return tbl;
	}

	@Override
	public TBL updateImpl(TBL tbl) {
		boolean isNew = tbl.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tbl);

				tbl.setNew(false);
			}
			else {
				tbl = (TBL)session.merge(tbl);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, TBLImpl.class, tbl.getPrimaryKey(), tbl, false);

		tbl.resetOriginalValues();

		return tbl;
	}

	/**
	 * Returns the tbl with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tbl
	 * @return the tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	@Override
	public TBL findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTBLException {

		TBL tbl = fetchByPrimaryKey(primaryKey);

		if (tbl == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTBLException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tbl;
	}

	/**
	 * Returns the tbl with the primary key or throws a <code>NoSuchTBLException</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl
	 * @throws NoSuchTBLException if a tbl with the primary key could not be found
	 */
	@Override
	public TBL findByPrimaryKey(long bno) throws NoSuchTBLException {
		return findByPrimaryKey((Serializable)bno);
	}

	/**
	 * Returns the tbl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bno the primary key of the tbl
	 * @return the tbl, or <code>null</code> if a tbl with the primary key could not be found
	 */
	@Override
	public TBL fetchByPrimaryKey(long bno) {
		return fetchByPrimaryKey((Serializable)bno);
	}

	/**
	 * Returns all the tbls.
	 *
	 * @return the tbls
	 */
	@Override
	public List<TBL> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TBL> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TBL> findAll(
		int start, int end, OrderByComparator<TBL> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TBL> findAll(
		int start, int end, OrderByComparator<TBL> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TBL> list = null;

		if (useFinderCache) {
			list = (List<TBL>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TBL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TBL;

				sql = sql.concat(TBLModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TBL>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tbls from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TBL tbl : findAll()) {
			remove(tbl);
		}
	}

	/**
	 * Returns the number of tbls.
	 *
	 * @return the number of tbls
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TBL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "bno";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TBL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TBLModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tbl persistence.
	 */
	@Activate
	public void activate() {
		TBLModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TBLModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TBLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TBLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBysubject = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TBLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysubject",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountBysubject = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBysubject",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBywriter = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TBLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBywriter",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountBywriter = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBywriter",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBycontents = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TBLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycontents",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountBycontents = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBycontents",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TBLImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = HHL_PROJECTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.BoardService.model.TBL"),
			true);
	}

	@Override
	@Reference(
		target = HHL_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HHL_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TBL = "SELECT tbl FROM TBL tbl";

	private static final String _SQL_SELECT_TBL_WHERE =
		"SELECT tbl FROM TBL tbl WHERE ";

	private static final String _SQL_COUNT_TBL =
		"SELECT COUNT(tbl) FROM TBL tbl";

	private static final String _SQL_COUNT_TBL_WHERE =
		"SELECT COUNT(tbl) FROM TBL tbl WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tbl.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TBL exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TBL exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TBLPersistenceImpl.class);

	static {
		try {
			Class.forName(HHL_PROJECTPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}