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
	//   图片上传路径
	   String uploadPath =request.getServletContext().getRealPath("/")+"upload/images/";
	//   图片临时上传路径
	   String tempPath = request.getServletContext().getRealPath("/")+"upload/images/temp/";
	//   图片网络相对路径
	   String imagePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	//   文件夹不存在就自动创建：
	   if(!new File(uploadPath).isDirectory())
	   new File(uploadPath).mkdirs();
	   if(!new File(tempPath).isDirectory())
	   new File(tempPath).mkdirs();
	   try {
	   DiskFileUpload fu = new DiskFileUpload();
	//   设置最大文件尺寸，这里是4MB
	   fu.setSizeMax(4194304);
	//   设置缓冲区大小，这里是4kb
	   fu.setSizeThreshold(4096);
	//   设置临时目录：
	   fu.setRepositoryPath(tempPath);
	//   得到所有的文件：
	   List fileItems = fu.parseRequest(request);
	   Iterator i = fileItems.iterator();
	//   依次处理每一个文件：
	   while(i.hasNext()) {
	   FileItem file = (FileItem)i.next();
	//   获得文件名，这个文件名是用户上传时用户的绝对路径：
	   String sourcefileName = file.getName();
	   if(sourcefileName!=null&&(sourcefileName.endsWith(".jpg")||sourcefileName.endsWith(".gif"))) {
	//   在这里可以记录用户和文件信息,生成上传后的文件名
	   
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
	//   可以跳转出错页面
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
