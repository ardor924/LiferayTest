package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.REP;
import BoardService.service.REPLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_REPLY_DELETE_PROJECT
		},
		service = MVCResourceCommand.class
	)
public class HhlReplyUpdateMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	long rno = ParamUtil.getInteger(resourceRequest, "rno");
	long bno = ParamUtil.getInteger(resourceRequest, "bno");
	String rWriter = ParamUtil.getString(resourceRequest, "rWriter");
	String rContents = ParamUtil.getString(resourceRequest, "rContents");
	String rRegDate = ParamUtil.getString(resourceRequest, "rRegDate");
	int rIndent = ParamUtil.getInteger(resourceRequest, "rIndent");
	int rAnsNum = ParamUtil.getInteger(resourceRequest, "rAnsNum");
		
		System.out.println("rno:"+rno);

			

			try {
				REP rep = REPLocalServiceUtil.getREP(rno);
				
				rep.setRno(rno);
				rep.setBno(bno);
				rep.setRWriter(rWriter);
				rep.setRContents(rContents);
				rep.setRRegDate(rRegDate);
				rep.setRIndent(rIndent);
				rep.setRAnsNum(rAnsNum);
				
				
				rep = REPLocalServiceUtil.updateREP(rep);
				
				resourceResponse.getWriter().write("update complete");
				
				
			} catch (PortalException | IOException e) {
				
			
				e.printStackTrace();
			}
			
			


			
		
		return false;
	

	}
}
