package com.example.JavaDev_HW12_Spring_boot.entities;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note {
    private Long id;
    private String title;
    private String content;
}
