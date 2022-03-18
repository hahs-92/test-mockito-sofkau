import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SubDependencyTest {

    @Mock
    private SubDependency subDependency;

    private Dependency dependency;

    @BeforeEach
    public void setupMock() {
        subDependency = Mockito.mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubDependecia() {
        Mockito.when(subDependency.getClassName()).thenReturn("hi there");

        Assertions.assertEquals("hi there", dependency.getSubdepedencyClassName());
    }

}
