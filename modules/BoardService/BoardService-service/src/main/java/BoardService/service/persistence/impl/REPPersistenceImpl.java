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

import BoardService.exception.NoSuchREPException;

import BoardService.model.REP;
import BoardService.model.impl.REPImpl;
import BoardService.model.impl.REPModelImpl;

import BoardService.service.persistence.REPPersistence;
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
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the rep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = REPPersistence.class)
public class REPPersistenceImpl
	extends BasePersistenceImpl<REP> implements REPPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>REPUtil</code> to access the rep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		REPImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBybno;
	private FinderPath _finderPathWithoutPaginationFindBybno;
	private FinderPath _finderPathCountBybno;

	/**
	 * Returns all the reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching reps
	 */
	@Override
	public List<REP> findBybno(long bno) {
		return findBybno(bno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<REP> findBybno(long bno, int start, int end) {
		return findBybno(bno, start, end, null);
	}

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
	@Override
	public List<REP> findBybno(
		long bno, int start, int end,
		OrderByComparator<REP> orderByComparator) {

		return findBybno(bno, start, end, orderByComparator, true);
	}

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
	@Override
	public List<REP> findBybno(
		long bno, int start, int end, OrderByComparator<REP> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBybno;
				finderArgs = new Object[] {bno};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBybno;
			finderArgs = new Object[] {bno, start, end, orderByComparator};
		}

		List<REP> list = null;

		if (useFinderCache) {
			list = (List<REP>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (REP rep : list) {
					if (bno != rep.getBno()) {
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

			sb.append(_SQL_SELECT_REP_WHERE);

			sb.append(_FINDER_COLUMN_BNO_BNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(REPModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bno);

				list = (List<REP>)QueryUtil.list(
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
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	@Override
	public REP findBybno_First(
			long bno, OrderByComparator<REP> orderByComparator)
		throws NoSuchREPException {

		REP rep = fetchBybno_First(bno, orderByComparator);

		if (rep != null) {
			return rep;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bno=");
		sb.append(bno);

		sb.append("}");

		throw new NoSuchREPException(sb.toString());
	}

	/**
	 * Returns the first rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rep, or <code>null</code> if a matching rep could not be found
	 */
	@Override
	public REP fetchBybno_First(
		long bno, OrderByComparator<REP> orderByComparator) {

		List<REP> list = findBybno(bno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep
	 * @throws NoSuchREPException if a matching rep could not be found
	 */
	@Override
	public REP findBybno_Last(
			long bno, OrderByComparator<REP> orderByComparator)
		throws NoSuchREPException {

		REP rep = fetchBybno_Last(bno, orderByComparator);

		if (rep != null) {
			return rep;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bno=");
		sb.append(bno);

		sb.append("}");

		throw new NoSuchREPException(sb.toString());
	}

	/**
	 * Returns the last rep in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rep, or <code>null</code> if a matching rep could not be found
	 */
	@Override
	public REP fetchBybno_Last(
		long bno, OrderByComparator<REP> orderByComparator) {

		int count = countBybno(bno);

		if (count == 0) {
			return null;
		}

		List<REP> list = findBybno(bno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reps before and after the current rep in the ordered set where bno = &#63;.
	 *
	 * @param rno the primary key of the current rep
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	@Override
	public REP[] findBybno_PrevAndNext(
			long rno, long bno, OrderByComparator<REP> orderByComparator)
		throws NoSuchREPException {

		REP rep = findByPrimaryKey(rno);

		Session session = null;

		try {
			session = openSession();

			REP[] array = new REPImpl[3];

			array[0] = getBybno_PrevAndNext(
				session, rep, bno, orderByComparator, true);

			array[1] = rep;

			array[2] = getBybno_PrevAndNext(
				session, rep, bno, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected REP getBybno_PrevAndNext(
		Session session, REP rep, long bno,
		OrderByComparator<REP> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REP_WHERE);

		sb.append(_FINDER_COLUMN_BNO_BNO_2);

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
			sb.append(REPModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bno);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rep)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<REP> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reps where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	@Override
	public void removeBybno(long bno) {
		for (REP rep :
				findBybno(bno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rep);
		}
	}

	/**
	 * Returns the number of reps where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching reps
	 */
	@Override
	public int countBybno(long bno) {
		FinderPath finderPath = _finderPathCountBybno;

		Object[] finderArgs = new Object[] {bno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REP_WHERE);

			sb.append(_FINDER_COLUMN_BNO_BNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bno);

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

	private static final String _FINDER_COLUMN_BNO_BNO_2 = "rep.bno = ?";

	public REPPersistenceImpl() {
		setModelClass(REP.class);

		setModelImplClass(REPImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the rep in the entity cache if it is enabled.
	 *
	 * @param rep the rep
	 */
	@Override
	public void cacheResult(REP rep) {
		entityCache.putResult(
			entityCacheEnabled, REPImpl.class, rep.getPrimaryKey(), rep);

		rep.resetOriginalValues();
	}

	/**
	 * Caches the reps in the entity cache if it is enabled.
	 *
	 * @param reps the reps
	 */
	@Override
	public void cacheResult(List<REP> reps) {
		for (REP rep : reps) {
			if (entityCache.getResult(
					entityCacheEnabled, REPImpl.class, rep.getPrimaryKey()) ==
						null) {

				cacheResult(rep);
			}
			else {
				rep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(REPImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rep.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(REP rep) {
		entityCache.removeResult(
			entityCacheEnabled, REPImpl.class, rep.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<REP> reps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (REP rep : reps) {
			entityCache.removeResult(
				entityCacheEnabled, REPImpl.class, rep.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, REPImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rep with the primary key. Does not add the rep to the database.
	 *
	 * @param rno the primary key for the new rep
	 * @return the new rep
	 */
	@Override
	public REP create(long rno) {
		REP rep = new REPImpl();

		rep.setNew(true);
		rep.setPrimaryKey(rno);

		return rep;
	}

	/**
	 * Removes the rep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep that was removed
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	@Override
	public REP remove(long rno) throws NoSuchREPException {
		return remove((Serializable)rno);
	}

	/**
	 * Removes the rep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rep
	 * @return the rep that was removed
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	@Override
	public REP remove(Serializable primaryKey) throws NoSuchREPException {
		Session session = null;

		try {
			session = openSession();

			REP rep = (REP)session.get(REPImpl.class, primaryKey);

			if (rep == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchREPException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rep);
		}
		catch (NoSuchREPException noSuchEntityException) {
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
	protected REP removeImpl(REP rep) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rep)) {
				rep = (REP)session.get(REPImpl.class, rep.getPrimaryKeyObj());
			}

			if (rep != null) {
				session.delete(rep);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rep != null) {
			clearCache(rep);
		}

		return rep;
	}

	@Override
	public REP updateImpl(REP rep) {
		boolean isNew = rep.isNew();

		if (!(rep instanceof REPModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rep.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rep);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rep proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom REP implementation " +
					rep.getClass());
		}

		REPModelImpl repModelImpl = (REPModelImpl)rep;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rep);

				rep.setNew(false);
			}
			else {
				rep = (REP)session.merge(rep);
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
			Object[] args = new Object[] {repModelImpl.getBno()};

			finderCache.removeResult(_finderPathCountBybno, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBybno, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((repModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBybno.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {repModelImpl.getOriginalBno()};

				finderCache.removeResult(_finderPathCountBybno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybno, args);

				args = new Object[] {repModelImpl.getBno()};

				finderCache.removeResult(_finderPathCountBybno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybno, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, REPImpl.class, rep.getPrimaryKey(), rep, false);

		rep.resetOriginalValues();

		return rep;
	}

	/**
	 * Returns the rep with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rep
	 * @return the rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	@Override
	public REP findByPrimaryKey(Serializable primaryKey)
		throws NoSuchREPException {

		REP rep = fetchByPrimaryKey(primaryKey);

		if (rep == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchREPException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rep;
	}

	/**
	 * Returns the rep with the primary key or throws a <code>NoSuchREPException</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep
	 * @throws NoSuchREPException if a rep with the primary key could not be found
	 */
	@Override
	public REP findByPrimaryKey(long rno) throws NoSuchREPException {
		return findByPrimaryKey((Serializable)rno);
	}

	/**
	 * Returns the rep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rno the primary key of the rep
	 * @return the rep, or <code>null</code> if a rep with the primary key could not be found
	 */
	@Override
	public REP fetchByPrimaryKey(long rno) {
		return fetchByPrimaryKey((Serializable)rno);
	}

	/**
	 * Returns all the reps.
	 *
	 * @return the reps
	 */
	@Override
	public List<REP> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<REP> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<REP> findAll(
		int start, int end, OrderByComparator<REP> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<REP> findAll(
		int start, int end, OrderByComparator<REP> orderByComparator,
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

		List<REP> list = null;

		if (useFinderCache) {
			list = (List<REP>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REP;

				sql = sql.concat(REPModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<REP>)QueryUtil.list(
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
	 * Removes all the reps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (REP rep : findAll()) {
			remove(rep);
		}
	}

	/**
	 * Returns the number of reps.
	 *
	 * @return the number of reps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REP);

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
		return "rno";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return REPModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rep persistence.
	 */
	@Activate
	public void activate() {
		REPModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		REPModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, REPImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, REPImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, REPImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybno",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, REPImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybno",
			new String[] {Long.class.getName()},
			REPModelImpl.BNO_COLUMN_BITMASK);

		_finderPathCountBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybno",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(REPImpl.class.getName());

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
				"value.object.column.bitmask.enabled.BoardService.model.REP"),
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

	private static final String _SQL_SELECT_REP = "SELECT rep FROM REP rep";

	private static final String _SQL_SELECT_REP_WHERE =
		"SELECT rep FROM REP rep WHERE ";

	private static final String _SQL_COUNT_REP =
		"SELECT COUNT(rep) FROM REP rep";

	private static final String _SQL_COUNT_REP_WHERE =
		"SELECT COUNT(rep) FROM REP rep WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rep.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No REP exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No REP exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		REPPersistenceImpl.class);

	static {
		try {
			Class.forName(HHL_PROJECTPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}