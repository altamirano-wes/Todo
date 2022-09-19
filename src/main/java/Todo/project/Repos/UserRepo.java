package Todo.project.Repos;

import Todo.project.Model.Todo;
import Todo.project.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
