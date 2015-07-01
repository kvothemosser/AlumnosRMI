/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.server;

import com.sistemas.distribuidos.rmi.dao.AlumnoDTOObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author mtapiat
 */
public class AlumnoDTOServer {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            AlumnoDTOObject po = new AlumnoDTOObject();
            registry.rebind("AlumnoDTO", po);
            System.out.println("AlumnoDTOServer ha sido creado!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
