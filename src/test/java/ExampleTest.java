import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Example Test Class")
class ExampleTest {

    @Test
    @DisplayName("Check that 1 + 1 equals 2")
    void exampleTest() {
        assertEquals(1+1, 2);
    }

}
