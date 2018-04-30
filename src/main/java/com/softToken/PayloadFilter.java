/**
 * Copyright TCS. All Rights Reserved.
 * This software is the proprietary to TCS.
 * Use is subject to license terms.
 */
package com.softToken;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

/**
 * @author TCS
 * This filter is a utility to log the HTTPRequest and HTTP Response Payload
 */
@Component
public class PayloadFilter extends OncePerRequestFilter implements Ordered{
	
	private int order = Ordered.LOWEST_PRECEDENCE - 15;

	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		Map<String, Object> trace = new LinkedHashMap<String, Object>();

		setRequestTrace(trace, requestWrapper);

		try {
			filterChain.doFilter(requestWrapper, responseWrapper);
		} finally {
			setRequestBodyTrace(requestWrapper, trace);

			setResponseTrace(trace, responseWrapper);
			
			setResponseBodyTrace(responseWrapper, trace);

			// String traceintend = (new JSONObject(trace)).toString(4);

			// LOG.info("traceintend \n" + traceintend.toString());

			logTrace(trace);
		}
	}

	/**
	 * This method sets the request related params to the map instance trace
	 * @param trace
	 * @param requestWrapper
	 */
	protected void setRequestTrace(Map<String, Object> trace, ContentCachingRequestWrapper requestWrapper) {

		HttpSession session = requestWrapper.getSession(false);

		trace.put("method", requestWrapper.getMethod());
		trace.put("path", requestWrapper.getRequestURI());
		trace.put("headers", getRequestHeaders(requestWrapper));

		trace.put("pathInfo", requestWrapper.getPathInfo());
		trace.put("pathTranslated", requestWrapper.getPathTranslated());
		trace.put("contextPath", requestWrapper.getContextPath());

		trace.put("parameters", getParameterMapString(requestWrapper.getParameterMap()));
		

		trace.put("query", requestWrapper.getQueryString());
		trace.put("authType", requestWrapper.getAuthType());
		trace.put("remoteAddress", requestWrapper.getRemoteAddr());
		trace.put("sessionId", (session == null ? null : session.getId()));
		trace.put("remoteUser", requestWrapper.getRemoteUser());
	}

	/**
	 * @param requestWrapper
	 * @return
	 */
	private Map<String, String> getParameterMapString(Map<String, String[]> parameterMap) {
		
		 Map<String, String> parameterMapStr =  new LinkedHashMap<String, String>();
		 for (String key : parameterMap.keySet()) {
			 parameterMapStr.put(key, parameterMap.get(key).toString());
			}
		return parameterMapStr;
	}

	/**
	 * This method sets the requestBody to the map instance trace
	 * @param requestWrapper
	 * @param trace
	 */
	protected void setRequestBodyTrace(ContentCachingRequestWrapper requestWrapper, Map<String, Object> trace) {
		trace.put("requestBody", getRequestBody(requestWrapper));
	}

	/**
	 * This method returns the request headers params as a map
	 * @param request
	 * @return
	 */
	protected Map<String, Object> getRequestHeaders(HttpServletRequest request) {
		Map<String, Object> headers = new LinkedHashMap<String, Object>();
		// Set<String> excludedHeaders = getExcludeHeaders();
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			// if (!excludedHeaders.contains(name.toLowerCase())) {
			headers.put(name, getHeaderValue(request, name));
			// }
		}
		return headers;
	}

	/**
	 * This method returns the value of the input request header param
	 * @param request
	 * @param name
	 * @return
	 */
	protected Object getHeaderValue(HttpServletRequest request, String name) {
		List<String> value = Collections.list(request.getHeaders(name));
		if (value.isEmpty()) {
			return "";
		} else if (value.size() == 1) {
			return value.get(0);
		}

		return value;
	}

	/**
	 * This method is used to get the requestbody from the ContentCachingRequestWrapper instance
	 * @param requestWrapper
	 * @return
	 */
	protected Object getRequestBody(ContentCachingRequestWrapper requestWrapper) {
		requestWrapper.getParameterMap();
		return new String(requestWrapper.getContentAsByteArray());
	}

	/**
	 * This method sets the response related params to the map instance trace
	 * @param trace
	 * @param responseWrapper
	 * @throws IOException
	 */
	protected void setResponseTrace(Map<String, Object> trace, ContentCachingResponseWrapper responseWrapper)
			throws IOException {

		Map<String, Object> headers = (Map<String, Object>) trace.get("headers");
		headers.put("response", getResponseHeaders(responseWrapper));
	}
	
	
	/**
	 * This method sets the responseBody to the map instance trace
	 * @param responseWrapper
	 * @param trace
	 * @throws IOException
	 */
	protected void setResponseBodyTrace(ContentCachingResponseWrapper responseWrapper, Map<String, Object> trace)
			throws IOException {
		trace.put("responseBody", getResponseBody(responseWrapper));
	}

	/**
	 *  This method returns the response headers params as a map
	 * @param response
	 * @return
	 */
	protected Map<String, String> getResponseHeaders(HttpServletResponse response) {
		Map<String, String> headers = new LinkedHashMap<String, String>();
		for (String name : response.getHeaderNames()) {
			String value = getHeaderValue(response, name);
			headers.put(name, value);
		}
		// if (!isIncluded(Include.COOKIES)) {
		// headers.remove("Set-Cookie");
		// }
		headers.put("status", "" + response.getStatus());
		return headers;
	}

	/**
	 *  This method returns the value of the input response header param
	 * @param response
	 * @param name
	 * @return
	 */
	protected String getHeaderValue(HttpServletResponse response, String name) {
		return response.getHeader(name);
	}

	/**
	 * This method is used to get the responsebody from the ContentCachingResponseWrapper instance	 * 
	 * @param responseWrapper
	 * @return
	 * @throws IOException
	 */
	protected Object getResponseBody(ContentCachingResponseWrapper responseWrapper) throws IOException {
		String strResponseBody = new String(responseWrapper.getContentAsByteArray());
		responseWrapper.copyBodyToResponse();
		return strResponseBody;
	}
	
	protected void logTrace(Map<String, Object> trace){
		
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
	
}
