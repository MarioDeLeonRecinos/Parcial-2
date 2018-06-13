/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AbstractFactory.Razas.Elfos;
import Enums.NombresUnidades;
import UnidadesYCosto.unidad;

/**
 *
 * @author mcdre
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Elfos NElfo = new Elfos();
        NElfo.soldado(2,1);
        NElfo.vehiculo1(2,1);
        NElfo.imprimirUnidades();
        NElfo.Fabrica(2000, 1, 1);
        NElfo.Fabrica(2000, 2, 1);
        NElfo.Fabrica(2000, 3, 1);
        
        NElfo.acumularRecursos(1);
        NElfo.acumularRecursos(2);
        NElfo.acumularRecursos(3);
        
        NElfo.addRecursos();
        
        NElfo.NivelUp();
        NElfo.recursosL();
        
        
        NElfo.NivelUp();
        NElfo.recursosL();
              
        NElfo.acumularRecursos(4);
        NElfo.acumularRecursos(5);
        NElfo.acumularRecursos(6);
                
        NElfo.addRecursos();
                
        NElfo.NivelUp();
        NElfo.recursosL();
        
        NElfo.acumularRecursos(7);
        NElfo.acumularRecursos(8);
        NElfo.acumularRecursos(9);
        NElfo.addRecursos();

        
        
    }
    
}
