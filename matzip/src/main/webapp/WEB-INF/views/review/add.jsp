<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">

    <title>리뷰 작성</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>리뷰 작성</h2>
    <form action="/review/add" method="post">
        <input type="hidden" name="restaurant_id" value="${restaurant_id}" />
        <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" id="content" name="content" rows="4" required></textarea>
        </div>
        <div class="mb-3">
            <label for="score" class="form-label">평점 (1~5)</label>
            <input type="number" class="form-control" id="score" name="score" min="1" max="5" required>
        </div>
        <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>
</body>
</html>