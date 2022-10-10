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
 * This class is used by SOAP remote services, specifically {@link BoardService.service.http.REPServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class REPSoap implements Serializable {

	public static REPSoap toSoapModel(REP model) {
		REPSoap soapModel = new REPSoap();

		soapModel.setRno(model.getRno());
		soapModel.setBno(model.getBno());
		soapModel.setRWriter(model.getRWriter());
		soapModel.setRContents(model.getRContents());
		soapModel.setRRegDate(model.getRRegDate());
		soapModel.setRIndent(model.getRIndent());
		soapModel.setRAnsNum(model.getRAnsNum());

		return soapModel;
	}

	public static REPSoap[] toSoapModels(REP[] models) {
		REPSoap[] soapModels = new REPSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static REPSoap[][] toSoapModels(REP[][] models) {
		REPSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new REPSoap[models.length][models[0].length];
		}
		else {
			soapModels = new REPSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static REPSoap[] toSoapModels(List<REP> models) {
		List<REPSoap> soapModels = new ArrayList<REPSoap>(models.size());

		for (REP model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new REPSoap[soapModels.size()]);
	}

	public REPSoap() {
	}

	public long getPrimaryKey() {
		return _rno;
	}

	public void setPrimaryKey(long pk) {
		setRno(pk);
	}

	public long getRno() {
		return _rno;
	}

	public void setRno(long rno) {
		_rno = rno;
	}

	public long getBno() {
		return _bno;
	}

	public void setBno(long bno) {
		_bno = bno;
	}

	public String getRWriter() {
		return _rWriter;
	}

	public void setRWriter(String rWriter) {
		_rWriter = rWriter;
	}

	public String getRContents() {
		return _rContents;
	}

	public void setRContents(String rContents) {
		_rContents = rContents;
	}

	public String getRRegDate() {
		return _rRegDate;
	}

	public void setRRegDate(String rRegDate) {
		_rRegDate = rRegDate;
	}

	public int getRIndent() {
		return _rIndent;
	}

	public void setRIndent(int rIndent) {
		_rIndent = rIndent;
	}

	public int getRAnsNum() {
		return _rAnsNum;
	}

	public void setRAnsNum(int rAnsNum) {
		_rAnsNum = rAnsNum;
	}

	private long _rno;
	private long _bno;
	private String _rWriter;
	private String _rContents;
	private String _rRegDate;
	private int _rIndent;
	private int _rAnsNum;

}