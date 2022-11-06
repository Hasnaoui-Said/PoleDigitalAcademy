<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@include file="header.jsp" %>
<%
    List<String> activeLink = Arrays.asList( "home","activity", "exercise", "users", "profile");
    String active = request.getAttribute("active").toString();
%>

    <% if (active.equals(activeLink.get(0))) { %>
        <%@include file="homeImp.jsp" %>
    <% } else if ((active.equals(activeLink.get(1)))){ %>
        <%@include file="activity.jsp" %>
    <% }else if ((active.equals(activeLink.get(2)))){ %>
        <%@include file="exercise.jsp" %>
    <% }else if ((active.equals(activeLink.get(3)))){ %>
        <%@include file="users.jsp" %>
    <% }else if ((active.equals(activeLink.get(4)))){ %>
        <%@include file="profile.jsp" %>
    <% } else{ %>
        <%@include file="notFound.jsp" %>
    <% } %>



<%@include file="footer.jsp" %>