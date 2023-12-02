let baseUrl = "http://localhost:8080";
let productos = [];

function ObtenerProductos() {
  fetch(baseUrl + '/productos/all').then(res => {
    res.json().then(json => {
      productos = json
      ImprimirProductos();
    });
  });
}

function ImprimirProductos() {
  let contenedorp = document.getElementById("seccion7");
  contenedorp.innerHTML = `<div class="botonordenes"><span class="plan2"><button class="botoncompra" onclick="VerOrdenes()">Ver Ordenes</button></span></div>
    <div class="botonordenes"><span class="plan2"><button class="botoncompra" onclick="ImpirmirVerificacionAdmin()">Actualizar Inventario</button></span></div>
    <div class="seccion7-cajas" id="seccion7-cajas">
    </div>
    `;

  let contenedor = document.getElementById("seccion7-cajas");
  contenedor.innerHTML = "";
  productos.forEach(producto => {
    contenedor.innerHTML += MappearProducto(producto);
  });
}

function MappearProducto(producto) {
  let id = producto.id;
  return `<div class="seccion7-caja">
    <img src="${producto.foto}" alt="" />
    <p><strong>$${producto.precio}</strong></p>
    <p class="texto-compra">${producto.nombre}<br>Edicion ${producto.edition} <br> Stock: ${producto.stock}</p>
    <span class="plan1"><button class="botoncompra" onclick="MappearPreCompra(${id})">COMPRAR</button></span>
  </div > `
}


function MappearPreCompra(id) {
  let contenedor = document.getElementById("seccion7");
  console.log(id);
  contenedor.innerHTML = `
  <div class="" >
    <h1 class="">Tienes una cuenta? o  continuar como invitado</h1>
    <span class="plan1"><button class="botoncompra" onclick="MappearFormulario(${id})">Ya tengo Usuario</button></span>
    <span class="plan1"><button class="botoncompra" onclick="MappearInvitado(${id})">Continuar como invitado</button></span>
  </div >
    `
}

function MappearInvitado(id) {
  let contenedor = document.getElementById("seccion7");
  let edicion;
  if (id = 1) {
    edicion = "EDICION DELUXE";
  }
  else {
    edicion = "EDICION ESTANDAR";
  }
  contenedor.innerHTML = `
    <div class="contenedorFormulario">
    <h1>Registrar Orden</h1>
    <h2 class="edicion">${edicion}</h2>
    <input type="text" name="usuario" placeholder="Nombre Usuario" id="usuario">
    <input type="text" name="nombre" placeholder="Nombre" id="nombre">
    <input type="text" name="apellido" placeholder="Apellido" id="apellido">
    <input type="text" name="telefono" placeholder="Telefono" id="telefono">
    <input type="number" name="cantidad" placeholder="Cantidad" id="cantidad">
    <input type="text" name="Direccion" placeholder="Direccion" id="direccion">
    <input type="text" name="Pais" placeholder="Pais" id="pais">
    <div class="boton">
      <button onclick="RegistrarPrimeraVez(${id})">Confirmar Compra</button>
    </div>
  </div>`
}

function MappearFormulario(id) {
  let contenedor = document.getElementById("seccion7");
  contenedor.innerHTML = ` <div class="contenedorFormulario">
  <h1>Registrar Orden</h1>
  <input type="text" name="usuario" placeholder="Nombre Usuario" id="usuario">
  <input type="number" name="cantidad" placeholder="Cantidad" id="cantidad">
  <input type="text" name="Direccion" placeholder="Direccion" id="direccion">
  <input type="text" name="Pais" placeholder="Pais" id="pais">
  <div class="boton">
    <button onclick="RegistrarOrdenes(${id})">Confirmar Compra</button>
  </div>
</div>`;
}

function InsertarUsuario() {
  let data = {
    usuario: document.getElementById("usuario").value,
    nombre: document.getElementById("nombre").value,
    apellido: document.getElementById("apellido").value,
    telefono: document.getElementById("telefono").value
  }
  console.log(data);

  fetch(baseUrl + "/cliente", {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json; charset=UTF-8'
    }
  });
}

function RegistrarPrimeraVez(id) {
  InsertarUsuario();
  let data = {
    cliente: document.getElementById("usuario").value,
    productoId: id,
    cantidad: document.getElementById("cantidad").value,
    direccion: document.getElementById("direccion").value,
    pais: document.getElementById("pais").value
  }

  fetch(baseUrl + "/orden", {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json; charset=UTF-8'
    }
  }).then(res => {
    console.log(res);
    ObtenerOrdenes(data.cliente)
  });
}

function RegistrarOrdenes(id) {
  let data = {
    cliente: document.getElementById("usuario").value,
    productoId: id,
    cantidad: document.getElementById("cantidad").value,
    direccion: document.getElementById("direccion").value,
    pais: document.getElementById("pais").value
  }

  fetch(baseUrl + "/orden", {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json; charset=UTF-8'
    }
  }).then(res => {
    console.log(res);
    ObtenerOrdenes(data.cliente)
  });
}

function VerOrdenes() {
  let contenedor = document.getElementById("seccion7");
  contenedor.innerHTML = `<h1>Ingresa Tu Usuario</h1>
  <input type="text" name="usuario" placeholder="Nombre Usuario" id="usuario">
  <button onclick="ObtenerUsuario()">Ingresar</button>`;
}

function ObtenerUsuario() {
  let usuario = document.getElementById("usuario").value;
  ObtenerOrdenes(usuario);
}

function ObtenerOrdenes(cliente) {
  fetch(baseUrl + '/ordenes/' + cliente).then(res => {
    res.json().then(json => {
      ordenes = json
      ImprimirOrdenes();
    });
  });
}

function ImprimirOrdenes() {
  let contenedor = document.getElementById("seccion7");
  contenedor.innerHTML = `<div>
  <h1>Tu Historial de Ordenes</h1>
  <table border="1" id="tablitaorden">
    <tr>
      <th>OrderID</td>
      <th>Cliente</td>
      <th>ProductoID</td>
      <th>Cantidad</td>
      <th>Fecha Compra</td>
      <th>Direccion</td>
      <th>Pais</td>
    </tr>
  </table>
  <br>
  <button onclick="ObtenerProductos()">Volver</button>
  </div>`;
  let contenedor1 = document.getElementById("tablitaorden")

  ordenes.forEach(orden => {
    contenedor1.innerHTML += MappearOrden(orden);
  });
}

function MappearOrden(orden) {
  return `<tr>
  <td>${orden.orderId}</td>
  <td>${orden.cliente}</td>
  <td>${orden.productoId}</td>
  <td>${orden.cantidad}</td>
  <td>${orden.fechaVenta}</td>
  <td>${orden.direccion}</td>
  <td>${orden.pais}</td>
</tr>`
}

function ImpirmirVerificacionAdmin(){
  let contenedor = document.getElementById("seccion7")
  contenedor.innerHTML = `<div>
  <h2>Admin Password</h2>
  <input type="password" name="password" placeholder="Password" id="password">
  <br>
  <button onclick="VerificarAdmin()">confirmar</button>
  <button onclick="ObtenerProductos()">volver</button>
  </div>`
}

function VerificarAdmin(){
  var password="admin33"
  var prueba=document.getElementById("password").value
  if (prueba==password){
    ImprimirActualizarStock();
  }else{
    alert("contraseña incorrecto")
  }
}

function ImprimirActualizarStock(){
  let contenedorp = document.getElementById("seccion7");
  contenedorp.innerHTML = `
  <div class="botonordenes"><span class="plan2"><button class="botoncompra" onclick="ObtenerProductos()">Regresar</button></span></div>
    <div class="seccion7-cajas" id="seccion7-cajas">
    </div>
    `;

  let contenedor = document.getElementById("seccion7-cajas");
  contenedor.innerHTML = "";
  productos.forEach(producto => {
    contenedor.innerHTML += MappearActualizarProducto(producto);
  });
}

function MappearActualizarProducto(producto) {
  let id = producto.id;
  return `<div class="seccion7-caja">
    <img src="${producto.foto}" alt="" />
    <p><strong>$${producto.precio}</strong></p>
    <p class="texto-compra">${producto.nombre}<br>Edicion ${producto.edition} <br> 
    <input type="number" name="stock" placeholder="stock" id="stock${id}"></p>
    <span class="plan1"><button class="botoncompra" onclick="ActualizarStock(${id})">ACTUALIZAR</button></span>
  </div > `
}

function ActualizarStock(productoid){
  let data={
    id: productoid,
    stock: document.getElementById("stock"+productoid).value
  }

  console.log(data)

  fetch(baseUrl + "/producto", {
    method: 'PUT',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json; charset=UTF-8'
    }
  }).then(res => {
    console.log(res);
    ObtenerProductos()
  });
}