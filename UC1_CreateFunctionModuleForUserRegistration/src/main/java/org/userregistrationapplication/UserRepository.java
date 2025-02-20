package org.userregistrationapplication;

import org.springframework.data.jpa.repository.JpaRepository;

// User Repository
interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}