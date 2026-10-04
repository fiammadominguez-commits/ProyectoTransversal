/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Cursada {
    private int idCursada;
    private int idAlumno;
    private int idMateria;
    private float nota;
    private float asist;
    private int cursa;   // año lectivo

    public Cursada() {
    }

    public Cursada(int idAlumno, int idMateria, float nota, float asist, int cursa) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
        this.asist = asist;
        this.cursa = cursa;
    }

    public Cursada(int idCursada, int idAlumno, int idMateria, float nota, float asist, int cursa) {
        this.idCursada = idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
        this.asist = asist;
        this.cursa = cursa;
    }

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getAsist() {
        return asist;
    }

    public void setAsist(float asist) {
        this.asist = asist;
    }

    public int getCursa() {
        return cursa;
    }

    public void setCursa(int cursa) {
        this.cursa = cursa;
    }

    @Override
    public String toString() {
        return "Cursada{" +
                "idCursada=" + idCursada +
                ", idAlumno=" + idAlumno +
                ", idMateria=" + idMateria +
                ", nota=" + nota +
                ", asist=" + asist +
                ", cursa=" + cursa +
                '}';
    }
}
