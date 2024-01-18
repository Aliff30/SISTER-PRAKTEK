/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alif.nilai.repository;

import com.alif.nilai.entity.Nilai;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Long> {
    public Optional<Nilai> findNilaiById(Long id);
}
