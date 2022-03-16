package GestionDeDepartamentos;



public class Departamento{

	private  String nombre, localizacion;
	private Empleado[] listaEmpleados;
	private int TAM = 2;
	private int dept_no;
	private int numeroEmpleados = 0;
	private int numeroInsercciones = 0;
	
	
	  public Departamento(int dept_no, String nombre, String localizacion) {
		    
		    this.dept_no = dept_no;
		    this.nombre = nombre;
		    this.localizacion = localizacion;
		    this.listaEmpleados = new Empleado[TAM];  
		    
		}
	  
	  
	public Departamento(int dept_no, String nombre, String localizacion, Empleado[] listaEmpleados) {
	    
	    this.dept_no = dept_no;
	    this.nombre = nombre;
	    this.localizacion = localizacion;
	    this.listaEmpleados = new Empleado[TAM];
	    this.listaEmpleados = listaEmpleados;
	    
	}
	
	
	  public int getNumeroEmpleados() {
		return numeroEmpleados;
	}



	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}



	public int getNumeroInserciones() {
		return numeroInsercciones;
	}



	public void setNumeroInsercciones(int numeroInseccionesEmpleados) {
		this.numeroInsercciones = numeroInseccionesEmpleados;
	}



	public void setEmpleados(Empleado[] empleados) {
		this.listaEmpleados = empleados;
	}



	public Departamento() {
	  
	  }
	  
	
	  


	
	public String getNombre() {
		return nombre;
	}

	public void mostrarEmpleados() {
		for (int i = 0; i < listaEmpleados.length; i++) {
			if (listaEmpleados[i] ==null) {
				
			}else {
				System.out.println(listaEmpleados[i]);
			}
			
		}
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	

	@Override
	public String toString() {
		return  " [Nombre: " + getNombre()
				+ " |Localizacion: " + getLocalizacion() + " |Numero de departamento: "+ getDept_no() +  
				 " Empleado:" + getlistaEmpleados()  +"]\n";
	}
	
	
	public void mostrarDepartamento() {
		
		System.out.println("-----------------------------------DEPARTAMENTO " + getNombre() + " ------------------------------------------------");
		System.out.println();
		
		System.out.println("NOMBRE: " + getNombre() + " | " + "Localizacion: " + getLocalizacion() + " | "  + "DEPARTAMENTO NUMERO:  " + getDept_no() );
		
		System.out.println("");
		
		for (int i = 0; i < listaEmpleados.length; i++) {
			if (getlistaEmpleados()[i] != null) {
				
			
			getlistaEmpleados()[i].mostrarEmpleados();
			System.out.println("");
			}
		}
		
		
	}
	

	public Empleado[] getlistaEmpleados() {
		return listaEmpleados;
	}

	public void setlistaEmpleados(Empleado[] listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
//	public int posicionEmpleado(int numeroEmpleado) {
//		int posicionEmpleado = -1;
//		int min = 0;
//		int longitud = listaEmpleados.length-1;
//		
//		while (min <= longitud ) {
//			int mid = (min+longitud)/2;
//			if(numeroEmpleado == listaEmpleados[mid].getNumeroEmpleado()) {
//				posicionEmpleado = mid;
//			}else if( numeroEmpleado < listaEmpleados[mid].getNumeroEmpleado()) {
//				longitud = mid-1;
//			} else if (numeroEmpleado > listaEmpleados[mid].getNumeroEmpleado()) {
//				longitud = mid+1;
//			}
//		}
//		
//		return posicionEmpleado;
//		
//		
//	}
//	
	public int posicionEmpleado(int numeroEmpleado) {
		int posicionEmpleado = -1;
		int i = 0;
		boolean control = false;
		
		while (i <= listaEmpleados.length-1 && control == false) {
			
			if(numeroEmpleado == listaEmpleados[i].getNumeroEmpleado() ) {
				posicionEmpleado = i;
				control = true;
			} 
			
			i++;
			
		}
		
		return posicionEmpleado;
		
	}



	public int getTAM() {
		return TAM;
	}



	public void setTAM(int tAM) {
		TAM = tAM;
	}
}
