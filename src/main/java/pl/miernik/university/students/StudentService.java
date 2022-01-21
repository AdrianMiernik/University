package pl.miernik.university.students;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public Student getStudentById(Integer id) {
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {

    }

    @Override
    public List<Student> studentList() {
        return null;
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }
}
