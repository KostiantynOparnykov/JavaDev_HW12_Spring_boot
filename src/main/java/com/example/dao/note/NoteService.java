package com.example.dao.note;

import com.example.entities.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService implements NoteDao{
    private final Map<Long, Note> notes = new LinkedHashMap<>();
    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note note) {
        if(note.getId()==null) {
            note.setId(UUID.randomUUID().getMostSignificantBits());
        }
        notes.put(note.getId(), note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if(notes.get(id) == null){
            throw new IllegalArgumentException("Invalid note id");
        }
        notes.remove(id);
    }

    @Override
    public void update(Note note) {
        Long noteKey = note.getId();
        if(notes.get(noteKey) == null){
            throw new IllegalArgumentException("Invalid note id");
        }
        notes.replace(noteKey, notes.get(noteKey), note);
    }

    @Override
    public Note getById(long id) {
        if(notes.get(id) == null){
            throw new IllegalArgumentException("Invalid note id");
        }
        return notes.get(id);
    }
}
