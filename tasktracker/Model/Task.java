package com.example.tasktracker.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;


}
