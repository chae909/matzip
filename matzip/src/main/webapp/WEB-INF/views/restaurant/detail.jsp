<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">

    <title>맛집 상세 정보</title></head>
<body>
<h1>${restaurant.name}</h1>
<p>주소: ${restaurant.address}</p>

<h2>📋 메뉴</h2>
<ul>
    <c:forEach var="menu" items="${restaurant.menus}">
        <li>${menu.name} - ${menu.price}원</li>
    </c:forEach>
</ul>

<h2>📝 리뷰</h2>
<ul>
    <c:forEach var="review" items="${reviews}">
        <li>
                ${review.content} (${review.score}점)
            <a href="/review/edit/${review.id}" class="btn btn-sm btn-warning">✏️ 수정</a>
            <form action="/review/delete/${review.id}" method="post" style="display:inline;">
                <input type="hidden" name="restaurant_id" value="${restaurant.id}">
                <button type="submit" class="review-btn-mini"
                        onclick="return confirm('정말 삭제하시겠습니까?')">🗑️ 삭제</button>
            </form>
        </li>
    </c:forEach>
</ul>


<form action="/review/add" method="post">
    <input type="hidden" name="restaurant_id" value="${restaurant.id}">
    <textarea name="content" placeholder="리뷰를 작성하세요"></textarea><br/>
    별점 <input type="number" name="score" min="0" max="5" step="0.5"><br/>
    <button type="submit">리뷰 작성</button>
</form><br/>

<a href="/review/edit/${restaurant.id}">✏️ 맛집수정</a><br/>
<form action="/restaurant/${restaurant.id}/delete" method="post" style="display:inline;">
    <input type="hidden" name="_method" value="DELETE">
    <br/><button type="submit" onclick="return confirm('정말 삭제하시겠습니까?')">🗑️ 삭제</button>
</form>
<br/><br/>
<a href="/restaurants">← 목록으로</a>
</body>
</html>