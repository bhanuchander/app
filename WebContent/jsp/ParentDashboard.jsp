<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <script type="text/javascript">
		 jQuery(document).ready(function () {
				 resultPopUp();
				  schoolMasterList();
		});

		
		</script>
    
    
    
    <div class="reg_mainCon">
  <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Parents Dashboard</legend>
  <div style="padding:20px;">
    <div class="row-fluid">   
      <div class="span4">
        <div class="controls">
          <label><strong>Student ID</strong> : SCT 0213546</label>
          <label><strong>Name</strong> : Ravi Kumar</label>
          <label><strong>Date of Birth</strong> : 06-06-2000</label>
          <label><strong>Class </strong>:VI</label>
          <label><strong>Joined on</strong> :06-06-1990 </label>
        </div>
      </div>
      <!--/span-->
         <div class="span2" style="text-align:left;"> <img src="img/Student_SampleImg.jpg" width="176" height="180"class="img-rounded" style="border:1px #CCCCCC solid;"> </div>
    </div>
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Notification</h4>
          <div class="alert">No New Notification</div>
    		<table class="table table-bordered" width="100%">
              <tr>
                <th>From</th>
                <th>Sent On</th>
                <th>Subject</th>
                <th>Status</th>
                <th>View</th>
                <th>Delete</th>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><a href="#myModal" style="color:#666; text-decoration:none;" data-toggle="modal">Sample</a></td>
                <td>&nbsp;</td>
                <td><a href="#myModal" style="color:#666; text-decoration:none;" data-toggle="modal">Sample</a></td>
                <td>&nbsp;</td>
              </tr>              
            </table> 
          </div>
      </div>
      <!--/span-->
    </div>
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Assignments</h4>
          <div class="alert">No Assignments uploaded</div>
          <table class="table table-bordered" width="100%">
            <tr>
              <th>Date</th>
              <th>Assignment Type</th>
              <th>Subject</th>
              <th>View</th>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td><a href="#myModal" style="color:#666; text-decoration:none;"data-toggle="modal">Sample</a></td>
              <td><a href="#myModal" style="color:#666; text-decoration:none;"data-toggle="modal">Sample</a></td>     
            </tr>
          </table>
        </div>
      </div>
      <!--/span-->
    </div>
    <hr>
    <div class="row-fluid">
      <div class="span6">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px; min-height:223px;">
          <h4>Utilities</h4>
          <p>
          	<a href="#myModal_img" class="btn" data-toggle="modal" style="width:92%; text-align:center;"><i class="icon-calendar"></i> View Calendar</a>            <a href="#myModal_img" class="btn" data-toggle="modal" style="width:92%; text-align:center;"><i class="icon-calendar"></i> View Calendar</a>
            <a href="#myModal_img" class="btn" data-toggle="modal" style="width:92%; text-align:center;"><i class="icon-time"></i> View Timetable</a>
            <a href="#myModal_img" class="btn" data-toggle="modal" style="width:92%; text-align:center;"><i class="icon-list"></i> View Canteen Menu</a>
            <a href="#myModal_img" class="btn" data-toggle="modal" style="width:92%; text-align:center;"><i class="icon-eye-open"></i> View Circulars</a>
            <br>
          </p>
        </div>
      </div>
      <!--/span-->
      <div class="span6">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px; min-height:251px;">
          <h4>Send Quick Message</h4>
          <p style="margin-top:20px;"><span style="padding-top:5px; vertical-align: middle;"> TO :</span>
                <label class="checkbox inline">
                <input type="checkbox" id="inlineCheckbox1" value="option1">Admin
                </label>
                <label class="checkbox inline">
                <input type="checkbox" id="inlineCheckbox2" value="option2">Class Teacher         
                </label>
                <label class="checkbox inline">
                <input type="checkbox" id="inlineCheckbox3" value="option3">Principal
                </label>               
          </p>
          
           <textarea style="width:95%;" rows="3"></textarea>
           <p style="text-align:center;"><button class="btn btn-warning" type="button">Send</button> </p>          
        </div>
      </div>
      <!--/span-->
    </div>
    <hr>
    <div class="row-fluid">
      <div class="span6">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Edit Details</h4>
          <form class="form-inline">
            <p>
              <label style="width:102px;">Fathers Mobile</label>
              <input type="text" class="input-small" placeholder="">
              <label class="radio">
  				<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1">Default
              </label>
            </p>
            <p>
              <label style="width:102px;">Mothers Mobile</label>
              <input type="text" class="input-small" placeholder="">
              <label class="radio">
  				<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Default
              </label>
            </p>
            <p>
              <label style="width:102px;">Fathers Mail</label>
              <input type="text" class="input-small" placeholder="">
              <label class="radio">
  				<input type="radio" name="optionsRadios1" id="optionsRadios3" value="option3">Default
              </label>
            </p>
            <p>
              <label style="width:102px;">Mothers Mail</label>
              <input type="text" class="input-small" placeholder="">
              <label class="radio">
  				<input type="radio" name="optionsRadios1" id="optionsRadios4" value="option4">Default
              </label>
            </p>
             <p style="text-align:center;"><button class="btn btn-warning" type="button">Send</button> </p> 
          </form>
        </div>
      </div>
      <!--/span-->
      <div class="span6">
        <div style="padding:0px 10px; border:1px #CCCCCC solid;margin-bottom:10px;">
          <h4>Academics</h4>
          <div style="text-align:center;height:136px; padding-top:84px; font-size:30px;">Coming Soon</div>
        </div>
      </div>
      <!--/span-->
    </div>
  </div>
</div>