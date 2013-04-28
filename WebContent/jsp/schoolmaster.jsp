	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>


<%
String insName =(String) session.getAttribute("name");


 %>


<script type="text/javascript" src="js/schoolmaster.js"></script>
<script type="text/javascript" src="dwr/interface/SchoolMasterDWR.js"></script>

<style type="text/css">
span.mandatory {
    color: #FF0000;
    display: inline;
}

			
.divDemoBody  {
                width: 60%;
                margin-left: auto;
                margin-right: auto;
                margin-top: 100px;
                }
            .divDemoBody p {
                font-size: 18px;
                line-height: 140%;
                padding-top: 12px;
                }
            .divDialogElements input {
                font-size: 18px;
                padding: 3px;
                height: 32px;
                width: 500px;
                }
            .divButton {
                padding-top: 12px;
                }
            .btn {
                /*width: 80px;*/
                margin-left: 5px;
                }
             #idAlertDialog {
                width: 450px;
                height: 185px;
                background-color: whitesmoke;
                }
             #idAlertDialog .btn {
                width: 70px;
                margin-bottom: 8px;
                margin-right: 15px;
                margin-top: 80px;
                float: right;
                }
             #idAlertDialog h3 {
                margin-left: 60px;
                margin-top:15px;
                }
             #idAlertDialog img {
                float: left;
                margin-left: 15px;
                margin-top: 15px;
                }
                #idConfirmDialog {
				width: 450px;
				height: 165px;
				background-color: whitesmoke;
				}
			 #idConfirmDialog .btn {
				width: 70px;
				margin-bottom: 8px;
				margin-right: 15px;
				margin-top: 80px;
				float: right;
				}
			 #idConfirmDialog h3 {
				margin-left: 60px;
				margin-top:15px;
				}
			 #idConfirmDialog img {
				float: left;
				margin-left: 15px;
				margin-top: 15px;
				}
</style>

</head>
<body>
<script type="text/javascript">
</script>


<!-- Static navbar -->
<div style="height:50px;"></div>
<div class="reg_mainCon">
  <form method="post" action="schoolmaster.action">
      <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Add School for <%=insName %></legend>
     <div style="padding:20px;">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><label  style="color:#000;"><b>School Name</b></label></td>
            <td><input  type="text" class="span4" name="sName" id="sName" /></td>
          </tr>  
          <tr>
          	<td><label style="color:#000;"><b>School Short Name</b></label></td>
            <td><input  type="text" class="span4" name="ssName" id="ssName"/></td>
        </tr>
        
        <tr>
          <td><label style="color:#000;"><b>Address</b></label></td>
           <td> <textarea class="span4" rows="3"  name="sAddress" id="sAddress"></textarea></td>
            </tr>
            <tr>
          <td><label style="color:#000;"><b>City</b></label></td>
           <td> <input  type="text" class="span4" name="sCity" id="sCity" /></td>
        </tr>
         <tr>
          <td><label style="color:#000;"><b>Country</b></label></td>
            <td><select class="span4" style="width:312px;"  name="sCountry"  id="sCountry" ><!--  onchange="changeCountry(this.value)" -->
               <option value="India"  selected="selected">India</option><option value="Indonesia">Indonesia</option>
                    </select>           
        </tr>        
		<tr>
          <td><label style="color:#000;"><b>State</b></label></td>
            <!-- <td><input  type="text" name="sState" id="sState" /></td> -->
            <td><select id="sState" class="span4" name="sState" style="width:55%;" >
            					<option value="-1" >Select</option>
                                 <option value="1" selected="selected">Andhra Pradesh</option>
                                <option value="2">Bihar</option>
                                <option value="3">Madya pradesh</option>
                            </select></td>
            </tr>     
        <tr>
          <td><label style="color:#000;"><b>Contact Person</b></label></td>
            <td><input  type="text" class="span4" name="sContPerson" id="sContPerson" /></td>
            </tr>
            <tr>
          <td><label style="color:#000;"><b>Email Id </b></label></td>
           <td> <input  type="text" class="span4"  name="sEmail" id="sEmail"/>
          </td>
        </tr>
        
        
        
		<tr>
          <td><label style="color:#000;"><b>Mobile</b></label></td>
            <td><input  type="text" class="span4" name="sMobile" id="sMobile"/></td>
            </tr>
            <tr>
          <td><label style="color:#000;"><b>Landline</b></label></td>
          <td>  <input  type="text" class="span4" name="sLandline" id="sLandline"/></td>
        </tr>
			<tr>
          <td colspan="2"><label style="color:#000;"><b>IsActive</b>&nbsp;&nbsp;&nbsp;&nbsp;
            <input  type="checkbox" class="span4" name="sIsActive" id="sIsActive" checked="checked"/></label>
          </td>
          </tr>
          <tr><td>&nbsp;</td></tr>
        <tr>
          <td><button type="button" class="btn" style="float:right;margin-right: 25px; " onclick="saveSchoolMasterAndGo(1);">Save</button></td>
            <td><button type="button" class="btn" onclick="saveSchoolMasterAndGo(2);" >Save and Add Branch</button></td>
        </tr>
      </table>
    </div>
    </fieldset>
  </form>
</div>

</body>
</html>




   <div id="idAlertDialog" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
            <img src="img/alert.gif" width="34" height="28" alt="alert icon">
            <h3 id="idAlertDialogPrompt"></h3>
            <a href="#" class="btn btn-primary" onclick="okAlertDialog ();">OK</a>
            </div>
            
            <div id="idConfirmDialog" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
			<img src="img/alert.gif" width="34" height="28" alt="confirm icon">
			<h3 id="idConfirmDialogPrompt"></h3>
			<a href="#" class="btn btn-primary" style="margin-top: 60px;" onclick="okConfirmDialog ();">Yes</a>
			<a href="#" class="btn" style="margin-top: 60px;"onclick="closeConfirmDialog ();">No</a>
			</div>