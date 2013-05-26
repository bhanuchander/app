<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String data = request.getParameter("assAlldata");
String subData = request.getParameter("notifAlldata");
System.out.println(subData+"#-----#"+data);
 %>
 
   <script type="text/javascript">
   		 jQuery(document).ready(function () {
			  var datatemp = '<%=request.getParameter("assAlldata")%>';  //Assignments
			  var notiftemp = '<%=request.getParameter("notifAlldata")%>';  //Notifications
		   		 
	   		 if (datatemp == null || datatemp == "null" ) {
	   		 //NotifMainDiv-AssignMainDiv
				document.getElementById("AssignMainDiv").style.display='none';
			 	document.getElementById("NotifMainDiv").style.display='block';
				onloadNotiFication();
			} else {
				document.getElementById("AssignMainDiv").style.display='block';
	   		  	document.getElementById("NotifMainDiv").style.display='none';
			
				onloadAssign();
			}
			
		});
   
	function onloadNotiFication(){
			  var notiftemp = '<%=request.getParameter("notifAlldata")%>';  
			  var   notifData  = notiftemp.split("~^");
			 // alert(notifData.length+"***Notif Length");
			
					if ( notifData.length>0) {
								var newNtoficationGrid  	 = jQuery('#notificationDynamicTable');
								
								
							   	var newNotificationStr = '';     
				   						newNotificationStr += '<table class="table table-bordered" width="100%" style="margin-bottom:0px;">';
										newNotificationStr += '<tr><th width="15%">From</th><th width="16%">Sent On</th><th width="40%">Subject</th><th width="15%" style="text-align:center;">View</th></tr>';
					                           
				                           for(var i = 0; i < notifData.length; i++) {
				                           // notif_subject,notif_body,ondate
				                           var notifBodyID = i+"yy";
				                           var notifSubID 	=	i+"uu"; 
												var temp = notifData[i].split("*^");
												//alert(temp+"*****"+temp.length);
						 						newNotificationStr += '<tr>';
						 						/* var tempDate = new Date(temp[2]);
						 						alert(tempDate+temp[2]); (tempDate.getMonth() + 1) + '-' + tempDate.getDate() + '-' +  tempDate.getFullYear()*/
												newNotificationStr += '<td>Administrator</td><td>'+temp[2]+'</td><td><label style = "color:#666666;font-weight: bold; font-size: 12px;" id ="'+notifSubID+'" value="'+temp[0]+'">'+temp[0]+'</label ></td><td><a href="#myModal_1" id= "'+i+'"  value="yuyu" style="color:#666; text-decoration:none; padding-left:50px;" data-toggle="modal" onclick="openModelWithData(id);"><i class="icon-eye-open"></i> <input type="hidden" id='+notifBodyID+' value="'+temp[1]+'"></a></td>';
												newNotificationStr += '</tr> ';
											}
										newNotificationStr += '</table>'; 
					   		 newNtoficationGrid.html(newNotificationStr);  
					   		 
					   	
					   		 
					   		 document.getElementById("notificationDynamicTable").style.display='block';
					       document.getElementById("noNotification").style.display='none';
					       }else{
					       //noNotification			notificationDynamicTable	
					       document.getElementById("notificationDynamicTable").style.display='none';
					       document.getElementById("noNotification").style.display='block';

					       }
	
	}
		
			function openModelWithData(vall){
		var idref = '#'+vall;
		
		//notifSub
		
		var notifBodyID 	= '#'+vall+"yy";//for notif body
		var subNotifID 		= '#'+vall+"uu";//for sub 
		var bodyNotif 		= jQuery(notifBodyID).val();		
		var subNotif 			= $(subNotifID).attr('value');	
			
		var id = $(idref).attr('href');
		
		//alert(idref+"^^"+vall+"*QQQ*-----"+id+"**"+jQuery(notifBodyID).val()+"&&"+subNotif);
		/* $("#myModalLabel").html("For tesiiiii"); */
		$("#myModalLabel11").text(subNotif); 
		$("#bodyyID").text(bodyNotif); 

		}

	function onloadAssign(){
	
			  var datatemp = '<%=request.getParameter("assAlldata")%>';  
			  var   data  = datatemp.split("~");
			  
			   var subjectMasterListtemp = '<%=request.getParameter("assAllSubdata")%>';			   
			   var subjectMasterList =  subjectMasterListtemp.split("~");
			
			if(datatemp.length>0){
								var newAssignmentGrid  	 = jQuery('#assignmentDynamicTable');
							   	var newAssignmentStr = '';     
				   						newAssignmentStr += '<table class="table table-bordered" width="100%" style="margin-bottom:0px;">';
										newAssignmentStr += '<tr><th width="19%">Date</th><th width="20%">Assignment Type</th><th width="20%">Subject</th><th width="30%">Description</th><th width="12%" style="text-align:center;">View</th></tr>';
					                     
				                     for(var i = 0; i < data.length; i++) {
				                         
				                           // upload_date,assign_type ,					subject,assg_desc,file_name
				                           var assignTypeID 			= i+"asign_t";
				                           var assignSubjID 			= i+"asign_s";
			                           	   var assignDescID 			= i+"asign_d";
				                           var assignFileNameID 	=	i+"asign_f"; 
												var tempTemp = data[i];
												var temp = data[i].split('*');
						 						//here required subject wise split
						 						var subjectsSplit = temp[2].split(',');
						 						
						 						var subjectNAem = null;
						 						
						 						for ( var p = 0; p < subjectsSplit.length; p++) {//Subject wise.................................
						 					
													//alert(subjectsSplit[p]);//assume	2
													if (subjectsSplit[p] != 0) {
													
														//alert(subjectMasterList.length+"--->subjectMasterList.length");
													    for(var qq = 0; qq < subjectMasterList.length; qq++) {
													    
															    var tempS = subjectMasterList[qq].split("*");
															    	//alert(tempS+"%%"+tempS[0]+"##tempS##"+subjectsSplit[p]);
															    	//alert(subjectMasterList[qq]+"**masterSub"+tempS[0]+"^^"+tempS.length);
															    if (tempS[0] == subjectsSplit[p]) {
																	subjectNAem = tempS[1];
																	break;
																}	
															    	
															}
													newAssignmentStr += '<tr>';
							 						
													newAssignmentStr += '<td>'+temp[0]+'</td><td><label style = "color:#666666;font-weight: bold; font-size: 12px;" id ="'+assignTypeID+'" value="'+temp[1]+'">'+temp[1]+'</label ></td>';		//2										
													//	subject,	assg_desc,	file_name
													//here actually not doing anything with subject name.....
													newAssignmentStr += '<td><label style = "color:#666666;font-weight: bold; font-size: 12px;" id ="'+assignSubjID+'" value="'+temp[2]+'">'+subjectNAem+'</label ></td>';
	/* 												newAssignmentStr += '<td><label style = "color:#666666;font-weight: bold; font-size: 12px;" id ="'+assignSubjID+'" value="'+temp[2]+'">'+temp[2]+'</label ></td>'; */
													
													newAssignmentStr += '<td><label style = "color:#666666;font-weight: bold; font-size: 12px;" id ="'+assignDescID+'" value="'+temp[3]+'">'+temp[3]+'</label >	</td>';
													
													newAssignmentStr += '<td><a href="#myModal_3" id= "'+i+'"  value="yuyu" style="color:#666; text-decoration:none; padding-left:26px;" data-toggle="modal" onclick="openModelWithAssignmentData(id);"><i class="icon-eye-open"></i> <input type="hidden" id='+assignFileNameID+' value="'+temp[4]+'"></a></td>';
													
													newAssignmentStr += '</tr> ';	
															
														}
													//here based on this thid get subject name from above method
												}
						 				
											}
								newAssignmentStr += '</table>'; 
					   		 newAssignmentGrid.html(newAssignmentStr);  
					   		 
					   		 //var hhhhr = "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\Schooltrix\First.html";
					   		// newAssignmentAllGrid.html('<form method="post" id="allForm1" action="ViewAllListParent.action"><a href="#" id= "66"  value="yuyu" style="color:#666; text-decoration:none; padding-left:26px;" data-toggle="modal" onclick="nextPageView()"><i class="icon-eye-open"></i><input type="hidden" id="assAlldata" name="assAlldata"  value="'+data+'">View1 All</a></form>');
					   		 
					   		 
					   		 
					   		 document.getElementById("assignmentDynamicTable").style.display='block';
					       document.getElementById("noAssignments").style.display='none';
					       }else{
					       //noNotification			notificationDynamicTable	
					       document.getElementById("assignmentDynamicTable").style.display='none';
					       document.getElementById("noAssignments").style.display='block';

					       }
		}
						
		function openModelWithAssignmentData(vall){

			var assignTypeID 	= '#'+vall+"asign_t";//for notif body
			var assignSubjID 	= '#'+vall+"asign_s";//for notif body
			var assignDescID 		= '#'+vall+"asign_d";//for sub 
			var assignFileNameID 		= '#'+vall+"asign_f";//for sub 
			
			var assignFileName 		= jQuery(assignFileNameID).val();		//text || hidden field value
			var assignDesc 			= $(assignDescID).attr('value');	//fetch lable value
				
			//var assignFileWithMsg ='      to download the  '+assignDesc;//sir said not req file desc here..
			var assignFileWithMsg ='      to download the  assignment';
			//	<a href="#">Click here</a> to download the Holiday Home work for Summer Vacation 2013
				
		/* 		var p = document.getElementById('assignBodyID');
				if (p != null) {
					
				p.parentNode.removeChild(p);
				} */
				
				
			 //Get the element that we want to append to
	         var divEl = document.getElementById('assignBodyID');
	     //    alert(divEl);
	        document.getElementById('assignBodyID').innerHTML = "";
	         //divEl.text('');
	         
	        //Create the new <a>
	        var aElem = document.createElement('a');
	       // aElem.href="javascript:Tesssst();";
	        aElem.href="downloadUploadDoc.action?type=Assignment&fileName="+assignFileName;
	       // aElem.href="http://www.google.com";
	       
	       
	        //Create a text node to hold the text of the <a>
	        var aElemTN = document.createTextNode('Click here');
	        //Append the <a> text node to the <a> element
		        aElem.appendChild(aElemTN);
		        //Append the new link to the existing <div>
		        divEl.appendChild(aElem);
				
				$("#myModalLabelAssign").text(assignDesc); 
				//$("#assignBodyID").text(assignFileWithMsg); 
				$("#assignBodyID1").text(assignFileWithMsg); 

		}
</script>
 <div class="reg_mainCon">
  <div style="padding:20px;">
  
 <div class="row-fluid" id="AssignMainDiv">						<!--Assignment Start-->
      <div class="span12">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Assignments</h4>          
          <div id="noAssignments" class="alert">No new Assignments</div>
           <div id="assignmentDynamicTable"></div>          
        </div>
      </div>
      <!--/span-->
    </div>		<!--Assignment End-->
    
    <div class="row-fluid" id="NotifMainDiv">						<!--Notification Start-->
      <div class="span12">      
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Notification</h4>          
          <div id="noNotification" class="alert" >No New Notification</div>
          <div id="notificationDynamicTable"></div>
        </div>        
      </div>
      <!--/span-->
    </div>														<!--Notification End-->
    
    	
    </div>
   <!--  <div><span class='icon-arrow-up'></span></div> -->
    <div><button class="btn btn-mini btn-primary" type="button" onclick="history.go(-1);return false;" >&nbsp;<span class='icon-arrow-left'></span>&nbsp;&nbsp;Back&nbsp;&nbsp;&nbsp;</button></div> 
    </div>
    
	<!-- AssignMenet Modal-1 -->
	<div id="myModal_3" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabelAssign">Holiday Homework</h3>
	  </div>
	  <div class="modal-body">
		<p id="assignBodyID" style="display:inline"></p>&nbsp;&nbsp;<p id="assignBodyID1" style="display:inline"></p>
	<!-- 	<p id="assignBodyID"><a href="#">Click here</a> to download the Holiday Home work for Summer Vacation 2013</p> -->
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	  </div>
	</div>
	<!-- AssignMenet Modal-1 End-->
	
		<!-- Notification Modal-1 -->
	<div id="myModal_1" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel11"></h3>
	  </div>
	  <div class="modal-body">
	    <p id="bodyyID"></p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	  </div>
	</div>
	<!-- Notification Modal-1 End-->