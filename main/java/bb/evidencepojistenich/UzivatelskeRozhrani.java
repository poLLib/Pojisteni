/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

import java.util.Scanner;

/**
 * Třída slouží k interakci mezi uživatelem a programem
 *
 * @author billove
 */
public class UzivatelskeRozhrani {
    private final Scanner sc = new Scanner(System.in, "Windows-1250");
    private final DatabazePoj databaze;

    public UzivatelskeRozhrani() {
        databaze = new DatabazePoj();
    }

    /* Uživatelský vstup: @jméno @příjmení @tel @věk ,který přidá nového pojištěnce do databáze */
    public void pridejPoj() {
        int vek = 0;
        System.out.println("Zadejte jméno:");
        String jmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmění:");
        String prijmeni = sc.nextLine().trim();
        System.out.println("Zadejte tel:");
        int tel = Integer.parseInt(sc.nextLine());

        // Validace věku. Musí být v rozmezí 0-100
        while (!((vek > 0) && (vek < 100))) {
            System.out.println("Zadejte vek:");
            vek = Integer.parseInt(sc.nextLine());
            if (vek <= 0) {
                System.out.println("Zadejte věk v absolutním čísle");
            } else if (vek > 100) {
                System.out.println("Věk je příliš velký");
            }
        }
        databaze.pridejPoj(jmeno, prijmeni, tel, vek);
        System.out.println("Nový pojištěnec byl přídán.");
    }

    /* Uživatel si zažádá o vypsání všech pojištěných */
    public void vypisVsePoj() {
        databaze.vypisPoj();
    }

    /* Uživatel si žádá o vypsání konkretního pojištěnce @jméno @příjmení */
    public void vypisPoj() {

        System.out.println("Zadejte jméno:");
        String inputJmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String inputPrijmeni = sc.nextLine().trim();
        databaze.najdiPoj(inputJmeno, inputPrijmeni);
    }
}
