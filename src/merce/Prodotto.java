package merce;

import negozio.Console;
import negozio.Vendibile;
import java.time.LocalDate;


public abstract class Prodotto implements Vendibile {

    // public Prodotto() {}   //Costruttore di Default
    
    private int sconto;
    private boolean dutyFree;
    LocalDate data = LocalDate.now();

    enum tipoMerce {
        DOLCI, ALCOLICI
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public boolean isDutyFree() {
        return dutyFree;
    }

    public void setDutyFree(boolean dutyFree) {
        this.dutyFree = dutyFree;
    }

    public static Prodotto getInstance() {
        tipoMerce prodotti = Console.leggiEnum("\n Scrivi il prodotto da acquistare... ", tipoMerce.values());

        switch (prodotti) {
            case DOLCI: {
                return new Dolci();
            }

            case ALCOLICI:
                return new Alcolici();
        }
        return null;
    }

    public void etichettatura(int s) {
        sconto = s;
        data = data.plusYears(5);
    }

}
