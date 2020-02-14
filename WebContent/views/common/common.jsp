<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>

<%--JS--%>
<script src="${contextPath}/js/jquery/jquery-2.1.4.js"></script>

<link type="image/x-icon" href="${contextPath}/images/ixoye.jpg" rel="icon">
