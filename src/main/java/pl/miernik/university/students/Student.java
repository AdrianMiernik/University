package pl.miernik.university.students;

import lombok.*;
import pl.miernik.university.teachers.Teacher;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Builder(toBuilder = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "This field cannot be blank.")
    @Size(min = 3, message = "First name is too short.")
    private String firstName;

    private String lastName;

    @NotNull(message = "This field cannot be null.")
    @Min(value = 18, message = "Age must be greater than or equal to {value}.")
    private int age;

    @NotBlank(message = "This field cannot be blank.")
    @Email(message = "This is not email format.")
    private String email;

    private String field;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();
}