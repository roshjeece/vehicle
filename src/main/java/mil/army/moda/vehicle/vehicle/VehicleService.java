package mil.army.moda.vehicle.vehicle;

import org.springframework.stereotype.Service;

@Service
public class VehicleService  {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }



}
