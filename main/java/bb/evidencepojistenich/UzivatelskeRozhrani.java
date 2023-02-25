/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

import java.util.Scanner;

/**
 * Třída slouží k interakci mezi vstupem uživatele a programemm (můžem si ji představit jako front-end)
 * <p>
 * Nalezneme zde tyto metody:
 * - Výpis hlavního menu
 * - Volba menu
 * - Přidání pojištěného --> pridejPoj()
 * - Vypsání pojištěných --> vypisVsePoj()
 * - Vyhledání a vypsání konkrétního pojištěného -->vypisPoj()
 * - Upravení dat pojištěného --> upravPoj()
 * - Smazaní pojištěného --> smazPoj()
 * - Ukončení programu
 * - Validace písmen a čísel
 * - Validace věku
 * - Validace telefoního čísla
 *
 * @author pollib
 */


public class UzivatelskeRozhrani {
    private final Scanner sc = new Scanner(System.in, "Windows-1250"); // Vytvoření instance pro uživatelský vstup
    private final DatabazePoj databaze;

    public UzivatelskeRozhrani() {
        databaze = new DatabazePoj();
    } // Vytvoření instance databáze

    /**
     * Vypis hlavní menu s nabídkou akcí
     *
     * @return - vrací celé menu
     */

    public String vypisMenu() {
        return """

                --------Evidence pojištěných----------

                Vyberte akci:
                1 - Přidat nového pojistného
                2 - Vypsat všechny pojištěné
                3 - Vyhledat pojištěného
                4 - Upravení pojištěného
                5 - Smazání pojištěného
                6 - Konec
                --------------------------------------
                Zadejte číslo akce:""";
    }

    /**
     * Výběr akce
     *
     * @param - výběr akce číslem 1-6
     * @return - vrací číselný vstup
     */
    public int volbaMenu() {
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Uživatelský vstup, který přidá nového pojištěnce do databáze
     */
    public void pridejPoj() {

        /* Validační metody vracející String jméná a příjmení */
        String jmeno = validacePismen("jméno");
        String prijmeni = validacePismen("příjmení");

        /* Validace čísel tel.čísla, může mít pouze 9 čísel */
        String tel = validaceTelefonu();

        /* Validace čísel ve věku, číslo musí být v rozmezí 0-100 */
        int vek = validaceVek();

        databaze.pridejPoj(jmeno, prijmeni, tel, vek); // Přídání pojištěného do databáze
        System.out.println("Nový pojištěnec byl přídán.");

    }

    /**
     * Uživatel si zažádá o vypsání všech pojištěných
     */
    public void vypisVsePoj() {
        databaze.vypisPoj(); // Výpis z databáze
    }

    /**
     * Uživatel si žádá o vypsání konkretních pojištěnců podle jména, příjmení nebo jejich částí
     */
    public void vypisPoj() {

        System.out.println("Zadejte jméno nebo příjmení:");
        String vstupJmenoPrijmeni = sc.nextLine().trim();

        databaze.najdiPoj(vstupJmenoPrijmeni); // Výpis z databáze
    }

    /**
     * Metoda se zeptá na data pro úpravu pajištěného, které posléze zpracuje databáze
     * (POZOR na duplicitní jména)
     */
    public void upravPoj() {
        System.out.println("Zadejte hledané jméno:");
        String vstupJmeno = sc.nextLine().trim();
        System.out.println("Zadejte hledané příjmení:");
        String vstupPrijmeni = sc.nextLine().trim();

        String novyJmeno = validacePismen("nové jméno");
        String novyPrijmeni = validacePismen("nové příjmení");
        String novyTel = validaceTelefonu();

        System.out.println("Pojištěný byl upraven");
        databaze.upravPoj(vstupJmeno, vstupPrijmeni, novyJmeno, novyPrijmeni, novyTel);
    }

    /**
     * Smazání pojištěného zadáním jeho jména a příjmení
     */
    public void smazPoj() {

        System.out.println("Zadejte jméno:");
        String vstupJmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String vstupPrijmeni = sc.nextLine().trim();

        databaze.smazPoj(vstupJmeno, vstupPrijmeni); // Smaže z databáze
    }

    /**
     * Ukončenčení programu
     *
     * @return - rozloučení
     */
    public String ukonciProgram() {
        return "Nashledanou";
    }

    /**
     * Metoda pro validaci písmen pomocí metody isAlphabetic() na třídě Character
     *
     * @param jmenoPrijmeni - Zadejte zda chcete požádat o jméno nebo příjmení
     * @return - jmeno || prijmeni
     */
    public String validacePismen(String jmenoPrijmeni) {
        String vratJmeno = "";
        boolean validaceJmena = false;

        while (!validaceJmena) {
            System.out.printf("Zadejte %s:\n", jmenoPrijmeni);
            vratJmeno = sc.nextLine().trim();

            for (char pismeno : vratJmeno.toLowerCase().toCharArray()) {
                if (!Character.isAlphabetic(pismeno) && pismeno != ' ' && pismeno != '-') {
                    validaceJmena = false;
                    break;
                } else {
                    validaceJmena = true;
                }
            }
            if (!validaceJmena)
                System.out.println("Musíte zadat pouze písmena české abecedy");
        }
        return vratJmeno;
    }

    /**
     * Metoda validující čísla přes ASCII tabulku
     *
     * @param c - jednotlivé char ve Stringu
     * @return - true = všechny char ve Stringu jsou čísla
     */
    public boolean validaceCisel(char c) {
        return ((int) c >= 48) && ((int) c <= 57);
    }

    /**
     * Validace čísel ve Stringu přes ASCII tabulku
     * Validace 9-ti místnýho čísla
     *
     * @return telefoní číslo (String)
     */
    public String validaceTelefonu() {
        boolean validaceTel = false;
        String vstupTel = "";

        while (!validaceTel) {
            System.out.println("Zadejte tel.číslo (bez předvolby):");
            vstupTel = sc.nextLine().replace(" ", "").trim();

            for (char c : vstupTel.toCharArray()) {
                validaceTel = validaceCisel(c);   // Validace čísel přes ASCII tabulku
            }

            if (!validaceTel) {
                System.out.println("Tel.číslo nemůže obsahovat písmena, ani znaky");
            }
            if (vstupTel.length() == 9) {
                validaceTel = true;
                return vstupTel;
            } else {
                validaceTel = false;
                System.out.println("Zadejte 9-ti místné číslo");
            }
        }
        return vstupTel;
    }

    public int validaceVek() {
        int vek = 0;
        boolean validaceVeku = false;

        while (!validaceVeku) {
            System.out.println("Zadejte vek:");
            String vstupVek = sc.nextLine();

            for (char c : vstupVek.toCharArray()) {
                validaceVeku = validaceCisel(c); // Validace čísel přes ASCII tabulku
            }

            // Validace rozmezí 0-100
            if (!validaceVeku) {
                System.out.println("Věk nemůže obsahovat písmena, ani znaky");
            } else {
                vek = Integer.parseInt(vstupVek);
            }
            if (vek < 0) {
                validaceVeku = false;
                System.out.println("Zadejte věk v absolutním čísle");
            } else if (vek > 100) {
                validaceVeku = false;
                System.out.println("Věk je příliš velký");
            }
        }
        return vek;
    }

}
