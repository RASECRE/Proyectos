let playlistId; // almacena el id 
let videos; //almacena los datos

async function connect(){

  //comprueba que no este vacio el campo
  if(!playlistId){
    alert('Ingrese un ID, por favor.');// alerta para avisar que no se proporciono el id
    return;
  }
  
  await fetch(`https://content.googleapis.com/youtube/v3/playlistItems?playlistId=${playlistId}&maxResults=50&part=id,snippet&key=AIzaSyChOPhn7jrHmLNnOXUNi1OebC2JxSV3qvA`)
  .then(response => response.json())
  .then(data => {
    videos = data.items;
    console.log(videos);
    let elementoLista = $('#lista');
    elementoLista.empty(); // vaciar la lista de reproduccion cada nueva busqueda
    elementoLista.append(`<ol>${videos.map((video) => {const thumbnail = video.snippet.thumbnails && video.snippet.thumbnails.default;const thumbnailUrl = thumbnail ? thumbnail.url : '';return `<li><img src="${thumbnailUrl}">${video.snippet.title}</li>`;})}</ol>`);

    let elementosLista = elementoLista.find('li');

    //seleccionar cada uno de los elementos de la lista y que se reproduzca
    elementosLista.each(function(index) {//tener que cada elemento pueda ser seleccionado 
        $(this).on('click', function() {
            srcID(videos[index].snippet.resourceId.videoId);
            $('#tituloVideo').text(videos[index].snippet.title);// actualizar el titulo del video reproducido
        });
    });
    srcID(videos[0].snippet.resourceId.videoId);
    $('#tituloVideo').text(videos[0].snippet.title);
    document.getElementById('lista').style.display = 'block';//mostrar lista del playlist
    document.getElementById('videoInfo').style.display = 'block';
  })
  .catch(error => {
    console.error('Se produjo un error:', error);//mostrar algun error en la consola
    alert("ID incorrecto favor de ingresar un dato valido.")
  });
}

 //funcion de boton para buscar con ID
function busqueda(){
  const intputID = document.getElementById('EspacioDeBusqueda').value;
  playlistId = intputID;
  document.getElementById('EspacioDeBusqueda').value = ''; //limpiar los datos puestos en el espacio de busqueda
  console.log(intputID);//mostrar en la consola el id
  connect();
  console.log(playlistId);
}

function srcID(videoId){
  const iframeID = document.getElementById('iframeID');
  iframeID.src = `https://www.youtube.com/embed/${videoId}?autoplay=1`
}
