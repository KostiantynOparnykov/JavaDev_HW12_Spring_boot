package com.example.JavaDev_HW12_Spring_boot.note;

import com.example.JavaDev_HW12_Spring_boot.entities.Note;

import java.util.List;

public interface NoteDao {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}
