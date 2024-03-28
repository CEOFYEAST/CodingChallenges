/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ceofyeast.codingchallenges;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * My solution to the 1st problem presented in the 2022 high-school programming competition at KState.
 * 
 * @author Benton Diebold
 */
public class FroyoChallenge {

    public static void main(String[] args) {
        System.out.println( FindOrdersOutOfOrder() );
    }
    
    private static int FindOrdersOutOfOrder()
    {
      Scanner s = new Scanner(System.in);
      
      final int ordersCount = 6;
      
      ArrayList<Integer> oneList = new ArrayList<>();
      ArrayList<Integer> twoList = new ArrayList<>();
      ArrayList<Integer> threeList = new ArrayList<>();
      for(int i = 0; i < ordersCount; i++)
      {
        System.out.print("Enter order num: ");
        Integer currentNum = s.nextInt();
        
        if(currentNum < 200)
        {
          oneList.add(currentNum);
        }
        else if(currentNum < 300)
        {
          twoList.add(currentNum);
        }
        else{
          threeList.add(currentNum);
        }
      }
      
      int toReturn = 0;
      toReturn += ProcessList(oneList);
      toReturn += ProcessList(twoList);
      toReturn += ProcessList(threeList);
      
      return toReturn;
    }
    
    private static int ProcessList( ArrayList<Integer> toProcess )
    {
      if(toProcess.size() == 0)
      {
        return 0;
      }
      
      int max = toProcess.get(0);
      int outOfOrders = 0;
      for(int i = 0; i < toProcess.size(); i++)
      {
        if(toProcess.get(i) < max)
        {
          outOfOrders++;
        }
        else {
          max = toProcess.get(i);
        }
      }
      
      return outOfOrders;
    }
    
    /*
    want to serve customers in the exact order they place their orders
      something prevents this
      - yogurt machines need repair, customer's order can be delayed
      - "delayed" means receiving order after other customer who placed order after you
        - this is very bad
    
    three ordering kiosks
      - each kiosk assigns order number (1: 100-199, 2: 200-299)
      - each order number is always biggest than last order number
    
    list of integers stores order numbers in order of recieved orders (not ordered order)
    
    steps
      - take 6 order numbers as user input and store in some data structure
      - find occurrences where larger order number at given kiosk comes before smaller number 
        - an order can only be out of order once
    
    */
}
