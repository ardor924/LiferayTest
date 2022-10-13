package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.File;
import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.service.ADDFILELocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
@Component(immediate = true, property = {

		"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
		"mvc.command.name=" + ConstantsCommands.HHLBOARD_FILEDELETE_PROJECT
		}, 
		service = MVCResourceCommand.class
		)
public class HhlFileDeleteResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		
		long fno = ParamUtil.getInteger(resourceRequest, "fno");
		boolean success = false;
		try {
			ADDFILE addFile =  ADDFILELocalServiceUtil.getADDFILE(fno);
			String fPath = addFile.getFPath();
			String fRealName = addFile.getFRealName();
			
			
			File file = new File(fPath+fRealName);
			
			
			boolean delete = file.delete();
			
			if(delete) {
				
				ADDFILE deletedFile = ADDFILELocalServiceUtil.deleteADDFILE(fno);
				
				if(deletedFile != null) {
					success = true;
				}
			}
			
			
			
			
		} catch (PortalException e1) {


			
			e1.printStackTrace();
		}
		
		
		
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		
		
		if(success) {
			json.put("result", "OK");
		}else {
			json.put("result", "NO");
		}
			
	 	try {
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		return false;
	}

}
