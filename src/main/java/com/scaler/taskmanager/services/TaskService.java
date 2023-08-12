package com.scaler.taskmanager.services;

import com.scaler.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>() ;
    private  int taskID=1 ;

    public TaskEntity addTask(String title , String description , String deadline){
        TaskEntity task = new TaskEntity() ;
        task.setId(taskID);
        task.setTitle(title);
        task.setDescription(description);
    //    task.setDeadline(new Date(deadline));
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
}

