package programmers;

import java.util.Arrays;

public class Array클레스_정리하기 {
	/**
	 * Array클레스
	 * : 배열의 복사, 항목정렬, 항목검색 등 배열 조작 기능을 가지고 있다. 
	 * : static메서드이다.
	 */
	public static void main(String[] args) {
		int[] answer = {1,5,2,6,3,7,4};
        int[][] origin = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		arrayCopy(answer, origin);
		arrayEquals(answer, origin);
		
	}
	
	/**
	 * 1. 배열복사
	 * copyOf(): 배열의 0번인덱스에서 복사할 길이만큼 복사할 타겟 배열을 리턴한다.
	 * copyOfRange(원본배열, 시작idx, 끝idx) : 시작인덱스는 포함, 끝인덱스는 포함하지 않고 복사한 배열을 리턴한다.
	 * 단순복사는 arraycopy(원본배열, 시작idx, 타겟배열, 시작idx, len복사갯수) 를 사용할 수 있다.
	 */
	public static void arrayCopy(int[] answer, int[][] cnum) {
        
        //copyOf()
        int[] answer2 = Arrays.copyOf(answer, answer.length);
        System.out.println(Arrays.toString(answer2));
       
        //copyOfRange()
		int[] pickArr = Arrays.copyOfRange(answer, 2, 5+1);
		System.out.println(Arrays.toString(pickArr));
		
		// System.arraycopy()
		int[] a4 = new int[answer.length];
		System.arraycopy(answer, 0, a4, 0, answer.length);
		System.out.println(Arrays.toString(a4));
	}
	
	/**
	 * 2. 배열 항목 비교
	 * equals(): 1차 항목의 값만 비교
	 * deepEquals(): 중첩된 배열의 항목까지 비교
	 */
	public static void arrayEquals(int[] answer, int[][] origin) {
		// 얕은 복사 후 비교
		System.out.println("[얕은 복사후 비교]");
		int[][] clone1 = Arrays.copyOf(origin, origin.length);
		System.out.println("배열 번지 비교: " + origin.equals(clone1)); // 2객체의 번지수는 같은가
		System.out.println("1차 배열 항목 비교: " + Arrays.equals(origin, clone1)); // 2객체 항목은 같은가
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(origin, clone1)); 
		
		// 깊은 복사 후 비교
		System.out.println("[깊은 복사후 비교]");
		int[][] clone2 = Arrays.copyOf(origin, origin.length);
		clone2[0] = Arrays.copyOf(origin[0], origin[0].length);
		clone2[1] = Arrays.copyOf(origin[1], origin[1].length);
		System.out.println("배열 번지 비교: " + origin.equals(clone2)); // 2객체의 번지수는 같은가
		System.out.println("1차 배열 항목 비교: " + Arrays.equals(origin, clone2)); // 2객체 항목은 같은가
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(origin, clone2)); 
		
	}
	
}
