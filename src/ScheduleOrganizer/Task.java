
package ScheduleOrganizer;

import java.time.LocalTime;

public class Task {
    
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priorityLevel;
    private boolean completed;
    
    public Task(String description, String startTime, String endTime,
            String priorityLevel){
        this.description = description;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.priorityLevel = priorityLevel;
        this.completed = false;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public boolean getStatus(){
        return this.completed;
    }
    
    public String getPriority(){
        return this.priorityLevel;
    }
    
    @Override
    public String toString(){
        return "\nTask : " + this.description + "\nStart Time : " + 
                this.startTime + "\nEnd Time : " + this.endTime + 
                "\nPriority Level : " + this.priorityLevel + "\nStatus : " + 
                (this.completed ? "Completed" : "Not Completed");
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setPriority(String priority){
        this.priorityLevel = priority;
    }
    
    public void setStartTime(String startTime){
        this.startTime = LocalTime.parse(startTime);
    }
    
    public void setEndTime(String endTime){
        this.endTime = LocalTime.parse(endTime);
    }
    
    public void setStatus(boolean status){
        this.completed = status;
    }
}
