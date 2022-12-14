package InitModuleProject.portlet;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
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

import BoardService.model.ADDFILE;
import BoardService.model.TBL;
import BoardService.service.ADDFILELocalServiceUtil;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.FileVO;
import InitModuleProject.service.ServiceMethod;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_WRITE_PROJECT
		},
		service = MVCActionCommand.class
	)
public class HhlWriteMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		

		
		
		
		System.out.println("-------------------------!!!!!-----------------------------------");
		System.out.println("-------------------------writeCommand-----------------------------------");
		System.out.println("-------------------------writeCommand-----------------------------------");
		
		  ServiceMethod serviceMethod = new ServiceMethod();
		  
		  long bno = ParamUtil.getInteger(actionRequest, "bno"); 
		  String subject = ParamUtil.getString(actionRequest, "subject"); 
		  String writer = ParamUtil.getString(actionRequest, "writer"); 
		  String contents = ParamUtil.getString(actionRequest, "contents"); 
		  String strDate = serviceMethod.getStrNowDate(); 
		  int hit = 0;
		  
		  
		  System.out.println("contents : "+contents );
		  
		  
		  TBL tbl = TBLLocalServiceUtil.createTBL(0);
		  
		  tbl.setBno(bno); 
		  tbl.setSubject(subject); 
		  tbl.setWriter(writer);
		  tbl.setContents(contents);
		  tbl.setRegDate(strDate); 
		  tbl.setHit(hit);
		  
		  tbl = TBLLocalServiceUtil.addTBL(tbl);
		  
		
		
		
		
		try {
			// ?????? url??????
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), PortletRequest.RENDER_PHASE);	
			portletURL.setParameter("mvcRenderCommandName", ConstantsCommands.HHLBOARD_LIST_PROJECT);
			actionResponse.sendRedirect(portletURL.toString());
			} 
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return false;
	}

}
