package com.mycompany.varejo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class ConfigBD {
	private static String d;

	public static String base() {
		d = lerArquivo();
		return d;
	}

	public static String lerArquivo() {
		String conteudo = "";
		try {
			FileReader arquivo = new FileReader("C:\\easypdv\\pdvbd.ini");
			BufferedReader lerArq = new BufferedReader(arquivo);
			String linha = "";
			linha = lerArq.readLine();
			while (linha != null) {
				conteudo += linha;
				linha = lerArq.readLine();
			}
			arquivo.close();
		} catch (Exception e) {
			criarConfig();
		}
		System.out.println(conteudo);
		return conteudo;
	}

	public static File criarConfig() {
		File arq = null;
		try {
			arq = new File("C:\\easypdv", "pdvbd.ini");
			if (!arq.exists()) {
				String texto = JOptionPane.showInputDialog("digite o ip do banco de dados");
				BufferedWriter bf = new BufferedWriter(new FileWriter(arq));
				bf.write(texto);
				bf.flush();
				bf.close();
				System.out.println("Arquivo gravado com sucesso");
			} else {
				String valor = JOptionPane.showInputDialog("Digite novo endereço do banco!!");
				arq = new File("C:\\easypdv", "pdvbd.ini");
				BufferedWriter bf = new BufferedWriter(new FileWriter(arq));
				bf.write(valor);
				bf.flush();
				bf.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arq;
	}

	public static void sobrescreverArquivo(String texto) {
		File arq = null;
		try {
			arq = new File("C:\\easypdv", "pdvbd.ini");
			BufferedWriter bf = new BufferedWriter(new FileWriter(arq));
			bf.write(texto);
			bf.flush();
			bf.close();
			System.out.println("Arquivo gravado com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String getD() {
		return d;
	}

	public static void setD(String d) {
		ConfigBD.d = d;
	}
}
