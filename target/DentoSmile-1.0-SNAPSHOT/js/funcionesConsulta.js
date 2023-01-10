$(document).ready(function () {
    $("tr #deleteConsul").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();
        swal({
            title: "Esta Seguro de Eliminar?",
            text: "Una vez eliminado deberá agregar de nuevo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sí, Eliminar!",
            cancelButtonText: "No, Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarConsulta(cod);
                        swal("Eliminado!", "La consulta se ha eliminado", "success");
                        setTimeout(function () {
                            parent.location.href = "srvConsulta?accion=listarConsultas"
                        }, 1800);
                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                    }
                });
    });

    function eliminarConsulta(cod) {
        var url = "srvConsulta?accion=eliminarConsulta&cod=" + cod;
        console.log("eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {

            }
        });
    }
});

function AbrirModalRegistro(){
    $("#modal_registro").modal({backdrop:'static',keyboard:false});
    $("#modal_registro").modal('show');
}












