/**
 * 
 */
package grafos;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * @author ignaciovaldes
 *
 */
public class Clases {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int Opcion=0;
		int Indice=0;
		int MatrizOriginal[][]=new int[Indice][Indice];
		int NuevaMatriz[][]=new int[Indice][Indice];
		int MatrizAdyacencia[][]=new int [Indice][Indice];
		System.out.println("Menu");
		
		while(Opcion!=10000) {
			
			System.out.println("1.- Ingresar Matriz");
			System.out.println("2.- Mostrar Matriz Ingresada");
			System.out.println("3.- Elevar hasta n la matriz");
			System.out.println("4.- Verificar si la matriz es conexa");
			System.out.println("5.- Salir");
			try {
			System.out.println("Ingrese el numero de la opcion deseada");
			Opcion=sn.nextInt();
				
			
			switch(Opcion)
			{
			
			
			case 1:
			{
				System.out.println("Ingrese el numero de columnas y filas para la matriz");
				Indice=sn.nextInt();
				
				int [][] Matriz=new int[Indice][Indice];
				
				System.out.println("Ingresa los valores para la matriz");
				for(int i=0;i<Matriz.length;i++)
				{
					for(int j=0;j<Matriz.length;j++)
					{
						System.out.println("Ingresa el numero para la posicion "+i+","+j);
						Matriz[i][j]=sn.nextInt();
					}
				}
				MatrizOriginal=Matriz;
				break;
			}
			
			case 2:
			{
				if(Indice!=0) {
				System.out.println("La matriz Actual es: ");
				MostrarMatriz(MatrizOriginal);
				break;
				}
				else {
					System.out.println("Ingrese en la opcion nº1 antes de continuar en esta");
				    System.out.println("");
				    }
					break;
			}
			
			case 3:
			{
				if(Indice!=0) {
				int Producto[][]=MatrizOriginal;
				int Suma[][]=Producto;
				
				System.out.println("Ingresar un coeficiente: ");
				int Coeficiente=sn.nextInt();
				int Contadora=0;
				if(Coeficiente==0)
				{
					Producto=MatrizIdentidad(Indice);
				}
				else
				{
					while(Contadora<Coeficiente)
					{
						if(Contadora==0)
						{
							Producto=MatrizOriginal;
							Suma=Producto;;
						}
						else
						{
							
							if(1==Contadora)
							{
								
								Producto=Multiplicar(MatrizOriginal,MatrizOriginal);
								Suma=Producto;
								
							}
							else if(Contadora>=2)
								{
									
									Producto=Multiplicar(Producto,MatrizOriginal);
									
									Suma=Sumar(Producto,Suma);
									
								}
							
						}
						Contadora++;
					}
					
				}
				NuevaMatriz=Producto;
				MatrizAdyacencia=Suma;
				System.out.println("");
				System.out.println("La matriz elevada es: ");
				MostrarMatriz(NuevaMatriz);
				
				break;
				}
				else {
					System.out.println("Ingrese en la opcion nº1 antes de continuar en esta");
					System.out.println("");
					break;
				}
					
			}
			case 4:
			{
				if(Indice!=0) {
				//System.out.println("La matriz actual es: ");
				//MostrarMatriz(NuevaMatriz);
				int Contador=0;
				for(int i=0;i<MatrizAdyacencia.length;i++)
				{
					for(int j=0;j<MatrizAdyacencia.length;j++)
					{
						if(MatrizAdyacencia[i][j]==0)
						{
							Contador++;
						}
					}
				}
				
				if(Contador==0)
				{
					System.out.println("El grafo es conexo");
					System.out.println("");
				}
				else
				{
					System.out.println("El grafo no es conexo");
					System.out.println("");
				}
				break;
				}
				else
				{
					System.out.println("Ingrese en la opcion nº1 antes de continuar en esta");
					System.out.println("");
					break;
				}
			}
			case 5:
			{
				System.out.println("TAAAAAA!");
				System.exit(5);
				
			}
			
			default:
				System.out.println("Opcion no valida ingrese un numero nuevamente");
			break;
		}//Hasta aqui llega switch
			} catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
			}
	}//hasta aqui llega while
		System.out.println("TAAAAAA!");

}

	public static void MostrarMatriz(int A[][])
	{
		//System.out.println("La matriz es: ");
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[i].length;j++)
			{
				System.out.print(A[i][j]);
				if(j!=A[i].length-1)System.out.print("\t");
			}
			System.out.println("\n");
		}
	}

	public static int [][] MatrizIdentidad(int Numero)
	{
	    int [][]matriz = new int [Numero][Numero];
	    for(int i =0; i<matriz.length;i++)
	    {
	        for(int j=0;j<matriz.length;j++)
	        {
	            if(i==j)
	            {
	                matriz[i][j]=1;
	            }
	            else
	            {
	                matriz[i][j]=0;
	            }
	        }
	    }
	    
	    return matriz;
	}

	public static int[][] Sumar (int[][] A,int[][] B) {

		int[][] SumaTotal = new int[A.length][B[0].length];
		for(int i=0;i<SumaTotal.length;i++) 
	        {
	            for(int j=0;j<SumaTotal[i].length;j++) 
	            {
	                SumaTotal[i][j]= A[i][j]+B[i][j];
	            }
	        }
		return SumaTotal;
	}

	public static int[][] Multiplicar(int[][] A,int[][] B) {
		
		int Fila_A=A.length;
		int Columna_A = A[0].length;
		
		int Columna_B = B[0].length;
		
		
		
		int[][] Multiplicacion = new int[Fila_A][Columna_B];
		
		for (int i=0;i< Multiplicacion.length; i++) {
	        for (int j=0;j< Multiplicacion[i].length; j++) {
	        		
	        		
	        		for (int z=0;z<Columna_A;z++) {
	        			Multiplicacion[i][j]+=A[i][z]*B[z][j];
	        		}
	        }
		}
		return Multiplicacion;
		
	}

	}