package com.projeto.arquivos;

import com.projeto.exception.ExcecaoIllegalArgumentException;

public class Arquivo {

	private String nome;
	private String IdArquivo;

	public Arquivo(String nome, String idArquivo) {
		super();
		this.nome = nome;
		IdArquivo = idArquivo;
		if (nome == null && idArquivo == null) {
			throw new ExcecaoIllegalArgumentException(
					"Aula nao pode ser nula!");
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