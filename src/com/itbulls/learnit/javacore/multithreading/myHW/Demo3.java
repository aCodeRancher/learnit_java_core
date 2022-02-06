package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo3 {


    private static CountDownLatch countDownLatch = new CountDownLatch(4);

     public static void main(String... args){
            int row=4, col=100;
            int[][] data = new int[row][col];
            Demo3 demo3 = new Demo3();
            demo3.generateNumbers(row, col,data) ;
            int a=0, b=0, c=0,d=0, result=0;
            int[] intermediates = new int[row];
            try {
                long startTime =  System.currentTimeMillis();

                for (int k=0;k<row;k++){
                    int finalK = k;
                    intermediates[finalK]= CompletableFuture.supplyAsync(() -> demo3.findMax(data[finalK])).get();

                }
                countDownLatch.await();
                result = demo3.findMax(intermediates);
                System.out.println("Duration in milliseconds " + (System.currentTimeMillis() - startTime));
                System.out.println("intermediates: " + intermediates[0] + "," + intermediates[1] +"," + intermediates[2] + ","
                        + intermediates[3] + "-> max : " + result);
            }
            catch(ExecutionException | InterruptedException e){

            }

     }

    private void generateNumbers(int r, int c, int[][] numbers){

        Random random = new Random();
        int upperbound = 101;
        for (int i=0;i<r; i++){
             for (int j=0;j<c;j++){
                 numbers[i][j]= random.nextInt(upperbound);
             }
       }
    }

    private int findMax( int[] nums){
         try{
             TimeUnit.MILLISECONDS.sleep(1);
             countDownLatch.countDown();
             System.out.println( Thread.currentThread().getName() + " counts down : " + countDownLatch.getCount());
         }
         catch (InterruptedException e){

         }
          return Arrays.stream(nums).max().getAsInt();
     }

}
