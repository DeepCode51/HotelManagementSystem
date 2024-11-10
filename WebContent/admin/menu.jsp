<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'menu.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/menu.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#bae87c;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#c1ea8b;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#acd6ff;
		/*  background-color:#9ad075; */
		}
		
		dl.bitem {
			width:148px;
			margin:0px 0px 5px 4px;
		}
		
		dl.bitem dt {
		  background:url(<%=path %>/images/menubg.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		}
		
		dl.bitem dd {
		  padding:3px 3px 3px 3px;
		  background-color:#fff;
		}
		
		.fllct
		{
			float:left;
			
			width:90px;
		}
		
		.flrct
		{
			padding-top:3px;
			float:left;
		}
		
		div.items
		{
			line-height:22px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 9px;
		}
		
		span.items
		{
			padding:10px 0px 10px 22px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 12px;
		}
		
		ul {
		  padding-top:3px;
		}
		
		li {
		  height:22px;
		}
		
		.sitemu li {
			padding:0px 0px 0px 22px;
			line-height:24px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 9px;
		}
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="<%=path %>/js/menu.js"></script>
	<base target="main" />
  </head>
  
  <body target="main">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">
		<!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_1")'><b>基本操作</b></dt>
	        <dd style='display:block' class='sitem' id='items1_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/admin?type=adminMana' target='main'>系统管理员</a> </li>
	              <li><a href='<%=path %>/admin/userinfo/userPw.jsp' target='main'>密码修改</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
	      <!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_1")'><b>客房管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/kefangleixing?type=kefangleixingMana' target='main'>客房类型</a> </li>
	              <li><a href='<%=path %>/kefang?type=kefangMana' target='main'>客房信息</a> </li>
	              <li><a href='<%=path %>/kefangyuding?type=kefangyudingMana' target='main'>客房预订</a> </li>
	              <li><a href='<%=path %>/kefangruzhu?type=kefangruzhuMana' target='main'>入住消费</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
	      <!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>客户管理</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/kehu?type=kehuMana' target='main'>客户信息</a> </li>
                 <li><a href='<%=path %>/admin/kehu/kehuAdd.jsp' target='main'>添加客户</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
	      <!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>特色菜品介绍</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/goods?type=goodsMana' target='main'>特色菜品介绍</a> </li>
                 <li><a href='<%=path %>/admin/goods/goodsAdd.jsp' target='main'>特色菜品添加</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
	      <!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>餐桌预订管理</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/canzhuoyuding?type=canzhuoyudingMana' target='main'>餐桌预订管理</a> </li>
                 <li><a href='<%=path %>/admin/canzhuoyuding/canzhuoyudingAdd.jsp' target='main'>餐桌预订添加</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>餐饮消费管理</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/canyinxiaofei?type=canyinxiaofeiMana' target='main'>餐饮消费管理</a> </li>
                 <li><a href='<%=path %>/admin/canyinxiaofei/canyinxiaofeiAdd.jsp' target='main'>餐饮消费添加</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <!-- 1 -->
		  </td>
	  </tr>
	</table>
  </body>
</html>
