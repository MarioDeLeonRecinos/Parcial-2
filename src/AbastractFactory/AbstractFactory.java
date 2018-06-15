/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbastractFactory;

import AbstractFactory.Razas.Raza;


/**
 *
 * @author LN710Q
 */
public interface AbstractFactory {
    abstract Raza getRazaAEscoger(int operacion);
}