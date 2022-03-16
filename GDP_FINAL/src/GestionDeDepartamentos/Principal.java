/*
 * Autor: Victor Fernandez Fernandez
 * Gestion de Departamentos
 * Fecha: 12/03/2022 
 * Ultima version
 */
package GestionDeDepartamentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Principal
		implements
			OperacionesDepartamentos,
			OperacionesEmpleados {

	static BufferedReader teclado = new BufferedReader(
			new InputStreamReader(System.in));
	private static int numeroDepartamentos = 0;
	private static int poscionInsercciones = 0;
	private static int TAM = 5;
	static Departamento listaDepartamentos[] = new Departamento[TAM];
	static Empleado listaEmpleados[] = new Empleado[2];
	private static Principal p = new Principal();

	public static void main(String[] args)
			throws NumberFormatException, IOException {

		cargaDepartamentosComposcion(1, "AAAAAAAAA", "ass");
		p.cargaAutomaticaConAgregacion();
		int opcion = -1;
		do {

			menuPrincipal(); // METODO QUE PINTA LAS OPCIONES DEL MENU PRINCIPAL

			// PEDIMOS OPCION DEL MENU
			try {
				opcion = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero");
			} catch (Exception e) {
			}

			switch (opcion) {
				case 1 :

					menuDepartamentos();

					break;

				case 2 :
					menuGestionEmpleados();

					break;

				case 3 :
					System.out.println("Hasta luego");
					break;

				default :
					System.out.println("Debes elegir la opcion 1 o 2");
					break;
			}

		} while (opcion != 3);

	}

	public static void menuPrincipal() {

		System.out.println(
				"--------------------------------------------------------");
		System.out.println(
				"|                                                      |");
		System.out.println(
				"|                                                      |");
		System.out.println(
				"|      BIENVENIDOS A GESTION DE DEPARTAMENTOS          |");
		System.out.println(
				"|                                                      |");
		System.out.println(
				"|                                                      |");
		System.out.println(
				"--------------------------------------------------------");
		System.out.println();

		System.out.println(
				"|             ¿QUE DESEAS GESTIONAR?                   |");

		System.out.println(
				"|           1. GESTIONAR DEPARTAMENTOS                  |");
		System.out.println(
				"|            2. GESTIONAR EMPLEADOS                     |");
		System.out.println(
				"|                  3. SALIR                             |");

	}

	public static void menuDepartamentos()
			throws NumberFormatException, IOException {
		int opcionGestionDepartamento = -1;
		do {

			System.out.println(
					"--------------------------------------------------------");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|              GESTION DE DEPARTAMENTOS                |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"--------------------------------------------------------");
			System.out.println();

			System.out.println(
					"|             ¿QUE DESEAS REALIZAR ?                   |");

			System.out.println(
					"|             1. AÑADIR DEPARTAMENTO                    |");
			System.out.println(
					"|            2. BORRAR DE DEPARTAMENTO                  |");
			System.out.println(
					"|            3. MODIFICAR DEPARTAMENTO                  |");
			System.out.println(
					"|             4. MOSTRAR DEPARTAMENTOS                  |");
			System.out.println(
					"|               5. MENU ANTERIOR                        |");

			// ---------------------------- PEDIMOS POR TECLADO OPCION DEL MENU

			try {
				opcionGestionDepartamento = Integer
						.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero");
			} catch (Exception e) {
				// TODO: handle exception
			}

			switch (opcionGestionDepartamento) {
				case 1 :

					cargaInteractivaDepartamento();

					break;

				case 2 :
					borrarDepartamentoInteractivo();

					break;

				case 3 : // MODIFICAR ALGUN ATRIBUTO DEL DEPARTAMENTO

					// MOSTRAR MENU PARA SELECIONAR QUE ATRIBUTO DEL DEPARTAMETO
					// DESEA MODIFICAR.
					p.mostrarDepartamentos();
					modificarDepartamentoInteractivo();

					break;

				case 4 : // LISTADO DEPARTAMENTOS
					p.mostrarDepartamentos();
					break;

				case 5 : // MENU ANTERIOR
					break;
				default :
					System.out.println(
							"Debes elegir unas de las opciones disponibles");
					break;
			}

		} while (opcionGestionDepartamento != 5);

	}

	public static void modificarDepartamentoInteractivo()
			throws NumberFormatException, IOException {

		int no_dept = -1;//
		if (p.departamentosVacio() == false) {
			do {

				try {
					System.out.println(
							"INTRODUZCA EL NUMERO DEL DEPARTAMENTO QUE DESEA MODIFICAR");
					no_dept = Integer.parseInt(teclado.readLine());

				} catch (NumberFormatException e) {
					System.err.println("INTRODUCE EL NUMERO CORRECTAMENTE");
				} catch (Exception e) {
					System.err.println("error");
				}

				if (p.existeDepartamento(no_dept) != -1) {

					modificarDepartamento(no_dept);

				} else {
					System.err.println(
							"El numero de departamento introducido no coincide con ningun departamento");
					no_dept = -1;
				}
			} while (no_dept == -1);
		} else {
			System.err.println("NO HAY DEPARTAMENTOS");

		}
	}

	public static int modificarDepartamento(int no_dept) {

		int opcionModificarDepartamento = -1;

		if (p.existeDepartamento(no_dept) != -1
				&& p.departamentosVacio() == false) {

			do {

				System.out.println(
						"--------------------------------------------------------");
				System.out.println(
						"|                                                      |");
				System.out.println(
						"|                                                      |");
				System.out.println(
						"|           MODIFICACION DE DEPARTAMENTO               |");
				System.out.println(
						"|                                                      |");
				System.out.println(
						"|                                                      |");
				System.out.println(
						"--------------------------------------------------------");
				System.out.println();

				System.out.println(
						"|              ¿QUE DESEAS MODIFICAR ?                  |");

				System.out.println(
						"|               1. NUMERO DEPARTAMENTO                  |");
				System.out.println(
						"|               2. NOMBRE DEPARTAMENTO                  |");
				System.out.println(
						"|            3. LOCALIZACION DEPARTAMENTO               |");
				System.out.println(
						"|               4. MENU ANTERIOR                        |");

				try {
					opcionModificarDepartamento = Integer
							.parseInt(teclado.readLine());
				} catch (NumberFormatException e) {
					System.err.println("Introduce un numero");
				} catch (Exception e) {

				}

				switch (opcionModificarDepartamento) {
					case 1 : // NUMERO DEPARTAMENTO
						int nuevo_no_dept = -1; // -1 VARIABLE DE CONTROL
						do {
							try {
								System.out.println(
										"INTRODUZCA EL NUEVO NUMERO DE DEPARTAMENTO");
								nuevo_no_dept = Integer
										.parseInt(teclado.readLine());

							} catch (NumberFormatException e) {
								System.err.println(
										"INTRODUCE EL NUMERO CORRETACTAMENTE");
							} catch (Exception e) {
								System.err.println("error");
							}

							for (int i = 0; i < listaDepartamentos.length; i++) {
								if (listaDepartamentos[i] != null) {
									if (listaDepartamentos[i]
											.getDept_no() == nuevo_no_dept) {
										nuevo_no_dept = -1;
										System.err.println(
												"ESTE NUMERO DE DEPARTAMENTO YA EXISTE");
									}
								}
							}
						} while (nuevo_no_dept == -1);
						listaDepartamentos[p.existeDepartamento(no_dept)]
								.setDept_no(nuevo_no_dept);
						p.mostrarDepartamentos();
						System.out.println("");
						System.out.println(
								"EL NUMERO DE DEPARTAMENTO SE HA MODIFICADO CORRECTAMENTE");
						System.out.println("");

						break;

					case 2 :// NOMBRE DEPARTAMENTO
						String nuevo_ndept = "";

						System.out.println(
								"INTRODUZCA EL NUEVO NOMBRE DEL DEPARTAMENTO");

						try {
							nuevo_ndept = teclado.readLine();
						} catch (IOException e) {
							System.err.println(
									"INTRODUZCA EL NOMBRE CORRECTAMENTE");
						}

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.setNombre(nuevo_ndept);
						p.mostrarDepartamentos();
						System.out.println("");
						System.out.println(
								"EL NOMBRE DEL DEPARTAMENTO SE HA MODIFICADO CORRECTAMENTE");
						System.out.println("");
						break;

					case 3 : // LOCALIZACION DEPARTAMENTO

						String nueva_localizacion = "";
						System.out.println(
								"INTRODUZCA LA NUEVA LOCALIZACION DEL DEPARTAMENTO");

						try {

							nueva_localizacion = teclado.readLine();
						} catch (IOException e) {
							System.err.println(
									"INTRODUZCA LA LOCALIZACION CORRECTAMENTE");
						}

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.setLocalizacion(nueva_localizacion);
						p.mostrarDepartamentos();
						System.out.println("");
						System.out.println(
								"LA LOCALIZACION DE DEPARTAMENTO SE HA MODIFICADO CORRECTAMENTE");
						System.out.println("");

						break;

					case 4 : // MENU ANTERIOR
						break;

					default :
						System.out.println("");
						System.err.println(
								"Debes elegir unas de las opciones disponibles");
						System.out.println("");
						break;
				}
				return 1;
			} while (opcionModificarDepartamento != 4);

		} else {
			return -1;
		}
	}

	// DEVUELVE UN ENTERO CON LA PRIMERA POSCION VACIA QUE EN CUENTRE EN LA
	// LISTA DE DEPARTAMENTOS. O -1
	@Override
	public int buscaHueco() {

		boolean encontrado = false; // booleado para para la busqueda al
									// encontrar un hueco en la lista de
									// empleados
		int i = 0;

		while (i < listaDepartamentos.length && !encontrado) {
			if (listaDepartamentos[i] == null) {

				encontrado = true;

			} else {
				i++;
			}

		}
		if (encontrado) {
			return i;
		} else {
			return -1;
		}

	}

	// DEVUELVE LA POSICION DE LA LISTA DE DEPARTAMENTOS EN LA CUAL SE ENCUENTRA
	// EL NUMERO DE DEPARTAMENTO INTRODUCIDO.

	@Override
	public int existeDepartamento(int numeroDep) {
		int posicion = 0;
		boolean encontrado = false;

		do {
			if (listaDepartamentos[posicion] != null
					&& listaDepartamentos[posicion].getDept_no() == numeroDep) {
				encontrado = true;
			}
			posicion++;

		} while (!encontrado && posicion < numeroDepartamentos);
		if (encontrado) {
			return posicion - 1;
		} else {
			return posicion = -1;
		}

	}
	// DEVUELVE LA POSICION DE LA LISTA DE DEPARTAMENTOS EN LA CUAL SE ENCUENTRA
	// EL NOMBRE DEL DEPARTAMENTO INTRODUCIDO
	@Override
	public int buscarDepartamento(String nombreDepartamento) {
		boolean encontrado = false;
		int posicion = 0;
		do {
			if (listaDepartamentos[posicion] != null
					&& listaDepartamentos[posicion]
							.getNombre() == nombreDepartamento) {
				encontrado = true;
			} else {
				posicion++;
			}
		} while (!encontrado && posicion < TAM);
		if (encontrado)
			return posicion;
		else
			return -1;
	}

	// AGREGA UN DEPARTAMENTO EN LA PRIMERA POSICION QUE ENCUENTRE EL METODO
	// posicionVaciaDepartamento():

	// POR COMPOSCION:

	// AGREGAR DEPARTAMETOS DE FORMA INTERACTIVA POR COMPOSICION, ES DECIR LOS
	// EMPLEADOS SE CREAN DENTRO DEL DEPARTAMENTO.
	public static void cargaInteractivaDepartamento()
			throws NumberFormatException, IOException {
		int nuevo_no_dept = -1; // -1 variable de control para poder parar
		String nuevo_ndept = "";
		String nueva_localizacion = "";

		if (p.departamentosLleno() == false) {

			do {
				try {
					System.out.println(
							"INTRODUZCA EL NUMERO DEL NUEVO DEPARTAMENTO");
					nuevo_no_dept = Integer.parseInt(teclado.readLine());

				} catch (NumberFormatException e) {
					System.err.println("INTRODUCE EL NUMERO CORRETACTAMENTE");
				} catch (Exception e) {
					System.err.println("error");
				}

				for (int i = 0; i < listaDepartamentos.length; i++) {
					if (listaDepartamentos[i] != null) {
						if (listaDepartamentos[i]
								.getDept_no() == nuevo_no_dept) {
							nuevo_no_dept = -1;
							System.err.println(
									"ESTE NUMERO DE DEPARTAMENTO YA EXISTE");
							System.out.println("");
						}
					}

				}
			} while (nuevo_no_dept == -1);

			System.out.println("INTRODUZCA EL NOMBRE DEL NUEVO DEPARTAMENTO");

			try {
				nuevo_ndept = teclado.readLine();
			} catch (IOException e) {
				System.err.println("INTRODUZCA EL NOMBRE CORRECTAMENTE");
			}

			System.out.println(
					"INTRODUZCA LA LOCALIZACION DEL NUEVO DEPARTAMENTO");

			try {
				nueva_localizacion = teclado.readLine();
			} catch (IOException e) {
				System.err.println("INTRODUZCA LA LOCALIZACION CORRECTAMENTE");
			}
			cargaDepartamentosComposcion(nuevo_no_dept, nuevo_ndept,
					nueva_localizacion);
			p.mostrarDepartamentos();
			System.out.println("");
			System.out.println("DEPARMENTO CREADO CORRECTAMENTE");
			System.out.println("");
		} else {
			System.err.println(
					"NO SE PUEDEN AÑADIR MAS DEPARTAMENTOS, CAPACIDAD LLENA.");
			System.out.println("");
		}
	}

	// AGREGAR DEPARTAMETOS POR COMPOSICION, ES DECIR CON EMPLEADOS, DEVUELVE,
	// DEVUELVE LA POSCION DE LA LISTA DE DEPARTAMENTOS DONDE SE HA INTRODUCIDO.
	// O
	// -1
	public static int cargaDepartamentosComposcion(int nuevo_no_dept,
			String nuevo_ndept, String nueva_localizacion) {

		if (p.departamentosLleno() == false) {

			listaDepartamentos[poscionInsercciones] = new Departamento(
					nuevo_no_dept, nuevo_ndept, nueva_localizacion);
			int posicion = poscionInsercciones;

			poscionInsercciones = p.buscaHueco();
			numeroDepartamentos += 1;

			return posicion;
		} else {
			return -1;
		}

	}

	// POR AGREGACION

	// AGREGAR DE FORMA INTERATIVA DEPARTAMETOS POR AGREGACION, ES DECIR LOS
	// EMPLEADOS SE CREAN FUERA DEL DEPARTAMENTO.
	public static void agregarDepartamentoInteractivoAgregacion()
			throws NumberFormatException, IOException {
		int nuevo_no_dept = -1;
		String nuevo_ndept = "";
		String nueva_localizacion = "";

		if (p.departamentosLleno() == false) {
			do {
				try {
					System.out.println(
							"INTRODUZCA EL NUMERO DEL NUEVO DEPARTAMENTO");
					nuevo_no_dept = Integer.parseInt(teclado.readLine());

				} catch (NumberFormatException e) {
					System.err.println("INTRODUCE EL NUMERO CORRETACTAMENTE");

				} catch (Exception e) {
					System.err.println("error");
				}
			} while (nuevo_no_dept == -1);

			System.out.println("INTRODUZCA EL NOMBRE DEL NUEVO DEPARTAMENTO");

			try {
				nuevo_ndept = teclado.readLine();
			} catch (IOException e) {
				System.err.println("INTRODUZCA EL NOMBRE CORRECTAMENTE");
			}

			System.out.println(
					"INTRODUZCA LA LOCALIZACION DEL NUEVO DEPARTAMENTO");

			try {
				nueva_localizacion = teclado.readLine();
			} catch (IOException e) {
				System.err.println("INTRODUZCA LA LOCALIZACION CORRECTAMENTE");
			}
			cargaDepartamentosConAgregacion(nuevo_no_dept, nuevo_ndept,
					nueva_localizacion);
			p.mostrarDepartamentos();
			System.out.println("");
			System.out.println("DEPARTAMENTO CREADO CORRECTAMENTE");
			System.out.println("");
		} else {
			System.out.println(
					"NO SE PUEDEN AÑADIR MAS DEPARTAMENTOS, CAPACIDAD LLENA.");
			System.out.println("");
		}
	}

	// AGREGAR DEPARTAMETOS POR AGREGACION, ES DECIR SIN EMPLEADOS DEVUELVE,
	// DEVUELVE LA POSCION DE LA LISTA DE DEPARTAMENTOS DONDE SE HA INTRODUCIDO.
	// O
	// -1
	public static int cargaDepartamentosConAgregacion(int nuevo_no_dept,
			String nuevo_ndept, String nueva_localizacion) {

		if (p.departamentosLleno() == false) {

			listaDepartamentos[poscionInsercciones] = new Departamento(
					nuevo_no_dept, nuevo_ndept, nueva_localizacion, null);

			int posicion = poscionInsercciones;
			poscionInsercciones = p.buscaHueco();
			numeroDepartamentos += 1;

			return posicion;

		} else {
			return -1;
		}

	}

	// CARGA EN LA LISTA DE DEPARTAMENTOS: 2 DEPARTAMENTOS Y 2 EMPLEADOS EN CADA
	// DEPARTAMENTO POR COMPOSICION
	@Override
	public void cargaAutomaticaConComposcion() {

		Departamento d1 = new Departamento(1, "Ventas", "Vva");
		Departamento d2 = new Departamento(2, "Disenio", "Don Benito");

		listaDepartamentos[0] = d1;
		listaDepartamentos[1] = d2;

		numeroDepartamentos = 2;
		poscionInsercciones = 2;
	}

	// CARGA EN LA LISTA DE DEPARTAMENTOS: 2 DEPARTAMENTOS Y 2 EMPLEADOS EN CADA
	// DEPARTAMENTO POR AGREGACION
	@Override
	public void cargaAutomaticaConAgregacion() {

		Empleado e1 = new Empleado(40, "Pedro", "Sanchez", "java developer",
				2800, null, LocalDate.of(1980, 4, 10));
		Empleado e2 = new Empleado(50, "Carla", "Perez", "programadora", 3100,
				null, LocalDate.of(1980, 4, 10));

		Empleado empleados1[] = new Empleado[2];
		empleados1[0] = e1;
		empleados1[1] = e2;

		Empleado e3 = new Empleado(60, "Pedro", "Sanchez", "java developer",
				2800, null, LocalDate.of(1980, 4, 10));
		Empleado e4 = new Empleado(70, "Carla", "Perez", "programadora", 3100,
				null, LocalDate.of(1980, 4, 10));

		Empleado empleados2[] = new Empleado[2];
		empleados2[0] = e3;
		empleados2[1] = e4;

		Departamento d3 = new Departamento(3, "Administracion", "Valdivia",
				empleados1);
		Departamento d4 = new Departamento(4, "Recursos humanos", "Zurbaran",
				empleados2);

		listaDepartamentos[0] = d3;
		listaDepartamentos[1] = d4;

		numeroDepartamentos = 2;
		poscionInsercciones = 2;

	}

	// BORRA EL DEPARTAMENTO SELECIONADO POR EL NUMERO DE DEPARTAMENTO

	// BORRA EL DEPARTAMENTO DE FORMA INTERACTIVA
	public static void borrarDepartamentoInteractivo()
			throws NumberFormatException, IOException {

		int no_dept_borrar = -1;

		if (p.departamentosVacio() == false) {

			do {

				p.mostrarDepartamentos();

				try {
					System.out.println(
							"INTRODUZCA EL NUMERO DEL DEPARTAMENTO QUE DESEA ELIMINAR");
					no_dept_borrar = Integer.parseInt(teclado.readLine());

				} catch (NumberFormatException e) {
					System.out.println("INTRODUCE EL NUMERO CORRETACTAMENTE");
				} catch (Exception e) {
					System.out.println("error");
				}

				if (p.existeDepartamento(no_dept_borrar) == -1) {
					System.err.println("NO EXISTE DEPARTAMENTO CON ESE NUMERO");
					no_dept_borrar = -1;
				}

				System.out.println("");
				System.out.println("DEPARTAMENTO BORRADO CORRECTAMENTE");
				System.out.println("");
			} while (no_dept_borrar == -1);

			borrarDepartamento(no_dept_borrar);

			p.mostrarDepartamentos();
		} else {
			System.err.println("NO HAY DEPARTAMENTOS");
			System.out.println("");
		}

	}

	// METODO PARA BORRAR EL DEPARTAMENTO
	public static int borrarDepartamento(int no_dept_borrar) {
		if (p.departamentosVacio() == false) {

			listaDepartamentos[p.existeDepartamento(no_dept_borrar)] = null;

			poscionInsercciones = p.buscaHueco();
			numeroDepartamentos -= 1;

			return numeroDepartamentos;
		} else {
			return -1;
		}

	}

	// MODIFICA ALGUN ATRIBUTO DE UN DEPARTAMENTO SELECIONADO.

	// MUESTRA POR PANTALLA LOS DEPARTAMENTOS EXISTENTES Y SUS EMPELADOS EN CASO
	// DE TENERLOS.
	@Override
	public void mostrarDepartamentos() {

		if (departamentosVacio() == false) {

			for (int i = 0; i < listaDepartamentos.length; i++) {
				if (listaDepartamentos[i] != null) {
					listaDepartamentos[i].mostrarDepartamento();
				}
			}

			System.out
					.println("Hay " + numeroDepartamentos + " Departamentos.");

			System.out.println(
					"Primera poscion para inserccion: " + (buscaHueco() + 1));
			System.out.println("");
			System.out.println("");

		}

	}

	// DEVUELVE TRUE SI LA LISTA DE DEPARTAMENTOS ESTA COMPLETA
	@Override
	public boolean departamentosLleno() {

		boolean lleno = false;

		if (numeroDepartamentos == TAM) {
			lleno = true;
		}

		return lleno;
	}

	// DEVUEVLE TRUE SI NO HAY NINGUN DEPARTAMENTO EN LA LISTA DE DEPARTAMENTOS.
	@Override
	public boolean departamentosVacio() {

		boolean vacio = false;

		if (numeroDepartamentos == 0) {
			vacio = true;
		}

		return vacio;
	}

	// METODOS GESTION DE EMPLEADOS

	public static void menuGestionEmpleados()
			throws NumberFormatException, IOException {
		int opcionGestionEmpleados = -1;
		do {
			System.out.println(
					"--------------------------------------------------------");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                GESTION DE EMPLEADOS                  |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"--------------------------------------------------------");
			System.out.println();

			System.out.println(
					"|             ¿QUE DESEAS REALIZAR ?                   |");

			System.out.println(
					"|               1. AÑADIR EMPLEADO                      |");
			System.out.println(
					"|              2. BORRAR DE EMPLEADO                    |");
			System.out.println(
					"|              3. MODIFICAR EMPLEADO                    |");
			System.out.println(
					"|               4. MENU ANTERIOR                        |");

			try {
				opcionGestionEmpleados = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero");
			} catch (Exception e) {

			}

			switch (opcionGestionEmpleados) {
				case 1 :

					p.mostrarDepartamentos();
					cargaInteractivaEmpleados();
					p.mostrarDepartamentos();

					break;

				case 2 :
					System.out.println(
							"Introduce el id del empleado que quieras borrar: ");
					int no_borrar_empleado = Integer
							.parseInt(teclado.readLine());
					System.out.println(
							"Introduce el numero del departamento donde se encuentra el empleado");
					int dept_borrar_empleado = Integer
							.parseInt(teclado.readLine());
					borrarEmpleado(no_borrar_empleado, listaDepartamentos[p
							.existeDepartamento(dept_borrar_empleado)]);
					listaDepartamentos[p.existeDepartamento(
							dept_borrar_empleado)].setNumeroEmpleados(
									listaDepartamentos[p.existeDepartamento(
											dept_borrar_empleado)]
													.getNumeroEmpleados()
											- 1);
					listaDepartamentos[p.existeDepartamento(
							dept_borrar_empleado)].setNumeroInsercciones(
									listaDepartamentos[p.existeDepartamento(
											dept_borrar_empleado)]
													.getNumeroInserciones()
											- 1);
					/*
					 * if (borrarEmpleado(no_borrar_empleado,
					 * listaDepartamentos[p.existeDepartamento(
					 * dept_borrar_empleado)]) == 0) {
					 * System.err.println("La lista de empleados está llena");
					 * 
					 * }
					 */

					break;

				case 3 :
					MenuModificarEmpleado();

					break;

				case 4 :

					break;

				default :
					System.out.println(
							"Debes elegir unas de las opciones disponibles");
					break;
			}

		} while (opcionGestionEmpleados != 4);

	}

	public static int posicionDelEmpleado(Departamento d, int num) {
		int posicion = 0;
		int encontrado = -1;

		do {
			if (d.getlistaEmpleados()[posicion] != null
					&& d.getlistaEmpleados()[posicion]
							.getNumeroEmpleado() == num) {
				encontrado = 1;
			}
			posicion++;

		} while (encontrado == -1 && posicion < d.getlistaEmpleados().length);
		return posicion - 1;

	}
	//METODO QUE RETORNA LA POSICION DEL ARRAY EN LA QUE SE ENCUENTRA EL EMPLEADO BUSCADO POR EL APELLIDO
	//EN CASO DE QUE NO SE ENCUENTRE EL DEPARTAMENTO DEVUELVE -1
	//EN CASO DE QUE NO SE ENCUENTRE EL APELLIDO DEVUELVE -2
	public static int posicionDelApellido(String apellido, Departamento d) {
		int posicion = 0;
		boolean encontrado = false;
		if (p.existeDepartamento(d.getDept_no()) == -1) {
			posicion = 0;
		} else if(p.existeDepartamento(d.getDept_no()) != -1){
			do {
				if (d.getlistaEmpleados()[posicion] != null
						&& d.getlistaEmpleados()[posicion].getApellido()
								.contentEquals(apellido)) {
					encontrado = true;
				}else if (posicion == d.getlistaEmpleados().length) {
					posicion=-2;
					encontrado = true;
				}
				posicion++;

			} while (encontrado == false
					&& posicion < d.getlistaEmpleados().length);
		}
		
		
		return posicion - 1;

	}

	public static int borrarEmpleado(int e, Departamento d) {

		boolean finalizar = false;
		int realizado = -1;
		do {
			if (finalizar == false && !p.empleadosVacio(d)) {
				d.getlistaEmpleados()[posicionDelEmpleado(d, e)] = null;
				// d.setNumeroEmpleados(d.getNumeroEmpleados() + 1);
				// d.setNumeroInserciones(d.getNumeroInserciones() + 1);
				realizado = 1;
				finalizar = true;
			} else if (p.empleadosLleno(d)) {
				realizado = 0;
				finalizar = true;
			} else if (p.existeEmpleados(d, e) == -1) {
				realizado = -1;
				finalizar = true;
			}
		} while (finalizar == false);
		return realizado;

	}

	public static void ordenarEmpleados(int numeroDep) {
		for (int i = 0; i < listaDepartamentos.length; i++) {
			listaDepartamentos[numeroDep]
					.getlistaEmpleados()[i] = listaDepartamentos[numeroDep]
							.getlistaEmpleados()[i - 1];
		}

	}

	public static void MenuModificarEmpleado()
			throws NumberFormatException, IOException {

		int opcionModificarEmpleado = -1;
		do {
			System.out.println(
					"--------------------------------------------------------");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|               MODIFICACION DE EMPLEADO               |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"--------------------------------------------------------");
			System.out.println();

			System.out.println(
					"|             ¿QUE DESEAS MODIFICAR ?                  |");

			System.out.println(
					"|               1. NUMERO EMPLEADO                  |");
			System.out.println(
					"|               2. NOMBRE EMPLEADO                  |");
			System.out.println(
					"|               3. OFICIO EMPLEADO                  |");
			System.out.println(
					"|            4. FECHA DE ALTA EMPLEADO              |");
			System.out.println(
					"|               5. SALARIO EMPLEADO                 |");
			System.out.println(
					"|              6. COMISION EMPLEADO                 |");
			System.out.println(
					"|                7. MENU ANTERIOR                   |");

			try {
				opcionModificarEmpleado = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero");
			} catch (Exception e) {
			}

			switch (opcionModificarEmpleado) {
				case 1 :
					try {

						System.out.println(
								"Introduce el id del empleado a modificar: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println(
								"Introduce el id que deseas asignarle:");
						int idAsignado = Integer.parseInt(teclado.readLine());

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar - 1]
										.setNumeroEmpleado(idAsignado);

					} catch (Exception e) {
						//
					}
					break;

				case 2 :

					try {

						System.out.println(
								"Introduce el id del empleado a modificar: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println(
								"Introduce el id que deseas asignarle:");
						String nombreAsignado = teclado.readLine();

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar - 1]
										.setApellido(nombreAsignado);

					} catch (Exception e) {

					}
					break;

				case 3 :
					try {

						System.out.println(
								"Introduce el id del empleado a modificar: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println(
								"Introduce el id que deseas asignarle:");
						String oficio = teclado.readLine();

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar - 1]
										.setOficio(oficio);

					} catch (Exception e) {

					}
					break;

				case 4 :
					try {

						System.out.println(
								"Introduce el id del empleado a modificar: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println("Introduce una nueva fecha:");

						String fecha = teclado.readLine();

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar - 1]
										.setOficio(fecha);

					} catch (Exception e) {

					}
					break;

				case 5 :
					try {

						System.out.println(
								"Introduce el id del empleado a modificar: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println("Introduce una nueva fecha:");

						double salario = Double.parseDouble(teclado.readLine());

						listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar - 1]
										.setSalario(salario);

					} catch (Exception e) {

					}
					break;

				case 6 :
					try {

						System.out.println(
								"Introduce el id del empleado al que desea modificar la comision: ");
						int idModificar = Integer.parseInt(teclado.readLine());
						System.out.println(
								"Introduce el id del departamento donde se encuentra: ");
						int no_dept = Integer.parseInt(teclado.readLine());

						System.out.println("Introduce una nueva comision:");

						double comision = Double
								.parseDouble(teclado.readLine());

						if (listaDepartamentos[p.existeDepartamento(no_dept)]
								.getlistaEmpleados()[idModificar
										- 1] instanceof Director) {
							((Director) listaDepartamentos[p
									.existeDepartamento(no_dept)]
											.getlistaEmpleados()[idModificar
													- 1]).setComision(comision);

						} else {
							System.err.println(
									"El empleado introducido no es un directivo, no tiene comision");
						}

					} catch (Exception e) {

					}
					break;

				case 7 :
					System.out.println("MODIFICAR ");
					break;

				default :
					System.out.println(
							"Debes elegir unas de las opciones disponibles");
					break;
			}

		} while (opcionModificarEmpleado != 7);

	}

	@Override
	public int existeEmpleados(Departamento d, int num) {
		int posicion = 0;
		int encontrado = -1;

		do {
			if (d.getlistaEmpleados()[posicion] != null
					&& d.getlistaEmpleados()[posicion]
							.getNumeroEmpleado() == num) {
				encontrado = 1;
			}
			posicion++;

		} while (encontrado == -1 && posicion < d.getlistaEmpleados().length);
		return encontrado;

	}

	public static int posicionEmpleado(int numeroEmpleado, Departamento e) {

		int posicion = -1;
		int contador = 0;
		boolean control = false;

		while (control == false && contador < e.getlistaEmpleados().length) {

			if (e.getlistaEmpleados()[contador] != null) {
				if (e.getlistaEmpleados()[contador]
						.getNumeroEmpleado() == contador) {

					posicion = contador;
					control = true;
				}
			}
			contador++;
		}
		return posicion;
	}

	@Override
	public boolean empleadosVacio(Departamento d) {

		boolean vacio;

		if (d.getNumeroEmpleados() == 0) {
			vacio = true;
		} else {
			vacio = false;
		}

		return vacio;
	}

	@Override
	public boolean empleadosLleno(Departamento d) {
		boolean lleno;

		if (d.getNumeroEmpleados() == d.getTAM()) {
			lleno = true;
		} else {
			lleno = false;
		}

		return lleno;
	}

	@Override
	public void mostrarEmpleados(Departamento d) {

		if (empleadosVacio(d) == false) {

			for (int i = 0; i < d.getlistaEmpleados().length; i++) {
				if (d.getlistaEmpleados()[i] != null)
					d.getlistaEmpleados()[i].mostrarEmpleados();
			}

			System.out.println("Primera poscion para inserccion: "
					+ (d.getNumeroInserciones() + 1));
			System.out.println("");
			System.out.println("");

		} else {
			System.err.println("NO HAY EMPLEADOS");
		}
	}

	public static int insertarEmpleado(Empleado e, Departamento d) {

		boolean finalizar = false;
		int realizado = -1;
		do {
			if (finalizar == false && !p.empleadosLleno(d)) {
				d.getlistaEmpleados()[d.getNumeroInserciones()] = e;
				// d.setNumeroEmpleados(d.getNumeroEmpleados() + 1);
				// d.setNumeroInserciones(d.getNumeroInserciones() + 1);
				realizado = 1;
				finalizar = true;
			} else if (p.empleadosLleno(d)) {
				realizado = 0;
				finalizar = true;
			} else if (p.existeDepartamento(d.getDept_no()) == -1) {
				realizado = -1;
				finalizar = true;
			}
		} while (finalizar == false);
		return realizado;

	}

	public static void cargaInteractivaEmpleados() {
		int id = 0;
		int numeroDepartamento = 0;
		int opcionModificarEmpleado = -1;

		do {

			try {
				System.out.println(
						"INTRODUZCA EL NUMERO DEL DEPARTAMENTO EN EL QUE DESEA INSERTAR EL EMPLEADO");
				numeroDepartamento = Integer.parseInt(teclado.readLine());

			} catch (NumberFormatException e) {
				System.err.println("INTRODUCE EL NUMERO CORRETACTAMENTE");
			} catch (Exception e) {
				System.err.println("error");
			}

			if (p.existeDepartamento(numeroDepartamento) == -1) {
				System.err.println(
						"No existe ese departamento, vuelve a intentarlo");
				numeroDepartamento = -1;
			}

		} while (numeroDepartamento == -1);

		do {
			System.out.println(
					"--------------------------------------------------------");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                 INSERTAR EMPLEADO                    |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"|                                                      |");
			System.out.println(
					"--------------------------------------------------------");
			System.out.println();

			System.out.println(
					"|       ¿QUE TIPO DE EMPLEADO DESEA INSERTAR?       |");

			System.out.println(
					"|                 1. ANALISTA                       |");
			System.out.println(
					"|                 2. DIRECTOR                       |");
			System.out.println(
					"|                 3. Elegir oficio                   |");
			System.out.println(
					"|                 4. ATRAS                          |");

			try {
				opcionModificarEmpleado = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.err.println("Introduce un numero");
			} catch (Exception e) {
			}
			switch (opcionModificarEmpleado) {
				case 1 :
					Analista nuevoEmpleado = new Analista();
					nuevoEmpleado.setOficio("Analista");
					if (insertarEmpleado(nuevoEmpleado, listaDepartamentos[p
							.existeDepartamento(numeroDepartamento)]) == -1) {
						System.out.println("");
						System.err
								.println("No existe el numero de departamento");
						System.out.println("");
						opcionModificarEmpleado = 4;

					} else {

						System.out.println(
								"--------------------------------------------------------");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                 INSERTAR ANALISTA                    |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"--------------------------------------------------------");
						System.out.println("");
						System.out.println("");
						boolean existeEmp = false;

						if (insertarEmpleado(nuevoEmpleado,
								listaDepartamentos[p.existeDepartamento(
										numeroDepartamento)]) == 0) {
							System.err.println(
									"La lista de empleados está llena");
							opcionModificarEmpleado = 4;
						} else {

							do {
								existeEmp = false;
								try {
									System.out.println(
											"Introduzca el id del empleado");
									id = Integer.parseInt(teclado.readLine());

									if (p.existeEmpleados(listaDepartamentos[p
											.existeDepartamento(
													numeroDepartamento)],
											id) == 1) {
										System.err.println(
												"El id introducido ya existe, prueba con otro");
										existeEmp = true;
									}
								} catch (NumberFormatException e) {
									System.err.println("Introduce un numero");
									existeEmp = true;
								} catch (Exception e) {
								}
							} while (existeEmp == true);
							nuevoEmpleado.setNumeroEmpleado(id);

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL NOMBRE DEL EMPLEADO");
							try {
								nuevoEmpleado.setNombre(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL NOMBRE CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL APELLIDO DEL EMPLEADO");
							try {
								nuevoEmpleado.setApellido(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL APELLIDO CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL SALARIO DEL EMPLEADO");

							try {
								nuevoEmpleado.setSalario(
										Double.parseDouble(teclado.readLine()));
							} catch (NumberFormatException e) {
								System.out.println("Introduce un numero");
							} catch (Exception e) {
							}

							System.out.println("");

							nuevoEmpleado.setNumeroDepartamento(
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]);

							System.out.println("");
							System.out.println(
									"INTRODUZCA LA FECHA DE ALTA DEL EMPLEADO Y/M/D");
							try {

								String date = teclado.readLine();
								LocalDate nuevafecha = LocalDate.parse(date);

								nuevoEmpleado.setFecha(nuevafecha);
							} catch (Exception e) {
							}

							insertarEmpleado(nuevoEmpleado, listaDepartamentos[p
									.existeDepartamento(numeroDepartamento)]);
							System.out.println(insertarEmpleado(nuevoEmpleado,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]));

							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroEmpleados(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroEmpleados()
													+ 1);
							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroInsercciones(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroInserciones()
													+ 1);

						}
					}
					break;
				case 2 :
					Director nuevoEmpleado2 = new Director();
					nuevoEmpleado2.setOficio("Director");
					if (insertarEmpleado(nuevoEmpleado2, listaDepartamentos[p
							.existeDepartamento(numeroDepartamento)]) == -1) {
						System.out.println("");
						System.err
								.println("No existe el numero de departamento");
						System.out.println("");
						opcionModificarEmpleado = 4;

					} else {

						System.out.println(
								"--------------------------------------------------------");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                 INSERTAR DIRECTOR                    |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"--------------------------------------------------------");
						System.out.println("");
						System.out.println("");
						boolean existeEmp = false;

						if (insertarEmpleado(nuevoEmpleado2,
								listaDepartamentos[p.existeDepartamento(
										numeroDepartamento)]) == 0) {
							System.err.println(
									"La lista de empleados está llena");
							opcionModificarEmpleado = 4;
						} else {

							do {
								existeEmp = false;
								try {
									System.out.println(
											"Introduzca el id del empleado");
									id = Integer.parseInt(teclado.readLine());

									if (p.existeEmpleados(listaDepartamentos[p
											.existeDepartamento(
													numeroDepartamento)],
											id) == 1) {
										existeEmp = true;
										System.err.println(
												"El id introducido ya existe, prueba con otro");
									}
								} catch (NumberFormatException e) {
									System.out.println("Introduce un numero");
								} catch (Exception e) {
								}
							} while (insertarEmpleado(nuevoEmpleado2,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]) == 0
									|| existeEmp == true);
							nuevoEmpleado2.setNumeroEmpleado(id);

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL NOMBRE DEL EMPLEADO");
							try {
								nuevoEmpleado2.setNombre(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL NOMBRE CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL APELLIDO DEL EMPLEADO");
							try {
								nuevoEmpleado2.setApellido(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL APELLIDO CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL SALARIO DEL EMPLEADO");

							try {
								nuevoEmpleado2.setSalario(
										Double.parseDouble(teclado.readLine()));
							} catch (NumberFormatException e) {
								System.out.println("Introduce un numero");
							} catch (Exception e) {
							}

							System.out.println("");

							nuevoEmpleado2.setNumeroDepartamento(
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]);

							System.out.println("");
							System.out.println(
									"INTRODUZCA LA FECHA DE ALTA DEL EMPLEADO Y/M/D");
							try {

								String date = teclado.readLine();
								LocalDate nuevafecha = LocalDate.parse(date);

								nuevoEmpleado2.setFecha(nuevafecha);
							} catch (Exception e) {
							}

							insertarEmpleado(nuevoEmpleado2,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]);
							System.out.println(insertarEmpleado(nuevoEmpleado2,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]));
							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroEmpleados(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroEmpleados()
													+ 1);
							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroInsercciones(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroInserciones()
													+ 1);

						}
					}
					break;

				case 3 :
					Empleado nuevoEmpleado3 = new Empleado();

					if (insertarEmpleado(nuevoEmpleado3, listaDepartamentos[p
							.existeDepartamento(numeroDepartamento)]) == -1) {
						System.out.println("");
						System.err
								.println("No existe el numero de departamento");
						System.out.println("");
						opcionModificarEmpleado = 4;

					} else {
						try {

							System.out.println("");
							System.out.println(
									"Introduzca el oficio del empleado a cargar:");
							nuevoEmpleado3.setOficio(teclado.readLine());
						} catch (Exception e) {

						}
						System.out.println(
								"--------------------------------------------------------");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println("|                 INSERTAR "
								+ nuevoEmpleado3.getOficio()
								+ "                   |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"|                                                      |");
						System.out.println(
								"--------------------------------------------------------");
						System.out.println("");
						System.out.println("");
						boolean existeEmp = false;

						if (insertarEmpleado(nuevoEmpleado3,
								listaDepartamentos[p.existeDepartamento(
										numeroDepartamento)]) == 0) {
							System.err.println(
									"La lista de empleados está llena");
							opcionModificarEmpleado = 4;
						} else {

							do {
								existeEmp = false;

								try {
									System.out.println(
											"Introduzca el id del empleado");
									id = Integer.parseInt(teclado.readLine());

									if (p.existeEmpleados(listaDepartamentos[p
											.existeDepartamento(
													numeroDepartamento)],
											id) == 1) {
										existeEmp = true;
										System.err.println(
												"El id introducido ya existe, prueba con otro");
									}
								} catch (NumberFormatException e) {
									System.out.println("Introduce un numero");
								} catch (Exception e) {
								}
							} while (insertarEmpleado(nuevoEmpleado3,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]) == 0
									|| existeEmp == true);
							nuevoEmpleado3.setNumeroEmpleado(id);

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL NOMBRE DEL EMPLEADO");
							try {
								nuevoEmpleado3.setNombre(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL NOMBRE CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL APELLIDO DEL EMPLEADO");
							try {
								nuevoEmpleado3.setApellido(teclado.readLine());
							} catch (IOException e) {
								System.err.println(
										"INTRODUZCA EL APELLIDO CORRECTAMENTE");
							}

							System.out.println("");
							System.out.println(
									"INTRODUZCA EL SALARIO DEL EMPLEADO");

							try {
								nuevoEmpleado3.setSalario(
										Double.parseDouble(teclado.readLine()));
							} catch (NumberFormatException e) {
								System.out.println("Introduce un numero");
							} catch (Exception e) {
							}

							System.out.println("");

							nuevoEmpleado3.setNumeroDepartamento(
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]);

							System.out.println("");
							System.out.println(
									"INTRODUZCA LA FECHA DE ALTA DEL EMPLEADO Y/M/D");
							try {

								String date = teclado.readLine();
								LocalDate nuevafecha = LocalDate.parse(date);

								nuevoEmpleado3.setFecha(nuevafecha);
							} catch (Exception e) {
							}

							insertarEmpleado(nuevoEmpleado3,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]);
							System.out.println(insertarEmpleado(nuevoEmpleado3,
									listaDepartamentos[p.existeDepartamento(
											numeroDepartamento)]));
							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroEmpleados(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroEmpleados()
													+ 1);
							listaDepartamentos[p.existeDepartamento(
									numeroDepartamento)].setNumeroInsercciones(
											listaDepartamentos[p
													.existeDepartamento(
															numeroDepartamento)]
																	.getNumeroInserciones()
													+ 1);

						}
					}
					break;
				default :
					break;
			}
		} while (opcionModificarEmpleado != 4);

	}

}
