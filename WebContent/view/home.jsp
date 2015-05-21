<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bibilothèque | Bonjour</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,300,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/foundation.css" />
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
			<h3>Liste des adherents</h3>
		</div>
		<div class="large-12">
			<a href="${pageContext.request.contextPath}/new" class="button tiny" data-tooltip title="Ajouter un nouveau adherent"><i class="fa fa-plus"></i> Ajouter nouveau</a>
		</div>
		<c:if test="${showmsg}">
			<div class="large-12">
				<div data-alert class="alert-box success radius">
				  ${message}
				  <a href="#" class="close">&times;</a>
				</div>
			</div>
		</c:if>
		<div class="large-12">
			<table class="large-12">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nom et prénom</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty adherents}">
							<tr>
								<td colspan="6" align="center">pas de adherents</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="adherent" items="${adherents}">
								<tr>
									<td>${adherent.id_adherent}</td>
									<td>${adherent.nom}</td>
									<td ><a href="${pageContext.request.contextPath}/edit/${adherent.id_adherent}" class="button tiny btnicon secondary" data-tooltip title="Modifier"><i
											class="fa fa-pencil"></i></a> 
											<a href="${pageContext.request.contextPath}/delete/${adherent.id_adherent}" data-tooltip title="Supprimer"><i class="fa fa-times"></i></a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="deleteModal" class="reveal-modal small" data-reveal>
	  <h2>Suppression</h2>
	  <p>Voulez vous vraiment supprimer le adherent <span class="label secondary titre"></span></p> 
	  <div>
	  	<a href="#" class="button tiny primary custom-close-reveal-modal">Annuler</a>
	  	<a href="#" class="button tiny alert delbtn">Supprimer</a>
	  </div>
	  <a class="close-reveal-modal">&#215;</a>
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/resources/js/vendor/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/foundation.min.js"></script>
<script>
	$(document).foundation();
	
	$('[data-reveal-id]').on('click', function() {
	  var targetModal = $('#' + $(this).data('revealId'));
	  targetModal.find('.titre').text($(this).data('titre'));
	  targetModal.find('.delbtn').attr('href', '${pageContext.request.contextPath}/delete/'+$(this).data('isbn'));
	});
	
	$('a.custom-close-reveal-modal').click(function(){
	  $('#deleteModal').foundation('reveal', 'close');
	});
</script>
</html>