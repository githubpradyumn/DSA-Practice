class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = 0;
        int eb = 0; // empty bottles
        
        while (numBottles > 0) {
            drinked += numBottles;   
            eb += numBottles;        
            
            numBottles = eb / numExchange; 
            eb = eb % numExchange;         
        }
        return drinked;
    }
}