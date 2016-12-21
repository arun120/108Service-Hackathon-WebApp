<%-- 
    Document   : home1
    Created on : 16 Nov, 2016, 5:36:18 PM
    Author     : antof
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 
         <script src="jquery.min.js"></script>
 <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDmpIyxCnOqXMfcl4mi-iZub0XQlgjkTgY&sensor=false&libraries=places"></script>
<script type="text/javascript">
var source, destination;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
google.maps.event.addDomListener(window, 'load', function () {
//    new google.maps.places.SearchBox(document.getElementById('txtSource'));
//    new google.maps.places.SearchBox(document.getElementById('txtDestination'));
    directionsDisplay = new google.maps.DirectionsRenderer({ 'draggable': true });
});
 
function GetRoute() {
    var chennai = new google.maps.LatLng(13.0827,80.2707);
    var mapOptions = {
        zoom: 7,
        center: chennai
    };
    map = new google.maps.Map(document.getElementById('dvMap'), mapOptions);
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById('dvPanel'));
 
    //*********DIRECTIONS AND ROUTE**********************//
//    source = document.getElementById("txtSource").value;
//    destination = document.getElementById("txtDestination").value;


        
       
    
 
    var request = {
        origin: "13.0551,80.2221",
        destination:"13.0551,80.2221",
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function (response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
 
 
}
</script>
    </head>
    <body>
     <nav class="navbar navbar-inverse navbar-fixed-top">
  
            <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">108_Services</a>
    </div>
    <ul class="nav navbar-nav">
        <li class="active">
            <a href="home.jsp" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-home"></span> Home
        
    </a>
        </li>
        <li>
           <a href="map.jsp" class="btn btn-info btn-lg" >
          <span class="glyphicon glyphicon-globe"></span> View map
        </a>
      </li>
      <li><a href="home2.jsp">Add Driver</a></li> 
      <li><a href="home3.jsp">Status</a></li> 
    </ul>
  </div>
</nav>
        <div class="container">
  <div class="jumbotron" style=" border: 1px solid black;">
        <table border="0" cellpadding="0" cellspacing="3">
<tr>
    
    <td colspan="2">
      
        <input type="button" value="Show status" onclick="GetRoute()" />
        <hr />
    </td>
</tr>
<tr>
    <td colspan="2">
        <div id="dvDistance">
        </div>
    </td>
</tr>
<tr>
    <td>
        <div id="dvMap" style="width: 500px; height: 500px">
        </div>
    </td>
   
</tr>
</table>
  </div>
        </div>
    </body>
</html>