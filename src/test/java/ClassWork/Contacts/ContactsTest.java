package ClassWork.Contacts;

import Utilities.RandomNameGenerator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {

    @Test
    void validatePhoneNumber() {

        String[] contacts = {
                RandomNameGenerator.fullNameGenerator() + " 709-123-4567",
                RandomNameGenerator.fullNameGenerator() + " 416-789-1234",
                RandomNameGenerator.fullNameGenerator() + " 905-555-6789",
                RandomNameGenerator.fullNameGenerator() + " 613-789-0123",
                RandomNameGenerator.fullNameGenerator() + " 709-321-9876",
                RandomNameGenerator.fullNameGenerator() + " 800-123-4567",
                RandomNameGenerator.fullNameGenerator() + " 709-000-1111",
                RandomNameGenerator.fullNameGenerator() + " 613-987-6543",
                RandomNameGenerator.fullNameGenerator() + " 907-555-1234",
                RandomNameGenerator.fullNameGenerator() + " 613-999-8888",
        };

        ArrayList<Boolean> assertionList = new ArrayList<Boolean>();
        for (String contact: contacts) {
            assertionList.add(Contacts.validatePhoneNumber(contact));
        }

        boolean[] expectedResults = {true, false, false, true, true, false, true, true, false, true};
        for (int i = 0; i < assertionList.size(); i++) {
            assertEquals(expectedResults[i], assertionList.get(i));
        }
    }
    }










