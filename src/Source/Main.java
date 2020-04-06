package Source;

public class Main {

	public static void main(String[] args) {
		
		int[] array = new int[] {1,2,3,4,5,6,7,8};
		boolean ok = false;
		SplitProblem p = new SplitProblem();
		
		ok = p.splitArray(array);
		
		System.out.println(ok);

	}

}
