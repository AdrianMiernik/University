package pl.miernik.university.students;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.miernik.university.teachers.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findAllStudentsPerTeacher(String text) {
        List<Student> outcomeList = new ArrayList<>();
        List<Student> listOfStudents = studentRepository.findAll();
        for (Student student : listOfStudents) {
            for (Teacher teacher : student.getTeachers()) {
                if (teacher.getFirstName().toLowerCase().contains(text.toLowerCase()) || teacher.getLastName().toLowerCase().contains(text.toLowerCase())) {
                    outcomeList.add(student);
                }
            }
        }
        return outcomeList;
    }
}
