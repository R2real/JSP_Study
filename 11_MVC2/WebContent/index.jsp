<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	pageContext.forward("main.do");
	//pageContext.forward("controller.jsp?action=main");
	//url이 기본적으로 파라미터를 1개이상의 값을 가짐 = 요청의 크기가 무거
%>