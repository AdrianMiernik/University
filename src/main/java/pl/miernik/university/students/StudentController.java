package pl.miernik.university.students;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @GetMapping("/page/{pageNo}")
    public String displayAllStudentsPaginated(@PathVariable(value = "pageNo") int pageNo,
                                              @RequestParam("sortField") String sortField,
                                              @RequestParam("sortDir") String sortDir,
                                              ModelMap model) {
        int pageSize = 5;
        Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Student> list = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("students", list);

        return "/students/list";
    }

    @GetMapping("/list")
    public String displayMain(ModelMap model) {
        return displayAllStudentsPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/add")
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        return "/students/add";
    }

    @PostMapping("/add")
    public String addStudentPost(
            ModelMap model,
            @ModelAttribute("student")
            @Valid Student student,
            BindingResult violation) {
        if (violation.hasErrors()) {
            return "/students/add";
        }
        studentService.saveStudent(student);
        model.addAttribute("students", students());
        return "redirect:/students/list";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/students/update";
    }

    @PostMapping("/update")
    public String updateStudentPost(
            ModelMap model,
            @Valid Student student,
            BindingResult violation) {
        if (violation.hasErrors()) {
            return "/students/update";
        }
            studentService.saveStudent(student);
            model.addAttribute("students", students());
            return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    @PostMapping("/search")
    public String searchStudentsPerTeacher(@Param("input") String input, ModelMap model){
        List<Student> specifiedList = studentService.findAllStudentsPerTeacher(input);
        model.addAttribute("specifiedList", specifiedList);
        return "/students/filter";
    }

    @ModelAttribute("students")
    private List<Student> students() {
        return studentService.studentList();
    }
}
