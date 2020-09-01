public class Dstack extends stack{
    Dstack(){
        super();
    }
    Dstack(int n){
        super(n);
    }
    Dstack(int[] arr){
        super(arr.length*2);
        for(int ele:arr){
            super.push_(ele);
        }
    }
    public boolean isEmpty(){
        return super.isEmpty();
    }

    
    @Override    
    public push(int val ){
        if(super.size == super.capacity()){
            int[] temp = new int[super.size()];
            int i = super.size() -1 ;
            while(super.size() != 0) temp[i--] = super.pop_();
            super.setValues(temp.length * 2);
            for(int ele : temp){
                super.push_(ele);
            }
            super.push_(val);
        }    
    }
    public int pop(){
        super.pop();
    }
}