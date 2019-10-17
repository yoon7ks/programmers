package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 수정렬 {

	/**
	 * 
	 * 함수 solution은 정수 n을 매개변수로 입력받습니다. 
	 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 118372;
		solution(n);
	}

	public static long solution(long n) {
		long answer = 0;
		
		String str = String.valueOf(n);
		char[] a = str.toCharArray();
		
		List<Character> cList = new ArrayList<Character>();
		List<Character> returnList = new LinkedList<Character>();
		for (char s : a) {
			cList.add(s);
		}
		
		returnList = cList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		String b = "";
		for (int i=0; i < returnList.size(); i++) {
			b += String.valueOf(returnList.get(i));
		}
		
		answer = Long.valueOf(b);
		
		return answer;
	}
}
