<%@page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<html>
<head><title>出现错误</title></head>
<body>
     <H1>错误：</H1><%=exception%>
 <H2>错误内容：</H2>
     <%exception.printStackTrace(response.getWriter());%></body>
</html>