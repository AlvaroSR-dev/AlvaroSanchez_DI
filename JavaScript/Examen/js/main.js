let urlMonedas = "https://run.mocky.io/v3/16f71bfa-7bee-476f-ab6b-71348547a9d3";
let urlDatos = "https://api.coingecko.com/api/v3/coins/"
let select = document.getElementById('select');
let card = document.getElementsByClassName('card');
let name = document.getElementById('name');
let description = document.getElementById('description');
let link = document.getElementById('link');
let list = document.getElementById('list');
let favourite = document.getElementById('favourite');

var objetoMoneda = { id: "", symbol: "", name: "" };
var objetoDetalles = { name: "", description: "", links: "", categories: "" };
var monedaSeleccion = objetoMoneda;
let arrayMonedas = {};

// leer json con los nombres de las monedas 

fetch(urlMonedas)
    .then((res) => {
        return res.json();
    })
    .then((res) => {
        console.log(res);
        // objeto moneda para leer el json y transformar los datos en objetos
        arrayMonedas = res;

        res.forEach(element => {
            objetoMoneda = element;
            //console.log(objetoMoneda.name);
            // agregar monedas al select
            select.innerHTML += `<option value="${objetoMoneda.name}">${objetoMoneda.name}</option>`;
        });
    })
    .catch((rej) => {
        console.log(`Ha habido algún tipo de fallo: ${rej}`);
    });

// rellenar datos de la moneda


select.addEventListener("change", function () {
    var id = "";
    console.log(select.value);

    arrayMonedas.forEach(element => {
        if (select.value == element.name) {
            id = element.id;
            monedaSeleccion = element;
            console.log(`id: ${id}`);
        }
    })

    fetch(urlDatos + id)
        .then((res) => {
            return res.json();
        })
        .then((res) => {
            console.log(res);
            card.innerHTML = `
            <div class="card-body">
                <h5 class="card-title" id="name">${res.name}</h5>
                <p class="card-text" id="description"></p>
                <a class="btn btn-primary" href="${res.links[0]}" role="button" id="link" target="_blank">Link</a>
                <ul class="list-group" id="list">
                </ul>
                <button class="btn btn-primary" type="submit" id="favourite">Favoritos</button>
            </div>
            `
            list.innerHTML = ``;
            res.categories.forEach(element => {
                list.innerHTML += `<li class="list-group-item">${element}</li>`;
            })
             
            console.log(res.description.es);
            
            res.description.forEach(element => {
                if(element == "es"){
                    description.innerHTML = element;
                }
            })
        })
        .catch((rej) => {
            console.log(`Ha habido algún tipo de fallo: ${rej}`);
        });
})
