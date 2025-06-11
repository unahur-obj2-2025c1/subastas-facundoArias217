package ar.edu.unahur.obj2.observer.observadores;
import ar.edu.unahur.obj2.observer.Oferta;

public abstract class Subastador implements Observer {
    protected String nombre;
    protected Oferta ultimaOferta;

    public Subastador(String nombre) {
        this.nombre = nombre;
        this.ultimaOferta = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Oferta getOferta() {
        return ultimaOferta;
    }

    //Lo creo solo para el test, porque sino rompe
    public void setOferta(Oferta oferta) {
        this.ultimaOferta = oferta;
    }

    public Double calcularMonto() {
        var monto = 0.0;
        if(ultimaOferta != null) {
            monto = ultimaOferta.getMonto() + 10.0;
        }
        else {
            monto = 10.0; // Si no hay oferta previa, inicia con 10
        }    
        return monto;
    }

    public void reset(){
        this.ultimaOferta = null;
    }

    public abstract Oferta crearOferta();

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta;
    }
}
