package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BookOrderDao;
import data.Book;
import data.BookOrder;
import data.User;


/**
 * Servlet implementation class BookOrderServlet
 */
@WebServlet("/BookOrderServlet")
public class BookOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method").equals("user")){
			int user=Integer.parseInt(request.getParameter("user"));
			List<BookOrder> list=BookOrderDao.findByUser(user);
			request.setAttribute("list", list);
			request.getRequestDispatcher("Library/MyBorrow.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("find")){
			int user=Integer.parseInt(request.getParameter("user"));
			int id=Integer.parseInt(request.getParameter("id"));
			List<BookOrder> list=BookOrderDao.findByUserAndId(user, id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("Library/MyBorrow.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("borrow")){
			String ISBN=request.getParameter("ISBN");
			Book book=BookDao.findByISBN(ISBN);
			book.setNum(book.getNum()-1);
			BookDao.update(book);
			BookOrder bo=new BookOrder();
			User user=(User)request.getSession().getAttribute("userInfo");
			bo.setISBN(ISBN);
			bo.setUser(Integer.parseInt(user.getId()));
			BookOrderDao.insert(bo);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");   
			out.print("<script>");
			out.print("alert('预约成功！');");
			out.print("window.location.href='BookOrderServlet?method=user&user="+user.getId()+"'");
			out.print("</script>");
			out.close();
		}
		else if(request.getParameter("method").equals("delete")){
			String id=request.getParameter("id");
			String ISBN=request.getParameter("ISBN");
			User user=(User)request.getSession().getAttribute("userInfo");
			BookOrderDao.delete(Integer.parseInt(id));
			Book book=BookDao.findByISBN(ISBN);
			book.setNum(book.getNum()+1);
			BookDao.update(book);
			request.getRequestDispatcher("BookOrderServlet?method=user&user="+user.getId()+"").forward(request,response);
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter  out = response.getWriter();
//			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");   
//			out.print("<script>");
//			out.print("alert('取消成功！');");
//			out.print("window.location.href='BookOrderServlet?method=user&user="+user.getId()+"'"); 
//			out.print("</script>");
//			out.close();
			
			
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
