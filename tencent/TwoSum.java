class TwoSum{
   
   public static void main(String[] args) {
       twoSum(new int[]{"2,7,11,15"},9)
   }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap();
        for(int i = 0 ; i < nums.length; i++){
            Integer a = map.get(target-nums[i]);
            if(i != null){
                return new int []{i,a}
            }
            map.put(nums[i],i);
        }
    }
}