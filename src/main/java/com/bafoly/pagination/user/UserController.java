package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/1.0/users")
    Page<User> getUsers(@RequestParam int pageNumber,
                        @RequestParam int pageSize) {
        log.debug("Received Get Request, pageNumber:" + pageNumber + " pageSize:" + pageSize);
        return userService.getUsers(pageNumber, pageSize);
    }

}
