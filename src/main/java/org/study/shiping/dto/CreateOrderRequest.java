package org.study.shiping.dto;

import java.util.List;

public class CreateOrderRequest {
    public long senderId;
    public long receiverId;
    public long departureId;
    public long destinationId;
    public List<CargoDto> cargo;
}
