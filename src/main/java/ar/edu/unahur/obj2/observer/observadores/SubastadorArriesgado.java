package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;

public class SubastadorArriesgado extends Subastador {

    public SubastadorArriesgado(String nombre) {
        super(nombre);
    }
    

    @Override
    public Oferta crearOferta() {     
        return new Oferta(this, this.calcularMonto());
    }
}
