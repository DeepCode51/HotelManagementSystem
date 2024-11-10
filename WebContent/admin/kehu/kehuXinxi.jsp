<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/bg.jpg'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;客户信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">客户名称</td>
					<td width="15%">地址</td>
					<td width="15%">联系人</td>
					<td width="15%">电话</td>
					<td width="10%">邮编</td>
					<td width="10%">传真</td>
					<td width="10%">email</td>
		        </tr>	
				<c:forEach items="${requestScope.kehuList}" var="kehu">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${kehu.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.dizhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${kehu.lianxiren}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.dianhua}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.youbian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${kehu.chuanzhen}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${kehu.youxiang}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
