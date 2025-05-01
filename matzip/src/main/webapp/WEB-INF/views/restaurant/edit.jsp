<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">

    <title>맛집 수정</title>
</head>
<body>
<h1>맛집 수정</h1>

<form action="/restaurant/${restaurant.id}" method="post">
    <!-- PUT 요청을 흉내내기 위한 hidden input -->
    <input type="hidden" name="_method" value="put"/>

    이름: <input type="text" name="name" value="${restaurant.name}"><br/>
    주소: <input type="text" name="address" value="${restaurant.address}"><br/>

    <button type="submit">수정</button>
</form>

<a href="/restaurant/detail/${restaurant.id}">← 상세 페이지로</a>
</body>
</html>