import com.wssonar.core.model.WebServiceTest;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    WebServiceTest.class
})
public class TestSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}