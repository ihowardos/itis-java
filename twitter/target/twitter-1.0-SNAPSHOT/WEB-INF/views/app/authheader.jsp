<div class="authbar">
    <span>Dear <strong>${username}</strong>, welcome!</span>
    <c:choose>
			<c:when test="${isRegistrationPage == null}">
        <c:choose>
            <c:when test="${username == 'Guest'}">
                <span class="floatRight"><a href="<c:url value="/login" />">Login</a></span>
                <span class="floatRight"><a href="<c:url value="/registration" />">Create account</a></span>
            </c:when>
            <c:otherwise>
                <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
            </c:otherwise>
        </c:choose>
            </c:when>
    </c:choose>
</div>
