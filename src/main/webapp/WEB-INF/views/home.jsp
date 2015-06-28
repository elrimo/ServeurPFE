<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<script type="text/javascript"  src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Jquery Ajax Demo</title>
<style>
Table.GridOne {
	padding: 3px;
	margin: 0;
	background: lightyellow;
	border-collapse: collapse;	
	width:35%;
}
Table.GridOne Td {	
	padding:2px;
	border: 1px solid #ff9900;
	border-collapse: collapse;
}
</style>
<script type="text/javascript">
function madeAjaxCall(){
	$.ajax({
		 type: "POST",
		  url: "rest/addUser",
		  cache: false,		
		  data: JSON.stringify({ password: $("#password").val(), username: $("#username").val(), email: $("#email").val, role: "user"}) ,
		  contentType: 'application/json',
		  mimeType: 'application/json',
		    success: function(data) { 
		        alert(data.id + " " + data.name);
		    },
		    error:function(data,status,er) { 
		        alert("error: "+data+" status: "+status+" er:"+er);
		    }
		});
		
	
}
</script>
</head>
<body>
	<form name="employeeForm" method="post">	
		<table  border="1" class="GridOne">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" id="username" value=""></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" id="password" value=""></td>
			</tr>
			
			<tr>
				<td>email</td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="madeAjaxCall();"></td>
			</tr>
		</table>
	</form>
	 <h1>Spring Framework Jquery Ajax Demo</h1>
	<div id="result"></div>
</body>
</html>