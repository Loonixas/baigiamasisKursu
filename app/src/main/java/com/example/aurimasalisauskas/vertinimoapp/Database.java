package com.example.aurimasalisauskas.vertinimoapp;

import java.util.ArrayList;

public class Database {

    private static ArrayList<Ivertinimas> ivertinimai = new ArrayList<>();

    public static void add(Ivertinimas ivertinimas) {
        ivertinimai.add(ivertinimas);
    }

    public static ArrayList<Ivertinimas> getIvertinimai() {
        return ivertinimai;
    }
}
