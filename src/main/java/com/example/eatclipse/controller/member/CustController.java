package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.member.CustDAO;
import com.example.eatclipse.model.member.CustDTO;
import com.example.eatclipse.model.member.memberDTO;

@Controller
@RequestMapping("/customer/*")   // 고객 로그인 후, 여기로 들어오는 지 확인 필요

public class CustController {
	
	@Inject
	CustDAO custDAO;
	
	/*-----------------------------------------------------------------
	어디서나 Home 버튼 누르면 메인페이지로 이동.  성공
	------------------------------------------------------------------*/ 
	
	@RequestMapping("main.do")
		public String main() {
			return "customer/main";
	}
	
	
	/*-----------------------------------------------------------------
	회원이 main에서 [마이페이지] 버튼 누르면, 
	myPage.jsp로 이동하여 상세회원정보 보여주는 로직
	
	   * 이슈 : 충전 후, 다시 마이페이지 들어올 때 회원정보가 나타나지 않음!!!
	------------------------------------------------------------------*/ 
	
	@RequestMapping("myPage.do")
	public String myPage(@RequestParam String userid, Model model) {
		model.addAttribute("dto", custDAO.view(userid));
		return "customer/myPage";
	}  
	
	
	/*-----------------------------------------------------------------
	회원이 마이페이지에서 [캐시 충전] 버튼을 누르면 돈 충전.  기본은 성공
	
	   * 이슈 : 충전 후, 다시 마이페이지 들어올 때 회원정보가 나타나지 않음!!!
	------------------------------------------------------------------*/ 

	@RequestMapping("cashCharge.do")    
	public String cashCharge() {
		return "customer/cashCharge_write";   
	}
	
	@RequestMapping("cashCharge_logic.do")    // 로직 전체 손봐야 해.
	public String cashCharge_logic(@RequestParam int cash,   // cash는 write.jsp의 name.
			HttpSession session) {  
	// HttpSession session : 홍길동의 계정정보 확보. 셋어트리뷰트, 겟어트리뷰트 필요할 때
		
		int money = (int) session.getAttribute("money");
		
		money += cash;
		
		CommonsDTO dto2 = new CommonsDTO();   // 텅 비어있는 상태
		dto2.setMoney(money);
		dto2.setUserid((String) session.getAttribute("userid"));
		
		
		custDAO.cashCharge(dto2);
		
		session.setAttribute("money", money);  // 원래 홍길동 돈을 업데이트.
		
		System.out.print("성공");
		
		return "customer/myPage";   
	}
	
	/* -----------------------------------------------------------------------
	고객 main에서 [한식], [양식], [분식] ... 버튼 눌러서 카테고리별 식당 리스트 접근
	  * 1/10(월) 오전 완성
	--------------------------------------------------------------------------*/
	
	@RequestMapping("shopList/{type}")
	public ModelAndView list(@PathVariable("type") int type, ModelAndView mav) {
		 
		mav.setViewName("/customer/shop_list");
		/*
		 * if(type == 2)mav.addObject("list", custDAO.koreanList(type)); else if(type ==
		 * 3)mav.addObject("list", custDAO.westernList(type)); else if(type ==
		 * 4)mav.addObject("list", custDAO.bunsickList(type)); else if(type ==
		 * 5)mav.addObject("list", custDAO.chineseList(type)); else if(type ==
		 * 6)mav.addObject("list", custDAO.japaneseList(type)); else if(type ==
		 * 7)mav.addObject("list", custDAO.disertList(type)); else if(type ==
		 * 8)mav.addObject("list", custDAO.fastfoodList(type));
		 */
		mav.addObject("list", custDAO.koreanList(type));
		mav.addObject("t", type);
		
		return mav;
	}
	
	/* -----------------------------------------------------------------------
		<장바구니!!!!!!!!!>
	--------------------------------------------------------------------------*/
	
	// 메인에서 [장바구니] 누르면 cart.jsp로 이동
	@RequestMapping("cart.do")
	public String cart() {
		return "customer/cart";
	}
	

	/* -----------------------------------------------------------------------
	    <최근 본 가게>
	
	--------------------------------------------------------------------------*/
	
	
	
	
	/* -----------------------------------------------------------------------
    	<주문>

	--------------------------------------------------------------------------*/
	
	
	
	/* -----------------------------------------------------------------------
		<리뷰>

	--------------------------------------------------------------------------*/
	
	
	
}
