package monitorbehaviors;

import java.util.Objects;

import static java.lang.String.format;

public interface TODOClient {
    String createTODO(String content);

    TODO findTODObyId(String todoId);

    class TODO {
        private final String id;
        private final String content;

        public TODO(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return format("TODO{id='%s', content='%s'}", id, content);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TODO todo = (TODO) o;
            return Objects.equals(id, todo.id) && Objects.equals(content, todo.content);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, content);
        }
    }
}
