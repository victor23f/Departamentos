package GestionDeDepartamentos;


import java.time.LocalDate;


public class Empleado extends Departamento{
	private  int numeroEmpleado;
	private  String nombre;
	private  String apellido;
	private  String oficio;
	private  LocalDate fecha;
	private  Double salario;
	private Departamento numeroDepartamento;
	
	
	
	public Empleado() {

	}
	
	
	public Empleado(int numeroEmpleado,String nombre, String apellido, String oficio, double salario,
			Departamento numeroDepartamento, LocalDate fecha) {

			this.numeroEmpleado = numeroEmpleado;
			this.nombre = nombre;
			this.apellido =apellido;
			this.oficio = oficio;
			this.salario = salario;
			this.numeroDepartamento = numeroDepartamento;
			this.fecha=fecha;
			
	}
@Override
	public String toString() {
		return "Empleado [numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", oficio=" + oficio
				+ ", salario=" + salario + ", comision=" + ", numeroDepartamento= " + numeroDepartamento
				+ ", fechaAlta=" + fecha + "]";
		
	}

	public void mostrarEmpleados() {
		System.out.println("EMPLEADO Nº: " + getNumeroEmpleado());
		System.out.println("    -------NOMBRE: " + getNombreEmpleado() + " | " + "Apellido:" + getApellido() + " | "  + "Fecha De Alta: " + getFecha() + " | "  + "Salario: " + getSalario() + " | " );
		
	}
public int getNumeroEmpleado() {
	return numeroEmpleado;
}
public void setNumeroEmpleado(int numeroEmpleado) {
	this.numeroEmpleado = numeroEmpleado;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getOficio() {
	return oficio;
}
public String getNombreEmpleado() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setOficio(String oficio) {
	this.oficio = oficio;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}
public Double getSalario() {
	return salario;
}
public void setSalario(Double salario) {
	this.salario = salario;
}

public Departamento getNumeroDepartamento() {
	return numeroDepartamento;
}
public void setNumeroDepartamento(Departamento numeroDepartamento) {
	this.numeroDepartamento = numeroDepartamento;
}

public void setComision(Empleado comision) {
	
}
public void getComision(Empleado comision) {
	
}

}
