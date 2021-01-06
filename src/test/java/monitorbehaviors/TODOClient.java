package monitorbehaviors;

import java.util.Objects;
import java.util.StringJoiner;

import static java.lang.String.format;

public interface TODOClient {
    String createTODO(String content);

    TODO findTODObyId(String todoId) throws TODONotFoundException;

    class TODO {
        public final String id;
        public final String content;

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

    class TODONotFoundException extends Exception {}
}
