package com.ebac.animal_service.repository;

import com.ebac.animal_service.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada ASC ")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL ORDER BY a.dataEntrada ASC ")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataObito IS NOT NULL ORDER BY a.dataEntrada ASC ")
    List<Animal> findDied();

    @Query("SELECT a FROM Animal a WHERE LOWER(a.especie) = LOWER(:especie) ")
    List<Animal> findByEspecie(@Param("especie") String especie);

    @Query("SELECT COUNT(a) FROM Animal a WHERE LOWER(a.nomeRecebedor) = LOWER(:nomeRecebedor) AND a.dataEntrada BETWEEN :inicio AND :fim")
    Integer countAnimalsBetweenDate(@Param("nomeRecebedor") String nomeRecebedor,
                                                 @Param("inicio")LocalDate inicio,
                                                 @Param("fim") LocalDate fim);
}
