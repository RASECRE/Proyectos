<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Proyecto</title>
		<link rel="stylesheet" href="style.css" />
		<script
			src="https://kit.fontawesome.com/a08ab3b7e5.js"
			crossorigin="anonymous"
		></script>
	</head>

	<body>
    <?php 
      include_once("connect.php");
      Connect:ConnectBD();
    ?>
		<div id="container">
      <!-- left bar -->
      <nav id="navbar">
        <!-- principal elements -->
        <div>
          <!-- home icon -->
          <a href="#" class="nav-icon">
            <li class="active-icon">
              <i class="fa-solid fa-house"></i>
              <p>principal</p>
            </li>
          </a>
          
          <!-- patient icon -->
          <a href="patient.html" class="nav-icon">
            <li>
              <i class="fa-solid fa-user"></i>
              <p>pacientes</p>
            </li>
          </a>

          <!-- calendar icon -->
          <a href="#" class="nav-icon">
            <li>
              <i class="fa-solid fa-calendar"></i>
              <p>Citas</p>
            </li>
          </a>
        </div>
        
        <!-- settings -->
        <div>
			    <a href="#" class="nav-icon">
            <li>
              <i class="fa-solid fa-gear"></i>
            </li>
          </a>
        </div>

			</nav>
			<div id="principal">No sé que poner aquí.</div>
		</div>
	</body>
</html>
