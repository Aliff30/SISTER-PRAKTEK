/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alif.matakuliah.service;

import com.alif.matakuliah.entity.Matakuliah;
import com.alif.matakuliah.repository.MatakuliahRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class MatakuliahService {
    @Autowired
    private MatakuliahRepository matakuliahRepository;
    
    public void insert(Matakuliah matakuliah){
        Optional<Matakuliah> mhsOptional = matakuliahRepository.findMatakuliahByKode(matakuliah.getKode());
        if (mhsOptional.isPresent()) {
            throw new IllegalStateException("Matakuliah sudah ada");
        }
        matakuliahRepository.save(matakuliah);
    }
    
    public List<Matakuliah> getAll(){
        return matakuliahRepository.findAll();
    }
    
    public Matakuliah getMatakuliahById(Long id){
        return matakuliahRepository.findById(id).get();
    }

    public void delete(Long id) {
        matakuliahRepository.deleteById(id);
    }
    
    @Transactional
    public void update(long id, String kode, String nama, Integer sks, Integer semester) {
        Matakuliah matakuliah = matakuliahRepository.findById(id).orElseThrow(() -> new IllegalStateException("Matakuliah Tidak Ada"));
        
        if (nama != null && nama.length() > 0 && !Objects.equals(matakuliah.getNama(), nama)) {
            matakuliah.setNama(nama);
            
        }
        if (kode != null && kode.length() > 0 && !Objects.equals(matakuliah.getKode(), kode)) {
            Optional<Matakuliah> matkulOptionalkode = matakuliahRepository.findMatakuliahByKode(kode);
            if (matkulOptionalkode.isPresent()) {
                throw new IllegalStateException("Kode ini sudah ada");
            }
            matakuliah.setKode(kode);
            
        }
        if (nama != null && nama.length() > 0 && !Objects.equals(matakuliah.getNama(), nama)) {
            Optional<Matakuliah> matkulOptionalnama = matakuliahRepository.findMatakuliahByNama(nama);
            if (matkulOptionalnama.isPresent()) {
                throw new IllegalStateException("nama matakuliah sudah ada");
            }
            matakuliah.setNama(nama);
        }

        
        if (sks != null && !Objects.equals(matakuliah.getSks(), sks)) {
            matakuliah.setSks(sks);
            
        }
        
        if(semester != null && Objects.equals(matakuliah.getSemester(), semester)){
            int ganjil = 1;
        
        matakuliah.setSemester(ganjil);
        }
        
    }
}
