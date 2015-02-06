/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Codigo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon
 */
@Local
public interface CodigoFacadeLocal {

    void create(Codigo codigo);

    void edit(Codigo codigo);

    void remove(Codigo codigo);

    Codigo find(Object id);

    List<Codigo> findAll();

    List<Codigo> findRange(int[] range);

    int count();
    
    Codigo actualizarCodigoQR(int idCodigo, String nombre,String descripcion, int estado, int tipo);
    
    boolean eliminarCodigoPorId(int idCodigo);
    
    String guardarCodigoEnServidor(String nombre, byte[] bytesArchivo);
    
    Codigo crearNuevoCodigo(int idEstado, int idTipo, String nombre, String descripcion, String ruta);
    
}
