/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udistrital.zuma.sessionBean;

import edu.udistrital.zuma.entityBean.Codigo;
import edu.udistrital.zuma.entityBean.EstadoCodigo;
import edu.udistrital.zuma.entityBean.TipoCodigo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon
 */
@Stateless
public class CodigoFacade extends AbstractFacade<Codigo> implements CodigoFacadeLocal {

    @PersistenceContext(unitName = "Zuma-UDistrital-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigoFacade() {
        super(Codigo.class);
    }

    @Override
    public Codigo actualizarCodigoQR(int idCodigo, String nombre, String descripcion, int estado, int tipo) {
        try {
            Codigo codigo = em.find(Codigo.class, idCodigo);
            if (codigo != null) {
                codigo.setCodigoNombre(nombre);
                codigo.setCodigoDescripcion(descripcion);
                codigo.setEstadoCodigoId(em.find(EstadoCodigo.class, estado));
                codigo.setTipoCodigoId(em.find(TipoCodigo.class, tipo));
                return codigo;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean eliminarCodigoPorId(int idCodigo) {
        try {
            em.remove(em.find(Codigo.class, idCodigo));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String guardarCodigoEnServidor(String nombre, byte[] bytesArchivo) {
        try {
            String ruta = "C:\\Codigos\\" + getComplementoNombreArhivo()+nombre;
            FileOutputStream fileOuputStream = new FileOutputStream(ruta);
            fileOuputStream.write(bytesArchivo);
            fileOuputStream.close();
            return ruta;
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException ex) {
            return "";
        }
    }

    private String getComplementoNombreArhivo() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH); // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);
        return ""+year+month+day+hour+minute+second+millis;
    }

    @Override
    public Codigo crearNuevoCodigo(int idEstado, int idTipo, String nombre, String descripcion, String ruta){
        try {
            Codigo nuevoCodigo = new Codigo();
            nuevoCodigo.setEstadoCodigoId(em.find(EstadoCodigo.class, idEstado));
            nuevoCodigo.setTipoCodigoId(em.find(TipoCodigo.class, idTipo));
            nuevoCodigo.setCodigoNombre(nombre);
            nuevoCodigo.setCodigoDescripcion(descripcion);
            nuevoCodigo.setCodigoRutaImagen(ruta);
            em.persist(nuevoCodigo);
            return nuevoCodigo;
        } catch (Exception e) {
            return null;
        }
    }
    
}
