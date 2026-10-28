package br.gov.sp.cps.produtos_soap.endpoint;

import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoRequest;
import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoResponse;
import br.gov.sp.cps.produtos_soap.exception.ProdutoNaoEncontradoException;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdutoEndpoint {

    private static final String NAMESPACE = "http://cps.sp.gov.br/produtos";

    @PayloadRoot(namespace = NAMESPACE, localPart = "consultarProdutoRequest")
    @ResponsePayload
    public ConsultarProdutoResponse consultarProduto(@RequestPayload ConsultarProdutoRequest request) {

        ConsultarProdutoResponse response = new ConsultarProdutoResponse();

        if (request.getCodigo() == 100) { 
            response.setNome("Teclado Mecânico Keychron K2");
            response.setDescricao("Teclado sem fio 75% com switches Gateron Brown e iluminação RGB");
            response.setMarca("Keychron");
            response.setQuantidadeEstoque(15);
            
        } else if (request.getCodigo() == 200) {
            response.setNome("Mouse Sem Fio MX Master 3S");
            response.setDescricao("Mouse ergonômico com sensor de 8000 DPI e rolagem MagSpeed");
            response.setMarca("Logitech");
            response.setQuantidadeEstoque(42);
            
        } else if (request.getCodigo() == 300) {
            response.setNome("Monitor UltraSharp 27 4K");
            response.setDescricao("Monitor IPS Black com hub USB-C e precisão de cores sRGB de 100%");
            response.setMarca("Dell");
            response.setQuantidadeEstoque(8);
            
        } else if (request.getCodigo() == 400) {
            response.setNome("Headset Cloud II Wireless");
            response.setDescricao("Headset gamer com som surround 7.1 e bateria de até 30 horas");
            response.setMarca("HyperX");
            response.setQuantidadeEstoque(23);
            
        } else if (request.getCodigo() == 500) {
            response.setNome("SSD NVMe M.2 990 PRO 2TB");
            response.setDescricao("SSD PCIe 4.0 com velocidade de leitura de até 7450 MB/s");
            response.setMarca("Samsung");
            response.setQuantidadeEstoque(55);

        } else {
            
            throw new ProdutoNaoEncontradoException("O código de produto " + request.getCodigo() + " não foi encontrado no estoque.");
        }

        return response;
    }
}