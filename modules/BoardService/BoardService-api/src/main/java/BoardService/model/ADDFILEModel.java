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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ADDFILE service. Represents a row in the &quot;HHL_PROJECT_ADDFILE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>BoardService.model.impl.ADDFILEModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>BoardService.model.impl.ADDFILEImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ADDFILE
 * @generated
 */
@ProviderType
public interface ADDFILEModel extends BaseModel<ADDFILE> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a addfile model instance should use the {@link ADDFILE} interface instead.
	 */

	/**
	 * Returns the primary key of this addfile.
	 *
	 * @return the primary key of this addfile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this addfile.
	 *
	 * @param primaryKey the primary key of this addfile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fno of this addfile.
	 *
	 * @return the fno of this addfile
	 */
	public long getFno();

	/**
	 * Sets the fno of this addfile.
	 *
	 * @param fno the fno of this addfile
	 */
	public void setFno(long fno);

	/**
	 * Returns the bno of this addfile.
	 *
	 * @return the bno of this addfile
	 */
	public long getBno();

	/**
	 * Sets the bno of this addfile.
	 *
	 * @param bno the bno of this addfile
	 */
	public void setBno(long bno);

	/**
	 * Returns the f real name of this addfile.
	 *
	 * @return the f real name of this addfile
	 */
	@AutoEscape
	public String getFRealName();

	/**
	 * Sets the f real name of this addfile.
	 *
	 * @param fRealName the f real name of this addfile
	 */
	public void setFRealName(String fRealName);

	/**
	 * Returns the f name of this addfile.
	 *
	 * @return the f name of this addfile
	 */
	@AutoEscape
	public String getFName();

	/**
	 * Sets the f name of this addfile.
	 *
	 * @param fName the f name of this addfile
	 */
	public void setFName(String fName);

	/**
	 * Returns the f path of this addfile.
	 *
	 * @return the f path of this addfile
	 */
	@AutoEscape
	public String getFPath();

	/**
	 * Sets the f path of this addfile.
	 *
	 * @param fPath the f path of this addfile
	 */
	public void setFPath(String fPath);

	/**
	 * Returns the f date of this addfile.
	 *
	 * @return the f date of this addfile
	 */
	@AutoEscape
	public String getFDate();

	/**
	 * Sets the f date of this addfile.
	 *
	 * @param fDate the f date of this addfile
	 */
	public void setFDate(String fDate);

}