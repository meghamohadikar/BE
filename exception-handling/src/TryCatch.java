public class TryCatch {
	public static void main(String[] args) throws Exception {
		try {
			throw new Exception();
		}catch(Exception ex) {
			throw new ArithmeticException();
		}
		finally {
			System.out.println("finally");
			//throw new ArithmeticException();
		}
	}

}