package Udemy.SpringGuru.firstSpringProject.repositories;

import Udemy.SpringGuru.firstSpringProject.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}
