package toy.todoList.entity;


import lombok.Getter;

@Getter
public enum PrimaryScore {
        FIRST(1), SECOND(2), THIRD(3);

        private final int description;

        PrimaryScore(int description) {
                this.description = description;
        }
}
