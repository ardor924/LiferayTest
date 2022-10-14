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
			"mvc.command.name="+ ConstantsCommands.HHLBOARD_IMAGESHOW_PROJECT
		},
		service = MVCActionCommand.class
	)
public class HhlImageShowActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		System.out.println("---------------------------------ImageShow RenderCommand------------------------------------");
		System.out.println("---------------------------------ImageShow RenderCommand------------------------------------");
		System.out.println("---------------------------------ImageShow RenderCommand------------------------------------");
		
	
	 // 리스폰스 세팅
	 HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
	 
	 // 아웃풋 인풋 초기세팅
	 FileInputStream in = null;
	 ServletOutputStream out = null;
	 
	 
	 
	 // 파라미터 세팅
	 
	 long fno = ParamUtil.getLong(actionRequest, "fno");
	 ADDFILE addFile;
	 try {
	 	addFile = ADDFILELocalServiceUtil.getADDFILE(fno);
	 	String fPath = addFile.getFPath();
	 	String  fRealName = addFile.getFRealName();
	 	
	 	
	 	// 파일 세팅
	 	File file = new File(fPath+fRealName);
	 	
	 	
	 	// 파일이 있을때 입출력 로직실행
	 	if(file.exists()) {
	 		
	 		// in out 재설정
	 		in = new FileInputStream(file);
	 		out = response.getOutputStream();
	 		
	 		// 크기 초기화 설정
	 		int size;
	 		
	 		// 버퍼설정
	 		byte[] buffer = new byte[1024]; // 버퍼크기가 크면 버퍼링 시간은 길지만 버퍼링 횟수가 적고, 버퍼크기가 작으면 버퍼링 시간을 줄일수 있지만 버퍼링 횟수가 많아짐.
	 		response.setContentType("image/jpeg, image/jpeg, image/png, image/gif, image/bmp");
	 		
	 		// 반복문으로 파일을 0까지 읽고 쓰기
	 		while(( size = in.read(buffer) ) != -1 )
	 			out.write(buffer,0,size);
	 		
	 	} 
	 	
	 } catch (PortalException e) {
	 	e.toString();
	 	
	 }catch (FileNotFoundException e) {
	 	e.toString();
	 
	 }catch (IOException e) {
	 	e.toString();
	 
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
