<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">

    <title>맛집 목록</title>
</head>
<body>
<h1>맛집 목록</h1>

<a href="/restaurant/new">➕ 맛집 등록</a>

<table border="1">
    <tr>
        <th>이름</th>
        <th>주소</th>
        <th>상세보기</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td>${restaurant.name}</td>
            <td>${restaurant.address}</td>
            <td><a href="/restaurant/detail/${restaurant.id}">보기</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>