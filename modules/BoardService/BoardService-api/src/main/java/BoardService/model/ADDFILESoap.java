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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link BoardService.service.http.ADDFILEServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ADDFILESoap implements Serializable {

	public static ADDFILESoap toSoapModel(ADDFILE model) {
		ADDFILESoap soapModel = new ADDFILESoap();

		soapModel.setFno(model.getFno());
		soapModel.setBno(model.getBno());
		soapModel.setFName(model.getFName());
		soapModel.setFPath(model.getFPath());

		return soapModel;
	}

	public static ADDFILESoap[] toSoapModels(ADDFILE[] models) {
		ADDFILESoap[] soapModels = new ADDFILESoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ADDFILESoap[][] toSoapModels(ADDFILE[][] models) {
		ADDFILESoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ADDFILESoap[models.length][models[0].length];
		}
		else {
			soapModels = new ADDFILESoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ADDFILESoap[] toSoapModels(List<ADDFILE> models) {
		List<ADDFILESoap> soapModels = new ArrayList<ADDFILESoap>(
			models.size());

		for (ADDFILE model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ADDFILESoap[soapModels.size()]);
	}

	public ADDFILESoap() {
	}

	public long getPrimaryKey() {
		return _fno;
	}

	public void setPrimaryKey(long pk) {
		setFno(pk);
	}

	public long getFno() {
		return _fno;
	}

	public void setFno(long fno) {
		_fno = fno;
	}

	public long getBno() {
		return _bno;
	}

	public void setBno(long bno) {
		_bno = bno;
	}

	public String getFName() {
		return _fName;
	}

	public void setFName(String fName) {
		_fName = fName;
	}

	public String getFPath() {
		return _fPath;
	}

	public void setFPath(String fPath) {
		_fPath = fPath;
	}

	private long _fno;
	private long _bno;
	private String _fName;
	private String _fPath;

}