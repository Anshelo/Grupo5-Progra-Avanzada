<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    //$url = "http://localhost:1024//FreightTransport/project/client/addClient";
    
    $url = "http://localhost:8080/FreightTransport/project/carrier/addcarrier";
    $idCarrier = $_POST['idcarrier'];
    $ciCarrier = $_POST['cicarrier'];
    $nameCarrier = $_POST['namecarrier'];
    $addressCarrier = $_POST['addresscarrier'];
    $phoneCarrier = $_POST['phonecarrier'];
    $mobileCarrier = $_POST['mobilecarrier'];
    $emailCarrier = $_POST['emailcarrier'];
    $truckPlate = $_POST['truckplate'];
    $truckType = $_POST['trucktype'];

    $data =array('idcarrier' =>$idCarrier, 'cicarrier'=>$ $ciCarrier,
                'namecarrier'=>$nameCarrier,'addresscarrier'=>$addressCarrier,'phonecarrier'=>$phoneCarrier,
                'mobilecarrier'=>$mobileCarrier,'emailcarrier'=>$emailCarrier,'truckplate'=>$truckPlate,'trucktype'=> $truckType);    
    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    //curl_setopt($cli, CURLOPT_URL,$url);
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));

    $respone = curl_exec($cli);
    
    if($respone == false){    
        echo"<center> <h1>Cliente Si Registrado</h1></center>";
       echo $nameCustomer;
    }else{
        echo"<center> <h1>Cliente No Registrado</h1></center>";
        echo $idCustomer;
        
    }
    
    curl_close($cli);
    
    elseif ($opcion == 'Ver registros'):
        echo " <center><h1>SHOW CARRIERS</h1></center>";
        $data = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/carrier/getcarriers"),true);
        ?>
        <center><table border="1" >
                <tr>
                    <td>idCarrier</td>
                    <td>CI</td>
                    <td>birthdate</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>Phone</td>	
                    <td>Mobile</td>
                    <td>Email</td>
                    <td>TruckPlate</td>
                    <td>TruckType</td>		
                </tr>

                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['idCarrier'] ?></td>
                    <td><?php echo $d['CI'] ?></td>
                    <td><?php echo $d['birthdate'] ?></td>
                    <td><?php echo $d['Name']?></td>
                    <td><?php echo $d['Address']?></td>
                    <td><?php echo $d['Phone'] ?></td>
                    <td><?php echo $d['Mobile']?></td>
                    <td><?php echo $d['Email']?></td>
                    <td><?php echo $d['TruckPlate']?></td>
                    <td><?php echo $d['TruckType']?></td>
                </tr>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['idcarrier'];
                echo " <center><h1>Cliente</h1></center>";
                // $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/client/searchClient/$id"),true);
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/carrier/getcarrierbyid/$id"),true);
                ?>
                <center><table border="1" >
                        <tr>
                            <td>idCarrier</td>
                            <td>CI</td>
                            <td>birthdate</td>
                            <td>Name</td>
                            <td>Address</td>
                            <td>Phone</td>	
                            <td>Mobile</td>
                            <td>Email</td>
                            <td>TruckPlate</td>
                            <td>TruckType</td>
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['idCarrier'] ?></td>
                            <td><?php echo $dataId['CI'] ?></td>
                            <td><?php echo $dataId['birthdate'] ?></td>
                            <td><?php echo $dataId['Name']?></td>
                            <td><?php echo $dataId['Address']?></td>
                            <td><?php echo $dataId['Phone'] ?></td>
                            <td><?php echo $dataId['Mobile']?></td>
                            <td><?php echo $dataId['Email']?></td>
                            <td><?php echo $dataId['TruckPlate']?></td>
                            <td><?php echo $dataId['TruckType']?></td>
                        </tr>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php 
        elseif ($opcion == 'Eliminar'):
            $idC = $_POST['idcarrier'];
			//$url = "http://localhost:1024/FreightTransport/project/client/deleteClient/$idC";
            $url = "http://localhost:8080/FreightTransport/project/carrier/deletecarrier/$idC";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>CARRIER DELETE</h2></center>";   
         elseif ($opcion == 'Modificar'):  
            $idCarrier = $_POST['idcarrier'];
            $ciCarrier = $_POST['cicarrier'];
            $nameCarrier = $_POST['namecarrier'];
            $addressCarrier = $_POST['addresscarrier'];
            $phoneCarrier = $_POST['phonecarrier'];
            $mobileCarrier = $_POST['mobilecarrier'];
            $emailCarrier = $_POST['emailcarrier'];
            $truckPlate = $_POST['truckplate'];
            $truckType = $_POST['trucktype'];
            
            $url = "http://localhost:8080/FreightTransport/project/carrier/updatecarrier/$idCarrier";
         // $url = "http://localhost:1024/FreightTransport/project/client/updateclient/$idCustomer";  

            
        
            $data =array('idcarrier' =>$idCarrier, 'cicarrier'=>$ $ciCarrier,
                         'namecarrier'=>$nameCarrier,'addresscarrier'=>$addressCarrier,'phonecarrier'=>$phoneCarrier,
                         'mobilecarrier'=>$mobileCarrier,'emailcarrier'=>$emailCarrier,'truckplate'=>$truckPlate,'trucktype'=> $truckType);          
                   
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            
            $ch  = curl_exec($ch);
            if($ch == false){    
                echo"<center> <h1>Transportista Si Registrado</h1></center>";
                echo $data_json;
            }else{
                echo"<center> <h1>Transportista No Registrado</h1></center>";
                echo $ch;
            }
            curl_close($ch);
             
    endif;
 ?>