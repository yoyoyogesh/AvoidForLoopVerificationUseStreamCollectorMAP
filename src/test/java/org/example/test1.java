package org.example;


import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    //Count the number of names starting with alphabet
    // A in list.
   public static void main(String [] args) {

           ArrayList<String> names = new ArrayList<String>();
           names.add("Yogesh");
           names.add("Pratap");
           names.add("Sunil");
           names.add("Amol");
           names.add("Anil");
           names.add("Abhinandan");
           int count = 0;

           for (int i = 0; i < names.size(); i++) {
               String actualnames = names.get(i);
               if (actualnames.startsWith("A")) {
                   count++;
               }
           }
           System.out.println("Total count = " + count);
           streamFilter();
           streamMap();
       streamCollect();
   }

   public static void streamFilter()
   {
       ArrayList<String> names = new ArrayList<String>();
       names.add("Yogesh");
       names.add("Pratap");
       names.add("Sunil");
       names.add("Amol");
       names.add("Anil");
       names.add("Abhinandan");

       long c = names.stream().filter(s->s.startsWith("A")).count();
       System.out.println("Stream used and count = "+c);

       long d =Stream.of("Yogesh","Pratap","Sunil",
               "Amol","Anil","Abhinandan").filter(s->
               {
               s.startsWith("A");
               return false;
               }).count();
       System.out.println("Stream instead of for loop = "+d);

       //print all the names of ArrayList
       names.stream().filter(s->s.length()>4).forEach(s-> System.out.println("Stream with for each = "+s));
       names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println("Stream with for each for single result = "+s));
   }

   public static void streamMap()
   {
       ArrayList<String> names = new ArrayList<String>();
       names.add("Kalidas");
       names.add("Santya");
       names.add("Parshya");

       //print names which has last letter as "h" with uppercase.
       Stream.of("John","Pratap","Sunil",
               "Amol","Anil","Azbhinandan").filter(s->s.endsWith("n"))
               .map(s->s.toUpperCase()).forEach(s-> System.out.println("Stream with map = "+s));

       //print names which have first letter as "a" with uppercase and sorted.
       List<String> names1= Arrays.asList("John","Pratap","Sunil",
               "Amol","Anil","Abhinandan");
       names1.stream().filter(s->s.startsWith("A")).sorted()
               .map(s->s.toUpperCase()).
               forEach(s-> System.out.println("Stream with map with sort = "+s));

       //Merging two different lists
       Stream<String> newStream =  Stream.concat(names.stream(), names1.stream());
       //newStream.sorted().forEach(s -> System.out.println(
       //        "Merged two lists using Stream = "+s
       //));

      boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Anil"));
       System.out.println("flag = "+flag);
      Assert.assertTrue(flag);

   }

   public static void streamCollect()
   {
       //list
       //new list
       //new list
       List<String> ls = Stream.of("John","Pratap","Sunil",
                       "Amol","Anil","Azbhinandan").filter(s->s.endsWith("n"))
               .map(s->s.toUpperCase()).collect(Collectors.toList());
       System.out.println("New list created using stream collector = "
               +ls.get(0));

       //Assignment
       //Print unique number from this array and sort the array and provide 3rd index
       List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
      values.stream().distinct().forEach(s -> System.out.println(s));

      List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
       System.out.println("Print unique number from this array and " +
               "sort the array and provide 3rd index = "+li.get(2));
         }
}
