package com.dissertation.project.jdbc.tokenDBMapping;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Tokens, String> {
}
