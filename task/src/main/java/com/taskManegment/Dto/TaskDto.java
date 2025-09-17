package com.taskManegment.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String userEmail;
    private String title;
    private String description;
    private boolean completed;
}
