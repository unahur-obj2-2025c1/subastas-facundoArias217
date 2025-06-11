package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    private final Subastador subastador;
    private final Double monto;

    public Oferta(Subastador subastador, Double monto) {
        if(monto <= 0) {
            throw new IllegalArgumentException("El monto de la oferta debe ser un número positivo.");
        }
        this.monto = monto;
        this.subastador = subastador;
    }

    public Subastador getSubastador() {
        return subastador;
    }

    public Double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return  subastador + "oferta: " + monto + "$";
    }

    

}
