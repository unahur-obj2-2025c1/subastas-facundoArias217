package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;

class ProductoSubatadoTest {

    private ProductoSubastado delorean;
    private Subastador gonzager;
    private Subastador martomau;
    private Subastador diazdan;

    @BeforeEach
    public void setup() {
        delorean = new ProductoSubastado();

        gonzager = new Subastador("gonzager");
        martomau = new Subastador("martomau");
        diazdan = new Subastador("diazdan");

        delorean.addObservador(gonzager);
        delorean.addObservador(martomau);
    }

    private void escenario1() {
        Oferta oferta1 = martomau.crearOferta();
        delorean.agregarOferta(oferta1);

        Oferta oferta2 = gonzager.crearOferta();
        delorean.agregarOferta(oferta2);

        Oferta oferta3 = martomau.crearOferta();
        delorean.agregarOferta(oferta3);

    }

    @Test
    public void losSubastadoresGonzaYMartoRecibeCorrectamenteLaUltimaOferta() {
        escenario1();

        assertEquals(30.0, martomau.getOferta().getMonto());
        assertEquals(30.0, gonzager.getOferta().getMonto());
    }

    @Test
    public void laUltimaOfertaRegistradaEsDeMartomau() {
        escenario1();

        assertEquals("martomau", delorean.getUltimaOferta().getSubastador().getNombre());
    }

    @Test
    public void elValorDeLaUltimaOfertaEs30() {
        escenario1();

        assertEquals(30.0, delorean.getUltimaOferta().getMonto());
    }

    @Test
    public void lasOfertasRegistradasSonTres() {
        escenario1();

        assertEquals(3, delorean.getOfertas().size());
    }

    @Test
    public void alAgregarUnaOfertaDeDiazdanSeLanzaUnaExcepcion() /*Mismo test que el que sigue pero con try/catch */ {
        /*
         * diazdan.crearOferta(); -> rompre porque como no es participante, no se
         * actualiza automaticamente
         * su estado de ultimaOferta
         */
        Oferta oferta = diazdan.crearOferta();
        diazdan.setOferta(oferta);
        try {
            delorean.agregarOferta(diazdan.getOferta());
        } catch (Exception e) {
            assertEquals("El subastador no participa de la subasta", e.getMessage());
        }
    }

    @Test
    public void lanzarExcepcionCuandoSubastadorNoParticipa() /*Mismo test que el de arriba */ {
        // Dado un subastador que no participa
        Oferta ofertaDeDiazdan = new Oferta(diazdan, 10.0);

        // Cuando intenta agregar la oferta, entonces se lanza la excepción esperada
        OfertaSubastadorException exception = assertThrows(
                OfertaSubastadorException.class,
                () -> delorean.agregarOferta(ofertaDeDiazdan));

        assertEquals("El subastador no participa de la subasta", exception.getMessage());
    }
}
