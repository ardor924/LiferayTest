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
import javax.servlet.http.HttpServletRequest;
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
	System.out.println("-------------------------FileDownload Action area--------------------------------------------------------------------------------");
	/* --------------------------------------------- 기본세팅 ------------------------------------------------------------*/System.out.println();		 
	
	HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
	HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

	FileInputStream in = null;  // 설명 : 다운로드시 FileInputStream과 ServletOutputStream를 사용하여 구현
	ServletOutputStream out = null; // HttpServletResponse 필요  -> 다운시 setContentType과 setContentLength ,setHeader 로 받기위함
	
	/* --------------------------------------------- 파라미터 세팅 ------------------------------------------------------------*/System.out.println();		 
		try {
		
		long fno = ParamUtil.getLong(actionRequest, "fno", 0);
		ADDFILE addFile = ADDFILELocalServiceUtil.getADDFILE(fno);
		String fRealName = addFile.getFRealName();
		String fPath = addFile.getFPath();
	/* --------------------------------------------- 파일 다운로드 ------------------------------------------------------------*/System.out.println();	
		

		File file = new File(fPath+fRealName); // 설명 : 파일의 경로 + 실제파일명 으로 새로운 파일객체를 생성한다.
		
		if(file.exists()) { // 파일이 폴더에 실제로 존재하는경우 실행
			in = new FileInputStream(file);  
			out = response.getOutputStream();
			
			 response.setContentType("application/pdf"); // 설명 : PDF다운 받기 위한설정
			 response.setContentLength((int) file.length()); 
			 response.setHeader("Content-Disposition", "attachment;filename="+addFile.getFRealName()); // 필수. 없으면 바이너리로 표기된 페이지만 전환됨
			
			for(int i = in.read(); i != -1; i = in.read()) {
				out.write(i);
			}
	
		}else {
			System.out.println("File Not Found");
		}
		
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
			if(in != null) { // FileInputStream에 파일이 있을경우 닫아준다.
				try {
					in.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if(out != null) { // ServletOutputStream에 파일이 있을경우 버퍼를 비워주고 닫아준다.
				
				try {
					out.flush();
					out.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
		}
		
		
		return false;
	}

}
