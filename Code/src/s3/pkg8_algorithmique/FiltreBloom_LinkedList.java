/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.pkg8_algorithmique;

import java.util.LinkedList;

/**
 *
 * @author geoff
 */
public class FiltreBloom_LinkedList extends AFiltreBloom {
    // Le filtre de Bloom avec une LinkedList
    private LinkedList<Boolean> linkedlist;

    /**
     * Constructeur de la classe FiltreBloom_LinkedList
     * @param taille la taille de la LinkedList
     * @param k le nombre de hachages
     */
    public FiltreBloom_LinkedList(int taille, int k) {
        super(taille, k);
        linkedlist = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            linkedlist.add(i, false);
        }
    }
    
    @Override
    public void afficher() {
        for (boolean b : linkedlist) {
            System.out.println(b);
        }
    }
    
    @Override
    public void ajoutElemFiltre(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            linkedlist.set(elt2, true);
        }
    }
    
    @Override
    public boolean testPresenceElem(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            if(!linkedlist.get(elt2)) {
                // L'élément n'est pas dans le filtre
                return false;
            }
        }
        // L'élément est potentiellement dans le filtre
        return true;
    }
    
    @Override
    public void supprimerElem() {
        for (int i = 0; i < m; i++) {
            if (linkedlist.get(i)) {
                linkedlist.set(i, false);
            }
        }
    }
}
