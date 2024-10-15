package junit_gradle_empty;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTeste {
	
	@Test
	public void deveCalcularIdadeCorretamente() {
		Pessoa pessoa = new Pessoa("Jessica", LocalDateTime.of(2000, 11, 3, 8, 30, 54));
		Assertions.assertEquals(23, pessoa.getIdade());
	}
	
	@Test void deveRetornarSeEhMaiorDeIdade() {
		Pessoa pessoa = new Pessoa("Marcos", LocalDateTime.now().minusYears(33));
		Assertions.assertTrue(pessoa.ehMaiorDeIdade());
		
		//retorna false
		Pessoa pessoa1 = new Pessoa("Padilho", LocalDateTime.now());
		Assertions.assertFalse(pessoa1.ehMaiorDeIdade());
	}

}
