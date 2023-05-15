package phamminhhieu.asm3.model;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
public class Course {
    private int id;
    private String lectureName;
    private String place;
    private LocalDate startDate;
}
