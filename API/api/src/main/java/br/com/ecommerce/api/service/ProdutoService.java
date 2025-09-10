package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository prod) {
        produtoRepository = prod;
    }

    public List<Produto> ListarTodos() {
        return produtoRepository.findAll();
    }

    public Produto cadastroProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    // buscar por id
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto deleteProduto(Integer id) {
        //1. verificar se o cliente existe
        Produto produto = buscarPorId(id);
        //2. se nao existir, retorno nulo
        if (produto == null) {
            return null;
        }
        //3. se existir excluo
        produtoRepository.delete(produto);
        return produto;
    }
}
