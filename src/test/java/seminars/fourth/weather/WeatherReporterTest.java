package seminars.fourth.weather;

import org.example.Seminar4.weather.WeatherReporter;
import org.example.Seminar4.weather.WeatherService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherReporterTest {
    @Test
    void checkWeatherReporterGenerateReport() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        when(weatherService.getCurrentTemperature()).thenReturn(30);
        String temp = weatherReporter.generateReport();

        assertEquals("Текущая температура: 30 градусов.", temp);
        verify(weatherService, times(1)).getCurrentTemperature();


    }
}