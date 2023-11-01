public class sample{
	public static void main(String[] args) throws Exception {
		Connect j = new Connect();
		
		int[] arr = j.getResult();
		for(int x:arr) {
			System.out.println(x);
		}
	}
}