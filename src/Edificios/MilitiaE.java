/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import EstadosYNombresdeUnidades.EstadoEdificio;

/**
 *
 * @author mcdre
 */
 public class MilitiaE {
    public double vida;
    int Id;
    int maxUnit;
    int maxTraining;
    EstadoEdificio estado;
    
    public int id(){
        return Id;
    }
    
    public void recibirDanno(double danno){
        if(vida-danno<=0){
            vida=0;
            this.estado=EstadoEdificio.destroyed;
        }
        else{
            vida=vida-danno;
        }
    }
    
    public EstadoEdificio Estado(){
        return estado;
    }
    
}
