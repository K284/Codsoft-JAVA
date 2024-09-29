/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codsoft.java;

/**
 *
 * @author Jayalakshmi
 */
class ATM{
    double amount;
    String name;    public ATM(String name,double amount){
        this.amount = amount; 
        this.name = name;
        if (amount<=5000){
            System.out.println("\n*******NOTICE TO "+name+"! *******\n");
            System.out.println(name+", Amount is less than minimum balance!! Make sure to have five thousand and above!"); 
        }
    }
        
    
    public void withdraw(double debit){
        System.out.println("\n*******"+name+"'s WITHDRAWAL*******\n");
        if (amount<5000){
            System.out.println(name+", Minimum balance not met!!!! Deposit immediately!!!");
            System.out.println("WITHDRAWAL FAILED!!");
        }
        else{
            System.out.println(name+", Money in your account is "+amount);
            if(debit>amount){
                System.out.println(name+", Insufficient Balance!!");
                System.out.println("WITHDRAWAL FAILED!!");
            }
            else {
                   amount-=debit;
                System.out.println(name+", You have withdrawn "+debit+" from your account!!");
                System.out.println("Current balance = "+amount);
                System.out.println("WITHDRAWAL SUCCESSFUL!!");
            }
            System.out.println("\n");
        }
    }
    
    public void deposit(double credit){
        System.out.println("\n*******"+name+"'s DEPOSIT*******\n");
        System.out.println(name+", You have deposited "+credit+" to your account!!");
        System.out.println("Before deposit = "+amount);
        amount+= credit;
        System.out.println("After deposit = "+amount);
        System.out.println("DEPOSITED SUCCESSFULLY!!");
        if (amount<5000){
            System.out.println(name+", Minimum balance not met!!!! Deposit immediately!!!");
        }
        System.out.println("\n");
    }
    public void checkbalance(){
        System.out.println("\n*******"+name+"'s BALANCE*******\n");
        if (amount<5000) 
            System.out.println(name+", Money less than minimum balance!!! Money in ur account = "+amount);
        else 
            System.out.println(name+", Your current balance is "+amount);
        System.out.println("\n");
    }
}
public class UserAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ATM user1 = new ATM("Krisha",380800);
        user1.deposit(4000);
        user1.checkbalance();
        user1.withdraw(123456);
        
        ATM user2 = new ATM("Jaya",12);
        user2.deposit(33);
        user2.withdraw(55);
        user2.checkbalance();
    }
    
}
