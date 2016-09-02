package com.unclechen.sp.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.monitoring.v3.Monitoring;
import com.google.api.services.monitoring.v3.model.CreateTimeSeriesRequest;
import com.unclechen.sp.domain.AdminUser;
import com.unclechen.sp.mongodb.index.LocusIndex;
import com.unclechen.sp.redis.session.HttpServletRequestWrapper;
import com.unclechen.sp.util.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Controller
public class HttpClientController {
	private static Logger log = Logger.getLogger(HttpClientController.class);

	@RequestMapping("httpview.action")
	public String http_view(HttpServletRequest request, HttpServletResponse response) {
		String httpurl=request.getParameter("httpurl");
		log.info("httpurl:"+httpurl);
		return "http_view";
	}


	@RequestMapping("httpsubmit.action")
	public String http_submit(HttpServletRequest request, HttpServletResponse response) {
		String httpurl=request.getParameter("httpurl");
		String result = HttpClientUtil.getInstance().sendHttpGet(httpurl);
		log.info("result:" + result);
		request.setAttribute("result", result);
		return "http_view";
	}

	@RequestMapping("httpcall.action")
	public void http_call(HttpServletRequest request, HttpServletResponse response) throws IOException, GeneralSecurityException {
//		String cloud-141309
		String project_id = request.getParameter("proid");
//				"cloud-141309";
		// Authentication is provided by the 'gcloud' tool when running locally
		// and by built-in service accounts when running on GAE, GCE, or GKE.
		GoogleCredential credential = GoogleCredential.getApplicationDefault();

		// The createScopedRequired method returns true when running on GAE or a local developer
		// machine. In that case, the desired scopes must be passed in manually. When the code is
		// running in GCE, GKE or a Managed VM, the scopes are pulled from the GCE metadata server.
		// See https://developers.google.com/identity/protocols/application-default-credentials for more information.
		if (credential.createScopedRequired()) {
			credential = credential.createScoped(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
		}

		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		Monitoring monitoringService = new Monitoring.Builder(httpTransport, jsonFactory, credential)
				.setApplicationName("Google Cloud Platform Sample")
				.build();

		// TODO: Change placeholders below to appropriate parameter values for the 'create' method:
		// The project on which to execute the request. The format is `"projects/{project_id_or_number}"`.
		String name = "projects/"+project_id;

		CreateTimeSeriesRequest content = new CreateTimeSeriesRequest();
		// TODO: Add code here to assign values to desired fields of the 'content' object

		Monitoring.Projects.TimeSeries.Create requestCreate = monitoringService.projects().timeSeries().create(name, content);
		log.info(requestCreate.execute());
		String result = "成功";
		// 这里不加的话，AJAX会缓存每次取的数据，从而造成数据不能更新
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(result);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
