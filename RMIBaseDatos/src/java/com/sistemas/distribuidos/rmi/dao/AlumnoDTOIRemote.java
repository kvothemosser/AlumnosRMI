/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.dao;

import com.sistemas.distribuidos.rmi.dto.AlumnoDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author mtapiat
 */
public interface AlumnoDTOIRemote extends Remote {

    public int save(AlumnoDTO alumnoDTO) throws RemoteException;

    public int update(AlumnoDTO alumnoDTO) throws RemoteException;

    public int delete(AlumnoDTO alumnoDTO) throws RemoteException;

    public void deleteAll() throws RemoteException;

    public List<AlumnoDTO> findAll() throws RemoteException;

    public List<AlumnoDTO> findByMatricula(String criteria) throws RemoteException;
}
