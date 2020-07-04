package com.sda.javagdy4_apirekrutacyjne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtilties {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Method processes input string given in format <code>yyyy-MM-dd</code>.
     *
     * @param input - input in format <code>yyyy-MM-dd</code>
     * @return parsed local date instance
     * @throws DateTimeParsingException - exception that might happen when there is parsing exception or date is after yesterday.
     */
    public static LocalDate loadEndDate(String input) throws DateTimeParsingException {
        LocalDate loadedDate;
        try {
            loadedDate = LocalDate.parse(input, FORMATTER);

            // sprawdzamy czy załadowana data jest po wczoraj
            if (loadedDate.isAfter(LocalDate.now().minusDays(1))) {
                throw new DateTimeParseException("End date should be no later than yesterday.", input, 1);
            }
        } catch (DateTimeParseException dtpe) {
            System.out.println("Błąd parsowania daty.");
            throw new DateTimeParsingException(dtpe.getMessage());
        }
        return loadedDate;
    }

}