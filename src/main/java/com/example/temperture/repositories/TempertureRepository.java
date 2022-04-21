package com.example.temperture.repositories;


import com.example.temperture.model.Temperture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempertureRepository extends JpaRepository<Temperture, Long> {
}

