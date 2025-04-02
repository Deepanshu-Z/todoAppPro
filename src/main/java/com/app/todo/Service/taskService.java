    package com.app.todo.Service;

    import com.app.todo.model.Task;
    import com.app.todo.respository.taskRepo;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class taskService{

        private final taskRepo tr;
        taskService(taskRepo tr){
            this.tr = tr;
        }
        public List<Task> getAllTasks(){
            return tr.findAll();
        }

        public void createNewTask(String title){
            Task task = new Task();
            task.setTitle(title);
            task.setCompleted(false);
            tr.save(task);
        }

        public void deleteTaskById(Long id){
            tr.deleteById(id);
        }

        public void toggleTask(Long id){
            Task task = tr.findById(id).orElseThrow(() -> new IllegalArgumentException());
            task.setComplete();
            tr.save(task);
        }
    }
