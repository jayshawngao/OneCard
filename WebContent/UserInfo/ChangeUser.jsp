<%@ page language="java" import="java.util.*" import="data.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<% User user=(User)request.getSession().getAttribute("userInfo"); %>
<% String cp = request.getContextPath();%>
<% 
   String id=request.getParameter("id");
   String name=request.getParameter("name");
   String pwd=request.getParameter("pwd");
   String sex=request.getParameter("sex");
   String age=request.getParameter("age");
   String phone=request.getParameter("phone");
   String level=request.getParameter("level");
   String money=request.getParameter("money");
   String photo=request.getParameter("photo");
   String flag=request.getParameter("flag");
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
 
 if(document.form1.pwd1.value!=document.form1.pwd2.value){
	 alert("两次密码不相同！");
	 document.form1.pwd2.focus();
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
                    
                   <%=user.getId()%><%=user.getLevel() %>:<%=user.getName() %>&nbsp;欢迎您！<a href="<%=cp %>/UserInfo/index.jsp">我的信息</a><a  href="/OneCard/LogOutServlet">安全退出</a>
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
                
<h2 class="mbx">个人中心&gt; 修改信息 &nbsp;&nbsp;&nbsp;</h2>       
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="<%=cp %>/UserInfo/index.jsp">个人资料</a> </li>
    <li><a class="tab2" onclick="" href="<%=cp %>/UserInfo/ManageUser.jsp">管理用户</a></li>

</ul>

</div>
<div class="cztable">
    <form name="form1" method="get" action="/OneCard/UserServlet"  >
    <input type="hidden" name="method" value="update" />
    <input type="hidden" name="id" value="<%=id %>"  />
    <input type="hidden" name="level" value="<%=level %>" />
    <input type="hidden" name="money" value="<%=money %>"  />
    <input type="hidden" name="flag" value="<%=flag %>" />
    <input type="hidden" name="photo" value="<%=photo %>" />
    <table width="50%" cellpadding="0" cellspacing="0">

        
        <tr>
        
            <td align="right">姓名：</td>
            <td><input type="text" name="name" value="<%=name %>" />&nbsp;</td>
 
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td><input type="text" name="sex" value="<%=sex %>" />&nbsp;</td>

        </tr>
        <tr>
            <td align="right">年龄：</td>
            <td><input type="text" name="age" value="<%=age %>" />&nbsp;</td>

        </tr>
       

        <tr>
            <td align="right">联系方式：</td>
            <td><input type="text" name="phone" value="<%=phone %>" /></td>    
        </tr>
       
        <tr>
            <td align="right">密码：</td>
            <td><input type="text" name="pwd1" value="<%=pwd %>" /></td>    
        </tr>
        <tr>
            <td align="right">确认密码：</td>
            <td><input type="text" name="pwd2" placeholder="再次确认密码" /></td>    
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
