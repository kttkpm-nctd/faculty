package iuh.nctd.faculty.service;

import iuh.nctd.faculty.entity.Faculty;
import iuh.nctd.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty getFacultyById(int id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
