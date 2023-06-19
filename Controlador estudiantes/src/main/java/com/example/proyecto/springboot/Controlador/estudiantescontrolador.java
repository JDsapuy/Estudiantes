package com.example.proyecto.springboot.Controlador;
import com.example.proyecto.springboot.Entidad.estudiantes;
import com.example.proyecto.springboot.Servicios.estudiantesservicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class estudiantescontrolador {

    private estudiantesservicio servicio;

    public estudiantescontrolador(estudiantesservicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping("/listaestudiantes")
    public List<estudiantes> listajuegos() {
        return servicio.listaestudiantes();
    }

    @PostMapping("/insertarestudiante")
    public void insertarjuego(@RequestBody estudiantes nuevoestudiante) {
        servicio.agregarestudiante(nuevoestudiante);
    }

    @GetMapping("/mayor-promedio")
    public estudiantes encontrarEstudianteMayorPromedio() {
        return servicio.mostrarEstudianteMayorPromedio();
    }
}
