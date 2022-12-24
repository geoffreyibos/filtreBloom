/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import s3.pkg8_algorithmique.FiltreBloom_ArrayList;
import s3.pkg8_algorithmique.FiltreBloom_LinkedList;
import s3.pkg8_algorithmique.FiltreBloom_Tableau;
import tests.Benchmark;
import app.App;
        
/**
 *
 * @author geoff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // On définit la taille du filtre
        int m = 100000;
        // On définit le nombre de hachages
        int k = 1;
        // On définit le nombre d'éléments à ajouter
        int n = 1000;
        
        // On initialise les filtres de Bloom avec les différentes implémentations
        FiltreBloom_Tableau bloomTab = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList = new FiltreBloom_LinkedList(m, k);
        
        // Test avec le benchmark pour le tableau
        Benchmark b = new Benchmark(bloomTab);
        b.ajoutElemRandom(n);
        System.out.println("Avec un tableau :\n");
        b.tempsRechercheElem(m, k, n);
        b.tauxErreur(m, k);
        
        // Test avec le benchmark pour l'ArrayList
        Benchmark b2 = new Benchmark(bloomArrayList);
        b2.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :\n");
        b2.tempsRechercheElem(m, k, n);
        b2.tauxErreur(m, k);
        
        // Test avec le benchmark pour la LinkedList
        Benchmark b3 = new Benchmark(bloomLinkedList);
        b3.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :\n");
        b3.tempsRechercheElem(m, k, n);
        b3.tauxErreur(m, k);
        
        // On teste avec des nouvelles valeurs pour k et n
        k = 3;
        n = 5000;
        FiltreBloom_Tableau bloomTab2 = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList2 = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList2 = new FiltreBloom_LinkedList(m, k);
        
        Benchmark b4 = new Benchmark(bloomTab2);
        b4.ajoutElemRandom(n);
        System.out.println("Avec un tableau :\n");
        b4.tempsRechercheElem(m, k, n);
        b4.tauxErreur(m, k);
        
        Benchmark b5 = new Benchmark(bloomArrayList2);
        b5.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :\n");
        b5.tempsRechercheElem(m, k, n);
        b5.tauxErreur(m, k);
        
        Benchmark b6 = new Benchmark(bloomLinkedList2);
        b6.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :\n");
        b6.tempsRechercheElem(m, k, n);
        b6.tauxErreur(m, k);
        
        // On teste avec des nouvelles valeurs pour k et n
        k = 5;
        n = 10000;
        FiltreBloom_Tableau bloomTab3 = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList3 = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList3 = new FiltreBloom_LinkedList(m, k);
        
        Benchmark b7 = new Benchmark(bloomTab3);
        b7.ajoutElemRandom(n);
        System.out.println("Avec un tableau :\n");
        b7.tempsRechercheElem(m, k, n);
        b7.tauxErreur(m, k);
        
        Benchmark b8 = new Benchmark(bloomArrayList3);
        b8.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :\n");
        b8.tempsRechercheElem(m, k, n);
        b8.tauxErreur(m, k);
        
        Benchmark b9 = new Benchmark(bloomLinkedList3);
        b9.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :\n");
        b9.tempsRechercheElem(m, k, n);
        b9.tauxErreur(m, k);
        
        // On teste en augmentant la taille du tableau
        m = 200000;
        k = 1;
        n = 2000;
        FiltreBloom_Tableau bloomTab4 = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList4 = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList4 = new FiltreBloom_LinkedList(m, k);
        
        Benchmark b10 = new Benchmark(bloomTab4);
        b10.ajoutElemRandom(n);
        System.out.println("Avec un tableau :");
        b10.tempsRechercheElem(m, k, n);
        b10.tauxErreur(m, k);

        Benchmark b11 = new Benchmark(bloomArrayList4);
        b11.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :");
        b11.tempsRechercheElem(m, k, n);
        b11.tauxErreur(m, k);
        
        Benchmark b12 = new Benchmark(bloomLinkedList4);
        b12.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :");
        b12.tempsRechercheElem(m, k, n);
        b12.tauxErreur(m, k);
        
        // On teste avec des nouvelles valeurs pour k et n
        k = 3;
        n = 10000;
        FiltreBloom_Tableau bloomTab5 = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList5 = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList5 = new FiltreBloom_LinkedList(m, k);
        
        Benchmark b13 = new Benchmark(bloomTab5);
        b13.ajoutElemRandom(n);
        System.out.println("Avec un tableau :");
        b13.tempsRechercheElem(m, k, n);
        b13.tauxErreur(m, k);

        Benchmark b14 = new Benchmark(bloomArrayList5);
        b14.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :");
        b14.tempsRechercheElem(m, k, n);
        b14.tauxErreur(m, k);
        
        Benchmark b15 = new Benchmark(bloomLinkedList5);
        b15.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :");
        b15.tempsRechercheElem(m, k, n);
        b15.tauxErreur(m, k);
        
        // On teste avec des nouvelles valeurs pour k et n
        k = 5;
        n = 20000;
        FiltreBloom_Tableau bloomTab6 = new FiltreBloom_Tableau(m, k);
        FiltreBloom_ArrayList bloomArrayList6 = new FiltreBloom_ArrayList(m, k);
        FiltreBloom_LinkedList bloomLinkedList6 = new FiltreBloom_LinkedList(m, k);
        
        Benchmark b16 = new Benchmark(bloomTab6);
        b16.ajoutElemRandom(n);
        System.out.println("Avec un tableau :");
        b16.tempsRechercheElem(m, k, n);
        b16.tauxErreur(m, k);

        Benchmark b17 = new Benchmark(bloomArrayList6);
        b17.ajoutElemRandom(n);
        System.out.println("Avec une ArrayList :");
        b17.tempsRechercheElem(m, k, n);
        b17.tauxErreur(m, k);
        
        Benchmark b18 = new Benchmark(bloomLinkedList6);
        b18.ajoutElemRandom(n);
        System.out.println("Avec une LinkedList :");
        b18.tempsRechercheElem(m, k, n);
        b18.tauxErreur(m, k);
        
        // On lance l'application
        App app = new App();
        app.run();
    }
    
}
