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
 * This class is a wrapper for {@link TBL}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TBL
 * @generated
 */
public class TBLWrapper
	extends BaseModelWrapper<TBL> implements ModelWrapper<TBL>, TBL {

	public TBLWrapper(TBL tbl) {
		super(tbl);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bno", getBno());
		attributes.put("subject", getSubject());
		attributes.put("writer", getWriter());
		attributes.put("contents", getContents());
		attributes.put("regDate", getRegDate());
		attributes.put("hit", getHit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bno = (Long)attributes.get("bno");

		if (bno != null) {
			setBno(bno);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String writer = (String)attributes.get("writer");

		if (writer != null) {
			setWriter(writer);
		}

		String contents = (String)attributes.get("contents");

		if (contents != null) {
			setContents(contents);
		}

		String regDate = (String)attributes.get("regDate");

		if (regDate != null) {
			setRegDate(regDate);
		}

		Integer hit = (Integer)attributes.get("hit");

		if (hit != null) {
			setHit(hit);
		}
	}

	/**
	 * Returns the bno of this tbl.
	 *
	 * @return the bno of this tbl
	 */
	@Override
	public long getBno() {
		return model.getBno();
	}

	/**
	 * Returns the contents of this tbl.
	 *
	 * @return the contents of this tbl
	 */
	@Override
	public String getContents() {
		return model.getContents();
	}

	/**
	 * Returns the hit of this tbl.
	 *
	 * @return the hit of this tbl
	 */
	@Override
	public int getHit() {
		return model.getHit();
	}

	/**
	 * Returns the primary key of this tbl.
	 *
	 * @return the primary key of this tbl
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reg date of this tbl.
	 *
	 * @return the reg date of this tbl
	 */
	@Override
	public String getRegDate() {
		return model.getRegDate();
	}

	/**
	 * Returns the subject of this tbl.
	 *
	 * @return the subject of this tbl
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the writer of this tbl.
	 *
	 * @return the writer of this tbl
	 */
	@Override
	public String getWriter() {
		return model.getWriter();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bno of this tbl.
	 *
	 * @param bno the bno of this tbl
	 */
	@Override
	public void setBno(long bno) {
		model.setBno(bno);
	}

	/**
	 * Sets the contents of this tbl.
	 *
	 * @param contents the contents of this tbl
	 */
	@Override
	public void setContents(String contents) {
		model.setContents(contents);
	}

	/**
	 * Sets the hit of this tbl.
	 *
	 * @param hit the hit of this tbl
	 */
	@Override
	public void setHit(int hit) {
		model.setHit(hit);
	}

	/**
	 * Sets the primary key of this tbl.
	 *
	 * @param primaryKey the primary key of this tbl
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reg date of this tbl.
	 *
	 * @param regDate the reg date of this tbl
	 */
	@Override
	public void setRegDate(String regDate) {
		model.setRegDate(regDate);
	}

	/**
	 * Sets the subject of this tbl.
	 *
	 * @param subject the subject of this tbl
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the writer of this tbl.
	 *
	 * @param writer the writer of this tbl
	 */
	@Override
	public void setWriter(String writer) {
		model.setWriter(writer);
	}

	@Override
	protected TBLWrapper wrap(TBL tbl) {
		return new TBLWrapper(tbl);
	}

}