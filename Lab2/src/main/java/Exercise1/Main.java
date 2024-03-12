package org.example;


public class Main {
        public static void main (String[] args)
        {

            Integer monitor1 = 1;
            Integer monitor2 = 1;
            new F13(monitor1,4,4,2,4).start();
            new F2(monitor1,monitor2,3,3,3,6).start();
            new F13(monitor2,5,5,2,5).start();

        }
}