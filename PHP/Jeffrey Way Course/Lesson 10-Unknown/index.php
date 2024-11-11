<?php  
 
include "function.php";
include "route.php";

$uri = new URI;
$uri->directURI($_SERVER["REQUEST_URI"]);