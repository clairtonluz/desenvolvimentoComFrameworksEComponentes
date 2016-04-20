package br.edu.fa7.model;

public class ErrorInfo {
	public final String url;
    public final String message;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.message = ex.getLocalizedMessage();
    }

}
