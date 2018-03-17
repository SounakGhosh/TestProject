package com.company;

public class MainClass {
    static String arr[][] = {
            {"x", "x"},
            {"x", "."}
    };
// static String arr[][] = {
//            {"x","x",".","x","x","x"},
//            {"x",".",".",".",".","x"},
//            {"x","x","x","x",".","x"},
//            {"x","x","x","x",".","x"},
//            {"x","x","x","x",".","x"},
//            {"x","x","x","x","x","x"}
//    };

    static int temp[][]; /*= {
            {0,0,1,0,0,0},
            {0,1,1,1,1,0},
            {0,0,0,0,1,0},
            {0,0,0,0,1,0},
            {0,0,0,0,1,0},
            {0,0,0,0,0,0}
    };*/

    static int noOfFences;
    static int len;

    public static void main(String args[]) {
        MainClass obj = new MainClass();
        obj.findNoOfFences();

        System.out.println("No. of fences: " + noOfFences);
    }

    void findNoOfFences() {
        int i, j;

        len = arr.length;
        noOfFences = len * 4;

        temp = new int[len][len];

        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                if (arr[i][j].equals("x"))
                    temp[i][j] = 0;
                else if (arr[i][j].equals("."))
                    temp[i][j] = 1;
                else {
                    System.out.println("*** Input Error ***");
                    System.exit(0);
                }
            }
        }

        MainClass obj = new MainClass();

        i = 0;
        for (j = 0; j < len; j++) {
            if (arr[i][j].equals(".") && temp[i][j] == 1)
                obj.changeNoOfFences(i, j);
        }

        j = len - 1;
        for (i = 0; i < len; i++) {
            if (arr[i][j].equals(".") && temp[i][j] == 1)
                obj.changeNoOfFences(i, j);
        }

        j = 0;
        for (i = 0; i < len; i++) {
            if (arr[i][j].equals(".") && temp[i][j] == 1)
                obj.changeNoOfFences(i, j);
        }

        i = len - 1;
        for (j = 0; j < len; j++) {
            if (arr[i][j].equals(".") && temp[i][j] == 1)
                obj.changeNoOfFences(i, j);
        }
    }

    void changeNoOfFences(int i, int j) {
        noOfFences += 2;
        temp[i][j] = 0;

        MainClass obj = new MainClass();

        if (obj.checkPoint(i, j + 1))
            obj.changeNoOfFences(i, j + 1);

        if (obj.checkPoint(i + 1, j))
            obj.changeNoOfFences(i + 1, j);

        if (obj.checkPoint(i, j - 1))
            obj.changeNoOfFences(i, j - 1);

        if (obj.checkPoint(i - 1, j))
            obj.changeNoOfFences(i - 1, j);
    }

    boolean checkPoint(int i, int j) {
        if (i < 0 || j < 0 || i == len || j == len)
            return false;
        if (arr[i][j].equals(".") && temp[i][j] == 1)
            return true;
        else
            return false;
    }
}
