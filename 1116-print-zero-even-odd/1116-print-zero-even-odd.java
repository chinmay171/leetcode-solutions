class ZeroEvenOdd {
    private int n;
    private int counter = 1;
    private boolean zeroLock = false;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        
        while(counter <= n){
            if(zeroLock == true){
                this.wait();
                continue;
            }
            printNumber.accept(0);
            zeroLock = true;
            this.notifyAll();
        }
        
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(counter <= n){
            if(zeroLock == false || counter % 2 == 1){
                this.wait();
                continue;
            }
            printNumber.accept(counter);
            counter++;
            zeroLock = false;
            this.notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(counter <= n){
            if(zeroLock == false || counter % 2 == 0){
                this.wait();
                continue;
            }
            printNumber.accept(counter);
            counter++;
            zeroLock = false;
            this.notifyAll();
        }
    }
}