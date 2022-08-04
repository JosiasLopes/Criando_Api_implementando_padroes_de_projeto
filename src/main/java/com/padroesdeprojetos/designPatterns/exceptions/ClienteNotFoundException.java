package com.padroesdeprojetos.designPatterns.exceptions;

public class ClienteNotFoundException extends RuntimeException{

    private String message = "Não encontrado";
    private long id =0;

    public ClienteNotFoundException(String n){
        this.message = n;
    }

    public ClienteNotFoundException(long id){
        this.message = "O Cliente: "+this.id+" não foi encontrado";
    }

}




