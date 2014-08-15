/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmadi.proyectofinalpedidos;

import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author Damian
 */
public class DAOVendedorImpl extends DAO{
    
    public void agregarVendedor(Vendedor vendedor) {
    begin();
    getSession().save(vendedor);
    commit();
    close();
    
    }
 
       /**
        * 
        * @return Este metodo nos regresa todos los vendedores
        */
    public ArrayList<Vendedor> buscarTodosVendedores() {
        begin();
        Query q = getSession().createQuery("from Vendedores");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>)q.list();
        commit();
        close();
         
return vendedores; 
        
      
    }
    /**
     * Este metodo borra un vendedor
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarVendedor(Vendedor p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un vendedor por medio de su Id
         * @param id Este parametro es el Id del vendedor que se quiere buscar
         * @return El tipo de retorno es el vendedor buscado
         */
  public Vendedor buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Vendedor where id = :id_vendedor");
        q.setInteger("id_vendedor",id);
        Vendedor p = (Vendedor)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
  
  public String ActualizarVendedor(Vendedor e){
        String mensaje="Actualizado correctamente";
        begin();
   getSession().update(e);
   commit();
   close();
   
        
        return mensaje;
    }
}
