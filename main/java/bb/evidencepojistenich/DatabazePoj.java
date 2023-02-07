/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

import java.util.ArrayList;

/**
 * Třída je databází, která slouží k vyhledávání a ukládání pojištěnců do ArrayListu
 * @author billove
 */
public class DatabazePoj{
    private ArrayList<Pojistenec> pojistnici;
    
    public DatabazePoj() {
        pojistnici = new ArrayList<>();
    }
    /* Funkce vytvoří nového pojištěnce a přidá do databáze */
    public void pridejPoj (String jmeno, String prijmeni, int tel, int vek) {
        pojistnici.add(new Pojistenec(jmeno, prijmeni, tel, vek));
    
    }
    /* Funkce vypíše všechny pojištěnce v databázi */
    public void vypisPoj() {
        for(Pojistenec pojistnik : pojistnici) {
            if (!(pojistnici.isEmpty())) {
            System.out.println(pojistnik);
            } else {
                System.out.println("V databázi není evidován žádný pojištěný");
            }
        }
    }
    /* Funkce najde a vypíše daného pojištěnce */
    public void najdiPoj(String inputJmeno, String inputPrijmeni) {
        ArrayList<Pojistenec> nalez = new ArrayList<>();
                    for (Pojistenec pojistnik : pojistnici) {
                        if (inputJmeno.equals(pojistnik.getJmeno()) && inputPrijmeni.equals(pojistnik.getPrijmeni())) {
                        nalez.add(pojistnik);
                            System.out.println(pojistnik);
                    } else if (pojistnici.isEmpty()) {
                            System.out.println("Databáze je prázdná");
                    } else {
                        System.out.println("Toto jméno neevidujeme");
                    }
                    
                }
        }
}
