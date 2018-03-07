import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * ex.
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 */
public class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new ArrayList<>();
    for( int i = left ; i <= right ; i++ ) {
      // 10의 배수일경우 자릿수중 0이 포함되므로 reuslt에 포함되지않음
      // 0으로는 나누어 떨어지지않으므로.. 10이상이면서 소수인경우도 마찬가지
      if( i % 10 == 0 ) {
        continue;
      }
      int cnt = 0;
      int length = 0;
      int current = i;
      while( current > 0 ) {
        length++;
        int mod = current % 10;
        current /= 10;
        if( mod == 0 ) continue;
        if( i % mod == 0 ) cnt++;
      }
      if( cnt == length ) result.add(i);
    }
    return result;
  }
  public static void main(String[] args) {
    SelfDividingNumbers sdn = new SelfDividingNumbers();
    int left = 40;
    int right = 57;
    List<Integer> re = sdn.selfDividingNumbers(left, right);
    for( int r : re ) {
      System.out.print(r + " ");
    }
  }
}
