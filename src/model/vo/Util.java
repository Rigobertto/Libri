package model.vo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
	
	public static String formataData(Calendar data) {
		String d;
		int dia = data.get(Calendar.DATE);
		int mes = data.get(Calendar.MONTH);
		int ano = data.get(Calendar.YEAR);
		
		mes += 1;
		if (dia < 10 && mes < 10)
			d = "0" + dia + "/0" + mes + "/" + ano;
		else if (dia < 10)
			d = "0" + dia + "/" + mes + "/" + ano;
		else if (mes < 10)
			d = dia + "/0" + mes + "/" + ano;
		else 
			d = dia + "/" + mes + "/" + ano;
		
		return d;
	}
	
	public static Calendar formataData(String d) {
		Calendar dataNascimento = new GregorianCalendar();
		
		int dia = Integer.parseInt(d.substring(0, 2));
		int mes = Integer.parseInt(d.substring(3, 5));
		int ano = Integer.parseInt(d.substring(6, 10));
		
		mes -= 1;
		
		if(dia > 0 && dia <= 31 && mes > 0 && mes <= 12)
			if (mes == 2 && dia > 28)
				dataNascimento = null;
			else 
				dataNascimento.set(ano, mes, dia);
		
		return dataNascimento;
	}
	
	public static String formataHora(Calendar hora) {
		int h = hora.get(Calendar.HOUR_OF_DAY);
		int m = hora.get(Calendar.MINUTE);
		
		String r;
		
		if (h < 10 && m < 10)
			r = "0" + h + ":" + "0" + m;
		else if(h < 10)
			r = "0" + h + ":" + m;	
		else if (m < 10)
			r = h + ":" + "0" + m;
		else
			r = h + ":" + m;
		
		return r;
	}
	
	public static Calendar formataHora(String h) {
		Calendar hora = new GregorianCalendar();
		
		int hr = Integer.parseInt(h.substring(0, 2));
		int m = Integer.parseInt(h.substring(3, 5));
		
		if(hr >= 0 && hr <= 24 && m >= 0 && m <= 59) 
			hora.set(1, 1, 1, hr, m, 0);
		else hora = null;
		
		return hora;
		
	}
	
	public static boolean isCPF(String CPF) {
		if(CPF.length() != 14)
			return false;
		else {
			int soma = 0, resto = 0;
			int numeros[] = new int[11];
			
			//transforma o CPF em um vetor de inteiros desconsiderando pontos e tra�os 
			for(int i = 0, j = 0; i < 11; i++) {
				numeros[i] = Character.getNumericValue(CPF.charAt(j));	
				
				if (j == 2 || j == 6 || j == 10)  
					j += 2;
				  else 
					j++;
			}
			
			//testa se todos os d�gitos s�o iguais
			boolean iguais[] = new boolean[10];
			boolean a = false;
			for (int i = 0; i < 10; i++) {
				int j = i + 1;
				
				for (; j < 11; j++) 
					if (numeros[i] == numeros[j])
						a = true;
					else
						a = false;
				
				iguais[i] = a;
			}
			
			for (int i = 0; i < 10; i++)
				if(!iguais[i]) {
					a = false;
					break;
				}
			
			//se forem o CPF � inv�lido
			if (a)
				return false;
			else {
				//teste do primeiro d�gito verificador
				for (int i = 0, j = 10; i < 9; i++, j--)
					soma += numeros[i] * j;
				
				resto = (soma * 10) % 11;
				
				if (resto == 10 || resto == 11)
					resto = 0;
				
				//se for diferente o cpf � inv�lido
				if (resto != numeros[9]) {
					System.out.println("erro 1DV");
					return false;
				} else {
					soma = 0;
					//teste do segundo d�gito verificador
					for (int i = 0, j = 11; i < 10; i++, j--)
						soma += numeros[i] * j;
					
					resto = (soma * 10) % 11;
					
					if (resto == 10 || resto == 11)
						resto = 0;
					
					//se for diferente o cpf � inv�lido
					if (resto != numeros[10])
						return false;
					else
						return true;
				}
			}
		}
	}
	
	public static boolean isISBN13(String isbn) {
		if(isbn.length() != 13) {
			return false;
		} else {
			int numeros[] = new int[13];
			
			for(int i = 0; i < 13; i++) {
				numeros[i] = Character.getNumericValue(isbn.charAt(i));	
			}
			
			int soma = 0, resto = 0, digito_verificador;
			
			for(int i = 0, j = 1; i < 12; i++) {
				soma += numeros[i] * j;
				
				if(j == 1)
					j = 3;
				else
					j = 1;
			}
			
			resto = soma % 10;
			
			if(resto == 0)
				digito_verificador = 0;
			else
				digito_verificador = 10 - resto;
			
			if(numeros[12] == digito_verificador)
				return true;
			else return false;
		}
	}
	
	public static boolean isISBN10(String isbn) {
		if(isbn.length() != 10) {
			return false;
		} else {
			int numeros[] = new int[10];
			
			for(int i = 0; i < 10; i++) {
				if(isbn.charAt(i) == 'X' || isbn.charAt(i) == 'x') {
					numeros[i] = 10;
				} else {
					numeros[i] = Character.getNumericValue(isbn.charAt(i));	
				}
			}
			
			int soma = 0, resto = 0, digito_verificador;
			
			for(int i = 0, j = 10; i < 9; i++) {
				soma += numeros[i] * j;
				j--;
			}
			
			resto = soma % 11;
			digito_verificador = 11 - resto;
			
			if(numeros[9] == digito_verificador)
				return true;
			else return false;
		}
	}
}
