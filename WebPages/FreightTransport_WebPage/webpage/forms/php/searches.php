                                                <?php
                                        $mysqli=new mysqli("localhost","root","","database_transportes");
                                        $salida="";
                                        $query="SELECT * FROM cliente ORDER BY ci";
                                        if(isset($_POST['consulta'])){
                                            $q=$mysqli->real_escape_string($_POST['consulta']);
                                            $query="SELECT nombre FROM cliente WHERE ci like '%".$q."%' ";
                                        }
                                        $resultado=$mysqli->query($query);
                                        if($resultado->num_rows>0){
                                        while($fila=$resultado->fetch_assoc()){
                                        $salida.="<label>".$fila['nombre']."</label>";  
                                        }
                                        }else{
                                            $salida="No existe la CI ingresada";
                                        }
                                        $mysqli->close();
                                        ?>    
                                            