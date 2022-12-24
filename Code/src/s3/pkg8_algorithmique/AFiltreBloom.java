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
public abstract class AFiltreBloom implements IFiltreBloom {
    // La taille du tableau
    int m;
    // Le nombre de hachages
    int nbHachages;
    
    /**
     * Constructeur de la classe AFiltreBloom
     * @param taille la taille du filtre
     * @param k le nombre de hachages
     */
    public AFiltreBloom(int taille, int k) {
        m = taille;
        nbHachages = k;
    }
    
    @Override
    public int hachage(int elt, int i) {
        return elt*67*(i+1) % m;
    }
}
