package w10;

public class 아파트칠하기 {

	public static void main(String[] args) {
		System.out.println(yellow(8)+blue(8));
	}

	private static int blue(int i) {
		if(i == 1) {
			return 1;
		}
		return yellow(i-1);
	}

	private static int yellow(int i) {
		if(i == 1) {
			return 1;
		}
		return yellow(i-1)+blue(i-1);
	}
}
