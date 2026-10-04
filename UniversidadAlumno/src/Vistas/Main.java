/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Persistencia.miConexion;
import Persistencia.AlumnoData;
import Persistencia.MateriaData;
import Persistencia.CursadaData;

import Entidades.Alumno;
import Entidades.Materia;
import Entidades.Cursada;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

      
        //   1. CREAR LA CONEXIÓN
     
        miConexion conexion = new miConexion( "jdbc:mariadb://localhost:3306/universidad", "root", "" );

    
        //   2. CREAR LOS DAO
      
        AlumnoData alumnoData = new AlumnoData(conexion);
        MateriaData materiaData = new MateriaData(conexion);
        CursadaData cursadaData = new CursadaData(conexion);

      
        //   3. GUARDAR ALUMNO
      
        Alumno alumno = new Alumno(
                28180533,
                "Laura Dalma",
                Date.valueOf("1999-04-07"),
                true
        );

        alumnoData.guardarAlumno(alumno);
        System.out.println("Alumno guardado con ID: " + alumno.getIdAlumno());

        // Buscarlo nuevamente
        Alumno alumnoBuscado = alumnoData.buscarAlumno(alumno.getIdAlumno());
        System.out.println("Alumno encontrado: " + alumnoBuscado);

        //   4. GUARDAR MATERIA
      
        Materia materia = new Materia("Programación I", 1);
        materiaData.guardarMateria(materia);

        //   5. GUARDAR CURSADA
       
        Cursada cursada = new Cursada(
                alumno.getIdAlumno(),
                1,          // idMateria (si es la primera materia guardada)
                9.5f,       // nota
                95f,        // asistencia
                2026        // año
        );

        cursadaData.guardarCursada(cursada);

        //   6. FINAL
       
        System.out.println("Sistema funcionando correctamente.");
        System.out.println("Lista de alumnos");
        List<Alumno> alumnos = alumnoData.listarAlumnos();
        alumnos.forEach(System.out::println);

        System.out.println("Lista de materias");
        List<Materia> materias = materiaData.listarMaterias();
        materias.forEach(System.out::println);

        System.out.println("Lista de cursadas");
        List<Cursada> cursadas = cursadaData.listarCursadas();
        cursadas.forEach(System.out::println);

      }
        }
