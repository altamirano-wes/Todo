package Todo.project.Controller;
import Todo.project.Model.Todo;
import Todo.project.Model.User;
import Todo.project.Repos.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//To be used for bonus 2
//Focuses on table "person" in todo database
@RequestMapping("api/person")
@RestController
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo u) {
        this.userRepo = u;
    }

    //READ request for getting list of todos for a specific user
    @GetMapping(path = "/{id}/todos")
    public Iterable<Todo> getTodosForUser(@PathVariable Integer i){
        System.out.println("Getting Todo list for user with ID: "+i);
        Optional<User> userOptional = this.userRepo.findById(i);
        if(!userOptional.isPresent()){
            System.out.println("User was not found");
            return null;
        }
        else{
            User userChoice = userOptional.get();
            return userChoice.getTodoList();
        }
    }//getTodoListForUser

    //READ request for getting user by ID
    @GetMapping(path = "/{id}")
    public Optional<User> getUserByID(@PathVariable Integer id){
        System.out.println("Getting user by ID: "+id);
        return this.userRepo.findById(id);
    }//getUserByID

    //READ request to retrieve all users
    @GetMapping
    public Iterable<User> getAllUsers(){
        System.out.println("Getting all users that exist.");
        return this.userRepo.findAll();
    }//getAllUsers

    //UPDATE request
    @PutMapping(path = "/{id}")
    public User updateUser(@RequestBody User u, @PathVariable Integer id){
        System.out.println("Updating user with ID: "+id);
        Optional<User> userToUpdate = this.userRepo.findById(id);
        if(userToUpdate.isPresent()){
            //If user with ID requested, exists then:
            User userUpdate = userToUpdate.get();
            if(u.getName() != null){
                userUpdate.setName(u.getName());
            }
            return this.userRepo.save(userUpdate);
        }
        else{
            System.out.println("No such user found.");
            return null;
        }
    }//updateUser

    //CREATE POST request
    @PostMapping
    public User addUser(@RequestBody User u){
        System.out.println("Adding new user: "+u.toString());
        return this.userRepo.save(u);
    }//addUser

    //POST request for new user
    @PostMapping(path = "/register")
    public User registerUser(@RequestParam(name = "name") String name){
        System.out.println("Adding new user with name: "+name);
        User user = new User();
        user.setName(name);
        return this.userRepo.save(user);
    }//registerUser

    //DELETE request
    @DeleteMapping(path = "/{id}")
    public User deleteUser(@PathVariable Integer i){
        Optional<User> userToRemove = this.userRepo.findById(i);
        if (userToRemove.isPresent()){
            this.userRepo.delete(userToRemove.get());
            return userToRemove.get();
        }
        else{
            System.out.println("User doesn't exist.");
            return null;
        }
    }//deleteUser

}//UserController
