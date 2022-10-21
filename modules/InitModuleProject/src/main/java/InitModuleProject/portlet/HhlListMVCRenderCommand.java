package InitModuleProject.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import BoardService.model.TBL;
import InitModuleProject.constants.ConstantsCommands;
import InitModuleProject.constants.MainHhlBoardPortletKeys;
import InitModuleProject.model.BoardPagingVO;
import InitModuleProject.service.ServiceMethod;
@Component(
		immediate = true,
		property = {

			"javax.portlet.name=" + MainHhlBoardPortletKeys.MAINHHLBOARD,
			"mvc.command.name=" +ConstantsCommands.HHLBOARD_LIST_PROJECT
		},
		service = MVCRenderCommand.class
	)
public class HhlListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

/*---------------------------------------------커스텀서비스인스턴스화----------------------------------------------------------*/
		ServiceMethod serviceMethod = new ServiceMethod();
/*---------------------------------------------기본 파라미터 설정----------------------------------------------------------*/
		// 검색 옵션값 가져오기
		String option = ParamUtil.getString(renderRequest, "option");
		String keyword = ParamUtil.getString(renderRequest, "keyword");
		// 정렬선택값 가져오기
		String ORDER = ParamUtil.getString(renderRequest, "ORDER");	

		// 검색 키워드 옵션별 분류
		String searchKeyword = serviceMethod.getOptionToSearchKeyword(option, keyword);
		// 검색어별 컬럼네임 리턴 
		String columnName = serviceMethod.getOptionToColumnName(option, searchKeyword);
		// 페이지번호 i 파라미터 가져오기
		int i = ParamUtil.getInteger(renderRequest, "i" ,1);
		
		// 페이지 계산에 필요한 파라미터 가져오기
		int initRowNumber = 0; // 각 페이지별 시작번호 (디폴트)
		int currentPage = i; // 현재 머물고 있는 페이지	i(파라미터로 가져온)	
		int cntPerPage = ParamUtil.getInteger(renderRequest, "cntPerPage",10); // 페이지에 표시할 게시글수
		int cntPerTotal = 0;  // (디폴트)
		
		int number = ParamUtil.getInteger(renderRequest, "number");
	
/*-------------------------------------------페이지 계산 && 파라미터 세팅----------------------------------------------------------*/
		cntPerTotal = serviceMethod.getcntPerTotalBySearchkeyword(searchKeyword, option, cntPerPage, initRowNumber);
		BoardPagingVO bp = serviceMethod.getBoardPagingResult(cntPerTotal, currentPage, cntPerPage);
		initRowNumber = bp.getInitRowNumber();	
		
		number = bp.getNumber();
		
/*---------------------------------------------페이징----------------------------------------------------------*/

		List<TBL> board_list = null;
		// 검색어 없는경우
		
			
			// 리스트 결과 리턴
			board_list = serviceMethod.getOrderListResult(ORDER, cntPerPage, initRowNumber, searchKeyword, columnName);
			
		// 검색어 있는경우			 
					
			
			/*
			 * // 리스트 결과 리턴(순서정렬은 OrderByComparator 참고) board_list =
			 * TBLLocalServiceUtil.getTBLListBySearch(searchKeyword, option, cntPerPage,
			 * initRowNumber);
			 */
		



/*-------------------------------------------객체 바인딩----------------------------------------------------------*/	
		
		
		renderRequest.setAttribute("board_list", board_list);
		renderRequest.setAttribute("bp", bp);
		renderRequest.setAttribute("option", option);
		renderRequest.setAttribute("keyword", keyword);
		renderRequest.setAttribute("ORDER", ORDER);	
		renderRequest.setAttribute("searchOn", "on");
		
/*-------------------------------------------페이지 리턴----------------------------------------------------------*/		
		return "/board/board_list.jsp";
	}
	
	

	
}
	