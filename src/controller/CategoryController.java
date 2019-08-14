package controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;
import model.Store;



/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String CAT_INSERT_OR_EDIT = "/category.jsp";
	private static String LIST_CATEGORIES = "/listCategories.jsp";
       
	private String modeUrl;
	private CategoryDao catDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
        catDao = new CategoryDao();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("cat_delete")){
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			catDao.deleteCategory(categoryId);
			forward = LIST_CATEGORIES;
			request.setAttribute("categories", catDao.getAllCategories());
			//response.sendRedirect("StoreController?action=listStores&delete_success=1");
		} else if (action.equalsIgnoreCase("listCategories")) {
			forward = LIST_CATEGORIES;
			request.setAttribute("categories", catDao.getAllCategories());
		} else if (action.equalsIgnoreCase("cat_insert") ) {
			forward = CAT_INSERT_OR_EDIT;
		} else if (action.equalsIgnoreCase("cat_edit")){
			forward = CAT_INSERT_OR_EDIT;
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			Category category = catDao.getCategoryById(categoryId);
			request.setAttribute("category", category);
		} 
			
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setCategoryName(request.getParameter("category_name"));
		category.setDescription(request.getParameter("description"));
		
		String categoryId = request.getParameter("category_id");
		
		if(categoryId == null || categoryId.isEmpty())
		{
			catDao.addCategory(category);
			modeUrl = "CategoryController?action=listCategories&cat_add_success=1";
		}
		else
		{
			category.setCategoryId(Integer.parseInt(categoryId));
			catDao.updateCategory(category);
			modeUrl = "CategoryController?action=listCategories&cat_edit_success=1";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORIES);
		request.setAttribute("categories", catDao.getAllCategories());
		//view.forward(request, response);
		response.sendRedirect(modeUrl);
		
	}

}
