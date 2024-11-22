package module;

public enum Interes {
	
	TITULO{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres.getTitulo().equals(this.getValor());
		}

	},AUTORES{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres
					.getAutores()
					.stream()
					.anyMatch( a -> a.equals(this.getValor()));
		}
	},FILIACIONES{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres
					.getFiliaciones()
					.stream()
					.anyMatch( a -> a.equals(this.getValor()));
		}
	},TIPO{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres.getTipo().equals(this.getValor());
		}
	},LUGAR{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres.getLugarDePublicacion().equals(this.getValor());
		}
	},PALABRASCLAVE{
		@Override
		public boolean esDeInteres(Articulo articuloDeInteres) {
			return articuloDeInteres
					.getPalabrasClave()
					.stream()
					.anyMatch( a -> a.equals(this.getValor()));
		}
	};
	
	private String valor; 
	
	public abstract boolean esDeInteres(Articulo articuloDeInteres);
	
	public void setValor(String valor) {
		// TODO Auto-generated method stub
		this.valor = valor;
	}
	
	public String getValor() {
		
		return this.valor;
	}

}
