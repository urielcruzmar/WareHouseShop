package com.en.ws.enums;

public enum VAT {

	SUPERREDUCTED(1.04), REDUCTED(1.10), GENERAL(1.21);
	
	private double percentaje;

	private VAT(double percentaje) {
		this.percentaje = percentaje;
	}

	public double getPercentaje() {
		return percentaje;
	}
	
}
