
package game_of_fifteen;

import java.util.Scanner;

public class Game_of_Fifteen {
    public static int n=4;
    public static int locationrow=3;
    public static int locationcol=3;
public static int[][] bord=new int[n][n];
    public static void main(String[] args) {
         System.out.println("WELCOME TO GAME OF FIFTEEN");
         System.out.println("Right => 3");
         System.out.println("left => 1");
         System.out.println("top => 5");
         System.out.println("bottom => 2");
         initalBord();
         draw();
         move();

    }
    public static boolean issorted(){
        int s=1;
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                if(bord[i][j]!=s){
                    return false;
                       
                }else{
                    s++;
                    if(s==16){
                        s=-1;
                    }
                }
             }
         }
        return true;
    }
    public static void move(){
        
        while(!issorted()){
            Scanner input=new Scanner(System.in);
            int m=input.nextInt();
            //left
            if(m==1){
                int newloc=locationrow;
                int newlocc=locationcol-1;
                if(newlocc<0){
                    System.out.println("invaid move");
                }else{
                    bord[locationrow][locationcol]=bord[newloc][newlocc];
                    bord[newloc][newlocc]=-1;
                    locationrow=newloc;
                    locationcol=newlocc;
                }
            }
            //bottom
            else if(m==2){
                int newloc=locationrow+1;
                int newlocc=locationcol;
                if(newloc>(n-1)){
                    System.out.println("invaid move");
                }else{
                    bord[locationrow][locationcol]=bord[newloc][newlocc];
                    bord[newloc][newlocc]=-1;
                    locationrow=newloc;
                    locationcol=newlocc;
                }
            }
             //right
            else if(m==3){
                int newloc=locationrow;
                int newlocc=locationcol+1;
                if(newlocc>(n-1)){
                    System.out.println("invaid move");
                }else{
                    bord[locationrow][locationcol]=bord[newloc][newlocc];
                    bord[newloc][newlocc]=-1;
                    locationrow=newloc;
                    locationcol=newlocc;
                }
            }
            //top
            else  if(m==5){
                int newloc=locationrow-1;
                int newlocc=locationcol;
                if(newloc<0){
                    System.out.println("invaid move");
                }else{
                    bord[locationrow][locationcol]=bord[newloc][newlocc];
                    bord[newloc][newlocc]=-1;
                    locationrow=newloc;
                    locationcol=newlocc;
                }
            }
            draw();
        }
    }
    public static void initalBord(){
        int s=n*n-1;
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(s==0){
                     bord[i][j]=-1;
                 }else{
                     bord[i][j]=s;
                       s--; 
                 }
                
             }
         }
        if(n%2==0){
           bord[3][1]=1;
           bord[3][2]=2; 
        }
         
         
    }
    public static void  draw(){
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                System.out.print(bord[i][j] + "      ");
             }
             System.out.println();
         }
    }
}
