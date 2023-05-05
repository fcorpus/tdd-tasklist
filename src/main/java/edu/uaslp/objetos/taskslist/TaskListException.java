package edu.uaslp.objetos.taskslist;

public class TaskListException extends RuntimeException{
    TaskListException(){
        super("Due date is set in the past");
    }
    /*public String getMessage(){
        String mensb="Due date is set in the past";
        return mensb;
    }*/
}
