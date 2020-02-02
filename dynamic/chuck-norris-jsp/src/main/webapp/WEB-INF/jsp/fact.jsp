<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<spring:url value="/fact.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
    <c:url value="/fact.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<div class="wrapper">
    <h1 class="title"> Chuck Norris Facts</h1>
    <div class="chuck-image-container">
        <img id="chuck-image" src="chuck-norris.jpg">
        <label id="chuck-iamge-label" for="chuck-image"> Click the image to fetch a new fact</label>
    </div>
    <div class="fact-container">
        <div class="fact">
            ${fact}
        </div>
    </div>
</div>


</body>

</html>