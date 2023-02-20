/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bb.evidencepojistenich;

/**
 * @author user
 */
public class EvidencePojistenych {

    public static void main(String[] args) {
        UzivatelskeRozhrani userI = new UzivatelskeRozhrani();

        /** Začátek cyklu uživatelské relace/cyklu
         *
         */
        boolean konec = false;
        while (!konec) {
            System.out.printf(userI.vypisMenu());
            try {
                int input = userI.volbaMenu();
                if (input >= 1 && input <= 4) {
                    switch (input) {

                /* Příkaz k zaevidování nového pojištěnce
                   @jméno @příjmení @telefon @číslo */
                        case 1 -> userI.pridejPoj();


                        /* Příkaz k vypsání všech pojištěných */
                        case 2 -> userI.vypisVsePoj();


                /* Přikaz k vyhledání konkrétního pojištěnce podle jména a příjmení
                   @jméno @příjmení */
                        case 3 -> userI.vypisPoj();


                        /* Příkaz k ukončení cyklu */
                        case 4 -> {
                            System.out.printf(userI.ukonciProgram());
                            konec = true;
                        }
                    }

                    /* Výpis při chybném příkazu*/
                } else {
                    System.out.println("Zadejte číslo od 1 do 4");
                }

                /* Výpis při chybném příkazu*/
            } catch (Exception e) {
                System.out.println("Zadejte číslo od 1 do 4");
            }
        }
    }
}
