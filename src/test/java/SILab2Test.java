import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<Item> createList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    @Test
    void EveryStatement() {
        RuntimeException e;
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,"anything"));
        assertTrue(e.getMessage().contains("allItems list can't be null!"));
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item(null,100,100,50)),"anything"));
        assertTrue(e.getMessage().contains("Invalid item!"));
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("User",100,100,50)),null));
        assertTrue(e.getMessage().contains("Invalid card number!"));
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("User",100,100,0)),"123456789B123456"));
        assertTrue(e.getMessage().contains("Invalid character in card number!"));
        assertEquals(9970,SILab2.checkCart(createList(new Item("User", 100, 100, 0)), "1234567890123456"));
    }

    @Test
    void MultipleCondition() {
        assertEquals(19970,SILab2.checkCart(createList(new Item("User", 100, 400, 0.5)), "1234567890123456"));
        assertEquals(4970,SILab2.checkCart(createList(new Item("User", 100, 100, 0.5)), "1234567890123456"));
        assertEquals(9970,SILab2.checkCart(createList(new Item("User", 100, 100, 0)), "1234567890123456"));
        assertEquals(500,SILab2.checkCart(createList(new Item("User", 5, 100, 0)), "1234567890123456"));
    }
}
