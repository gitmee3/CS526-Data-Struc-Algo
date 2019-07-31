package HW4;

/**
 *
 * @author Eddy
 */
public class Process {
    
    //Object Variables
    public int id;

    public int priority;

    public int arrivalTime;

    public int duration;

    public int waitTime;

    public Process(int id, int priority, int duration, int arrivalTime) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.waitTime = 0;
    }
    
    //Getter() and Setter() Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
