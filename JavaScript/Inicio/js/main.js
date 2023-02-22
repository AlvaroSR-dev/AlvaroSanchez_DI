let numero = 0;
let decimal = 3.14;

var nombre = prompt("Introduce tu nombre")

let confirmacion = confirm("¿Quieres mostrar tu nombre?")

if(confirmacion){
    console.log(nombre)
    document.write(nombre)
}else{
    console.log("Rechazado")
    document.write("Rechazado")
}
