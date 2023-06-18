package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {
    private Archaeologist archaeologist;
    private Excavation excavation;
    @Before
    public void setUp(){
         archaeologist = new Archaeologist("John",100);
         excavation = new Excavation("Excavation1",2);
    }
    @Test
    public void testGetCount(){
        assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        assertEquals(1,excavation.getCount());
    }
    @Test
    public void testGetName(){
        assertEquals("Excavation1",excavation.getName());
    }
    @Test
    public void testGetCapacity(){
        assertEquals(2,excavation.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWrongCapacity(){
        Excavation excavation1 = new Excavation("excavation2",-1);
    }
    @Test(expected = NullPointerException.class)
    public void testAddWrongName(){
        Excavation excavation1 = new Excavation("",1);
    }
    @Test
    public void testAddArc(){
        assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        assertEquals(1,excavation.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArcToFullExc(){
        assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologist1 = new Archaeologist("John1",100);
        Archaeologist archaeologist2 = new Archaeologist("John2",100);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddSameArc(){
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }
    @Test
    public void testRemoveArc(){
//        assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        excavation.removeArchaeologist(archaeologist.getName());
        assertEquals(0,excavation.getCount());
    }
    @Test
    public void testRemoveWrongArc(){
//        assertEquals(0,excavation.getCount());
        Archaeologist archaeologist1 = new Archaeologist("John1",100);
        excavation.addArchaeologist(archaeologist);
        String name = archaeologist1.getName();

        assertEquals(false,excavation.removeArchaeologist(name));
        assertEquals(1,excavation.getCount());
    }

}
