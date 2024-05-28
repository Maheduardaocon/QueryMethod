package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livro;
import com.example.demo.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService service) {
        this.livroService = service;
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.postLivro(livro);
    }
    
    @GetMapping("/")
	public ResponseEntity<List<Livro>> findAllUsuarioscontrol() {
		List<Livro> livro = livroService.getAllLivros();
		return ResponseEntity.ok(livro);
	}

    @GetMapping("/{id}")
    public Livro getLivro(@PathVariable Long id) {
        return livroService.getLivroById(id);
    }

    @GetMapping("/titulo/(titulo)")
    public List<Livro> buscarPorTitulo (@PathVariable String titulo){
        return livroService.buscarPorTitulo(titulo);
    }
    
    @GetMapping("/autor/(autor)")
    public List<Livro> buscarPorAutor (@PathVariable String autor){
        return livroService.buscarPorAutor(autor);

    }    
    @GetMapping("/nome/(nome)")
        public List<Livro> buscarPorNome (@PathVariable String nome){
            return livroService.buscarPorNome(nome); 
    }
    
    @GetMapping("/isbn/(isbn)")
    public List<Livro> buscarPorisbn (@PathVariable String isbn){
        return livroService.buscarPorIsbn(isbn);
}
    @GetMapping("/editora/(editora)")
    public List<Livro> buscarPoreditora (@PathVariable String editora){
        return livroService.buscarPorEditora(editora);
}
}