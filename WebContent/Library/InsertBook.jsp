<%@ page language="java" import="java.util.*" import="data.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
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
<script type="text/javascript">
function check()
{
 if(document.form2.ISBN.value=="")
 {
 alert("请输入ISBN！");
 document.form2.ISBN.focus();
 return false;
 }
 if(document.form2.name.value=="")
 {
 alert("请输入书名！");
 document.form2.name.focus();
 return false;
 }
 if(document.form2.writer.value=="")
 {
 alert("请输入作者！");
 document.form2.writer.focus();
 return false;
 }
 if(document.form2.page.value=="")
 {
 alert("请输入页数！");
 document.form2.page.focus();
 return false;
 }
 if(document.form2.date.value=="")
 {
 alert("请输入出版年！");
 document.form2.date.focus();
 return false;
 }
 if(document.form2.publisher.value=="")
 {
 alert("请输入出版社！");
 document.form2.publisher.focus();
 return false;
 }
 if(document.form2.num.value=="")
 {
 alert("请输入馆存数！");
 document.form2.num.focus();
 return false;
 }
return true;
}
</script>
    
    
    <link href="<%=cp %>/Style/StudentStyle.css" rel="stylesheet" type="text/css" />
    <script src="<%=cp %>/Script/Base.js" type="text/javascript"></script>
    
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
                        <div>
                            <a href="<%=cp %>/UserInfo/index.jsp">我的信息</a></div>
                        <div>
                            <a href="<%=cp %>/UserInfo/ManageUser.jsp">管理用户 </a>
                        </div>
                        
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
        在线图书馆 &gt; 添加书籍</h2>
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="<%=cp %>/Library/MyBorrow.jsp">我的预约</a></li>
            <li><a class="tab2" href="<%=cp %>/Library/Borrow.jsp">预约书籍</a></li>
            <li><a class="tab2" href="<%=cp %>/Library/ManageBook.jsp">管理书籍</a></li>
            
        </ul>
    </div>
<div class="cztable">
    <form name="form2" method="get" action="/OneCard/BookServlet"  >
    <input name="method" type="hidden" value="insert"/>
    <table width="50%" cellpadding="0" cellspacing="0"> 
        <tr> 
            <td align="right">ISBN：</td>
            <td><input name="ISBN" type="text" placeholder="ISBN"/></td>
        </tr>
        <tr>
            <td align="right">书名：</td>
            <td><input type="text" name="name" placeholder="书名"/></td>
        </tr>
        <tr>
            <td align="right">作者：</td>
            <td><input type="text" name="writer" placeholder="作者"/></td>
        </tr>
        <tr>
            <td align="right">页数：</td>
            <td><input name="page" type="text" placeholder="页数"/></td>    
        </tr>  
        <tr>
            <td align="right">出版年：</td>
            <td><input name="date" type="text" placeholder="格式：yyyy-mm-dd"/></td>
        </tr>
        <tr>
            <td align="right">出版社：</td>
            <td><input name="publisher" type="text" placeholder="出版社"/></td>    
        </tr>
        <tr>
            <td align="right">馆存数：</td>
            <td><input name="num" type="text" placeholder="馆存"/></td>    
        </tr>
       
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="submit" id="button3" value="保存"  class="input2" onclick="return check()" />
                </div>
            </td>
        </tr>
    </table>
    </form>
</div>

            </div>
        </div>
        <div class="footer">
            <p>Copyright&copy; 2016 东南大学 All Rights Reserved</p>
        </div>
    </div>
</body>
</html>
