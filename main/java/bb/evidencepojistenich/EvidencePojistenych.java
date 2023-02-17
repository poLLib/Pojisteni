/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bb.evidencepojistenich;

import java.util.Scanner;


/**
 * @author user
 */
public class EvidencePojistenych {

    public static void main(String[] args) {
        UzivatelskeRozhrani userI = new UzivatelskeRozhrani();
        Scanner sc = new Scanner(System.in, "Windows-1250");

        System.out.println("--------Evidence pojištěných----------\n");
        System.out.println("Vyberte akci:\n"
                + "1 - Přidat nového pojistného\n"
                + "2 - Vypsat všechny pojištěné\n"
                + "3 - Vyhledat pojištěného\n"
                + "4 - Konec");

        /* Začátek cyklu uživatelské relace/cyklu */
        boolean konec = false;
        while (!konec) {
            System.out.println("--------------------------------------\nZadejte číslo akce:");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input >= 1 && input <= 4) {
                    switch (input) {

                /* Příkaz k zaevidování nového pojištěnce
                   @jméno @příjmení @telefon @číslo */
                        case 1:
                            userI.pridejPoj();
                            break;

                        /* Příkaz k vypsání všech pojištěných */
                        case 2:
                            userI.vypisVsePoj();
                            break;

                /* Přikaz k vyhledání konkrétního pojištěnce podle jména a příjmení
                   @jméno @příjmení */
                        case 3:
                            userI.vypisPoj();
                            break;

                        /* Příkaz k ukončení cyklu */
                        case 4:
                            System.out.println("Nashledanou");
                            konec = true;
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
