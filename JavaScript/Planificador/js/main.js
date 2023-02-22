let datos = {
    "notas":[
        {
            "fecha": "10-01-2023",
            "titulo": "DI",
            "descripcion": "Desarrollo de Interfaces",
            "completa":  true,
            "tareas": ["Java", "JavaFX", "JavaScript"]
        },
        {
            "fecha": "10-01-2023",
            "titulo": "PMDM",
            "descripcion": "Programación Multimedia en Dispositivos Móviles",
            "completa":  true,
            "tareas": ["Kotlin", "Android"]
        },
        {
            "fecha": "10-01-2023",
            "titulo": "PSP",
            "descripcion": "Programación de Servicios y Procesos",
            "completa":  false,
            "tareas": ["Java", "Powershell", "Linux", "Windows"]
        },
        {
            "fecha": "10-01-2023",
            "titulo": "SGE",
            "descripcion": "Sistemas de Gestión Empresarial",
            "completa":  false,
            "tareas": ["Odoo", "Canva"]
        },
        {
            "fecha": "10-01-2023",
            "titulo": "AD",
            "descripcion": "Acceso a Datos",
            "completa":  false,
            "tareas": ["Python"]
        }
    ]
};

let row = document.getElementById("row");

function agregar(nota){
    row.innerHTML = row.innerHTML + `<div class="col">
    <div class="card" style="width: 18rem">
      <img src="..." class="card-img-top" alt="..." />
      <div class="card-body">
        <h5 class="card-title">${nota.titulo}</h5>
        <p class="card-text">
          ${nota.descripcion}
        </p>
        <ul>
          <li>${nota.tareas}</li>
        </ul>
        <h6>${nota.fecha}</h6>
      </div>
    </div>
  </div>`
}

datos.forEach(element => {
    agregar(element);
});