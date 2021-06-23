package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // Same usage explain as in the Controller class.
    public Page<User> getUsers(Pageable page) {
        log.debug("Request in Service, page object: " + page.toString());
        return userRepository.findAll(page);
    }
}
