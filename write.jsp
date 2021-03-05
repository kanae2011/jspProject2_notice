<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바부분
//넘어오는 데이터 받기
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");

//vo객체에 저장
NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);

//vo객체 확인
System.out.println("/notice/write.jsp [vo]" + vo);

//DB에 데이터 저장 jsp(controller) -NoticeWriteService - DAO - notice table insert

ExeService.execute(Beans.get(AuthorityFilter.url), vo);

response.sendRedirect("list.jsp");
%>