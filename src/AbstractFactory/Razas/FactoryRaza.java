/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.Razas;

import AbastractFactory.AbstractFactory;

/**
 *
 * @author mcdre
 */
public class FactoryRaza implements AbstractFactory  {
    public Raza getRazaAEscoger(int operacion) {

        switch (operacion) {
            case 1:
                System.out.println("Escojio la raza Humana");
                return new Humanos();
            case 2:
                System.out.println("Escojio la raza Elfa");
                return new Elfos();
            case 3:
                System.out.println("Escojio la raza Orca");
                return new Orcos();
            default:
                System.out.println("No escojio una raza existente");
                return null;
        }
    }
}
