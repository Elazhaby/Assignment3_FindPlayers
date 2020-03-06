package com.eg.edu.alexu.csd.datastructure.iceHockey.cs51;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] Pic = new String[6];
        Pic[0] = "33JUBU33";
        Pic[1] = "3U3O4433";
        Pic[2] = "O33P44NB";
        Pic[3] = "PO3NSDP3";
        Pic[4] = "VNDSD333";
        Pic[5] = "OINFD33X";
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] result = new Point[3];
        result = S.findPlayers(Pic ,3,16);
        for (int i = 0; i < 3 ; i++) {
            System.out.println(result[i]);
        }
        String str = null;
        System.out.println(str == null);
    }
}
