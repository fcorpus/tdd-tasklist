package edu.uaslp.objetos.taskslist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.time.Month;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void givenANewTask_validateInfoOnTask() {
        // Given:
        Task task = new Task();

        task.setTitle("Lavar los trastes");
        task.setDescription("Lavar los trastes sin tirar mucha agua");

        // When:
        String title = task.getTitle();
        String description = task.getDescription();
        LocalDateTime dueDate = task.getDueDate();
        boolean done = task.isDone();

        // Then:
        assertThat(title).isEqualTo("Lavar los trastes");
        assertThat(description).isEqualTo("Lavar los trastes sin tirar mucha agua");
        assertThat(dueDate).isNull();
        assertThat(done).isFalse();
    }

    @Test
    public void givenANewTask_validateInfoWithDueDateOnTask() {
        // Given:
        Task task = new Task();
        LocalDateTime dateInFuture = LocalDateTime.now().plusWeeks(20);

        task.setTitle("Lavar los trastes");
        task.setDescription("Lavar los trastes sin tirar mucha agua");
        task.setDueDate(dateInFuture);
        task.setDone(false);

        // When:
        String title = task.getTitle();
        String description = task.getDescription();
        LocalDateTime dueDate = task.getDueDate();
        boolean done = task.isDone();

        // Then:
        assertThat(title).isEqualTo("Lavar los trastes");
        assertThat(description).isEqualTo("Lavar los trastes sin tirar mucha agua");
        assertThat(dueDate).isEqualTo(dateInFuture);
        assertThat(done).isFalse();
    }

    @Test
    public void givenANewTaskCreatedWithConstructor_validateInfoWithDueDateOnTask() {
        // Given:
        LocalDateTime dateInFuture = LocalDateTime.now().plusWeeks(20);
        Task task = new Task("Lavar los trastes", "Lavar los trastes sin tirar mucha agua", dateInFuture, false);

        // When:
        String title = task.getTitle();
        String description = task.getDescription();
        LocalDateTime dueDate = task.getDueDate();
        boolean done = task.isDone();

        // Then:
        assertThat(title).isEqualTo("Lavar los trastes");
        assertThat(description).isEqualTo("Lavar los trastes sin tirar mucha agua");
        assertThat(dueDate).isEqualTo(dateInFuture);
        assertThat(done).isFalse();
    }

    @Test
    public void givenANewTask_whenDueDateIsSetInThePast_thenAnExceptionIsThrown() {
        // Given:
        Task task = new Task();
        LocalDateTime dateInThePast = LocalDateTime.of(2021, Month.JANUARY, 25, 0, 0, 0);

        // When:
        // Then:
        /*try {//polimorfismo
            task.setDueDate(dateInThePast);
        }catch(Exception exception){
            assertThat(exception.getMessage()).isEqualTo("Due date is set in the past");
            assertThat(exception).isInstanceOf(RuntimeException.class);//m1
            assertThat(exception).isInstanceOf(TaskListException.class);//m1
            org.junit.jupiter.api.Assertions.assertTrue(exception instanceof RuntimeException);//m2
        }*/
        assertThatThrownBy(() -> task.setDueDate(dateInThePast))
                .hasMessage("Due date is set in the past")
                .isInstanceOf(TaskListException.class)
                .isInstanceOf(RuntimeException.class);

    }
}
