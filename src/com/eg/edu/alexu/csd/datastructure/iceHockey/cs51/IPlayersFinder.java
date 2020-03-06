package com.eg.edu.alexu.csd.datastructure.iceHockey.cs51;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public interface IPlayersFinder {
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}

class IPlayersFinderImplementation implements IPlayersFinder {
    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        if (photo.length == 0 || photo[0] == null || photo[0].length() == 0)  return null;

        int[] Pic = new int[photo.length * photo[0].length()];
        int maxSquares;
        int xMin, xMax, yMin, yMax;
        if (threshold % 4 == 0 && threshold >= 4) maxSquares = threshold / 4;
        else if (threshold < 4)     maxSquares = 1;
        else maxSquares = threshold / 4 + 1;
        int objects = 0;
        int k = 0;
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length(); j++) {
                if (photo[i].charAt(j) == Character.forDigit(team,10))
                    Pic[k] = Character.getNumericValue(photo[i].charAt(j));
                else Pic[k] = 0;
                k++;
            }
        }
        k = 0;
        for (int j = 0; j < Pic.length; j++) {
            if (Pic[j] != 0) {
                F = 0;
                Pic = Count(Pic, photo[0].length(), j, team);
                if (counter >= maxSquares) {
                    objects++;
                    xMin = min(x);
                    xMax = max(x);
                    yMin = min(y);
                    yMax = max(y);
                    xmid[k] = xMin + xMax + 1;
                    ymid[k] = yMin + yMax + 1;
                    k++;
                }
                x = Reset(x);
                y = Reset(y);
                counter = 0;
            }
        }
        Point[] points = new Point[objects];
        for (int i = 0; i < objects; i++) {
            points[i] = new Point(xmid[i], ymid[i]);
        }
        points = Sorting(points);
        return points;
    }


    public int counter = 0;
    public int[] x = new int[50];
    public int[] y = new int[50];
    public int[] xmid = new int[50];
    public int[] ymid = new int[50];
    public int F = 0;

    int [] Count (@NotNull int[] Pic, int columns, int k, int team){
        int Origin = k;
        boolean foundOrigin = true;
        int X,Y,i;
        while (k >= 0 && k < Pic.length && foundOrigin) {
            if (((k + 1) % columns == 0 || Pic[k + 1] != team) && (k % columns == 0 || Pic[k - 1] != team) && ((k+columns) >= Pic.length || Pic[k + columns] == 0)) {
                Pic[k] = 0;
                counter++;
                X = k%columns;
                Y = k;
                for (i = 0; i < columns; i++) {
                    if (Y < columns)    break;
                    else Y-=columns;
                }
                Y = i;
                x[F] = X;
                y[F] = Y;
                F++;
                if (k == Origin)   foundOrigin = false;
                return Pic;
            }
            else if ((k+columns < Pic.length) && Pic[k + columns] == team)      Pic = Count(Pic, columns, k + columns, team);
            else if ((k < columns - 1 || (k + 1) % columns != 0) && Pic[k + 1] == team) {
                Pic[k] = -1;
                Pic = Count(Pic, columns, k + 1, team);
            } else if ((k < columns || k % columns != 0) && Pic[k - 1] == team) {
                Pic[k] = -1;
                Pic = Count(Pic, columns, k - 1, team);
            }
        }
        return Pic;
    }

    int min (int[] Pic){
        int minimum = Pic[0];
        for (int i = 0; i < F ; i++) {
            if (Pic[i] < minimum)   minimum = Pic[i];
        }
        return minimum;
    }

    int max (int[] Pic){
        int maximum = Pic[0];
        for (int i = 0; i < F ; i++) {
            if (Pic[i] > maximum)   maximum = Pic[i];
        }
        return maximum;
    }
    int[] Reset (int[] A){
        int i = 0;
        while (i < F){
            A[i] = 0;
            i++;
        }
        return A;
    }
    Point[] Sorting (Point[] S){
        boolean flag = false;
        Point temp = new Point();
        while (flag == false) {
            flag = true;
            for (int i = 0; i < S.length - 1; i++) {
                if (S[i].x > S[i+1].x){
                   temp = S[i+1];
                   S[i+1] = S[i];
                   S[i] =  temp;
                   flag = false;
                }
                else if((S[i].x == S[i+1].x) && (S[i].y > S[i+1].y)){
                    S[i+1].y = S[i].y ^ S[i+1].y;
                    S[i].y = S[i+1].y ^ S[i].y;
                    S[i+1].y =  S[i].y ^ S[i+1].y;
                    flag = false;
                }
            }
        }
        return S;
    }
}
