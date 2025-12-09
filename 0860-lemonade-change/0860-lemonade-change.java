class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; 
        int ten = 0;
        boolean ans = true;
        int i = 0;
        while(i<bills.length){
            if(bills[i]==5){
                five += 1;
                i++;
            } else if (bills[i]==10){
                if(five>=1){
                    five -= 1;
                    ten += 1;
                    i++;
                } else {
                    ans = false;
                    break;
                }
            } else if (bills[i]==20){
                if(five>=1 && ten>=1){
                    five -= 1;
                    ten -=1;
                    i++;
                } else if(five>=3) {
                    five = five - 3;
                    i++;
                } else {
                   ans = false;
                    break; 
                }

            } else {
                return false;
            }
        }
        return ans;
    }
}