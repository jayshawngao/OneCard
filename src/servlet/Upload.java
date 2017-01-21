package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;

import dao.BookDao;
import dao.CommodityDao;
import dao.UserDao;
import data.Book;
import data.Commodity;
import data.User;
/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinationfileName=null;
		response.setContentType("text/html");
	//   ͼƬ�ϴ�·��
	   String uploadPath =request.getServletContext().getRealPath("/")+"upload/images/";
	//   ͼƬ��ʱ�ϴ�·��
	   String tempPath = request.getServletContext().getRealPath("/")+"upload/images/temp/";
	//   ͼƬ�������·��
	   String imagePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	//   �ļ��в����ھ��Զ�������
	   if(!new File(uploadPath).isDirectory())
	   new File(uploadPath).mkdirs();
	   if(!new File(tempPath).isDirectory())
	   new File(tempPath).mkdirs();
	   try {
	   DiskFileUpload fu = new DiskFileUpload();
	//   ��������ļ��ߴ磬������4MB
	   fu.setSizeMax(4194304);
	//   ���û�������С��������4kb
	   fu.setSizeThreshold(4096);
	//   ������ʱĿ¼��
	   fu.setRepositoryPath(tempPath);
	//   �õ����е��ļ���
	   List fileItems = fu.parseRequest(request);
	   Iterator i = fileItems.iterator();
	//   ���δ���ÿһ���ļ���
	   while(i.hasNext()) {
	   FileItem file = (FileItem)i.next();
	//   ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
	   String sourcefileName = file.getName();
	   if(sourcefileName!=null&&(sourcefileName.endsWith(".jpg")||sourcefileName.endsWith(".gif"))) {
	//   ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���
	   
	   Random rd = new Random();
	   Calendar time = Calendar.getInstance();
	   if(sourcefileName.endsWith(".jpg")){
	   destinationfileName=String.valueOf(time.get(Calendar.YEAR))
	   + String.valueOf(time.get(Calendar.MONTH))
	   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))
	   + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
	   + String.valueOf(time.get(Calendar.MINUTE))
	   + String.valueOf(time.get(Calendar.SECOND))
	   + String.valueOf(rd.nextInt(100)) + ".jpg";
	   }else if(sourcefileName.endsWith(".gif")){
	   destinationfileName=String.valueOf(time.get(Calendar.YEAR))
	   + String.valueOf(time.get(Calendar.MONTH))
	   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))
	   + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
	   + String.valueOf(time.get(Calendar.MINUTE))
	   + String.valueOf(time.get(Calendar.SECOND))
	   + String.valueOf(rd.nextInt(100)) + ".gif";
	   }
	   File f1=new File(uploadPath+ destinationfileName);
	   file.write(f1);
	  
	   
	   
	   }
	   }
	   if(request.getParameter("method").equals("user")){
	   User user=(User)request.getSession().getAttribute("userInfo");
		   user.setPhoto(destinationfileName);
		   UserDao.update(user);
		   request.getSession().setAttribute("userInfo", user);
		   response.sendRedirect("/OneCard/UserInfo/index.jsp");
	   }
	   else if(request.getParameter("method").equals("book")){
		   String ISBN=request.getParameter("ISBN");
		   Book book=BookDao.findByISBN(ISBN);
		   book.setPhoto(destinationfileName);
		   BookDao.update(book);
		   request.setAttribute("book", book);
		   request.getRequestDispatcher("/Library/Detail.jsp").forward(request,response);
	   }
	   else if(request.getParameter("method").equals("commodity")){
		   int id=Integer.parseInt(request.getParameter("id"));
		   Commodity c=CommodityDao.findById(id);
		   c.setPhoto(destinationfileName);
		   CommodityDao.update(c);
		   request.setAttribute("commodity", c);
		   request.getRequestDispatcher("/Finance/Detail.jsp").forward(request,response);
	   }
	   
	   }
	   catch(Exception e) {
	//   ������ת����ҳ��
	   }
	   PrintWriter  out = response.getWriter();
	   out.flush();
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
