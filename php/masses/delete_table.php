<?php
$con=mysql_connect('localhost', 'root', '00');
if (!$con)
{
    die('Could not connect:'.mysql_error());
} else {
    echo "databse connect success<br>";
}

mysql_select_db("mdb", $con);

mysql_query("DELETE FROM Persons where Age < '100'");
echo "<h1>Delete from Persons Success!!</h1>";
mysql_close($con);



?>
