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
public class DAOPedidosImpl extends DAO{
    
    public void agregarPedido(Pedidos pedido) {
    begin();
    getSession().save(pedido);
    commit();
    close();
    
    }
 
       /**
        * 
        * @return Este metodo nos regresa todos los pedidos
        */
    public ArrayList<Pedidos> buscarTodosPedidos() {
        begin();
        Query q = getSession().createQuery("from Pedidos");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Pedidos> pedidos = (ArrayList<Pedidos>)q.list();
        commit();
        close();
         
return pedidos; 
        
      
    }
    /**
     * Este metodo borra un pedido
     * @param p Se le debe pasar un parametro de tipo pedido para ser borrado
     */
 public void borrarPedido(Pedidos p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un pedido por medio de su Id
         * @param id Este parametro es el Id del pedido que se quiere buscar
         * @return El tipo de retorno es el pedido buscado
         */
  public Pedidos buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Pedidos where id = :id_pedidos");
        q.setInteger("id_pedidos",id);
        Pedidos p = (Pedidos)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
  
  public String ActualizarPedido(Pedidos e){
        String mensaje="Actualizado correctamente";
        begin();
   getSession().update(e);
   commit();
   close();
   
        
        return mensaje;
    }
}
