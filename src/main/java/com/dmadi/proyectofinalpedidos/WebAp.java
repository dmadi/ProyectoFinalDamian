/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmadi.proyectofinalpedidos;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Damian
 */
public class WebAp extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings(){
      return new String[]{
          "/servicios/*"
      } ; 
    }
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[0];
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebApConfig.class};
 }
}
