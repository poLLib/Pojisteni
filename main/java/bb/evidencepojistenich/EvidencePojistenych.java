/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bb.evidencepojistenich;

/**
 * @author pollib
 */
public class EvidencePojistenych {
    public static void main(String[] args) {
        UzivatelskeRozhrani uzivatelI = new UzivatelskeRozhrani();

        /* Začátek cyklu uživatelské relace/cyklu
          Uživatel zvolí příkaz zadáním čísla
         */
        boolean konec = false;
        while (!konec) {
            System.out.printf(uzivatelI.vypisMenu()); // Vypíše hlavní menu
            try {
                int vstup = uzivatelI.volbaMenu();
                if (vstup >= 1 && vstup <= 5) {
                    switch (vstup) {

                        /* Příkaz k zaevidování nového pojištěnce --> @jmeno @prijmení @tel @vek */
                        case 1 -> uzivatelI.pridejPoj();

                        /* Příkaz k vypsání všech pojištěných */
                        case 2 -> uzivatelI.vypisVsePoj();

                        /* Přikaz k vyhledání konkrétního pojištěnce podle jména a příjmení --> @jmeno @prijmení */
                        case 3 -> uzivatelI.vypisPoj();

                        /* Příkaz k smazání konkrétního pojištěnce */
                        case 4 -> uzivatelI.smazPoj();

                        /* Příkaz k ukončení cyklu */
                        case 5 -> {
                            System.out.printf(uzivatelI.ukonciProgram());
                            konec = true;
                        }
                    }
                } else {
                    System.out.println("Zadejte číslo od 1 do 5"); // Výpis při chybném příkazu
                }
            } catch (Exception e) {
                System.out.println("Zadejte číslo od 1 do 5"); // Výpis při chybném příkazu
            }
        }
    }
}
