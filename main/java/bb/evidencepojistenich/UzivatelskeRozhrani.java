/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

import java.util.Scanner;

/**
 * Třída slouží k interakci mezi uživatelem a programem
 * <p>
 * Nalezneme zde 4 funkce:
 * Výpis hlavního menu
 * Volba menu
 * 1)Přidání pojištěného --> pridejPoj()
 * 2)Vypsání pojištěných --> vypisVsePoj()
 * 3)Vyhledání a vypsání konkrétního pojištěného -->vypisPoj()
 * 4)Ukončení programu
 * 5)
 *
 * @author billove
 */
public class UzivatelskeRozhrani {
    private final Scanner sc = new Scanner(System.in, "Windows-1250");
    private final DatabazePoj databaze;

    public UzivatelskeRozhrani() {
        databaze = new DatabazePoj();
    }

    public String vypisMenu() {
        return "\n--------Evidence pojištěných----------\n\n"
                + "Vyberte akci:\n"
                + "1 - Přidat nového pojistného\n"
                + "2 - Vypsat všechny pojištěné\n"
                + "3 - Vyhledat pojištěného\n"
                + "4 - Konec\n"
                + "--------------------------------------\nZadejte číslo akce:";
    }

    public int volbaMenu() {
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Uživatelský vstup: @jméno @příjmení @tel @věk ,který přidá nového pojištěnce do databáze
     */
    public void pridejPoj() {

        /** Cyklus validace písmen ve jméně
         *  pomocí iterace uložené abecedy ve Stringu
         */
        String jmeno = "";
        boolean validaceJmena = false;

        while (!validaceJmena) {
            System.out.println("Zadejte jméno:");
            jmeno = sc.nextLine().trim();

            for (char pismeno : jmeno.toLowerCase().toCharArray()) {
                String abeceda = "aeiouyáéěíóúůýbcčdďfghjklmnpqrřsštťvwxzž";
                if (!abeceda.contains(String.valueOf(pismeno))) {
                    validaceJmena = false;
                    break;
                } else {
                    validaceJmena = true;
                }
            }
            if (!validaceJmena)
                System.out.println("Musíte zadat pouze písmena české abecedy");
        }

        /** Cyklus validace písmen v příjmení
         * pomocí metody isAlphabetic() na třídě Character
         */
        String prijmeni = "";
        boolean validacePrijmeni = false;

        while (!validacePrijmeni) {
            System.out.println("Zadejte příjmění:");
            prijmeni = sc.nextLine().trim();

            for (char pismeno : prijmeni.toLowerCase().toCharArray()) {
                if (!Character.isAlphabetic(pismeno)) {
                    validacePrijmeni = false;
                    break;
                } else {
                    validacePrijmeni = true;
                }
            }
            if (!validacePrijmeni)
                System.out.println("Musíte zadat pouze písmena české abecedy");
        }

        /** Cyklus validace čísel tel.čísla
         * může mít pouze 9 čísel
         * pomocí metody .isAlphabetic() na třídě Character
         */
        long tel = 0;
        boolean validaceTel = false;

        while (!validaceTel) {
            System.out.println("Zadejte tel.číslo (bez předvolby):");
            String inputTel = sc.nextLine().replace(" ", "");

            // Validace čísel přes ASCII tabulku
            for (char c : inputTel.toCharArray()) {
                int telAscii = c;
                if (!((telAscii >= 48) && (telAscii <= 57))) {
                    validaceTel = false;
                    break;
                } else {
                    validaceTel = true;
                }
            }
            if (!validaceTel) {
                System.out.println("Tel.číslo nemůže obsahovat písmena, ani znaky");
            }
            if (inputTel.length() == 9) {
                validaceTel = true;
                tel = Long.parseLong(inputTel);
            } else {
                validaceTel = false;
                System.out.println("Zadejte 9-ti místné číslo");
            }
        }

        /** Cyklus validace čísel věku
         * číslo musí být v rozmezí 0-100
         */
        int vek = 0;
        boolean validaceVeku = false;

        while (!validaceVeku) {
            System.out.println("Zadejte vek:");
            String inputVek = sc.nextLine();

            // Validace čísel přes ASCII tabulku
            for (char c : inputVek.toCharArray()) {
                int vekAscii = c;
                if (!((vekAscii >= 48) && (vekAscii <= 57))) {
                    validaceVeku = false;
                    break;
                } else {
                    validaceVeku = true;
                }
            }
            if (!validaceVeku) {
                System.out.println("Věk nemůže obsahovat písmena, ani znaky");
            } else {
                vek = Integer.parseInt(inputVek);
            }

            // Validace rozmezí 0-100
            if (vek < 0) {
                validaceVeku = false;
                System.out.println("Zadejte věk v absolutním čísle");
            } else if (vek > 100) {
                validaceVeku = false;
                System.out.println("Věk je příliš velký");
            }
        }
        databaze.pridejPoj(jmeno, prijmeni, tel, vek);
        System.out.println("Nový pojištěnec byl přídán.");

    }

    /**
     * Uživatel si zažádá o vypsání všech pojištěných
     */
    public void vypisVsePoj() {
        databaze.vypisPoj();
    }

    /**
     * Uživatel si žádá o vypsání konkretního pojištěnce @jméno @příjmení
     */
    public void vypisPoj() {

        System.out.println("Zadejte jméno:");
        String inputJmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String inputPrijmeni = sc.nextLine().trim();
        databaze.najdiPoj(inputJmeno, inputPrijmeni);
    }

    /**
     * Ukončení programu
     *
     * @return
     */
    public String ukonciProgram() {
        return "Nashledanou";
    }
}
