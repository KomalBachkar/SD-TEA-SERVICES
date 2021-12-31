 <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="${images}/logo.png" alt="">
        <span class="d-none d-lg-block">${companyName}</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

       <!-- Navigation -->
		<%@include file="./shared/message1.jsp"%>
		
		<!-- Navigation -->
		<%@include file="./shared/message2.jsp"%>
     
     <!-- Navigation -->
		<%@include file="./shared/menu.jsp"%>
       
      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- Navigation -->
		<%@include file="./shared/sidebar.jsp"%>

 <main id="main" class="main">

    <div class="pagetitle">
      <h1>Branch</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Tables</li>
          <li class="breadcrumb-item active">Data</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Add Sales Details</h5>
              
              <form action="${action}" method="post" class="row g-3 needs-validation" novalidate>
                <div class="row mb-3">
                  <label for="branchName" class="col-sm-2 col-form-label">Branch Name</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="branchName" name="branchName">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="totalSales" class="col-sm-2 col-form-label">Total Sales</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="totalSales" name="totalSales">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="filledBy" class="col-sm-2 col-form-label">FilledBy</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="filledBy" name="filledBy">
                  </div>
                </div>
               
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
              </form><!-- End Horizontal Form -->
             
             
            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->
 
 
 
  <!-- Navigation -->
		<%@include file="./shared/footer.jsp"%>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
