package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import data.Book;
import util.StringToDate;
import util.StringToTimeStamp;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method").equals("all")){
			List<Book> list=BookDao.findAll();
			request.setAttribute("list", list);
			if(request.getParameter("flag").equals("1"))
				request.getRequestDispatcher("/Library/Borrow.jsp").forward(request,response);
			else if(request.getParameter("flag").equals("2"))
				request.getRequestDispatcher("/Library/ManageBook.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("findByName")){
			String name=request.getParameter("name");
			List<Book> list=BookDao.findByName(name);
			request.setAttribute("list", list);
			if(request.getParameter("flag").equals("1"))
				request.getRequestDispatcher("/Library/Borrow.jsp").forward(request,response);
			else if(request.getParameter("flag").equals("2"))
				request.getRequestDispatcher("/Library/ManageBook.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("insert")){
			String ISBN=request.getParameter("ISBN");
			String name=request.getParameter("name");
			String writer=request.getParameter("writer");
			int page=Integer.parseInt(request.getParameter("page"));
			String dateTemp=request.getParameter("date");
			java.sql.Date date=StringToDate.revert(dateTemp);
			String publisher=request.getParameter("publisher");
			int num=Integer.parseInt(request.getParameter("num"));
			
			Book book=new Book();
			book.setISBN(ISBN);
			book.setName(name);
			book.setWriter(writer);
			book.setPage(page);
			book.setDate(date);
			book.setPublisher(publisher);
			book.setNum(num);
			book.setPhoto("photo.jpg");
			BookDao.insert(book);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/Library/Detail.jsp").forward(request,response);
			
		}
		else if(request.getParameter("method").equals("findByISBN")){
			String ISBN=request.getParameter("ISBN");
			Book book=BookDao.findByISBN(ISBN);
			//System.out.println(book);
			request.setAttribute("book", book);
            request.getRequestDispatcher("/Library/Detail.jsp").forward(request,response);

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
