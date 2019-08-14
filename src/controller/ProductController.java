package controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;  

import javax.servlet.annotation.WebServlet;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
 
import dao.ProductDao;
import model.Product;

import dao.StoreDao;
import model.Store;

import dao.CategoryDao;
import model.Category;
/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PROD_INSERT_OR_EDIT = "/product.jsp";
	private static String LIST_PRODUCTS = "/listProducts.jsp";
	private static String STOCK_TRANSFER = "/stockTransfer.jsp";
	private ProductDao prodDao;
	
	private CategoryDao catDao;
	private StoreDao sDao;
	
	private String modeUrl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        prodDao = new ProductDao();
        
    }
    
    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	catDao = new CategoryDao();
        sDao = new StoreDao();
 
    	List<Category> listCatagories = catDao.listCategories();
        request.setAttribute("listCatagories", listCatagories);
        
        List<Store> listStores = sDao.listStores();
        request.setAttribute("listStores", listStores);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        List<Product> listProducts = prodDao.listProducts();
        request.setAttribute("listProducts", listProducts);
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward = "";
		String action = request.getParameter("action");
		
		if (request.getParameter("productId") != null && !request.getParameter("productId").isEmpty()  
				&& action.equalsIgnoreCase("prod_delete")){
			int productId = Integer.parseInt(request.getParameter("productId"));
			prodDao.deleteProduct(productId);
			forward = LIST_PRODUCTS;
			
			request.setAttribute("products", prodDao.getAllProducts());
			//response.sendRedirect("StoreController?action=listStores&delete_success=1");
		} else if (request.getParameter("productId") != null && !request.getParameter("productId").isEmpty() 
				&& action.equalsIgnoreCase("prod_edit")){
			forward = PROD_INSERT_OR_EDIT;
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = prodDao.getProductById(productId);
			request.setAttribute("product", product);
		} else if (action != null && !action.isEmpty() && action.equalsIgnoreCase("listProducts")) {
			forward = LIST_PRODUCTS;
			
			if (( null != request.getParameter("product_name") && !request.getParameter("product_name").isEmpty())) {
				String prodName = request.getParameter("product_name");
				
				request.setAttribute("products", prodDao.getSearchProducts(prodName));
				request.setAttribute("prodCookieName", prodName);
			} else {
				request.setAttribute("products", prodDao.getAllProducts());
			}
			
		} else if (action != null && !action.isEmpty() &&  action.equalsIgnoreCase("prod_insert") ) {
			forward = PROD_INSERT_OR_EDIT;
		} /*
			 * else if (( null != request.getParameter("product_name") &&
			 * !request.getParameter("product_name").isEmpty())) { String storeId =
			 * request.getParameter("store_id"); //int storeId =
			 * Integer.parseInt(request.getParameter("store_id")); String prodName =
			 * request.getParameter("product_name");
			 * 
			 * Cookie productCookie = new Cookie("pCookie", prodName);
			 * productCookie.setMaxAge(100); response.addCookie(productCookie);
			 * 
			 * Cookie c[]= request.getCookies();
			 * 
			 * 
			 * 
			 * request.setAttribute("cookieProdName", c[1].getValue());
			 * 
			 * 
			 * forward = LIST_PRODUCTS; request.setAttribute("products",
			 * prodDao.getSearchProducts(storeId, prodName)); }
			 */
		
		listCategory(request, response);
		listProducts(request, response);
	 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String[] storeIds = request.getParameterValues("store_id");
		//System.out.println(storeIds);
		String productId = request.getParameter("product_id");
		
		Product product = new Product();
		product.setProductName(request.getParameter("product_name"));
		product.setDescription(request.getParameter("description"));
		product.setPicture(request.getParameter("picture"));
		product.setCategoryId(request.getParameter("category_id"));
		product.setPrice(request.getParameter("price"));
		product.setQuantity(request.getParameter("quantity"));
		
		if(productId == null || productId.isEmpty())
		{
			for(String id : storeIds) {
				if(null != id) {
						product.setStoreId(id);
					try {
						prodDao.addProduct(product);
						modeUrl = "ProductController?action=listProducts&prod_add_success=1";
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			try {
				product.setProductId(Integer.parseInt(productId));
				prodDao.updateProduct(product);
				modeUrl = "ProductController?action=listProducts&prod_edit_success=1";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCTS);
		request.setAttribute("products", prodDao.getAllProducts());
		//view.forward(request, response);
		response.sendRedirect(modeUrl);
	}
		
		
}


