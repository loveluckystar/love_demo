package com.unclechen.sp.controller;

import com.unclechen.sp.domain.AdminUser;
import com.unclechen.sp.mongodb.index.LocusIndex;
import com.unclechen.sp.redis.session.HttpServletRequestWrapper;
import com.unclechen.sp.util.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HttpClientController {
	private static Logger log = Logger.getLogger(HttpClientController.class);

	@RequestMapping("http_view.action")
	public String http_view(HttpServletRequest request, HttpServletResponse response) {
		String httpurl=request.getParameter("httpurl");
		log.info("httpurl:"+httpurl);
		return "http_view";
	}


	@RequestMapping("http_submit.action")
	public String http_submit(HttpServletRequest request, HttpServletResponse response) {
		String httpurl=request.getParameter("httpurl");
		String result = HttpClientUtil.getInstance().sendHttpGet(httpurl);
		log.info("result:" + result);
		request.setAttribute("result",result);
		return "http_view";
	}
//	http_submit
}
