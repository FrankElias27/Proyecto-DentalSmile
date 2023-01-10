$(document).ready(function () {
    $("tr #deletFu").click(function (e) {
        e.preventDefault();
        var cod1 = $(this).parent().find('#codigoFu').val();
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
                        eliminarFua(cod1);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function () {
                            parent.location.href = "srvHistorial?accion=listarHistoriales"
                        }, 1800);
                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                    }
                });
    });

    function eliminarFua(cod1) {
        var url = "srvFua?accion=eliminarFua&cod=" + cod1;
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
