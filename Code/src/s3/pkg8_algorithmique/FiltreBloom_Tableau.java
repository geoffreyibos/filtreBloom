/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.pkg8_algorithmique;

/**
 *
 * @author geoff
 */
public class FiltreBloom_Tableau extends AFiltreBloom {
    // Le filtre de Bloom avec un tableau
    private boolean[] tabBooleens;

    /**
     * Constructeur de la classe FiltreBloom_Tableau
     * @param taille la taille du tableau
     * @param k le nombre de hachages
     */
    public FiltreBloom_Tableau(int taille, int k) {
        super(taille, k);
        tabBooleens = new boolean[m];
        for (int i = 0; i < m; i++) {
            tabBooleens[i] = false;
        }
    }
    
    @Override
    public void afficher() {
        for (boolean b : tabBooleens) {
            System.out.println(b);
        }
    }
    
    @Override
    public void ajoutElemFiltre(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            tabBooleens[elt2] = true;
        }
    }
    
    @Override
    public boolean testPresenceElem(int elt) {
        int elt2 = 0;
        for (int i = 0; i < nbHachages; i++) {
            elt2 = hachage(elt, i);
            if(!tabBooleens[elt2]) {
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
            if (tabBooleens[i]) {
                tabBooleens[i] = false;
            }
        }
    }
    
}
