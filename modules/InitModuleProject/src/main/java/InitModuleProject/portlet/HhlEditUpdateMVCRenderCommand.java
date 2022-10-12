package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.model.TBL;
import BoardService.service.ADDFILELocalServiceUtil;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_EDIT_UPDATE_PROJECT
		},
		service = MVCRenderCommand.class
	)
public class HhlEditUpdateMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("--------------------EditUpdateCommand----------------------");
		// PK가져와서 tbl로 객체바인딩
		long bno = ParamUtil.getInteger(renderRequest, "bno");
		String currentPage = ParamUtil.getString(renderRequest, "currentPage");
		String cntPerPage = ParamUtil.getString(renderRequest, "cntPerPage");
		String keyword = ParamUtil.getString(renderRequest, "keyword");
		String option = ParamUtil.getString(renderRequest, "option");
		String ORDER = ParamUtil.getString(renderRequest, "ORDER");
		
		
		System.out.println("bno : " + bno);
		System.out.println("currentPage : " + currentPage);
		System.out.println("cntPerPage : " + cntPerPage);
		System.out.println("ORDER : " + ORDER);
		

		List<ADDFILE> fileList = ADDFILELocalServiceUtil.getfileListBybno(bno);
		renderRequest.setAttribute("fileList", fileList);
		
		System.out.println("fileList:"+fileList);
		
		try {
			TBL tbl = TBLLocalServiceUtil.getTBL(bno);
			renderRequest.setAttribute("tbl", tbl);
			renderRequest.setAttribute("currentPage", currentPage);
			renderRequest.setAttribute("cntPerPage", cntPerPage);
			renderRequest.setAttribute("keyword", keyword);
			renderRequest.setAttribute("option", option);
			renderRequest.setAttribute("ORDER", ORDER);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "/board/board_edit_form_update.jsp";
	}

}
