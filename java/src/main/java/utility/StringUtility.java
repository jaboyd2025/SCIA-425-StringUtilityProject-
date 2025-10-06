package utility;

/**
 * A utility class for common string operations.
 */
public class StringUtility {
    
    /**
     * Checks if a string is empty or null.
     * @param str the string to check
     * @return true if the string is empty or null, false otherwise
     */
	public boolean isEmpty(String str) {
	    // Returns true if null, empty, or whitespace-only
	    return str == null || str.trim().isEmpty();
	}

    
    /**
     * Reverses a string.
     * @param str the string to reverse
     * @return the reversed string, or null if input is null
     */
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Counts the occurrences of a character in a string.
     * @param str the string to check
     * @param charToCount the character to count
     * @return the number of occurrences, or 0 if str is null
     */
    public int countOccurrences(String str, char charToCount) {
        if (str == null) return 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == charToCount) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Converts a string to title case (each word starts with uppercase).
     * @param str the string to convert
     * @return the title case string, or null if input is null
     */
    public String toTitleCase(String str) {
        if (str == null) return null;
        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        return result.toString().trim();
    }
    
    /**
     * Truncates a string to a specified length and adds ellipsis if truncated.
     * @param str the string to truncate
     * @param maxLength the maximum length
     * @return the truncated string with "..." if truncated
     * @throws IllegalArgumentException if maxLength is negative
     */
    public String truncate(String str, int maxLength) {
        if (maxLength < 0) {
            throw new IllegalArgumentException("maxLength cannot be negative");
        }
        if (str == null) return null;
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength) + "...";
    }

    
    /**
     * Checks if a string contains only alphabetic characters.
     * @param str the string to check
     * @return true if string contains only letters, false otherwise
     */
    public boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) return false;
        return str.chars().allMatch(Character::isLetter);
    }
    
    /**
     * Checks if a string is a valid email address (simplified validation).
     * @param email the string to validate
     * @return true if string appears to be a valid email, false otherwise
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
    }
}
