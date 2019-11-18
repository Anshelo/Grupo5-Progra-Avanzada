function validatenumbers(e) {

    key = e.keyCode || e.which;
    keyboard = String.fromCharCode(key);
    numbers = "0123456789";
    specials = "8-37-38-46";
    keyboard_special = false;
    for (var i in specials) {
        if (key == specials[i]) {
            keyboard_special = true;
        }
    }
    if (numbers.indexOf(keyboard) == -1 && !keyboard_special) {
        return false;
    }
}

function validatedoubles(e) {
    key = e.keyCode || e.which;
    keyboard = String.fromCharCode(key);
    numbers = "0123456789.";
    specials = "8-37-38-46";
    keyboard_special = false;
    for (var i in specials) {
        if (key == specials[i]) {
            keyboard_special = true;
        }
    }
    if (numbers.indexOf(keyboard) == -1 && !keyboard_special) {
        return false;
    }
}

function letrasNumeros(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "áéíóúabcdefghijklmnñopqrstuvwxyz1234567890";
    especiales = [8, 37, 39, 46];

    tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if(letras.indexOf(tecla) == -1 && !tecla_especial)
        return false;
}

function validateletters(e) {
    keyl = e.keyCode || e.which;
    keyboardl = String.fromCharCode(keyl).toLowerCase();
    letters = " abcdefghijklmnñopqrstuvxyz";
    specialsl = "8-37-38-46-164";
    keyboard_speciall = false;
    for (var i in specialsl) {
        if (keyl == specialsl[i]) {
            keyboard_speciall = true;
            break;
        }
    }
    if (letters.indexOf(keyboardl) == -1 && !keyboard_speciall) {
        return false;
    }
}

function validateTransportist() {
    var i;
    var id;
    var accumulated;
    id = document.user.iduser.value;
    var instance;
    accumulated = 0;
    for (i = 1; i <= 9; i++) {
        if (i % 2 != 0) {
            instance = id.substring(i - 1, i) * 2;
            if (instance > 9) instance -= 9;
        } else instance = id.substring(i - 1, i);
        accumulated += parseInt(instance);
    }
    while (accumulated > 0)
        accumulated -= 10;
    if (id.substring(9, 10) != (accumulated * -1)) {
        alert("Cédula incorrecta");
        document.transportist.id.setfocus();
    }
}

function verificaId(){
	if(document.user.iduser.value == ""){
		alert("El campo nombre esta vacio");
		document.getElementById('iduser').style.border = 'thin solid #FF0000';
		return;
	}
}

function verificaUser(){
	if(document.user.userU.value == ""){
		alert("El campo nombre esta vacio");
		document.getElementById('userU').style.border = 'thin solid #FF0000';
		return;
	}
}

function verificaPassword(){
	if(document.user.password.value == ""){
		alert("El campo nombre esta vacio");
		document.getElementById('password').style.border = 'thin solid #FF0000';
		return;
	}
}

function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        return false;
    }
}


function tecla() {
    alert('TECLADO BLOQUEADO')
}