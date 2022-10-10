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

package BoardService.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link REPService}.
 *
 * @author Brian Wing Shun Chan
 * @see REPService
 * @generated
 */
public class REPServiceWrapper
	implements REPService, ServiceWrapper<REPService> {

	public REPServiceWrapper(REPService repService) {
		_repService = repService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _repService.getOSGiServiceIdentifier();
	}

	@Override
	public REPService getWrappedService() {
		return _repService;
	}

	@Override
	public void setWrappedService(REPService repService) {
		_repService = repService;
	}

	private REPService _repService;

}