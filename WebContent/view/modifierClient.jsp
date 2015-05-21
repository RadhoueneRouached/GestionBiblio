<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bibilothèque | Modifier client</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,300,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/foundation.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/foundation-datepicker.css" />
<script
	src="${pageContext.request.contextPath}/resources/js/vendor/modernizr.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="top-bar" data-topbar role="navigation">
		<ul class="title-area">
			<li class="name">
				<h1>
					<a href="#">Bibliothèque</a>
				</h1>
			</li>
			<!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
			<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
		</ul>

		<section class="top-bar-section">
			<!-- Right Nav Section -->
			<ul class="right">
				<li class="divider"></li>
				<li><a href="#">Livres</a></li>
			</ul>
		</section>
	</nav>

	<div class="row large-12">
		<div class="large-12">
			<h3>Modifier client</h3>
		</div>
		<div class="large-6">
			<form:form method="post" action="${pageContext.request.contextPath}/edit/${idClient}" modelAttribute="client"> 
				<div class="row">
					<div class="large-12 columns">
						<label>Id client <form:input path="idClient" type="text" disabled="true"/>
						</label>
					</div>
				</div><div class="row">
					<div class="large-12 columns">
						<label>Nom et prénom <form:input path="nomPrenom" type="text" />
						</label>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<input type="submit" value="Modifier" class="button tiny">
					</div>
				</div>
			</form:form>
		</div>
		<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/resources/js/vendor/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/foundation.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/foundation.datepicker.js"></script>
<script>
	$(document).foundation();
	$('#dp1').fdatepicker({
		format: 'dd-mm-yyyy'
	});
</script>
</html>