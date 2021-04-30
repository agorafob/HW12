import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionTests {
    MyCollection test = new MyCollection();
    MyCollection test2 = new MyCollection();

    @Test
    public void addTest() {
        Assertions.assertTrue(test.add("111"));
    }

    @Test
    public void addByIndexTest() {
        Assertions.assertTrue(test.add(0, "222"));
    }

    @Test
    public void deleteTest() {
        Assertions.assertTrue(test.delete("111"));
    }

    @Test
    public void getTest() {
        Assertions.assertNotNull(test.get(0));
    }

    @Test
    public void containsTest() {
        Assertions.assertTrue(test.contain("222"));
    }

    @Test
    public void equalsTest() {
        Assertions.assertTrue(test.equals(test2));
    }

    @Test
    public void clearTest() {
        Assertions.assertTrue(test.clear());
    }

    @Test
    public void sizeTest(){
        Assertions.assertEquals(0,test.size());
    }

}
