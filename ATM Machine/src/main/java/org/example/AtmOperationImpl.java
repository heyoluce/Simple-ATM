package org.example;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperIntef{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Balance: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount<=atm.getBalance() && withdrawAmount%500==0) {
            ministmt.put(withdrawAmount, "Amount withdrawn");
            atm.setBalance(atm.getBalance() - withdrawAmount);
            System.out.println(withdrawAmount + "$ was withdrawn");
            viewBalance();
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, "Amount deposited");
        System.out.println(depositAmount + "$ were deposited successfully");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m : ministmt.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
