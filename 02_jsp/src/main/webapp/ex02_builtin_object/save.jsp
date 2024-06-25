<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
  String mobile = request.getParameter("mobile");
  String email = request.getParameter("email");
  String ip = request.getRemoteAddr();
  // 여기쯤에서 DB에 저장한다.
  request.getRequestDispatcher("/ex02_builtin_object/confirm.jsp").forward(request, response);
%>