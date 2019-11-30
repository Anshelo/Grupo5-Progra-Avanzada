<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    //$url = "http://localhost:1024//FreightTransport/project/client/addClient";
    
    $url = "http://localhost:8080/FreightTransport/project/client/addClient";
    $idCustomer = $_POST['idcustomer'];
    $nameCustomer = $_POST['namecustomer'];
    $rucCustomer = $_POST['ruccustomer'];
    $fonoCustomer = $_POST['fono1customer'];
    $cellphoneCustomer = $_POST['fono2customer'];
    $emailCustomer = $_POST['emailCustomer'];
    $addressCustomer = $_POST['addressCustomer'];

    $data =array('ci' =>$idCustomer, 'ruc'=>$rucCustomer,
                 'nombre'=>$nameCustomer,'direccion'=>$addressCustomer,'telfconvencional'=>$fonoCustomer,
                 'telfcelular'=>$cellphoneCustomer,'correo'=>$emailCustomer);    
    
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
        echo " <center><h1>SHOW GUIDES</h1></center>";
        $data = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showallguides"),true);
        ?>
        <center><table border="1" >
                <tr>
                    <td>idguide</td>
                    <td>datesent</td>
                    <td>datereceive</td>
                    <td>quantityguide</td>
                    <td>totalguide</td>
                    <td>idcustomer</td>	
                    <td>idcarrier</td>
                    <td>codezone</td>		
                </tr>

                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['guideId'] ?></td>
                    <td><?php echo $d['sendDate'] ?></td>
                    <td><?php echo $d['deliverDate'] ?></td>
                    <td><?php echo $d['quantity']?></td>
                    <td><?php echo $d['total']?></td>
                    <td><?php echo $d['customerId'] ?></td>
                    <td><?php echo $d['carrierCard']?></td>
                    <td><?php echo $d['zoneCode']?></td>
                </tr>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['idcustomer'];
                echo " <center><h1>Cliente</h1></center>";
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/client/searchClient/$id"),true);
                ?>
                <center><table border="1" >
                        <tr>
                            <td>ci</td>
                            <td>ruc</td>
                            <td>nombre</td>
                            <td>direccion</td>
                            <td>telefono convencional</td>
                            <td>telefono celular</td>	
                            <td>correo</td>	
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['ciClient'] ?></td>
                            <td><?php echo $dataId['rucClient'] ?></td>
                            <td><?php echo $dataId['nameClient'] ?></td>
                            <td><?php echo $dataId['addressClient']?></td>
                            <td><?php echo $dataId['phoneClient']?></td>
                            <td><?php echo $dataId['mobileClient'] ?></td>
                            <td><?php echo $dataId['emailClient']?></td>
                        </tr>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php 
        elseif ($opcion == 'Eliminar'):
            $idG = $_POST['idguide'];
            $url = "http://localhost:1024/FreightTransport/project/guide/removeguide/$idG";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>GUIDE DELETE</h2></center>";   
         elseif ($opcion == 'Modificar'):  
            
            $idgui = $_POST['idguide'];
            $datesentm = $_POST['datesent'];
            $datereceivem = $_POST['datereceive'];
            $quantitym = $_POST['quantityguide'];
            $totalm = $_POST['totalguide'];
            $idcustomerm = $_POST['idcustomer'];
            $idcarrierm = $_POST['idcarrier'];
            $codezonem = $_POST['codezone'];          
            $url = "http://localhost:1024/FreightTransport/project/guide/updateguide/$idgui";         
            $data =array('sendDate'=>$datesentm, 'deliverDate'=>$datereceivem,'quantity'=>$quantitym,'total'=>$totalm,
            'customerId'=>$idcustomerm, 'carrierCard'=>$idcarrierm,'zoneCode'=>$codezonem);  
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>GUIDE MODIFY</h2></center>"; 
            echo $data_json; 
       endif;
		 ?>