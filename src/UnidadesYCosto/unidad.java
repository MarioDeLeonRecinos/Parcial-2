/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadesYCosto;

import Enums.NombresUnidades;
import Enums.estadoUnidad;
import java.util.Random;

/**
 *
 * @author mcdre
 */
public class unidad {
    int dannoUnit;
    int dannoEdificio;
    double vida;
    int blanco;
    int tipoblanco;
    int orders;
    estadoUnidad estado;
    NombresUnidades tipo;
    int faseDamage;
    int Id;
    int faseCreado;
    
    public unidad(NombresUnidades tipe,int id,int faseC){
        dannoUnit=tipe.danno1();
        dannoEdificio=tipe.danno2();
        vida=tipe.vida();
        estado=estadoUnidad.enBase;
        tipo=tipe;
        Id=id;
        faseCreado=faseC;
        
    }
    public void takeDamage(double dano){
        if(vida-dano>0){
            vida=vida-dano;
        }
        else{
            vida=0;
            estado=estadoUnidad.muerto;
        }
        
    }
    
    public double dealDamage(){
        Random r = new Random();
        double Low = 0.5;
        double High = 1.5;
        double randomValue = Low + (High - Low) * r.nextDouble();

        if (estado == estadoUnidad.defendiendo) {
            return dannoUnit * randomValue;
        }
        if(estado==estadoUnidad.atacando){
            return dannoEdificio * randomValue;
        }
        else{
            return 0;
        }
    }
    public void atacando(int fase){
        if(fase>=faseDamage&&orders==1&&vida>0){
            estado=estadoUnidad.atacando;
        }
        if(fase>=faseDamage&&orders==2&&vida>0){
            estado=estadoUnidad.defendiendo;
        }
    }
    
    public void atackOders(int faseD,int order,int bla,int tipo){
        faseDamage=faseD;
        orders=order;
        tipoblanco=tipo;
        blanco=bla;
        
    }

    public  void nombre() {
        System.out.println(Id+" "+tipo);
    }
    
    public int tipoblanco(){
        return tipoblanco;
    }
    
    public int blanco(){
        return blanco;
    }
    
    public estadoUnidad estado(){
        return estado;
    }
    
    public int faseDamage(){
        return faseDamage;
    }
    
    public String tipo(){
        return  tipo.toString();
    }
    
    public int id(){
        return Id;
    }
    
    public int orders(){
        return orders;
    }
    
    public void setTEnemigo(){
        estado=estadoUnidad.enTEnemigo;
    }
    
}
