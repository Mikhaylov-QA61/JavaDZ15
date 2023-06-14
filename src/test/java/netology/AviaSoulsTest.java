package netology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Самара", "Сочи", 2000, 1755, 2020);
    Ticket ticket2 = new Ticket("Сочи", "Самара", 3000, 1940, 2300);
    Ticket ticket3 = new Ticket("Самара", "Москва", 1000, 1801, 2111);
    Ticket ticket4 = new Ticket("Москва", "Самара", 5555, 1313, 1616);
    Ticket ticket5 = new Ticket("Самара", "Москва", 6666, 1124, 1419);
    Ticket ticket6 = new Ticket("Самара", "Москва", 1000, 1624, 1919);

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
    }

    @Test
    public void priceBelowComparableTest() {
        setup();

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceAboveComparableTest() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void pricePeerComparableTest() {

        int expected = 0;
        int actual = ticket3.compareTo(ticket6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortTicketByPriceTest() {
        setup();
        Ticket expected[] = {ticket3, ticket6, ticket5};
        Ticket actual[] = aviaSouls.search("Самара", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNullTicketByPriceTest() {
        setup();
        Ticket expected[] = {};
        Ticket actual[] = aviaSouls.search("Москва", "Челябинск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketByTimeTest() {
        setup();
        Ticket expected[] = {ticket5, ticket6, ticket3};
        Ticket actual[] = aviaSouls.searchAndSortBy("Самара", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNullTicketByTimeTest() {
        setup();
        Ticket expected[] = {};
        Ticket actual[] = aviaSouls.search("Адлер", "Саратов");

        Assertions.assertArrayEquals(expected, actual);
    }
}