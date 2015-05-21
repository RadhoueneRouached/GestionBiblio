<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Emprunt</title>
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

			<!-- CONTENU  -->
			<div id="content">
				<h2>
					<fmt:message key='borrow' />
				</h2>
				<br /> <br />  
				<p>
					<hr />
							<a href="${pageContext.request.contextPath}/consulterLivre"> << <fmt:message key='back' /></a>

					<div class="CSSTableGenerator">
						<table border="1">
							<tr>
								<td>ID</td>
								<td><fmt:message key='document' /></td>
								<td><fmt:message key='member' /></td>
								<td><fmt:message key='firstDate' /></td>
								<td><fmt:message key='finalDate' /></td>
								<td><fmt:message key='overtake' /></td>
							</tr>
							<c:forEach items="${emprunts}" var="emprunt">
								<tr>
									<td>${emprunt.id_emp}</td>
									<td>${emprunt.getDocument().titre}</td>
									<td>${emprunt.getAdherent().nom}
										${emprunt.getAdherent().prenom}</td>
									<td><c:set var="db" value="${emprunt.dateDeb}" /> <fmt:formatDate
											type="date" value="${db}" /></td>
									<td><c:set var="df" value="${emprunt.dateFin}" /> <fmt:formatDate
											type="date" value="${df}" /></td>
									<td>${emprunt.depasse}</td>

								</tr>
							</c:forEach>


						</table>
					</div>

				</p>
				<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
			</div>

		</div>

		<!-- PIED DE PAGE -->
	</div>

</body>
</html>