
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/assets/vendor" />
<spring:url var="css1" value="/assets/css" />
<spring:url var="js" value="/assets/js" />
<spring:url var="images" value="/assets/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>${title}</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${css}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="${css}/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${css}/quill/quill.snow.css" rel="stylesheet">
<link href="${css}/quill/quill.bubble.css" rel="stylesheet">
<link href="${css}/remixicon/remixicon.css" rel="stylesheet">
<link href="${css}/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${css1}/style.css" rel="stylesheet">


</head>

<body>

	<main>
		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
							<c:if test="${not empty message}">
								<div class="alert alert-success alert-dismissible fade show"
									role="alert">
									${message}
									<button type="button" class="btn-close" data-bs-dismiss="alert"
										aria-label="Close"></button>
								</div>
							</c:if>
							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="${images}/logo.png" alt=""> <span
									class="d-none d-lg-block">${header_name}</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">Create an
											Account</h5>
										<p class="text-center small">Enter your personal details
											to create account</p>
									</div>

									<form action="${action}" method="post" class="row g-3 needs-validation" novalidate>
										<div class="col-12">
											<label for="firstName" class="form-label">Your
												FirstName</label> <input type="text" name="firstName"
												class="form-control" id="firstName" required>
											<div class="invalid-feedback">Please, enter your
												firstname!</div>
										</div>

										<div class="col-12">
											<label for="lastName" class="form-label">Your
												LastName</label> <input type="text" name="lastName"
												class="form-control" id="lastName" required>
											<div class="invalid-feedback">Please, enter your
												lastname!</div>
										</div>

										<div class="col-12">
											<label for="yourEmail" class="form-label">Your Email</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="email" name="email" class="form-control"
													id="yourEmail" required>
												<div class="invalid-feedback">Please enter a valid
													Email adddress!</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourUsername" class="form-label">UserName</label>
											<input type="text" name="username" class="form-control"
												id="yourUsername" required>
											<div class="invalid-feedback">Please choose a username.</div>
										</div>

										<div class="col-12">
											<label for="password" class="form-label">Password</label> <input
												type="password" name="password" class="form-control"
												id="yourPassword" required>
											<div class="invalid-feedback">Please enter your
												password!</div>
										</div>

										<div class="col-12">
											<label for="mobileNumber" class="form-label">Mobile
												Number</label> <input type="text" name="mobileNumber"
												class="form-control" id="yourMobileNumber" required>
											<div class="invalid-feedback">Please enter your
												mobileNumber!</div>
										</div>

										<div class="col-12">
											<label for="address" class="form-label">Address</label>
											<textarea name="address" class="form-control"
												id="yourAddress" required>
                      </textarea>
											<div class="invalid-feedback">Please enter your
												address!</div>
										</div>

										<div class="col-12">
											<label for="pinCode" class="form-label">PinCode</label> <input
												type="text" name="pinCode" class="form-control"
												id="yourPinCode" required>
											<div class="invalid-feedback">Please enter your
												pinCode!</div>
										</div>

										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" name="terms" type="checkbox"
													value="" id="acceptTerms" required> <label
													class="form-check-label" for="acceptTerms">I agree
													and accept the <a href="#">terms and conditions</a>
												</label>
												<div class="invalid-feedback">You must agree before
													submitting.</div>
											</div>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Create
												Account</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												Already have an account? <a href="pages-login.html">Log
													in</a>
											</p>
										</div>
									</form>

								</div>
							</div>

							<div class="credits">
								Designed by <a href="#">Sagar Jate</a>
							</div>

						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<!-- End #main -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${css}/apexcharts/apexcharts.min.js"></script>
	<script src="${css}/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${css}/chart.js/chart.min.js"></script>
	<script src="${css}/echarts/echarts.min.js"></script>
	<script src="${css}/quill/quill.min.js"></script>
	<script src="${css}/simple-datatables/simple-datatables.js"></script>
	<script src="${css}/tinymce/tinymce.min.js"></script>
	<script src="${css}/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${js}/main.js"></script>

</body>

</html>