package org.ggyool.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ggyool.guestbook.argumentresolver.HeaderInfo;
import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuestBookController {

	@Autowired
	GuestBookService guestBookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap map, 
			HttpServletRequest request,
			HttpServletResponse response,
			HeaderInfo headerInfo){
		
		System.out.println("-----------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------------------------");
		
		String value = null;
		boolean isFind = false;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if("count".equals(cookie.getName())){
					isFind = true;
					value = cookie.getValue();
				}
			}
		}
		if(!isFind) {
			// cookie 는 String 이어야 한다.
			value = "1";
		}else {
			int num = Integer.parseInt(value)+1;
			value = Integer.toString(num);
		}
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60*60*24*365);
		cookie.setPath("/"); // 경로 이하의 주소에 쿠키 적용 ( 모든 경로에 적용 )
							 // 테스트 해보니 절대 경로인듯  
		response.addCookie(cookie);
		
		//start 부터 LIMIT개 방명록
		List<GuestBook> list = guestBookService.getGuestBooks(start);
		// 전체페이지 수 구하기
		int count = guestBookService.getCount();
		int pageCount = count / GuestBookService.LIMIT;
		if(count % GuestBookService.LIMIT > 0) ++pageCount;	
		
		// 페이지 수가 3이면 0,5,10 이렇게 저장된다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; ++i) {
			pageStartList.add(i * GuestBookService.LIMIT);
		}
		
		
		map.addAttribute("list", list);
		map.addAttribute("count", count);
		map.addAttribute("pageStartList", pageStartList);
		map.addAttribute("cookieCount", value);
		return "list";
	}
	
	//@CookieValue 테스트
	@GetMapping(path="/list2")
	public String list2(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap map, 
			@CookieValue(value="count", defaultValue="0", required=true) String value,
			HttpServletResponse response){
		
		
		int num = Integer.parseInt(value)+1;
		value = Integer.toString(num);
		
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60*60*24*365);
		cookie.setPath("/"); // 경로 이하의 주소에 쿠키 적용 ( 모든 경로에 적용 )
							 // 테스트 해보니 절대 경로인듯  
		response.addCookie(cookie);
		
		//start 부터 LIMIT개 방명록
		List<GuestBook> list = guestBookService.getGuestBooks(start);
		// 전체페이지 수 구하기
		int count = guestBookService.getCount();
		int pageCount = count / GuestBookService.LIMIT;
		if(count % GuestBookService.LIMIT > 0) ++pageCount;	
		
		// 페이지 수가 3이면 0,5,10 이렇게 저장된다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; ++i) {
			pageStartList.add(i * GuestBookService.LIMIT);
		}
		
		
		map.addAttribute("list", list);
		map.addAttribute("count", count);
		map.addAttribute("pageStartList", pageStartList);
		map.addAttribute("cookieCount", value);
		return "list";
	}
	@PostMapping(path="/write")
	public String write(@ModelAttribute GuestBook guestBook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		guestBookService.addGuestBook(guestBook, clientIp);
		System.out.println("clientIp : " + clientIp);
		return "redirect:/list";
	}
	
	@GetMapping(path="delete")
	public String delete(@RequestParam(name="id", required=true) Long id,
			@SessionAttribute("isAdmin") String isAdmin,
			HttpServletRequest request,
			RedirectAttributes rttr) {
		if(isAdmin==null || !"true".equals(isAdmin)) {
			rttr.addFlashAttribute("errorMessage", "로그인하지 않았습니다.");
			return "redirect:/loginform";
		}
		String ip = request.getRemoteAddr();
		guestBookService.deleteGuestBook(id, ip);
		return "redirect:/list";
	}
	
}
