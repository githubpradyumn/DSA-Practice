class Solution {
    public boolean checkPerfectNumber(int num) {
        //define a variable to store all the divisors
        long count = 0;

        //create a for loop that goes from 1 till num-1 to find its divisors
        for(int i = 1;i<num;i++){

            //if divisors found, add it to count 
            if(num%i == 0)
              count += i;

            // if divisors sum exceed the num then it is not a perfect number
            if(count > num)
              return false;
        }

        //check if num is perfect or not 
        return count==num;
    }
}