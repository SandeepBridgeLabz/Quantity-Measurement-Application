package com.bridgelab.service;

import com.bridgelab.dto.QuantityDTO;
import com.bridgelab.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(
            QuantityDTO q1,
            QuantityDTO q2
    );

    QuantityMeasurementEntity convert(
            QuantityDTO q,
            String targetUnit
    );

    QuantityMeasurementEntity add(
            QuantityDTO q1,
            QuantityDTO q2
    );
}
