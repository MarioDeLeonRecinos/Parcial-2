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
public enum NombresUnidades {
    Soldado (30,20,200),
    Arquero(40,10,150),
    Mosquetero(30,20,150),
    Caballero(40,10,350),
    Ballesta(60,10,450),
    Catapulta(30,60,450);
    
    private final int danno1;   
    private final int danno2;
    private final int vida;
    
    NombresUnidades(int danno1, int danno2,int vida) {
        this.danno1 = danno1;
        this.danno2 = danno2;
        this.vida=vida;
    }
    public int danno1(){
        return danno1;
    }
    public int danno2(){
        return danno2;
    }
    public int vida(){
        return vida;
    }
    
}
