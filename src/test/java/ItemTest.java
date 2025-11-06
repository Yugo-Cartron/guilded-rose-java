import com.guildedrose.InvalidQualityException;
import com.guildedrose.Item;
import com.guildedrose.Quality;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("An item should")
public class ItemTest {

    @Test
    @DisplayName("reduce its sellIn each day")
    public void reduceItsSellInEachDay () throws InvalidQualityException {
        var item = new Item("Big Sword", 10, Quality.of(10));

        item.applyDailyUpdate();

        assertEquals(9, item.sellIn);
    }

    @Test
    @DisplayName("Quality should decrease by 1 each day")
    public void decreaseQualityByOneEachDay () throws InvalidQualityException {
        var item = new Item("Big Sword", 10, Quality.of(10));

        item.applyDailyUpdate();

        assertEquals(9, item.quality.value());
    }

    @Test
    @DisplayName("when the sellIn is negative, the quality decreases twice faster")
    public void decreaseQualityByTwoEachDayWhenTheSellInIsEqualToZero () throws InvalidQualityException {
        var item = new Item("Big Sword", -1, Quality.of(10));

        item.applyDailyUpdate();

        assertEquals(8, item.quality.value());
    }

    @Test
    @DisplayName("Quality can never be negative during instantiation")
    public void qualityCanNotBeNegativeDuringInstantiation () {
        var exception = assertThrows(InvalidQualityException.class, () -> new Item("Big Sword", 10, Quality.of(-1)));
        assertEquals("Quality cannot be negative, quality provided: -1", exception.getMessage());
    }

    @Test
    @DisplayName("Quality can never be negative after a daily update")
    public void qualityCanNotBeNegativeAfterDailyUpdate() throws InvalidQualityException {
        var item = new Item("Big Sword", 10, Quality.of(0));
        var peremptedItem = new Item("Big Sword", -1, Quality.of(0));

        item.applyDailyUpdate();
        peremptedItem.applyDailyUpdate();

        assertEquals(0, item.quality.value());
        assertEquals(0, peremptedItem.quality.value());
    }
}
