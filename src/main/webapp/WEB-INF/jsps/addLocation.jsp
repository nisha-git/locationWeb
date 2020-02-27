<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>


<h2>Add Location</h2>
<form action="addLocation" method="post">
  <pre>   
           <input type="hidden" name="id" value="${location.id > 0?location.id:0}">
    Name : <input type="text" name="name" value="${location.name }">
    Code : <input type="text" name="code" value="${location.code }">
    Type : Urban ==><input type="radio" name="type" value="urban" ${location.type=='urban'?checked:''}>
           Rural ==><input type="radio" name="type" value="rural" ${location.type=='rural'?checked:''}>
             
        <input type="submit" value="Add Location">
    
  </pre>
</form>

<br/>

