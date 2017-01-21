package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import dao.CommodityDao;
import dao.CommodityOrderDao;
import data.Commodity;
import data.CommodityOrder;
import data.User;

/**
 * Servlet implementation class CommodityOrderServlet
 */
@WebServlet("/CommodityOrderServlet")
public class CommodityOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method").equals("commodity")){
			int user=Integer.parseInt(request.getParameter("user"));
			List<CommodityOrder> list=CommodityOrderDao.findByUser(user);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Finance/MyOrder.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("find")){
			int user=Integer.parseInt(request.getParameter("user"));
			int id=Integer.parseInt(request.getParameter("id"));
			List<CommodityOrder> list=CommodityOrderDao.findByUserAndID(user, id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("Finance/MyOrder.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			User user=(User)request.getSession().getAttribute("userInfo");
			CommodityOrderDao.delete(id);
			request.getRequestDispatcher("CommodityOrderServlet?method=commodity&user="+user.getId()+"").forward(request,response);
		}
		else if(request.getParameter("method").equals("order")){
			int id=Integer.parseInt(request.getParameter("id"));
			double price=Double.parseDouble(request.getParameter("price"));
			CommodityOrder co=new CommodityOrder();
			User user=(User)request.getSession().getAttribute("userInfo");
			
			user.setMoney(user.getMoney()-price);
			co.setCommodity(id);
			co.setUser(Integer.parseInt(user.getId()));
			CommodityOrderDao.insert(co);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");   
			out.print("<script>");
			out.print("alert('¹ºÂò³É¹¦£¡');");
			out.print("window.location.href='CommodityOrderServlet?method=commodity&user="+user.getId()+"'");
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
