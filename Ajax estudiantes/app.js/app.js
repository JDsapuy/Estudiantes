$(document).ready(function() {
    obtenerEstudiantes();
    obtenerEstudianteMayorPromedio();

    $('#estudiante-form').submit(function(event) {
        event.preventDefault();
        agregarEstudiante();
    });

    function obtenerEstudiantes() {
        $.ajax({
            url: 'http://localhost:8080/listaestudiantes',
            type: 'GET',
            success: function(estudiantes) {
                mostrarEstudiantes(estudiantes);
            }
        });
    }

    function agregarEstudiante() {
        var nuevoEstudiante = {
            codigo: $('#codigo-input').val(),
            nombre: $('#nombre-input').val(),
            apellido: $('#apellido-input').val(),
            curso: $('#curso-input').val(),
            nota1: parseFloat($('#nota1-input').val()),
            nota2: parseFloat($('#nota2-input').val()),
            nota3: parseFloat($('#nota3-input').val())
        };

        var codigoExistente = false;
        $.ajax({
            url: 'http://localhost:8080/listaestudiantes',
            type: 'GET',
            async: false,
            success: function(estudiantes) {
                estudiantes.forEach(function(estudiante) {
                    if (estudiante.codigo === nuevoEstudiante.codigo) {
                        codigoExistente = true;
                    }
                });
            }
        });

        if (codigoExistente) {
            alert('Ya existe un estudiante con el mismo código. Introduce un código único.');
            return;
        }

        $.ajax({
            url: 'http://localhost:8080/insertarestudiante',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(nuevoEstudiante),
            success: function() {
                obtenerEstudiantes();
                obtenerEstudianteMayorPromedio();
                limpiarFormulario();
            }
        });
    }

    function limpiarFormulario() {
        $('#codigo-input').val('');
        $('#nombre-input').val('');
        $('#apellido-input').val('');
        $('#curso-input').val('');
        $('#nota1-input').val('');
        $('#nota2-input').val('');
        $('#nota3-input').val('');
    }

    function mostrarEstudiantes(estudiantes) {
        var estudiantesList = $('#estudiantes-list');
        estudiantesList.empty();

        estudiantes.forEach(function(estudiante) {
            var listItem = $('<li>').text(estudiante.codigo + ' ' + estudiante.nombre + ' ' + estudiante.apellido + ' - Promedio: ' + estudiante.promedio);
            estudiantesList.append(listItem);
        });
    }

    function obtenerEstudianteMayorPromedio() {
        $.ajax({
            url: 'http://localhost:8080/mayor-promedio',
            type: 'GET',
            success: function(estudiante) {
                mostrarEstudianteMayorPromedio(estudiante);
            }
        });
    }

    function mostrarEstudianteMayorPromedio(estudiante) {
        var mayorPromedioInfo = $('#mayor-promedio-info');

        if (estudiante) {
            mayorPromedioInfo.text('Estudiante con Mayor Promedio: ' + estudiante.nombre + ' ' + estudiante.apellido + ' - Promedio: ' + estudiante.promedio);
        } else {
            mayorPromedioInfo.text('No hay estudiantes registrados');
        }
    }
});