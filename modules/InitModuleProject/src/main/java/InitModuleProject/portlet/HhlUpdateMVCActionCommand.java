package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.resiliency.spi.agent.SPIAgent.Lifecycle;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.model.TBL;
import BoardService.service.ADDFILELocalServiceUtil;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.FileVO;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_UPDATE_PROJECT
		},
		service = MVCActionCommand.class
	)
public class HhlUpdateMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		

		try {
			// 보낼 url설정
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, MainHhlBoardPortletKeys.MAINHHLBOARD, Lifecycle.RENDER.toString());	
			portletURL.setPortletMode(PortletMode.VIEW); 
			portletURL.setParameter("mvcRenderCommandName", ConstantsCommands.HHLBOARD_LIST_PROJECT);	
			actionResponse.sendRedirect(portletURL.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}
			

		
		return false;
	}

}
