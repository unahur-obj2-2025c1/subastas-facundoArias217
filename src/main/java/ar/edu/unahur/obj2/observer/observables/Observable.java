package ar.edu.unahur.obj2.observer.observables;
import ar.edu.unahur.obj2.observer.observadores.Observer;

import ar.edu.unahur.obj2.observer.Oferta;

public interface Observable {
    void addObservador(Observer observer);
    void quitarObservador(Observer observer); 
    void notificar(Oferta oferta);
}
