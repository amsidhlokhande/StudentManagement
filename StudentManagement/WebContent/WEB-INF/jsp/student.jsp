<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
   <form:form action="/action.do" method="post" commandName="student">
          <table align="center" border="2">
             <tr>
                <td>Student ID :</td>
                <td><form:input path="id"/></td>
             </tr>
             
             <tr>
                <td>Student Name :</td>
                <td><form:input path="name"/> </td>
             </tr>
             <tr>
                <td>Student Year :</td>
                <td><form:input path="year"/></td>
             </tr>
             <tr>
                <td colspan="2" align="center">
                 <input type="submit" name="Add" value="add"/>
                 <input type="submit" name="Edit" value="edit"/>
                 <input type="submit" name="Delete" value="delete"/>
                 <input type="submit" name="Search" value="search"/>
                </td>
             </tr>
          </table>
   </form:form>
   <h3 align="center">List Of Students</h3>
   <c:if test="${studentList} not empty }">
      
      <table align="center" border="2">
          <tr>
             <th>STUDENT ID</th>
             <th>STUDENT NAME</th>
             <th>STUDENT YEAR</th>
          </tr>
          <c:forEach items="${studentList}" var="std">
          <tr>
             <td>${std.id}</td>
             <td>${std.name}</td>
             <td>${std.year}</td>
          </tr>
          </c:forEach>
      </table>
   </c:if>
</body>
</html>