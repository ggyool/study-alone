package org.ggyool.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuestBookController {

	@Autowired
	GuestBookService guestBookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap map){
		
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
		
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute GuestBook guestBook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		guestBookService.addGuestBook(guestBook, clientIp);
		System.out.println("clientIp : " + clientIp);
		return "redirect:list";
	}
	
}
