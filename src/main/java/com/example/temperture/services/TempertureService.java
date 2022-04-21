package com.example.temperture.services;

import com.example.temperture.model.Temperture;
import java.util.List;
import java.util.Map;

public interface TempertureService {

  List<Map<String, Object>> getTempertures(int number);

  Temperture getTempertureById(Long id);
  Temperture insertTemperture(Temperture Temperture);
 ;
}




