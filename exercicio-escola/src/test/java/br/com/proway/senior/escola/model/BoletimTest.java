package br.com.proway.senior.escola.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BoletimTest{
	
	static Boletim boletim ;
	private static int periodoPadrao= 202105;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		boletim = new Boletim(aluno, periodo);
	}

	@Test
	public void testBoletim() {
		assertNotNull(boletim);
	}

	@Test
	public void testGetAluno() {
		assertNotNull(boletim.getAluno());
	}

	@Test
	public void testGetPeriodo() {
		assertEquals(periodoPadrao, (int) boletim.getPeriodo());
	}

	@Test
	public void testCalcularMedia() {
		boletim.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova1 = new Prova(periodoPadrao, boletim.getAluno(), materia);
		Prova prova2 = new Prova(periodoPadrao, boletim.getAluno(), materia);
		Prova prova3 = new Prova(periodoPadrao, boletim.getAluno(), materia);
		try {
			prova1.setNota(10.0);
			prova2.setNota(09.0);
			prova3.setNota(08.0);
			boletim.calcularMedia();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		boletim.addProva(prova1);
		boletim.addProva(prova2);
		boletim.addProva(prova3);
		assertEquals(9.0, (Double)boletim.getMedia(), 0.1);
	}

	@Test
	public void testAddProva() {
		Prova prova;
		int periodoParam = 202105;
		
		Integer periodo = periodoParam;
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		prova = new Prova(periodo, aluno, materia);

		assertEquals(1, boletim.getProvas().size());
	}

	@Test
	public void testRemoveProva() {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		boletim.removeTodasProvas();
		boletim.addProva(prova);
		boletim.addProva(prova);
		boletim.removeProva(0);
		assertEquals(1, boletim.getProvas().size());
			}
	
	@Test
	public void testRemoveTodasProvas() {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		boletim.addProva(prova);
		boletim.removeTodasProvas();
		assertFalse(boletim.getProvas().size() > 0);
	}

}
