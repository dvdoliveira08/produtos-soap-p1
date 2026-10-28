package br.gov.sp.cps.produtos_soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, faultStringOrReason = "Produto não encontrado no estoque")
public class ProdutoNaoEncontradoException extends RuntimeException {
    
    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}