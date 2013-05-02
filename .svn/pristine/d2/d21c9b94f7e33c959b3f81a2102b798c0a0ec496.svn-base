// code for alert box
function okAlertDialog () {
	$("#idAlertDialog").modal ('hide'); 
	};
function alertDialog (prompt) {
	document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
	$("#idAlertDialog").modal ("show");
	}
// code for confirm box
var confirmDialogCallback;

function closeConfirmDialog () {
	$("#idConfirmDialog").modal ('hide'); 
	return false;
	};
function okConfirmDialog () {
	$("#idConfirmDialog").modal ('hide'); 
	save(flag1);
	};
function confirmDialog (prompt, callback) {
	document.getElementById ("idConfirmDialogPrompt").innerHTML = prompt;
	confirmDialogCallback = callback;
	$("#idConfirmDialog").modal ("show");
	}
function save(flag){
	
	var  sName 	= jQuery("#sName").val();
	var  ssName 	= jQuery("#ssName").val();
	var  sAddress 	= jQuery("#sAddress").val();
	var  sCity 	= jQuery("#sCity").val();
	var  sState 	= jQuery("#sState").val();
	var  sCountry 	= jQuery("#sCountry").val();
	var  sContPerson 	= jQuery("#sContPerson").val();
	var  sEmail 	= jQuery("#sEmail").val();
	var  sMobile 		= jQuery("#sMobile").val();
	var  sLandline 	= jQuery("#sLandline").val();
	var  sIsActive;
	 if ($('#sIsActive').is(":checked"))
	{
				sIsActive='Y';
	} else{sIsActive='N';}
	try{
	        SchoolMasterDWR.saveSchoolMaster(
		                                   sName,
		                                   ssName,
		                                   sAddress,
		                                   sCity,
		                                   sState,
		                                   sCountry,
		                                   sContPerson,
		                                   sEmail,
		                                   sMobile,
		                                   sLandline,
		                                   sIsActive,
		                                   function(data){
		                                   if (data =='saved') {
											if(flag == 2){
		                                       document.location ="Access.action?p1=branchMaster";
		                                       }else if(flag ==1){
		                                       alertDialog("School Name Added:"+sName);		                                       
		                                     }
		                                       
											}else {
			                                   alert("exception::"+data);

											}
			                             }) ;    
		 }catch(e){
		 alert("incatch::"+e);
	     } 		


}
function validateSchoolMasterForm(){
	var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
	var patName		=/^[0-9a-zA-Z-. ]{2,25}$/;
	var patAddress		=/^[a-zA-Z0-9-.,~!@#$%^&*()_+:"? ]{2,25}$/;
	var num			= /^[0-9-+ ]{8,20}$/;	
	var scNmae = "/^([a-zA-Z]+\s)*[a-zA-Z]*['. ]?[ ]?([a-zA-Z]+[.]?\s?)*[a-zA-Z]+$/";//later change
	var sm_sname			= document.getElementById("sName").value.match(scNmae);
	var sm_ssname			= document.getElementById("ssName").value.match(patName);
	var sm_address			= document.getElementById("sAddress").value.match(patAddress);
	var sm_city				= document.getElementById("sCity").value.match(patName);
	var sm_country			= document.getElementById("sCountry").value.match(patName);
	var sm_state			= document.getElementById("sState").value;
	var sm_cperson			= document.getElementById("sContPerson").value.match(patName);
	var sm_email			= document.getElementById("sEmail").value.match(patEmail);
	var sm_mobile			= document.getElementById("sMobile").value.match(num);
	var sm_landline			= document.getElementById("sLandline").value.match(num);
		if(!sm_sname){
			alertDialog('Please enter valid school name');
			return false;
		}if(!sm_ssname){
			alertDialog('Enter valid school short name');
			return false;
		}/*if(!sm_address){
			alertDialog('Please enter valid address');
			return false;
		}*/if(!sm_city){
			alertDialog('Please enter valid city');
			return false;
		}if(sm_state=="-1"){
			alertDialog('Please select valid state');
			return false;
		}if(!sm_country){
			alertDialog('Please enter valid country');
			return false;
		}if(!sm_cperson){
			alertDialog('Please enter valid contact name');
			return false;
		}if(!sm_email){
			alertDialog('Please enter valid email id');
			return false;
		}if(!sm_mobile){
			alertDialog('Please enter valid mobile number');
			return false;
		}if(!sm_landline){
			alertDialog('Please enter valid landline number');
			return false;
		}	


}

var flag1=1;
function saveSchoolMasterAndGo(flag){
	//var retrnvalue=validateSchoolMasterForm();
	var retrnvalue=true;
	if(retrnvalue == "false" || retrnvalue == false)
	{
	return false; 
	}
	flag1=flag;
	confirmDialog ('Would you like to save?', alert);
	
	}