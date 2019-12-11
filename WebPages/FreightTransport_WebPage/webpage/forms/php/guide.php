<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    $url = "http://localhost:1024/FreightTransport/project/guide/insertguide";
    $idguide = $_POST['idguide'];
    $datesent = $_POST['datesent'];
    $datereceive = $_POST['datereceive'];
    $quantity = $_POST['quantityguide'];
    $total = $_POST['totalguide'];
    $idcustomer = $_POST['idcustomer'];
    $idcarrier = $_POST['idcarrier'];
    $codezone = $_POST['codezone'];    
    $data =array('guideId' =>$idguide, 'sendDate'=>$datesent, 'deliverDate'=>$datereceive,'quantity'=>$quantity,'total'=>$total,
    'customerId'=>$idcustomer, 'carrierCard'=>$idcarrier,'zoneCode'=>$codezone);    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
    echo"<center> <h1>GUIDE REGISTER</h1></center>";
elseif($opcion =='+'):
    $url = "http://localhost:1024/FreightTransport/project/guide/calculatetotal/addguidedetail";
    $idguidedetail = $_POST['idguide'];
    $codeproduct = $_POST['codeproduct'];
    $quantityproduct = $_POST['quantityproduct'];
       
    $data =array('guideId' =>$idguidedetail, 'productCode'=>$codeproduct, 'quantity'=>$quantityproduct);    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
elseif ($opcion == 'Ver registros'):
        $data = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showallguides"),true);
        ?>
        <html lang="en">
        <head>
        <link rel="stylesheet" href="../css/styles.css">
            <title>Guides</title>
        </head>
        <body>
        <body class="col-sm-8 main-section mx-auto">
            <br>
        <div class="styletittle">
                                        Guías de Remisión
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                    <td>ID</td>
                    <td>Fecha envio</td>
                    <td>Fecha recepcion</td>
                    <td>ID transportista</td>
                    <td>Ci Cliente</td>
                    <td>Cod. Zona envio</td>
                    <td>Cantidad</td>
                    <td>Total</td>                
                    		
                </tr>
                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['guideId'] ?></td>
                    <td><?php echo $d['sendDate'] ?></td>
                    <td><?php echo $d['deliverDate'] ?></td>
                    <td><?php echo $d['carrierCard']?></td>
                    <td><?php echo $d['customerId'] ?></td>
                    <td><?php echo $d['zoneCode']?></td>
                    <td><?php echo $d['quantity']?></td>
                    <td><?php echo $d['total']?></td> 
                </tr>
        </body>
        </html>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['idguide'];
                $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showguidebyid/$id"),true);
                ?>
                <html lang="en">
        <head>
        <link rel="stylesheet" href="../css/styles.css">
            <title>Guides</title>
        </head>
        <body>
        <body class="col-sm-8 main-section mx-auto">
            <br>
        <div class="styletittle">
                                        Guías de Remisión
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                <td>ID</td>
                    <td>Fecha envio</td>
                    <td>Fecha recepcion</td>
                    <td>ID transportista</td>
                    <td>Ci Cliente</td>
                    <td>Cod. Zona envio</td>
                    <td>Cantidad</td>
                    <td>Total</td> 		
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['guideId'] ?></td>
                            <td><?php echo $dataId['sendDate'] ?></td>
                            <td><?php echo $dataId['deliverDate'] ?></td>
                            <td><?php echo $dataId['carrierCard']?></td>
                            <td><?php echo $dataId['customerId'] ?></td>
                            <td><?php echo $dataId['zoneCode']?></td>
                            <td><?php echo $dataId['quantity']?></td>
                            <td><?php echo $dataId['total']?></td>
                            
                            
                            
                        </tr>
        </body>
        </html>
        
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