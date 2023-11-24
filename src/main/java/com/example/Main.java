package com.example;

import com.example.dao.note.NoteService;
import com.example.entities.Note;

public class Main {
    public static void main(String[] args) {
        NoteService noteService = new NoteService();

        Note note1 = new Note(null, "First", "This is first note.");
        Note note2 = new Note(null, "Second", "Second note.");
        Note note3 = new Note(null, "Third", "Last one for now.");

        Note note1PlusId = noteService.add(note1);
        Note note2PlusId = noteService.add(note2);
        Note note3PlusId = noteService.add(note3);
        System.out.println("-->>Some notes added<<--");

        System.out.println("\n-->>List all notes<<--");
        noteService.listAll().forEach(System.out::println);

        System.out.println("\n-->>Getting note by ID<<--");
        System.out.println("noteService.getById(id2) = " + noteService.getById(note2PlusId.getId()));

        System.out.println("\n-->>Updating note<<-- ");
        note3PlusId.setTitle("LastInTheRow");
        note3PlusId.setContent("New content");
        noteService.update(note3PlusId);
        System.out.println("noteService.getById(id3) = " + noteService.getById(note3PlusId.getId()));

        System.out.println("\n-->>Deleting note<<--");
        System.out.println("noteService.deleteById(id1)");
        noteService.deleteById(note1PlusId.getId());

        System.out.println("\n-->>List all notes<<--");
        noteService.listAll().forEach(System.out::println);

    }
}
