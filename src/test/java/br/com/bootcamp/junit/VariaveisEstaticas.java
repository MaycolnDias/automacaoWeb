package br.com.bootcamp.junit;

public class VariaveisEstaticas {

	private static String email;
	private static String password;
	private static String nome;
	
	public static String getNome() {
		return nome;
	}
	
	public static void setNome(String nome) {
		VariaveisEstaticas.nome = nome;
	}
	
	public static String getEmail() {
		return email;
	}
	
	public static void setEmail(String email) {
		VariaveisEstaticas.email = email;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		VariaveisEstaticas.password = password;
	}

}
