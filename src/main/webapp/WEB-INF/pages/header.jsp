<%@page
	import="com.company.rssfiddle.domain.User,com.company.rssfiddle.util.RSSFiddleConstants"%>
<div style="width: 100%; overflow: hidden;">
	<div id="header-container">
		<a href="${pageContext.servletContext.contextPath}/"><img
			src="http://www.logomaker.com/logo-images/3370d01941c5e49c.gif"
			alt="RSS Fiddle" /></a>
	</div>
	<div id="social-container">
		<a class="social24 facebook" target="_blank" href="http://www.facebook.com/rssfiddle">Facebook</a>
		<a class="social24 twitter"  target="_blank" href="http://www.twitter.com/rssfiddle">Twitter</a>
		<a class="social24 google"  target="_blank" href="http://www.facebook.com/rssfiddle">Google Plus</a>
	</div>
	<div id='cssmenu'>
		<ul>
			<%
				Integer userId = (Integer) session
							.getAttribute(RSSFiddleConstants.SESSION_USER_ID);
					Boolean isAdmin = (Boolean) session
							.getAttribute(RSSFiddleConstants.SESSION_USER_ISADMIN);
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

			<li><a href="${pageContext.servletContext.contextPath}/synd/feeds">Feeds</a></li>

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
