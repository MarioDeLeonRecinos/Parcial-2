/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

import UnidadesYCosto.Costo;

/**
 *
 * @author mcdre
 */
public enum TodosLosCostos {
    Soldado (10,15,30),
    Arquero(30,25,15),
    globin(50,15,50),
    
    Caballero(20, 15, 35),
    nightriders(20, 15, 35),
    Warlord(20, 15, 35),
    
    bombers(20, 15, 35),
    Ballesta(20, 15, 35),
    Catapulta(20, 15, 35),
    
    Paladin(20, 15, 35),
    PriestOfTheMoon(20, 15, 35),
    Hoglobin(20, 15, 35),
    
    
    FabricaE(100,100,80),
    FabricaH(100,100,80),
    FabricaO(100,100,80),
    
    Barracas1E(100,100,80),
    Barracas2E(100,100,80),
    Barracas3E(100,100,80),
    
    Barracas1O(100,100,80),
    Barracas2O(100,100,80),
    Barracas3O(100,100,80),
    
    Barracas1H(100,100,80),
    Barracas2H(100,100,80),
    Barracas3H(100,100,80),
    
    CostoAtaqueE(10,10,10),
    CostoAtaqueO(10,10,10),
    CostoAtaqueH(10,10,10),
    
    CostoDefensaE(5,5,5),
    CostoDefensaO(5,5,5),
    CostoDefensaH(5,5,5);
    
    private final int rec1;   
    private final int rec2;
    private final int rec3;
    
    TodosLosCostos(int rec1, int rec2,int rec3) {
        this.rec1 = rec1;
        this.rec2 = rec2;
        this.rec3=rec3;
    }
    public Costo Costo(){
        Costo costo=new Costo(rec1,rec2,rec3);
        return costo;
    }

}
