<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>

<div class="main" style="background-image: url('images/ucmo.jpg');">
	
	<div class="wrap-contact100">
		<form method="POST" action='CategoryController' name="frmAddStore" class="validate-form" >
			<div style="display:inline-block;"><h4>Add Category Details</h4></div>
			<div class="space30"></div>
			<input class="input100" type="hidden" readonly="readonly" name="category_id" value="<c:out value="${category.categoryId}" />">
			<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
				<div class="label-input100" style="display:inline-block; width:20%">Category name <span class="color_red">*</span></div>
 					<div style="display:inline-block;width:69%">
					<input required class="input100" type="text" name="category_name" placeholder="Enter category name" value="<c:out value="${category.categoryName}" />">
				</div>
			</div>
			<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
				<div class="label-input100" style="display:inline-block; width:20%">Description <span class="color_red">*</span></div>
 					<div style="display:inline-block;width:69%">
					<textarea required   rows="4" cols="20" class="input100" name="description" placeholder="Enter Description"><c:out value="${category.description}" /></textarea>
				</div>
			</div>
			
			<div class="container-contact100-form-btn">
				<input type="submit" value="Save" class="css-button">
				&nbsp;<a href="CategoryController?action=listCategories" class="css-cancel-button">Cancel</a>
			</div>
			
			
		</form>
	</div>
</div>
<%@ include file="footer.jsp" %>
