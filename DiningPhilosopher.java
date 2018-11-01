public class DiningPhilosopher { 
  
   public static void main(String[] args) { 
   
      int numberOfPhilosophers = 5; 
   
      Philosopher phil[] = new Philosopher[numberOfPhilosophers]; 
      Chopstick stick[] = new Chopstick[numberOfPhilosophers]; 
       
      for (int count =0; count<numberOfPhilosophers; count++) {
         stick[count] = new Chopstick(); 
      }
   
      for (int count =0; count<numberOfPhilosophers; count++){ 
 
          phil[count] = new Philosopher(count, stick[count], stick[(count+1)%numberOfPhilosophers]);

          phil[count].start(); 
    
      } 
    } 
}