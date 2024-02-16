package exerc14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TimeTest {
    @ParameterizedTest
    @CsvSource({
            "90, 30",
            "3600, 0",
            "3599, 59"
    })
    void testRemainingSeconds(int seconds, int expectedRemainingSeconds) {
        assertEquals(expectedRemainingSeconds, Time.remainingSeconds(seconds));
    }

    @ParameterizedTest
    @CsvSource({
            "3690, 90",
            "3600, 0",
            "7253, 53"
    })
    void testRemainingMinutes(int seconds, int expectedRemainingMinutes) {
        assertEquals(expectedRemainingMinutes, Time.remainingMinutes(seconds));
    }

    @ParameterizedTest
    @CsvSource({
            "3600, 1",
            "7200, 2",
            "59, 0"
    })
    void testSecondsToHours(int seconds, int expectedHours) {
        assertEquals(expectedHours, Time.secondsToHours(seconds));
    }

    @ParameterizedTest
    @CsvSource({
            "3600, 1h 0m 0s",
            "7260, 2h 1m 0s",
            "7290, 2h 1m 30s",
    })
    void testConvertTime(int seconds, String expectedTime) {
        assertEquals(expectedTime, Time.convertTime(seconds));
    }
}
