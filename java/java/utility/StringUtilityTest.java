package utility;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilityTest {

    private StringUtility stringUtility;

    @BeforeEach
    void setUp() {
        stringUtility = new StringUtility();
    }

    @AfterEach
    void tearDown() {
        stringUtility = null;
    }

    // ===== isEmpty Tests =====
    @Test
    void testIsEmpty_withNullString() {
        assertTrue(stringUtility.isEmpty(null));
    }

    @Test
    void testIsEmpty_withEmptyString() {
        assertTrue(stringUtility.isEmpty(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void testIsEmpty_withBlankStrings(String input) {
        assertTrue(stringUtility.isEmpty(input), "Blank strings should be considered empty");
    }

    @Test
    void testIsEmpty_withNonEmptyString() {
        assertFalse(stringUtility.isEmpty("hello"));
    }

    // ===== reverse Tests =====
    @Test
    void testReverse_withNullInput() {
        assertNull(stringUtility.reverse(null));
    }

    @Test
    void testReverse_withEmptyString() {
        assertEquals("", stringUtility.reverse(""));
    }

    @Test
    void testReverse_withPalindrome() {
        assertEquals("madam", stringUtility.reverse("madam"));
    }

    @Test
    void testReverse_withRegularString() {
        assertEquals("olleh", stringUtility.reverse("hello"));
    }

    // ===== countOccurrences Tests =====
    @Test
    void testCountOccurrences_withNullInput() {
        assertEquals(0, stringUtility.countOccurrences(null, 'a'));
    }

    @Test
    void testCountOccurrences_withNoOccurrences() {
        assertEquals(0, stringUtility.countOccurrences("hello", 'z'));
    }

    @Test
    void testCountOccurrences_withMultipleOccurrences() {
        assertEquals(3, stringUtility.countOccurrences("banana", 'a'));
    }

    @Test
    void testCountOccurrences_caseSensitivity() {
        assertEquals(1, stringUtility.countOccurrences("Apple", 'A'));
//        assertEquals(1, stringUtility.countOccurrences("Apple", 'p'));
    }

    // ===== toTitleCase Tests =====
    @Test
    void testToTitleCase_withNullInput() {
        assertNull(stringUtility.toTitleCase(null));
    }

    @Test
    void testToTitleCase_withEmptyString() {
        assertEquals("", stringUtility.toTitleCase(""));
    }

    @Test
    void testToTitleCase_withSingleWord() {
        assertEquals("Hello", stringUtility.toTitleCase("hello"));
    }

    @Test
    void testToTitleCase_withMultipleWords() {
        assertEquals("Hello World", stringUtility.toTitleCase("hello world"));
    }

    @Test
    void testToTitleCase_withAlreadyTitleCasedString() {
        assertEquals("Hello World", stringUtility.toTitleCase("Hello World"));
    }

    // ===== truncate Tests =====
    @Test
    void testTruncate_withShorterString() {
        assertEquals("hello", stringUtility.truncate("hello", 10));
    }

    @Test
    void testTruncate_withExactLength() {
        assertEquals("hello", stringUtility.truncate("hello", 5));
    }

    @Test
    void testTruncate_withLongerString() {
        assertEquals("hel...", stringUtility.truncate("hello world", 3));
    }

    @Test
    void testTruncate_withNullInput() {
        assertNull(stringUtility.truncate(null, 5));
    }

    @Test
    void testTruncate_withNegativeMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> stringUtility.truncate("hello", -1));
    }

    // ===== isAlphabetic Tests =====
    @Test
    void testIsAlphabetic_withNullInput() {
        assertFalse(stringUtility.isAlphabetic(null));
    }

    @Test
    void testIsAlphabetic_withEmptyString() {
        assertFalse(stringUtility.isAlphabetic(""));
    }

    @Test
    void testIsAlphabetic_withAlphabeticString() {
        assertTrue(stringUtility.isAlphabetic("Hello"));
    }

    @Test
    void testIsAlphabetic_withMixedContent() {
        assertFalse(stringUtility.isAlphabetic("Hello123"), "String with numbers should not be considered alphabetic");
    }

    @Test
    void testIsAlphabetic_withSpecialCharacters() {
        assertFalse(stringUtility.isAlphabetic("Hello!"));
    }

    // ===== isValidEmail Tests =====
    @Test
    void testIsValidEmail_withNullInput() {
        assertFalse(stringUtility.isValidEmail(null));
    }

    @Test
    void testIsValidEmail_withEmptyString() {
        assertFalse(stringUtility.isValidEmail(""));
    }

    @Test
    void testIsValidEmail_withInvalidEmail() {
        assertFalse(stringUtility.isValidEmail("invalid-email"));
    }

    @Test
    void testIsValidEmail_withValidEmail() {
        assertTrue(stringUtility.isValidEmail("user@example.com"));
    }

    @Test
    void testIsValidEmail_multipleValidFormats() {
        assertAll("Multiple valid email formats",
            () -> assertTrue(stringUtility.isValidEmail("user@example.com"), "Simple email should be valid"),
            () -> assertTrue(stringUtility.isValidEmail("john.doe@domain.co.uk"), "Email with subdomain should be valid"),
            () -> assertTrue(stringUtility.isValidEmail("name+tag@example.org"), "Email with + should be valid")
        );
    }

    // ===== Disabled Test Example =====
    @Disabled("This test is currently not working due to incomplete implementation")
    @Test
    void testUnfinishedFeature() {
        fail("Not implemented yet");
    }

    // ===== Conditional Test Execution Example =====
    @Test
    @EnabledOnOs(OS.MAC)
    void testFeatureOnMac() {
        assertTrue(stringUtility.isAlphabetic("MacOnly"));
    }
}
        

