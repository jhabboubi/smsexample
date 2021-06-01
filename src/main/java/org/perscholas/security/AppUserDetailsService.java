package org.perscholas.security;

import org.perscholas.dao.IAuthGroup;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final IStudentRepo studentRepo;
    private final IAuthGroup authGroup;
    @Autowired
    public AppUserDetailsService(IStudentRepo studentRepo, IAuthGroup authGroup) {
        this.studentRepo = studentRepo;
        this.authGroup = authGroup;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Student> student = studentRepo.findBysUsername(s);

        if(student.isEmpty()){
            throw new UsernameNotFoundException("Cannot find Username: " + s);
        }

        List<AuthGroup> authGroups = authGroup.findByaUsername(s);
        return new AppUserPrincipal(student.get(),authGroups);
    }
}
