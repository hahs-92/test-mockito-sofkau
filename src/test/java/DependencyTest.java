import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class DependencyTest {
    @Mock
    private Dependency dependency;

    @BeforeEach
    public void setupMock() {
        dependency = Mockito.mock(Dependency.class);
    }

    @Test
    public void testDependency() {
        Mockito.when(dependency.getClassName()).thenReturn("hi there");

        Assertions.assertEquals("hi there", dependency.getClassName());
    }


    @Test
    public void testAddTwo() {
        Mockito.when(dependency.addTwo(1)).thenReturn(5);

        Assertions.assertEquals(5, dependency.addTwo(1));
        Assertions.assertEquals(0, dependency.addTwo(27));
    }

    @Test
    public void testAddTwoAny() {
        Mockito.when(dependency.addTwo(Mockito.anyInt())).thenReturn(0);

        Assertions.assertEquals(0, dependency.addTwo(3));
        Assertions.assertEquals(0, dependency.addTwo(80));
    }

}
