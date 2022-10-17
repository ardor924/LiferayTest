package InitModuleProject.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_EDIT_WRITE_PROJECT
		},
		service = MVCRenderCommand.class
	)
public class HhlEditWriteMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		// 파라미터 가져온뒤 객체 바인딩
		String userName = ParamUtil.getString(renderRequest, "userName");
		renderRequest.setAttribute("userName", userName);
		
		
		

		
		return "/board/board_edit_form_write.jsp";
	}

}
