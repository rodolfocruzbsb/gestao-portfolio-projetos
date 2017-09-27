package br.com.rscruz.springmvc.utils;

public final class InitPrintter {

	public static void print(){
		final StringBuilder textToPrint = new StringBuilder();
		textToPrint.append("  ____                             ____  _             _           _ ").append("\n");
		textToPrint.append(" / ___|  ___ _ ____   _____ _ __  / ___|| |_ __ _ _ __| |_ ___  __| |").append("\n");
		textToPrint.append(" \\___ \\ / _ \\ '__\\ \\ / / _ \\ '__| \\___ \\| __/ _` | '__| __/ _ \\/ _` |").append("\n");
		textToPrint.append("  ___) |  __/ |   \\ V /  __/ |     ___) | || (_| | |  | ||  __/ (_| |").append("\n");
		textToPrint.append(" |____/ \\___|_|    \\_/ \\___|_|    |____/ \\__\\__,_|_|   \\__\\___|\\__,_|").append("\n");
		System.out.println(textToPrint);
	}
	
	public static void main(String[] args) {

		InitPrintter.print();
	}
	
}
