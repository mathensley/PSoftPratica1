package repositorios;

import java.util.HashMap;
import java.util.Map;

import produto.Produto;

public class Repositorio {
	
	private Map<Integer, Produto> mp;
	
	public Repositorio() {
		this.mp = new HashMap<>();
	}
	
	public void addProduto(Produto prod, int id) {
		this.mp.put(id, prod);
	}

}
