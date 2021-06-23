package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/1.0/users")
    Page<User> getUsers(Pageable page) {
        log.debug("Received Get in Controller, page object: " + page.toString());
        return userService.getUsers(page);
    }

}
