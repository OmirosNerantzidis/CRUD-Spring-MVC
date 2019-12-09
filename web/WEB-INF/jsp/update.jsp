<%-- 
    Document   : showall
    Created on : Sep 26, 2019, 7:29:52 PM
    Author     : omiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Trainers</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
    </head>


    <body class="bg-secondary text-white">
        <div class="container">


            <h1 class="mb-1">Trainers</h1>

            <spring:form modelAttribute="trainerToBeUpdated" action="${pageContext.request.contextPath}/trainer/update-form/${trainerToBeUpdated.trainerId}.htm" method="post">


                <div class="container">

                    <spring:label path="trainerFirstName"><b>Name</b></spring:label>
                    <spring:input path="trainerFirstName" required="required"/>

                    <spring:label path="trainerLastName"><b>Last Name</b></spring:label>
                    <spring:input path="trainerLastName" required="required"/>

                    <spring:label path="trainerSubject"><b>Subject</b></spring:label>
                    <spring:input path="trainerSubject" required="required"/>

                    <button class="btn btn-success" type="submit">UPDATE</button>

                </div>


            </spring:form>
            <table border="1" class="table table-dark table-hover shadow p-3 mb-5 rounded" id="mainTable">
                <thead class="thead-light" id="mainTableHead">



                    <tr>
                        <th id="mainTableHeadCol-1">ID</th>
                        <th id="mainTableHeadCol-2">Name</th>
                        <th id="mainTableHeadCol-2">Last Name</th>
                        <th id="mainTableHeadCol-2">Subject</th>
                        <th id="mainTableHeadCol-3"></th>
                        <th id="mainTableHeadCol-3"></th>
                    </tr>
                </thead>
                <c:choose>
                    <c:when test="${empty result_show}">
                        <tbody>
                            <tr>
                                <td></td>
                                <td>No Trainers to show...</td>
                                <td>Click "Insert New Trainer" to add one</td>
                            </tr>
                        </tbody>
                    </c:when>    
                    <c:otherwise>
                        <tbody>

                            <c:forEach var="trainer" items="${result_show}">

                                <tr>

                                    <td>${trainer.trainerId}</td>
                                    <td>${trainer.trainerFirstName}</td>
                                    <td>${trainer.trainerLastName}</td>
                                    <td>${trainer.trainerSubject}</td>
                                    <td><a href="${pageContext.request.contextPath}/trainer/update/${trainer.trainerId}.htm"><img src="${pageContext.request.contextPath}/images/edit.png" width="16" height="16" alt="update"/></a></td>
                                    <td><a onclick="return getConfirmation();" href="${pageContext.request.contextPath}/trainer/delete/${trainer.trainerId}.htm"><img src="${pageContext.request.contextPath}/images/delete.png" width="16" height="16" alt="delete"/></a>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:otherwise>
                </c:choose>
            </table>



        </div>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>



    </body>
</html>
