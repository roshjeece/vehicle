package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    VehicleService vehicleService;

    @Test
    void shouldSaveVehicle() {
        // Arrange
        Vehicle triplane = new Vehicle("Triplane", "DR-1", 1916, 100);
        triplane.setId(1L);

        // Act
        when(vehicleRepository.save(triplane)).thenReturn(triplane);
        Vehicle result = vehicleService.saveVehicle(triplane);

        // Assert
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getMake()).isEqualTo("Triplane");
        verify(vehicleRepository).save(triplane);
    }

}