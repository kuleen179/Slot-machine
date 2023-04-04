import java.util.*;
class Finals{
    static final int minbet = 10;
    static final int maxbet = 100;
    static final int MAX_LINES = 3;
}
class Dep extends Finals{
    public static int deposit(){
        int amount = 0;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("What would you like to deposit: $");
            amount = sc.nextInt();
            if (amount >= minbet && amount <= maxbet){
                break;
            }
            else{
                System.out.printf("Enter a valid amount between $%d and $%d \n",minbet,maxbet);
            }
        }
        return amount;
    }
}

class Bet extends Dep{
    public static int getlines(){
        int lines =0;
        while(lines==0 || lines> MAX_LINES){
            Scanner sa = new Scanner(System.in);
            System.out.printf("How many lines you wanna bet on? ");
            lines = sa.nextInt();
            if (lines >= 0 && lines <= MAX_LINES){
                break;
            }
            else{
                System.out.printf("Enter value between %d and %d \n",1,MAX_LINES);
            }
        }
        return lines;
    }
}

class Getbetline extends Bet{
    public static int getonline(){
        int amt = deposit();
        int online = 0;
        int line = getlines();
        while(true){
            Scanner sb = new Scanner(System.in);
            System.out.printf("Enter the amount you wanna bet on each line $");
            online = sb.nextInt();
            int ota = online*line;
            if(ota < amt){
                System.out.printf("You are betting $%d on each line and your total bet is $%d. \n",online,ota);
                return online;
            }
            else{
                System.out.printf("You don't have enough balance to bet. Your current balance is $%d \n",amt);
            }
        }
    } 
}

class SpinMachine extends Getbetline{
    public static void spin(){
        int[] al = {1,2,3,4};
        int[][] digits = new int[3][3];
        int index = -1;
        for(int row=0; row<3;row++){
            index++;
            for(int col=0;col<3;col++){
                digits[row][col] = al[index];
            }
        }
        System.out.println("Spin");
        for(int row =0; row<3;row++){
            for (int col =0;col<3;col++){
            System.out.print(digits[row][col]+" ");
            }
        System.out.println();
        }
    }
}


public class Machine extends SpinMachine{
    public static void main(String[] args) {
        Machine obj = new Machine();
        obj.getonline();
        obj.spin();
    }
}