package com.restful.notes.restfulnotes.security;

import com.restful.notes.restfulnotes.dao.NoteUserRepository;
import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class NoteUserDetailsService implements UserDetailsService {

    private NoteUserRepository noteUserRepository;

    public NoteUserDetailsService(NoteUserRepository noteUserRepository) {
        this.noteUserRepository = noteUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NoteUser user = noteUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                emptyList());
    }
}
