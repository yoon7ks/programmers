package programmers.lv1;

public class 짝수문자열반환 {

	/**
	 * 
	 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.

s		return
abcde	c
qwer	we

	 * @param args
	 */
	public static void main(String[] args) {
		String answer = "";

		answer = solution("abcdefg");

		answer = solution("qwer");
	}

	public static String solution(String s) {
		String answer = "";
		double len = s.length()/2.0;
		int a = (int) Math.ceil(len);
		
		if (s.length()%2 == 0) {
			// 짝수
			answer = s.substring(a-1, a+1);
		} else {
			// 홀수
			answer = s.substring(a-1, a);
		}
		
		return answer;
	}
}
