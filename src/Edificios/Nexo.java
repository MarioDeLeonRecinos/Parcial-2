/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

/**
 *
 * @author mcdre
 */
public class Nexo {

    double recurso1L = 10000;
    double recurso2L = 5000;
    double recurso3L = 3000;

    double recurso1A;
    double recurso2A;
    double recurso3A;

    int nivel;

    double vida;

    public Nexo() {
        recurso1L = 10000;
        recurso2L = 5000;
        recurso3L = 3000;

        recurso1A = 600;
        recurso2A = 600;
        recurso3A = 500;

        nivel = 0;

        vida = 200;
    }

    public void NexoSubirNivel(boolean cond) {
        if (cond == true) {
            switch (this.nivel) {
                case 0:
                    recurso1L = recurso1L * 1.1;
                    recurso2L = recurso2L * 1.1;
                    recurso3L = recurso3L * 1.1;
                    nivel = 1;
                    break;
                case 1:
                    recurso1L = recurso1L * 1.3;
                    recurso2L = recurso2L * 1.3;
                    recurso3L = recurso3L * 1.3;
                    nivel = 2;
                    break;
                case 2:
                    recurso1L = recurso1L * 1.5;
                    recurso2L = recurso2L * 1.5;
                    recurso3L = recurso3L * 1.5;
                    nivel = 3;
                    break;
                default:
                    System.out.println("Nivel maximo alcanzado");
            }
        }
    }

    public boolean CalcularSubirNivel() {
        double total = (0.25 * (recurso1L + recurso2L + recurso3L)) / 3;
        if (recurso1A >= total && recurso2A >= total && recurso3A >= total) {
            return true;
        } else {
            System.out.println("No puede subir nivel ya que no tiene suficientes recursos");
            return false;
        }
    }

    public void addRecursos(int rec1, int rec2, int rec3) {
        if (recurso1A + rec1 < recurso1L) {
            recurso1A = recurso1A + rec1;
        } else {
            if (recurso1A + rec1 >= recurso1L) {
                recurso1A = recurso1L;
            }
        }
        if (recurso2A + rec2 < recurso2L) {
            recurso2A = recurso2A + rec2;
        } else {
            if (recurso2A + rec2 >= recurso2L) {
                recurso2A = recurso2L;
            }
        }
        if (recurso3A + rec3 < recurso3L) {
            recurso3A = recurso3A + rec3;
        } else {
            if (recurso3A + rec3 >= recurso3L) {
                recurso3A = recurso3L;
            }
        }
    }

    public boolean takeRecursosB(int rec1, int rec2, int rec3) {
        if (recurso1A - rec1 >= 0 && recurso2A - rec2 >= 0 && recurso3A - rec3 >= 0) {
            return true;
        } else {
            return false;
        }

    }

    public void takeRecursosD(boolean cond, int rec1, int rec2, int rec3) {
        if (cond == true) {
            recurso1A = recurso1A - rec1;
            recurso2A = recurso2A - rec2;
            recurso3A = recurso3A - rec3;
        }
        else{
            System.out.println("No puede crear ese objeto con la cantidad de recursos que posee en este momento.");
        }
    }

    public boolean TakeDamage(double danno) {
        if (vida-danno <= 0) {
            vida=0;
            return false;
        } else {
            vida=vida-danno;
            return true;
        }

    }

    public double recurso1() {
        return recurso1A;
    }

    public double recurso2() {
        return recurso2A;
    }

    public double recurso3() {
        return recurso3A;
    }

    public void Limites() {
        System.out.println("Oro: " + recurso1L + " Madera: " + recurso2L + " Hierro: " + recurso3L);
    }

    public void nivelA() {
        System.out.println("El nivel actual del nexo es "+nivel);
    }

}
