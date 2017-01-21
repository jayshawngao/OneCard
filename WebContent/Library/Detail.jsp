<%@ page language="java" import="java.util.*" import="data.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% User user=(User)request.getSession().getAttribute("userInfo"); %>
<% String cp = request.getContextPath();%>
<% Book book=(Book)request.getAttribute("book");
int num=book.getNum();
%>

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
 if(<%=num%>==0)
 {
 alert("抱歉，该书已无馆存！");
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
                    
                   <%=user.getId()%><%=user.getLevel() %>:<%=user.getName() %>&nbsp;欢迎您！<a href="/OneCard/UserInfo/index.jsp">我的信息</a><a  href="/OneCard/LogOutServlet">安全退出</a>
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
        在线图书馆 &gt; 书籍详情</h2>
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="<%=cp %>/Library/MyBorrow.jsp">我的预约</a></li>
            <li><a class="tab2" href="<%=cp %>/Library/Borrow.jsp">预约书籍</a></li>
            <li><a class="tab2" href="<%=cp %>/Library/ManageBook.jsp">管理书籍</a></li>
            
        </ul>
    </div>
<div class="cztable">
    <form name="form1" action="/OneCard/BookOrderServlet?ISBN=${requestScope.book.ISBN}&method=borrow" method="post">
    <table width="65%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" >ISBN：</td>
            <td>${requestScope.book.ISBN}&nbsp;</td>
                    <td rowspan="7"><div align="center"><a href="/OneCard/Library/UploadPhoto.jsp?ISBN=${requestScope.book.ISBN}"><img id="pic_face"  height="160" width="120" title="上传封面" src="/OneCard/upload/images/${requestScope.book.photo}" style="padding:2px 2px 5px; border:1px #ddd solid;"></a></div>&nbsp;</td>
        
            
        </tr>
        <tr>
            <td align="right">书名：</td>
            <td>${requestScope.book.name}&nbsp;</td>
 
        </tr>

        <tr>
            <td align="right">作者：</td>
            <td>${requestScope.book.writer}&nbsp;</td>

        </tr>
        <tr>
            <td align="right">页数：</td>
            <td>${requestScope.book.page}&nbsp;</td>

        </tr>
        <tr>
            <td align="right">出版年：</td>
            <td>${requestScope.book.date}&nbsp;</td>

        </tr>
        <tr>
            <td align="right">出版社：</td>
            <td>${requestScope.book.publisher}</td>    
        </tr>
        <tr>
            <td align="right">馆存数：</td>
            <td>${requestScope.book.num}</td>    
        </tr>
        
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="submit" id="button2" value="预约该书" onclick="return check()" class="input2" />
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
