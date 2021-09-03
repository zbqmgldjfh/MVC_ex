<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보 삭제 </h3>
	
	${error}
	
	<form action="memberDelete.do" method="POST">
		ID : <input type="text" name="id" />
		<input type="hidden" name="job" value="Delete" />
		<input type="submit" value="삭제" />
	</form>

</body>
</html>