package ar.edu.unahur.obj2.observer.observadores;

public class Umbral {

    private static Double valorBase = 60.0;

    private Umbral() {}  // Evita instanciación

    public static Double getValorBase() {
        return valorBase;
    }

    public static void setValorBase(Double valorBase) {
        Umbral.valorBase = valorBase;
    }
}
