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

package BoardService.model.impl;

import BoardService.model.REP;
import BoardService.model.REPModel;
import BoardService.model.REPSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the REP service. Represents a row in the &quot;HHL_PROJECT_REP&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>REPModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link REPImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see REPImpl
 * @generated
 */
@JSON(strict = true)
public class REPModelImpl extends BaseModelImpl<REP> implements REPModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rep model instance should use the <code>REP</code> interface instead.
	 */
	public static final String TABLE_NAME = "HHL_PROJECT_REP";

	public static final Object[][] TABLE_COLUMNS = {
		{"rno", Types.BIGINT}, {"bno", Types.BIGINT},
		{"rWriter", Types.VARCHAR}, {"rContents", Types.VARCHAR},
		{"rRegDate", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("rno", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("bno", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rWriter", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rContents", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rRegDate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table HHL_PROJECT_REP (rno LONG not null primary key,bno LONG,rWriter VARCHAR(75) null,rContents TEXT null,rRegDate VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table HHL_PROJECT_REP";

	public static final String ORDER_BY_JPQL = " ORDER BY rep.rno ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY HHL_PROJECT_REP.rno ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long BNO_COLUMN_BITMASK = 1L;

	public static final long RNO_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static REP toModel(REPSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		REP model = new REPImpl();

		model.setRno(soapModel.getRno());
		model.setBno(soapModel.getBno());
		model.setRWriter(soapModel.getRWriter());
		model.setRContents(soapModel.getRContents());
		model.setRRegDate(soapModel.getRRegDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<REP> toModels(REPSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<REP> models = new ArrayList<REP>(soapModels.length);

		for (REPSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public REPModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rno;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRno(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rno;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return REP.class;
	}

	@Override
	public String getModelClassName() {
		return REP.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<REP, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<REP, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<REP, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((REP)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<REP, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<REP, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((REP)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<REP, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<REP, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, REP>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			REP.class.getClassLoader(), REP.class, ModelWrapper.class);

		try {
			Constructor<REP> constructor =
				(Constructor<REP>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<REP, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<REP, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<REP, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<REP, Object>>();
		Map<String, BiConsumer<REP, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<REP, ?>>();

		attributeGetterFunctions.put("rno", REP::getRno);
		attributeSetterBiConsumers.put(
			"rno", (BiConsumer<REP, Long>)REP::setRno);
		attributeGetterFunctions.put("bno", REP::getBno);
		attributeSetterBiConsumers.put(
			"bno", (BiConsumer<REP, Long>)REP::setBno);
		attributeGetterFunctions.put("rWriter", REP::getRWriter);
		attributeSetterBiConsumers.put(
			"rWriter", (BiConsumer<REP, String>)REP::setRWriter);
		attributeGetterFunctions.put("rContents", REP::getRContents);
		attributeSetterBiConsumers.put(
			"rContents", (BiConsumer<REP, String>)REP::setRContents);
		attributeGetterFunctions.put("rRegDate", REP::getRRegDate);
		attributeSetterBiConsumers.put(
			"rRegDate", (BiConsumer<REP, String>)REP::setRRegDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getRno() {
		return _rno;
	}

	@Override
	public void setRno(long rno) {
		_rno = rno;
	}

	@JSON
	@Override
	public long getBno() {
		return _bno;
	}

	@Override
	public void setBno(long bno) {
		_columnBitmask |= BNO_COLUMN_BITMASK;

		if (!_setOriginalBno) {
			_setOriginalBno = true;

			_originalBno = _bno;
		}

		_bno = bno;
	}

	public long getOriginalBno() {
		return _originalBno;
	}

	@JSON
	@Override
	public String getRWriter() {
		if (_rWriter == null) {
			return "";
		}
		else {
			return _rWriter;
		}
	}

	@Override
	public void setRWriter(String rWriter) {
		_rWriter = rWriter;
	}

	@JSON
	@Override
	public String getRContents() {
		if (_rContents == null) {
			return "";
		}
		else {
			return _rContents;
		}
	}

	@Override
	public void setRContents(String rContents) {
		_rContents = rContents;
	}

	@JSON
	@Override
	public String getRRegDate() {
		if (_rRegDate == null) {
			return "";
		}
		else {
			return _rRegDate;
		}
	}

	@Override
	public void setRRegDate(String rRegDate) {
		_rRegDate = rRegDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, REP.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public REP toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, REP> escapedModelProxyProviderFunction =
				EscapedModelProxyProviderFunctionHolder.
					_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		REPImpl repImpl = new REPImpl();

		repImpl.setRno(getRno());
		repImpl.setBno(getBno());
		repImpl.setRWriter(getRWriter());
		repImpl.setRContents(getRContents());
		repImpl.setRRegDate(getRRegDate());

		repImpl.resetOriginalValues();

		return repImpl;
	}

	@Override
	public int compareTo(REP rep) {
		long primaryKey = rep.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof REP)) {
			return false;
		}

		REP rep = (REP)object;

		long primaryKey = rep.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalBno = _bno;

		_setOriginalBno = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<REP> toCacheModel() {
		REPCacheModel repCacheModel = new REPCacheModel();

		repCacheModel.rno = getRno();

		repCacheModel.bno = getBno();

		repCacheModel.rWriter = getRWriter();

		String rWriter = repCacheModel.rWriter;

		if ((rWriter != null) && (rWriter.length() == 0)) {
			repCacheModel.rWriter = null;
		}

		repCacheModel.rContents = getRContents();

		String rContents = repCacheModel.rContents;

		if ((rContents != null) && (rContents.length() == 0)) {
			repCacheModel.rContents = null;
		}

		repCacheModel.rRegDate = getRRegDate();

		String rRegDate = repCacheModel.rRegDate;

		if ((rRegDate != null) && (rRegDate.length() == 0)) {
			repCacheModel.rRegDate = null;
		}

		return repCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<REP, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<REP, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<REP, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((REP)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<REP, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<REP, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<REP, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((REP)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, REP>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _rno;
	private long _bno;
	private long _originalBno;
	private boolean _setOriginalBno;
	private String _rWriter;
	private String _rContents;
	private String _rRegDate;
	private long _columnBitmask;
	private REP _escapedModel;

}