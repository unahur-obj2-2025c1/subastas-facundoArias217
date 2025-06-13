package ar.edu.unahur.obj2.observer.observadores;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.estrategias.Arriesgada;
import ar.edu.unahur.obj2.observer.estrategias.EstrategiaOferta;

public class Subastador implements Observer {
    private String nombre;
    private Oferta ultimaOferta;
    private EstrategiaOferta estrategia;

    public Subastador(String nombre, EstrategiaOferta estrategia) {
        this.nombre = nombre;
        this.ultimaOferta = null;
        this.estrategia = estrategia;
    }
    public Subastador(String nombre) {
        this.nombre = nombre;
        this.ultimaOferta = null;
        this.estrategia = new Arriesgada();
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

    public void reset(){
        this.ultimaOferta = null;
    }

    public Oferta crearOferta(){
        Double monto = estrategia.calcularMonto(ultimaOferta);
        return new Oferta(this, monto);
    };

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta;
    }
}
