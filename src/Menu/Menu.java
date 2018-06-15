/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import AbastractFactory.AbstractFactory;
import AbastractFactory.FactoryProducer;
import AbstractFactory.Razas.Raza;
import java.util.Scanner;

/**
 *
 * @author mcdre
 */
public class Menu {

    int fase = 1;
    public static Menu menu;
    boolean base1Viva = true;
    boolean base2Viva = true;

    private final String StrMenu = "| 1. Recolectar Recursos |   2. Crear Fabrica   | 3.Mostrar Fabricas  | 4. Crear Barraca  |              5. Mostrar Barracas               |\n"
            + "| 6. Subir de Nivel Nexo | 7. Nexo Nivel Actual |       8. Atacar     | 9. Crear Unidades | 10. Unidades disponibles para ataque o defensa |\n"
            + "|                11. Defensa                |                                   12. Terminar turno                                         |";
    private final String StrMenu2 = "| 1. Oro | 2. Madera | 3. Hierro |";
    private final String StrMenu4 = "| 1. Barracas de soldados | 2. Barracas de vehiculos tipo1 | 3. Barracas de vehiculos tipo2  |";
    private final String StrMenu8 = "| 1. Fabricas | 2. Barracas | ";
    private final String StrMenu9 = "| 1. Soldados | 2. Vehiculos tipo 1 | 3. Vehiculos tipo 2 | 4. Especialista |";
    private final String opcionesRaza = "Escoja una Raza\n| 1.Humanos | 2.Elfos | 3.Orcos |";

    AbstractFactory factory;
    Raza base1;
    Raza base2;

    Scanner in = new Scanner(System.in);

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        } else {
            System.err.println("Error: menu quizo ser duplicado");
        }
        return menu;
    }

    public void Select(int persona) {
        factory = FactoryProducer.getFactory("Raza");
        int opcion = 0;
        System.out.println(opcionesRaza);
        while (opcion <= 0 || opcion > 3) {
            opcion = in.nextInt();
        }
        switch (persona) {
            case 1:
                base1 = factory.getRazaAEscoger(opcion);
                base1.Fabrica(1, 1, 0);
                base1.Fabrica(1, 2, 0);
                base1.Fabrica(1, 3, 0);
                break;
            case 2:
                base2 = factory.getRazaAEscoger(opcion);
                base2.Fabrica(0, 1, 0);
                base2.Fabrica(0, 2, 0);
                base2.Fabrica(0, 3, 0);
                break;
            default:
                System.out.println("No puede tener mas jugadores");
        }

    }

    public void Opciones(int elect) {
        switch (elect) {
            case 1:
                System.out.println(StrMenu);
                break;
            case 2:
                System.out.println(StrMenu2);
                break;
            case 4:
                System.out.println(StrMenu4);
                break;
            case 8:
                System.out.println(StrMenu8);
                break;
            case 9:
                System.out.println(StrMenu9);
                break;
            case 10:
                System.out.println(opcionesRaza);
                break;
        }
    }

    public void AccionesPorFasePlayer1() {
        System.out.println("Jugador 1");
        int opcion;
        boolean finalizado = false;
        int cantidad = 0;
        while (base1Viva == base2Viva && !finalizado) {
            base1.mostrarR();
            this.Opciones(1);
            opcion = in.nextInt();

            switch (opcion) {

                case 1:
                    base1.addRecursos();
                    break;
                case 2:
                    this.Opciones(2);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el numero de fabricas a construir");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base1.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                        case 2:
                            base1.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                        case 3:
                            base1.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                    }
                    break;
                case 3:
                    base1.mostrarF();
                    break;
                case 4:
                    this.Opciones(4);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el numero de barracas a construir");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base1.crearObjeto(5, fase, opcion, cantidad, 0, false);
                            break;
                        case 2:
                            base1.crearObjeto(6, fase, opcion, cantidad, 0, false);
                            break;
                        case 3:
                            base1.crearObjeto(7, fase, opcion, cantidad, 0, false);
                            break;
                    }
                    break;
                case 5:
                    base1.mostrarM();
                    break;
                case 6:
                    base1.NivelUp();
                    break;
                case 7:
                    base1.nivelActual();
                    break;
                case 8:
                    this.Opciones(8);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el tipo unidad a mandar\n| 1. Soldado | 2. Vehiculo 1 | 3. Vehiculo 2 |");
                    int tipoUnidad = in.nextInt();
                    System.out.println("Ingrese el numero de unidades a mandar");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base2.mostrarMId();
                            base1.crearObjeto(8, fase, 1, cantidad, tipoUnidad, base2.NexoAtackTorF());
                            break;
                        case 2:
                            base2.mostrarFID();
                            base1.crearObjeto(8, fase, 2, cantidad, tipoUnidad, base2.NexoAtackTorF());
                            break;
                    }
                    break;
                case 9:
                    this.Opciones(9);
                    opcion = in.nextInt();
                    if (opcion != 4) {
                        System.out.println("Ingrese el numero de unidades a crear");
                        cantidad = in.nextInt();
                    }
                    switch (opcion) {
                        case 1:
                            base1.crearObjeto(1, fase, 0, cantidad, 0, false);
                            break;
                        case 2:
                            base1.crearObjeto(2, fase, 0, cantidad, 0, false);
                            break;
                        case 3:
                            base1.crearObjeto(3, fase, 0, cantidad, 0, false);
                            break;
                        case 4:
                            base1.crearObjeto(11, fase, 0, 1, 0, false);
                            break;
                    }
                    break;
                case 10:
                    base1.mostrarUniD();
                    break;
                case 11:
                    base1.DefenderAlerta(fase);
                case 12:
                    finalizado = !finalizado;
            }

        }
    }

    public void AccionesPorFasePlayer2() {
        System.out.println("Jugador 2");
        int opcion;
        boolean finalizado = false;
        int cantidad = 0;
        while (base1Viva == base2Viva && !finalizado) {
            base2.mostrarR();
            this.Opciones(1);
            opcion = in.nextInt();

            switch (opcion) {

                case 1:
                    base2.addRecursos();
                    break;
                case 2:
                    this.Opciones(2);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el numero de fabricas a construir");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base2.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                        case 2:
                            base2.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                        case 3:
                            base2.crearObjeto(4, fase, opcion, cantidad, 0, false);
                            break;
                    }
                    break;
                case 3:
                    base2.mostrarF();
                    break;
                case 4:
                    this.Opciones(4);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el numero de barracas a construir");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base2.crearObjeto(5, fase, opcion, cantidad, 0, false);
                            break;
                        case 2:
                            base2.crearObjeto(6, fase, opcion, cantidad, 0, false);
                            break;
                        case 3:
                            base2.crearObjeto(7, fase, opcion, cantidad, 0, false);
                            break;
                    }
                    break;
                case 5:
                    base2.mostrarM();
                    break;
                case 6:
                    base2.NivelUp();
                    break;
                case 7:
                    base2.nivelActual();
                    break;
                case 8:
                    this.Opciones(8);
                    opcion = in.nextInt();
                    System.out.println("Ingrese el tipo unidad a mandar\n| 1. Soldado | 2. Vehiculo 1 | 3. Vehiculo 2 |");
                    int tipoUnidad = in.nextInt();
                    System.out.println("Ingrese el numero de unidades a mandar");
                    cantidad = in.nextInt();
                    switch (opcion) {
                        case 1:
                            base1.mostrarMId();
                            base2.crearObjeto(8, fase, 1, cantidad, tipoUnidad, base1.NexoAtackTorF());
                            break;
                        case 2:
                            base1.mostrarFID();
                            base2.crearObjeto(8, fase, 2, cantidad, tipoUnidad, base1.NexoAtackTorF());
                            break;
                    }
                    break;
                case 9:
                    this.Opciones(9);
                    opcion = in.nextInt();
                    if (opcion != 4) {
                        System.out.println("Ingrese el numero de unidades a crear");
                        cantidad = in.nextInt();
                    }
                    switch (opcion) {
                        case 1:
                            base2.crearObjeto(1, fase, 0, cantidad, 0, false);
                            break;
                        case 2:
                            base2.crearObjeto(2, fase, 0, cantidad, 0, false);
                            break;
                        case 3:
                            base2.crearObjeto(3, fase, 0, cantidad, 0, false);
                            break;
                        case 4:
                            base2.crearObjeto(11, fase, 0, 1, 0, false);
                            break;
                    }
                    break;
                case 10:
                    base2.mostrarUniD();
                    break;
                case 11:
                    base2.DefenderAlerta(fase);
                case 12:
                    finalizado = !finalizado;
            }

        }
    }

    public void ataques() {
        base2.newUnidades(base1.calcularDanno(base2.enviarUnidades(), fase));
        base1.newUnidades(base2.calcularDanno(base1.enviarUnidades(), fase));
    }

    public void newTurno() {
        fase++;
        base1.acumularRecursos(fase);
        base2.acumularRecursos(fase);
        base1Viva=base1.nexovivo();
        base2Viva=base2.nexovivo();
    }
    public void main(){
        while(base1Viva==base2Viva){
            System.out.println("La fase actual es: " + fase);
            this.AccionesPorFasePlayer1();
            this.AccionesPorFasePlayer2();
            this.ataques();
            this.newTurno();
        }
        if(base1Viva==false){
            System.out.println("Perdio el jugador 1");
        }
        else{
            System.out.println("Perdio el jugador 2");
        }
    }

}
