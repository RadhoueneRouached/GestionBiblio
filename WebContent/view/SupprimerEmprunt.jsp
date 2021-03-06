<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Supprimer Emprunt</title>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1" />
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />
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
				<h2>Livre</h2>
				<p>
					<form action="/BibioGestViews/AjouterLivre">
						<input value="Ajouter" type="submit" />
					</form>
					<hr />
					<div class="CSSTableGenerator">
							<fmt:message key='deleteBorrow' />

						<%-- 
<c:choose>
    <c:when test="${sessionScope.suppressionLivre !=0 }">
    <br/>
	Livre supprim� avec succes !     
    </c:when>
    <c:otherwise>
     <br/>
     Livre n'est supprim� correctement     
    </c:otherwise>
</c:choose>
 --%>
					</div>

				</p>
			</div>
<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>