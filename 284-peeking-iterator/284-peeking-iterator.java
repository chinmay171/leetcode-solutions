// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    int data;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
        next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return data;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int temp = data;
        
        if(itr.hasNext() == true){
            data = itr.next();
        }else{
            data = -1;
        }
        
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return (data != -1);
	}
}