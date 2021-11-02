package iuh.nctd.faculty.service;

import iuh.nctd.faculty.entity.Faculty;
import iuh.nctd.faculty.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

//    public Faculty getFacultyById(int id) {
//        log.info("faculty by id: ");
//        return facultyRepository.findById(id).get();
//    }

    @Cacheable("faculty")
    public Faculty getFacultyById(int id) {
        log.info("faculty by id: ");
        return facultyRepository.findById(id).get();
    }

    @CacheEvict(value = "faculty")
    public void clearFaciltyById(int id) {
        log.info("delete cache faculty");
    }

    @CacheEvict(value = "faculty", allEntries = true)
    public void clearAllFacilty() {
        log.info("delete cache All faculty");
    }

    @CachePut(value = "faculty")
    public Faculty updateFacultyCacheById(int id) {
        Faculty faculty = facultyRepository.findById(id).get();
        faculty.setName("new faculty");

        log.info("updated");

        return faculty;
    }


}
