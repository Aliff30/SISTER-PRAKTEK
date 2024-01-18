/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alif.matakuliah.repository;

import com.alif.matakuliah.entity.Matakuliah;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {
   public Optional<Matakuliah> findMatakuliahByKode(String kode);

    public Optional<Matakuliah> findMatakuliahByNama(String nama);
}
