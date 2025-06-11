package com.magz014.notasapi.repository;

import com.magz014.notasapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserModel, Long>{
}
