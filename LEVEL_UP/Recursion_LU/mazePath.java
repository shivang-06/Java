public class mazePath{

    public static void main(String[] args) {
        System.out.println(solve(0,0,5,5,""));
    }
    public static int solve(int sr, int sc, int dr, int dc, String psf) {
        if(sr>dr || sc > dc){
            return 0;
        }
        if(sr==dr && sc == dc){
            System.out.println(psf);
            return 1;
        }
        return solve(sr+1,sc,dr,dc,psf+"v")+solve(sr,sc+1,dr,dc,psf+"h")+solve(sr+1,sc+1,dr,dc,psf+"d");
        
        
    }

}