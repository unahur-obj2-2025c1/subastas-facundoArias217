package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;

public abstract class EstrategiaOferta {

    public Double calcularMonto(Oferta oferta) {
        var monto = 0.0;
        
        if (!this.validar(oferta)) {
            throw new OfertaSubastadorException("Este subastador no puede ofertar");
        } 
        
        if(oferta != null){
            monto = oferta.getMonto() + 10.0;
        } else{
            monto = 10.0;
        }
        this.notificarOferta();
        return monto;
    }


    protected void notificarOferta(){}
    public abstract Boolean validar(Oferta oferta);
}