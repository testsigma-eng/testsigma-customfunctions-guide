package com.testsigma.customfunc.examples;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class RestAPIWaitForResponse {

	@CustomTestStep
	public TestStepResult curl(Long executionId, String username, String password) {

		TestStepResult result = new TestStepResult();
		try {
			String Rurl = "https://app.testsigma.com/rest/execution/" + executionId + "/run";
			HttpUriRequest request = new HttpPost(Rurl);
			String authHeader = getBasicAuthString(username + ":" + password);

			request.setHeader(org.apache.http.HttpHeaders.AUTHORIZATION, "Basic" + " " + authHeader);
			request.setHeader(org.apache.http.HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
			System.out.println(httpResponse.getStatusLine());
			HttpEntity entity = httpResponse.getEntity();
			String runId = EntityUtils.toString(entity);

			int executionStatus = getExecutionStatus(executionId, runId, username, password);
			while (ResultConstants.QUEUED.getId() == executionStatus) {
				Thread.sleep(3000);
				executionStatus = getExecutionStatus(executionId, runId, username, password);
				// driver.getTitle();
			}
			Map<Object, Object> data = new HashMap<Object, Object>();
			data.put("final status", executionStatus);
			result.setMetadata(data);
			result.setStatus(executionStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setStatus(ResultConstants.FAILURE);

		}
		return result;

	}

	public Integer getExecutionStatus(Long executionId, String runId, String username, String password)
			throws ParseException, IOException {
		String Rurl = "httpa://app.testsigma.com/rest/execution/" + executionId + "/run/" + runId + "/status";
		HttpUriRequest request = new HttpGet(Rurl);
		String authHeader = getBasicAuthString(username + ":" + password);

		request.setHeader(org.apache.http.HttpHeaders.AUTHORIZATION, "Basic" + " " + authHeader);
		request.setHeader(org.apache.http.HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println(httpResponse.getStatusLine());

		HttpEntity entity = httpResponse.getEntity();
		String body = EntityUtils.toString(entity);
		Type type = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> pathMap = new Gson().fromJson(body, type);
		return ((Double) pathMap.get("result")).intValue();

	}

	public static String getBasicAuthString(String s) {
		try {
			byte[] encodedAuth = Base64.encodeBase64(s.getBytes(Charset.forName("ISO-8859-1")));
			String authHeader = new String(encodedAuth);
			return authHeader;
		} catch (Exception ignore) {
			return "";
		}
	}
}
