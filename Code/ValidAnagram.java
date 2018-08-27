import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*  242. https://leetcode.com/problems/valid-anagram/description/
*
*  string s와 t가 주어졌을 때 t가 s의 anagram인지를 결정
*
* ex1)
* input: s = "anagram", t = "nagaram"
* output: true
*
* ex2)
* input: s = "rat", t = "car"
* output: false
* */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if( s.length() != t.length() ) return false;

    Map<Character, Integer> map = new HashMap<>();

    // 1. s의 각 문자를 map에 넣는다. key: 해당문자, value: 빈도수
    for( int i = 0 ; i < s.length() ; i++ ) {
      Character ch = s.charAt(i);
      Integer cnt = 1;
      if( map.containsKey( ch ) ) {
        cnt = map.get(ch);
        cnt++;
      }
      map.put(ch, cnt);

    }
    // 2. t를 탐색하며 s의 각 문자의 빈도수를 제거
    // - 해당 문자의 value가 1일경우 key를 제거
    for( int i = 0 ; i < t.length() ; i++ ) {
      Character ch = t.charAt(i);
      if( !map.containsKey( ch ) ) {
        return false;
      }

      Integer cnt = map.get(ch);
      if( cnt == 1 ) {
        map.remove(ch);
      } else {
        cnt--;
        map.replace(ch, cnt);
      }
    }

    // 3. map이 비었을 경우 true
    return (map.size() == 0);
  }

  public boolean isAnagram2(String s, String t) {
    if( s.length() != t.length() ) return false;
    Integer[] arr = new Integer[26];
    Arrays.fill(arr , 0);
    for( int i = 0 ; i < s.length() ; i++ ) {
      Character chS = s.charAt(i);
      Character chT = t.charAt(i);
      arr[chS - 'a']++;
      arr[chT - 'a']--;
    }

    for( int i = 0 ; i < 26 ; i++ ) {
      if( arr[i] != 0 ) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ValidAnagram va = new ValidAnagram();
    String s = "anagram";
    String t = "nagaram";
    System.out.println(va.isAnagram(s, t));
    System.out.println(va.isAnagram2(s, t));
  }
}
