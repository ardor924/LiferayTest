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

import BoardService.exception.NoSuchADDFILEException;

import BoardService.model.ADDFILE;
import BoardService.model.impl.ADDFILEImpl;
import BoardService.model.impl.ADDFILEModelImpl;

import BoardService.service.persistence.ADDFILEPersistence;
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
 * The persistence implementation for the addfile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ADDFILEPersistence.class)
public class ADDFILEPersistenceImpl
	extends BasePersistenceImpl<ADDFILE> implements ADDFILEPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ADDFILEUtil</code> to access the addfile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ADDFILEImpl.class.getName();

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
	 * Returns all the addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the matching addfiles
	 */
	@Override
	public List<ADDFILE> findBybno(long bno) {
		return findBybno(bno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ADDFILE> findBybno(long bno, int start, int end) {
		return findBybno(bno, start, end, null);
	}

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
	@Override
	public List<ADDFILE> findBybno(
		long bno, int start, int end,
		OrderByComparator<ADDFILE> orderByComparator) {

		return findBybno(bno, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ADDFILE> findBybno(
		long bno, int start, int end,
		OrderByComparator<ADDFILE> orderByComparator, boolean useFinderCache) {

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

		List<ADDFILE> list = null;

		if (useFinderCache) {
			list = (List<ADDFILE>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ADDFILE addfile : list) {
					if (bno != addfile.getBno()) {
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

			sb.append(_SQL_SELECT_ADDFILE_WHERE);

			sb.append(_FINDER_COLUMN_BNO_BNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ADDFILEModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bno);

				list = (List<ADDFILE>)QueryUtil.list(
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
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	@Override
	public ADDFILE findBybno_First(
			long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws NoSuchADDFILEException {

		ADDFILE addfile = fetchBybno_First(bno, orderByComparator);

		if (addfile != null) {
			return addfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bno=");
		sb.append(bno);

		sb.append("}");

		throw new NoSuchADDFILEException(sb.toString());
	}

	/**
	 * Returns the first addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	@Override
	public ADDFILE fetchBybno_First(
		long bno, OrderByComparator<ADDFILE> orderByComparator) {

		List<ADDFILE> list = findBybno(bno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile
	 * @throws NoSuchADDFILEException if a matching addfile could not be found
	 */
	@Override
	public ADDFILE findBybno_Last(
			long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws NoSuchADDFILEException {

		ADDFILE addfile = fetchBybno_Last(bno, orderByComparator);

		if (addfile != null) {
			return addfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bno=");
		sb.append(bno);

		sb.append("}");

		throw new NoSuchADDFILEException(sb.toString());
	}

	/**
	 * Returns the last addfile in the ordered set where bno = &#63;.
	 *
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addfile, or <code>null</code> if a matching addfile could not be found
	 */
	@Override
	public ADDFILE fetchBybno_Last(
		long bno, OrderByComparator<ADDFILE> orderByComparator) {

		int count = countBybno(bno);

		if (count == 0) {
			return null;
		}

		List<ADDFILE> list = findBybno(
			bno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addfiles before and after the current addfile in the ordered set where bno = &#63;.
	 *
	 * @param fno the primary key of the current addfile
	 * @param bno the bno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE[] findBybno_PrevAndNext(
			long fno, long bno, OrderByComparator<ADDFILE> orderByComparator)
		throws NoSuchADDFILEException {

		ADDFILE addfile = findByPrimaryKey(fno);

		Session session = null;

		try {
			session = openSession();

			ADDFILE[] array = new ADDFILEImpl[3];

			array[0] = getBybno_PrevAndNext(
				session, addfile, bno, orderByComparator, true);

			array[1] = addfile;

			array[2] = getBybno_PrevAndNext(
				session, addfile, bno, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ADDFILE getBybno_PrevAndNext(
		Session session, ADDFILE addfile, long bno,
		OrderByComparator<ADDFILE> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDFILE_WHERE);

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
			sb.append(ADDFILEModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bno);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(addfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ADDFILE> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addfiles where bno = &#63; from the database.
	 *
	 * @param bno the bno
	 */
	@Override
	public void removeBybno(long bno) {
		for (ADDFILE addfile :
				findBybno(bno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(addfile);
		}
	}

	/**
	 * Returns the number of addfiles where bno = &#63;.
	 *
	 * @param bno the bno
	 * @return the number of matching addfiles
	 */
	@Override
	public int countBybno(long bno) {
		FinderPath finderPath = _finderPathCountBybno;

		Object[] finderArgs = new Object[] {bno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDFILE_WHERE);

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

	private static final String _FINDER_COLUMN_BNO_BNO_2 = "addfile.bno = ?";

	public ADDFILEPersistenceImpl() {
		setModelClass(ADDFILE.class);

		setModelImplClass(ADDFILEImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the addfile in the entity cache if it is enabled.
	 *
	 * @param addfile the addfile
	 */
	@Override
	public void cacheResult(ADDFILE addfile) {
		entityCache.putResult(
			entityCacheEnabled, ADDFILEImpl.class, addfile.getPrimaryKey(),
			addfile);

		addfile.resetOriginalValues();
	}

	/**
	 * Caches the addfiles in the entity cache if it is enabled.
	 *
	 * @param addfiles the addfiles
	 */
	@Override
	public void cacheResult(List<ADDFILE> addfiles) {
		for (ADDFILE addfile : addfiles) {
			if (entityCache.getResult(
					entityCacheEnabled, ADDFILEImpl.class,
					addfile.getPrimaryKey()) == null) {

				cacheResult(addfile);
			}
			else {
				addfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all addfiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ADDFILEImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the addfile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ADDFILE addfile) {
		entityCache.removeResult(
			entityCacheEnabled, ADDFILEImpl.class, addfile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ADDFILE> addfiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ADDFILE addfile : addfiles) {
			entityCache.removeResult(
				entityCacheEnabled, ADDFILEImpl.class, addfile.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ADDFILEImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new addfile with the primary key. Does not add the addfile to the database.
	 *
	 * @param fno the primary key for the new addfile
	 * @return the new addfile
	 */
	@Override
	public ADDFILE create(long fno) {
		ADDFILE addfile = new ADDFILEImpl();

		addfile.setNew(true);
		addfile.setPrimaryKey(fno);

		return addfile;
	}

	/**
	 * Removes the addfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile that was removed
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE remove(long fno) throws NoSuchADDFILEException {
		return remove((Serializable)fno);
	}

	/**
	 * Removes the addfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the addfile
	 * @return the addfile that was removed
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE remove(Serializable primaryKey)
		throws NoSuchADDFILEException {

		Session session = null;

		try {
			session = openSession();

			ADDFILE addfile = (ADDFILE)session.get(
				ADDFILEImpl.class, primaryKey);

			if (addfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchADDFILEException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(addfile);
		}
		catch (NoSuchADDFILEException noSuchEntityException) {
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
	protected ADDFILE removeImpl(ADDFILE addfile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addfile)) {
				addfile = (ADDFILE)session.get(
					ADDFILEImpl.class, addfile.getPrimaryKeyObj());
			}

			if (addfile != null) {
				session.delete(addfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (addfile != null) {
			clearCache(addfile);
		}

		return addfile;
	}

	@Override
	public ADDFILE updateImpl(ADDFILE addfile) {
		boolean isNew = addfile.isNew();

		if (!(addfile instanceof ADDFILEModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(addfile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(addfile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in addfile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ADDFILE implementation " +
					addfile.getClass());
		}

		ADDFILEModelImpl addfileModelImpl = (ADDFILEModelImpl)addfile;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(addfile);

				addfile.setNew(false);
			}
			else {
				addfile = (ADDFILE)session.merge(addfile);
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
			Object[] args = new Object[] {addfileModelImpl.getBno()};

			finderCache.removeResult(_finderPathCountBybno, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBybno, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((addfileModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBybno.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					addfileModelImpl.getOriginalBno()
				};

				finderCache.removeResult(_finderPathCountBybno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybno, args);

				args = new Object[] {addfileModelImpl.getBno()};

				finderCache.removeResult(_finderPathCountBybno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybno, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ADDFILEImpl.class, addfile.getPrimaryKey(),
			addfile, false);

		addfile.resetOriginalValues();

		return addfile;
	}

	/**
	 * Returns the addfile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the addfile
	 * @return the addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE findByPrimaryKey(Serializable primaryKey)
		throws NoSuchADDFILEException {

		ADDFILE addfile = fetchByPrimaryKey(primaryKey);

		if (addfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchADDFILEException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return addfile;
	}

	/**
	 * Returns the addfile with the primary key or throws a <code>NoSuchADDFILEException</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile
	 * @throws NoSuchADDFILEException if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE findByPrimaryKey(long fno) throws NoSuchADDFILEException {
		return findByPrimaryKey((Serializable)fno);
	}

	/**
	 * Returns the addfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fno the primary key of the addfile
	 * @return the addfile, or <code>null</code> if a addfile with the primary key could not be found
	 */
	@Override
	public ADDFILE fetchByPrimaryKey(long fno) {
		return fetchByPrimaryKey((Serializable)fno);
	}

	/**
	 * Returns all the addfiles.
	 *
	 * @return the addfiles
	 */
	@Override
	public List<ADDFILE> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ADDFILE> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ADDFILE> findAll(
		int start, int end, OrderByComparator<ADDFILE> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ADDFILE> findAll(
		int start, int end, OrderByComparator<ADDFILE> orderByComparator,
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

		List<ADDFILE> list = null;

		if (useFinderCache) {
			list = (List<ADDFILE>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDFILE;

				sql = sql.concat(ADDFILEModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ADDFILE>)QueryUtil.list(
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
	 * Removes all the addfiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ADDFILE addfile : findAll()) {
			remove(addfile);
		}
	}

	/**
	 * Returns the number of addfiles.
	 *
	 * @return the number of addfiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDFILE);

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
		return "fno";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ADDFILEModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the addfile persistence.
	 */
	@Activate
	public void activate() {
		ADDFILEModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ADDFILEModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ADDFILEImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ADDFILEImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ADDFILEImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybno",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ADDFILEImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybno",
			new String[] {Long.class.getName()},
			ADDFILEModelImpl.BNO_COLUMN_BITMASK);

		_finderPathCountBybno = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybno",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ADDFILEImpl.class.getName());

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
				"value.object.column.bitmask.enabled.BoardService.model.ADDFILE"),
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

	private static final String _SQL_SELECT_ADDFILE =
		"SELECT addfile FROM ADDFILE addfile";

	private static final String _SQL_SELECT_ADDFILE_WHERE =
		"SELECT addfile FROM ADDFILE addfile WHERE ";

	private static final String _SQL_COUNT_ADDFILE =
		"SELECT COUNT(addfile) FROM ADDFILE addfile";

	private static final String _SQL_COUNT_ADDFILE_WHERE =
		"SELECT COUNT(addfile) FROM ADDFILE addfile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "addfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ADDFILE exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ADDFILE exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ADDFILEPersistenceImpl.class);

	static {
		try {
			Class.forName(HHL_PROJECTPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}