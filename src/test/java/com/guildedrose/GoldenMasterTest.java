package com.guildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Golden Master test for GuildedRose.
 *
 * Ce test capture le comportement actuel de l'application sur 30 jours
 * pour toutes les combinaisons pertinentes d'items.
 *
 * Pour régénérer le golden master : mvn test -Dupdate-golden-master=true
 */
class GoldenMasterTest {

    private static final Path GOLDEN_MASTER_PATH =
            Paths.get("src/test/resources/golden-master.txt");

    private static final int DAYS = 10;

    private static final String[] ITEM_NAMES = {
            "normal item",
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "Sulfuras, Hand of Ragnaros",
            "Conjured Mana Cake"
    };

    // Valeurs limites et représentatives pour sellIn
    private static final int[] SELL_IN_VALUES = {-1, 0, 1, 5, 6, 10, 11, 15};

    // Valeurs limites et représentatives pour quality
    private static final int[] QUALITY_VALUES = {0, 1, 2, 25, 49, 50};

    @Test
    void goldenMaster() throws IOException {
        String actual = generateOutput();

        if (Boolean.getBoolean("update-golden-master") || !Files.exists(GOLDEN_MASTER_PATH)) {
            Files.createDirectories(GOLDEN_MASTER_PATH.getParent());
            Files.writeString(GOLDEN_MASTER_PATH, actual);
            System.out.println("Golden master généré : " + GOLDEN_MASTER_PATH.toAbsolutePath());
            return;
        }

        String expected = Files.readString(GOLDEN_MASTER_PATH);
        assertEquals(expected, actual);
    }

    private String generateOutput() {
        StringBuilder sb = new StringBuilder();

        for (String name : ITEM_NAMES) {
            for (int sellIn : SELL_IN_VALUES) {
                for (int quality : QUALITY_VALUES) {
                    int initialQuality = name.equals("Sulfuras, Hand of Ragnaros") ? 80 : quality;

                    Item[] items = {new Item(name, sellIn, initialQuality)};
                    GuildedRose app = new GuildedRose(items);

                    sb.append(String.format("=== %s | sellIn=%d | quality=%d ===\n",
                            name, sellIn, initialQuality));
                    sb.append(formatItem("Jour  0", items[0]));

                    for (int day = 1; day <= DAYS; day++) {
                        app.updateQuality();
                        sb.append(formatItem("Jour " + String.format("%2d", day), items[0]));
                    }
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    private String formatItem(String label, Item item) {
        return String.format("  %s -> sellIn=%3d, quality=%3d\n", label, item.sellIn, item.quality);
    }
}
