package com.example.demo.store;

import com.example.demo.domain.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, String> {
}
