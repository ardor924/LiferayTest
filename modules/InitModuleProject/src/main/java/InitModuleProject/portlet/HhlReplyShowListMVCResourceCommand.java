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
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_REPLY_SHOWLIST_PROJECT
		},
		service = MVCResourceCommand.class
	)
public class HhlReplyShowListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	System.out.println("------------------------------ReplyShowList-------------------------------------------------------");
/*------------------------------------기본설정 커스텀서비스 인스턴스-------------------------------------------------------------*/	
	ServiceMethod serviceMethod = new ServiceMethod();
/*-----------------------------------------------------------------------------------------------------------------------*/		
/*-----------------------------------JSON형식으로 보내기(GET)------------------------------------------------------------*/				
/*-----------------------------------------------------------------------------------------------------------------------*/		
		int page = ParamUtil.getInteger(resourceRequest, "page");

		int total = REPLocalServiceUtil.getREPsCount();
		

		
			
		int bno = ParamUtil.getInteger(resourceRequest, "bno");
		//int rno = ParamUtil.getInteger(resourceRequest, "rno");		
		
		
		
		//List<REP> reply_list = REPLocalServiceUtil.getREPListBybno(bno, 0, REPLocalServiceUtil.getREPsCount());
		//List<REP> reply_list = REPLocalServiceUtil.getREPListBybno(bno,offset,limit);
		List<REP> reply_list = REPLocalServiceUtil.getREPListBybno(bno,page);
		//List<REP> reply_list  = serviceMethod.getReplyList(bno);
		//List<REP> reply_list  = serviceMethod.getReplyList(bno,offset,limit);
				
	 	JSONArray jArray = JSONFactoryUtil.createJSONArray();//배열이 필요할때  
		for (int i = 0; i < reply_list.size(); i++)//배열                    
			{                        
			JSONObject sObject = JSONFactoryUtil.createJSONObject(); //오브젝트 파싱 
			
			//배열 내에 들어갈 json                        
			sObject.put("bno", reply_list.get(i).getBno());                        
			sObject.put("rno", reply_list.get(i).getRno());                      
			sObject.put("rWriter", reply_list.get(i).getRWriter());                        
			sObject.put("rContents", reply_list.get(i).getRContents().replace("\n","<br/>")); // 댓글 개행처리                   
			sObject.put("rRegDate", reply_list.get(i).getRRegDate());                     
                 
			jArray.put(sObject);
			}  		 
		  
			System.out.println("jArray : "+jArray.toString());
			System.out.println("page :"+page);
					
		try {
			resourceResponse.getWriter().write(jArray.toString());
			
		
		} catch (IOException e) {


			e.printStackTrace();
		}

				
				return false;
			}

		}
