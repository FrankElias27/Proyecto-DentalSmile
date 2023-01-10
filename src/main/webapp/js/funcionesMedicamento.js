$(document).ready(function () {
    $("tr #deleteMe").click(function (e) {
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
                        eliminarMedicamento(cod);
                        swal("Eliminado!", "El medicamento se ha eliminado", "success");
                        setTimeout(function () {
                            parent.location.href = "srvMedicamento?accion=listarMedicamentos"
                        }, 1800);
                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                    }
                });
    });

    function eliminarMedicamento(cod) {
        var url = "srvMedicamento?accion=eliminarMedicamento&cod=" + cod;
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


