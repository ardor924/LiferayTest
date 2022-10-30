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
 * This class is used by SOAP remote services, specifically {@link BoardService.service.http.TBLServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TBLSoap implements Serializable {

	public static TBLSoap toSoapModel(TBL model) {
		TBLSoap soapModel = new TBLSoap();

		soapModel.setBno(model.getBno());
		soapModel.setSubject(model.getSubject());
		soapModel.setWriter(model.getWriter());
		soapModel.setContents(model.getContents());
		soapModel.setRegDate(model.getRegDate());
		soapModel.setHit(model.getHit());

		return soapModel;
	}

	public static TBLSoap[] toSoapModels(TBL[] models) {
		TBLSoap[] soapModels = new TBLSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TBLSoap[][] toSoapModels(TBL[][] models) {
		TBLSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TBLSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TBLSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TBLSoap[] toSoapModels(List<TBL> models) {
		List<TBLSoap> soapModels = new ArrayList<TBLSoap>(models.size());

		for (TBL model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TBLSoap[soapModels.size()]);
	}

	public TBLSoap() {
	}

	public long getPrimaryKey() {
		return _bno;
	}

	public void setPrimaryKey(long pk) {
		setBno(pk);
	}

	public long getBno() {
		return _bno;
	}

	public void setBno(long bno) {
		_bno = bno;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getWriter() {
		return _writer;
	}

	public void setWriter(String writer) {
		_writer = writer;
	}

	public String getContents() {
		return _contents;
	}

	public void setContents(String contents) {
		_contents = contents;
	}

	public String getRegDate() {
		return _regDate;
	}

	public void setRegDate(String regDate) {
		_regDate = regDate;
	}

	public int getHit() {
		return _hit;
	}

	public void setHit(int hit) {
		_hit = hit;
	}

	private long _bno;
	private String _subject;
	private String _writer;
	private String _contents;
	private String _regDate;
	private int _hit;

}