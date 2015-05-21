<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Modifier Livre</title>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1" />
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<script src="${pageContext.request.contextPath}/js/jquery.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine-fr.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"
	type="text/javascript"></script>
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
				<form id="formID" class="formular" action="${pageContext.request.contextPath}/editDocument/${document.id_support}" modelAttribute="document"
					method="post">
					<fieldset>
						<legend><fmt:message key='modifyDocument' />: </legend>
						 
						<label> <input type="hidden" name="idLivre" value="${document.id_support}"
							id="idLivre" />
						</label> <label> <span><fmt:message key='title' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="titre" value="${document.titre}" id="titre" />
						</label> <label> <span>Description</span> <input
							class="validate[required,length[1,20]]"
							type="text" name="description" value="${document.description}" id="description" />
						</label>
						<label> <span>Type</span> <input
							class="validate[required,length[1,20]]"
							type="text" name="type" value="${document.type}" id="type" />
						</label>
						 <label> <span><fmt:message key='author' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="auteur" value="${document.auteur}" id="auteur" />
						</label> <label> <span><fmt:message key='releaseDate' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="dateSorie" value="${document.dateSorie}" id="DateSortie" />
						</label> <label> <span><fmt:message key='editionNumber' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="numEdition" value="${document.numEdition}" id="numEdition" />
						</label> <label> <span><fmt:message key='numberOfCopies' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="exemplaire" value="${document.exemplaire}" id="exemplaire" />
						</label>


					</fieldset>
					<p>
						<input class="submit" type="submit" value="<fmt:message key='modifyDocument' />" />
					</p>
				</form>
				<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
				
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>