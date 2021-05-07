package br.com.proway.senior.escola.model;

/**
 * A avalição do desempenho do Aluno em uma Materia.
 * 
 * A prova registra uma avalição realizada pelo {@link Aluno} relativo ao
 * conhecimento de uma matéria. O {@link Aluno} poderá realizar várias
 * avaliações da mesma a matéria. A média ponderada das notas das Provas é
 * registrada no {@link Boletim} e verifica se o aluno foi aprovado.
 * 
 * @author ricardo.goncalves
 * @see Aluno
 * @see Boletim
 *
 */
public class Prova {

	private Integer periodo;
	private Aluno aluno;
	private Materia materia;
	private Double nota;
	
	/**
	 * Avaliação de desempenho do aluno
	 * 
	 * No construtor da prova não atribui-se valor para a nota para que seja
	 * possível a criação de provas para depois serem atribuídas as notas
	 * 
	 * @param periodo Periodo no formato YYYYMM
	 * @param aluno Aluno que realizou a prova
	 * @param materia Materia da prova
	 */
	public Prova(Integer periodo, Aluno aluno, Materia materia) {
		this.periodo = periodo;
		this.aluno = aluno;
		this.materia = materia;
	}
	
	
	/**
	 * Valor da avalia��o do aluno.
	 */
	public Double getNota() {
		return nota;
	}
	
	/**
	 * Determina a avaliação do aluno.
	 * 
	 * Não pode ser menor que 0 nem maior do que o atributo Materia.notaMaxima.
	 * 
	 * @param nota
	 */
	public void setNota(Double nota) throws Exception {
		if(nota < 0 || nota > this.materia.notaMaxima) {
			throw new Exception("Valor da nota inválido.");
		}
		this.nota = nota;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Materia getMateria() {
		return materia;
	}


	
}
