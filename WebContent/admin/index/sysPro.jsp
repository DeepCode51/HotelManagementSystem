<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
	<style>
   .con {
    width: 100%;
    height: 400px;
    display: table;
   }

   .txt {
    vertical-align: middle;
    display: table-cell;
   }
  </style>
 </head>
 <body background='<%=path %>/images/bg.jpg'>
  <div class="con">
   <div class="txt"><center><span>欢迎使用酒店管理系统</span></center></div>
  </div>
 </body>
</html>