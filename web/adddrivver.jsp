<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="index.jsp">108 Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome Admin</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="showproccess.jsp"><i class="icon-check"></i> Proccess</a></li>
        <li class="divider"></li>
        <li><a href="index.jsp"><i class="icon-key"></i> Log Out</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="index.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>

<!--start-top-serch-->
<!--close-top-serch--> 

<!--sidebar-menu-->

<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-list"></i>Forms</a>
  <ul>
    <li><a href="Main.jsp"><i class="icon icon-home"></i> <span>Home</span></a> </li>
    <li><a href="ShowProcessCases.jsp"><i class="icon icon-signal"></i> <span>Current Cases</span></a> </li>
    <li><a href="History.jsp"><i class="icon icon-inbox"></i> <span>History</span></a> </li>
    <li class="submenu active"> <a href="#"><i class="icon icon-list"></i> <span>Driver</span> <span class="label label-important">2</span></a>
      <ul>
        <li><a href="adddrivver.jsp">Add Driver</a></li>
        <li><a href="View_Driver.jsp">View Driver</a></li>
      </ul>
    </li>
  </ul>
</div>

<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="home.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Driver</a> <a href="#" class="current">Add Driver</a> </div>
  <h1>Add Driver</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span12">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Driver Deatils</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="LoginServlet1" method="post" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">First Name :</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="First name" name="uname1" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Last Name :</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="Last name" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Mobile Number</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="Company name" name="mob1" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Date Of Birth</label>
              <div class="controls">
                <div  data-date="02-12-2012" class="input-append date datepicker">
                  <input type="text" value="01-02-2012"  data-date-format="dd-mm-yyyy" class="span11" name="age1">
                  <span class="add-on"><i class="icon-th"></i></span> </div>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Type</label>
              <div class="controls">
                <select name="type1">
                  <option>Ambulance</option>
                  <option>Fire</option>
                  <option>Police</option>
                </select>
              </div>
            </div>
              <div class="control-group">
              <label class="control-label">Gender</label>
              <div class="controls">
                <select name="sex1">
                  <option>Male</option>
                  <option>Female</option>
                  <option>Transgender</option>
                </select>
              </div>
            </div>
              
            <div class="control-group">
              <label class="control-label">Select a Image</label>
              <div class="controls">
                <input type="file" />
              </div>
            </div>
              <div class="control-group">
              <label class="control-label">Address</label>
              <div class="controls">
                <textarea class="span11" name="address1" ></textarea>
              </div>
            </div>
            <div class="form-actions">
              <center><input type="submit" value ="Add Driver" class="btn btn-success"/></center>
            </div>
          </form>
        </div>
      </div>
    </div>
    
  </div>
  
</div></div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part--> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.toggle.buttons.js"></script> 
<script src="js/masked.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_common.js"></script> 
<script src="js/wysihtml5-0.3.0.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/bootstrap-wysihtml5.js"></script> 
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>
