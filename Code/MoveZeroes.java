class Solution {
  public void moveZeroes(int[] nums) {
    // 0을 찾으면 nums에 넣지않음
    int current = 0;
    for( int i = 0 ; i < nums.length ; i++ ) {
      if( nums[i] == 0 ) {
        continue;
      }
      nums[current] = nums[i];
      current++;
    }
    // current가 nums.length 보다 작다면 나머지 뒷부분에 0을 채워줌
    for( int i = current ; i < nums.length ; i++ ) {
      nums[i] = 0;
    }
  }
}