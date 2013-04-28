	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
    	<!-- css -->
	    <link href="css/bootstrap-fileupload.css" rel="stylesheet" media="screen">	   
    	<link href="css/datepicker.css"  rel="stylesheet" type="text/css" media="screen"  >
 	  
      <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
     </script>
         <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    
    	<!-- javascripts -->
	    <script src="js/bootstrap-fileupload.js" type="text/javascript"></script>
	    <script src="js/bootstrap-datepicker.js"> </script>
    	<script  src="js/bootstrap-datetimepicker.pt-BR.js"> </script>
    	
    	<!-- DWR calls -->
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/UserMasterDWR.js"></script>

	    <script>
	    var userTypes;
	/*    function addUser(){
				var  fileUP = 	jQuery("#fileUP").val();
				alert("fileUP---"+fileUP);
				var image = dwr.util.getValue("fileUP");
				dwr.util.setValue("fileUP", null);
	
				//Process DWR/AJAX request here
				try{
				alert("in alrttt--save user---"+fileUP+":image:"+image);
				       UserMasterDWR.addUserTest(image,fileUP, function(data){
					                                   if (data ==null) {														
					                                  			alert("save::"+data);
														} else {
						                               		    alert("exception::"+data);
														}
					                                   alert("data::"+data);
					                                   }
					                              ) ;    
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     }
	    alert("hiii");
	   }*/
	   
	      function addUser(){
				var  fileUP = 	jQuery("#fileUP").val();
				var path='<%=request.getContextPath()%>'+'/'+ 'adduserForm.action';
				alert("fileUP---"+fileUP+":::"+path);
				try{
				alert("in alrttt--save user---"+fileUP);
				       UserMasterDWR.addUserTest(fileUP, function(data){
					                                   if (data ==null) {														
					                                  			alert("save::"+data);
														} else {
						                               		    alert("exception::"+data);
						                               		    document.location =path;
														}
					                                   alert("data::"+data);
					                                   }
					                              ) ;    
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     }
	    alert("hiii");
	   }
	    </script>
	    
 <form>
<table>
	<tr>
          <td width="20%" ><label style="color:#000;"><b>Photo</b></label></td>
          <td>
          	<div class="fileupload fileupload-new" data-provides="fileupload">
				  <div class="input-append">
				    <div class="uneditable-input span2"><i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span></div><span class="btn btn-file">
				    <span class="fileupload-new">Select file</span><span class="fileupload-exists">Change</span>
				    <input type="file" name="fileUP" id ="fileUP"/></span><a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
				  </div>
			</div></td></tr>
        <tr>
          	<td >&nbsp;</td>   
            <td colspan="4">       	
            <button type="button" class="btn" onclick="addUser();">Save changes</button>
            <button type="button" class="btn">Cancel</button></td>
        </tr>
        
        
      </table>

   
  </form>





