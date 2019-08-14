<%@ include file="header.jsp" %>
<%@ include file="sideMenu.jsp" %>
<div class="main" style="background-image: url('images/ucmo.jpg');">
		<div class="wrap-contact100">
			<form method="POST" action='StoreController' name="frmAddStore" class="validate-form" >
				<div style="display:inline-block;"><h4>Add Store Details</h4></div>
				<div class="space30"></div>
				<input class="input100" type="hidden" readonly="readonly" name="store_id" value="<c:out value="${store.storeId}" />">
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%">Store name <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="store_name" placeholder="Enter store name" value="<c:out value="${store.storeName}" />">
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width">
					<div class="label-input100" style="display:inline-block; width:20%">Description <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<textarea required rows="4" cols="20" class="input100" name="description" placeholder="Enter Description"><c:out value="${store.description}" /></textarea>
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Address 1 <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="address1" placeholder="Enter address" value="<c:out value="${store.address1}" />" >
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Address 2 </div>
  					<div style="display:inline-block;width:69%">
						<input class="input100" type="text" name="address2" placeholder="Enter address 2" value="<c:out value="${store.address2}" />" >
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">City <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="city" placeholder="Enter city" value="<c:out value="${store.city}" />" >
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">State <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="state" placeholder="Enter state" value="<c:out value="${store.state}" />" >
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Zip Code <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="zip_code" maxlength="10" placeholder="Enter zip code" value="<c:out value="${store.zipCode}" />" >
					</div>
				</div>
				<div class="wrap-input100 rs1-wrap-input100 validate-input div_width" >
					<div class="label-input100" style="display:inline-block; width:20%">Contact # <span class="color_red">*</span></div>
  					<div style="display:inline-block;width:69%">
						<input required class="input100" type="text" name="phone_number" id="phone_number" maxlength="10" placeholder="Enter contact" value="<c:out value="${store.phoneNumber}" />" >
					</div>
					<br><span id="showError" style="display:none;padding-left:135px;color:red"></span>
				</div>
				
				<div class="container-contact100-form-btn">
					<input type="submit" value="Save" class="css-button">
					&nbsp;<a href="StoreController?action=listStores" class="css-cancel-button">Cancel</a>
				</div>
				
			</form>
		</div>
	</div>
<%@ include file="footer.jsp" %>