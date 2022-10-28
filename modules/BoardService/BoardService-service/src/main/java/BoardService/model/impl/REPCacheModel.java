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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing REP in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class REPCacheModel implements CacheModel<REP>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof REPCacheModel)) {
			return false;
		}

		REPCacheModel repCacheModel = (REPCacheModel)object;

		if (rno == repCacheModel.rno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{rno=");
		sb.append(rno);
		sb.append(", bno=");
		sb.append(bno);
		sb.append(", rWriter=");
		sb.append(rWriter);
		sb.append(", rContents=");
		sb.append(rContents);
		sb.append(", rRegDate=");
		sb.append(rRegDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public REP toEntityModel() {
		REPImpl repImpl = new REPImpl();

		repImpl.setRno(rno);
		repImpl.setBno(bno);

		if (rWriter == null) {
			repImpl.setRWriter("");
		}
		else {
			repImpl.setRWriter(rWriter);
		}

		if (rContents == null) {
			repImpl.setRContents("");
		}
		else {
			repImpl.setRContents(rContents);
		}

		if (rRegDate == null) {
			repImpl.setRRegDate("");
		}
		else {
			repImpl.setRRegDate(rRegDate);
		}

		repImpl.resetOriginalValues();

		return repImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rno = objectInput.readLong();

		bno = objectInput.readLong();
		rWriter = objectInput.readUTF();
		rContents = objectInput.readUTF();
		rRegDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(rno);

		objectOutput.writeLong(bno);

		if (rWriter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rWriter);
		}

		if (rContents == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rContents);
		}

		if (rRegDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rRegDate);
		}
	}

	public long rno;
	public long bno;
	public String rWriter;
	public String rContents;
	public String rRegDate;

}