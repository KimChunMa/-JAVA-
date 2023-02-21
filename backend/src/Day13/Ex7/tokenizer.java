package Day13.Ex7;

import java.util.Arrays;
import java.util.StringTokenizer;

public class tokenizer {
	public static void main(String[] args) {
		String data1 = "홍길동&이수홍-박연수";
		String[] arr = data1.split("&|-");
		System.out.println(Arrays.toString(arr)); //[홍길동, 이수홍, 박연수]
		
		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2,"/");
		System.out.println("조각수 : " + st.countTokens() );
		
		for(int i = 1; i <= 3 ; i++) {
			System.out.println( st.nextToken()  );
		}
	}
}
