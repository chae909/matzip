<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">

    <title>맛집 등록</title></head>
<body>
<h1>맛집 등록</h1>
<form action="/restaurant" method="post">
    이름: <input type="text" name="name"><br/>
    주소: <input type="text" name="address"><br/>

    <h3>메뉴</h3>
    <div>
        <input type="text" name="menus[0].name" placeholder="대표메뉴">
        <input type="number" name="menus[0].price" placeholder="가격">
    </div>
    <div>
        <input type="text" name="menus[1].name" placeholder="사이드메뉴">
        <input type="number" name="menus[1].price" placeholder="가격">
    </div>

    <button type="submit">등록</button>
</form>

<a href="/restaurants">← 목록으로</a>
</body>
</html>