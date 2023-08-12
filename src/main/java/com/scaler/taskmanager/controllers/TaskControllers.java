package com.scaler.taskmanager.controllers;

import com.scaler.taskmanager.dto.CreateTaskDTO;
import com.scaler.taskmanager.entities.TaskEntity;
import com.scaler.taskmanager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskControllers {
    private final TaskService taskService ;

    public TaskControllers(TaskService taskService) {
        this.taskService = taskService ;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks() ;

        return ResponseEntity.ok(tasks) ;
    }
    @GetMapping("/{id}")
    public  ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id) {
        var task = taskService.getTasksById(id) ;
        if (task==null){
            return  ResponseEntity.notFound().build() ;
        }
        return  ResponseEntity.ok(task) ;
    }
    @PostMapping("")
    public  ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body){
        var task = taskService.addTask(body.getTitle(),body.getDescription(),body.getDeadline());

        return ResponseEntity.ok(task) ;
    }
}
