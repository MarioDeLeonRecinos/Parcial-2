/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadesYCosto;

/**
 *
 * @author mcdre
 */
public class Costo {
    public int rec1;
    public int rec2;
    public int rec3;
    
    public Costo(int recu1,int recu2,int recu3){
        rec1=recu1;
        rec2=recu2;
        rec3=recu3;
    }
    
    public Costo calcularTotal(int cantidad){
        Costo aux = new Costo(rec1*cantidad,rec2*cantidad,rec3*cantidad);
        return aux;
    }
    
}
