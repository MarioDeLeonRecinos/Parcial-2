/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.Razas;

import Edificios.MilitiaE;
import Edificios.Nexo;
import Edificios.Recurso;
import Enums.EstadoEdificio;
import Enums.NombresUnidades;
import Enums.RecursoProduccionPorRaza;
import Enums.estadoUnidad;
import UnidadesYCosto.unidad;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mcdre
 */
public class Elfos implements Raza{

    Nexo elfoNexo = new Nexo();
    boolean nexoA = false;
    ArrayList<unidad> listaUnidades = new ArrayList();

    ArrayList<Recurso> fabricas = new ArrayList();
    ArrayList<MilitiaE> mili = new ArrayList();

    ArrayList<MilitiaE> defensaM = new ArrayList();
    ArrayList<Recurso> defensaF = new ArrayList();
    
    @Override
    public void NexoCrear() {
        elfoNexo = new Nexo();
    }
    @Override
    public void soldado(int cantidad, int fase) {

        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad(NombresUnidades.Arquero, 1, fase));
            } else {
                listaUnidades.add(new unidad(NombresUnidades.Arquero, listaUnidades.size() + 1, fase));
            }
        }
    }

    public void imprimirUnidades() {
        if (listaUnidades.size() != 0) {
            for (unidad i : listaUnidades) {
                if (i.estado() == estadoUnidad.enBase || i.estado() == estadoUnidad.enTEnemigo) {
                    i.nombre();
                }

            }
        }
    }

    public void vehiculo1(int cantidad, int fase) {
        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad(NombresUnidades.Catapulta, 1, fase));
            } else {
                listaUnidades.add(new unidad(NombresUnidades.Catapulta, listaUnidades.size() + 1, fase));
            }
        }
    }

    public void vehiculo2(int cantidad, int fase) {
        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad( NombresUnidades.Ballesta, 1, fase));
            } else {
                listaUnidades.add(new unidad( NombresUnidades.Ballesta, listaUnidades.size() + 1, fase));
            }
        }
    }

    public void Fabrica(int cantidad, int tipo, int fase) {

        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                fabricas.add(new Recurso(RecursoProduccionPorRaza.Elfos,fase,tipo,1));
            } else {
                fabricas.add(new Recurso(RecursoProduccionPorRaza.Elfos,fase,tipo, fabricas.size() + 1));
            }
        }
    }

    public void addRecursos() {
        int acum1 = 0;
        int acum2 = 0;
        int acum3 = 0;
        for (Recurso i : fabricas) {
            switch (i.tipo()) {
                case 1:
                    acum1 = acum1 + i.Recolectar();
                    break;
                case 2:
                    acum2 = acum2 + i.Recolectar();
                    break;
                case 3:
                    acum3 = acum3 + i.Recolectar();
                    break;
                default:
                    System.out.print("tipo no valido");
            }

        }
        elfoNexo.addRecursos(acum1, acum2, acum3);
    }

    public void acumularRecursos(int fase) {
        for (Recurso i : fabricas) {
            i.Acumular(fase);
        }
    }

    public void mostrarR() {
        System.out.println("Oro: " + elfoNexo.recurso1() + " Madera: " + elfoNexo.recurso2() + " Hierro: " + elfoNexo.recurso3());
    }

    //aun falta que evalue si la vida llega a cero y que cambie el estado de edificio
    public ArrayList<unidad> calcularDanno(ArrayList<unidad> unidades, int fase) {

        for (unidad u : unidades) {
            for (Recurso f : fabricas) {
                if (u.tipoblanco() == 1 && u.blanco() == f.id() && fase - u.faseDamage() >= 0&&u.estado()==estadoUnidad.atacando&&f.Estado()==EstadoEdificio.working) {
                    f.recibirDanno(u.dealDamage());
                    if (defensaF.contains(f) == false) {
                        defensaF.add(f);
                    }
                }
            }
            for (MilitiaE m : mili) {
                if (u.tipoblanco() == 2 && u.blanco() == m.id() && fase - u.faseDamage() >= 0&&u.estado()==estadoUnidad.atacando&&m.Estado()==EstadoEdificio.working) {
                    m.recibirDanno(u.dealDamage());
                    if (defensaM.contains(m) == false) {
                        defensaM.add(m);
                    }
                }
            }
            if (u.tipoblanco() == 3 && fase - u.faseDamage() >= 0&&u.estado()==estadoUnidad.atacando) {
                elfoNexo.TakeDamage(u.dealDamage());
                nexoA = true;
            }
        }
        for(unidad u : unidades){
            for (Recurso f : fabricas) {
                if(u.tipoblanco() == 1 && u.blanco() == f.id() && f.Estado() == EstadoEdificio.destroyed){
                    u.setTEnemigo();
                }
            }
            for (MilitiaE m : mili) {
                if(u.tipoblanco() == 1 && u.blanco() == m.id() && m.Estado() == EstadoEdificio.destroyed){
                    u.setTEnemigo();
                }
            }
        }
        if (defensaF.isEmpty() == false) {
            this.peleaDeUnidades(unidades);
        }
        if (this.noAtaco() == true) {
            defensaF = new ArrayList();
            defensaM = new ArrayList();
        }

        return unidades;
    }

    public void recursosL() {
        elfoNexo.Limites();
    }

    public void NivelUp() {
        elfoNexo.NexoSubirNivel(elfoNexo.CalcularSubirNivel());
    }

    public void nivelA() {
        elfoNexo.nivelA();
    }

    public boolean NexoAtackTorF() {

        for (Recurso f : fabricas) {
            if (f.Estado() == EstadoEdificio.working) {
                return false;
            }
        }
        for (MilitiaE m : mili) {
            if (m.Estado() == EstadoEdificio.working) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<unidad> peleaDeUnidades(ArrayList<unidad> unidades) {
        for (unidad j : listaUnidades) {
            for (unidad i : unidades) {
                if (j.blanco() == i.blanco() && j.tipoblanco() == i.tipoblanco() && j.estado() == estadoUnidad.defendiendo && i.estado() == estadoUnidad.atacando) {
                    i.takeDamage((int) j.dealDamage());
                }
            }
        }
        return unidades;
    }

    public boolean noAtaco() {

        for (Recurso i : fabricas) {
            for (Recurso j : defensaF) {
                if (j.equals(i)==false&&j.id()==i.id()) {
                    return false;
                }
            }
        }
        for (MilitiaE i : mili) {
            for (MilitiaE j : defensaM) {
                if (j.equals(i)==false&&j.id()==i.id()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void DefenderAlerta(int fase) {
        int a = 0;
        if (defensaF.isEmpty() == false) {
            System.out.println("Puedes defender las siguientes fabricas: ");
            for (Recurso i : defensaF) {
                System.out.println(i.id());
            }
        }
        
        System.out.println("Escoje los edificios a proteger y las tropas uno por uno: ");
        
        while (a == 0) {
            a = darOrdenesDefensa(fase, 1);
        }
        a=0;
        if (defensaM.isEmpty() == false) {
            System.out.println("Puedes defender las siguientes barracas: ");
            for (MilitiaE i : defensaM) {
                System.out.println(i.id());
            }
        }
        while (a == 0) {
            a = darOrdenesDefensa(fase, 2);
        }
    }

    private int darOrdenesDefensa(int fase, int tipo) {
        System.out.println("Introduzca el tipo de unidad, el numero de unidades a mandar y el id del blanco: ");
        System.out.println("Si ya no quiere seleccionar nada presione 0: ");
        Scanner reader = new Scanner(System.in);

        String tipo2 = reader.nextLine();
        int cantidad=reader.nextInt();
        int aux=0;
        int id = reader.nextInt();

        for (unidad j : listaUnidades) {
            if (j.tipo().equals(tipo2) && j.id() == id && aux<cantidad) {
                j.atackOders(fase+1, 2, id, tipo);
                aux++;
            }
        }
        
        if(tipo2.equals("0")||id==0||cantidad==0){
            return 1;
        }
        
        return 0;
    }
    
    public int darOrdenesAtaque(int fase, int tipo) {
        System.out.println("Introduzca el tipo de unidad, el numero de unidades a mandar y el id del blanco: ");
        System.out.println("Si ya no quiere seleccionar nada presione 0: ");
        Scanner reader = new Scanner(System.in);

        String tipo2 = reader.nextLine();
        int cantidad=reader.nextInt();
        int aux=0;
        int id = reader.nextInt();

        for (unidad j : listaUnidades) {
            if (j.tipo().equals(tipo2) && j.id() == id && aux<cantidad) {
                j.atackOders(fase+1, 2, id, tipo);
                aux++;
            }
        }
        
        if(tipo2.equals("0")||id==0||cantidad==0){
            return 1;
        }
        
        return 0;
    }
    
    public void newUnidades(ArrayList<unidad> unidades){
        listaUnidades = unidades;
    }

}
