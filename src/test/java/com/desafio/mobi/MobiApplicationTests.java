package com.desafio.mobi;

import java.util.List;
import java.util.Optional;

import com.desafio.mobi.model.Pedido;
import com.desafio.mobi.repository.PedidoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MobiApplicationTests {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Test
	void teste1() {

		for(int x = 1; x <= 100; x++ ){

			System.out.print(x + " " );
			
			if (x % 3 == 0 && x % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if(x % 3 == 0){
				System.out.println("Fizz");
			} else if(x % 5 == 0){
				System.out.println("Buzz");
			} else {
				System.out.println();
			}
		}
	}

	@Test
	void test2() {

		String[] estrelas = new String[4];

		estrelas[0] = "[*--]";
		estrelas[1] = "[---]";
		estrelas[2] = "[**-]";
		estrelas[3] = "[***]";

		int contadorEstrelas = 0;
		for (String string : estrelas) {

			string = string.replaceAll("\\[", "").replaceAll("\\]", "");

			if(string.equals("*--")) {
				contadorEstrelas++;
			} else if (string.equals("**-")) {
				contadorEstrelas += 2;
			} else if (string.equals("***")) {
				contadorEstrelas += 3;
			}		
		}

		System.out.println("Marvin tem " + contadorEstrelas);
	}

	@Test
	void test3() {

		String[] momentoTempo = new String[3];
		 momentoTempo[0] = "11:00";
		 momentoTempo[1] = "13:13";
		 momentoTempo[2] = "10:00";

		 for (String tempo : momentoTempo) {

			System.out.print(tempo);

			if (tempo.charAt(0) == tempo.charAt(3) && tempo.charAt(1) == tempo.charAt(4) ||
				tempo.charAt(0) == tempo.charAt(1) && tempo.charAt(3) == tempo.charAt(4) ||
				tempo.charAt(0) == tempo.charAt(4) && tempo.charAt(1) == tempo.charAt(3) ||
				tempo.charAt(0) == tempo.charAt(1) && tempo.charAt(0) == tempo.charAt(3) && tempo.charAt(0) == tempo.charAt(4) ) {
				System.out.println(" 2");
			}			 
		 }

	}

	@Test
	void test4() {

		int numeroEquipes = 3;

		int[] vitoria = new int[]{1,0,3};
		int[] empate = new int[]{2,2,0};

		int[] pontosDasEquipes = new int[numeroEquipes];

		for(int x = 0; x < numeroEquipes; x++){

			pontosDasEquipes[x] = calcularPontosEquipes(vitoria[x], empate[x]);
		}
		
		int contador = 0;
		for (int pontos : pontosDasEquipes) {
			System.out.println("Equipe " + contador +  " total pontos = " + pontos);
			contador++;
		}

	}

	private int calcularPontosEquipes(int vitoria, int empates) {

		int pontosVitoria = vitoria * 3;
		int pontosEmpate = empates * 1;

		return pontosVitoria + pontosEmpate;
	}

	@Test
	void test5() {

		Optional<List<Pedido>> listaPedido = pedidoRepository.findByNome("DeathStar");

		listaPedido.get().forEach(System.out::println);

		List<Pedido> listaPedidoDois = pedidoRepository.buscarListaPedidoPorNome("DeathStar");

		System.out.println();
		listaPedidoDois.forEach(System.out::println);
	}




}
