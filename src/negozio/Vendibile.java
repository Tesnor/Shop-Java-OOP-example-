/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negozio;

/**
 *
 * @author User-1107
 */
public interface Vendibile {
    
  public int vediPrezzo();
  public Object tipologia();
  public boolean verifica(Object marcaProdotto);
  public void ordinaMerce();
    
}
