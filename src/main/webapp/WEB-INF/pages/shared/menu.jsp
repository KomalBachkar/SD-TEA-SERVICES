
<li class="nav-item dropdown pe-3"><a
	class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
	data-bs-toggle="dropdown"> <img src="${images}/profile-img.jpg"
		alt="Profile" class="rounded-circle"> <span
		class="d-none d-md-block dropdown-toggle ps-2">${userModel.firstName}&nbsp;${userModel.lastName}</span>
</a>
<!-- End Profile Iamge Icon -->

	<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
		<li class="dropdown-header">
			<h6>${userModel.firstName}&nbsp;${userModel.lastName}</h6> <span>Web
				Designer</span>
		</li>
		<li>
			<hr class="dropdown-divider">
		</li>

		<li><a class="dropdown-item d-flex align-items-center"
			href="users-profile.html"> <i class="bi bi-person"></i> <span>My
					Profile</span>
		</a></li>
		<li>
			<hr class="dropdown-divider">
		</li>

		<li><a class="dropdown-item d-flex align-items-center"
			href="users-profile.html"> <i class="bi bi-gear"></i> <span>Account
					Settings</span>
		</a></li>
		<li>
			<hr class="dropdown-divider">
		</li>

		<li><a class="dropdown-item d-flex align-items-center"
			href="pages-faq.html"> <i class="bi bi-question-circle"></i> <span>Need
					Help?</span>
		</a></li>
		<li>
			<hr class="dropdown-divider">
		</li>

		<li><c:if test="${sessionScope.role=='ADMIN'}">
				<a class="dropdown-item d-flex align-items-center"
					href="${contextRoot}/admin/logout">
			</c:if> 
			<c:if test="${sessionScope.role=='USER'}">
				<a class="dropdown-item d-flex align-items-center"
					href="${contextRoot}/logout">
			</c:if> <i class="bi bi-box-arrow-right"></i> <span>Sign Out</span> </a></li>

	</ul>
	<!-- End Profile Dropdown Items --></li>
<!-- End Profile Nav -->
