/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merce;

import negozio.Console;

/**
 *
 * @author User-1107
 */
public class Alcolici extends Prodotto {

    
    public enum tipoProdotto {
        
         JOHNNYWALKER(11), LAGAVULLIN(25), PAMPERO(10), JACKDANIELS(13);
         private final int prezzo;

         private tipoProdotto(int prezzo) {
         this.prezzo = prezzo;
        }
    }

    

    private tipoProdotto prodotto;

    @Override
    public boolean verifica(Object articolo) {
        return prodotto.equals(articolo);
    }

    @Override
    public Object tipologia() {
        tipoProdotto c = Console.leggiEnum("\n Tipo di prodotto? ", tipoProdotto.values());
        return c;
    }

    @Override
    public int vediPrezzo() {
        return prodotto.prezzo;
    }

    @Override
    public void ordinaMerce() {
        prodotto = Console.leggiEnum("\n Prodotto da ordinare? ", tipoProdotto.values());
        super.etichettatura(0);
        super.setDutyFree(true);
    }

    @Override
    public String toString() {
        if (isDutyFree()) {
            return "\n Tipologia prodotto: alcolici. Marca: " + prodotto + ". Prezzo: " + prodotto.prezzo + " € (Il prodotto è 'duty free') \n";
        } else {
            return "\n Tipologia prodotto: alcolici. Marca: " + prodotto + "\n";
        }

    }

}
