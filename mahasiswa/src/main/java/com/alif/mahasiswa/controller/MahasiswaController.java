/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alif.mahasiswa.controller;

import com.alif.mahasiswa.entity.Mahasiswa;
import com.alif.mahasiswa.service.MahasiswaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */

@RestController
@RequestMapping("api/v1/mahasiswa")
public class MahasiswaController {
     @Autowired
    public MahasiswaService mahasiswaService;
    
    @GetMapping
    public List<Mahasiswa> getAll(){
        return mahasiswaService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Mahasiswa getMahasiswaById(@PathVariable("id")Long id){
        return mahasiswaService.getMahasiswaById(id);
    }
    
    @PostMapping
    public void insert(@RequestBody Mahasiswa mahasiswa){
        mahasiswaService.insert(mahasiswa);
    }
    
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id")Long id){
        mahasiswaService.delete(id);
    }
    
    @PutMapping(path = "{id}")
    public void update (@PathVariable("id") Long id,
            @RequestParam(required = false)String nama,
            @RequestParam(required = false)String email,
            @RequestParam(required = false)LocalDate tgllahir) {
        mahasiswaService.update(id, nama, email, tgllahir);
    }
}
