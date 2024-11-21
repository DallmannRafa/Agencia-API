package com.agencia.api.controller;

import com.agencia.api.dto.DestinoDTO;
import com.agencia.api.model.Destino;
import com.agencia.api.service.DestinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {
    private final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    // Endpoint para cadastrar um destino
    @PostMapping
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody DestinoDTO destinoDTO) {
        Destino destino = new Destino(null, destinoDTO.getNome(), destinoDTO.getLocalizacao(), destinoDTO.getDescricao());
        Destino novoDestino = destinoService.cadastrarDestino(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDestino);
    }

    // Endpoint para listar todos os destinos
    @GetMapping
    public ResponseEntity<List<Destino>> listarDestinos() {
        return ResponseEntity.ok(destinoService.listarDestinos());
    }

    // Endpoint para pesquisar destinos
    @GetMapping("/pesquisa")
    public ResponseEntity<List<Destino>> pesquisarDestinos(@RequestParam String termo) {
        return ResponseEntity.ok(destinoService.pesquisarPorTermo(termo));
    }

    // Endpoint para visualizar informações detalhadas de um destino
    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarDestinoPorId(@PathVariable Long id) {
        return destinoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para avaliar um destino
    @PatchMapping("/{id}/avaliar")
    public ResponseEntity<Void> avaliarDestino(@PathVariable Long id, @RequestParam double nota) {
        if (destinoService.avaliarDestino(id, nota)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Endpoint para excluir um destino
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDestino(@PathVariable Long id) {
        if (destinoService.excluirDestino(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
