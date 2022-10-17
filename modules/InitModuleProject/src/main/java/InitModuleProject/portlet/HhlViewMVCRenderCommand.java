package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_VIEW_PROJECT
		},
		service = MVCRenderCommand.class
	)
public class HhlViewMVCRenderCommand implements MVCRenderCommand{
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("--------------------ViewCommand----------------------");


		// PK가져와서 tbl로 객체바인딩
		long bno = ParamUtil.getLong(renderRequest, "bno", -1);
		String currentPage = ParamUtil.getString(renderRequest, "currentPage");
		String cntPerPage = ParamUtil.getString(renderRequest, "cntPerPage");
		String ORDER = ParamUtil.getString(renderRequest, "ORDER");
		String userName = ParamUtil.getString(renderRequest, "userName"); 
		String keyword = ParamUtil.getString(renderRequest, "keyword"); 
		String option = ParamUtil.getString(renderRequest, "option"); 
		
		
		System.out.println("bno : " + bno);
		System.out.println("currentPage : " + currentPage);
		System.out.println("cntPerPage : " + cntPerPage);
		System.out.println("ORDER : " + ORDER);
		
		// 조회수 증가
		if(bno > 0) {
			boolean success = TBLLocalServiceUtil.addHitTBL(bno);
			if(success) {
				System.out.println("hit is updated");
			}else {
				System.out.println("hit update failed..");
			}
		}
		
		
		
		try {
			TBL tbl = TBLLocalServiceUtil.getTBL(bno);
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY); 
			  
			renderRequest.setAttribute("mine", themeDisplay.getUser().getScreenName().equals(tbl.getWriter()) || themeDisplay.getUser().getScreenName().equals("admin"));
			
			renderRequest.setAttribute("tbl", tbl);
			renderRequest.setAttribute("currentPage", currentPage);
			renderRequest.setAttribute("cntPerPage", cntPerPage);
			renderRequest.setAttribute("ORDER", ORDER);
			renderRequest.setAttribute("keyword", keyword);
			renderRequest.setAttribute("option", option);
			renderRequest.setAttribute("userName", userName);
			
			
			
			List<ADDFILE> fileList = ADDFILELocalServiceUtil.getfileListBybno(bno);
			renderRequest.setAttribute("fileList", fileList);
			
			System.out.println("fileList:"+fileList);
			
			
			
			
			/*
			 * renderRequest.setAttribute("fName", fName);
			 * renderRequest.setAttribute("fPath", fPath);
			 */
			
			
			
			
			
			
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return "/board/board_view_subject.jsp";
	}

}
