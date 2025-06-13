package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Umbral;

public class ConLimite extends EstrategiaOferta{

    @Override
    public Boolean validar(Oferta oferta) {
        return Umbral.getValorBase() > oferta.getMonto() + 10.0;
    }
}
