package com.tupperware.auto.handler;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tupperware.auto.commons.utils.DataInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 系统异常处理，比如：404,500
	 * 
	 * @param request
	 * @param resp
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public DataInfo defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		logger.error("", e);
		DataInfo result = new DataInfo(); 
		if (e instanceof IllegalArgumentException) { // 参数检查异常
			result.setCode(HttpServletResponse.SC_CONFLICT);
			result.setMessage(e.getMessage());
		} else if (e instanceof NoHandlerFoundException) {
			result.setCode(HttpServletResponse.SC_NOT_FOUND);
			result.setMessage("接口 [" + request.getRequestURI() + "] 不存在");
		} else if (e instanceof ServletException) {
			result.setCode(HttpServletResponse.SC_FORBIDDEN);
			result.setMessage(e.getMessage());
		} else if (e instanceof AccessDeniedException) {
			result.setCode(HttpServletResponse.SC_NOT_ACCEPTABLE);
			result.setMessage(e.getMessage());
		} else {
			result.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			result.setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
		}
		result.setRows(new ArrayList<Object>());
		result.setStatus(false);
		result.setDimorgan("");
		result.setDimtime("");
		result.setOrganno("");
		return result;
	}
}