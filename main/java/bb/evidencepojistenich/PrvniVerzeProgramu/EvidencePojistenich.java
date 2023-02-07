/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bb.evidencepojistenich;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class EvidencePojistenich {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        ArrayList<Pojistenec> pojistnici = new ArrayList<>();
        System.out.println("--------Evidence pojištěných----------\n");
        System.out.println("Vyberte akci:\n"
                + "1 - Přidat nového pojistného\n"
                + "2 - Vypsat všechny pojištěné\n"
                + "3 - Vyhledat pojištěného\n"
                + "4 - Konec");
        
        boolean konec = false;
        while(!konec) {
            System.out.println("Zadejte číslo akce:");
            try {
        int input = Integer.parseInt(sc.nextLine());
        switch (input) {
            case 1:
                int vek=0;
                System.out.println("Zadejte jméno:");
                String jmeno = sc.nextLine();
                System.out.println("Zadejte příjmění:");
                String prijmeni = sc.nextLine();
                System.out.println("Zadejte tel:");
                int tel = Integer.parseInt(sc.nextLine());
                    while (!(vek>0)) {
                        System.out.println("Zadejte vek:");
                        vek = Integer.parseInt(sc.nextLine()); 
                        if(vek<0) {
                            vek=0;
                            System.out.println("Zadejte věk v absolutním čísle");
                        }
                    }
                Pojistenec pojistenec = new Pojistenec(jmeno, prijmeni, tel, vek);
                pojistnici.add(pojistenec);
                System.out.println("Nový pojištěnec byl přídán.");
                break;
            case 2:
                for(Pojistenec pojistnik : pojistnici) {
                    System.out.println(pojistnik);
                }
                break;
            case 3:

                    System.out.println("Zadejte jméno:");
                    String inputJmeno = sc.nextLine();
                    System.out.println("Zadejte příjmení:");
                    String inputPrijmeni = sc.nextLine();
                    
                    for (Pojistenec pojistnik : pojistnici) {
                        if (inputJmeno.equals(pojistnik.getJmeno()) && inputPrijmeni.equals(pojistnik.getPrijmeni())) {
                        System.out.println(pojistnik);
                    } else {
                        System.out.println("Toto jméno neevidujeme");
                    }
                    
                }
                    break;
            case 4:
                System.out.println("Nashledanou");
                konec = true;
        }
                System.out.println("Pokračujte libovolnou klávesou...");
                sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error");
        }
        }
    }
}
