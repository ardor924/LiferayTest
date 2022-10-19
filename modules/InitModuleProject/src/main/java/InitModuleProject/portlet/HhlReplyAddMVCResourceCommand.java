package InitModuleProject.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.REP;
import BoardService.service.REPLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.service.ServiceMethod;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_REPLY_ADDLIST_PROJECT
		},
		service = MVCResourceCommand.class
	)
public class HhlReplyAddMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
/*------------------------------------기본설정 커스텀서비스 인스턴스-------------------------------------------------------------*/	
		ServiceMethod serviceMethod = new ServiceMethod();
/*------------------------------------댓글작성시(POST)-------------------------------------------------------------*/			
/*------------------------------------파라미터세팅-------------------------------------------------------------*/			
		
		long rno = ParamUtil.getInteger(resourceRequest, "rno");	
		int bno = ParamUtil.getInteger(resourceRequest, "bno");
		String rContents = ParamUtil.getString(resourceRequest, "rContents","error");
		String rWriter = ParamUtil.getString(resourceRequest, "rWriter","error");
		String rRegDate = serviceMethod.getStrNowDate();
		int parent = 0;
		int seqOrder = 0;
		
	
/*-----------------------------------DB에 REP 저장-----------------------------------------------------------------*/		
		
		
		REP rep = REPLocalServiceUtil.createREP(0);
		
		rep.setRno(rno);
		rep.setBno(bno);
		rep.setRContents(rContents);
		rep.setRWriter(rWriter);
		rep.setRRegDate(rRegDate);
		rep.setParent(parent);
		rep.setSeqOrder(seqOrder);
		


		rep = REPLocalServiceUtil.addREP(rep);
		
		int totalInt = REPLocalServiceUtil.getREPsCount();		
		String totalCnt = Integer.toString(totalInt);

		
		try {
			resourceResponse.getWriter().write("Great!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
		
		
		return false;
	}

}
