package programmers.lv1;

public class 소수의갯수구하기 {

	/**
	 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.

입출력 예 설명
입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * #소수
		 * 정확이 2개의 약수를 가진 수를 소수라고 한다.
		 * 1과 자기자신 이외에는 다른 약수를 갖지 못한다.
		 * 
		 * 어떤 수 n이 소수인지 판별하기 위해서는 n을 2부터 n-1까지 하나씩 나누어보아
		 * 나누어 떨어지는 수가 존재하지 않으면 n은 소수가 된다.
		 * 
		 *  
		 *  #합성수: 2개 이상의 약수를 가지고 있다.
		 *  16은 합성수이다. 16의 약수는 1,2,4,8,16이다.
		 *  이수들은 모두 16을 똑같이 나눈다.
		 *  
		 *  1은 소수도 합성수도 아니다.
		 *  1은 유일한 약수는 1이다.
		 *  소수는 정확히 두개의 약수를 갖고있다.
		 *  합성수는 두개이상의 약수를 갖고있다.
		 */
		
		solution(10);
	}

	public static int solution(int n) {
		int answer = 0;
		
		for (int i = 2; i <= n; i++) { 
			// 어떤수=i  // 1,2,3,4,5
			// 2를 제외한 모든 소수는 홀수이다. n이 짝수면 소수가 아니다.
			if ((i/2 == 0 && i !=2)) { //2는 무조건 소수 나눠서 수가 있으면 홀수이므로 짝수면 무조건 체크
				// 여기 들어오면 소수이다
				System.out.println(i);
				answer++;
				continue;
			}
			
			boolean isPrime = true;
			for (int j = 2; j*j <= i; j++) {
				if (i%j == 0) {
					//나누어지면 소수가 아니다.
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				System.out.println(i);
				// 소수이면 소수이면 갯수를 더한다.
				answer++;
			}
			
		}
		
		System.out.println("소수의갯수="+answer);
		return answer;
	}
	
	
	public static int solution2(int n) {
		int answer = n;
		
		// 나눌 대상 n
		for (int i = 1; i <= n; i++) { // 1,2,3,4,5
			// 5이면 1부터~5까지 루프
			// 자기자신/2 보다 큰수는 약수가 될 수 없다.
			// 약수가 없는 수가 소수이므로 2부터 n/2까지만 확인하면 된다.
			double last = i/2; 
			
			if (i <= 1) { // 소수는 1보다 큰 자연수 
				answer--;
				continue;
			}
			
			for (int j = 2; j <= last; j++) {
				if (i % j == 0) {
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);
		return answer;
	}
}
