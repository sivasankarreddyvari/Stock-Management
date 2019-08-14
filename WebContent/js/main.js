
	
$("#tablist").on('click','li',function(){
    // remove classname 'active' from all li who already has classname 'active'
   // $("#tablist li.active").removeClass("active"); 
    // adding classname 'active' to current click li 
    $(this).addClass("active"); 
});




(function ($) {
    "use strict";

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        $("#showError").hide();
        $("#showError").html('');
        $("#priceShowError").hide();
        $("#priceShowError").html('');
        $("#qtyShowError").hide();
        $("#qtyShowError").html('');
        
        for(var i=0; i<input.length; i++) {
        	
        	//alert($(input[i]).attr('name'));
        	
            if(validate(input[i]) == false){
            	//alert('----'+$(input[i]).attr('name'));
                showValidate(input[i]);
                check = false;
            } else if ( ( $(input[i]).attr('name') == 'phone_number' && (isNaN($('#phone_number').val()) == true) ) ) {
        		//alert('aaa');
            	$("#showError").show();
            	$("#showError").html('Field should be numeric');
            	
                check = false;
            }
            else if ( ( $(input[i]).attr('name') == 'price' && (isNaN($('#price').val()) == true) ) ) {
            	//alert('bbbb');
            	$("#priceShowError").show();
            	$("#priceShowError").html('Field should be numeric');
            	
                check = false;
            }
            else if ( ( $(input[i]).attr('name') == 'quantity' && (isNaN($('#quantity').val()) == true) ) ) {
            	//alert('cccc');
            	$("#qtyShowError").show();
            	$("#qtyShowError").html('Field should be numeric');
            	
                check = false;
            }
        }

        return check;
        //window.location.href = "http://localhost:8080/StockManagement/StoreController?action=listStores";
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    

})(jQuery);

function deleteProduct(productId) {
	  var doIt = confirm('Do you want to delete the Product?');
	  if(doIt) {
		  window.location.href = 'ProductController?action=prod_delete&productId='+productId;
	  } else {
		//Nothing...
	  }
}

function deleteCategory(categoryId) {
	  var doIt = confirm('Do you want to delete the Category?');
	  if(doIt) {
		  window.location.href = 'CategoryController?action=cat_delete&categoryId='+categoryId;
	  } else {
		//Nothing...
	  }
}

function deleteStore(storeId) {
	  var doIt = confirm('Do you want to delete the Store?');
	  if(doIt) {
		  window.location.href = 'StoreController?action=delete&storeId='+storeId;
	  } else {
		//Nothing...
	  }
}