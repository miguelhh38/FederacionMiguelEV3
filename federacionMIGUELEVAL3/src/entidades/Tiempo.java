package entidades;

public class Tiempo {
	private long num_horas;
	private long num_minutos;
	private long num_segundos;
	private long num_centesimas;

	public Tiempo() {
	}

	public Tiempo(long num_horas, long num_minutos, long num_segundos, long num_centesimas) {
		this.num_horas = num_horas;
		this.num_minutos = num_minutos;
		this.num_segundos = num_segundos;
		this.num_centesimas = num_centesimas;

	}

	public long getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(long num_horas) {
		this.num_horas = num_horas;
	}

	public long getNum_minutos() {
		return num_minutos;
	}

	public void setNum_minutos(long num_minutos) {
		this.num_minutos = num_minutos;
	}

	public long getNum_segundos() {
		return num_segundos;
	}

	public void setNum_segundos(long num_segundos) {
		this.num_segundos = num_segundos;
	}

	public long getNum_centesimas() {
		return num_centesimas;
	}

	public void setNum_centesimas(long num_centesimas) {
		this.num_centesimas = num_centesimas;
	}

	@Override
	public String toString() {
		return "Tiempo [horas=" + num_horas + ", minutos=" + num_minutos + ", segundos=" + num_segundos
				+ ", centesimas=" + num_centesimas + "]";
	}

}
