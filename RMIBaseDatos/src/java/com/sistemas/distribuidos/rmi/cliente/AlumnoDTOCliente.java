/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.cliente;

import com.sistemas.distribuidos.rmi.dao.AlumnoDTOIRemote;
import com.sistemas.distribuidos.rmi.dto.AlumnoDTO;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author Moisés Tapia Téllez.
 */
public class AlumnoDTOCliente {

    public static void main(String[] args) {
        try {
            //Get reference to rmi registry server
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");

            //Lookup server object
            AlumnoDTOIRemote rp = (AlumnoDTOIRemote) registry.lookup("AlumnoDTO");

            //Save province
            AlumnoDTO alumno1 = new AlumnoDTO(1, "Moises", "Tapia", "Tellez", "204304458", "S");
            AlumnoDTO alumno2 = new AlumnoDTO(2, "Perfecto", "Ladron", "Honrado", "204304450", "S");
            AlumnoDTO alumno3 = new AlumnoDTO(3, "Ramona", "Ponte", "Alegre", "204304451", "B");
            AlumnoDTO alumno4 = new AlumnoDTO(4, "Eva", "Fina", "Segura", "204304452", "MB");
            AlumnoDTO alumno5 = new AlumnoDTO(5, "Margarita", "Flores", "Del Campo", "204304453", "NA");
            AlumnoDTO alumno6 = new AlumnoDTO(6, "Alberto", "Camino", "Grande", "204304448", "S");
            AlumnoDTO alumno7 = new AlumnoDTO(7, "Sandalio", "Botin", "Descalzo", "204304488", "MB");

            //Save province
            System.out.println("Guardando Alumnos");
            rp.save(alumno1);
            rp.save(alumno2);
            rp.save(alumno3);
            rp.save(alumno4);
            rp.save(alumno5);
            rp.save(alumno6);
            rp.save(alumno7);

            //Update province
            System.out.println("Actualizando a Sandalio");
            AlumnoDTO updateAlumno7 = new AlumnoDTO(7, "Sandalio", "Zapata", "Descalzo", "204304488", "MB");
            int iRet = rp.update(updateAlumno7);

            //Display all provinces
            System.out.println("Mostrar todos los registros");
            List<AlumnoDTO> arrProv = rp.findAll();
            for (AlumnoDTO alumnoDTO : arrProv) {
                System.out.println(alumnoDTO.toString());
            }

            //Delete Kampong Cham
            System.out.println("Borrando Alberto");
            rp.delete(alumno6);

            //Display province starts by "Kam"
            System.out.println("Mostrando Matriculas por 20430445");
            arrProv = rp.findByMatricula("20430445");
            for (AlumnoDTO alumnoDTO : arrProv) {
                System.out.println(alumnoDTO.toString());
            }

            //Delete all provinces
            System.out.println("Borrando todos los alumnos");
            rp.deleteAll();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
