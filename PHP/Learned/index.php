<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

    <body>
        <?php 
            echo "Hello World";
        ?>

        <?php 
            echo "Hello" . " World"; // Concatenate String
        ?>

        <?php 
            $greeting = "Hello"; // Variable

            echo $greeting . " World \n";

            echo "$greeting World \n";

            echo '$greeting World'
        ?>

        <?php 
            $name = "Something";
            $boolean = false; // Boolean Variable
        ?>

        <h1>
            <!-- Condition -->
            <?php
                if ($boolean) {
                    echo "You have print $name";
                }  else if (!$boolean) {
                    echo "false";
                } else {
                    echo "You have not print";
                }
            ?>

            <!-- Array -->
            <?php 
                $books = [
                    "Book1",
                    "Book2",
                    "Book3"
                ];

                // Associated Array:
                $bookshelf = [
                    [
                        "Book1",
                        "Book2",
                        "Book3"
                    ],
                    // Key Array
                    [
                        'name1' => "Book1",
                        'name2' => 'Book2',
                        'url' => 'someURL'
                    ],
                    $books
                ];

                $book1 = $book[0];
            ?>

            <!-- Loop -->
            <?php 
                foreach ($books as $book) {
                    echo $book . "\n";
                }
            ?>

            <!-- Add PHP with HTML -->
            <ul>
                <?php 
                    foreach ($books as $book) {
                        echo "<li> Hello World </li>";
                    }   
                ?>

                <!-- Another ways to use -->
                <?php foreach ($books as $book): ?>
                    <li> <?php echo $book; ?> </li>
                    <!-- or -->
                    <li> <?= $book ?></li>
                <?php endforeach; ?>
            </ul>

            <!-- Loop through Associated Array -->
            <ul>
                <?php foreach ($bookshelf as $book_arr): ?>
                    <li>
                        <a href="<?= $book_arr['url'] ?>;">
                            <?= $book_arr['name1'] ?>;
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </h1>

        <!-- Function, filter -->
        <?php 
            $SomeBook = [
                [
                    'name' => 'Book\'s 1 Name',
                    'author' => 'Author\'s 1 Name',
                    'years' => 2024,
                    'URL' => 'http://example.com'
                ],
                [
                    'name' => 'Book\'s 2 Name',
                    'author' => 'Author\'s 2 Name',
                    'years' => 2024,
                    'URL' => 'http://example.com'
                ]
            ]
        ?>

        <?php foreach ($someBook as $book): ?>
            <?php if ($book['name'] === 'Book\'s 1 Name'):?>
                <li>
                    <a href="<?= $books['URL'] ?>">
                        <?= $book['name']; ?> (<?= $book['years']; ?>) - By <?= $book['author']; ?>
                    </a>
                </li>
            <?php endif  ?>
        <?php endforeach ?>
        
        <?php 
            function filterByName($books):array {
                $filter_book = [];
                
                // $idx = 0;
                foreach ($books as $book){
                    if ($book['name'] ===  'Book\'s 1 Name') {
                        // $filter_book[$idx] = $book[$idx++];
                        $filter_book[] = $book;
                    }
                }

                return $filter_book;
            }
        ?>

        <!-- Lambda Function -->
        <?php 
            
        ?>
    </body>

</html>