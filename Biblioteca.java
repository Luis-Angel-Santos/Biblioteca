package testingclasematrices;

//@author Angel

import java.util.Scanner;

public class ClaseArreglos {
    
    //crear una matriz
    public int [][] CrearMatriz(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que dimensiones sera la matriz?");
        int dim = sc.nextInt();
        int matriz [][] = new int[dim][dim];
        System.out.println("--------------------------------");
        System.out.println("Matriz Creada");
        return matriz;
    }
    
    //LLenar una matriz
    public int[][] LlenarMatriz(int A[][]){//Recibimos la matriz
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<A.length; i++){
            for (int x=0; x<A[i].length; x++){
                System.out.println("Ingrese los datos de la posición ["+i+"]["+x+"]");//Pedimos los datos de la posicion
                A[i][x]=sc.nextInt();//Asignamos ese valor a la posicion
            }
        }
        return A;//Regresamos la matriz ya llena
    }
    
    //Sumar las columnas de una matriz
    public int[] SumarColumnas(int matriz[][]){//Recibimos la matriz
        int [] C = new int[matriz.length];//Declaramos un vector en donde guardaremos los resultados
        int sumaCol=0;//Declaramos un contador
        for(int i=0; i<matriz.length; i++){//recorre la fila
            for(int x=0; x<matriz[i].length; x++){//Recorre cada posicion de la columna
                if(x<matriz[i].length){   
                    sumaCol += matriz [x][i];//Al contador sumamos el dato que esta en la posicion indicada
                }   
            }
            C[i]=sumaCol;//Asigamos la suma de esa columna a una posicion en el vector
            sumaCol = 0;   //Asignamos 0 a nuestro contador para que no haya problema en el ciclo
        } 
        return C;
    }
    
    //sumar filas de una matrisz
    public int[] SumarFilas(int B[][]){//recibimos una matriz
        int [] D = new int[B.length];//declaramos un vector en el cual guardatemos los resultados
        int sumaFilas=0;
        for (int i = 0; i < B.length; i++){ //recorremos fila por fila
            for (int x = 0; x < B[i].length; x++){//y cada posicion en la columna
                if (x < B[0].length) {
                    sumaFilas += B[i][x];//asignamos el valor de la matriz al contador
                }
            }
            D[i]=sumaFilas;//lo colocamos en el vector
            sumaFilas = 0;
        }
        return D;
    }
    
    //mostrar matriz
    public void MostrarMatriz(int A[][]){
        System.out.println("Esta es la Matriz: ");
        for (int[] A1 : A) {//recorre cada posicion a lo largo de la matriz
            for (int j = 0; j < A1.length; j++) {//recorre cada posicion a lo ancho de la matriz
                System.out.print(A1[j] + " ");
            }
            System.out.println();//Salto de linea
        }
        System.out.println();
    }
    
    //mostrar vetor (lo mismo de arriba pero con vectores XD)
    public void MostrarVector(int A[]){
        System.out.println("Este es el resultado: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
    
    //Multiplicar matrices
    public int[][] MultiplicarMatrices ( int[][] A, int[][] B) {//recibimos las dos matrices que queremos multiplicar
      int[][] C = new int[A.length][B[0].length];//creamos una matriz para guardar los resultados de la multiplicacion
      for (int i= 0; i<C.length; i++)
          for (int j=0; j<C[0].length; j++)
              for (int k=0; k<B.length; k++)
                  C[i][j] = C[i][j] + A[i][k] * B[k][j];//multiplicamos la casilla de la primer matriz por la segunda matriz
      return C;
   }
    
    //matriz irregular
    public int[][] MatrizIrregular(){//en este metodo solo crearemos una matriz irregular
        Scanner sc = new Scanner(System.in);
        int filas, colum;
        System.out.println("¿Cuantas filas tendra la matriz?");//pedimos cuantas filas tendra
        filas = sc.nextInt();
        int [][]matriz = new int[filas][];//creamos la matriz con las filas que asignamos
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("¿Cuantas columnas quieres en la fila " +i+ "?");//asignamos las columnas que queramos a la fila X
            colum = sc.nextInt();
            matriz [i] = new int[colum];//guardamos las columnas en la matriz
        }
        return matriz;//Regresamos la matriz ya creada, pero vacia
    }
    
    //matriz en forma de caracol/espiral
    public int[][] MatrizCaracol(int n, int x) {//en este caso n es la dimension de la matriz y x es el numero de donde empezara la matriz
        int[][] M = new int[n + 1][n + 1];//creamos la matriz en la cual se generara el caracol
        for (int a = 1; a <= n / 2; a++) {
            for (int i = a; i <= n - a; i++) {
                M[a][i] = x;
                x++;
            }
            for (int i = a; i <= n - a; i++) {
                M[i][n - a + 1] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                M[n - a + 1][i] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                M[i][a] = x;
                x++;
            }
        }
        if (n % 2 == 1) {
            M[n / 2 + 1][n / 2 + 1] = x;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("\t" + M[i][j]);//imprimimos la matriz en caracol
            }
            System.out.println();
        }
        return M;//regresamo la matriz, por si quieren cambiar algo
        
    }
    
    //transponer una matriz
    public int[][] TransponerMatriz(int matriz[][]){//recibimos la matriz que queremos transponer
        int[][] C = new int[matriz[0].length][matriz.length];//creamos una nueva matriz con las dimensiones de la primera matriz
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                C[y][x] = matriz[x][y];//transponemos de posicion los datos
            }
        }
        return C;//regresamos la matriz transpuesta
    }
    
    //buscar un elemento especifico en la mariz
    public void BuscarElemento(int A, int matriz[][]){//En este caso recibiremos la matriz y A sera el dato que queremos buscar en la matriz
        int pos = 0, fila = 0, colum = 0, cont = 1;//declaramos e inicializamos algunos contadores 
        for (int i = 0; i < matriz.length; i++) {//recorremos cada fila de la matriz
            for (int j = 0; j < matriz[i].length; j++) {//recorremos cada columna de la matriz
                if (matriz[i][j] == A) {//comparamos que la posicion en la que estamos es igual al dato que buscamos
                    pos = cont;//guardamos el valor encontrado
                    fila = i;//guardamos la fila en donde se encontro
                    colum = j;//guardamos la columna donde se encontro
                }
                cont++;//en caso de que no aumentamos el contador y se repite el proceso
            }
        }
        if (pos >= 1) {//imprimimos si se encontro o no el elemento y en que posicion
            System.out.println("Elemento encontrado en la posicion "+(pos)+" de la matriz");
            System.out.println("Se encuentra en la fila "+(fila+1)+" columna "+(colum+1));
        }
        else{
            System.out.println("El elemento no existe en la matriz, lo setimos");
        }
    }
    
    //saber si una matriz es simetrica
    public boolean esMatrizSimetrica(int matriz[][]){//recibimos la matriz que queremos saber si es simetrica o no
	for(int i=0; i < matriz.length; i++){//recorremos todas la filas de la matriz
            for(int j=0; j < matriz[i].length ; j++){//recorremos las columnas de la matriz
		if(matriz[i][j] != matriz[j][i]){//comparamos si son distintas los datos de las posiciones opuestas
                    return false;//si es falsa, entonces no es simretica
		}
            }
	}
	return true;//es una matriz simetrica
    }
    
    //matriz identidad
    public void MatrizIdentidad(int matriz[][]){//recibimos una matriz vacia 
        for(int i=0; i<matriz.length; i++){
            for (int x=0; x<matriz[i].length; x++){
                matriz[i][x] = 0;//lenamos la matriz con puros 0
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][i] = 1;//asginaos 1 a cada diagonal en la matriz
        }
        System.out.println("Esta es la Matriz Identidad: ");//Mostramos como queda
        for (int[] A1 : matriz) {//recorre cada posicion a lo largo de la matriz
            for (int j = 0; j < A1.length; j++) {//recorre cada posicion a lo ancho de la matriz
                System.out.print(A1[j] + " ");
            }
            System.out.println();//Salto de linea
        }
        System.out.println();
    }
}
