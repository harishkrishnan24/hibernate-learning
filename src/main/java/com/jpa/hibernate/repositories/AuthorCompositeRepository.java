package com.jpa.hibernate.repositories;

import com.jpa.hibernate.domain.composite.AuthorComposite;
import com.jpa.hibernate.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
