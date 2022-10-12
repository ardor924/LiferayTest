package InitModuleProject.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.model.TBL;
import BoardService.service.ADDFILELocalServiceUtil;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.FileVO;
import InitModuleProject.service.ServiceMethod;

@Component(immediate = true, property = {

		"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
		"mvc.command.name=" + ConstantsCommands.HHLBOARD_FILEUPLOAD_PROJECT 
		}, 
		service = MVCResourceCommand.class
		)

public class HhlFileUploadMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		ServiceMethod serviceMethod = new ServiceMethod();
		
		  HttpServletRequest reqest = PortalUtil.getHttpServletRequest(resourceRequest); 
		  HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		  

		  JSONObject json = JSONFactoryUtil.createJSONObject();
		  
		  // content_file formData 받기.. 
		  
		  
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User writerUser = themeDisplay.getUser();
			String writer = writerUser.getScreenName();
			
			
			String regDate = serviceMethod.getStrNowDate();
		  

		  
		  System.out.println("----------------HhlFileUploadMVCResourceCommand - Successed!----------------------------------");
		  
		  UploadPortletRequest uploadRequest =PortalUtil.getUploadPortletRequest(resourceRequest);
		  long bno = ParamUtil.getLong(uploadRequest, "bno", 0);
		 String subject = ParamUtil.getString(uploadRequest, "subject", "");
		 String contents = ParamUtil.getString(uploadRequest, "contents", "");
		 
		 System.out.println("bno : "+bno);
		 System.out.println("subject : " + subject);  
		System.out.println("contents : " + contents);
		TBL tbl = TBLLocalServiceUtil.createTBL(bno);
		tbl.setSubject(subject);
		tbl.setContents(contents);
		tbl.setWriter(writer);
		tbl.setRegDate(regDate);
		
		
		System.out.println("1");
		if(bno > 0) {
			System.out.println("2");
			tbl = TBLLocalServiceUtil.updateTblWithTbl(tbl);
			System.out.println("3");
		}else {
			System.out.println("4");
			tbl = TBLLocalServiceUtil.addTblWithIncrement(tbl);
			bno = tbl.getBno();
			System.out.println("5");
		}
		System.out.println("6");
		 File[] files = uploadRequest.getFiles("content_file");
		 String[] fileNames = uploadRequest.getFileNames("content_file");
		 System.out.println("files : " + files.length);
		 String ResourceFolder = "\\resources\\"; 
		 String UPLOAD_DIR = "file_repo";
		 String uploadPath = reqest.getContextPath()+File.separator+ResourceFolder+UPLOAD_DIR;

		 int j = 0; System.out.println("files>>>>>>>>>>>"+files.length);
		 // 생성할 파일의 경로 및 파일명 으로 File 객체 생성
		 for (File file : files) { 
		 System.out.println("-------------");

		 String originalName = file.getName(); 
		 String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
		 
		 String uuid = UUID.randomUUID().toString();
		 
		 
		 String savefileName = uploadPath + File.separator + uuid + "_" + fileName;
		 
		 Path savePath = Paths.get(savefileName); // 파일명+라이프레이 리소스내부 경로
		 
		  System.out.println("Size: "+ file.length()); // 파일사이즈 
		  System.out.println("file : " + file.toString()); // 파일절대경로
		  System.out.println("originalName : " + originalName); // 기존 파일명
		  System.out.println("fileName : " + file.getName()); // 기존 파일명
		 System.out.println("savefileName : "+savefileName);
		 System.out.println("savePath : "+savePath);
		 System.out.println("### fileName : " + fileNames[j]);
		 
		 	try {
				  File copy = new File("C:\\file_repo\\"+uuid+fileNames[j]);
				  
				  long fSize = file.length(); // 원본 파일 크기 변환
				  System.out.println("fileSize : " + fSize);
				  
				  FileInputStream fis = new FileInputStream(file);
				  FileOutputStream fos = new FileOutputStream(copy);
				  
				  int input=0, count=0;
				  
				  byte[] data = new byte[1024];
				  
				  while((input=fis.read(data))!=-1){
				   // 배열을 할 때는 0부터 끝까지 넣어야함
				   fos.write(data, 0, input);
				   count+=input;
				   
				   // (읽은 바이트 수 / 전체 파일 크기) * 100
				   float per = ((float)count/fSize) * 100;
					/* System.out.println((int)per + "% copy complete"); */
				   
				  }
		 	}catch (IOException e) {
		 			
		 			
		 		
		 				e.printStackTrace();
					 }
		 	

			
			 ADDFILE addFile = ADDFILELocalServiceUtil.createADDFILE(0);
			 
			 System.out.println("bno : " + bno);
			 addFile.setBno(bno);
			 addFile.setFName(fileNames[j]);
			 addFile.setFPath("C:\\file_repo\\"+uuid+fileNames[j]);
			 
			 
			 addFile = ADDFILELocalServiceUtil.addADDFILEWithIncrement(addFile);
			 
			 
			 
			 

	        
		 	
		 	j++;
			} // END for문
		 	
		 	json.put("result", "OK");
		 	json.put("bno", bno);
		 	try {
				resourceResponse.getWriter().write(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 

		return false;
	

	}

}