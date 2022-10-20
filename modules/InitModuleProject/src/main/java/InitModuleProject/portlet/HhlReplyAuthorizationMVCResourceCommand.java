package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_REPLY_AUTHORIZATION_PROJECT
		},
		service = MVCResourceCommand.class
	)
public class HhlReplyAuthorizationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	System.out.println("------------------------------Authorization-------------------------------------------------------");

	int rno = ParamUtil.getInteger(resourceRequest, "rno");
	
	
	JSONObject json = JSONFactoryUtil.createJSONObject();
	
	
	
	try {
		REP rep = REPLocalServiceUtil.getREP(rno);
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String currentUser = themeDisplay.getUser().getScreenName();
		
		
		if(currentUser.equals(rep.getRWriter()) || currentUser.equals("admin")) {
			
			
			json.put("result", "OK");
			
			
			resourceResponse.getWriter().write(json.toString());
			
		}else {
			json.put("result", "NO");
			resourceResponse.getWriter().write(json.toString());
		}

		

		
		
		
	} catch (PortalException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
	

	
	
	

	

	
	
	
	
	
				
				return false;
			}

		}
