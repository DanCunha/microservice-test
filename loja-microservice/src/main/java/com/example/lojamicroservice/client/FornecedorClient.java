package com.example.lojamicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.lojamicroservice.dto.InfoFornecedorDTO;
import com.example.lojamicroservice.dto.InfoPedidoDTO;
import com.example.lojamicroservice.dto.ItemCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItemCompraDTO> itens);
}
