package pl.miernik.university.teachers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miernik.university.students.Student;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping("/page/{pageNo}")
    public String displayAllTeachersPaginated(@PathVariable(value = "pageNo") int pageNo,
                                              @RequestParam("sortField") String sortField,
                                              @RequestParam("sortDir") String sortDir,
                                              ModelMap model) {
        int pageSize = 4;
        Page<Teacher> page = teacherService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Teacher> list = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("teachers", list);

        return "/teachers/list";
    }

    @GetMapping("/list")
    public String displayMain(ModelMap model) {
        return displayAllTeachersPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/add")
    public String addTeacher(ModelMap model) {
        model.addAttribute("teacher", new Teacher());
        return "/teachers/add";
    }
    @PostMapping("/add")
    public String addTeacherPost(
            ModelMap model,
            @ModelAttribute("teacher")
            @Valid Teacher teacher,
            BindingResult violation) {
        if(violation.hasErrors()){
            return "/teachers/add";
        }
        teacherService.saveTeacher(teacher);
        model.addAttribute("teachers", teachers());
        return "/teachers/list";
    }

    @GetMapping("/update/{id}")
    public String updateTeacher(@PathVariable Integer id, ModelMap model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "/teachers/update";
    }
    @PostMapping("/update")
    public String updateTeacherPost(
            ModelMap model,
            @Valid Teacher teacher,
            BindingResult violation) {
        if(violation.hasErrors()){
            return "/teachers/update";
        }
        teacherService.saveTeacher(teacher);
        model.addAttribute("teachers", teachers());
        return "/teachers/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return "redirect:/teachers/list";
    }

    @PostMapping("/search")
    public String searchStudentsPerTeacher(@Param("input") String input, ModelMap model){
        List<Teacher> specifiedList = teacherService.findAllTeachersPerStudent(input);
        model.addAttribute("specifiedList", specifiedList);
        return "/teachers/filter";
    }

    @ModelAttribute("teachers")
    private List<Teacher> teachers(){
        return teacherService.teacherList();
    }
}
