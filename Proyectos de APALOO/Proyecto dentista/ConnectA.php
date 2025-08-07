<?php
interface DatabaseConnection{
    public function connect();
    public function query($sql);
    public function close();
}
class MySQLiAdapter implements DatabaseConnection{
    private $connection;
    public function connect(){
        $this -> connection = new mysqli("host", "username", "password", "database");
        echo "La conexion se establico correctamente";
    }
    public function query($sql){
        return $this->connection->query($sql);
    }
    public function close(){
        $this->connection->close();
    }
}
$adapter = new MySQLiAdapter();
$adapter->connect();
$result = $adapter->query("SELECT * FROM users");
$adapter->close();
?>