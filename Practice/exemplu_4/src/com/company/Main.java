package com.company;

public static class Main {
    public static void main(String[] args) throws Exception {
        final BankAccount momAccount = new BankAccount("mom", 100_000);
        final BankAccount myAccount = new BankAccount("me", 100);
        Transaction t1 = new Transaction("T1", momAccount, myAccount, 10);
        Transaction t2 = new Transaction("T2", momAccount, myAccount, 100);
        t1.start();
        t2.start();
        //wait for transfers to be completed
        t1.join();
        t2.join();
        System.out.println(momAccount);
        System.out.println(myAccount);
    }

    static class Transaction extends Thread {
        public Transaction(String name, BankAccount from, BankAccount to, int amout) { //TODO your implementation here        }
            @Override public void run () {            //TODO your implementation here        }
            }
            static class BankAccount {
                public BankAccount(String name, int debit) {            //TODO your implementation here        }
                    static void transfer (BankAccount from, BankAccount to,int amount)
                    {            //TODO your implementation here        }
                        void withdraw ( double amount){
                        longDatabaseCall();            //TODO your implementation here        }
                        void deposit ( double amount){
                            longDatabaseCall();            //TODO your implementation here        }
                            void longDatabaseCall () {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    }
                }
            }
        }
    }
}
