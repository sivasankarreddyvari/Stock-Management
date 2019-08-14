<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>
<div class="main" style="background-image: url('images/ucmo.jpg');">
		<div class="wrap-contact100">
			<form method="POST" action='ProductController' name="frmAddStore" class="validate-form">
				<div style="display:inline-block;"><h4>Add Product Details</h4><br></div>
				<div class="space10"></div>
				<input class="input100" type="hidden" readonly="readonly" name="product_id" value="<c:out value="${product.productId}" />">
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%;v-align:top"> Product name <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="product_name" placeholder="Enter product name" value="<c:out value="${product.productName}" />">
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%;"><span style="padding-top:-100px;">Description </span><span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<textarea   rows="4" cols="15" class="input100" name="description" placeholder="Enter Description" required><c:out value="${product.description}" />
						</textarea>
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Category <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%important!">
						<select required name="category_id" class="input100" style="width:350px!important">
							<option value="" >Please select category</option>
						    <c:forEach items="${listCatagories}" var="category">
						        <option value="${category.categoryId}" <c:if test="${category.categoryId eq product.categoryId}">selected="selected"</c:if>
						        >${category.categoryName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Store <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<select <c:if test="${product.productId != null}">disabled</c:if> <c:if test="${product.productId == null}">multiple</c:if> required name="store_id" class="input100-select">
						    <c:forEach items="${listStores}" var="store">
						        <option value="${store.storeId}" <c:if test="${store.storeId eq product.storeId}">selected="selected"</c:if>
						        >${store.storeName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Price <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="price" id="price" maxlength="15" placeholder="Enter price" value="<c:out value="${product.price}" />" >
					</div>
					<br><span id="priceShowError" style="display:none;padding-left:135px;color:red"></span>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Quantity <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input  required class="input100" type="text" name="quantity" id="quantity" maxlength="15" placeholder="Enter quantity" value="<c:out value="${product.quantity}" />" >
					</div>
					<br><span id="qtyShowError" style="display:none;padding-left:135px;color:red"></span>
				</div>
				<div class="space30"></div>
				<div class="container-contact100-form-btn">
					<input type="submit" value="Save" class="css-button">
					&nbsp;<a href="ProductController?action=listProducts" class="css-cancel-button">Cancel</a>
				</div>
				
				
<%--				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							Save
						</button>
					</div>
					<div class="clearfix"></div>
					<div >
					<div class="space10"></div>&nbsp;<a href="ProductController?action=listProducts" style="font-size:16px">Cancel</a>
					</div>
				</div> --%>
			</form>
		</div>
	</div>
<%@ include file="footer.jsp" %>	