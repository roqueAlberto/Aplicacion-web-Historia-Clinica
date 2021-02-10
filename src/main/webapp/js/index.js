$(document).ready(function () {
  $("#table_historial").DataTable({
    language: {
      lengthMenu: "Mostrar_MENU_registros",
      sZerorecords: "No se encontraro resultados",
      sEmptyTable: "Ningun dato disponible en la tabla",
      info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
      infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
      infofiltered: "(filtrando de un total de _MAX_ registros)",
      sSearch: "Buscar",
      oPaginate: {
        sFirst: "Primero",
        sLast: "Ultimo",
        sNext: "Siguiente",
        sPrevious: "Anterior",
      },
      sProcessing: "Procesando...",
    },
  });

  $(document).on("click", ".btn-ficha", function (event) {
    var evaluar = document.getElementById("id_p");

    if (evaluar.value == 0) {
      event.preventDefault();
    }
  });

  $(document).on("click", ".btn-guardarconsulta", function (event) {
    var evaluar_consulta = document.getElementById("id_p");

    if (evaluar_consulta.value == 0) {
      event.preventDefault();
    }
  });
});

function realizar_focus() {
  var buscar = document.getElementById("buscar_dni");
  buscar.focus();
}
