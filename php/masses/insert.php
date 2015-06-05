<?php
$con = mysql_connect('localhost', 'root', '00');
if (!$con)
{
    die('Could not connect;'.mysql_error());
}

mysql_select_db("mdb", $con);

$sql="INSERT INTO PER (PersonID, FirstName, LastName, Age)
    VALUES
    ('$_POST[personid]', '$_POST[firstname]', '$_POST[lastname]', '$_POST[age]')";

if(!mysql_query($sql, $con))
{
     die('Errof:'.mysql_error());
}
echo "1 record insrted";

mysql_close($con);

?>
