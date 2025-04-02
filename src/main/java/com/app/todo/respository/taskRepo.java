package com.app.todo.respository;
import com.app.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface taskRepo extends JpaRepository<Task, Long> {

}
