package tigo.bsd.com;
import tigo.bsd.com.consulta;
public class ConsultaServicioImpl implements ServicioConsulta{

	
	@Override
	public String Sumar(consulta p) {
	int Resultado =  p.getValor1()+p.getValor2();
		return "Hola "+p.getNombre()+" el resultado es " + Resultado;
	}
}
