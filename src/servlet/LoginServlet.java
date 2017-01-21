package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import data.User;
import jdbc.Connsql;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getServletContext().getRealPath(""));
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String level=request.getParameter("t1");
		User user=new User();
		user=UserDao.find(Integer.parseInt(id));
		if(user.getId()==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");   
			out.print("<script>");
			out.print("alert('该账户不存在！');");
			out.print("window.location.href='login.html'");
			out.print("</script>");
			out.close();	
		}
		else if(!user.getPwd().equals(pwd)){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('密码错误！');");
			out.print("window.location.href='login.html'");
			out.print("</script>");
			out.close();
		}
		else if(!user.getLevel().equals(level)){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('您不是该权限！');");
			out.print("window.location.href='login.html'");
			out.print("</script>");
			out.close();	
		}
		else{
			HttpSession hs=request.getSession();
			hs.setAttribute("userInfo", user);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("window.location.href='UserInfo/index.jsp'");
			out.print("</script>");
			out.close();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
