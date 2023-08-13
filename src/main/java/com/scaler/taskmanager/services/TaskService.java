package com.scaler.taskmanager.services;

import com.scaler.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>() ;
    private  int taskID=1 ;
    private final SimpleDateFormat deadLineFormatter = new SimpleDateFormat("yyyy-MM-DD");

    public TaskEntity addTask(String title , String description , String deadline) throws ParseException {
        TaskEntity task = new TaskEntity() ;
        task.setId(taskID);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadLineFormatter.parse(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskID++;
        return task ;
    }
   public ArrayList<TaskEntity> getTasks() {
        return  tasks ;
    }
    public TaskEntity getTasksById(int id) {
        for ( TaskEntity task : tasks){
            if (task.getId()==id){
                return task ;
            }
        }
        return  null ;
    }
    public TaskEntity updateTask(int id ,  String description , String deadLine , Boolean completed) throws ParseException{
        TaskEntity task = getTasksById(id) ;
        if (task==null){
            return null ;
        }
        if (description!=null){
            task.setDescription(description);
        }
        if (deadLine!=null){
            task.setDeadline(deadLineFormatter.parse(deadLine));
        }
        if (completed!=null){
            task.setCompleted(completed);
        }
        return task ;
    }
}

