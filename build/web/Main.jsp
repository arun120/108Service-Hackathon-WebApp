<%@page import="Database.Dbdetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link rel="stylesheet" href="css/select2.css" />

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

       <script>
           var map;
      function addMarker(lat,lng){
          
            myCenter = new google.maps.LatLng(lat,lng);
             marker= new google.maps.Marker({position:myCenter});
             marker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png');
             marker.setMap(map);
          
          
      }
        function myMap()
        {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        console.log(document.getElementById('map'));
         map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: {lat: 13.0827, lng: 80.2707}
        });
        directionsDisplay.setMap(map);
           var myRepeater;
        

            
            <% 
            Connection con;
            Statement stmt;
            ResultSet rs,rs1;
            
            con = new Dbdetails().getConnection();
            stmt = con.createStatement();
            String a="",b="Processing",query = "SELECT a.CASE_ID,a.LATITUDE,a.LONGITUDE,b.CASE_ID,b.DRIVER_ID,c.DRIVER_ID,c.LATITUDE,c.LONGITUDE,d.CASE_ID,d.STATUS FROM CUSTOMER_CASE a,CASE_LINK b,DRIVER_LOCATION c,CASE_LOG d WHERE a.CASE_ID = b.CASE_ID AND a.CASE_ID = d.CASE_ID AND b.DRIVER_ID = c.DRIVER_ID";
            rs = stmt.executeQuery(query);
            int i=0;
            while(rs.next())
            {
                if(b.equals(rs.getString("d.STATUS")))
                {
                   i++;
                    a+= rs.getString("a.LATITUDE")+":"+rs.getString("a.LONGITUDE")+":"+rs.getString("c.LATITUDE")+":"+rs.getString("c.LONGITUDE")+":";
             
                %>
            
                 custlat<%=i%>=<%=rs.getString("a.LATITUDE")%>;
                 custlon<%=i%>=<%=rs.getString("a.LONGITUDE")%>;
                 drilat<%=i%>=<%=rs.getString("c.LATITUDE")%>;
                drilon<%=i%>=<%=rs.getString("c.LONGITUDE")%>;
                driverid<%=i%>=<%=rs.getString("c.DRIVER_ID")%>;
                
            myCenter<%=i%> = new google.maps.LatLng(custlat<%=i%>,custlon<%=i%>);
             marker<%=i%> = new google.maps.Marker({position:myCenter<%=i%>});
             marker<%=i%>.setMap(map);
             myCenter<%=i%> = new google.maps.LatLng(12.9532,80.1416);
           google.maps.event.addListener(marker<%=i%>, 'click',function(){
               
                  calculateAndDisplayRoute<%=i%>(directionsService, directionsDisplay);
                    clearInterval(myRepeater);
                    myRepeater=setInterval(function(){    calculateAndDisplayRoute<%=i%>(directionsService, directionsDisplay);},1000);
               
           });
            function calculateAndDisplayRoute<%=i%>(directionsService, directionsDisplay) {
                //ajax call
                var alat<%=i%>,alon<%=i%>;
                $.post('DriverLocation',{
                    driverid:driverid<%=i%> 
                },function(response){
                    var a=response.split(":");
                   
                    alat<%=i%>=parseFloat(a[0]);
                    alon<%=i%>=parseFloat(a[1]);
                   // console.log(alon<%=i%>);
            directionsService.route({
            origin: {lat:custlat<%=i%>,lng:custlon<%=i%>},
            destination:{lat:alat<%=i%>,lng:alon<%=i%>},
            travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
              console.log("<%=i%>");
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
        
                });
    }
            
            <%
                
                }
            }     
           // out.println(a);
            

%>
        
//        var c = b.split(":");


         }
     
                
        
             
           
                  
         
         
         </script>
         
         


</head>

<body>  <!--Header-part-->
    
                <div id="map" style="position: absolute;z-index: 50;left:250px;top:325px;width:60%;height: 35%;">
                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDaFex4-AjPI57E4c3WsWZuyAOStCN-9GI&callback=myMap"></script>
              
</div>
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
 <ul>
    <li class ="active"><a href="Main.jsp"><i class="icon icon-home"></i> <span>Home</span></a> </li>
    <li><a href="ShowProcessCases.jsp"><i class="icon icon-signal"></i> <span>Current Cases</span></a> </li>
    <li><a href="History.jsp"><i class="icon icon-inbox"></i> <span>History</span></a> </li>
    <li class="submenu"> <a href="#"><i class="icon icon-list"></i> <span>Driver</span> <span class="label label-important">2</span></a>
       <ul>
        <li><a href="adddrivver.jsp">Add Driver</a></li>
        <li><a href="View_Driver.jsp">View Driver</a></li>
      </ul>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="Main.jsp"> <i class="icon-dashboard"></i> <span class="label label-important">20</span> Home </a> </li>
        <li class="bg_lg span3"> <a href="ShowProcessCases.jsp"> <i class="icon-signal"></i> Current Cases</a> </li>
        <li class="bg_ly"> <a href="History.jsp"> <i class="icon-inbox"></i><span class="label label-success">101</span> History </a> </li>
         <li class="submenu active"> <a href="#"><i class="icon icon-list"></i> <span>Driver</span> <span class="label label-important">2</span></a>
      <ul>
        <li><a href="adddrivver.jsp">Add Driver</a></li>
        <li><a href="View_Driver.jsp">View Driver</a></li>
      </ul>
    </li>
       

      </ul>
    </div>
<!--End-Action boxes-->    
<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Site Analytics</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span9">
              
            </div>
            <div class="span3">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong>2540</strong> <small>Total Users</small></li>
                <li class="bg_lh"><i class="icon-plus"></i> <strong>120</strong> <small>New Users </small></li>

                
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    
     <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Current case</h5>
        </div>
          <form action="#">
                      <div class="control-group">
              <label class="control-label">Mobile Number</label>
              <div class="controls">

          <input type="text" name="search">
              </div></div>
                   <input type="submit" value ="Submit"/>
               
          </form>
          
          
   
    <%
        if(request.getParameter("search")!=null){
            String mobile=request.getParameter("search");
    String query1 ="SELECT * FROM CUSTOMER_CASE a,Customer_details b where a.cust_id=b.cust_id and mobile like '"+mobile+"'";
    rs = stmt.executeQuery(query1);
    rs.afterLast();
    if(rs.previous()){
    %>
          <div class="control-group">
              <label class="control-label"></label>
              <div class="controls">
                  
                <%= "Case Id:"+rs.getString("case_id")+"<br> Type:"+rs.getString("type")+"<br> No of people affected:"+rs.getString("no_ppl_affected")+"<br>Description:"+rs.getString("description")%>
                <input type ="text" value ='<%=rs.getString("description")%>' />
                <form action="#">
                <select>
                    <option>Reject</option>
                    <option>Nuisance Case</option>
                    <option>Already registered</option>
                </select>
                    <input type="submit" value ="submit"/>
                </form>
 <br>
              </div>
       </div>
<%
}else{
%>
    Number Not Found
          <%
}
}
%>
          </div>
        </div>
      </div>
    </div>
<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>

<!--end-Footer-part-->

<!-- Script For Map Starts Here-->
<!--         <script src="jquery.min.js"></script>-->
<!-- Script For Map Ends Here-->



<script src="js/excanvas.min.js"></script> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/fullcalendar.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/jquery.gritter.min.js"></script> 
<script src="js/matrix.interface.js"></script> 
<script src="js/matrix.chat.js"></script> 
<script src="js/jquery.validate.js"></script> 
<script src="js/matrix.form_validation.js"></script> 
<script src="js/jquery.wizard.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.popover.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.tables.js"></script> 

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>


</body>
</html>
