package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import data.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd1");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String level=request.getParameter("t1");
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setMoney(0);
		user.setSex(sex);
		user.setAge(age);
		user.setPhone(phone);
		user.setLevel(level);
		UserDao.insert(user);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter  out = response.getWriter();
		out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
		out.print("<script>");
		if(request.getParameter("method").equals("register")){
			out.print("alert('注册成功！请牢记自己的账户ID："+UserDao.findMax().getId()+"');");
			out.print("window.location.href='login.html'");
		}
		else if(request.getParameter("method").equals("insert")){
			out.print("alert('新建用户成功！');");
			out.print("window.location.href='UserServlet?method=all'");
		}
			
		out.print("</script>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
