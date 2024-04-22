package enzinium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {
    private Address rick = null;
    private Address morty = null;
    private TokenContract ricknillos = null;

    @BeforeEach
    public void setup_address_y_contract() {


        rick = new Address();
        rick.generateKeyPair();
        ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        assertEquals(1, ricknillos.getBalances().size());

        ricknillos.setTokenPrice(5d);

        morty = new Address();
        morty.generateKeyPair();

    }

    @Test
    public void requireThrowsTest() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> ricknillos.checkHasEnoughBalance(0.0, 1.0));
    }
}

