<%@ page language="java" import="java.util.*" import="data.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% User user=(User)request.getSession().getAttribute("userInfo"); %>
<% String cp = request.getContextPath();%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	东南一卡通
</title><link href="<%=cp %>/css/img.css" rel="stylesheet" type="text/css" /><link href="<%=cp %>/Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="<%=cp %>/Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="<%=cp %>/Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="<%=cp %>/Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/Common.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/Data.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/Common.js" type="text/javascript"></script>
   <script type="text/javascript">
function check()
{
 if(document.form1.id.value=="")
 {
 alert("请输入订单号！");
 document.form1.id.focus();
 return false;
 }
return true;
}
</script>
</head>
<body>


    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                
                        <img src="<%=cp %>/img/logo.png" alt="" class="titleimg" />
                  
                </div>
                <div class="topxx">
                    
                   <%=user.getId()%><%=user.getLevel() %>:<%=user.getName() %>&nbsp;欢迎您！<a href="/OneCard/UserInfo/index.jsp">我的信息</a> <a  href="/OneCard/LogOutServlet">安全退出</a>
                </div>
            
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="<%=cp %>/UserInfo/index.jsp">我的信息</a></div>
                        <div><a href="<%=cp %>/UserInfo/ManageUser.jsp">管理用户 </a></div>    
                    </div>
                    <div class="ta1">
                        <strong>在线图书馆</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="<%=cp %>/Library/MyBorrow.jsp">我的预约</a></div>
                        <div>
                            <a href="<%=cp %>/Library/Borrow.jsp">预约书籍</a></div>
                        <div>
                            <a href="<%=cp %>/Library/ManageBook.jsp">管理书籍</a></div>
                    </div>
                    <div class="ta1">
                        <strong>财务中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="<%=cp %>/Finance/MyOrder.jsp">我的订单</a></div>
                        <div>
                            <a href="<%=cp %>/Finance/Market.jsp">在线超市</a></div>
                            <div>
                            <a href="<%=cp %>/Finance/ManageMarket.jsp">管理商品</a></div>
                    </div>
                   
                  
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        财务中心 &gt; <a href="#">我的订单</a></h2>
        <div class="morebt">
        <ul>
            <li><a class="tab1" href="<%=cp %>/Finance/MyOrder.jsp">我的订单</a></li>
            <li><a class="tab2" href="<%=cp %>/Finance/Market.jsp">在线超市</a></li>
            <li><a class="tab2" href="<%=cp %>/Finance/ManageMarket.jsp">管理商品</a></li>
            
        </ul>
    </div>
   
   <div class="cztable">
       
<table>
<tr>
    <td>    <input type="button" id="button2" value="显示我的订单" onclick="window.location=('<%=cp %>/CommodityOrderServlet?method=commodity&user=<%=user.getId() %>')" class="input2" /></td>
     <td>   <form name="form1" action="/OneCard/CommodityOrderServlet" method="get">
     <input type="hidden"  name="method" class="input2" value="find"  /> 
     <input type="hidden"  name="user" class="input2" value="<%=user.getId() %>"  /> 
    <input type="text"  name="id" class="input2" placeholder="输入订单号" /> 
    <input type="submit" id="button2" value="查询我的订单"  class="input2" onclick="return check()"/></form> </td>
    <td><input type="text"   class="input2"  disabled='disabled' value='我的余额：<%=user.getMoney() %>'/> </td>
    <td>    <input type="button" id="button2" value="充值" onclick="window.location=('<%=cp %>/Finance/Recharge.jsp')" class="input2" /></td>
</tr>
</table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
               
                <tr style="height: 25px" align="center">
                    <th scope="col">
                        订单号
                    </th>
                    <th scope="col">
                        商品编号
                    </th>
                    <th scope="col">
                        用户编号
                    </th>
                    <th scope="col">
                        创建时间
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>
                <c:forEach items="${requestScope.list}"  var="commodityOrder">
                <tr align="center">
                    <td>
                      ${commodityOrder.id}
                    </td>
                    <td>
                  
                   <div class="cdlist">
                   <div> <a href="/OneCard/CommodityServlet?method=findByCommodity&commodity=${commodityOrder.commodity}">${commodityOrder.commodity}</a> </div>
                    </div>
                    </td>
                    <td>
                      ${commodityOrder.user}  
                    </td>
                      
                    <td>
                      ${commodityOrder.ts} 
                    </td>
                    <td>
                     <a href="<%=cp %>/CommodityOrderServlet?method=delete&id=${commodityOrder.id}">删除订单</a>  
                    </td>
                </tr>
                </c:forEach>
                
                
            </tbody>
        </table>
    </div>
   

            </div>
        </div>
       <div class="footer">
            <p>Copyright&copy; 2016 东南大学 All Rights Reserved</p>
        </div>
    </div>
</body>
</html>
