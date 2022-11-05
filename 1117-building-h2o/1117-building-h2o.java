class H2O {

    public H2O() {
        
    }
    
    private int hydrogen = 0 , oxygen = 0;

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        
        while(hydrogen == 2 && oxygen == 0) wait();
        releaseHydrogen.run();
        
        hydrogen++;
        if(hydrogen == 2 && oxygen == 1){
            hydrogen = oxygen = 0;
        }
        this.notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        while(hydrogen < 2 && oxygen == 1) wait();
		releaseOxygen.run();
        
        oxygen++;
        if(hydrogen == 2 && oxygen == 1){
            hydrogen = oxygen = 0;
        }
        this.notifyAll();
    }
}