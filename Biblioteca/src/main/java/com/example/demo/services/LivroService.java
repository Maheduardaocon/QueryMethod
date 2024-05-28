package com.example.demo.services;

import com.example.demo.entities.Livro;
import com.example.demo.repositories.LivroRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository LivroRepository;

    public LivroService(LivroRepository LivroRepository) {
        this.LivroRepository = LivroRepository;

    }
    public List<Livro> getAllLivros() {
		return LivroRepository.findAll();
	}

    public Livro postLivro(Livro Livro) {
        return LivroRepository.save(Livro);
    }

    public Livro getLivroById(Long id) {
        return LivroRepository.findById(id).orElse(null);
    }

    public List<Livro> buscarPorTitulo (String titulo) {
        return LivroRepository.buscarPorTitulo(titulo);
    }
    
    public List<Livro> buscarPorAutor (String autor) {
        return LivroRepository.findByAutor(autor);
    }
    
    public List<Livro> buscarPorNome (String nome) {
        return LivroRepository.findByNome(nome);
    }
    public List<Livro> buscarPorIsbn (String isbn) {
        return LivroRepository.findByIsbn(isbn);
    }
   
    public List<Livro> buscarPorEditora (String editora) {
        return LivroRepository.findByEditora(editora);
    }
}

