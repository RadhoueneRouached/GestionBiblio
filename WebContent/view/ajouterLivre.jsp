<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Ajouter Livre</title>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1" />
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="css/styleGabarit.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<link rel="stylesheet"
	href="css/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<script src="js/jquery.js"
	type="text/javascript"></script>
<script
	src="js/jquery.validationEngine-fr.js"
	type="text/javascript"></script>
<script
	src="js/jquery.validationEngine.js"
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
				<form id="formID" class="formular" action="${pageContext.request.contextPath}/newDocument" modelAttribute="document"
					method="post"  >
					<fieldset>
						<legend><fmt:message key='addDocument' /></legend>
							<b> ${messageAjoutLivre} </b><br />
						<label> <span><fmt:message key='title' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="titre" value="" id="titre" />
						</label> <label> <span>Description</span> <input
							class="validate[required,length[1,20]]"
							type="text" name="description" id="description" />
						</label> <label> <span><fmt:message key='author' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="auteur" value="" id="auteur" />
						</label> 
						<label> <span><fmt:message key='type' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="type" value="" id="type" />
						</label>
						<label> <span><fmt:message key='releaseDate' /></span> <input
							class="validate[required,length[1,20]]"
							type="text" name="DateSortie" id="datepicker" />
						</label> <label> <span><fmt:message key='editionNumber' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="numEdition" value="" id="numEdition" />
						</label> <label> <span><fmt:message key='numberOfCopies' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="exemplaire" id="exemplaire" />
						</label>
					<p>
						<input class="submit" type="submit" value="<fmt:message key='addDocument' />" />
					</p>
				</form>
				<c:import url="/WEB-INF/jspf/footer.jsp">
				</c:import>
			</div>

		</div>

		<!-- PIED DE PAGE -->
		</div>

	</div>

</body>
</html>