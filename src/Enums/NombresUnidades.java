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
    Soldado(30, 20, 200, 1),
    Arquero(40, 10, 150, 1),
    globin(30, 20, 150, 1),
    
    Caballero(40, 10, 350, 2),
    nightriders(50, 5, 300, 2),
    Warlord(40, 15, 350, 2),
    
    bombers(40, 10, 350, 3),
    Ballesta(60, 10, 450, 3),
    Catapulta(30, 60, 450, 3),
    
    Paladin(40, 10, 350, 4),
    PriestOfTheMoon(60, 10, 450, 4),
    Hoglobin(30, 60, 450, 4);

    private final int danno1;
    private final int danno2;
    private final int vida;
    private final int tipo;

    NombresUnidades(int danno1, int danno2, int vida, int tipo) {
        this.danno1 = danno1;
        this.danno2 = danno2;
        this.vida = vida;
        this.tipo = tipo;
    }

    public int danno1() {
        return danno1;
    }

    public int danno2() {
        return danno2;
    }

    public int vida() {
        return vida;
    }

    public int tipo() {
        return tipo;
    }

}
