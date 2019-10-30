package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 에어1 {


    /**
     * 알파벳으로 구성된 문자열들이 주어질 때, 각 문자열이 아래 규칙에 맞는지 확인하려 합니다.
     *
     * 모음1이 4개 이상 연속으로 오면 안 됩니다.
     * 자음2이 4개 이상 연속으로 오면 안 됩니다.
     * 같은 알파벳이 3개 이상 연속으로 오면 안 됩니다.
     * 연속된 알파벳이 4개 이상 오면 안 됩니다. (예를 들어 dcba, wxyz 등)
     * 문자열들이 담긴 배열 words가 매개변수로 주어질 때, 각 문자열이 규칙에 맞으면 1, 맞지 않으면 0을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * words는 문자열들이 담긴 배열로, 길이는 1 이상 10 이하입니다.
     * words에 담긴 각 문자열 길이는 1 이상 20 이하입니다.
     * 각 문자열은 알파벳 소문자로만 이루어져 있습니다.
     * 입출력 예
     * words	result
     * ["aeiou", "asdfgh", "yakkke", "abfedc", "xyzabc", "qwertyuiop"]	[0, 0, 0, 0, 1, 1]
     * 입출력 예 설명
     * 입출력 예 #1
     *
     * aeiou : 모음이 4자 이상 연속됩니다.
     * asdfg : 자음이 4자 이상 연속됩니다.
     * yakkke : 같은 알파벳이 3개 이상 연속됩니다.
     * abfedc : 연속된 알파벳이 4개 이상 옵니다.(fedc)
     * xyzabc, qwertyuiop : 규칙에 맞는 문자열입니다.
     * 따라서 각 문자열에 대해 순서대로 [0, 0, 0, 0, 1, 1]을 배열에 담아 return 하면 됩니다.
     *
     * a, e, i, o u ↩
     *
     * 모음을 제외한 나머지 ↩
     */

    public static void main(String[] args) {

        String[] str = {"aeiou", "asdfgh", "yakkke", "abfedc", "xyzabc", "qwertyuiop"};
        solution(str);
    }

    public static int[] solution(String[] str) {
        int[] answer = {};
        List<String> mgroup = new ArrayList<>();
        mgroup.add("a");
        mgroup.add("e");
        mgroup.add("i");
        mgroup.add("o");
        mgroup.add("u");

        byte a = (byte) str[0].charAt(0);
        System.out.println(a);

        return answer;
    }
}
