
package ScheduleOrganizer;

import java.util.Scanner;

public class DailyScheduleOrganizer {
    
    public static void main(String [] args){
        Tasks tasks = new Tasks();
        
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("""
                               Enter 1 to Add Task
                               Enter 2 to Remove Existing task
                               Enter 3 to Edit existing tasks
                               Enter 4 to view all tasks
                               Enter 5 to view based on priority
                               Enter 6 to change task status
                               Enter 7 to exit
                               Enter your choice : """);
            int choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1 -> {
                    System.out.print("Enter task description : ");
                    String desc = in.nextLine();
                    System.out.print("Enter Start Time : ");
                    String stTime = in.nextLine();
                    System.out.print("Enter End Time : ");
                    String endTime = in.nextLine();
                    System.out.print("Enter Priority Level : ");
                    String priority = in.nextLine();
                    Task newTask = new Task(desc, stTime, endTime, priority);
                    boolean status = tasks.addTask(newTask);
                    if(status){
                        System.out.println("Task Added Successfully...");
                    } else {
                        System.out.println("Task Already Exist...");
                    }
                }
                case 2 -> {
                    System.out.print("Enter task description : ");
                    String desc = in.nextLine();
                    boolean status = tasks.removeTask(desc);
                    if(status){
                        System.out.println("Task removed Successfully...");
                    } else {
                        System.out.println("Task doesn't Exist...");
                    }
                }
                case 3 -> {
                    System.out.print("Enter task description : ");
                    String desc = in.nextLine();
                    boolean status = tasks.editTask(desc);
                    if(status){
                        System.out.println("Task Edited Successfully...");
                    } else {
                        System.out.println("Task doesn't Exist...");
                    }
                }
                case 4 -> {
                    tasks.display();
                }
                case 5 -> {
                    System.out.print("Enter Priority : ");
                    String priority = in.next();
                    tasks.viewTasks(priority);
                }
                case 6 -> {
                    System.out.print("Enter task description : ");
                    String desc = in.nextLine();
                    int status = tasks.changeStatus(desc);
                    switch (status) {
                        case 1 ->
                            System.out.println("Task marked as Completed");
                        case 0 ->
                            System.out.println("Task marked as not completed");
                        default ->
                            System.out.println("Task doesn't exist");
                    }
                }
                case 7 -> {
                    System.out.println("Program Exited");
                    return;
                }
                default -> {
                    System.out.print("Invalid Option...");
                }
            }
        }
    }
}
