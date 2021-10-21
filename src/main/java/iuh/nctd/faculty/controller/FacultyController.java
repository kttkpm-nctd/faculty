package iuh.nctd.faculty.controller;

import iuh.nctd.faculty.entity.Faculty;
import iuh.nctd.faculty.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable int id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping("/")
    public Faculty saveFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }
}
