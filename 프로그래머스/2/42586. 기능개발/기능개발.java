import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int curr = 0, pre = queue.peek();
        int cnt = 0;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            if(pre < curr) {
                list.add(cnt);
                pre = curr;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}