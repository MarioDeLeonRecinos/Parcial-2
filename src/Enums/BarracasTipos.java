/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author mcdre
 */
public enum BarracasTipos {
    soldadoH (10,100,300,1),
    vehiculo1H(5,50,400,2),
    vehiculo2H(3,40,400,3),
    
    soldadoO (10,100,300,1),
    vehiculo1O(5,50,400,2),
    vehiculo2O(3,40,400,3),
    
    soldadoE(40,10,350,1),
    vehiculo1E(60,10,450,2),
    vehiculo2E(30,60,450,3);
    
    private final int produccionMaximaPorFase;   
    private final int LimiteAlmacenamiento;
    private final int vida;
    private final int TipoEdi;
    
    BarracasTipos(int produccionMaximaPorFase, int LimiteAlmacenamiento,int vida,int TipoEdi) {
        this.produccionMaximaPorFase = produccionMaximaPorFase;
        this.LimiteAlmacenamiento = LimiteAlmacenamiento;
        this.vida=vida;
        this.TipoEdi=TipoEdi;
    }
    public int produccionMaximaPorFase(){
        return produccionMaximaPorFase;
    }
    public int LimiteAlmacenamiento(){
        return LimiteAlmacenamiento;
    }
    public int vida(){
        return vida;
    }
    public int tipoEdi(){
        return TipoEdi;
    }
}
