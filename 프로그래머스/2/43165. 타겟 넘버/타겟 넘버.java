class Solution {
    int cnt = 0;
    int N;
    int[] nums;

    public int solution(int[] numbers, int target) {
        N = numbers.length;
        nums = numbers.clone();
        dfs(0, 0, target);
        return cnt;
    }

    void dfs(int index, int now, int target) {
        if (index > N) return;
        if (target == now && index == N) {
            cnt++;
            return;
        } else if (index == N) return;
        dfs(index+1, now + nums[index], target);
        dfs(index+1, now - nums[index], target);
    }
}