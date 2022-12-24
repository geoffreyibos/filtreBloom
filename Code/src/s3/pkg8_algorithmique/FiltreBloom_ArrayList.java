/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.pkg8_algorithmique;

import java.util.ArrayList;

/**
 *
 * @author geoff
 */
public class FiltreBloom_ArrayList extends AFiltreBloom {
    // Le filtre de Bloom avec une ArrayList
    private ArrayList<Boolean> listBooleens;

    /**
     * Constructeur de la classe FiltreBloom_ArrayList
     * @param taille la taille de l'ArrayList
     * @param k le nombre de hachages
     */
    public FiltreBloom_ArrayList(int taille, int k) {
        super(taille, k);
        listBooleens = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            listBooleens.add(i, false);
        }
    }
    
    @Override
    public void afficher() {
        for (boolean b : listBooleens) {
            System.out.println(b);
        }
    }
    
    @Override
    public void ajoutElemFiltre(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            listBooleens.set(elt2, true);
        }
    }
    
    @Override
    public boolean testPresenceElem(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            if(!listBooleens.get(elt2)) {
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
            if (listBooleens.get(i)) {
                listBooleens.set(i, false);
            }
        }
    }
}
