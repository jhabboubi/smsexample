package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.dao.IAuthGroup;
import org.perscholas.dao.ICourseRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Log
@Component
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    IStudentRepo studentRepo;
    ICourseRepo courseRepo;
    IAuthGroup authGroup;
    @Autowired
    public AppStartupRunner(IStudentRepo studentRepo, ICourseRepo courseRepo, IAuthGroup authGroup) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.authGroup = authGroup;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("*** start student sql ***");

        studentRepo.save(new Student("habboubi","habboubi@gmail.com","password"));
        studentRepo.save(new Student("admin","admin@gmail.com","password"));
        studentRepo.save(new Student("student_one","student_one@gmail.com","password"));

        log.info("*** end student sql ***");


        log.info("*** start course sql ***");

        courseRepo.save(new Course("Java", 3));
        courseRepo.save(new Course("Spring Framework", 3));
        courseRepo.save(new Course("HTML/CSS", 3));

        log.info("*** end course sql ***");

        log.info("*** start auth group sql ***");

        authGroup.save(new AuthGroup("habboubi","ROLE_ADMIN"));
        authGroup.save(new AuthGroup("habboubi","ROLE_USER"));
        authGroup.save(new AuthGroup("habboubi","WRITE"));

        authGroup.save(new AuthGroup("admin","ROLE_ADMIN"));
        authGroup.save(new AuthGroup("admin","ROLE_USER"));

        authGroup.save(new AuthGroup("student_one","ROLE_USER"));


        log.info("*** end auth group sql ***");


    }

    @PostConstruct
    public void letMeKnow(){
        log.warning("Constructed!");
    }
}
