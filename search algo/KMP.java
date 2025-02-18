import java.util.*;

    class KMP_String_Matching {
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;

        computeLPSArray(pat, M, lps);
 
        int i = 0; 
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
 
    void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0; 
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else 
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else 
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
 
    
    public static void main(String[] args) {
 
      Scanner sc= new Scanner(System.in);
        String txt = sc.nextLine();
        String tp = txt;
        String pat = "i got it";
        int count =0 ;
        /* for(int i = 1; i <= 999 ; i++) {    
                txt  += tp;
        }   */
        for( int i =0 ;i <txt.length();i++){
           count++;
        } 
     
          // Function call
       long start = System.nanoTime();  
       new KMP_String_Matching().KMPSearch(pat, txt);
       long end = System.nanoTime();

System.out.print("Execution time is " + (end - start) + " nanoseconds for pattern length " +count);
    }
    
}