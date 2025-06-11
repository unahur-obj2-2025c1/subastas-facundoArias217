package ar.edu.unahur.obj2.observer.observadores;
import ar.edu.unahur.obj2.observer.Oferta;

public class SubastadorConLimite extends Subastador {

   
    public SubastadorConLimite(String nombre) {
        super(nombre);
    }

    @Override
    public Oferta crearOferta() {
        if(Umbral.getValorBase() < this.calcularMonto()){
            throw new IllegalArgumentException("El monto de la oferta supera el límite del umbral.");
        } 
        return new Oferta(this, this.calcularMonto());
    }

}
