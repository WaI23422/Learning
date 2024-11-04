<?php
class URI{

    public $route = [
        "/error" => [
            "404" => "views/errors/404_view.php"
        ],
        "/about" => "controllers/about.php",
        "/contact" => "controllers/contact.php",
        "/" => "controllers/home.php",
    ];

    function abort($code = 404){
        http_response_code($code);

        require $this->route["/error"][$code];

        die();
    }

    function directURI($uri){
        $uri = parse_url($uri)["path"];

        if (
            array_key_exists(
                $uri,
                $this->route
            )
        ) {
            require $this->route[$uri];
        } else {
            $this->abort(404);
        }
        ;

        // switch (parse_url($uri)["path"]) {
        //     case '/about':
        //         require "controllers/about.php";
        //         break;

        //     case '/contact':
        //         require "controllers/contact.php";
        //         break;

        //     default:
        //         require "controllers/home.php";
        //         break;
        // }
    }
};

