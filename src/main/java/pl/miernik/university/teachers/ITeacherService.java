package pl.miernik.university.teachers;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ITeacherService {
    //CRUD
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(Integer id);
    void deleteTeacher(Integer id);

    List<Teacher> teacherList();
    Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    List<Teacher> findAllTeachersPerStudent(String input);
}
