/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkRut(rut) {
    console.log("funcion rut");
    // Despejar Puntos
    var valor = rut.value.replace('.', '');
    // Despejar Guión
    valor = valor.replace('-', '');

    // Aislar Cuerpo y Dígito Verificador
    cuerpo = valor.slice(0, -1);
    dv = valor.slice(-1).toUpperCase();

    // Formatear RUN
    rut.value = cuerpo + '-' + dv

    // Si no cumple con el mínimo ej. (n.nnn.nnn)
    if (cuerpo.length < 7) {
        rut.className = 'form-control is-invalid';
    } else {
        rut.className = 'form-control is-valid';
    }

    // Calcular Dígito Verificador
    suma = 0;
    multiplo = 2;

    // Para cada dígito del Cuerpo
    for (i = 1; i <= cuerpo.length; i++) {

        // Obtener su Producto con el Múltiplo Correspondiente
        index = multiplo * valor.charAt(cuerpo.length - i);

        // Sumar al Contador General
        suma = suma + index;

        // Consolidar Múltiplo dentro del rango [2,7]
        if (multiplo < 7) {
            multiplo = multiplo + 1;
        } else {
            multiplo = 2;
        }

    }

    // Calcular Dígito Verificador en base al Módulo 11
    dvEsperado = 11 - (suma % 11);

    // Casos Especiales (0 y K)
    dv = (dv == 'K') ? 10 : dv;
    dv = (dv == 0) ? 11 : dv;

    // Validar que el Cuerpo coincide con su Dígito Verificador
    if (dvEsperado != dv) {
        rut.className = 'form-control is-invalid';
        return false;
    }

    // Si todo sale bien, eliminar errores (decretar que es válido)
    rut.setCustomValidity('');
}

function vacio(element) {
    console.log("funcion vacio");
    if (element.value == '') {

        console.log("holaa");
        element.className = 'form-control is-invalid';
    } else {
        element.className = 'form-control is-valid';
    }
}

function validateNumPhone(element) {
    var data = element.value;
    if (isNaN(data)) {
        element.className = 'form-control is-invalid';
    }
    else {
        element.className = 'form-control is-valid';
    }
}
function validateTextField(element) {
    var data = element.value;
    if (isNaN(data)) {
        element.className = 'form-control is-valid';
    } else {
        element.className = 'form-control is-invalid';
    }
}

function validateEmail(element) {
    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (regex.test(element.value) == false) {
        //Mail correcto
        element.className = 'form-control is-invalid';
    } else {
        //Mail incorrecto
        element.className = 'form-control is-valid';
    }
}

function validateBirthdate(element) {
    var currentDate = new Date();
    currentDate.getFullYear() + "-" + currentDate.getMonth() + "-" + currentDate.getDate();
    var birthDate = new Date(element.value);

    var day_as_milliseconds = 86400000;
    var diff_in_days = (currentDate - birthDate) / day_as_milliseconds;
    var adult = 18 * 365;
    if (diff_in_days > adult) {
        element.className = 'form-control is-valid';
    } else {
        element.className = 'form-control is-invalid';
    }
}

function validateContract(element) {
    var currentDate = new Date();
    currentDate.getFullYear() + "-" + currentDate.getMonth() + "-" + currentDate.getDate();
    var contract = new Date(element.value);

    var day_as_milliseconds = 86400000;
    var diff_in_days = (currentDate - contract) / day_as_milliseconds;

    if (diff_in_days > 0) {
        element.className = 'form-control is-valid';
    } else {
        element.className = 'form-control is-invalid';
    }
}
function validateDateCurrent(element) {
    var currentDate = new Date();
    currentDate.getFullYear() + "-" + currentDate.getMonth() + "-" + currentDate.getDate();
    var start = new Date(element.value);

    var day_as_milliseconds = 86400000;
    var diff_in_days = (currentDate - start) / day_as_milliseconds;

    if (diff_in_days < 0) {
        element.className = 'form-control is-valid';
    } else {
        element.className = 'form-control is-invalid';
    }
}
function compareDates(form, elemento) {
    var init = form.inicio.value;
    var fin = elemento.value;
    
    var start = new Date(init);
    var end = new Date(fin);
    
  
    var day_as_milliseconds = 86400000;
    var diff_in_days = (end - start) / day_as_milliseconds;
    
    
    if (diff_in_days >= 0) {
        elemento.className = 'form-control is-valid';
    } else {
        elemento.className = 'form-control is-invalid';
    }
}




function sub(elemento) {

    if (elemento.usuario_rut.className == 'form-control is-invalid' ||
            elemento.usuario_nombre.className == 'form-control is-invalid' ||
            elemento.usuario_apellido.className == 'form-control is-invalid' ||
            elemento.usuario_telefono.className == 'form-control is-invalid' ||
            elemento.usuario_correo.className == 'form-control is-invalid' ||
            elemento.usuario_pass.className == 'form-control is-invalid' ||
            elemento.usuario_fecha_nacimiento.className == 'form-control is-invalid') {
            
        alert('El envio del formulario no es posible por datos invalidos');
    } else if (elemento.usuario_rut.value == '' ||
            elemento.usuario_nombre.value == '' ||
            elemento.usuario_apellido.value == '' ||
            elemento.usuario_telefono.value == '' ||
            elemento.usuario_correo.value == '' ||
            elemento.usuario_pass.value == '' ||
            elemento.usuario_fecha_nacimiento.value == '') {

        alert('El envio del formulario no es posible por datos vacios');
    } else {

    }
}

function subEvents(elemento) {

    if (elemento.titulo.className == 'form-control is-invalid' ||
            elemento.inicio.className == 'form-control is-invalid' ||
            elemento.fin.className == 'form-control is-invalid' ||
            elemento.url.className == 'form-control is-invalid' 
            ) {
        alert('El envio del formulario no es posible por datos invalidos');
    } else if (elemento.titulo.value == '' ||
            elemento.inicio.value == '' ||
            elemento.fin.value == '' ||
            elemento.url.value == '' 
          ) {
        alert('El envio del formulario no es posible por datos vacios');
    } else {
        elemento.submit();
    }
}





