<%@page
	import="com.jay.news.fiddle.domain.User,com.jay.news.fiddle.util.NewsFiddleConstants"%>
<div style="width: 100%; overflow: hidden;">
	<div>
		<a href="${pageContext.servletContext.contextPath}/"><img
			src="${pageContext.servletContext.contextPath}/resources/images/logo-big.png"
			alt="News-Fiddle" /></a>
	</div>

	<div id='cssmenu'>
		<ul>
			<%
				Integer userId = (Integer) session.getAttribute(NewsFiddleConstants.SESSION_USER_ID);
				Boolean isAdmin = (Boolean) session.getAttribute(NewsFiddleConstants.SESSION_USER_ISADMIN);
				if (userId == null) {
			%>
			<li><a href="${pageContext.servletContext.contextPath}/login">Login</a></li>
			<%
				}
				if (isAdmin != null && isAdmin) {
			%>
			<li><a
				href="${pageContext.servletContext.contextPath}/admin/category">Admin</a></li>
			<%
				}
			%>

			<li><a
				href="${pageContext.servletContext.contextPath}/synd/news">News</a></li>

			<%
				if (userId != null) {
			%>
			<li><a
				href="${pageContext.servletContext.contextPath}/user/showProfile">Profile</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/settings">settings</a></li>
			<li class='last'><a
				href="${pageContext.servletContext.contextPath}/login/quit">Logout</a></li>
			<%
				}
			%>
		</ul>
		<ul>
	</div>
</div>
