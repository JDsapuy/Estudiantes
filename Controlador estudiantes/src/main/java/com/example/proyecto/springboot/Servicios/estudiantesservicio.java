package com.example.proyecto.springboot.Servicios;
import java.util.ArrayList;
import java.util.List;

import com.example.proyecto.springboot.Entidad.estudiantes;
import org.springframework.stereotype.Service;

@Service
public class estudiantesservicio {

    // Crear ArrayList de estudiantes
    ArrayList<estudiantes> estudiantesarray = new ArrayList<>();

    public estudiantesservicio() {
        // Agregar estudiantes al ArrayList
        estudiantesarray.add(new estudiantes(1, "Juan", "Perez", "Curso A", 3.5f, 4.7f, 2.8f));
        estudiantesarray.add(new estudiantes(2, "Maria", "Gomez", "Curso B", 2.2, 3.5, 4.1));
        estudiantesarray.add(new estudiantes(3, "Carlos", "Lopez", "Curso A", 4.8, 1.9, 4.3));
        estudiantesarray.add(new estudiantes(4, "Laura", "Fernandez", "Curso C", 2.9, 3.1, 2.5));
        estudiantesarray.add(new estudiantes(5, "Pedro", "Rodriguez", "Curso B", 2.6, 4.3, 1.9));
        estudiantesarray.add(new estudiantes(6, "Andrea", "Gonzalez", "Curso C", 4.9, 3.1, 4.5));
        // Recorrer el ArrayList de estudiantes
    }
        public List<estudiantes> listaestudiantes() {return estudiantesarray;}

    public void agregarestudiante(estudiantes nuevoestudiante) {
        boolean codigoExistente = false;
        for (estudiantes v : estudiantesarray) {
            if (v.getcodigo() == nuevoestudiante.getcodigo()) {
                codigoExistente = true;
                break;
            }
        }
        if (codigoExistente) {
            System.out.println("El código " + nuevoestudiante.getcodigo() + " ya existe en la lista de estudiantes.");
        } else {
            estudiantesarray.add(nuevoestudiante);
            System.out.println("El estudiante " + nuevoestudiante.getNombre() + " ha sido agregado a la lista de estudiantes.");
        }
    }



    private int getcodigo() {
        return 0;
    }

   public estudiantes mostrarEstudianteMayorPromedio() {
        double mayorPromedio = 0.0;
        estudiantes estudianteMayorPromedio = null;
        for (estudiantes e : estudiantesarray) {
            double promedio=e.getPromedio();
            if (promedio > mayorPromedio) {
                mayorPromedio = promedio;
                estudianteMayorPromedio = e;
            }
        }
        return  estudianteMayorPromedio;
   }

}


















