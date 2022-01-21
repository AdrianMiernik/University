package pl.miernik.university.teachers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService implements ITeacherService{
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(Teacher teacher) {

    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return null;
    }

    @Override
    public void deleteTeacher(Integer id) {

    }

    @Override
    public List<Teacher> teacherList() {
        return null;
    }

    @Override
    public Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }
}
