/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.Razas;

import Edificios.MilitiaE;
import Edificios.Nexo;
import Edificios.Recurso;
import Enums.BarracasTipos;
import Enums.EstadoEdificio;
import Enums.NombresUnidades;
import Enums.RecursoProduccionPorRaza;
import Enums.TodosLosCostos;
import Enums.estadoUnidad;
import UnidadesYCosto.Costo;
import UnidadesYCosto.unidad;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mcdre
 */
public class Humanos implements Raza {

    Nexo Nexo = new Nexo();
    boolean nexoA = false;
    ArrayList<unidad> listaUnidades = new ArrayList();

    ArrayList<Recurso> fabricas = new ArrayList();
    ArrayList<MilitiaE> mili = new ArrayList();

    ArrayList<MilitiaE> defensaM = new ArrayList();
    ArrayList<Recurso> defensaF = new ArrayList();

    RecursoProduccionPorRaza fabrica = RecursoProduccionPorRaza.Elfos;

    NombresUnidades unidad1 = NombresUnidades.Soldado;
    NombresUnidades unidad2 = NombresUnidades.Caballero;
    NombresUnidades unidad3 = NombresUnidades.Catapulta;

    NombresUnidades especialista = NombresUnidades.Paladin;

    BarracasTipos edificio1 = BarracasTipos.soldadoH;
    BarracasTipos edificio2 = BarracasTipos.vehiculo1H;
    BarracasTipos edificio3 = BarracasTipos.vehiculo2H;

    TodosLosCostos unidad1C = TodosLosCostos.Soldado;
    TodosLosCostos unidad2C = TodosLosCostos.Caballero;
    TodosLosCostos unidad3C = TodosLosCostos.Ballesta;

    TodosLosCostos especialistaC = TodosLosCostos.Paladin;

    TodosLosCostos fabricaC = TodosLosCostos.FabricaH;

    TodosLosCostos edificio1C = TodosLosCostos.Barracas1H;
    TodosLosCostos edificio2C = TodosLosCostos.Barracas2H;
    TodosLosCostos edificio3C = TodosLosCostos.Barracas3H;

    TodosLosCostos ataqueC = TodosLosCostos.CostoAtaqueH;
    TodosLosCostos defensaC = TodosLosCostos.CostoDefensaH;

    @Override
    public void NexoCrear() {
        Nexo = new Nexo();
    }

    @Override
    public void soldado(int cantidad, int fase) {

        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad(unidad1, 1, fase));
            } else {
                listaUnidades.add(new unidad(unidad1, listaUnidades.size() + 1, fase));
            }
        }
    }

    @Override
    public void espe(int fase) {
        if (listaUnidades == null) {
            listaUnidades.add(new unidad(especialista, 1, fase));
        } else {
            listaUnidades.add(new unidad(especialista, listaUnidades.size() + 1, fase));
        }
    }

    @Override
    public void imprimirUnidades() {
        if (listaUnidades.size() != 0) {
            for (unidad i : listaUnidades) {
                if (i.estado() == estadoUnidad.enBase || i.estado() == estadoUnidad.enTEnemigo) {
                    i.nombre();
                }

            }
        }
    }

    @Override
    public void vehiculo1(int cantidad, int fase) {
        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad(unidad2, 1, fase));
            } else {
                listaUnidades.add(new unidad(unidad2, listaUnidades.size() + 1, fase));
            }
        }
    }

    @Override
    public void vehiculo2(int cantidad, int fase) {
        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                listaUnidades.add(new unidad(unidad3, 1, fase));
            } else {
                listaUnidades.add(new unidad(unidad3, listaUnidades.size() + 1, fase));
            }
        }
    }

    @Override
    public void Fabrica(int cantidad, int tipo, int fase) {

        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                fabricas.add(new Recurso(fabrica, fase, tipo, 1));
            } else {
                fabricas.add(new Recurso(fabrica, fase, tipo, fabricas.size() + 1));
            }
        }
    }

    @Override
    public void miliFabrica(int cantidad, BarracasTipos tipo, int fase) {

        for (int i = 0; i < cantidad; i++) {
            if (listaUnidades == null) {
                mili.add(new MilitiaE(tipo, fase, 1));
            } else {
                mili.add(new MilitiaE(tipo, fase, fabricas.size() + 1));
            }
        }
    }

    @Override
    public void PedirTropas(int cantidad, int tipo) {

        for (MilitiaE m : mili) {

            switch (tipo) {
                case 1:
                    int aux = BarracasTipos.soldadoE.produccionMaximaPorFase();
                    if (m.tipo() == 1 && aux < cantidad) {
                        m.orden(aux);
                        cantidad = cantidad - aux;
                    }
                    if (m.tipo() == 1 && aux >= cantidad) {
                        m.orden(cantidad);
                    }
                    break;
                case 2:
                    int aux2 = BarracasTipos.vehiculo1E.produccionMaximaPorFase();
                    if (m.tipo() == 2 && aux2 < cantidad) {
                        m.orden(aux2);
                        cantidad = cantidad - aux2;
                    }
                    if (m.tipo() == 2 && aux2 >= cantidad) {
                        m.orden(cantidad);
                    }
                    break;
                case 3:
                    int aux3 = BarracasTipos.vehiculo2E.produccionMaximaPorFase();
                    if (m.tipo() == 3 && aux3 < cantidad) {
                        m.orden(aux3);
                        cantidad = cantidad - aux3;
                    }
                    if (m.tipo() == 3 && aux3 >= cantidad) {
                        m.orden(cantidad);
                    }
                    break;
            }
        }
    }

    @Override
    public void RecibirTropas(int fase) {
        for (MilitiaE m : mili) {
            if (m.tipo() == 1) {
                this.soldado(m.crearTropas(), fase);
            }
            if (m.tipo() == 2) {
                this.vehiculo1(m.crearTropas(), fase);
            }
            if (m.tipo() == 3) {
                this.vehiculo2(m.crearTropas(), fase);
            }
        }
    }

    @Override
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
        Nexo.addRecursos(acum1, acum2, acum3);
    }

    @Override
    public void acumularRecursos(int fase) {
        for (Recurso i : fabricas) {
            i.Acumular(fase);
        }
    }

    @Override
    public void mostrarR() {
        System.out.println("Oro: " + Nexo.recurso1() + " Madera: " + Nexo.recurso2() + " Hierro: " + Nexo.recurso3());
    }

    //aun falta que evalue si la vida llega a cero y que cambie el estado de edificio
    @Override
    public ArrayList<unidad> calcularDanno(ArrayList<unidad> unidades, int fase) {
        for (unidad u : unidades){
            u.atacando(fase);
        }
        for (unidad u : unidades) {
            for (Recurso f : fabricas) {
                if (u.tipoblanco() == 1 && u.blanco() == f.id() && fase - u.faseDamage() >= 0 && u.estado() == estadoUnidad.atacando && f.Estado() == EstadoEdificio.working) {
                    f.TakeDamage(u.dealDamage());
                    if (defensaF.contains(f) == false) {
                        defensaF.add(f);
                    }
                }
            }
            for (MilitiaE m : mili) {
                if (u.tipoblanco() == 2 && u.blanco() == m.id() && fase - u.faseDamage() >= 0 && u.estado() == estadoUnidad.atacando && m.Estado() == EstadoEdificio.working) {
                    m.TakeDamage(u.dealDamage());
                    if (defensaM.contains(m) == false) {
                        defensaM.add(m);
                    }
                }
            }
            if (u.tipoblanco() == 3) {
                Nexo.TakeDamage(u.dealDamage());
                nexoA = true;
            }
        }
        for (unidad u : unidades) {
            for (Recurso f : fabricas) {
                if (u.tipoblanco() == 1 && u.blanco() == f.id() && f.Estado() == EstadoEdificio.destroyed) {
                    u.setTEnemigo();
                }
            }
            for (MilitiaE m : mili) {
                if (u.tipoblanco() == 1 && u.blanco() == m.id() && m.Estado() == EstadoEdificio.destroyed) {
                    u.setTEnemigo();
                }
            }
        }
        if (defensaF.isEmpty() == false) {
            unidades = this.peleaDeUnidades(unidades);
        }
        if (this.noAtaco() == true) {
            defensaF = new ArrayList();
            defensaM = new ArrayList();
            nexoA = false;
        }

        return unidades;
    }

    @Override
    public void recursosL() {
        Nexo.Limites();
    }

    @Override
    public void NivelUp() {
        Nexo.NexoSubirNivel(Nexo.CalcularSubirNivel());
    }

    @Override
    public void nivelActual() {
        Nexo.nivelA();
    }

    @Override
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

    @Override
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

    @Override
    public boolean noAtaco() {

        for (Recurso i : fabricas) {
            for (Recurso j : defensaF) {
                if (j.equals(i) == false && j.id() == i.id()) {
                    return false;
                }
            }
        }
        for (MilitiaE i : mili) {
            for (MilitiaE j : defensaM) {
                if (j.equals(i) == false && j.id() == i.id()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void DefenderAlerta(int fase) {
        Scanner in = new Scanner(System.in);
        boolean a = true;
        int cantidad = 0;

        if (defensaF.isEmpty() == false) {
            System.out.println("Puedes defender las siguientes fabricas: ");
            for (Recurso i : defensaF) {
                System.out.println(i.id());
            }
        } else {
            a = false;
        }

        System.out.println("Escoje los edificios a proteger y las tropas uno por uno: ");

        while (a == true) {
            System.out.println("Ingrese el tipo unidad a mandar\n| 1. Soldado | 2. Vehiculo 1 | 3. Vehiculo 2 |");
            int tipoUnidad = in.nextInt();
            System.out.println("Ingrese el numero de unidades a mandar");
            cantidad = in.nextInt();
            if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == true) {
                a = this.darOrdenesDefensa(fase, 3, cantidad, tipoUnidad);
            } else {
                if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == false) {
                    System.out.println("no tiene los recursos para mandar esa cantidad de unidades");
                    a = false;
                }
            }
        }
        a = true;
        if (defensaM.isEmpty() == false) {
            System.out.println("Puedes defender las siguientes barracas: ");
            for (MilitiaE i : defensaM) {
                System.out.println(i.id());
            }
        } else {
            a = false;
        }

        while (a == true) {

            System.out.println("Ingrese el tipo unidad a mandar\n| 1. Soldado | 2. Vehiculo 1 | 3. Vehiculo 2 |");
            int tipoUnidad = in.nextInt();
            System.out.println("Ingrese el numero de unidades a mandar");
            cantidad = in.nextInt();
            if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == true) {
                a = this.darOrdenesDefensa(fase, 3, cantidad, tipoUnidad);
            } else {
                if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == false) {
                    System.out.println("no tiene los recursos para mandar esa cantidad de unidades");
                    a = false;
                }
            }
        }

        if (nexoA == true) {
            System.out.println("Puedes defender tu nexo: ");
            while (a == true) {
                System.out.println("Ingrese el tipo unidad a mandar\n| 1. Soldado | 2. Vehiculo 1 | 3. Vehiculo 2 |");
                int tipoUnidad = in.nextInt();
                System.out.println("Ingrese el numero de unidades a mandar");
                cantidad = in.nextInt();
                if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == true) {
                    a = this.darOrdenesDefensa(fase, 3, cantidad, tipoUnidad);
                } else {
                    if (Nexo.takeRecursosB(this.CalcularCosto(10, cantidad).rec1, this.CalcularCosto(10, cantidad).rec2, this.CalcularCosto(10, cantidad).rec3) == false) {
                        System.out.println("no tiene los recursos para mandar esa cantidad de unidades");
                        a = false;
                    }
                }
            }

        }
    }

    @Override
    public boolean darOrdenesDefensa(int fase, int tipoE, int cantidad, int tipoU) {
        int id = 0;
        int aux = 0;

        if (tipoE != 3) {
            System.out.println("Introduzca el id del blanco a proteger o presione cero si no quiere defender nada: ");
            Scanner reader = new Scanner(System.in);
            id = reader.nextInt();
        }

        for (unidad j : listaUnidades) {
            if (j.tipoN() == tipoU && j.id() == id && aux < cantidad && j.estado() == estadoUnidad.enBase) {
                j.atackOders(fase + 2, 2, id, tipoE);
                aux++;
            }
            if (j.tipoN() == tipoU && j.id() == id && aux < cantidad && j.estado() == estadoUnidad.enTEnemigo) {
                j.atackOders(fase + 1, 2, id, tipoE);
                aux++;
            }
        }

        if (id == 0) {
            return false;
        }

        return true;
    }

    @Override
    public int darOrdenesAtaque(int fase, int tipoE, int cantidad, int tipoU) {
        int id = 0;
        int aux = 0;

        if (tipoE != 3) {
            System.out.println("Introduzca el id del blanco a atacar: ");
            Scanner reader = new Scanner(System.in);
            id = reader.nextInt();
        }

        for (unidad j : listaUnidades) {
            if (j.tipoN() == tipoU && j.id() == id && aux < cantidad && j.estado() == estadoUnidad.enBase) {
                j.atackOders(fase + 2, 1, id, tipoE);
                aux++;
            }
            if (j.tipoN() == tipoU && j.id() == id && aux < cantidad && j.estado() == estadoUnidad.enTEnemigo) {
                j.atackOders(fase + 1, 1, id, tipoE);
                aux++;
            }
        }

        if (id == 0) {
            return 1;
        }

        return 0;
    }

    @Override
    public void newUnidades(ArrayList<unidad> unidades) {
        listaUnidades = unidades;
    }

    @Override
    public ArrayList<unidad> enviarUnidades() {
        return listaUnidades;
    }

    @Override
    public Costo CalcularCosto(int opcion, int cantidad) {
        Costo aux = new Costo(0, 0, 0);

        switch (opcion) {
            case 1:
                aux = unidad1C.Costo().calcularTotal(cantidad);
                return aux;
            case 2:
                aux = unidad2C.Costo().calcularTotal(cantidad);
                return aux;
            case 3:
                aux = unidad3C.Costo().calcularTotal(cantidad);
                return aux;
            case 4:
                aux = fabricaC.Costo().calcularTotal(cantidad);
                return aux;
            case 5:
                aux = edificio1C.Costo().calcularTotal(cantidad);
                return aux;
            case 6:
                aux = edificio2C.Costo().calcularTotal(cantidad);
                return aux;
            case 7:
                aux = edificio3C.Costo().calcularTotal(cantidad);
                return aux;
            case 8:
                aux = ataqueC.Costo().calcularTotal(cantidad);
                return aux;
            case 9:
                return aux.calcularTotal(1);
            case 10:
                aux = defensaC.Costo().calcularTotal(cantidad);
                return aux;
            case 11:
                aux = especialistaC.Costo().calcularTotal(cantidad);
                return aux;
            default:
                return null;
        }
    }

    @Override
    public void crearObjeto(int opcion, int fase, int tipo, int cantidad, int tipoUnidad, boolean nexo) {

        Costo costo = this.CalcularCosto(opcion, cantidad);

        if (Nexo.takeRecursosB(costo.rec1, costo.rec2, costo.rec3) == true) {

            Nexo.takeRecursosD(Nexo.takeRecursosB(costo.rec1, costo.rec2, costo.rec3), costo.rec1, costo.rec2, costo.rec3);
            switch (opcion) {
                case 1:
                    this.PedirTropas(cantidad, opcion);
                    break;
                case 2:
                    this.PedirTropas(cantidad, opcion);
                    break;
                case 3:
                    this.PedirTropas(cantidad, opcion);
                    break;
                case 4:
                    this.Fabrica(cantidad, tipo, fase);
                    break;
                case 5:
                    this.miliFabrica(cantidad, edificio1, fase);
                    break;
                case 6:
                    this.miliFabrica(cantidad, edificio2, fase);
                    break;
                case 7:
                    this.miliFabrica(cantidad, edificio3, fase);
                    break;
                case 8:
                    if (nexo == true) {
                        tipo = 3;
                        System.out.println("Esta atacando el nexo enemigo");
                    }
                    this.darOrdenesAtaque(fase, tipo, cantidad, tipoUnidad);
                    break;
                case 9:
                    this.DefenderAlerta(fase);
                    break;
                case 11:
                    if (this.Especialista() == true) {
                        this.espe(fase);
                    }
                    else{
                        System.out.println("No puedes tener otro especialista");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }

    @Override
    public int EspacioDisponible(int tipo) {
        int acum = 0;
        int max = 0;

        for (unidad u : listaUnidades) {
            if (u.estado() != estadoUnidad.muerto) {
                if (u.tipoN() == tipo) {
                    acum++;
                }
            }
        }
        for (MilitiaE m : mili) {
            if (m.tipo() == tipo) {
                max = max + m.max();
            }
        }

        return max - acum;
    }

    @Override
    public int MaximoAProducirEstaFase(int Limite, int tipo) {
        int limit = 0;
        for (MilitiaE m : mili) {
            if (m.tipo() == tipo) {
                limit = limit + m.maxFase();
            }
        }
        if (Limite - limit > 0) {
            return limit;
        } else {
            return Limite - limit;
        }

    }

    @Override
    public void mostrarF() {
        for (Recurso f : fabricas) {
            if (f.Estado() == EstadoEdificio.working) {
                f.mostrarN();
            }
        }
    }

    @Override
    public void mostrarM() {
        for (MilitiaE m : mili) {
            if (m.Estado() == EstadoEdificio.working && m.tipo() == 1) {
                m.mostrarN(unidad1);
            }
            if (m.Estado() == EstadoEdificio.working && m.tipo() == 2) {
                m.mostrarN(unidad2);
            }
            if (m.Estado() == EstadoEdificio.working && m.tipo() == 3) {
                m.mostrarN(unidad3);
            }
        }
    }

    @Override
    public void mostrarMId() {
        for (MilitiaE m : mili) {
            if (m.Estado() == EstadoEdificio.working) {
                m.mostrarA();
            }
        }
    }

    @Override
    public void mostrarFID() {
        for (Recurso r : fabricas) {
            if (r.Estado() == EstadoEdificio.working) {
                r.mostrarA();
            }
        }
    }

    @Override
    public void mostrarUniD() {
        int acum1 = 0, acum2 = 0, acum3 = 0, acum4 = 0;
        for (unidad r : listaUnidades) {
            if (r.estado() == estadoUnidad.enBase || r.estado() == estadoUnidad.enTEnemigo) {
                if (r.tipoN() == 1) {
                    acum1++;
                }
                if (r.tipoN() == 2) {
                    acum2++;
                }
                if (r.tipoN() == 3) {
                    acum3++;
                }
                if (r.tipoN() == 4) {
                    acum4++;
                }
            }
        }
        System.out.println("Tiene en total " + acum1 + " " + unidad1.toString());
        System.out.println("Tiene en total " + acum2 + " " + unidad2.toString());
        System.out.println("Tiene en total " + acum3 + " " + unidad3.toString());
        System.out.println("Tiene en total " + acum4 + " " + especialista.toString());
    }

    public boolean Especialista() {
        for (unidad u : listaUnidades) {
            if (u.tipoN() == 4&&u.estado()!=estadoUnidad.muerto) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean nexovivo(){
        return Nexo.TakeDamage(0);
    }
    
}
