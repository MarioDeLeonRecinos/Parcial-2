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
public enum RecursoProduccionPorRaza {
    Elfos (100,1,200,300),
    Orcos(50,1,200,300),
    Humanos(150,1,200,300);
    //Druidas(100,1,200,300);
    
    private final int produccionXFase;   
    private final int tEsp;
    private final int limite;
    private final double vida;
    
    RecursoProduccionPorRaza(int produccionXFase, int tEsp,int limite,int vida) {
        this.produccionXFase = produccionXFase;
        this.tEsp = tEsp;
        this.limite=limite;
        this.vida=vida;
    }
    public int produccionXFase(){
        return produccionXFase;
    }
    public int tEsp(){
        return tEsp;
    }
    public int limite(){
        return limite;
    }
    public double vida(){
        return vida;
    }
}
