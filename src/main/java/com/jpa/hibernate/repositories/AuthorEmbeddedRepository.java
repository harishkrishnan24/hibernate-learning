package com.jpa.hibernate.repositories;

import com.jpa.hibernate.domain.composite.AuthorEmbedded;
import com.jpa.hibernate.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
