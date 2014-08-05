package com.projeto.facade;

import java.util.LinkedList;
import java.util.List;

import com.projeto.arquivos.Aluno;
import com.projeto.arquivos.Arquivo;
import com.projeto.arquivos.Aula;
import com.projeto.arquivos.GrupoDiscursao;
import com.projeto.arquivos.Tutor;
import com.projeto.exception.AlunoExistenteException;
import com.projeto.exception.AlunoInexistenteException;
import com.projeto.exception.ArquivoInexistenteException;
import com.projeto.exception.ExcecaoAlunoDuplicado;
import com.projeto.exception.ExcecaoIllegalArgumentException;
import com.projeto.exception.ExcecaoTutorDuplicado;
import com.projeto.exception.GrupoDiscursaoJaexisteException;
import com.projeto.exception.GrupoInexistenteException;
import com.projeto.exception.GrupoJaexisteException;
import com.projeto.exception.TutorExistenteException;
import com.projeto.exception.TutorInexistenteException;

public class GestorAuxiliarParaSistema {

	private List<Tutor> tutores;
	private List<Aluno> alunos;  
	private List<Aula> aulas = new LinkedList<Aula>();
	private List<GrupoDiscursao> grupos = new LinkedList<GrupoDiscursao>();
	private List<Arquivo> arquivos = new LinkedList<Arquivo>();
	
	public  GestorAuxiliarParaSistema(){
	
		tutores = new LinkedList<Tutor>();
		alunos = new LinkedList<Aluno>();
	}
	
	public boolean finalizou() {
		return false;
	}

	public void cadastraTutor(Tutor tutorNovo) throws Exception {
		boolean existe = false;
		for (Tutor tutorAntigo : this.tutores) {
			if (tutorAntigo.getMatricula().equals(tutorNovo.getMatricula()) || tutorAntigo.getNome().equals(tutorNovo.getNome())) {
				existe = true;
				throw new ExcecaoTutorDuplicado();
			}
		}
		if (existe == false) {
			this.tutores.add(tutorNovo);
		} else {
			throw new TutorExistenteException("Tutor Existente");
		}
	}

	public Tutor pesquisarTutorPeloId(String id)
			throws TutorInexistenteException {
		for (Tutor t : this.tutores) {
			if (t.getMatricula().equals(id)) {
				return t;
			}
		}
		throw new TutorInexistenteException("Tutor Inexistente");
	}

	public void removeTutorPeloId(String id) throws TutorInexistenteException {
		boolean removeu = false;
		for (Tutor t : this.tutores) {
			if (t.getMatricula().equals(id)) {
				this.tutores.remove(t);
				removeu = true;
				break;
			}
		}

		if (removeu == false) {
			throw new TutorInexistenteException("Tutor n�o existe!");
		}
	}

	// Aluno

	public void cadastrarAluno(Aluno alunos) throws ExcecaoIllegalArgumentException{
		boolean existe = false;
		for (Aluno aluno : this.alunos) {
			
			
			if (aluno.getMatricula().equals(aluno.getMatricula())) {
				existe = true;
				throw new ExcecaoAlunoDuplicado();
			}
		}

		if (existe == false) {
			this.alunos.add(alunos);
		} else {
			throw new AlunoExistenteException("Aluno Existente!");
		}// throw new ExcecaoAlunoDuplicado();

	}

	public Aluno pesquisaAlunoPeloNome(String nome)
			throws AlunoInexistenteException {
		for (Aluno alu : this.alunos) {
			if (alu.getNome().equals(nome)) {
				return alu;
			}
		}
		throw new AlunoInexistenteException("Aluno Inexistente");
	}

	public Aluno pesquisarAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		for (Aluno aluno1 : this.alunos) {
			if (aluno1.getMatricula().equals(matricula)) {
				return aluno1;
			}
		}
		throw new AlunoInexistenteException("Aluno Inexistente");
	}

	public void removerAlunoPelaMatricula(String matricula) {
		boolean removeu = false;
		for (Aluno a : this.alunos) {
			if (a.getMatricula().equals(matricula)) {
				this.alunos.remove(a);
				removeu = true;
				break;
			}
		}
		if (removeu == false) {
			throw new AlunoInexistenteException("Aluno n�o existe!");
		}

	}

	public List<Aluno> getListaDeAlunosCadastrados() {

		return alunos;
	}

	public List<GrupoDiscursao> getListaDeGruposNoForum() {
		return this.grupos;
	}

	public List<Tutor> getListaDeTutores() {

		return tutores;
	}

	public void cadastrarAula(Aula aula) {
		this.aulas.add(aula);

	}

	public List<Aula> getListaDeAulasCadastradas() {

		return aulas;
	}

	public void cadastrarArquivos(Arquivo arquivo) {
		this.arquivos.add(arquivo);

	}

	public List<Aula> getListaDeAulasCadastradasPorGrupo(GrupoDiscursao gd1) {

		return aulas;
	}

	public List<Arquivo> getListaDeArquivos() {

		return arquivos;
	}

	public void removerAulaDoGrupoDiscursao(Aula a1, GrupoDiscursao gd1) {
		this.aulas.remove(0).getIdAula();

	}

	public void cadastrarGrupoDiscursao(GrupoDiscursao grupod)
			throws GrupoJaexisteException {
		boolean existe = false;

		for (GrupoDiscursao g : this.grupos) {
			if (g.getiDGrupo().equals(grupod.getiDGrupo())) {
				throw new GrupoDiscursaoJaexisteException();
				// existe = true;
			}
		}
		if (!existe) {
			this.grupos.add(grupod);
		} else {
			throw new GrupoJaexisteException("Erro de iD");
		}
	}

	public GrupoDiscursao pesquisarGrupo(String iDcodigo)
			throws GrupoInexistenteException {
		for (GrupoDiscursao g : this.grupos) {
			if (g.getiDGrupo().equals(iDcodigo)) {
				return g;
			}
		}
		throw new GrupoInexistenteException("Grupo Inexistente!");

	}

	public void adicionarAulaAoGrupo(Aula aula, GrupoDiscursao gd) {
		gd.addAula(aula);

	}

	public Aula pesquisaAula(String iDAul) {
		for (Aula aa : this.aulas) {
			if (aa.getIdAula().equals(iDAul)) {
				return aa;
			}
		}
		return null;
	}

	public void removerAula(String iDAula) {
		boolean removeu = false;
		for (Aula a : this.aulas) {
			if (a.getIdAula().equals(iDAula)) {
				this.aulas.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new RuntimeException("ERRO!");
		}
	}

	public void removerArquivo(String iDArquivo)
			throws ArquivoInexistenteException {
		boolean removeu = false;
		for (Arquivo a : this.arquivos) {
			if (a.getIdArquivo().equals(iDArquivo)) {
				this.aulas.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new ArquivoInexistenteException("");
		}

	}

	public Arquivo removerArquivoPeloNome(String nome) {
		for (Arquivo a : this.arquivos) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		throw new ArquivoInexistenteException("Arquivo Nao Existe");
	}

	public Arquivo pesquisarArquivos(String iDArquivo)
			throws ArquivoInexistenteException {
		for (Arquivo arquivo : this.arquivos) {
			if (arquivo.getIdArquivo().equals(iDArquivo)) {
				return arquivo;
			}
		}
		throw new ArquivoInexistenteException("iDArquivo Inexistente");
	}

}