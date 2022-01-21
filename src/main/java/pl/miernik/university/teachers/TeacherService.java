package pl.miernik.university.teachers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.miernik.university.students.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService implements ITeacherService{
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> teacherList() {
        return teacherRepository.findAll();
    }

    @Override
    public Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<Teacher> findAllTeachersPerStudent(String input) {
        List<Teacher> outcomeList = new ArrayList<>();
        List<Teacher> teacherList = teacherRepository.findAll();
        for (Teacher teacher : teacherList) {
            for (Student student : teacher.getStudents()) {
                if (student.getFirstName().toLowerCase().contains(input.toLowerCase()) || student.getLastName().toLowerCase().contains(input.toLowerCase())) {
                    outcomeList.add(teacher);
                }
            }
        }
        return outcomeList;
    }
}
