package org.perscholas.security;

import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class AppUserPrincipal implements UserDetails {

    //fields
    private Student student;
    private List<AuthGroup> authGroups;

    public AppUserPrincipal(Student student, List<AuthGroup> authGroups) {
        this.student = student;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == authGroups){
            return Collections.emptySet();
        }

        //init
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        authGroups.forEach(authGroup -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
        });

        return grantedAuthorities;
    }


    @Override
    public String getPassword() {
        return this.student.getSPassword();
    }

    @Override
    public String getUsername() {
        return this.student.getSUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
