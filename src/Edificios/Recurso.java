/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import Enums.EstadoEdificio;
import Enums.RecursoProduccionPorRaza;

/**
 *
 * @author mcdre
 */
public class Recurso {

    int produccionF;
    int fCreado;
    int tEsp;
    int limit;
    int acum;
    int tipo;
    public double vida;
    int Id;
    EstadoEdificio estado;

    public Recurso( RecursoProduccionPorRaza tipe, int fcre, int tipo, int id) {
        this.produccionF =tipe.produccionXFase();
        this.fCreado = fcre;
        this.tEsp = tipe.tEsp();
        this.limit = tipe.limite();
        this.acum = 0;
        this.tipo = tipo;
        this.vida = tipe.vida();
        this.Id = id;
        this.estado = EstadoEdificio.working;
    }

    public void Acumular(int fase) {
        if (tEsp < fase - fCreado && estado == EstadoEdificio.working) {
            if (acum + produccionF < limit) {
                acum = acum + produccionF;
            } else {
                acum = limit;
            }
        }
    }

    public int Recolectar() {
        if (estado == EstadoEdificio.working) {
            int acu = acum;
            acum = 0;
            return acu;
        } else {
            return 0;
        }

    }

    public int tipo() {
        return tipo;
    }

    public int id() {
        return Id;
    }

    public void recibirDanno(double danno) {
        if (vida - danno <= 0) {
            vida = 0;
            this.estado = EstadoEdificio.destroyed;
        } else {
            vida = vida - danno;
        }
    }

    public EstadoEdificio Estado() {
        return estado;
    }

}
