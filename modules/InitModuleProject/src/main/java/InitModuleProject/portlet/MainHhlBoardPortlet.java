package InitModuleProject.portlet;

import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.BoardPagingVO;
import InitModuleProject.service.ServiceMethod;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.TBL;
import BoardService.service.TBLLocalServiceUtil;

/**
 * @author TETRA
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Board",
		"com.liferay.portlet.header-portlet-css=/css/board_list.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=BoardList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/board/board_list.jsp",
		"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MainHhlBoardPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {


/*---------------------------------------커스텀 서비스 인스턴스화---------------------------------------------*/
		ServiceMethod serviceMethod = new ServiceMethod();		
/*---------------------------------------------더미데이터 생성------------------------------------------------*/
		// serviceMethod.getDummy();		
/*------------------------------------------기본세팅----------------------------------------------------------*/
		// 회원 고유 번호 가져오기
		 int userNumber = serviceMethod.getUserIdNumber(renderRequest, renderResponse);		 		
		
		// 회원 아이디 바인딩
		boolean success = serviceMethod.setUserIdtoName(renderRequest, renderResponse, userNumber);
		if (success) {
			System.out.println("UserName setting Success");
		}else {
			System.out.println("UserName setting failed");
			
		}
		
		
/*---------------------------------------------기본 파라미터 설정----------------------------------------------------------*/		
		
		// 페이지번호 i 파라미터 가져오기
		int i = ParamUtil.getInteger(renderRequest, "i" ,1);
		int initRowNumber = 0; // 각 페이지별 시작번호
		int cntPerTotal = TBLLocalServiceUtil.getTBLsCount(); // 총 등록된 게시글수
		int currentPage = i; // 현재 머물고 있는 페이지	i(파라미터로 가져온)	
		int cntPerPage = ParamUtil.getInteger(renderRequest, "cntPerPage",10); // 페이지에 표시할 게시글수
		String ORDER = "";
		String searchKeyword = null;
		String columnName = null;
		// 표시할 페이지 갯수 옵션 (기본값 :10)
		renderRequest.setAttribute("cntPerPage", cntPerPage);	
		
/*-------------------------------------------페이지 계산 && 파라미터 세팅----------------------------------------------------------*/
		// 게시판 페이지 이동 세팅
		BoardPagingVO bp = new BoardPagingVO(cntPerTotal, currentPage, cntPerPage);
		renderRequest.setAttribute("bp", bp);	
		initRowNumber = bp.getInitRowNumber();
/*---------------------------------------------페이징----------------------------------------------------------*/

		List<TBL> board_list = serviceMethod.getOrderListResult(ORDER, cntPerPage, initRowNumber, searchKeyword, columnName);
		
/*-------------------------------------------객체 바인딩----------------------------------------------------------*/	
	
		renderRequest.setAttribute("board_list", board_list);
		renderRequest.setAttribute("bp", bp);

/*-------------------------------------------페이지 리턴----------------------------------------------------------*/		
		super.render(renderRequest, renderResponse);
	}
}