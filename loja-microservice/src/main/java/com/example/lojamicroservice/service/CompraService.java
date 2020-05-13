package com.example.lojamicroservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lojamicroservice.client.FornecedorClient;
import com.example.lojamicroservice.dto.CompraDTO;
import com.example.lojamicroservice.dto.InfoFornecedorDTO;
import com.example.lojamicroservice.dto.InfoPedidoDTO;
import com.example.lojamicroservice.model.Compra;

@Service
public class CompraService {
	
	public static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
    public Compra realizaCompra(CompraDTO compra) {	
    	final String estado = compra.getEndereco().getEstado();
    	
    	LOG.info("Buscando informações do fornecedor de {}", estado);
    	InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
    	LOG.info("Realizando um pedido");
    	InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
    	
    	System.out.println(info.getEndereco());
    	
    	Compra compraSalva = new Compra();
    	compraSalva.setPedidoId(pedido.getId());
    	compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
    	compraSalva.setEnderecoDestino(compra.getEndereco().toString());
    	return compraSalva;
    }
    
    
}
