package Udemy.SpringGuru.firstSpringProject.repositories;

import Udemy.SpringGuru.firstSpringProject.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
