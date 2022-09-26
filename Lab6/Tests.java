import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void getAccoutOwnerName() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        assertEquals(b1.getAccoutOwnerName(), "Josh");
        BankAccount b2=new SavingsAccount("Jack", 50, 1);
        assertEquals(b2.getAccoutOwnerName(), "Jack");

    }

    @Test
    void getCurrentAccountBalance() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        BankAccount b2=new SavingsAccount("Jack", 50, 1);
        assertEquals(b1.getCurrentAccountBalance(),100);
        assertEquals(b2.getCurrentAccountBalance(),50);
    }

    @Test
    void setCurrentAccountBalance() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        assertEquals(b1.getCurrentAccountBalance(),100);
        b1.setCurrentAccountBalance(1000);
        assertEquals(b1.getCurrentAccountBalance(),1000);
        BankAccount b2=new SavingsAccount("Jack", 200, 1);
        assertEquals(b2.getCurrentAccountBalance(),200);
        b2.setCurrentAccountBalance(1000);
        assertEquals(b2.getCurrentAccountBalance(),1000);

    }

    @Test
    void deposit() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        assertEquals(b1.getCurrentAccountBalance(),100);
        b1.deposit(100);
        assertEquals(b1.getCurrentAccountBalance(),200);
        BankAccount b2=new SavingsAccount("Jack", 200, 1);
        assertEquals(b2.getCurrentAccountBalance(),200);
        b2.deposit(12.3);
        assertEquals(b2.getCurrentAccountBalance(), 212.3);
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                ()->{b1.deposit(-222);} );
        Throwable exception2 = assertThrows(IllegalArgumentException.class,
                ()->{b2.deposit(-22222);} );

    }

    @Test
    void withdraw() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        BankAccount b2=new SavingsAccount("Jack",50, 1);
        b1.withdraw(1.5,1);
        assertEquals(b1.getCurrentAccountBalance(), 100-(.97*1.5));
        b2.withdraw(25,1);
        assertEquals(b2.getCurrentAccountBalance(), 25);
        ((SavingsAccount) b2).setWithdrawalsThisMonth(6);
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                ()->{b2.withdraw(1, 1);} );
    }

    @Test
    void transferMoney() {
        BankAccount b1=new CheckingAccount("Josh", 100);
        BankAccount b2=new SavingsAccount("Jack",50, 1);
        assertEquals(b1.getCurrentAccountBalance(), 100);
        assertEquals(b2.getCurrentAccountBalance(),50);
        b1.transferMoney(30, b2, 1);
        assertEquals(b1.getCurrentAccountBalance(),70.9);
        assertEquals(b2.getCurrentAccountBalance(),80);
        b2.transferMoney(10, b1, 1);
        assertEquals(b2.getCurrentAccountBalance(),70);
        assertEquals(b1.getCurrentAccountBalance(),80.9);
        assertEquals(((SavingsAccount) b2).getWithdrawalsThisMonth(), 1);
    }

    @Test
    void getWithdrawalsThisMonth() {
        SavingsAccount b2=new SavingsAccount("Jack",50, 1);
        assertEquals(b2.getWithdrawalsThisMonth(),0);
        b2.withdraw(1,1);
        assertEquals(b2.getWithdrawalsThisMonth(),1);
        b2.withdraw(1,1);
        assertEquals(b2.getWithdrawalsThisMonth(),2);
    }

    @Test
    void getCurrentMonth() {
        SavingsAccount b2=new SavingsAccount("Jack",50, 1);
        assertEquals(b2.getCurrentMonth(),1);
        b2.setCurrentMonth(2);
        assertEquals(b2.getCurrentMonth(),2);
    }

    @Test
    void setWithdrawalsThisMonth() {
        SavingsAccount b2=new SavingsAccount("Jack",50, 1);
        assertEquals(b2.getWithdrawalsThisMonth(),0);
        b2.setWithdrawalsThisMonth(3);
        assertEquals(b2.getWithdrawalsThisMonth(),3);
    }

    @Test
    void setCurrentMonth() {
        SavingsAccount b2=new SavingsAccount("Jack",50, 1);
        assertEquals(b2.getCurrentMonth(),1);
        b2.setCurrentMonth(2);
        assertEquals(b2.getCurrentMonth(),2);
    }

    @Test
    void isLastElementInList() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.toList().toString(), "[Hi, Hello, Howdy]");
        assertEquals(s1.getNextElement().getNextElement().isLastElementInList(), true);
        assertEquals(s1.getNextElement().isLastElementInList(), false);
    }

    @Test
    void changeNextElement() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        StringLinkedList s2=new StringLinkedList("Bye");
        s2.add("Goodbye");
        s2.add("See ya");
        assertEquals(s1.toList().toString(), "[Hi, Hello, Howdy]");
        assertEquals(s2.toList().toString(), "[Bye, Goodbye, See ya]");

        s1.changeNextElement(s2);
        assertEquals(s1.toList().toString(), "[Hi, Bye, Goodbye, See ya, Howdy]");
    }

    @Test
    void add() {
        StringLinkedList s1=new StringLinkedList("Hi");
        assertEquals(s1.toList().toString(), "[Hi]");
        s1.add("Hello");
        assertEquals(s1.toList().toString(),"[Hi, Hello]");
        s1.add("Yo",1);
        assertEquals(s1.toList().toString(),"[Hi, Yo, Hello]");

        StringSet str1=new StringSet();
        assertEquals(str1.toList().toString(), "[]");
        str1.add("Hi");
        assertEquals(str1.toList().toString(), "[Hi]");
        str1.add("Hello");
        assertEquals(str1.toList().toString(), "[Hi, Hello]");
    }

    @Test
    void getNextElement() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.getNextElement().getValue(),"Hello");
        assertEquals(s1.getNextElement().getNextElement().getValue(),"Howdy");
    }

    @Test
    void getValue() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.getValue(),"Hi");
        assertEquals(s1.getNextElement().getValue(),"Hello");
        assertEquals(s1.getNextElement().getNextElement().getValue(),"Howdy");
    }

    @Test
    void getSize() {
        StringLinkedList s1=new StringLinkedList("Hi");
        assertEquals(s1.getSize(),1);
        s1.add("Hello");
        assertEquals(s1.getSize(),2);
        s1.add("Howdy");
        assertEquals(s1.getSize(),3);

        StringSet str1=new StringSet();
        str1.add("Hi");
        assertEquals(str1.getSize(),1);
        str1.add("Hello");
        assertEquals(str1.getSize(),2);
        str1.add("Howdy");
        assertEquals(str1.getSize(),3);
    }

    @Test
    void contains() {
        StringLinkedList s1=new StringLinkedList("Hi");
        StringLinkedList s2=new StringLinkedList("Yo");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.contains("Hello"),true);
        assertEquals(s1.contains("Yo"),false);

        StringSet str1=new StringSet();
        str1.add("Hi");
        str1.add("Hello");
        str1.add("Howdy");
        assertEquals(str1.contains("Hello"),true);
        assertEquals(str1.contains("Yo"),false);
    }

    @Test
    void getIndexOf() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.getIndexOf("Hi"),0);
        assertEquals(s1.getIndexOf("Hello"),1);
        assertEquals(s1.getIndexOf("Howdy"),2);
        assertEquals(s1.getIndexOf(s1.getNextElement()),1);
        assertEquals(s1.getIndexOf(s1.getNextElement().getNextElement()),2);
    }

    @Test
    void remove() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.toList().toString(),"[Hi, Hello, Howdy]");
        s1.remove("Hello");
        assertEquals(s1.toList().toString(),"[Hi, Howdy]");
        s1.remove("Howdy");
        assertEquals(s1.toList().toString(),"[Hi]");
    }

    @Test
    void addAllFromCollection() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.toList().toString(),"[Hi, Hello, Howdy]");

        StringSet str1=new StringSet();
        str1.add("Hey");
        str1.add("Yo");
        str1.add("Sup");
        assertEquals(str1.toList().toString(),"[Hey, Yo, Sup]");
        s1.addAllFromCollection(str1);
        assertEquals(s1.toList().toString(),"[Hi, Hello, Howdy, Hey, Yo, Sup]");

        s1.remove("Hey");
        s1.remove("Yo");
        s1.remove("Sup");
        assertEquals(s1.toList().toString(),"[Hi, Hello, Howdy]");

        str1.addAllFromCollection(s1);
        assertEquals(str1.toList().toString(),"[Hey, Yo, Sup, Hi, Hello, Howdy]");
    }

    @Test
    void toList() {
        StringLinkedList s1=new StringLinkedList("Hi");
        s1.add("Hello");
        s1.add("Howdy");
        assertEquals(s1.toList().toString(), "[Hi, Hello, Howdy]");

        StringSet str1=new StringSet();
        str1.add("Hey");
        str1.add("Yo");
        str1.add("Sup");
        assertEquals(str1.toList().toString(), "[Hey, Yo, Sup]");
    }


}