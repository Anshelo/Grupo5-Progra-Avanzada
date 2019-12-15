<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    $url = "http://localhost:1024/FreightTransport/project/guide/insertguide";
    $idguide = $_POST['idguide'];
    $datesent = $_POST['datesent'];
    $datereceive = $_POST['datereceive'];
    $idcustomer = $_POST['idcustomer'];
    $idcarrier = $_POST['idcarrier'];
    $codezone = $_POST['codezone'];    
    $data =array('guideId' =>$idguide, 'sendDate'=>$datesent, 'deliverDate'=>$datereceive,
    'customerId'=>$idcustomer, 'carrierCard'=>$idcarrier,'zoneCode'=>$codezone);    
    $data_json = json_encode($data);
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
    $idg = $_POST['idguide'];
                $dataread = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showguidebyid/$idg"),true);
?>
                <html lang="en">
<head>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
    <script src="../js/formsent.js"></script>
    <script src="../js/validations.js"></script>
    <script src="../php/json.php"></script>

    <title>Formulario Guia</title>
</head>

<body>
    <form name="guide" id="guideproduct" method="post" action="../php/guide.php">
        <div class="modal-body text-center">
            <div class="col-sm-8 main-section mx-auto">
                <div class="modal-content">
                    <div class="col-33 ">
                        <form class="col-33"><br>
                            <table class="table">

                                <head>
                                    <div class="styletittle">
                                        Guia de remision
                                    </div>
                                </head>
                                <tbody>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Id Guia: </div>
                                            </td>
                                            <td><input type="number" class="form-control" name="idguide" value="<?php echo $dataread['guideId'] ?>"></td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Fecha envio: </div>
                                            </td>
                                            <td><input type="date" value="<?php echo $dataread['sendDate'] ?>" class="form-control" name="datesent" >
                                            </td>
                                            <td></td>
                                            <td>
                                                <div class="label">Fecha llegada: </div>
                                            </td>
                                            <td><input type="date" value="<?php echo $dataread['deliverDate'] ?>" class="form-control" name="datereceive" >
                                            </td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td colspan="6">
                                                <subtitles>
                                                    Datos cliente
                                                </subtitles>

                                            </td>
                                        </div>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cedula: </div>
                                                </td>
                                                <td><input type="text" class="form-control" name="idcustomer" id="id" value="<?php echo $dataread['customerId'] ?>"></td>
                                    
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group label">
                                                <td colspan="7">
                                                    <subtitles>
                                                        Datos Transportista
                                                    </subtitles>
                                                </td>

                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cedula: </div>
                                                </td>
                                                <td><input type="text" class="form-control" value="<?php echo $dataread['carrierCard']?>" name="idcarrier" id="id">
                                                </td>
                                            
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Codigo zona envio: </div>
                                                </td>
                                                <td colspan="2">
                                                    <input type="text" class="form-control" name="codezone" value="<?php echo $dataread['zoneCode']?>">
                                                </td>
                                            </div>
                                        </tr>
                                      
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cantidad total:</div>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" name="quantityguide" value="<?php echo $dataread['quantity']?>">
                                                </td>
                                            </div>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Total a pagar: </div>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" name="totalguide" value="<?php echo $dataread['total']?>">
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </div>

                                        </tr>

                                </tbody>
                            </table>
                            
                        </form>
                        <form method="POST" action="../html/home.html">
                        <table class="table">

                                <body>
                                    <tr>
                                        <div class="form-group">
                                           
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" type="submit" class="btn btn-primary center " name="option" value="Inicio">
                                            </td>
                                        </div>
                                    </tr>
                                </body>
                            </table>
</form>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </form>
</body>
</html>  

<?php
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