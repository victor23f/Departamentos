package GestionDeDepartamentos;

import java.time.LocalDate;


public class Director extends Empleado {
	
	private double comision;
	
	public Director() {
		super();
		
	}

	public Director(int numeroEmpleado, String nombre, String apellido, String oficio, double salario,
			Departamento numeroDepartamento, LocalDate fecha, double comision) {
		super(numeroEmpleado, nombre, apellido, oficio, salario, numeroDepartamento, fecha);
		this.comision = comision;
		
	}
	
	public Empleado comisionHaciaEmpleado(Director r1) {
		
		r1.getComision();
		
		return (Empleado) r1;
	}
	

public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}

}
