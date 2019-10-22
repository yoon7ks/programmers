package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 약수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5);
	}
// 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
/*
 * n은 0 이상 3000이하인 자연수입니다.
 * 입출력 예 #1
12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

입출력 예 #2
5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
 */
	/**
	 * 약수는 어떤 수를 나머지 없이 나눌 수 있는 수
	 * 1,3,5,15는 15를 나머지 없이 나눌 수 있기 때문에 15의 약수이다. 
	 * 모든 수는 1과 자기자신이 약수이다.
	 * 
	 * @param n
	 * @return
	 */
	  public static int solution(int n) {
	      int answer = 0;
	      List<Integer> sub = new ArrayList<Integer>();
	      int j = 0;
	      
	      for (int i = 1; i*i < n; i++) {
	    	  if ( n % i == 0) {
	    		  //sub.add(i);
	    		 // sub.add(n/i);
	    		  answer += i;
	    		  answer += (n/i);
	    	  }
	    	 
	    	  if (j*i==n) {
	    		  answer += i;
	    	  }
	    	  
	      }
	     // answer = sub.stream().reduce(0, Integer::sum);
	      System.out.println(answer);
	      System.out.println(answer);
	      return answer;
	  }
}
