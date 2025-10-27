package com.lab3;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        
        //for beginner
        Portfolio p = new Portfolio();
        
        Company c1 = new Company("Ubisoft");
        Share s1 = new Share(1200, c1);
        Share s2 = new Share(500, c1);
        Share s3 = new Share(700, c1);

        Company c2 = new Company("Apple");
        Share s4 = new Share(800, c2);
        Share s5 = new Share(900, c2);
        Share s6 = new Share(100, c2);

        p.addShare(s1);
        p.addShare(s2);
        p.addShare(s3);
        p.addShare(s4);
        p.addShare(s5);
        p.addShare(s6);
        
        System.out.println(p.computeSum()); //4200.0

        System.out.println();
        System.out.println("********************************");
        System.out.println();

        Address addr1 = new Address("Popesti-Leordeni", 85, "Strada Oituz");
        Address addr2 = new Address("Rosu", 67, "Strada Rezervelor");
        Client danut = new Client("Dan Deaconu", LocalDate.of(2002, 2, 20), "123456789", addr1);
        Client gigel = new Client("Gigel Castana", LocalDate.of(1996, 5, 23), "987654321", addr2);

        DebitAccount danutDebit = new DebitAccount("RO001", 2000);
        CreditAccount danutCredit = new CreditAccount("RO002", 500, 1500);
        DebitAccount gigelDebit = new DebitAccount("RO003", 1500);
        CreditAccount gigelCredit = new CreditAccount("RO004", 1000, 1000);

        danut.addAccount(danutDebit);
        danut.addAccount(danutCredit);
        gigel.addAccount(gigelDebit);
        gigel.addAccount(gigelCredit);

        System.out.println("CLIENT INFORMATION");
        System.out.println(danut);
        danut.showAccounts();

        System.out.println();
        System.out.println(gigel);
        gigel.showAccounts();

        System.out.println("\nTRANSACTIONS");
        System.out.println("Dan withdraws 500 from DebitAccount: " + danutDebit.withdraw(500));
        System.out.println("Dan withdraws 1800 from CreditAccount: " + danutCredit.withdraw(1800));
        System.out.println("Gigel withdraws 1700 from DebitAccount (should fail): " + gigelDebit.withdraw(1700));
        System.out.println("Gigel deposits 300 into CreditAccount.");
        gigelCredit.deposit(300);

        System.out.println("\nUPDATED BALANCES");
        System.out.println("Dan's Accounts:");
        danut.showAccounts();
        System.out.println("\nGigel's Accounts:");
        gigel.showAccounts();

        System.out.println("\nWITHDRAW");
        System.out.println("Removing Dan's Debit Account (RO001): " + danut.removeAccount("RO001"));
        System.out.println("Removing Gigel's Credit Account (RO004): " + gigel.removeAccount("RO004"));

        System.out.println("\nDan's remaining accounts:");
        danut.showAccounts();
        System.out.println("\nGigel's remaining accounts:");
        gigel.showAccounts();
    
        System.out.println();
        System.out.println("********************************");
        System.out.println();

        University university = new University("Poli", "Bucuresti", 5);
        
        Author aut1 = new Author("Gigel Castana", university);
        Author aut2 = new Author("Ionel Castana", university);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);

        Publication pub1 = new ConferenceProceeding("Conf 1", false, "Publication 1", calendar, 1);
        Publication pub2 = new Journal("Journal 1", "Publication 2", calendar, 1, 4);
        Publication pub3 = new Journal("Journal 2", "Publication 3", calendar, 1, 3);
        Publication pub4 = new ConferenceProceeding("Conf 2", true, "Publication 4", calendar, 1);
        
        Publication pub5 = new Journal("Journal 3", "Publication 5", calendar, 1, 6);
        Publication pub6 = new ConferenceProceeding("Conf 3", true, "Publication 6", calendar, 1);
        Publication pub7 = new Journal("Journal 4", "Publication 7", calendar, 1, 7);
        Publication pub8 = new ConferenceProceeding("Conf 4", false, "Publication 8", calendar, 1);
        
        university.addAuthors(aut1);
        university.addAuthors(aut2);

        aut1.addPublication(pub1);
        aut1.addPublication(pub2);
        aut1.addPublication(pub3);
        aut1.addPublication(pub4);

        aut2.addPublication(pub5);
        aut2.addPublication(pub6);
        aut2.addPublication(pub7);
        aut2.addPublication(pub8);

        System.out.println("The score for author 1 is: " + aut1.calculateScore());
        System.out.println("The score for author 2 is: " + aut2.calculateScore());
        System.out.println("The university's score  is: " + university.calculateScore());
    }
}