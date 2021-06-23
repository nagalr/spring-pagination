package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/1.0/users")
    Page<User> getUsers(@RequestParam int pageNumber,
                        @RequestParam int pageSize) {
        return userService.getUsers(pageNumber, pageSize);
    }

}
