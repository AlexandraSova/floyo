<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Date date = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);%>
<p align="center">F L O Y O, <%= calendar.get(Calendar.YEAR)%>.</p>