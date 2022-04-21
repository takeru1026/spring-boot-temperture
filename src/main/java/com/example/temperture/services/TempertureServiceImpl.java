package com.example.temperture.services;

import com.example.temperture.model.Temperture;
import com.example.temperture.repositories.TempertureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TempertureServiceImpl implements TempertureService {
  TempertureRepository tempertureRepository;

  @Autowired
  JdbcTemplate jdbc;

  public TempertureServiceImpl(TempertureRepository tempertureRepository){
    this.tempertureRepository = tempertureRepository;
  }

  @Override
  public List<Map<String, Object>> getTempertures(int number) {
    final String sql = "SELECT * FROM Temperture ORDER BY id DESC LIMIT ?";
    List<Map<String, Object>> sqlList = jdbc.queryForList(sql, number);
    return sqlList;
  }

  @Override
  public Temperture getTempertureById(Long id) {
    Optional<Temperture> Temperture = tempertureRepository.findById(id);
    return Temperture.orElse(null);
  }

  @Override
  public Temperture insertTemperture(Temperture temperture) {
    return tempertureRepository.save(temperture);
  }
}

