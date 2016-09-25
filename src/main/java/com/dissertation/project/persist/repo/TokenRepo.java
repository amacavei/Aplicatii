package com.dissertation.project.persist.repo;

import com.dissertation.project.persist.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo  extends JpaRepository<Token, String> {
}
