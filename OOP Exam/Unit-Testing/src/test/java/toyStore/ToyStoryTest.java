package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {
    //TODO: Write your tests here

    private Map<String, Toy> test;
    private ToyStore store;
    private Toy toy;
    private Toy toy1;
    private Toy toy2;

    @Before
    public void setUp(){
        test = new LinkedHashMap<>();
        test.put("A", null);
        test.put("B", null);
        test.put("C", null);
        test.put("D", null);
        test.put("E", null);
        test.put("F", null);
        test.put("G", null);
        store = new ToyStore();
        toy = new Toy("manif1","yoyo");
        toy1 = new Toy("manif2","bakugan");
        toy2 = new Toy("manif3","rubkics cube");

    }
    @Test
    public void testGetToyShelf(){
        Assert.assertEquals(test, store.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyWithWrongShelf() throws OperationNotSupportedException {
        store.addToy("GG",toy);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyToThatIsAlreadyAdded() throws OperationNotSupportedException {
        store.addToy("G",toy);
        store.addToy("A",toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToFullShelf() throws OperationNotSupportedException {
        store.addToy("G",toy);
        store.addToy("G",toy);
    }
    @Test
    public void testAddToySuccessfully() throws OperationNotSupportedException {
        test.put("G",toy);
        Assert.assertEquals("Toy:yoyo placed successfully!", store.addToy("G",toy));
        Assert.assertEquals(test,store.getToyShelf());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWithWrongShelf() throws OperationNotSupportedException {
        store.addToy("G",toy);
        store.removeToy("GG",toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWrongToy() throws OperationNotSupportedException {
        store.addToy("G",toy);
        store.removeToy("G",toy1);
    }
    @Test
    public void testRemoveToySuccessfully() throws OperationNotSupportedException {
        store.addToy("G",toy);
        Assert.assertEquals("Remove toy:yoyo successfully!",store.removeToy("G",toy));
        Assert.assertEquals(test,store.getToyShelf());
    }

}