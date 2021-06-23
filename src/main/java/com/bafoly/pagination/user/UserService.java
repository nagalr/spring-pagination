package com.bafoly.pagination.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(page);
    }
}
