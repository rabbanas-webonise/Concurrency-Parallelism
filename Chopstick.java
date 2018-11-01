class Chopstick { 
 
    boolean taken=false;
    final static int THREAD_SLEEP = 100;
 
    synchronized void put() {   
      taken=false; 
    } 
 
    synchronized void get() throws InterruptedException {   
      
        while (taken) {
            Thread.currentThread().sleep(THREAD_SLEEP); 
            taken=true;  
        }

    }   
} 