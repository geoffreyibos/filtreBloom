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
public interface IFiltreBloom {
    // Affiche les éléments du filtre
    public void afficher();
    // Permet de hacher l'élément passé en paramètre, en fonction de i
    public int hachage(int elt, int i);
    // Ajoute l'élément passé en paramètre au filtre de Bloom
    public void ajoutElemFiltre(int elt);
    // Teste la présence de l'élément en paramètre dans le filtre
    public boolean testPresenceElem(int elt);
    // Met tous les éléments du filtre à false
    public void supprimerElem();
}
