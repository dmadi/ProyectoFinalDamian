/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmadi.proyectofinalpedidos;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Damian
 */
@Controller
@RequestMapping("/")
public class ControladorZona {
    @RequestMapping(value="/zona/{nombre}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable String nombre){
           DAOZonaImpl d= new DAOZonaImpl();
           d.agregarZona(new Zona(nombre));
           return "Zona guardada con exito";
    }
    
    @RequestMapping(value="/zona", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOZonaImpl d=new DAOZonaImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodasZona());
    }
    
}
