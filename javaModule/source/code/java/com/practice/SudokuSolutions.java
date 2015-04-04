package com.practice;

/**
 * Created by shruti.mantri on 10/02/15.
 */
import java.util.ArrayList;

public class SudokuSolutions {

    public static int count = 0;
    public static int fails = 0;

    public static void main(String[] args) {

        int[][] board = new int[4][4];
        fillIt(board,0,0);
        System.out.println("Count of solutions: "+count);
        System.out.println("Count of failures: "+fails);

    }
    //Fills boards recursively and counts if the filling was a success or not
    public static void fillIt(int[][]board, int x, int y){
        ArrayList<Integer> pos = getPossibilities(board, x, y);
        int[][] clone = clone(board);
        if(pos.size()==0){
            fails++;
            return;
        }
        for (Integer integer : pos) {
            clone[x][y] = integer;
            if(x==3 && y==3){
                if(checkBoard(clone)){
                    printBoard(clone);
                    count++;
                    return;
                }
                else{
                    System.out.println("Failed!");
                }
            }
            if(x==3){
                fillIt(clone,0,y+1);
            }
            else{
                fillIt(clone,x+1,y);
            }
        }
    }
    public static int[][] clone(int[][] board){
        int[][] ret = new int [4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                ret[i][j] = board[i][j];
            }
        }
        return ret;
    }
    public static void printBoard(int[][] board){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //Gets all the possibilities for a cell
    public static ArrayList<Integer> getPossibilities(int[][] board,int x,int y){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        pos.add(1);pos.add(2);pos.add(3);pos.add(4);
        //Check rows
        for(int i = 0;i<4;i++){
            if(board[x][i]!=0){
                if(pos.contains(board[x][i])){
                    pos.remove(pos.indexOf(board[x][i]));
                }
            }
        }
        //Check Columns
        for(int i = 0;i<4;i++){
            if(board[i][y]!=0){
                if(pos.contains(board[i][y])){
                    pos.remove(pos.indexOf(board[i][y]));
                }
            }
        }
        //Check squares
        int moveX = x-x%2;
        int moveY = y-y%2;
        for(int i=moveX;i<moveX+2;i++){
            for(int j=moveY;j<moveY+2;j++){
                if(board[i][j]!=0){
                    if(pos.contains(board[i][j])){
                        pos.remove(pos.indexOf(board[i][j]));
                    }
                }
            }
        }
        return pos;
    }
    //Not really necessary since the getPossibilities function gets only valid numbers
    public static boolean checkBoard(int[][] board){
        //check rows for duplicates
        for(int i=0;i<4;i++){
            int[] bitMask = {0,0,0,0};
            for(int j=0;j<4;j++){
                if(bitMask[board[i][j]-1]==1){
                    return false;
                }
                else{
                    bitMask[board[i][j]-1]=1;
                }
            }
        }
        for(int i=0;i<4;i++){
            int[] bitMask = {0,0,0,0};
            for(int j=0;j<4;j++){
                if(bitMask[board[j][i]-1]==1){
                    return false;
                }
                else{
                    bitMask[board[j][i]-1]=1;
                }
            }
        }
        return true;
    }

}