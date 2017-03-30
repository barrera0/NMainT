$(document).ready(function () {

    validarRegistro();
    vistaRegistro();
    vistaActualizarRegistro();
    eliminarFila();

});

/* Cambiar el nombre del titulo del registro */

function vistaRegistro() {

    $("#registrarEquipo").on("click", function () {
        $("#tituloRegisto").text("Registrar equipo");
        $("#botonRegistro").text("Guardar");


        /* Limpiar formulario */

        $('#registroEquipoFormulario').each(function () {
            this.reset();
        });

        /* Limpiar Validaciones */

        var validator = $("#registroEquipoFormulario").validate();
        validator.resetForm();

        /* Ocultar html de anotacion */

        $("#campoAnotacion").addClass("hidden");

    });

}

/* Cambiar el nombre del titulo del registro - actualizar*/

function vistaActualizarRegistro() {

    $(".botonModificar").on("click", function () {
        $("#tituloRegisto").text("Actualizar informacion del equipo");
        $("#botonRegistro").text("Actualizar");


        /* Limpiar formulario */

        $('#registroEquipoFormulario').each(function () {
            this.reset();
        });

        /* Limpiar Validaciones */

        var validator = $("#registroEquipoFormulario").validate();
        validator.resetForm();

        /* Agregar html de anotacion */

        $("#registroEquipoFormulario").removeClass("hidden");
        $("#campoAnotacion").removeClass("hidden");

    });

}

function validarRegistro() {

    $("#registroEquipoFormulario").validate({
        rules: {
            idEquipo: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            descripcion: {
                required: true,
                minlength: 15,
                maxlength: 50
            },
            serie: {
                required: true,
                minlength: 5,
                maxlength: 10
            },
            estado: {
                required: true
            },
            anotacion: {
                minlength: 15,
                maxlength: 50
            }
        },
        messages: {
            idEquipo: {
                required: "<span style='color: #DD2727'>Por favor ingrese el id del equipo.</span>",
                minlength: "<span style='color: #DD2727'>Minimo 3 caracteres.</span>",
                maxlength: "<span style='color: #DD2727'>Maximo 10 caracteres</span>"
            },
            descripcion: {
                required: "<span style='color: #DD2727'>Por favor ingrese una descripcion del equipo.</span>",
                minlength: "<span style='color: #DD2727'>Minimo 15 caracteres.</span>",
                maxlength: "<span style='color: #DD2727'>Maximo 50 caracteres.</span>"
            },
            serie: {
                required: "<span style='color: #DD2727'>Por favor ingrese una serie del equipo.</span>",
                minlength: "<span style='color: #DD2727'>Minimo 5 caracteres.</span>",
                maxlength: "<span style='color: #DD2727'>Maximo 10 caracteres.</span>"
            },
            estado: {
                required: "<span style='color: #DD2727'>Por favor seleccione un estado.</span>",
                minlength: "<span style='color: #DD2727'>Minimo 5 caracteres.</span>",
                maxlength: "<span style='color: #DD2727'>Maximo 10 caracteres.</span>"
            },
            anotacion: {
                minlength: "<span style='color: #DD2727'>Minimo 15 caracteres.</span>",
                maxlength: "<span style='color: #DD2727'>Maximo 50 caracteres.</span>"
            }
        },
        submitHandler: function () {

            $("#cargaGif").removeClass("hidden");

            alert("Formulario validado");

        }
    });
}

function eliminarFila(){

    $(".btnEliminar").on("click", function(){


        /* Obtener la etiqueta boton btnEliminar */
        
        var fila = $(this);
                swal({
                    title: "Esta serguro?",
                    text: "El registro será eliminado!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "Seguro deseas eliminarlo",
                    cancelButtonText: "Cancelar",
                    closeOnConfirm: false,
                    closeOnCancel: false
                },
                function(isConfirm){
                    if (isConfirm) {
                        console.log($(this));
                        
                        fila.parent().parent().remove();

                        swal("Deleted!", "El registro se elimino", "success");
                    } else {
                        swal("Cancelled", "Se cancelo la funcion", "error");
                    }
                });
    });

}
