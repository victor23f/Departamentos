package GestionDeDepartamentos;


public interface OperacionesEmpleados {

	void mostrarEmpleados(Departamento d);

	boolean empleadosVacio(Departamento d);

	boolean empleadosLleno(Departamento d);

	int existeEmpleados(Departamento d, int num);
}
