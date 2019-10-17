package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No1 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		String[] array = s.split("");
		String ancwer = Arrays.stream(array).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
		System.out.println(ancwer);
		
		String[] str = {"sun", "bed", "car"};
		
		
	}

}
