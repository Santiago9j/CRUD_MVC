/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let div = document.createElement("div");
let ejecutar = function (){
    div.style.display = "block";
    div.innerHTML = "<div class='products-preview'> <div class='preview'><i class='far fa-times-circle' onclick='terminar()'></i></div></div>";
    document.body.appendChild(div);
    formularioAnadir();
};

let botAnadir = document.getElementById("agregar");



botAnadir.addEventListener("click", ejecutar);



function terminar(){
    div.style.display = "none";
}

function formularioAnadir(){
    let divAnadir = document.getElementsByClassName('preview');
    let divCrearPersona = document.createElement("div");
    divCrearPersona.innerHTML ="<h1>Crear una persona</h1>" + 
    "<form action='Controlador' method='POST'>"+
    "<input type='text' placeholder='Id' required id='ide' name='tid'>" +
    "<input type='text' placeholder='Nombre' required id='nombre' name='tnombre'>" +
    "<input type='text' placeholder='Apellidos' required id='apellido' name='tape'>" +
    "<input type='number' placeholder='Edad' required id='edad' name='tedad'>"+
    "<input type='number' placeholder='Telefono' required id='telefono' name='ttelefono'>"+
    "<input type='email' placeholder='Correo' required id='email' name='temail'> " +
    "<input type='submit' name='accion' value='Agregar' id='boton'>"+
    "</form>";
    divAnadir[0].appendChild(divCrearPersona);
}



