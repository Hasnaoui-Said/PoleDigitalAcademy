<%
    HttpSession maSession = request.getSession();
    Administrateur administrateur = (Administrateur)maSession.getAttribute("userSession");
    if (request.getSession().getAttribute("userSession")==null){
        response.sendRedirect("login");
        return;
    }
%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="next.pda.entity.Administrateur" %>

<%@include file="header.jsp" %>

<%
    String message = (String)session.getAttribute("message");
    String className = (String)session.getAttribute("className");
    List<String> activeLink = Arrays.asList( "home","activity", "exercise", "users", "profile","addResponsable","addParticipant");
    String active = request.getAttribute("active").toString();
%>

<% if (message != null) { %>
<div class="container my-2">
    <div class="alert alert-<%=className%> alert-dismissible">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong><%=className%></strong> <%=message%>
    </div>
</div>
<%
        session.removeAttribute("message");
        session.removeAttribute("className");
    }
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
    <% }else if ((active.equals(activeLink.get(5)))){ %>
        <%@include file="addRespansable.jsp" %>
    <% }else if ((active.equals(activeLink.get(6)))){ %>
        <%@include file="addParticipant.jsp" %>
    <% } else{ %>
        <%@include file="notFound.jsp" %>
    <% } %>



<%@include file="footer.jsp" %>