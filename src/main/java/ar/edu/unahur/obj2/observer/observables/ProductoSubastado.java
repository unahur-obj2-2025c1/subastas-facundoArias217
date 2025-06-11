package ar.edu.unahur.obj2.observer.observables;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;


import java.util.ArrayList;
import java.util.List;

public class ProductoSubastado implements Observable{
    List<Observer> observadores = new ArrayList<>();
    List<Oferta> ofertas = new ArrayList<>();
    
    public ProductoSubastado(List<Observer> observadores, List<Oferta> ofertas) {
        this.observadores = observadores;
        this.ofertas = ofertas;
    }
    public ProductoSubastado(){
    }

    public void agregarOferta(Oferta oferta) {
        if (!observadores.contains(oferta.getSubastador())) {
            throw new OfertaSubastadorException("El subastador no participa de la subasta");
        }

        this.ofertas.add(oferta);
        this.notificar(oferta);
    }

    public void reset(){
        this.ofertas.clear();
        this.observadores.clear();;
    }

    public Oferta getUltimaOferta() {
        if (this.ofertas.isEmpty()) {
            return null;
        }
        return this.ofertas.get(this.ofertas.size() - 1);
    }

    public List<Oferta> getOfertas() {
        return this.ofertas;
    }

    public List<Observer> getObservadores() {
        return this.observadores;
    }

    
    @Override
    public void addObservador(Observer observer) {
        this.observadores.add(observer);        
    }
    @Override
    public void notificar(Oferta oferta) {
        observadores.stream()
        .forEach(o -> o.actualizar(oferta));        
    }
    @Override
    public void quitarObservador(Observer observer) {
        this.observadores.remove(observer);                
    }


}
