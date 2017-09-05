package io.pivotal.workshop.repository;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.workshop.domain.Directory;

public interface DirectoryRepository extends CrudRepository<Directory, Long>{

}
