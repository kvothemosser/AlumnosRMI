/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.dao;

import com.sistemas.distribuidos.rmi.dto.AlumnoDTO;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Moises Tapia Tellez
 */
public class AlumnoDTOObject extends UnicastRemoteObject implements AlumnoDTOIRemote {

    public AlumnoDTOObject() throws RemoteException {
        super();
    }

    @Override
    public int save(AlumnoDTO alumnoDTO) throws RemoteException {
        try {
            System.out.println("Invocacion de save desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return AlumnoDTORepository.save(alumnoDTO);
    }

    @Override
    public int update(AlumnoDTO alumnoDTO) throws RemoteException {
        try {
            System.out.println("Invocacion de update desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return AlumnoDTORepository.update(alumnoDTO);
    }

    @Override
    public int delete(AlumnoDTO alumnoDTO) throws RemoteException {
        try {
            System.out.println("Invocacion de delete desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return AlumnoDTORepository.delete(alumnoDTO);
    }

    @Override
    public void deleteAll() throws RemoteException {
        try {
            System.out.println("Invocacion de deleteAll desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        AlumnoDTORepository.deleteAll();
    }

    @Override
    public List<AlumnoDTO> findAll() throws RemoteException {
        try {
            System.out.println("Invocacion de findAll desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return AlumnoDTORepository.findAll();
    }

    @Override
    public List<AlumnoDTO> findByMatricula(String criteria) throws RemoteException {
        try {
            System.out.println("Invocacion de findByName desde " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return AlumnoDTORepository.findByMatricula(criteria);
    }
}
