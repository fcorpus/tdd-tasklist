package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.Date;
import java.lang.Throwable;
class Task {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;//shift + f6//Boolean es una clase, primitivos y el grapper class Boolean

    Task(){

    }
    Task(String title,String description,LocalDateTime duedate,boolean done){// Task("Lavar los trastes", "Lavar los trastes sin tirar mucha agua", LocalDateTime.now().plusWeeks(20), false);
        this.description=description;
        this.title=title;
        this.dueDate=duedate;
        this.done =done;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) throws TaskListException{
        LocalDateTime now=LocalDateTime.now();//fecha actual
        if(dueDate.isBefore(now)){
            throw new TaskListException();
        }
        this.dueDate = dueDate;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;

    }

}
