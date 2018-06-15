/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.Razas;

import Enums.BarracasTipos;
import UnidadesYCosto.Costo;
import UnidadesYCosto.unidad;
import java.util.ArrayList;

/**
 *
 * @author mcdre
 */
public interface Raza {
    public void NexoCrear();
    public void soldado(int cantidad, int fase);
    public void espe(int fase);
    public void imprimirUnidades() ;
    public void vehiculo1(int cantidad, int fase);
    public void vehiculo2(int cantidad, int fase);
    public void Fabrica(int cantidad, int tipo, int fase);
    public void miliFabrica(int cantidad, BarracasTipos tipo, int fase);
    public void PedirTropas(int cantidad,int tipo);
    public void RecibirTropas(int fase);
    public void addRecursos();
    public void acumularRecursos(int fase) ;
    public void mostrarR() ;
    public ArrayList<unidad> calcularDanno(ArrayList<unidad> unidades, int fase) ;
    public void recursosL();
    public void NivelUp() ;
    public void nivelActual();
    public boolean NexoAtackTorF() ;
    public ArrayList<unidad> peleaDeUnidades(ArrayList<unidad> unidades);
    public boolean noAtaco() ;
    public void DefenderAlerta(int fase) ;
    public boolean darOrdenesDefensa(int fase, int tipoE, int cantidad, int tipoU) ;
    public int darOrdenesAtaque(int fase, int tipoE,int cantidad,int tipoU);
    public void newUnidades(ArrayList<unidad> unidades);
    public ArrayList<unidad> enviarUnidades();
    public Costo CalcularCosto(int opcion,int cantidad);
    public void crearObjeto(int opcion, int fase,int tipo,int cantidad,int tipoUnidad,boolean nexo);
    public int EspacioDisponible(int tipo);
    public int MaximoAProducirEstaFase(int Limite, int tipo);
    public void mostrarF();
    public void mostrarM();
    public void mostrarMId();
    public void mostrarFID();
    public void mostrarUniD();
    public boolean nexovivo();
}
