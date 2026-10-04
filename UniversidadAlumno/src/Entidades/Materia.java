/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Materia {
    private int idMateria;
    private String nombre;
    private int estado;

    public Materia() {
    }

    public Materia(String nombre, int estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Materia(int idMateria, String nombre, int estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + 
                "idMateria=" + idMateria + 
                ", nombre=" + nombre + 
                ", estado=" + estado + 
                '}';
    }
}
