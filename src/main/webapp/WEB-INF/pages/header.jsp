<%@page
	import="com.jay.news.fiddle.domain.User,com.jay.news.fiddle.util.NewsFiddleConstants"%>
<div style="width: 100%; overflow: hidden;">
	<div id="header-container">
		<a href="${pageContext.servletContext.contextPath}/"><img
			src="http://www.logomaker.com/logo-images/3370d01941c5e49c.gif"
			alt="RSS Fiddle" /></a>
	</div>

	<div id='cssmenu'>
		<ul>
			<%
				Integer userId = (Integer) session
						.getAttribute(NewsFiddleConstants.SESSION_USER_ID);
				Boolean isAdmin = (Boolean) session
						.getAttribute(NewsFiddleConstants.SESSION_USER_ISADMIN);
				if (userId == null) {
			%>
			<li><a href="${pageContext.servletContext.contextPath}/login">Login</a></li>
			<%
				}
				if (isAdmin != null && isAdmin) {
			%>
					<li><a href="${pageContext.servletContext.contextPath}/admin/category">Admin</a></li>
			<%
				} else {
					if (userId != null) {
			%>					
						<li><a  href="${pageContext.servletContext.contextPath}/admin/settings">settings</a></li>
					<%
				    }
				}
			%>

			<li><a href="${pageContext.servletContext.contextPath}/synd/news">Feeds</a></li>

			<%
				if (userId != null) {
			%>
			<li><a href="${pageContext.servletContext.contextPath}/user/showProfile">Profile</a></li>

			<li class='last'><a href="${pageContext.servletContext.contextPath}/login/quit">Logout</a></li>
			<%
				}
			%>
		</ul>
		<ul>
	</div>
</div>
