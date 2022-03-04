
package negozio;

import java.util.ArrayList;
import java.util.List;
import merce.Prodotto;


public class DutyFree {

    enum Menu {
        RIFORNIMENTO, NEGOZIO, VEDISTOCK, ESCI
    }

    enum Scelta {
        YES, NO
    }

    Scelta ris;

    int numArticoli = 1;

    private final List<Prodotto> stock = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        DutyFree shop = new DutyFree();
        Menu menu;

        do {
            System.out.println("\n");
            menu = Console.leggiEnum("\n Gestione Duty Free. Opzioni disponibili: ", Menu.values());
            switch (menu) {
                case RIFORNIMENTO:
                    shop.compra();
                    break;
                case NEGOZIO:
                    shop.vendi();
                    break;
                case VEDISTOCK:
                    shop.stampa();
                    break;
            }
        } while (menu != Menu.ESCI);
    }

    //---------------------------------fine MAIN-------------------------------
    private void compra() {

        do {

            Prodotto p = Prodotto.getInstance();
            p.ordinaMerce();
            numArticoli = Console.leggiInt("\n Quantità? \n");

            for (int i = 0; i < numArticoli; i++) {
                stock.add(p);
            }

            System.out.println("\n L'ordine è stato eseguito.. ");
            System.out.println("\n");

            ris = Console.leggiEnum("\n Altro ordine? ", Scelta.values());

        } while (ris == Scelta.YES);
    }

    private void vendi() {

        Prodotto merce = Prodotto.getInstance();
        Object articolo = merce.tipologia();
        int magazzino = 0;
        int tot = 0;
        int cont = 0;

        if (merce.getSconto() > 0) {
            System.out.println("\n Sul prodotto selezionato è presente uno sconto del " + merce.getSconto() + "% ");
        }

        numArticoli = Console.leggiInt("\n Quantità? ");

        ris = Console.leggiEnum("\n Confermo ordine? ", Scelta.values());

        switch (ris) {

            case YES:

                //if (stock.size() >= numArticoli) {
                for (Prodotto p : stock) {
                    if (p.verifica(articolo)) {
                        magazzino++;
                    }
                }

                if (magazzino >= numArticoli) {

                    for (Prodotto p : stock) {
                        if (p.verifica(articolo)) {

                            while (cont < numArticoli) {
                                stock.remove(p);
                                tot = tot + p.vediPrezzo();
                                cont++;
                            }
                            break;
                        }
                    }

                    System.out.println("\n Hai acquistato " + numArticoli + " " + articolo + " al costo di: " + tot + " €");
                    break;

                } else {
                    System.err.println(" Prodotto non disponibile nella quantità desiderata.. ");
                }

            
            case NO:
                break;
        }

    }

    private void stampa() {

        int tot = 0, i = 0;

        if (stock.isEmpty()) {
            System.out.println("\n Magazzino vuoto! ");
        } else {

            tot++;

            while (i < stock.size()) {

                while ((i + 1) < stock.size()) {

                    if (stock.get(i).equals(stock.get(i + 1))) {
                        tot++; i++;
                    } else break;
                   
                }

                System.out.println(stock.get(i) + "\n Totale confezioni in magazzino: " + tot + "\n ");
                tot = 1;
                i++;
            }

        }

    }
    
    
    private void stampa2(){
        
        int tot = 0, i = 0, check = 0; 
        Prodotto p;

        if (stock.isEmpty()) {
            System.out.println("\n Magazzino vuoto! ");
        } else {

            tot++;

            while (i < stock.size()) {
                
                p = stock.get(i);
                check = i;
                
                while ((i + 1) < stock.size()) {

                    if (p.equals(stock.get(i + 1))) {
                        tot++;
                        i++;
                    } 
                    i++;
                }

                System.out.println(stock.get(i) + "\n Totale confezioni in magazzino: " + tot + "\n ");
                tot = 1; i = check; i++; 
            }

        }

        
        
    }

}
