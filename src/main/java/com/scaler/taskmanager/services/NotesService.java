package com.scaler.taskmanager.services;

import com.scaler.taskmanager.entities.NoteEntity;
import com.scaler.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {
    private TaskService taskService ;
    private HashMap<Integer , TaskNotesHolder> taskNoteHolder = new HashMap<>() ;
    public  NotesService (TaskService taskService){
        this.taskService= taskService ;
    }
    class TaskNotesHolder{
        protected int noteId;
        protected ArrayList<NoteEntity> notes = new ArrayList<>() ;
    }
    public List<NoteEntity> getNotesFortask(int taskId) {
        TaskEntity task = taskService.getTasksById(taskId) ;
        if(task==null){
            return null ;
        }
        if (taskNoteHolder.get(taskId)==null){
            taskNoteHolder.put(taskId , new TaskNotesHolder()) ;
        }
        return taskNoteHolder.get(taskId).notes ;
    }
    public NoteEntity addNotefortask (int taskId ,String title , String body){
        TaskEntity task = taskService.getTasksById(taskId) ;
        if (task==null){
            return null ;
        }
        if (taskNoteHolder.get(taskId)== null){
            taskNoteHolder.put (taskId , new TaskNotesHolder()) ;
        }
        TaskNotesHolder taskNotesHolder = taskNoteHolder.get(taskId) ;
        NoteEntity note = new NoteEntity() ;
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note) ;
        taskNotesHolder.noteId++;
        return note ;

    }

}
