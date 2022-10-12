package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
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
			"mvc.command.name="+ ConstantsCommands.HHLBOARD_FILEDOWNLOAD_PROJECT
		},
		service = MVCActionCommand.class
	)
public class HhlFileDownloadMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		System.out.println("Download Action area!!!!!");
		
		long fno = ParamUtil.getLong(actionRequest, "fno", 0);
		System.out.println("fno : "+ fno);
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		System.out.println("1");
		try {
			ADDFILE addFile = ADDFILELocalServiceUtil.getADDFILE(fno);
			System.out.println("2");
			String fPath = addFile.getFPath();
			System.out.println("3");
			System.out.println("fPath : " + fPath);
			File file = new File(fPath);
			System.out.println("4");
			System.out.println("file.exists() : "+file.exists());
			if(file.exists()) {
				 in = new FileInputStream(file);
				 HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
				 
				 out = response.getOutputStream();
				 response.setContentType("application/pdf");
				 response.setContentLength((int) file.length());
				 response.setHeader("Content-Disposition", "attachment;filename="+addFile.getFName());
				 
				 for (int i = in.read(); i != -1; i = in.read()) {
					 out.write(i);
				 }
			}
			System.out.println("5");
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
