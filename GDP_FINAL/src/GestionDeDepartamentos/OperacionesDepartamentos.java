package GestionDeDepartamentos;



public interface OperacionesDepartamentos {

	void cargaAutomaticaConAgregacion();

	void cargaAutomaticaConComposcion();

	void mostrarDepartamentos();

	boolean departamentosVacio();

	boolean departamentosLleno();

	int buscaHueco();

	int existeDepartamento(int num);
	
	int buscarDepartamento(String nombreDepartamento); // retorna posición o -1
}
