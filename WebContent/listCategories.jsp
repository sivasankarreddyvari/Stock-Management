<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>

<div class="main" style="background-image: url('images/ucmo.jpg');">

	<div class="wrap-contact100-list">
		<c:if test="${param.cat_edit_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Category Modified Successfully</div>
		</c:if>
		<c:if test="${param.cat_add_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Category Added Successfully</div>
		</c:if>
		<c:if test="${param.cat_delete_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Category Deleted Successfully</div>
		</c:if>
		<div>
	  		<div style="display:inline-block;width:40%"><h3>Category Listing</h3></div>
	  		<div style="display:inline-block;text-align:right; width:59%">
	 			<a class="decoration_none" href="CategoryController?action=cat_insert"><h3>Add Category</h3></a>
		  	</div>
		</div>
		<div class="space10"></div>
		<table id="t01">
		  	<thead>
			  	<tr>
					<th class="first-name">Category Name</th>
					<th class="first-name">Description</th>
					<th class="area-code">Action</th>
			  	</tr>
			</thead>
		  	<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td style="width:20%"><c:out value="${category.categoryName}" /></td>
						<td style="width:30%"><c:out value="${category.description}" /></td>
						<td style="width:15%">
							<a class="decoration_none" href="CategoryController?action=cat_edit&categoryId=<c:out value="${category.categoryId}"/>">Edit</a>
							<%--<input type="button" name="delete" value="Delete" style="font-weight:bold;cursor:pointer;color:blue;" onclick="deleteCategory(${category.categoryId});"> --%> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="footer.jsp" %>