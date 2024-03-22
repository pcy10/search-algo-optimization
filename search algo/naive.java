public class JavaApplication5 {
    static void search(String pat, String txt)
    {
        int l1 = pat.length();
        int l2 = txt.length();
        int i = 0, j = l2 - 1;
 
        for (i = 0, j = l2 - 1; j < l1;) {
 
            if (txt.equals(pat.substring(i, j + 1))) {
                System.out.println("Pattern found at index "+ i);
            }
            i++;
            j++;
        }
    }
    
    public static void main(String[] args) {
 
     Scanner sc= new Scanner(System.in);
        String pat = sc.nextLine();
        String tp = pat;
        String txt = "i got it";
        int count =0 ;
       /*  for(int i = 1; i <= 9 ; i++) {    
                pat  += tp;
        }  */
        for( int i =0 ;i <pat.length();i++){
           count++;
        }
     
          // Function call
        long start = System.nanoTime();  
        search(pat, txt); 
        long end = System.nanoTime();

System.out.print("Execution time is " + (end - start) + " milliseconds for pattern length " +count);
    }
    
}
