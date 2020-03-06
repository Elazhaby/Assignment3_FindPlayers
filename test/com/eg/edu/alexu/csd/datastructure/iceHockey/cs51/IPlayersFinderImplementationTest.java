package com.eg.edu.alexu.csd.datastructure.iceHockey.cs51;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class IPlayersFinderImplementationTest {

    @org.junit.jupiter.api.Test
    void count() {
        int[] Pic = {3,3,0,3,0,3,0,0,3,0,0,0,0,3,3};
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        int[] result = new int[15];
        int[] trueValue = {0,0,0,3,0,0,0,0,3,0,0,0,0,3,3};
        result = S.Count(Pic ,5 ,0, 3);
        int X = S.counter;
        assertArrayEquals(trueValue,result);
        assertEquals(3,X);
    }

    @Test
    void findPlayers() {
        String[] Pic = new String[6];
        Pic[0] = "33JUBU33";
        Pic[1] = "3U3O4433";
        Pic[2] = "O33P44NB";
        Pic[3] = "PO3NSDP3";
        Pic[4] = "VNDSD333";
        Pic[5] = "OINFD33X";
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] actual = new Point[3];
        actual[0] = new Point(4,5);
        actual[1] = new Point(13,9);
        actual[2] = new Point(14,2);
        Point[] result = new Point[3];
        result = S.findPlayers(Pic ,3,16);
        assertArrayEquals(actual,result);
    }
    @Test
    void test_1(){
        String[] Pic = new String[10];
        Pic[0] = "44444H44S4";
        Pic[1] = "K444K4L444";
        Pic[2] = "4LJ44T44XH";
        Pic[3] = "444O4VIF44";
        Pic[4] = "44C4D4U444";
        Pic[5] = "4V4Y4KB4M4";
        Pic[6] = "G4W4HP4O4W";
        Pic[7] = "4444ZDQ4S4";
        Pic[8] = "4BR4Y4A444";
        Pic[9] = "4G4V4T4444";
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] actual = new Point[6];
        actual[0] = new Point(3,8);
        actual[1] = new Point(4,16);
        actual[2] = new Point(5,4);
        actual[3] = new Point(16,3);
        actual[4] = new Point(16,17);
        actual[5] = new Point(17,9);
        Point[] result = new Point[6];
        result = S.findPlayers(Pic ,4,16);
        assertArrayEquals(actual,result);
    }
    @Test
    void test_2(){
        String[] Pic = new String[0];
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] actual = null;
        Point[] result = new Point[0];
        result = S.findPlayers(Pic ,0,4);
        assertArrayEquals(actual,result);
    }
    @Test
    void test_3(){
        String[] Pic = new String[3];
        Pic[0] = "";
        Pic[1] = "";
        Pic[2] = "";
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] actual = null;
        Point[] result = new Point[0];
        result = S.findPlayers(Pic ,0,4);
        assertArrayEquals(actual,result);
    }
    @Test
    void test_4(){
        String[] Pic = new String[3];
        Pic[0] = null;
        Pic[1] = null;
        Pic[2] = null;
        IPlayersFinderImplementation S = new IPlayersFinderImplementation();
        Point[] actual = null;
        Point[] result = new Point[0];
        result = S.findPlayers(Pic ,0,4);
        assertArrayEquals(actual,result);
    }

}