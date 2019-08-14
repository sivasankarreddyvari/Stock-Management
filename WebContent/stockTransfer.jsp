<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>
<div class="main" style="background-image: url('images/bg-01.jpg');">
		<div class="wrap-contact100">
			<form method="POST" action='ProductController' name="frmAddStore" class="validate-form">
			
				<div style="display:inline-block;"><h4>Stock Transfer</h4></div>
			
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Product <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%important!">
						<select name="product_id" class="input100">
							<option value="">Please select Product</option>
						    <c:forEach items="${listProducts}" var="product">
						        <option value="${product.productId}">${product.productName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
				
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Source Store <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%important!">
						<select name="source_store_id" class="input100">
							<option value="">Please select store</option>
						    <c:forEach items="${listStores}" var="store">
						        <option value="${store.storeId}">${store.storeName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
			
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%">Original Quantity<span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input class="input100" type="text" readonly="readonly" name="quantity" value="<c:out value="" />">
					</div>
				</div>
				
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Destination Store <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%important!">
						<select name="destination_store_id" class="input100">
							<option value="">Please select destination store</option>
						    <c:forEach items="${listStores}" var="dstore">
						        <option value="${dstore.storeId}">${dstore.storeName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
				
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%">Transfer Quantity<span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input class="input100" type="text" name="transfer_quantity" value="<c:out value="" />">
					</div>
				</div>
				
				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							Transfer
						</button>
					</div>
					<div class="clearfix"></div>
					<div >
					<div class="space10"></div>&nbsp;<a href="ProductController?action=listProducts" style="font-size:16px">Cancel</a>
					</div>
				</div>
				
			</form>		
		
		</div>
</div>
<%@ include file="footer.jsp" %>			