/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

/*
 * Třída představuje konkrétního pojištěnce
 * @jmeno
 * @prijmeni
 * @long
 * @vek
 *
 * @author pollib
 */
public class Pojistenec {
    private final String jmeno;
    private final String prijmeni;
    private final long tel;
    private final int vek;

    public Pojistenec(String jmeno, String prijmeni, long tel, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.tel = tel;
        this.vek = vek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public long getTel() {
        return tel;
    }

    public int getVek() {
        return vek;
    }

    @Override
    public String toString() {
        return "Pojištěnec " + jmeno + " " + prijmeni + ", tel:" + tel + ", věk " + vek;
    }

}
