import java.util.Stack;
import java.util.Arrays;
public class NextSmallerGreater{
    public static void main(String[] args) {
        solve();
    }
    public void solve(){
        int[] arr = {5,2,6,3,2,1,4,7,6};
        int[] ans = nextGreaterOnRight(arr);
    }
    public int[] nextGreaterOnRight(int[] arr){
        n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,n);
        for(int i=0; i<n; i++){
            while(st.size()!=0 && arr[st.peek()]< arr[i]){
                ans[st.pop()] = i; 
            }
            st.push(i);

        }
    }
    public int[] nextGreaterOnleft(int[] arr){
        n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=n-1; i>=n; i--){
            while(st.size()!=0 && arr[st.peek()]< arr[i]){
                ans[st.pop()] = i; 
            }
            st.push(i);

        }
    }
    public int[] nextSmallerOnRight(int[] arr){
        n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,n);
        for(int i=0; i<n; i++){
            while(st.size()!=0 && arr[st.peek()] > arr[i]){
                ans[st.pop()] = i; 
            }
            st.push(i);

        }
    }
    public int[] nextGreaterOnleft(int[] arr){
        n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=n-1; i>=n; i--){
            while(st.size()!=0 && arr[st.peek()] > arr[i]){
                ans[st.pop()] = i; 
            }
            st.push(i);

        }
    }
}   