package module;
import java.util.*;

public class Investigador {

	private List<Interes> intereses;
	private String email;
	private MailSender mailSender;
	
	public Investigador(String email) {
		this.intereses = new ArrayList<>();
		this.email = email;
		this.mailSender = new MailSender();
	}
	
	public void agregarInteres(Interes interes) {
		
		this.getIntereses().add(interes);
	}

	public void update(Articulo articulo) {
		
		if(this.esDeInteresDeInvestigador(articulo)) {
			this.getMailSender().enviarMail(this.getEmail(), articulo);
		}
		
		
	}

	private boolean esDeInteresDeInvestigador(Articulo articulo) {
		// TODO Auto-generated method stub
		return 	this.getIntereses()
					.stream()
					.anyMatch( i -> i.esDeInteres(articulo));
	}

	public List<Interes> getIntereses() {
		// TODO Auto-generated method stub
		return this.intereses;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	public MailSender getMailSender() {
		// TODO Auto-generated method stub
		return this.mailSender;
	}

}