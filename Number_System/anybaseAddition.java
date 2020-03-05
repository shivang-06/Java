import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
int carry = 0;
int result =0;
int mul = 1;
while(n1 !=0 || n2 !=0 || carry !=0){
    int d1 = n1%10;
    int d2 = n2%10;
    int D = d1+d2+carry;
    // OPTIMIZED LINE : No need of if-else. 
    carry = D/b;
    D = D%b;
    
    
    result += (D*mul);
    n1 /=10;
    n2 /=10;
    mul *= 10;
    
}
return result;
}

}