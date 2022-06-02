package courseworkSD2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	//this class adds all the test cases to a test suite so all the tests can be run together
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		suite.addTestSuite(EnemyShipFactoryTest.class);
		suite.addTestSuite(MasterShipTest.class);
		suite.addTestSuite(GameTest.class);
		suite.addTestSuite(GridTest.class);
		suite.addTestSuite(RowTest.class);
		suite.addTestSuite(SquareTest.class);
		suite.addTestSuite(MyIteratorsTest.class);
		
		return suite;
	}

}
