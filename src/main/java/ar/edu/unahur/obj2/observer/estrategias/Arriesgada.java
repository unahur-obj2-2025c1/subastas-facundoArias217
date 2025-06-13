package ar.edu.unahur.obj2.observer.estrategias;
import ar.edu.unahur.obj2.observer.Oferta;

public class Arriesgada extends EstrategiaOferta{

    @Override
    public Boolean validar(Oferta oferta) {
        return Boolean.TRUE;
    }
 
}
