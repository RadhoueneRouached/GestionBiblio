<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Accueil</title>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1" />
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

<script src="${pageContext.request.contextPath}/js/jquery.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine-fr.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"
	type="text/javascript"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 <script>
 $(function() {
	 $( "#datepicker" ).datepicker({
	 changeMonth: true,
	 changeYear: true
	 });
	 });
 
</script>
</head>

<body>

	<!-- CONTENEUR 998 PX CENTRE -->
	<div id="conteneur">

		<!-- ENTETE -->
				<c:import url="/WEB-INF/jspf/header.jsp">
				</c:import>
				

		<!-- CONTENEUR CENTRAL  -->
		<div id="center">

			<!-- COLONNE GAUCHE  -->
			<div id="left" style="margin-top: 20px;">
				<c:import url="/WEB-INF/jspf/menu.jsp">
				</c:import>
			</div>

			<!-- CONTENU  -->
			<div id="content">
				<h2>
					<fmt:message key='document' />
				</h2>
				<p>
				<form action="${pageContext.request.contextPath}/newDocument">
						<input value="<fmt:message key='add' />" type="submit" />
					</form>
				
				<hr />
				<b>${messageModDoc}</b><br/> <b>${messageDoc}</b><br/> <b>${message}</b>

					<div class="CSSTableGenerator">
					<table border="1">
						<tr>
							<td>ID</td>
							<td><fmt:message key='title' /></td>
							<td><fmt:message key='author' /></td>
							<td>Description</td>
							<td><fmt:message key='numberOfCopies' /></td>
							<td><fmt:message
										key='modify' /></a></td>
							<td><fmt:message
										key='delete' /></a></td>
						</tr>
						<c:forEach items="${documents}" var="document">
							<tr>
								<td>${document.id_support}</td>
								<td>${document.titre}</td>
								<td>${document.auteur}</td>
								<td>${document.description}</td>
								<td>${document.exemplaire}</td>
								<td><a
									href="${pageContext.request.contextPath}/editDocument/${document.id_support}"><fmt:message
											key='modify' /></a></td>
								<td><a
									href="${pageContext.request.contextPath}/deleteDocument/${document.id_support}"><fmt:message
											key='delete' /></a></td>
							</tr>
						</c:forEach>


					</table>
							
				</div>
	<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
							</div>

		</div>

		<!-- PIED DE PAGE -->

				
	</div>

</body>
</html>