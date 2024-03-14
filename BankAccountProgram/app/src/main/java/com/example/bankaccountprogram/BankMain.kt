package com.example.bankaccountprogram

fun main() {

    val Nisha = BankAccount("Sayista",123000.89)
//    println(Nisha.accountHolder)
    Nisha.deposit(200.80)
    Nisha.displayTransactionHistory();
}