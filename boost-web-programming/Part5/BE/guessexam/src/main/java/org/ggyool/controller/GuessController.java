package org.ggyool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/guess")
public class GuessController {
	
	@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
	public String guessGet(@RequestParam(name="userInput", required=false) Integer userInput,
			HttpSession session,
			ModelMap model) {
		
		String msg; 
		if(userInput==null) {
			msg = "맞춰봐.";
			session.setAttribute("answer", (int)(Math.random()*100) + 1);
			session.setAttribute("count", 0);
		}
		else{
			// post 한 경우 userInput 를 받는다.
			int answer = (int)session.getAttribute("answer");
			int count = (int)session.getAttribute("count") + 1;
			session.setAttribute("count", count);
			if(userInput==answer) {
				msg = "정답. " + count + "번 걸렸어. 정답은 " + answer + "야!";
				session.removeAttribute("count");
				session.removeAttribute("answer");
			}else if(userInput>answer) {
				msg = "커";
			}else {
				msg = "작아";
			}
		}
		model.addAttribute("msg", msg);
		return "guess";
	}
}
