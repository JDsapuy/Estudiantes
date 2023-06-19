package com.example.proyecto.springboot.Entidad;


public class estudiantes {

    public int codigo;
    public String nombre;
    public String apellido;
    public String curso;
    public double nota1;
    public double nota2;
    public double nota3;
    public double promedio;
    public boolean aprobado;

    public estudiantes(int codigo, String nombre, String apellido, String curso, double nota1, double nota2, double nota3) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }


    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }


    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public int getcodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = Integer.parseInt(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    public double getPromedio() {
        return (nota1+nota2+nota3)/3;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isAprobado(){
        if(getPromedio()>3){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "estudiantes{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", curso='" + curso + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", promedio=" + promedio +
                '}';
    }
}


