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
public class Dolci extends Prodotto {

   
    public enum tipoProdotto {
        BACI(5), POCKETCOFFEE(3), LIQUIRIZIA(3), CARAMELLE(2);

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
    }

    @Override
    public String toString() {
        return "\n Tipologia prodotto: dolci. Marca: " + prodotto + ". Sconto: " + getSconto() + ". Scadenza: " + data + ". Prezzo unitario: " + prodotto.prezzo + " € \n";
    }

}
