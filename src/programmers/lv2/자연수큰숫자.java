package programmers.lv2;

public class 자연수큰숫자 {

	/**
	 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

제한 사항
n은 1,000,000 이하의 자연수 입니다.

입출력 예
n	result
78	83
15	23
입출력 예 설명
입출력 예#1
문제 예시와 같습니다.
입출력 예#2
15(1111)의 다음 큰 숫자는 23(10111)입니다.

	 * @param args
	 */
	public static void main(String[] args) {
		solution(78);
	}

	public static int solution(int n) {
		int answer = 0;
		
		String str = Integer.toBinaryString(n); // 10진수 -> 2진수 변환
		//System.out.println(str);
		char[] ch = str.toCharArray();
		int cnt = 0;
		
		for (char c : ch) {
			if (c == '1') {
				cnt++;
			}
		}
		
		//System.out.println("cnt="+cnt);
		for (int i = n+1; n <= 1000000; i++) {
			String tempStr = Integer.toBinaryString(i);
			//System.out.println("==>"+tempStr);
			
			char[] chars = tempStr.toCharArray();
			int cn = 0;
			
			for (char c : chars) {
				if (c == '1') {
					cn++;
				}
			}
			
			//System.out.println("cn=" + cn);
			if (cn == cnt) {
				
				answer = Integer.parseInt(tempStr, 2); // 2진수 -> 10진수 변환
				break;
			}
		}
		
		System.out.println("결과값==" + answer);
		
		return answer;
	}

}
