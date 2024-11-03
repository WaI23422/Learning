<?php
function dump_die($value){
    echo "<pre>";
        var_dump($value);
    echo "</pre>";
    die();
}

function isURI($uri){
    return $_SERVER['REQUEST_URI'] === $uri ? "bg-gray-700 text-white" : "text-gray-300";
}