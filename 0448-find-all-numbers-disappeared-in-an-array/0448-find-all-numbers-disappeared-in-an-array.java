class Solution {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n=nums.length;
        int index =0;
        
        //sorting the array using cyclic sort such that repated 
        //numbers take place in place of missing numbers index

        while(index<n){
            int element = nums[index];
            int correct = element-1;  // because array is from [1,N]
            if(nums[index]!=nums[correct]){
                int temp=nums[index];
                nums[index]=nums[correct];
                nums[correct]=temp;
            }
            else{
                index++;
            }
        }

        List<Integer> ls = new ArrayList<>();

        //traversing the array for elements and its corresponding index not matching
        //here we comparing with i+1 because array is from [1,N]
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                ls.add(i+1);
            }
        }
        return ls;
    }
}