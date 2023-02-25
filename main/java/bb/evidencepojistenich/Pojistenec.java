/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb.evidencepojistenich;

/**
 * Třída představuje konkrétního pojištěnce
 *
 * @author pollib
 */
public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private String tel;
    private int vek;

    public Pojistenec(String jmeno, String prijmeni, String tel, int vek) {
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

    public String getTel() {
        return tel;
    }

    public int getVek() {
        return vek;
    }

    public void setJmeno(String novyJmeno) {
        this.jmeno = novyJmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Pojištěnec " + jmeno + " " + prijmeni + ", tel:" + tel + ", věk " + vek;
    }

}
