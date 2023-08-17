package com.scaler.taskmanager.controllers;

import com.scaler.taskmanager.dto.CreateNoteDTO;
import com.scaler.taskmanager.dto.CreateNoteResponseDTO;
import com.scaler.taskmanager.entities.NoteEntity;
import com.scaler.taskmanager.services.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    private NotesService notesService ;
    public NotesController (NotesService notesService){
        this.notesService = notesService ;
    }
    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes (@PathVariable("taskId") Integer taskId){
        var notes = notesService.getNotesFortask(taskId) ;
        return ResponseEntity.ok(notes) ;
    }
    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote (
            @PathVariable("taskId") Integer taskId ,
            @RequestBody CreateNoteDTO body
            ){
        var note = notesService.addNotefortask(taskId , body.getTitle() , body.getBody()) ;
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId,note)) ;
    }

}
