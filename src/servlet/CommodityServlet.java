package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import data.Commodity;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/CommodityServlet")
public class CommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("method").equals("findByCommodity")){
			int id=Integer.parseInt(request.getParameter("commodity"));
			Commodity c=CommodityDao.findById(id);
			request.setAttribute("commodity", c);
			request.getRequestDispatcher("/Finance/Detail.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("all")){
			List<Commodity> list=CommodityDao.findAll();
			request.setAttribute("list", list);
			if(request.getParameter("flag").equals("1"))
				request.getRequestDispatcher("/Finance/Market.jsp").forward(request,response);
			else if(request.getParameter("flag").equals("2"))
				request.getRequestDispatcher("/Finance/ManageMarket.jsp").forward(request,response);
		}
		else if(request.getParameter("method").equals("insert")){
			String name=request.getParameter("name");
			double price=Double.parseDouble(request.getParameter("price"));
			Commodity c=new Commodity();
			c.setName(name);
			c.setPrice(price);
			CommodityDao.insert(c);
			c=CommodityDao.findMax();
			request.setAttribute("commodity", c);
			request.getRequestDispatcher("/Finance/Detail.jsp").forward(request,response);
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
