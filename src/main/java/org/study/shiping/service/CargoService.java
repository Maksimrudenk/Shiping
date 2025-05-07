package org.study.shiping.service;

import org.springframework.stereotype.Service;
import org.study.shiping.model.Cargo;
import org.study.shiping.repository.CargoRepository;
import org.study.shiping.dto.CargoDto;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<CargoDto> getAllCargosByOrder(Long orderId) {
        return cargoRepository.findAllByOrder_Id(orderId).stream().map(this::map).collect(Collectors.toList());
    }

    private CargoDto map(Cargo c) {
        CargoDto dto = new CargoDto();
        dto.cargoId = c.getId();
        dto.type = c.getType();
        dto.weight = c.getWeight();
        dto.state = c.getState();
        return dto;
    }
}
