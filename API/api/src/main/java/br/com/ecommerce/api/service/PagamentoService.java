package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pag) {
        pagamentoRepository = pag;
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento cadastrarPagamento(Pagamento pag) {
        return pagamentoRepository.save(pag);
    }

    // buscar cadastro por id
    public Pagamento buscarPorId(int id) {
        //1. verificar se o pagamento existe
        Pagamento pagamento = buscarPorId(id);
        //2. se nao existir, retorno nulo
        if  (pagamento == null) {
            return null;
        }
        //3. se existir excluo
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }
}
