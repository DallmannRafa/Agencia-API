package com.agencia.api.service;

import com.agencia.api.model.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DestinoService {
    private final List<Destino> destinos = new ArrayList<>();
    private Long proximoId = 1L;

    // Cadastrar um novo destino
    public Destino cadastrarDestino(Destino destino) {
        destino.setId(proximoId++);
        destinos.add(destino);
        return destino;
    }

    // Listar todos os destinos
    public List<Destino> listarDestinos() {
        return destinos;
    }

    // Buscar destino por ID
    public Optional<Destino> buscarPorId(Long id) {
        return destinos.stream().filter(destino -> destino.getId().equals(id)).findFirst();
    }

    // Pesquisar destinos por nome ou localização
    public List<Destino> pesquisarPorTermo(String termo) {
        List<Destino> resultados = new ArrayList<>();
        for (Destino destino : destinos) {
            if (destino.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                    destino.getLocalizacao().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(destino);
            }
        }
        return resultados;
    }

    // Avaliar um destino
    public boolean avaliarDestino(Long id, double nota) {
        Optional<Destino> destinoOptional = buscarPorId(id);
        if (destinoOptional.isPresent()) {
            Destino destino = destinoOptional.get();
            double notaTotal = destino.getNotaMedia() * destino.getQuantidadeAvaliacoes();
            destino.setQuantidadeAvaliacoes(destino.getQuantidadeAvaliacoes() + 1);
            destino.setNotaMedia((notaTotal + nota) / destino.getQuantidadeAvaliacoes());
            return true;
        }
        return false;
    }

    // Excluir um destino
    public boolean excluirDestino(Long id) {
        return destinos.removeIf(destino -> destino.getId().equals(id));
    }
}
