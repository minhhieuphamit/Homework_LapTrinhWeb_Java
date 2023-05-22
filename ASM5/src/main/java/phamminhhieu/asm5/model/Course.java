package phamminhhieu.asm5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Lecture name must not be null")
    @Size(max = 100, message = "Lecture name must not be greater than 100 characters")
    @Column(name = "LectureName")
    private String lectureName;

    @NotBlank(message = "Course name must not be null")
    @Column(name = "Place")
    private String place;

    @NotNull(message = "Start date must not be null")
    @FutureOrPresent(message = "Start date must be present or future")
    @Column(name = "StartDate")
    private LocalDate startDate;
}
