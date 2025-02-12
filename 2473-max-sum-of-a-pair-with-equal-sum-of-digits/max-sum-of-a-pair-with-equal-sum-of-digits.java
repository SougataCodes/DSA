class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i : nums){
            int sum=0;
            int val = i;
            while(val != 0){
                sum+=val%10;
                val=val/10;
            }
            PriorityQueue<Integer> ts = map.getOrDefault(sum, new PriorityQueue<>(Collections.reverseOrder()));
            ts.add(i);
            map.put(sum, ts);
        }
        int ans = 0;
        for(int s : map.keySet()){
            PriorityQueue list = map.get(s);
            if(list.size()>=2){
                int f = (int) list.poll();
                int l = (int) list.poll();
                
                ans = Math.max(ans, f+l);
            }
        }
        return ans==0?-1:ans;
    }
}