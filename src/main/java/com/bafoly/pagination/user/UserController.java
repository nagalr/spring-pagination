package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
// needed for the Service @Autowire, the Required-Args-Ctor will include all 'final' properties.
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    /*
     Controller Receives a 'Pageable' Object.
     This Object will assign values for: pageSize, pageNumber, sort, if not passed by the user.
     The Object will validate the values if passed as RequestParams, and assign defaults if needed.
     There are default values for the variables, can be overwritten in application.properties
     using the 'spring.data.web..' definitions.
     Hence, its better to use it like that, instead of controller-method accepting:
     @RequestParam(required = false, defaultValue = 1) pageSize,
     @RequestParam(required = false, defaultValue = 0) pageNumber
     Passing them on to the Service, which will have its own logic to validate/assign-defaults.
     It's Cleaner like that.
     */
    @GetMapping("/api/1.0/users")
    Page<User> getUsers(Pageable page) {
        log.debug("Received Get in Controller, page object: " + page.toString());
        return userService.getUsers(page);
    }

}
