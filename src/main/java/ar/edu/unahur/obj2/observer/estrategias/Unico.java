package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;

public class Unico extends EstrategiaOferta{
    private Boolean yaOferto = false;
    
    @Override
    public Boolean validar(Oferta oferta) {
        return !yaOferto;
    }
    
    @Override
    protected void notificarOferta(){
        this.yaOferto = true;
    }
}
