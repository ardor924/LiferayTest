package InitModuleProject.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.ADDFILE;
import BoardService.model.TBL;
import BoardService.service.ADDFILELocalServiceUtil;
import BoardService.service.TBLLocalServiceUtil;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.BoardPagingVO;
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
		
	System.out.println("-------------------------FileUpload & Data Update/Regist ResourceArea--------------------------------------------");
	/* --------------------------------------------- 기본 세팅 ------------------------------------------------------------*/System.out.println();	 
		
		ServiceMethod serviceMethod = new ServiceMethod();    //  설명 : 사용자정의 서비스 
		JSONObject json = JSONFactoryUtil.createJSONObject(); // 설명 : ajax에서 받아온 데이터를 json 형태로 보내기 위한 객체를 생성
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest); // 설명 : 업로드로직을 위한 uploadRequest 생성
	/* --------------------------------------------- 파라미터 세팅 ------------------------------------------------------------*/System.out.println();		 
		
		String writer = serviceMethod.getScreenNameResource(resourceRequest, resourceResponse); // 설명 : themeDisplay로 user의 screenName을 가져온다.
		String regDate = serviceMethod.getStrNowDate(); // 설명 : simpleDateFormat 으로 String 형태로 변환한 날짜값을 가져온다.
		
		
		long bno = ParamUtil.getLong(uploadRequest, "bno"); 	              // 설명 : 각각의 파라미터를 가져온다
		String subject = ParamUtil.getString(uploadRequest, "subject", "");   //
		String contents = ParamUtil.getString(uploadRequest, "contents", ""); //
		
	/* --------------------------------------------- DB에 글 등록 처리(등록/수정) ------------------------------------------------------------*/System.out.println(3);	
		
		
		if(bno > 0) { // 이미 존재하는 게시글은 번호가 1 이상 이므로 업데이트 처리한다.
			
			try {
				TBL tbl = TBLLocalServiceUtil.getTBL(bno);
				tbl.setBno(bno);
				tbl.setWriter(writer);                         
				tbl.setContents(contents);                     
				tbl.setSubject(subject);                       
				tbl.setRegDate(regDate);
				tbl = TBLLocalServiceUtil.updateTBL(tbl);		
				
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		else {	// 번호가 0일때는 게시글이 없는 상태이므로 게시글을 등록 처리한다.
		TBL tbl = TBLLocalServiceUtil.createTBL(0);  // 설명 : 테이블에 새로운 게시글을 생성 (bno를 먼저세팅할경우 중복된값이 들어갈수 있으므로 하단에 빼놓음)					                   
		tbl.setBno(bno);							   //
		tbl.setWriter(writer);                         //
		tbl.setContents(contents);                     //
		tbl.setSubject(subject);                       //
		tbl.setRegDate(regDate);                       //
		tbl = TBLLocalServiceUtil.addTblWithIncrement(tbl);         //
		bno = tbl.getBno();
		}
	/* --------------------------------------------- 파일업로드처리 ------------------------------------------------------------*/System.out.println(4);			
		System.out.println("bno : "+bno);
		File[] files = uploadRequest.getFiles("content_file"); // 설명 : ajax로 가져온 formData에 담긴 파일데이터를 가져와서 File[] 배열에 담는다 / 파일의 갯수가 복수이므로 File[] 사용
		String [] fileNames = uploadRequest.getFileNames("content_file"); // formData에 파일이름을 가져와 String [] 배열에 담는다
		
		String fRoot= "C:\\file_repo\\";  // 설명 : 업로드할 폴더명을 선언한다. 
		String fDate = serviceMethod.getFolderDate(); // 설명 : simpleDateFormat 으로 String 형태로 변환한 날짜값을 가져온다.
		String uuid = UUID.randomUUID().toString();
		
		String fPath = fRoot+fDate+"\\"; // 설명 : (폴더루트 + 날짜 + "\\")를 합친 경로
		
		long maxFileSize = 10 * 1024 * 1024; // 업로드 최대 파일크기 제한
		
		int cnt = 0; 	// 설명 : 파일의 갯수만큼 cnt를 증가시키면서 파일 이름을 각각 다르게 처리한다.
		if(files != null) {  	// 설명 : 파일이 있다는것은 글등록/수정 할때 파일을 보냈다는것이므로 파일 업로드처리를 한다.
			for (File file : files ) { 	// 설명 : File[] 배열에서 File타입 파일들을 하나씩 추출한다.

			
				
		long fileSize = file.length();
		
		if(fileSize < maxFileSize) { // 최대 파일 사이즈에 제한이 없는경우 로직 실행
				
				
				
				File folderGenerator = new File(fRoot+fDate);
				
				if(!folderGenerator.exists()) {
					folderGenerator.mkdir();
				}else {
					System.out.println("The folder is already exist!");
				}		
				
				
				
				
				
				

				try { // 설명 : fPath = C:￦ 루트 + 날짜지정
					File copy = new File(fPath + uuid +"_"+ fileNames[cnt]); // 설명 :날짜를 지정한 폴더명에 랜덤UUI+'_'+파일명을 더해 새로운 카피 파일을 생성한다(업로드)				
					long fSize = file.length();  // 설명 : 각각에 원본 파일크기를 설정한다. 
					FileInputStream fis = new FileInputStream(file); // 설명 : 추출된 각각의 파일원본을 FileInputStream으로 읽어들이기 위해 세팅한다
					FileOutputStream fos = new FileOutputStream(copy); // 설명 : 임의로 지정한 폴더에 복제파일을 FileOuputStream으로 추출하기위해 세팅한다(업로드)
					
					
					byte[] data = new byte[1024]; // 설명 byte[] 배열을 이용하여, fis를 read 하기 위한 매개변수를 설정한다.
					int input = 0; // 설명 : 파일 업로드 작업을 하기위한 세팅을 한다
								   // 		 input은 fis 읽어온 크기로설정해 fos.write할때 읽어온 값까지 데이터를 복제한다
					
					int count = 0; // 설명 : 업로드 진행도 '%' 를 콘솔에서 보기위해 생성
					
					while( (input = fis.read(data)) != -1 ) { // 설명 : fis.read로 파일을 바이트단위로 읽어온뒤 input에 대입해주고 0이될때까지 반복한다. (크기가 0이될때까지 while문 돌림)
						fos.write(data , 0 , input); // 설명 : 파일쓰기 data(바이트단위로),0부터,input(읽어온 사이즈가될때까지) 
													//         배열을 할 때는 0부터 끝까지 넣어야함
						count += input; // 설명 : 업로드%표시를 위해 반복문 돌아갈때마다 한번씩 추가해준다.
						float per = ( (float)count/fSize )*100; // 설명 : (읽은 바이트 수 / 전체 파일 크기) * 100
						
					} // END : while문
			
				} catch (IOException e) {

					e.printStackTrace();
				
				}
				
	/* ---------------------------------------------DB에 파일 컬럼 등록------------------------------------------------------------*/System.out.println();							
	
			ADDFILE addFile = ADDFILELocalServiceUtil.createADDFILE(0);

			addFile.setBno(bno);	// 설명 : 글번호는 위에서 만든 테이블의 글번호를 가져온다	
			addFile.setFRealName(uuid+"_"+fileNames[cnt]);
			addFile.setFName(fileNames[cnt]);
			addFile.setFPath(fPath);
			addFile.setFDate(fDate);
			

			addFile = ADDFILELocalServiceUtil.addADDFILEWithIncrement(addFile);
				
			cnt++;	
				} // END 파일사이즈제한 if 문
		else {
			System.out.println("File over it's max size, upload limited");
			break;
		}// END 파일사이즈제한 else 문
		

			} // END : for문 각각의 파일추출
		} // END : if문 파일배열에 파일이 존재할때
		
			
			
			
	/* ---------------------------------------------Ajax에 JSON 전송------------------------------------------------------------*/System.out.println();			
	
	
		json.put("result", "OK");
		json.put("bno", bno);
		json.put("writer", writer);
		json.put("userName", writer);

		
	
		try {
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		 

		return false;
	

	}

}