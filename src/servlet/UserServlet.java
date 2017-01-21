package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import data.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method").equals("all")){
			List<User> list=UserDao.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/UserInfo/ManageUser.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("update")){
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("pwd1"));
//			System.out.println(request.getParameter("sex"));
//			System.out.println(request.getParameter("age"));
//			System.out.println(request.getParameter("phone"));
//			System.out.println(request.getParameter("level"));
//			System.out.println(request.getParameter("money"));
//			System.out.println(request.getParameter("photo"));
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd1");
			String sex=request.getParameter("sex");
			int age=Integer.parseInt(request.getParameter("age"));
			String phone=request.getParameter("phone");
			String level=request.getParameter("level");
			double money=Double.parseDouble(request.getParameter("money"));
			String photo=request.getParameter("photo");
			User user= new User();
			user.setName(name);
			user.setPwd(pwd);
			user.setSex(sex);
			user.setAge(age);
			user.setPhone(phone);
			user.setId(id);
			user.setMoney(money);
			user.setLevel(level);
			user.setPhoto(photo);
			UserDao.update(user);
			request.getSession().setAttribute("userInfo", user);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('ÐÞ¸Ä³É¹¦£¡');");
			if(request.getParameter("flag").equals("1"))
			out.print("window.location.href='UserInfo/index.jsp'");
			else
				out.print("window.location.href='UserServlet?method=all'");
			out.print("</script>");
			out.close();
		}
		else if(request.getParameter("method").equals("delete")){
			String id=request.getParameter("id");
			UserDao.delete(Integer.parseInt(id));
			response.sendRedirect("UserServlet?method=all");
		}
		else if(request.getParameter("method").equals("find")){
			String id=request.getParameter("id");
			System.out.println(id);
			User user=UserDao.find(Integer.parseInt(id));
//			if(user.getId()!=null){
				List<User> list=new ArrayList<User>();
				if(user.getId()!=null) list.add(user);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/UserInfo/ManageUser.jsp").forward(request,response);
			}
		else if(request.getParameter("method").equals("recharge")){
			int money=Integer.parseInt(request.getParameter("money"));
			User user=(User)request.getSession().getAttribute("userInfo");
			user.setMoney(user.getMoney()+money);
			UserDao.update(user);
			request.getRequestDispatcher("/Finance/MyOrder.jsp").forward(request,response);
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
