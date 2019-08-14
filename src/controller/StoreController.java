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
 
import dao.StoreDao;
import model.Store;

@WebServlet("/StoreController")
public class StoreController extends HttpServlet {
private static final long serialVersionUID = 1L;
private static String INSERT_OR_EDIT = "/store.jsp";
private static String LIST_STORES = "/listStores.jsp";
private StoreDao dao;
private String modeUrl;
 
public StoreController() {
	super();
	dao = new StoreDao();
}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String forward = "";
	String action = request.getParameter("action");
	
	if (action.equalsIgnoreCase("delete")){
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		dao.deleteStore(storeId);
		forward = LIST_STORES;
		request.setAttribute("stores", dao.getAllStores());
		//response.sendRedirect("StoreController?action=listStores&delete_success=1");
	} else if (action.equalsIgnoreCase("edit")){
		forward = INSERT_OR_EDIT;
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		Store store = dao.getStoreById(storeId);
		request.setAttribute("store", store);
	} else if (action.equalsIgnoreCase("listStores")) {
		forward = LIST_STORES;
		request.setAttribute("stores", dao.getAllStores());
	} else if (action.equalsIgnoreCase("insert") ) {
		forward = INSERT_OR_EDIT;
	}
 
	RequestDispatcher view = request.getRequestDispatcher(forward);
	view.forward(request, response);
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Store store = new Store();
	store.setStoreName(request.getParameter("store_name"));
	store.setDescription(request.getParameter("description"));
	store.setAddress1(request.getParameter("address1"));
	store.setAddress2(request.getParameter("address2"));
	store.setCity(request.getParameter("city"));
	store.setState(request.getParameter("state"));
	store.setZipCode(request.getParameter("zip_code"));
	store.setPhoneNumber(request.getParameter("phone_number"));

	String storeId = request.getParameter("store_id");

	if(storeId == null || storeId.isEmpty())
	{
		dao.addStore(store);
		modeUrl = "StoreController?action=listStores&add_success=1";
	}
	else
	{
		store.setStoreId(Integer.parseInt(storeId));
		dao.updateStore(store);
		modeUrl = "StoreController?action=listStores&edit_success=1";
	}
		RequestDispatcher view = request.getRequestDispatcher(LIST_STORES);
		request.setAttribute("stores", dao.getAllStores());
		//view.forward(request, response);
		response.sendRedirect(modeUrl);
	}
}
