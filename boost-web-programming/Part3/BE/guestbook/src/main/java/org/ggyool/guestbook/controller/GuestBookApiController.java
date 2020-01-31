package org.ggyool.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestBookApiController {
	@Autowired
	GuestBookService guestBookService;
	
	@GetMapping
	// content-type 이 application/json 요청이 들어오면 이 메소드가 실행된다.
	// dispatcher servlet은 json message converter를 내부적으로 사용하여 해당 map 객체를 json 으로 변환해준다.
	public Map<String, Object> list(
			@RequestParam(name="start", required=false, defaultValue="0") int start){
		
		List<GuestBook> list = guestBookService.getGuestBooks(start);
		
		int count = guestBookService.getCount();
		int pageCount = count / GuestBookService.LIMIT;
		if(count % GuestBookService.LIMIT > 0) ++pageCount;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; ++i) {
			pageStartList.add(i * GuestBookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		return map;
	}
	
	@PostMapping
	// 마찬가지로 json 으로 바뀌어서 클라이언트에게 reponse함
	public GuestBook write(@RequestBody GuestBook guestBook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		GuestBook resultGuestBook = guestBookService.addGuestBook(guestBook, clientIp);
		return resultGuestBook;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id, HttpServletRequest request){
		String clientIp = request.getRemoteAddr();
		int deleteCount = guestBookService.deleteGuestBook(id, clientIp);
		return Collections.singletonMap("sucess", deleteCount>0 ? "true" : "false");
	}
}





