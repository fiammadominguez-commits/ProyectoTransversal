/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Alumno {
    private int idAlumno;
    private int dni;
    private String nombre;
    private java.sql.Date fecNac;
    private boolean activo;

    public Alumno() {
    }

    public Alumno(int dni, String nombre, java.sql.Date fecNac, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public Alumno(int idAlumno, int dni, String nombre, java.sql.Date fecNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.sql.Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(java.sql.Date fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno{" + 
                "idAlumno=" + idAlumno + 
                ", dni=" + dni + 
                ", nombre=" + nombre + 
                ", fecNac=" + fecNac + 
                ", activo=" + activo + 
                '}';
    }
}
