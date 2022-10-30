package InitModuleProject.portlet;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import BoardService.model.TBL;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
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
		  
		  int subject_id = 10;
				  
		  // int subject_id = subjectCnt + TBLLocalServiceUtil.getTBLsCount();
		  
		  // System.out.println("====================================>subject_id : "+subject_id );
		  
		  
		  TBL tbl = TBLLocalServiceUtil.createTBL(0);
		  
		  tbl.setBno(bno); 
		  tbl.setSubject(subject); 
		  tbl.setWriter(writer);
		  tbl.setContents(contents);
		  tbl.setRegDate(strDate); 
		  tbl.setHit(hit);
		  tbl = TBLLocalServiceUtil.addTblWithIncrement(tbl);
		  
		
		
		
		
		try {
			// 보낼 url설정
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
