package adt.hashtable;



public class Util {
	
	/**
	 * It says if a specific number is prime or not.
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n){
		boolean result = true;
		for (int i = 2; i < n/2 && result; i++) {
			result = result && (n % i != 0);
		}
		return result;
	}
	
	/**
	 * Creates a generic array of the specified size. <p>
	 * Ex.: {@code Util.<Integer>makeArray(10);}
	 *
	 * @param size  The desired size
	 * @return An array of the type and size chosen
	 */
	public static <T> T[] makeArray(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size];
		return array;
	}
}
