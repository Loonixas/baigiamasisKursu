package com.example.aurimasalisauskas.vertinimoapp;

import java.util.ArrayList;

public class Ivertinimas {

    private int pasirinkimas;
    private ArrayList<String> trukumai = new ArrayList<>();

    public int getPasirinkimas() {
        return pasirinkimas;
    }

    public void setPasirinkimas(int pasirinkimas) {
        this.pasirinkimas = pasirinkimas;
    }

    public ArrayList<String> getTrukumai() {
        return trukumai;
    }
}
