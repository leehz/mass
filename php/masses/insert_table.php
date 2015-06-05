<?php
$con=mysql_connect('localhost', 'root', '00');
if (!$con)
{
    die('Could not connect:'.mysql_error());
} else {
    echo "databse connect success<br>";
}

mysql_select_db("mdb", $con);

mysql_query("INSERT INTO Persons (FirstName, LastName, Age)
    VALUES ('hz', 'lee', '11')");
mysql_query("INSERT INTO Persons (FirstName, LastName, Age)
    VALUES ('hello', 'lex', '11')");
echo "<h1>Success!!</h1>";
mysql_close($con);



?>
