<?php
    $con = mysql_connect('localhost', 'root', '00');
    if (!$con)
    {
        die('could not connect:'.mysql_error());
    }

    if(mysql_query("CREATE DATABASE mdb", $con))
    {
        echo "Database mdb created";
    } else {
        echo "error creating database: ".mysql_error();
    }

    //create tables in mdb
    mysql_select_db("mdb", $con);
    $sql="CREATE TABLE Persons
        (
            FirstName varchar(15),
            LastName varchar(15),
            Age int
        )";
    mysql_query($sql, $con);

    $sql1="CREATE TABLE PER
        (
            PersonID int NOT NULL AUTO_INCREMENT,
            PRIMARY KEY(PersonID),
            FirstName varchar(15),
            LastName varchar(15),
            Age int
        )";

    mysql_query($sql1, $con);

    mysql_close($con);

?>
