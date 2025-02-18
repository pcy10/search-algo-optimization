public class Main {
	public final static int d = 256;
	static void search(String pat, String txt, int q)
	{
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; 
		int t = 0; 
		int h = 1;

		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

	
		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

	
		for (i = 0; i <= N - M; i++) {
			if (p == t) {
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}
				if (j == M)
					System.out.println("Pattern found at index " + i);
			}
			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h)+ txt.charAt(i + M))% q;
				if (t < 0)
					t = (t + q);
			}
		}
	}

	public static void main(String[] args)
	{
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEKlong end = System.nanoTime();

		int q = 101;
		long start = System.nanoTime();  
		search(pat, txt, q);
		long end = System.nanoTime();

        System.out.print("Execution time is " + (end - start) + " milliseconds for pattern length " +count);
		
	}
}

