package programmers.lv2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mobilnumber = "010-2320-0360";
		if (!mobilnumber.equals("")) {
			String[] mbtArr= mobilnumber.split("-");
			System.out.println(mbtArr[0]);
			System.out.println(mbtArr[1]);
			System.out.println(mbtArr[2] + mbtArr.length);
		}
	}

}
