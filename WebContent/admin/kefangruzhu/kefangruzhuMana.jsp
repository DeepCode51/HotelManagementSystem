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
           function kefangruzhuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/kefangruzhu?type=kefangruzhuDel&id="+id;
               }
           }
           
           function kefangruzhuAdd()
           {
                 var url="<%=path %>/admin/kefangruzhu/kefangruzhuAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }	
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/bg.jpg'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/images/tbg.gif">&nbsp;客房&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="14%">入住客房</td>
					<td width="14%">入住时间</td>
					<td width="14%">客户姓名</td>
					<td width="14%">客户联系方式</td>
					<td width="14%">预订天数</td>
					<td width="14%">消费金额</td>
					<td width="14%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.kefangruzhuList}" var="kefangruzhu">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.kefang_fanjianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.kehuname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.kehutel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.tianshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kefangruzhu.xiaofeijine}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						     <input type="button" value="删除" onclick="kefangruzhuDel(${kefangruzhu.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kefangruzhuAdd()" />
			    </td>
			  </tr>
		    </table>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="120" width="120"></TD>
				</TR>
			</TABLE>
	</body>
</html>
