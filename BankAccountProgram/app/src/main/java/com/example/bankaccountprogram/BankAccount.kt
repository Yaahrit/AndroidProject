package com.example.bankaccountprogram

class BankAccount(var accountHolder:String,var balance:Double) {

    private val TransactionHistory = mutableListOf<String>()

    fun deposit(amount:Double){
        balance+=amount
        TransactionHistory.add("$accountHolder deposited $$amount")
    }
    fun withdraw(amount: Double){
        if(amount<=balance){
            balance-=amount
            TransactionHistory.add("$accountHolder withdraw $$amount")
        }else{
            println("You don't have the enough money to withdraw $$amount")
        }
    }
    fun displayTransactionHistory(){
        println("transition history for $accountHolder")
        for(transaction in TransactionHistory){
            println(transaction)
        }

    }
}