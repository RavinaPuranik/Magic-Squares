//make magic squares of any odd number

import java.util.Scanner;
public class HelloWorld{
     
     static void makeMagicSquare(int number){
         int arr[][]=new int[number][number];
         for(int i=0;i<number;i++){
             for(int j=0;j<number;j++)
             arr[i][j]=0;
         }
         
         int start_point=number/2;
         arr[start_point][number-1]=1;
         
         int curr_position_row=start_point;
         int curr_position_col=number-1;
         for(int i=2;i<=number*number;i++){
            if((curr_position_row+1)<number && (curr_position_col+1)<number && arr[curr_position_row+1][curr_position_col+1]==0)
            {   
                
                arr[curr_position_row+1][curr_position_col+1]=i;
                curr_position_row=curr_position_row+1;
                curr_position_col=curr_position_col+1;
            }
            
            else if (curr_position_row+1<number && curr_position_col+1<number && arr[curr_position_row+1][curr_position_col+1]!=0 && arr[curr_position_row][curr_position_col-1]==0)
            {
                arr[curr_position_row][curr_position_col-1]=i;
                curr_position_col=curr_position_col-1;
            }
            
            else if(((curr_position_row+1)<number && (curr_position_col+1)>=number) && arr[curr_position_row+1][0]==0){
                arr[curr_position_row+1][0]=i;
                curr_position_row=curr_position_row+1;
                curr_position_col=0;
            }
            
            else if(((curr_position_row+1)>=number && (curr_position_col+1)<number) && arr[0][curr_position_col+1]==0){
                arr[0][curr_position_col+1]=i;
                curr_position_row=0;
                curr_position_col=curr_position_col+1;
            }
            
            else if(((curr_position_row+1)>=number && (curr_position_col+1)>=number) && arr[curr_position_row][curr_position_col-1]==0){
                arr[curr_position_row][curr_position_col-1]=i;
                curr_position_col=curr_position_col-1;
            }
         }
         
         for(int i=0;i<number;i++){
             for(int j=0;j<number;j++)
             System.out.print(arr[i][j]+ "    ");
             System.out.println();
         }
         
     }
     
     
     
     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an odd number");
        int number=sc.nextInt();
        if(number%2!=0)
        makeMagicSquare(number);
        else
        System.out.println("Even numbers not allowed");
     }
}