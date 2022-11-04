class FooBar {
    private boolean lock = false;
    
    private int n;
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            while(lock == true) this.wait();
        	printFoo.run();
            lock = true;
            this.notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            while(lock == false) this.wait();
        	printBar.run();
            lock = false;
            this.notifyAll();
        }
    }
}