$(searchCliente());

function searchCliente(consulta) {
    $.ajax({
            url: '../php/searches.php',
            type: 'POST',
            dataType: 'html',
            data: { consulta: consulta },
        })
        .done(function(respuesta) {
            $("#datos").html(respuesta);
        })
        .fail(function() {
            console.log("error");
        })
}
$(document).on('keyup', '#id', function() {
    var valor = $(this).val();
    if (valor != "") {
        searchCliente(valor);
    } else {
        searchCliente();
    }
});