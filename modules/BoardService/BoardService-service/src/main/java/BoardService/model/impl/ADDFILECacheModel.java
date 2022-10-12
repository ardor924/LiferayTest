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

import BoardService.model.ADDFILE;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ADDFILE in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ADDFILECacheModel implements CacheModel<ADDFILE>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ADDFILECacheModel)) {
			return false;
		}

		ADDFILECacheModel addfileCacheModel = (ADDFILECacheModel)object;

		if (fno == addfileCacheModel.fno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{fno=");
		sb.append(fno);
		sb.append(", bno=");
		sb.append(bno);
		sb.append(", fName=");
		sb.append(fName);
		sb.append(", fPath=");
		sb.append(fPath);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ADDFILE toEntityModel() {
		ADDFILEImpl addfileImpl = new ADDFILEImpl();

		addfileImpl.setFno(fno);
		addfileImpl.setBno(bno);

		if (fName == null) {
			addfileImpl.setFName("");
		}
		else {
			addfileImpl.setFName(fName);
		}

		if (fPath == null) {
			addfileImpl.setFPath("");
		}
		else {
			addfileImpl.setFPath(fPath);
		}

		addfileImpl.resetOriginalValues();

		return addfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fno = objectInput.readLong();

		bno = objectInput.readLong();
		fName = objectInput.readUTF();
		fPath = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fno);

		objectOutput.writeLong(bno);

		if (fName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fName);
		}

		if (fPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fPath);
		}
	}

	public long fno;
	public long bno;
	public String fName;
	public String fPath;

}