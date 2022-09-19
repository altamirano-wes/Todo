package Todo.project.Repos;

import Todo.project.Model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, Integer> {
}
