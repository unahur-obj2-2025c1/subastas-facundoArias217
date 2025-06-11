package ar.edu.unahur.obj2.observer.observadores;
import ar.edu.unahur.obj2.observer.Oferta;

public class SubastadorUnico extends Subastador {
    private Boolean yaOferto = false;

    public SubastadorUnico(String nombre) {
        super(nombre);
    }

    @Override
    public Oferta crearOferta() {
        if (yaOferto) {
            throw new IllegalStateException("El subastador " + this.nombre + " ya ha realizado una oferta.");
        }
        this.yaOferto = true;
        return new Oferta(this, this.calcularMonto());
    }


    public Boolean getYaOferto() {
        return yaOferto;
    }


}
