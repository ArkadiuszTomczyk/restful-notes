package com.restful.notes.restfulnotes.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String encode = bCryptPasswordEncoder.encode("1234");
        System.out.println(encode);
    }
}
