package programmers.lv2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 에어2 {

    /**
     * N개의 원소로 이루어진 수열 A가 있습니다. 수열 A에서 다음 조건을 만족하는 구간의 길이를 구해서 return하세요.
     * <p>
     * 구간의 모든 연속된 원소들의 합이 S 이상이어야 합니다.
     * 위의 조건을 만족하는 구간 중 가장 길이가 짧아야 합니다.
     * 제한사항
     * 원소의 개수 : 100,000 이하의 자연수
     * 원소 : 10,000 이하의 자연수
     * S : 10억 이하의 자연수
     * 입출력 예
     * A	                    S	return
     * [1,10,2,9,3,8,4,7,5,6]	20	3
     * 입출력 예 설명
     * 입출력 예 #1
     * 2번째에서 4번째 까지 구간인 [10,2,9]의 합이 20보다 크고, 4번째에서 6번째 까지 구간인 [9,3,8]의 합이 20이므로 조건을 만족하는 가장 짧은 구간의 길이는 3입니다.
     */
    static int sum;
    static int S = 0;
    static int count = 0;

    public static void main(String[] args) {

        int[] str = {1, 1, 2, 9, 13, 8, 4, 7, 5, 6};
        int answer = solution(str, 20);
        System.out.println(answer);
    }

    static class BreakException extends RuntimeException {}

    public static int solution(int[] str, int s1) {
        int answer = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            List<Integer> cList = new ArrayList<Integer>();
            count=0;
            sum=0;
            List<Integer> returnList = new LinkedList<Integer>();
            for (int s : str) {
                cList.add(s);
            }
           returnList = cList.stream().collect(Collectors.toList());
                try {
                    returnList.stream().forEach(s -> {
                        if (s > 0) {
                            sum += s;
                            count++;
                            if (sum >= s1) {
                                throw new BreakException();
                            }
                        }
                    });
                } catch (BreakException e) {
                    result.add(count);
                    str[i] = 0;
                }
        }

        System.out.println("result==>"+  Collections.min(result));

        answer = Collections.min(result);
        return answer;
    }
}
