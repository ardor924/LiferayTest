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
 * This class is a wrapper for {@link ADDFILE}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILE
 * @generated
 */
public class ADDFILEWrapper
	extends BaseModelWrapper<ADDFILE>
	implements ADDFILE, ModelWrapper<ADDFILE> {

	public ADDFILEWrapper(ADDFILE addfile) {
		super(addfile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fno", getFno());
		attributes.put("bno", getBno());
		attributes.put("fRealName", getFRealName());
		attributes.put("fName", getFName());
		attributes.put("fPath", getFPath());
		attributes.put("fDate", getFDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fno = (Long)attributes.get("fno");

		if (fno != null) {
			setFno(fno);
		}

		Long bno = (Long)attributes.get("bno");

		if (bno != null) {
			setBno(bno);
		}

		String fRealName = (String)attributes.get("fRealName");

		if (fRealName != null) {
			setFRealName(fRealName);
		}

		String fName = (String)attributes.get("fName");

		if (fName != null) {
			setFName(fName);
		}

		String fPath = (String)attributes.get("fPath");

		if (fPath != null) {
			setFPath(fPath);
		}

		String fDate = (String)attributes.get("fDate");

		if (fDate != null) {
			setFDate(fDate);
		}
	}

	/**
	 * Returns the bno of this addfile.
	 *
	 * @return the bno of this addfile
	 */
	@Override
	public long getBno() {
		return model.getBno();
	}

	/**
	 * Returns the f date of this addfile.
	 *
	 * @return the f date of this addfile
	 */
	@Override
	public String getFDate() {
		return model.getFDate();
	}

	/**
	 * Returns the f name of this addfile.
	 *
	 * @return the f name of this addfile
	 */
	@Override
	public String getFName() {
		return model.getFName();
	}

	/**
	 * Returns the fno of this addfile.
	 *
	 * @return the fno of this addfile
	 */
	@Override
	public long getFno() {
		return model.getFno();
	}

	/**
	 * Returns the f path of this addfile.
	 *
	 * @return the f path of this addfile
	 */
	@Override
	public String getFPath() {
		return model.getFPath();
	}

	/**
	 * Returns the f real name of this addfile.
	 *
	 * @return the f real name of this addfile
	 */
	@Override
	public String getFRealName() {
		return model.getFRealName();
	}

	/**
	 * Returns the primary key of this addfile.
	 *
	 * @return the primary key of this addfile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bno of this addfile.
	 *
	 * @param bno the bno of this addfile
	 */
	@Override
	public void setBno(long bno) {
		model.setBno(bno);
	}

	/**
	 * Sets the f date of this addfile.
	 *
	 * @param fDate the f date of this addfile
	 */
	@Override
	public void setFDate(String fDate) {
		model.setFDate(fDate);
	}

	/**
	 * Sets the f name of this addfile.
	 *
	 * @param fName the f name of this addfile
	 */
	@Override
	public void setFName(String fName) {
		model.setFName(fName);
	}

	/**
	 * Sets the fno of this addfile.
	 *
	 * @param fno the fno of this addfile
	 */
	@Override
	public void setFno(long fno) {
		model.setFno(fno);
	}

	/**
	 * Sets the f path of this addfile.
	 *
	 * @param fPath the f path of this addfile
	 */
	@Override
	public void setFPath(String fPath) {
		model.setFPath(fPath);
	}

	/**
	 * Sets the f real name of this addfile.
	 *
	 * @param fRealName the f real name of this addfile
	 */
	@Override
	public void setFRealName(String fRealName) {
		model.setFRealName(fRealName);
	}

	/**
	 * Sets the primary key of this addfile.
	 *
	 * @param primaryKey the primary key of this addfile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ADDFILEWrapper wrap(ADDFILE addfile) {
		return new ADDFILEWrapper(addfile);
	}

}