<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>抱歉</title>
</head>
<body>
error！<br/>
${requestScope.user.userName}<br/>
${requestScope.book.bookName}<br/>
<hr><br/>
${requestScope.allUser}
${requestScope.allBook}
</body>
</html>