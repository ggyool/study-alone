package org.ggyool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/guess")
public class GuessController {
	
	@GetMapping
	public String guessGet(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) {
		
		Object answer, count, userInput;
		HttpSession session = request.getSession();
		userInput = session.getAttribute("userInput");
		if(session.isNew() || userInput==null) {
			answer = (int)(Math.random()*100) + 1;
			count = 0;
			session.setAttribute("answer", answer);
			session.setAttribute("count", count);
			session.setAttribute("userInput", userInput);
		}else{
			answer = session.getAttribute("answer");
			count = session.getAttribute("count"); 
			session.removeAttribute("userInput");
		}
		model.addAttribute("answer", answer);
		model.addAttribute("count", count);
		model.addAttribute("userInput", userInput);
		return "guess";
	}
	
	@PostMapping
	public String guessPost(@RequestParam("userInput") Integer userInput,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		int count = (int)session.getAttribute("count");
		session.setAttribute("count", count+1);
		session.setAttribute("userInput", userInput);
		return "redirect:/guess";
	}
}
