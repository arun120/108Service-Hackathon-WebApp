<%-- 
    Document   : home2
    Created on : 16 Nov, 2016, 5:54:33 PM
    Author     : antof
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
    .jumbotron {
    padding: 30px;
    margin-bottom: 30px;
    font-size: 16px;
}
</style>     
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">108_Services</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home.jsp" class="btn btn-info btn-lg">
              <span class="glyphicon glyphicon-home"></span>Home</a></li>
      <li>
           <a href="map.jsp" class="btn btn-info btn-lg">
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
      <form action="LoginServlet1" method="post">
          <br>Name:<input type="text" name="uname1" align="center" style="
    margin-left: 130px;
    line-height: normal;
">
          <br>Type:<select name="type1" style="
    margin-left: 138px;
" align ="center">
              <option></option>
              <option value="police">Police</option>
    <option value="ambulance">Ambulance</option>
    <option value="fire">Fire</option>
    
  </select>
          <br>Mobile:<input type="text" name="mob1" style="
    margin-left: 121px;
    line-height: normal;
">
          <br>Age:<input type="text" name="age1" style="
    margin-left: 143px;
    margin-top: 10px;
    line-height: normal;
">
          <br>Address:<input type="text" name="address1" style="
    margin-left: 103px;
    margin-top: 10px;
    line-height: normal;
">
          <br>Sex:<select name="sex1" style="margin-left: 144px;">
    <option value="male">Male</option>
    <option value="female">Female</option>
   
  </select>
          <br><input type="submit" value="Add Driver" align ="center">
      </form>
  </div>
       </div>
       </body>
</html>

