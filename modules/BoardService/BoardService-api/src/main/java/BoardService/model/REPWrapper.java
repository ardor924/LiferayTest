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

package BoardService.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link REP}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see REP
 * @generated
 */
public class REPWrapper
	extends BaseModelWrapper<REP> implements ModelWrapper<REP>, REP {

	public REPWrapper(REP rep) {
		super(rep);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rno", getRno());
		attributes.put("bno", getBno());
		attributes.put("rWriter", getRWriter());
		attributes.put("rContents", getRContents());
		attributes.put("rRegDate", getRRegDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rno = (Long)attributes.get("rno");

		if (rno != null) {
			setRno(rno);
		}

		Long bno = (Long)attributes.get("bno");

		if (bno != null) {
			setBno(bno);
		}

		String rWriter = (String)attributes.get("rWriter");

		if (rWriter != null) {
			setRWriter(rWriter);
		}

		String rContents = (String)attributes.get("rContents");

		if (rContents != null) {
			setRContents(rContents);
		}

		String rRegDate = (String)attributes.get("rRegDate");

		if (rRegDate != null) {
			setRRegDate(rRegDate);
		}
	}

	/**
	 * Returns the bno of this rep.
	 *
	 * @return the bno of this rep
	 */
	@Override
	public long getBno() {
		return model.getBno();
	}

	/**
	 * Returns the primary key of this rep.
	 *
	 * @return the primary key of this rep
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the r contents of this rep.
	 *
	 * @return the r contents of this rep
	 */
	@Override
	public String getRContents() {
		return model.getRContents();
	}

	/**
	 * Returns the rno of this rep.
	 *
	 * @return the rno of this rep
	 */
	@Override
	public long getRno() {
		return model.getRno();
	}

	/**
	 * Returns the r reg date of this rep.
	 *
	 * @return the r reg date of this rep
	 */
	@Override
	public String getRRegDate() {
		return model.getRRegDate();
	}

	/**
	 * Returns the r writer of this rep.
	 *
	 * @return the r writer of this rep
	 */
	@Override
	public String getRWriter() {
		return model.getRWriter();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bno of this rep.
	 *
	 * @param bno the bno of this rep
	 */
	@Override
	public void setBno(long bno) {
		model.setBno(bno);
	}

	/**
	 * Sets the primary key of this rep.
	 *
	 * @param primaryKey the primary key of this rep
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the r contents of this rep.
	 *
	 * @param rContents the r contents of this rep
	 */
	@Override
	public void setRContents(String rContents) {
		model.setRContents(rContents);
	}

	/**
	 * Sets the rno of this rep.
	 *
	 * @param rno the rno of this rep
	 */
	@Override
	public void setRno(long rno) {
		model.setRno(rno);
	}

	/**
	 * Sets the r reg date of this rep.
	 *
	 * @param rRegDate the r reg date of this rep
	 */
	@Override
	public void setRRegDate(String rRegDate) {
		model.setRRegDate(rRegDate);
	}

	/**
	 * Sets the r writer of this rep.
	 *
	 * @param rWriter the r writer of this rep
	 */
	@Override
	public void setRWriter(String rWriter) {
		model.setRWriter(rWriter);
	}

	@Override
	protected REPWrapper wrap(REP rep) {
		return new REPWrapper(rep);
	}

}