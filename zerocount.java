import java.util.*;

public class zerocount {
   
    public static int count(String s, char c){
        int res = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == c)
            res++;
        }
        return res;
    }
   
 public static int maxConsecutiveZerosCount(String st) {
        int zcount = 0;
        ArrayList<Integer> zeroCounts = new ArrayList<Integer>();

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '0') {
                zcount++;
            } else if (st.charAt(i) == '1') {
                if (zcount > 0) {
                    zeroCounts.add(zcount);
                }
                zcount = 0;
            }
        }
        if (zcount > 0) {
            zeroCounts.add(zcount);
        }
        int maxZerosCount = 0;
        for (int count : zeroCounts) {
            if (count > maxZerosCount) {
                maxZerosCount = count;
            }
        }
        return maxZerosCount;
    }
   
    public static int countMinValue(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];
        int minCount = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minCount = 1;
            } else if (array[i] == min) {
                minCount++;
            }
        }
        return minCount;
    }
   
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int z = n-k;
        if(n==k){
        System.out.println("0");
        System. exit(0);}
        int s = (int) Math.pow(2, n);
        String[] arr = new String[s];
        String temp = "";
        for (int i = 0; i < s; i++) {
            temp = Integer.toBinaryString(i);
            arr[i] = String.format("%"+n+"s", temp).replace(' ', '0');
        }
        ArrayList<String> finarr= new ArrayList<String>();
        for(String str: arr){
            if(count(str, '1') == k){
                finarr.add(str);
            }
        }
        int y = finarr.size();
        int f[] = new int[y];
        int a, res = 0;
        int i = 0;
        for(String st : finarr){
            f[i++] = maxConsecutiveZerosCount(st);
        }
        int result = countMinValue(f);
        System.out.println(result);
       
       
    }
}
