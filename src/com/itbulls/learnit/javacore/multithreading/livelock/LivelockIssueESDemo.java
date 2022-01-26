package com.itbulls.learnit.javacore.multithreading.livelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LivelockIssueESDemo {

    public static void main(String[] args) {
        Spouse1 husband = new  Spouse1("Igor");
        Spouse1 wife = new  Spouse1("Nastia");

         Spoon1 s = new  Spoon1(husband);

     //   new Thread(() -> husband.eatWith(s, wife)).start();
     //   new Thread(() -> wife.eatWith(s, husband)).start();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(()-> husband.eatWith(s,wife));
        es.execute(()-> wife.eatWith(s,husband));

    }

    static class Spoon1 {
        private Spouse1 owner;

        public Spoon1( Spouse1 spouse) {
            owner = spouse;
        }

        public  Spouse1 getOwner() {
            return owner;
        }

        public synchronized void setOwner( Spouse1 spouse) {
            owner = spouse;
        }

        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.name);
        }
    }

    static class Spouse1 {
        private String name;
        private boolean isHungry;

        public Spouse1(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith( Spoon1 spoon,  Spouse1 spouse) {
            while (isHungry) {
                // Don't have the spoon, so wait patiently for spouse.
                if (spoon.owner != this) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // If spouse is hungry, insist upon passing the spoon.
                if (spouse.isHungry()) {
                    System.out.printf("%s: You eat first my darling %s!%n", name, spouse.getName());
                    spoon.setOwner(spouse);
                    System.out.println(" Who has the spoon now ? " + spoon.getOwner().getName());
                    continue;
                }

                // Spouse wasn't hungry, so finally eat
                spoon.use();
                isHungry = false;
                System.out.printf("%s: I am stuffed, my darling %s! I'm not hungry anymore%n", name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }
}
