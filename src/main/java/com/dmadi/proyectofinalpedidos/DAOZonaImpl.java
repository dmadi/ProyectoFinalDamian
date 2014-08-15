/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmadi.proyectofinalpedidos;

import static com.dmadi.proyectofinalpedidos.DAO.close;
import static com.dmadi.proyectofinalpedidos.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author Damian
 */
public class DAOZonaImpl extends DAO{
    
    
    public void agregarZona(Zona zona) {
    begin();
    getSession().save(zona);
    commit();
    close();
    
    }
 
       /**
        * 
        * @return Este metodo nos regresa todos las zonas
        */
    public ArrayList<Zona> buscarTodasZona() {
        begin();
        Query q = getSession().createQuery("from Zona");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Zona> zonas = (ArrayList<Zona>)q.list();
        commit();
        close();
         
return zonas; 
        
      
    }
    /**
     * Este metodo borra una zona
     * @param p Se le debe pasar un parametro de tipo zona para ser borrado
     */
 public void borrarZona(Zona p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un zona por medio de su Id
         * @param id Este parametro es el Id de la zona  que se quiere buscar
         * @return El tipo de retorno es la zona buscada
         */
  public Zona buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Zona where id = :id_zona");
        q.setInteger("id_zona",id);
        Zona p = (Zona)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
  public String ActualizarZona(Zona e){
        String mensaje="Actualizado correctamente";
        begin();
   getSession().update(e);
   commit();
   close();
   
        
        return mensaje;
    }
}
