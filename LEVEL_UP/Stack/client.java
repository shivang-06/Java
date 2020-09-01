public class client{
    public static void main(String[] args) throws Exception {
        stack st = new stack();
        for(int i =1;i<11;i++){
            st.push(i*10);
        }
        System.out.println(st);
        st.pop();
        System.out.println(st);

    }
}