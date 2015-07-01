/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.dao;

import com.sistemas.distribuidos.rmi.dto.AlumnoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mtapiat
 */
public class AlumnoDTORepository {

    public static int save(AlumnoDTO alumnoDTO) {
        int iRet = -1;
        try {
            Connection con = DataBaseManager.getInstance().getConnection();
            String SQL = "INSERT INTO Alumno(id, nombre, apellidoPaterno, apellidoMaterno, matricula, calificacion) Values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, alumnoDTO.getId());
            pstmt.setString(2, alumnoDTO.getNombre());
            pstmt.setString(3, alumnoDTO.getApellidoPaterno());
            pstmt.setString(4, alumnoDTO.getApellidoMaterno());
            pstmt.setString(5, alumnoDTO.getMatricula());
            pstmt.setString(6, alumnoDTO.getNombre());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static int update(AlumnoDTO alumnoDTO) {
        int iRet = -1;
        try {
            Connection con = DataBaseManager.getInstance().getConnection();
            String SQL = "UPDATE Alumno SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, matricula=?, calificacion=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, alumnoDTO.getNombre());
            pstmt.setString(2, alumnoDTO.getApellidoPaterno());
            pstmt.setString(3, alumnoDTO.getApellidoMaterno());
            pstmt.setString(4, alumnoDTO.getMatricula());
            pstmt.setString(5, alumnoDTO.getNombre());
            pstmt.setInt(6, alumnoDTO.getId());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static int delete(AlumnoDTO alumnoDTO) {
        int iRet = -1;
        try {
            Connection con = DataBaseManager.getInstance().getConnection();
            String SQL = "DELETE FROM Alumno WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, alumnoDTO.getId());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return iRet;
    }

    public static void deleteAll() {
        Connection con = DataBaseManager.getInstance().getConnection();
        try {
            con.setAutoCommit(false);
            String SQL = "DELETE FROM Alumno";
            PreparedStatement pstmt = con.prepareStatement(SQL);

            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException se) {
            try {
                con.rollback();
            } catch (SQLException ise) {
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException fse) {
            }
        }
    }

    public static List<AlumnoDTO> findAll() {
        List<AlumnoDTO> arr = new ArrayList<AlumnoDTO>();

        try {
            String QRY = "SELECT * FROM Alumno ORDER BY Id";
            Connection con = DataBaseManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                AlumnoDTO alumnoDTO = new AlumnoDTO();
                alumnoDTO.setId(rs.getInt("id"));
                alumnoDTO.setNombre(rs.getString("nombre"));
                alumnoDTO.setApellidoPaterno(rs.getString("apellidoPaterno"));
                alumnoDTO.setApellidoMaterno(rs.getString("apellidoMaterno"));
                alumnoDTO.setMatricula(rs.getString("matricula"));
                alumnoDTO.setCalificacion(rs.getString("calificacion"));
                arr.add(alumnoDTO);
            }

            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return arr;
    }

    public static ArrayList findByMatricula(String name) {
        ArrayList arr = new ArrayList();

        try {
            String QRY = "SELECT * FROM Alumno WHERE matricula LIKE(?) ORDER BY id";
            Connection con = DataBaseManager.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(QRY);
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AlumnoDTO alumnoDTO = new AlumnoDTO();
                alumnoDTO.setId(rs.getInt("id"));
                alumnoDTO.setNombre(rs.getString("nombre"));
                alumnoDTO.setApellidoPaterno(rs.getString("apellidoPaterno"));
                alumnoDTO.setApellidoMaterno(rs.getString("apellidoMaterno"));
                alumnoDTO.setMatricula(rs.getString("matricula"));
                alumnoDTO.setCalificacion(rs.getString("calificacion"));
                arr.add(alumnoDTO);
            }

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return arr;
    }

}
