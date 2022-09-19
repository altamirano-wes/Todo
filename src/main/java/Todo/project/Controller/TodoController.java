package Todo.project.Controller;

import Todo.project.Model.Todo;
import Todo.project.Repos.TodoRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//Focuses on todo table in todo database.
@RequestMapping("api/todo")
@RestController
public class TodoController {

    private final TodoRepo todoRepo;

    public TodoController(TodoRepo t) {
        this.todoRepo = t;
    }

    @GetMapping
    public Iterable<Todo> getAllTodos() {
        return this.todoRepo.findAll();
    }

    // READ REQUEST
    @GetMapping(path = "/{id}")
    public Optional<Todo> getTodoById(@PathVariable Integer id) {
        System.out.println("Getting Todo by ID: " + id);
        return this.todoRepo.findById(id);
    }

    // CREATE REQUEST
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        System.out.println("Adding New Todo: " + todo.toString());
        return this.todoRepo.save(todo);
    }//addTodo

    // DELETE REQUEST
    @DeleteMapping(path = "/{id}")
    public Todo deleteTodo(@PathVariable Integer id) {
        Optional<Todo> todoToDelete = this.todoRepo.findById(id);
        if (todoToDelete.isPresent()) {
            this.todoRepo.delete(todoToDelete.get());
            System.out.println("Todo found, being deleted now!");
            return todoToDelete.get();
        }
        else {
            System.out.println("Todo doesn't exist");
            return null;
        }
    }//deleteTodo

    // UPDATE REQUEST
    @PutMapping(path = "/{id}")
    public Todo todoUpdate(@RequestBody Todo t, @PathVariable Integer id) {
        System.out.println("Updating Todo with ID: " + id);
        Optional<Todo> newTodo = this.todoRepo.findById(id);
        if (newTodo.isPresent()) {
            // Get the todo associated with requested ID
            Todo todoUpdate = newTodo.get();
            if (t.getDescription() != null) {
                todoUpdate.setDescription(t.getDescription());
            }
            if (t.getPersonID() != null) {
                todoUpdate.setPersonID(t.getPersonID());
            }
            if(t.getCompleted() || !t.getCompleted()){
                todoUpdate.setCompleted(t.getCompleted());
            }
            return this.todoRepo.save(todoUpdate);
        }
        else {
            System.out.println("Couldn't find Todo.");
            return null;
        }
    }//todoUpdate
}//TodoController
