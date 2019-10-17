package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 배열 {
	
	/**
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
	 */
	
	public static void main(String[] args) {
		
        int[] answer = {1,5,2,6,3,7,4};
        int[][] cnum = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
  /*      
        List<Integer> numList = new ArrayList<>();
        // j번째 숫자까지 잘라서 넣는다.
        for (int n =0; n < answer.length; n++) {
        	if (n >= i-1 && n <= j-1) {
        		numList.add(answer[n]);
        	}
        	System.out.println(numList);
        }
        // 정렬한뒤 
        List<Integer> sortList = new ArrayList<>();
        sortList = numList.stream().sorted().collect(Collectors.toList());
    	System.out.println(sortList);
    	System.out.println(sortList.get(k-1));*/
    	
    	int[] anwser = solution(answer, cnum);
    	int[] anwser2 = solution2(answer, cnum);
    	
    	System.out.println(Arrays.toString(anwser));
    	System.out.println(Arrays.toString(anwser2));
	}
	

	public static int[] solution2(int[] array, int[][] commands) {
		// 리턴할 배열 초기화 // 입력된 커맨드객체의 갯수로 초기화한다.
		int[] anwser = new int[commands.length];

		
		
		// 커맨드객체 갯수만큼 루프를 돌린다.
		for (int n = 0; n < commands.length; n++) {
			// 각 번째의 i, j, k값을 초기화한다.
			int[] unit = commands[n];
			int i = 0, j = 0, k = 0;
			i = unit[0]; 
			j = unit[1]; 
			k = unit[2];

			List<Integer> numList = new ArrayList<>();
			
			// j번째 숫자까지 잘라서 넣는다.
			for (int m = 0; m < array.length; m++) {
				if (m >= i - 1 && m <= j - 1) {
					numList.add(array[m]);
				}
			}
			

			// 정렬한뒤 k번째 값을 리턴 배열에 넣는다.
			List<Integer> sortList = new ArrayList<>();
			sortList = numList.stream().sorted().collect(Collectors.toList());
			anwser[n] = sortList.get(k - 1);
		}

		return anwser;

	}

	public static int[] solution(int[] array, int[][] commands) {
		// 리턴할 배열 초기화 // 입력된 커맨드객체의 갯수로 초기화한다.
		int[] anwser = new int[commands.length];

		// 커맨드객체 갯수만큼 루프를 돌린다.
		for (int n = 0; n < commands.length; n++) {
			// 각 번째의 i, j, k값을 초기화한다.
			int[] unit = commands[n];
			int i = 0, j = 0, k = 0;
			i = unit[0];
			j = unit[1];
			k = unit[2];

			List<Integer> numList = new ArrayList<>();

			// j번째 숫자까지 잘라서 넣는다.
			for (int m = 0; m < array.length; m++) {
				if (m >= i - 1 && m <= j - 1) {
					numList.add(array[m]);
				}
			}

			// 정렬한뒤 k번째 값을 리턴 배열에 넣는다.
			List<Integer> sortList = new ArrayList<>();
			sortList = numList.stream().sorted().collect(Collectors.toList());
			anwser[n] = sortList.get(k - 1);
		}

		return anwser;

	}
	
}
