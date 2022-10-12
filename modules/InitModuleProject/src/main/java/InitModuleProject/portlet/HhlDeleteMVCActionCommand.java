package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import BoardService.model.TBL;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;

@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_DELETE_PROJECT
		},
		service = MVCActionCommand.class
	)
public class HhlDeleteMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		
		System.out.println("진입 확인!");
		
		long bno = ParamUtil.getInteger(actionRequest, "bno" ,-1);
		
		System.out.println("bno:"+bno);
		
		try {
			TBL tbl = TBLLocalServiceUtil.getTBL(bno);
			
			tbl = TBLLocalServiceUtil.deleteTBL(bno);
			
			System.out.println("delete complete!");
			
			
			actionRequest.setAttribute("bno", bno);
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			// 보낼 url설정
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), PortletRequest.RENDER_PHASE);	
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("mvcRenderCommandName", ConstantsCommands.HHLBOARD_LIST_PROJECT);
			actionResponse.sendRedirect(portletURL.toString());
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return false;
	}

}
