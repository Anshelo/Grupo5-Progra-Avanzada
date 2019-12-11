<?php
$opcion=$_POST['option'];
if($opcion == 'Registrar'):
    $url = "http://localhost:8080/FreightTransport/project/zone/insertzone";
    $codigozona = $_POST['codigozona'];
    $nombrezona = $_POST['nombrezona'];
    $data =array('codigozona' =>$codigozona, 'nombrezona' =>$nombrezona);
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
    echo"<center> <h1>ZONE REGISTER</h1></center>";
    elseif ($opcion == 'Mostrar'):
        echo " <center><h1>SHOW ZONES</h1></center>";
        $data = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/zone/zones"),true);
        ?>
        <center><table border="1" >
                <tr>
                    <td>codigozona</td>
                    <td>nombrezona</td>
                </tr>

                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['codigozona'] ?></td>
                    <td><?php echo $d['nombrezona'] ?></td>
                </tr>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['codigozona'];
                echo " <center><h1>SHOW Zones</h1></center>";
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/zone/showguidebyid/$id"),true);
                ?>
                <center><table border="1" >
                        <tr>
                            <td>codigozona</td>
                            <td>nombrezona</td>		
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['codigozona'] ?></td>
                            <td><?php echo $dataId['nombrezona'] ?></td>
                        </tr>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php   
         elseif ($opcion == 'Modificar'):  
            
            $codigozona = $_POST['codigozona'];
            $nombrezona = $_POST['nombrezona'];  
            $url = "(http://localhost:8080/FreightTransport/project/zone/modify/zone";      
            $data =array('codigozona' =>$codigozona, 'nombrezona' =>$nombrezona); 
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>ZONE MODIFY</h2></center>"; 
            echo $data_json; 
       endif;
?>
