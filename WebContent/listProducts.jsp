<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>
<div class="main" style="background-image: url('images/ucmo.jpg');">
	<div class="wrap-contact100-list">
		<c:if test="${param.prod_edit_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Product Modified Successfully</div>
		</c:if>
		<c:if test="${param.prod_add_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Product Added Successfully</div>
		</c:if>
		<c:if test="${param.prod_delete_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Product Deleted Successfully</div>
		</c:if>
		
		<div>
	  		<div style="display:inline-block;width:50%" ><h3>Products Listing</h3></div>
	  		<div style="display:inline-block;text-align:right; width:49%">
	 			<a class="css-button" href="ProductController?action=prod_insert" >Add Product</a>
		  	</div>
		</div>
		<div>
			<form action="ProductController" method="GET">
				<%-- <div style="display:inline-block; width:10%;font-weight:bold;font-size:12px;text-align:right;"> Select Store: </div>
				<div style="display:inline-block; width:10%">
						
						<select name="store_id" class="input50-select">
							<option value="0">Please select store</option>
						    <c:forEach items="${listStores}" var="store">
						        <option value="${store.storeId}">${store.storeName}</option>
						    </c:forEach>
						</select>
					
			  	</div> --%>
			  	<input type="hidden" name="action" value="listProducts">
			  	<div style="width:10%;display:inline-block;text-align:right;font-weight:bold;font-size:12px;" >Product Name:</div>
			  	<div style="display:inline-block; width:10%">
		  			<input required type="text" name="product_name" value="<c:out value="${prodCookieName}" />" placeholder="Enter product name" class="input50">
			  	</div>
			  	&nbsp;
			  	<div style="display:inline-block;text-align:right; width:15%">
		  			<span><input type="submit" value="Search" class="normal-button"></span>
		  			<span></span><a href="ProductController?action=listProducts" class="normal-cancel-button">Clear</a></span>
			  	</div>
		  	</form>
		</div>
		<div class="space10"></div>
		<table id="t01">
		  	<thead>
			  	<tr>
			  		<th class="first-name">Store</th>
					<th class="first-name">Product Name</th>
					<th class="first-name">Description</th>
					<th class="first-name">Category</th>
					<th class="last-name">Price</th>
					<th class="first-name">Quantity</th>
					<th class="area-code">Action</th>
			  	</tr>
			</thead>
		  	<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td style="width:15%"><c:out value="${product.pStoreName}" /></td>
						<td style="width:20%"><c:out value="${product.productName}" /></td>
						<td style="width:20%"><c:out value="${product.description}" /></td>
						<td style="width:15%"><c:out value="${product.pCatName}" /></td>
						<td style="width:8%"><c:out value="${product.price}" /></td>
						<td style="width:8%"><c:out value="${product.quantity}" /></td>
						<td style="width:12%">
							<a class="decoration_none" href="ProductController?action=prod_edit&productId=<c:out value="${product.productId}"/>">Edit</a>
							 | <input type="button" name="delete" value="Delete" style="font-weight:bold;cursor:pointer;color:blue" onclick="deleteProduct(${product.productId});"> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="footer.jsp" %>

