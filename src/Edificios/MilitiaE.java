/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import Enums.BarracasTipos;
import Enums.EstadoEdificio;
import Enums.NombresUnidades;

/**
 *
 * @author mcdre
 */
 public class MilitiaE {
    int ordenado;
    private double vida;
    int Id;
    int maxUnitPerFase;
    int maxTraining;
    EstadoEdificio estado;
    int faseCreado;
    int tipo;
    BarracasTipos tipe;
    public MilitiaE(BarracasTipos tipo,int fase,int id){
        this.tipe=tipo;
        this.vida=tipo.vida();
        this.Id=id;
        this.maxUnitPerFase=tipo.produccionMaximaPorFase();
        this.maxTraining=tipo.LimiteAlmacenamiento();
        this.estado=EstadoEdificio.working;
        this.faseCreado=fase;
        this.tipo=tipo.tipoEdi();
    }
    
    public int id(){
        return Id;
    }
    
    public int tipo(){
        return tipo;
    }
    
    public int max(){
        return maxTraining;
    }
    
    public int maxFase(){
        return maxUnitPerFase;
    }
    
    public void TakeDamage(double danno){
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
    
    public int crearTropas(){
        int acum=ordenado;
        ordenado=0;
        return acum;
    }
    
    public void orden(int orden){
        if(estado==EstadoEdificio.working&&ordenado+orden<=maxUnitPerFase){
            ordenado=orden+ordenado;
        }
        if(estado==EstadoEdificio.working&&ordenado+orden>maxUnitPerFase){
            System.out.println("No puede asignar mas unidades");
        }
    }
    public void mostrarN(NombresUnidades unidad){
        System.out.println("Barraca que produce "+unidad.toString());
    }
    
    public void mostrarA(){
        System.out.println(Id+"barraca con "+vida+" vida restante");
    }
}
