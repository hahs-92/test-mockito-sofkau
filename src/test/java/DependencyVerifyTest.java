import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DependencyVerifyTest {
    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify() {
        //never
        Mockito.verify(dependency, Mockito.never()).getClassNameUpperCase();

        //one time
        dependency.getClassNameUpperCase();
        Mockito.verify(dependency, Mockito.times(1)).getClassNameUpperCase();

        //one time atLeats
        Mockito.verify(dependency, Mockito.atLeast(1)).getClassNameUpperCase();

        //max 2 times
        dependency.getClassNameUpperCase();
        Mockito.verify(dependency, Mockito.atMost(2)).getClassNameUpperCase();
    }

    @Test
    public void testParameters() {
        dependency.addTwo(3);
        Mockito.verify(dependency, Mockito.times(1)).addTwo(3);

        dependency.addTwo(4);
        Mockito.verify(dependency, Mockito.times(2)).addTwo(Mockito.anyInt());
    }

}
