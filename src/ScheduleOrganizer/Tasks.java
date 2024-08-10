
package ScheduleOrganizer;

import java.util.ArrayList;
import java.util.Scanner;


public class Tasks {
    
    private ArrayList<Task> tasks;
    
    public Tasks(){
        this.tasks = new ArrayList<>();
    }
    
    public boolean addTask(Task newTask){
        if(isPresent(newTask.getDescription())){
            return false;
        }
        this.tasks.add(newTask);
        return true;
    }
    
    public boolean isPresent(String description){
        for(Task obj : tasks){
            if(obj.getDescription().equals(description)){
                return true;
            }
        }
        return false;
    }
    
    public boolean editTask(String description){
        for(Task obj : tasks){
            if(obj.getDescription().equals(description)){
                Scanner in = new Scanner(System.in);
                System.out.print("""
                                 Enter 1 for Editing Description
                                 2 for editing start time
                                 3 for editing end time
                                 4 for editing priority level
                                  Enter your choice : """);
                int choice = in.nextInt();
                switch(choice){
                    case 1 ->  {
                        System.out.print("Enter new Description : ");
                        String newDescription = in.nextLine();
                        obj.setDescription(newDescription);
                    }
                    case 2 -> {
                        System.out.print("Enter new Start Time : ");
                        String newTime = in.nextLine();
                        obj.setStartTime(newTime);
                    }
                    case 3 -> {
                        System.out.print("Enter new End Time : ");
                        String newTime = in.nextLine();
                        obj.setEndTime(newTime);
                    }
                    case 4 -> {
                        System.out.print("Enter new Priority level : ");
                        String newPriorityLevel = in.nextLine();
                        obj.setPriority(newPriorityLevel);
                    }
                    default -> {
                        System.out.println("Invalid Option...");
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean removeTask(String description){
        
        for(Task obj : tasks){
            if(obj.getDescription().equals(description)){
                this.tasks.remove(obj);
                return true;
            }
        }
        
        return false;
    }
    
    public int changeStatus(String description){
        
        for(Task obj : tasks){
            if(obj.getDescription().equals(description)){
                boolean status = obj.getStatus();
                obj.setStatus(!status);
                return !status == true ? 0 : 1; // 0 -> marked as not complete
            }
        }
        return -1;
        
    }
    
    public void display(){
        for(Task obj : tasks){
            System.out.println(obj);
        }
    }
    
    public void viewTasks(String priority){
        for(Task obj : tasks){
            if(obj.getPriority().equals(priority)){
                System.out.println(obj);
            }
        }
    }
}
