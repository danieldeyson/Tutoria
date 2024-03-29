package com.projeto.negocios;

import com.projeto.exception.ArquivoInexistenteException;

public class Arquivo {

	private String nome;
	private String IdArquivo;

	public Arquivo(String nome, String idArquivo) {
		super();
		this.nome = nome;
		IdArquivo = idArquivo;
		if (nome == null && idArquivo == null) {
			throw new ArquivoInexistenteException("Arquivo nao pode ser nula!");
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdArquivo() {
		return IdArquivo;
	}

	public void setIdArquivo(String idArquivo) {
		IdArquivo = idArquivo;
	}

}
