<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <title>리뷰 수정</title>
</head>
<body>
<div class="container">
    <h1>리뷰 수정</h1>
    <form action="${pageContext.request.contextPath}/review/edit" method="post">
        <input type="hidden" name="id" value="${review.id}" />
        <input type="hidden" name="restaurant_id" value="${review.restaurant_id}" />
        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="4" required>${review.content}</textarea>
        </div>
        <div class="form-group">
            <label for="score">평점 (1~5)</label>
            <input type="number" id="score" name="score" min="1" max="5" value="${review.score}" required>
        </div>
        <button type="submit">수정</button>
    </form>

    <a href="/restaurant/detail/${review.restaurant_id}">← 상세 페이지로</a>
</div>
</body>
</html>
