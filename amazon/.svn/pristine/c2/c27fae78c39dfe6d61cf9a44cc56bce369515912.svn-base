package com.oracleoaec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class test
 */
/*@WebServlet("/WebContent/test")*/
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("param", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		
		ValidateCode vCode = new ValidateCode(80, 25, 4, 10);
        //获取生产的验证码字符串
         String code =vCode.getCode();
         //传值方式1.拼接网址字符串  2.使用域对象

         //使用session 来储存验证码
         request.getSession().setAttribute("wcode", code);

         //写到网页上 (通过  响应中的字符流  写回网页)
         vCode.write(response.getOutputStream());
	}

}
