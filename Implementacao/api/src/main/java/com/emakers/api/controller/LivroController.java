package com.emakers.api.controller;

import com.emakers.api.data.dto.request.LivroRequestDto;
import com.emakers.api.data.dto.response.LivroResponseDto;
import com.emakers.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LivroResponseDto>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAllLivros());
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroResponseDto> getLivroId(@PathVariable long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getLivroId(idLivro));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LivroResponseDto> createLivro(@RequestBody LivroRequestDto livroRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.createLivro(livroRequestDto));
    }

    @PutMapping(value = "/update/{idLivro}")
    public ResponseEntity<LivroResponseDto> updateLivro(@PathVariable long idLivro, @RequestBody LivroRequestDto livroRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateLivro(idLivro, livroRequestDto));
    }

    @DeleteMapping(value = "/delete/{idLivro}")
    public ResponseEntity<String> deleteLivro(@PathVariable long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteLivro(idLivro));
    }
}