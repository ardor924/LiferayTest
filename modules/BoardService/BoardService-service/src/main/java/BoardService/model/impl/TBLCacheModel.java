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

import BoardService.model.TBL;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TBL in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TBLCacheModel implements CacheModel<TBL>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TBLCacheModel)) {
			return false;
		}

		TBLCacheModel tblCacheModel = (TBLCacheModel)object;

		if (bno == tblCacheModel.bno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{bno=");
		sb.append(bno);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", writer=");
		sb.append(writer);
		sb.append(", contents=");
		sb.append(contents);
		sb.append(", regDate=");
		sb.append(regDate);
		sb.append(", hit=");
		sb.append(hit);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TBL toEntityModel() {
		TBLImpl tblImpl = new TBLImpl();

		tblImpl.setBno(bno);

		if (subject == null) {
			tblImpl.setSubject("");
		}
		else {
			tblImpl.setSubject(subject);
		}

		if (writer == null) {
			tblImpl.setWriter("");
		}
		else {
			tblImpl.setWriter(writer);
		}

		if (contents == null) {
			tblImpl.setContents("");
		}
		else {
			tblImpl.setContents(contents);
		}

		if (regDate == null) {
			tblImpl.setRegDate("");
		}
		else {
			tblImpl.setRegDate(regDate);
		}

		tblImpl.setHit(hit);

		tblImpl.resetOriginalValues();

		return tblImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bno = objectInput.readLong();
		subject = objectInput.readUTF();
		writer = objectInput.readUTF();
		contents = objectInput.readUTF();
		regDate = objectInput.readUTF();

		hit = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bno);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (writer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(writer);
		}

		if (contents == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contents);
		}

		if (regDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(regDate);
		}

		objectOutput.writeInt(hit);
	}

	public long bno;
	public String subject;
	public String writer;
	public String contents;
	public String regDate;
	public int hit;

}