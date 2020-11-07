package com.basico.vendas.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5915629892770146595L;

    public ResourceNotFoundException(Object id) {
        super("recurso não encontrado Id: " + id);
    }
}
