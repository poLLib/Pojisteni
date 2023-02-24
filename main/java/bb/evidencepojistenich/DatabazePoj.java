/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

import java.util.ArrayList;

/**
 * Třída je databází, která slouží k vyhledávání a ukládání pojištěnců do ArrayListu
 *
 * @author pollib
 */


/**
 * TO-DO-LIST DatabazePoj !!!!!!!!!!
 * * upravPoj použiji setX()
 * uprav pridejPoj() metodou static přideluj unikátní ID každému novému poj. / uprav metodu smazPoj() aby mazala jen podle ID čísla / datum vzniku
 * nacti/uloz do souboru
 */


public class DatabazePoj {
    private final ArrayList<Pojistenec> pojistnici;

    public DatabazePoj() {
        pojistnici = new ArrayList<>();     // Vytvoření instance ArrayListu, reprezentujícího databázi
    }

    /**
     * Metoda přidá nového pojištěného do databáze
     *
     * @param jmeno
     * @param prijmeni
     * @param tel
     * @param vek
     */
    public void pridejPoj(String jmeno, String prijmeni, String tel, int vek) {
        pojistnici.add(new Pojistenec(jmeno, prijmeni, tel, vek));

    }

    /**
     * Metoda vypíše všechny pojištěnce v databázi
     */
    public void vypisPoj() {

        // Cyklus vypisující všechny pojištěný
        for (Pojistenec pojistenec : pojistnici) {
            System.out.println(pojistenec);
        }
        if (pojistnici.isEmpty()) {
            System.out.println("V databázi není evidován žádný pojištěný");
        }
    }

    /**
     * Metoda najde a vypíše daného pojištěnce
     *
     * @param vstupJmenoPrijmeni - zvolíme, na jaký vstup se nás bude metoda ptát
     */
    public void najdiPoj(String vstupJmenoPrijmeni) {
        boolean nalez = false;

        // Cyklus, hledající shodu jména a příjmení z uživatelského vstupu s uloženými v databázi
        for (Pojistenec pojistenec : pojistnici) {
            if (pojistenec.getJmeno().contains(vstupJmenoPrijmeni) || pojistenec.getPrijmeni().contains(vstupJmenoPrijmeni)) {
                System.out.println(pojistenec);
                nalez = true;
            }
        }

        // Výpis pokud je databáze prázdná nebo hledaný pojištěný není v evidován
        if (pojistnici.isEmpty()) {
            System.out.println("Databáze je prázdná");
        } else if (!nalez) {
            System.out.println("Toto jméno v databázi neevidujeme");
        }
    }


    // !!!!! POUŽIJ SETTERY
   /* public void upravPoj(String vstupJmenoPrijmeni, String vstupPrijmeni, String novyJmeno, String novyPrijmeni, long novyTel, int vek) {
        for (Pojistenec pojistenec : pojistnici) {
            if (vstupJmenoPrijmeni.equals(pojistenec.getJmeno()) && vstupPrijmeni.equals(pojistenec.getPrijmeni())) {
                pojistnici.remove(pojistenec);
            }
        }
        pojistnici.add(new Pojistenec(novyJmeno, novyPrijmeni, novyTel, vek));
    }
    */

    /**
     * Metoda k smazání konkrétního pojištěného
     *
     * @param vstupJmeno - zadej přesné jméno
     * @param vstupPrijmeni - zadej přesné příjmení
     */
    public void smazPoj(String vstupJmeno, String vstupPrijmeni) {

        // Cyklus hledající shodu jména a příjmení uživatelského vstupu s uloženými v databázi
        for (Pojistenec pojistenec : pojistnici) {
            if (vstupJmeno.equalsIgnoreCase(pojistenec.getJmeno()) && vstupPrijmeni.equalsIgnoreCase(pojistenec.getPrijmeni())) {
                pojistnici.remove(pojistenec);
                System.out.println("Pojištěný byl smazán");
            } else {
                System.out.println("Pojištěného se nepodařilo vyhledat");
            }
        }
    }
}
