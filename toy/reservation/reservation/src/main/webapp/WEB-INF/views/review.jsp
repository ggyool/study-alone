<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link rel="shortcut icon" href="/resources/img/favicon.ico">
    <link href="/resources/css/style.css" rel="stylesheet">

</head>

<body> 
    <div id="container">
		<!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
		<div class="header fade">
			<header class="header_tit">
				<h1 class="logo">
					<a href="#" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
					<a href="#" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				</h1>
				  <a href="#" class="btn_my"> <span title="예약확인">예약확인</span> </a>
			</header>
		</div>
        <div class="ct">
            <div class="wrap_review_list">
                <div class="review_header">
                    <div class="top_title gr">
                        <a class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                        <h2><a class="title">${productDescription}</a></h2>
                    </div>
                </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area"> <span class="graph_mask"> <em class="graph_value" style="width: ${scorePercent}%;"></em> </span> <strong class="text_value"> <span>${averageScore}</span> <em class="total">5.0</em> </strong> <span class="join_count"><em class="green">${fn:length(commentList)}건</em> 등록</span></div>
                            <ul class="list_short_review">
                            	<c:forEach var="comment" items="${commentList}">
                            		<li class="list_item">
	                                    <div>
	                                        <c:choose>
												<c:when test="${not empty comment.commentImages}">
													<div class="review_area">
				                                    	<div class="thumb_area">
				                                        	<a class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/${comment.commentImages[0].saveFileName}"> </a> 
				                                            	<span class="img_count">1</span>
				                                        </div>
												</c:when>
												<c:otherwise>
													<div class="review_area no_img">
												</c:otherwise>
											</c:choose>
	                                            <p class="review">${comment.comment}</p><c:out value="${value}"/>
	                                        </div>
	                                        <div class="info_area">
	                                            <div class="review_info"> <span class="grade">${comment.score}</span> 
	                                            <span class="name">${fn:substring(comment.reservationEmail,0,4)}****</span> <span class="date">${fn:split(comment.reservationDate,' ')[0]} 방문</span> </div>
	                                        </div>
	                                    </div>
	                                </li>
                            	</c:forEach>
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                </div>
            </div>
        </div>
        <hr> </div>
		<footer>
	        <div class="gototop">
	            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
	        </div>
	        <div id="footer" class="footer">
	            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
	            <span class="copyright">© NAVER Corp.</span>
	        </div>
	    </footer>
	    <script src="/resources/js/review.js"></script>
</body>

</html>
