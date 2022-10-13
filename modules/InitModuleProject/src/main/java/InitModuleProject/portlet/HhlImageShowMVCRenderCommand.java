package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.service.ADDFILELocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_IMAGESHOW_PROJECT
		},
		service = MVCRenderCommand.class
	)
public class HhlImageShowMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse){
	System.out.println("---------------------------------ImageShow RenderCommand------------------------------------");
	
	
	try {	
	
		HttpServletResponse response = PortalUtil.getHttpServletResponse(renderResponse);
		ServletOutputStream imgout = response.getOutputStream();

	
		long fno = ParamUtil.getInteger(renderRequest, "fno");
		ADDFILE addFile = ADDFILELocalServiceUtil.getADDFILE(fno);
		
		String fRealName = addFile.getFRealName();
		String fPath = addFile.getFPath();
		
		
	    File file = new File(fPath + fRealName);
	    
	    if(file.exists()){ 	 //파일이 있는 경우 로직실행

	    
	    FileInputStream fis = new FileInputStream(fPath);
	    int length;
	    byte[] buffer = new byte[10];
	    while( (length = fis.read(buffer)) != -1)
	        imgout.write(buffer, 0, length);
	    
	    
	    System.out.println("fullPath : "+fRealName+file);
	}

	}catch (IOException e) {
		e.getStackTrace();
 	}catch (PortalException e) {
		e.getStackTrace();
	} 
	
	
	

		
		
		
		return null;
	}

}
