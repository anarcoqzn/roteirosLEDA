import java.time.LocalDateTime;

public class Teste {

	public static void main(String[] args) {
		LocalDateTime data = LocalDateTime.now();
		System.out.println("ab");
		LocalDateTime data1 = LocalDateTime.now();
		
		System.out.println(-data.compareTo(data1));
		
	}
	
}
