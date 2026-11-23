class ProductOfNumbers {
  ArrayList<Integer>ar=new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    int prod=1;
    int size=0;
    int sum=1;
    
    public void add(int num) {
        if(num==0){
            size=0;
            prod=1;
            sum=1;
            ar.add(sum);
           
        }else{
            sum*=num;
            prod*=num;
            ar.add(sum);
            size++;
        }
        
    }
    
    public int getProduct(int k) {
        if(size <k){
            return 0;
        }
        if(size==k){
            return prod;
        }
        int newsize=ar.size()-k;
        return prod / ar.get(newsize-1);
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */