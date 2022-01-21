package pl.miernik.university.students;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    //CRUD
    void saveStudent(Student student);
    Student getStudentById(Integer id);
    void deleteStudent(Integer id);

    List<Student> studentList();
    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
