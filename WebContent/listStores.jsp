<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>

<div class="main" style="background-image: url('images/ucmo.jpg');">
		<div class="wrap-contact100-list">
		<c:if test="${param.edit_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Store Modified Successfully</div>
		</c:if>
		<c:if test="${param.add_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Store Added Successfully</div>
		</c:if>
		<c:if test="${param.delete_success eq 1}">
	    	<div id="successMsg" style="text-align:center; color:blue">Store Deleted Successfully</div>
		</c:if>
		<div>
	  		<div style="display:inline-block;width:38%" class="page_heading"><h2>&nbsp;Store Listing</h2></div>
	  		<div style="display:inline-block;text-align:right; width:59%" class="page_heading">
	 			<a class="decoration_none" href="StoreController?action=insert">Add Store&nbsp;</a>
		  	</div>
		</div>
		<div class="space10"></div>
		<table id="t01">
		  	<thead>
			  	<tr>
					<th class="">Store Name</th>
					<th class="">Description</th>
					<th class="">Address</th>
					<th class="">Contact #</th>
					<th class="">Action</th>
			  	</tr>
			</thead>
		  	<tbody>
				<c:forEach items="${stores}" var="store">
					<tr>
						<td style="width:20%"><c:out value="${store.storeName}" /></td>
						<td style="width:30%"><c:out value="${store.description}" /></td>
						<td style="width:25%"><c:out value="${store.address1}, ${store.address2}, ${store.city}, ${store.state}, ${store.zipCode} " /></td>
						<td style="width:10%"><c:out value="${store.phoneNumber}" /></td>
						<td style="width:15%">
							<a class="decoration_none" href="StoreController?action=edit&storeId=<c:out value="${store.storeId}"/>">Edit</a>
							<%-- <a class="decoration_none" href="StoreController?action=delete&storeId=<c:out value="${store.storeId}"/>">Delete</a>--%>
							<%--<input type="button" name="delete" value="Delete" style="font-weight:bold;cursor:pointer;color:blue" onclick="deleteStore(${store.storeId});"> --%> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="footer.jsp" %>

<%@ include file="footer.jsp" %>