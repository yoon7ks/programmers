package programmers.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 땅따먹기 {
	
	/**
	 * 땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 
	 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 
	 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.

예를 들면,

| 1 | 2 | 3 | 5 |

| 5 | 6 | 7 | 8 |

| 4 | 3 | 2 | 1 |

로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.

마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요. 
위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.

제한사항
행의 개수 N : 100,000 이하의 자연수
열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
점수 : 100 이하의 자연수
입출력 예
land								answer
[[1,2,3,5],[5,6,7,8],[4,3,2,1]]		16
	 * @param args
	 */
	public static void main(String[] args) {
		//int[][] land = {{1,2,3,5},{5,6,7,8},{1,2,3,4}};
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		int anwser1 = solution(land);
		int anwser2 = solution2(land);
		int anwser3 = solution3(land);
		int anwser4 = solution4(land);
		System.out.println(anwser1);
		System.out.println(anwser2);
		System.out.println(anwser3); //?
		System.out.println(anwser4); //?
	}
	/**
	 * 동적계획법
	 * 
	 * @param land
	 * @return
	 */
	// 오답
	public static int solution(int[][] land) {
        int answer = 0;
        
        int row = land.length; // 행의 갯수 
        
        int maxIdx = 0;
        for (int i = 0; i < row; i++) {
        	int max = 0;
        	int[] rowArr = land[i];
        	List<Integer> rowList = IntStream.of(rowArr).boxed().collect(Collectors.toList());
        	
        	if (maxIdx > 0) {
        		rowList.set(maxIdx-1, 0);
        	}
        	
        	for (int j = 0; j < rowList.size(); j++) {
            	// 1, 2비교
            	if (max < rowList.get(j)) {
            		max = rowList.get(j);
            		maxIdx = j+1;
            	}
            }
        	answer+=max;
        	//System.out.println(max + ":" + maxIdx);
        }
        
       // System.out.println(answer);
        
        return answer;
    }
	
	// 풀이2
	public static int solution2(int[][] land) {
		for (int i = 1; i < land.length; i++) {
			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
		}

		return Math.max(land[land.length - 1][0],
				Math.max(land[land.length - 1][1], Math.max(land[land.length - 1][2], land[land.length - 1][3])));
	}

	// 풀이3
	public static int solution3(int[][] land) {
		
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < land[0].length; k++) {
					if (k == j)
						continue;
					else
						sum = Math.max(sum, land[i - 1][k]);
				}
				land[i][j] += sum;
			}
		}

		Arrays.sort(land[land.length - 1]);
		return land[land.length - 1][land[0].length - 1];
	}
	
	// 풀이4
	public static int solution4(int[][] land) {
		int[][] temp = new int[10001][4];
		int rowOfLand = land.length;
		int answer = 0;

		for (int i = 0; i < 4; i++) {
			temp[0][i] = land[0][i];
		}
		for (int i = 1; i < rowOfLand; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (j != k) {
						temp[i][j] = Math.max(temp[i][j], temp[i - 1][k] + land[i][j]);
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, temp[rowOfLand - 1][i]);
		}
		return answer;
	}
}
