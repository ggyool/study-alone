package org.ggyool.guestbook.argumentresolver;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {

	// Controller Method 의 인자 수 대로 supportsParameter 가 실행된다. (4개면 4번)
	// 인자의 정보를 가져와서 원하는 정보가 있으면 true 없으면 false
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType() == HeaderInfo.class;
	}
	
	// supportsParameter 가 true 일 경우에만 resolveArgument가 호출 된다.
	// return 값이 controller method 의 인자로 전달된다.
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 요청으로 부터 넘어온 모든 header 정보 HeaderInfo 객체에 넣는다. 
		HeaderInfo headerInfo = new HeaderInfo();
		Iterator<String> headerNames = webRequest.getHeaderNames();
		while(headerNames.hasNext()) {
			String headerName = headerNames.next();
			String headerValue = webRequest.getHeader(headerName);
			System.out.println(headerName + "////" +  headerValue);
			headerInfo.put(headerName, headerValue);
		}
		return headerInfo;
	}	
}



