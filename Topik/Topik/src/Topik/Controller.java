package Topik;

import java.util.Scanner;


public class Controller {
	public static void switchCase (Topik topik) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserir");
		System.out.println("show");
		System.out.println("exit");
		String opcao = scanner.next();
		while(true){
		  if(opcao.equals("show")){
              System.out.println(topik);
              switchCase(topik);
              break;
          }else if(opcao.equals("inserir")){
          	System.out.println("Digite o id: ");
          	String id = scanner.next();
          	System.out.println("Digite a idade: ");
          	int idade = scanner.nextInt();
          	topik.inserir(id, idade);
          	switchCase(topik);
          	break;
          }else if(opcao.equals("exit")){
        	  break;
		 }else{
              System.out.println("fail: comando invalido");
              switchCase(topik);
              break;
          }
		}
		
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a capacidade do transporte: ");
        int capacidade = scanner.nextInt();
        System.out.println("Digite a quantidade assentos prioritários: ");
        int prioridade = scanner.nextInt();
        Topik topik = new Topik (capacidade, prioridade);
        switchCase(topik);
      
    }
}