/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import UnidadesYCosto.Costo;

/**
 *
 * @author mcdre
 */
public class Menu {
    int fase;
    public static Menu menu;
    
    Costo recE=new Costo(100,75,50);
    Costo recH=new Costo(50,50,25);
    Costo recO=new Costo(150,125,85);
    
    Costo ME=new Costo(110,85,60);
    Costo MH=new Costo(60,60,35);
    Costo MO=new Costo(160,135,95);
    
    //no se han cambiado los precios aun para el balance mas adelante
    
    Costo arqueros=new Costo(100,75,50);
    Costo soldado=new Costo(50,50,25);
    Costo mosquetero=new Costo(150,125,85);
    Costo catapulta=new Costo(100,75,50);
    Costo ballesta=new Costo(50,50,25);
    Costo caballero=new Costo(150,125,85);
    
    public static Menu getInstance(){
    if(menu == null){
        menu = new Menu();
    }
    else{
        System.err.println("Error: menu quizo ser duplicado");
    }
    return menu;
    }
    public void Iniciar() {
        int opcion;
        while (!Finalizado) {
            this.Opciones(1);
            opcion = Reader.consola.nextInt();

            switch (opcion) {
                case 1:
                    //crear reservacion
                    this.crearReservacion();

                    break;
                case 2:
                    this.PagoReservacion();
                    break;
                case 3:
                    this.CancelarReservacion();
                    break;
                case 4:
                    this.Opciones(4);
                    opcion = Reader.consola.nextInt();
                    switch (opcion) {
                        case 1:
                            this.CambioFechaND();
                            break;
                        case 2:
                            this.cambioPrincipal();
                            break;
                        case 3:
                            this.CambioPaquete();
                            break;
                        case 4:
                            this.CambioDias();
                            break;
                        case 5:
                            this.CambioDeAcompanniantes();
                            break;
                        case 6:
                            this.CambioDeFechaYDias();
                    }
                    break;
                case 5:
                    this.VerListaDeReservaciones();
                    break;
                case 6:
                    this.EntregarHabitacion();
                    break;
                case 7:
                    this.RetirarHabitacion();
                    break;
                case 8:
                    this.Opciones(8);
                    opcion = Reader.consola.nextInt();
                    switch (opcion) {
                        case 1:
                            this.habilitarHabitacion();
                            break;
                        case 2:
                            this.deshabilitarHabitacion();
                            break;
                        case 3:
                            this.HabilitarPiso();
                            break;
                        case 4:
                            this.deshaiblitarPiso();
                            break;
                    }
                    break;
                case 9:
                    this.Opciones(9);
                    opcion = Reader.consola.nextInt();
                    switch (opcion) {
                        case 1:
                            this.DB_Facturas();
                            break;
                        case 2:
                            this.DB_Reservas();
                            break;
                        case 3:
                            this.DB_HuespedesActuales();
                            break;
                        case 4:
                            this.DB_Habitaciones();
                            break;
                    }
                    break;
                case 10:
                    Finalizado = !Finalizado;
                    break;

            }

        }
    }
    
    public 
    
}
