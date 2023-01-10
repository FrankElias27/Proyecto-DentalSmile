$(document).ready(function () {
    $("tr #deletHi").click(function (e) {
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
                        eliminarHistorial(cod);
                        swal("Eliminado!", "El historial se ha eliminado", "success");
                        setTimeout(function () {
                            parent.location.href = "srvHistorial?accion=listarHistoriales"
                        }, 1800);
                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                    }
                });
    });

    function eliminarHistorial(cod) {
        var url = "srvHistorial?accion=eliminarHistorial&cod=" + cod;
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

