<%@ page language="java" import="java.util.*" import="data.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% User user=(User)request.getSession().getAttribute("userInfo"); %>
<% String cp = request.getContextPath();%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	东南一卡通
</title> <link href="<%=cp %>/css/img.css" rel="stylesheet" type="text/css"/><link href="<%=cp %>/Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="<%=cp %>/Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="<%=cp %>/Style/ks.css" rel="stylesheet" type="text/css" />
    

    
    
    <script src="<%=cp %>/Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/Common.js" type="text/javascript"></script>
    <script src="<%=cp %>/Script/Data.js" type="text/javascript"></script>

    
    
</head>
<body>

    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                   
                        <img src="<%=cp %>/img/logo.png" alt="" class="titleimg"/>
                        
                    
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
                
<h2 class="mbx">个人中心 &gt; 我的信息 &nbsp;&nbsp;&nbsp;</h2>       
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">

    <li><a class="tab2" onclick="" href="<%=cp %>/UserInfo/index.jsp">个人资料</a> </li>
    <li><a class="tab2" onclick="" href="<%=cp %>/UserInfo/ManageUser.jsp">管理用户</a></li>

</ul>

</div>
<div class="cztable">
    <table width="65%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" >账户：</td>
            <td><%=user.getId() %>&nbsp;</td>
                    <td rowspan="7"><div align="center"><a href="/OneCard/UserInfo/UploadPhoto.jsp"><img id="pic_face"  height="160" width="120" title="上传头像" src="/OneCard/upload/images/<%=user.getPhoto() %>" style="padding:2px 2px 5px; border:1px #ddd solid;"></a></div>&nbsp;</td>
        
            
        </tr>
        <tr>
            <td align="right">姓名：</td>
            <td><%=user.getName() %>&nbsp;</td>
 
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td><%=user.getSex() %>&nbsp;</td>

        </tr>
        <tr>
            <td align="right">年龄：</td>
            <td><%=user.getAge() %>&nbsp;</td>

        </tr>
        <tr>
            <td align="right">级别：</td>
            <td><%=user.getLevel() %>&nbsp;</td>

        </tr>
        <tr>
            <td align="right">余额：</td>
            <td><%=user.getMoney() %>&nbsp;</td>

        </tr>
        <tr>
            <td align="right">联系方式：</td>
            <td><%=user.getPhone() %></td>    
        </tr>
        
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="button" id="button2" value="修改信息" onclick="window.location=('<%=cp %>/UserInfo/ChangeUser.jsp?id=<%=user.getId() %>&name=<%=user.getName() %>&sex=<%=user.getSex() %>&age=<%=user.getAge() %>&level=<%=user.getLevel() %>&money=<%=user.getMoney() %>&phone=<%=user.getPhone() %>&pwd=<%=user.getPwd() %>&photo=<%=user.getPhoto() %>&flag=1')" class="input2" />
                </div>
            </td>
        </tr>
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
