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
           function kefangleixingDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/kefangleixing?type=kefangleixingDel&id="+id;
               }
           }
           
           function kefangleixingAdd()
           {
                 var url="<%=path %>/admin/kefangleixing/kefangleixingAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/bg.jpg'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/images/tbg.gif">&nbsp;客房类型&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="33%">ID</td>
					<td width="33%">类型名称</td>
					<td width="33%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.kefangleixingList}" var="kefangleixing">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${kefangleixing[0]}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangleixing[1]}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <form action="<%=path %>/admin/kefangleixing/kefangleixingEditPre.jsp" name="form1" method="post">
						    <input type="button" value="删除" onclick="kefangleixingDel(${kefangleixing[0]})"/>
						    <input name="id" type="hidden" value="${kefangleixing[0]}"/>
						    <input name="name" type="hidden" value="${kefangleixing[1]}"/>
						    <input type="submit" value="编辑"/>
						 </form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kefangleixingAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
