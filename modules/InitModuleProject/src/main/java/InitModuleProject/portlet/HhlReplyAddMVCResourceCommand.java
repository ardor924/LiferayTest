package InitModuleProject.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/*------------------------------------기본설정-------------------------------------------------------------*/	
		ServiceMethod serviceMethod = new ServiceMethod();
		
		String ajaxType = ParamUtil.get(resourceRequest, "ajaxType","get");
	
		
		
/*------------------------------------댓글작성시(POST)-------------------------------------------------------------*/			
/*------------------------------------파라미터세팅-------------------------------------------------------------*/			
		
		if(ajaxType.equals("post")) {
		
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
		
		};
/*-----------------------------------------------------------------------------------------------------------------------*/		
/*-----------------------------------JSON형식으로 보내기(GET)------------------------------------------------------------*/				
/*-----------------------------------------------------------------------------------------------------------------------*/		
		int page = ParamUtil.getInteger(resourceRequest, "page");
		int limit = 10;
		int offset = limit * (page - 1);
		
		int bno = ParamUtil.getInteger(resourceRequest, "bno");
		List<REP> reply_list = REPLocalServiceUtil.getREPListBybno(bno, offset, limit);


		  
	 	JSONArray jArray = JSONFactoryUtil.createJSONArray();//배열이 필요할때  
		for (int i = 0; i < reply_list.size(); i++)//배열                    
			{                        
			JSONObject sObject = JSONFactoryUtil.createJSONObject(); //오브젝트 파싱 
			
			//배열 내에 들어갈 json                        
			sObject.put("bno", reply_list.get(i).getBno());                        
			sObject.put("rno", reply_list.get(i).getRno());                      
			sObject.put("rWriter", reply_list.get(i).getRWriter());                        
			sObject.put("rContents", reply_list.get(i).getRContents());                        
			sObject.put("rRegDate", reply_list.get(i).getRRegDate());                     
			sObject.put("parent", reply_list.get(i).getParent());                        
			sObject.put("seqOrder", reply_list.get(i).getParent());                        
			jArray.put(sObject);
			}  		 
		  
			System.out.println("jArray : "+jArray.toString());
		
		
		try {
			resourceResponse.getWriter().write(jArray.toString());
		} catch (IOException e) {


			e.printStackTrace();
		}

		
		return false;
	}

}
