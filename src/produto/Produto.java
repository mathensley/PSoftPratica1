package produto;

public class Produto {
	
	private int id;
	private String nome;
	private String fabricante;
	private String data;
	private Double preco;
	
	public Produto(int id, String nome, String fabricante, String data, Double preco) {
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.data = data;
		this.preco = preco;
	}

}
