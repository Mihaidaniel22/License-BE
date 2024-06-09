package com.endava.expensesmanager.repository;
import com.endava.expensesmanager.model.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {
    UserRegistration findByName(String name);
}
