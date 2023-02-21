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
public class DatabazePoj {
    private final ArrayList<Pojistenec> pojistnici;

    public DatabazePoj() {
        pojistnici = new ArrayList<>();
    }

    /* Funkce vytvoří nového pojištěnce a přidá ho databáze */
    public void pridejPoj(String jmeno, String prijmeni, long tel, int vek) {
        pojistnici.add(new Pojistenec(jmeno, prijmeni, tel, vek));

    }

    /* Funkce vypíše všechny pojištěnce v databázi */
    public void vypisPoj() {
        for (Pojistenec pojistenec : pojistnici) {
            if (!(pojistnici.isEmpty())) {
                System.out.println(pojistenec);
            }
        }
        if (pojistnici.isEmpty()) {
            System.out.println("V databázi není evidován žádný pojištěný");
        }
    }

    /* Funkce najde a vypíše daného pojištěnce */
    public void najdiPoj(String inputJmeno, String inputPrijmeni) {
        ArrayList<Pojistenec> nalez = new ArrayList<>();
        for (Pojistenec pojistenec : pojistnici) {
            if (inputJmeno.equals(pojistenec.getJmeno()) && inputPrijmeni.equals(pojistenec.getPrijmeni())) {
                nalez.add(pojistenec);
                System.out.println(pojistenec);
            }
        }
        // Výpis pokud je databáze prázdná nebo hledaný pojištěný není v evidován
        if (pojistnici.isEmpty()) {
            System.out.println("Databáze je prázdná");
        } else if (nalez.isEmpty()) {
            System.out.println("Toto jméno neevidujeme");
        }
    }

    /* Funkxw k smazání konkrétního pojištěného */
    public void smazPoj(String inputJmeno, String inputPrijmeni) {
        for (Pojistenec pojistenec : pojistnici) {
            if (inputJmeno.equals(pojistenec.getJmeno()) && inputPrijmeni.equals(pojistenec.getPrijmeni())) {
                pojistnici.remove(pojistenec);
                System.out.println("Pojištěný byl smazán");
            } else {
                System.out.println("Pojištěného se nepodařilo vyhledat");
            }
        }
    }
}
