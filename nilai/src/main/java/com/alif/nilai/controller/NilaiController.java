/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alif.nilai.controller;

import com.alif.nilai.entity.Nilai;
import com.alif.nilai.service.NilaiService;
import com.alif.nilai.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("api/v1/nilai")
public class NilaiController {
    @Autowired
    private NilaiService nilaiService;
    
    @GetMapping
    public List<Nilai> getAll(){
        return nilaiService.getAll();
    }
    
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        nilaiService.delete(id);
    }
    
    @PostMapping()
    public void insert(@RequestBody Nilai nilai){
        nilaiService.insert(nilai);
    }
    
    @GetMapping(path = "{id}")
    public ResponseTemplate getMahasiswaById(@PathVariable("id") Long id){
        return nilaiService.getNilaiById(id);
    }
    
}
