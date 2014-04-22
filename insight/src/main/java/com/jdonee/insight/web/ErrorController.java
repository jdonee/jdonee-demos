package com.jdonee.insight.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jdonee
 *
 */
@Controller
@RequestMapping(value = "/error")
@Scope("prototype")
public class ErrorController {

	/**
	 * 404错误
	 * 
	 */
	@RequestMapping(value = "404", method = RequestMethod.GET)
	public String pageNoFound(Model model) {
		model.addAttribute("errorCode", HttpServletResponse.SC_NOT_FOUND);
		return "error/error";
	}

	/**
	 * 400错误(请求无效)
	 * 
	 */
	@RequestMapping(value = "400", method = RequestMethod.GET)
	public String badRequest(Model model) {
		model.addAttribute("errorCode", HttpServletResponse.SC_BAD_REQUEST);
		return "error/error";
	}

	/**
	 * 403错误(禁止访问)
	 * 
	 * @return
	 */
	@RequestMapping(value = "403", method = RequestMethod.GET)
	public String scForbidden(Model model) {
		model.addAttribute("errorCode", HttpServletResponse.SC_FORBIDDEN);
		return "error/error";
	}

	/**
	 * 系统错误
	 * 
	 * @return
	 */
	@RequestMapping(value = "500", method = RequestMethod.GET)
	public String serverError(Model model) {
		model.addAttribute("errorCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "error/error";
	}

}
