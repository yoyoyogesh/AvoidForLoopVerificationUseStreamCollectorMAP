# AvoidForLoopVerificationUseStreamCollectorMAP
AvoidForLoopVerificationUseStreamCollectorMAP 

Where to use these java concepts:
1. For loop: Avoid filtering using for loop and use Stream filter instead.
   (ex: names.stream().filter(s->s.length()>4).forEach(s-> System.out.println("Stream with for each = "+s));

2. Merge List: Use Stream to merge list and perform further operation.
3. Collector: Get data using Selenium getText() method and store in a list, convert that list into stream, and perform further operation.
   Ex:
 List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);

      List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
       System.out.println("Print unique number from this array and " +
               "sort the array and provide 3rd index = "+li.get(2));   
