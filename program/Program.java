/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

/**
 *
 * @author ingenieria
 */
public class Program
{
	private static int[][] xn =
	{
		{1, 1, 1},
		{0, 1, 1},
		{1, 0, 1}
	};
	private static int[][] pattern =
	{
		{1, 0, 1},
		{0, 1, 0},
		{1, 1, 1}
	};
	private static int[][] salida;
	private static double[] pesos = new double[] {1};
	private static double[] nPesos;
	private static double soma;
	private static int o = 0, err = -1, inn = 0, pixel = 0, mat = 0, aux = 0;
        public static void main (String [ ] args) {
		int ite = 0;
		nPesos = pesos;
		salida = new int[3][3];
		do
		{
			for (int c = 0; c < xn.length; c++)
			{
				for (int f = 0; f < (xn.length == 0 ? 0 : xn[0].length); f++)
				{
					
					System.out.println("Vuelta: " + (aux + 1));
					System.out.println("-------------------------------------------");
					while (err != 0)
					{
						System.out.println("Ciclo MATRIZ: [" + c + "," + f + "] nodo matriz: " + (ite + 1));
						
						pixel = xn[f][c];
						soma += (pixel + nPesos[0]);
						System.out.println("W: " + nPesos[0]);
						System.out.println("X: " + xn[f][c]);
						System.out.println("EYzoma: " + soma);
						System.out.println("f: " + fActivacion(soma));
						err = fError(f, c, fActivacion(soma));
						System.out.println("La función de error es: " + String.valueOf(err));
						System.out.println("-------------------------------------------");
						ite++;
						mat++;
					}
					salida[f][c] = fActivacion(soma);
					err = -1;
					ite = 0;
					soma = 0;
					aux++;
				}
			}
		} while (mat <= xn.length);
		
		System.out.println("Matrix: ");
		for(int fi = 0; fi < xn.length; fi++)
		{
			for (int co = 0; co < (xn.length == 0 ? 0 : xn[0].length); co++)
			{
				System.out.print("[" + xn[fi][co] + "]");
			}
			System.out.print("\n");
		}
		
		System.out.println("Result Matix: ");
		for (int fi = 0; fi < salida.length; fi++)
		{
			for (int co = 0; co < (salida.length == 0 ? 0 : salida[0].length); co++)
			{
				System.out.print("[" + salida[fi][co] + "]");
			}
			System.out.print("\n");
		}
		
		System.out.println("Matrix base: ");
		for (int fi = 0; fi < pattern.length; fi++)
		{
			for (int co = 0; co < (pattern.length == 0 ? 0 : pattern[0].length); co++)
			{
				System.out.print("[" + pattern[fi][co] + "]");
			}
			System.out.print("\n");
		}
	}
	private static int fActivacion(double d)
	{
		if (d > 1)
		{
			return 1;
		}
		if (d <= 1)
		{
			return 0;
		}
		return -1;
	}
	private static int fError(int fila, int columna, int q)
	{
		o = pattern[fila][columna];
		inn = xn[fila][columna];
		System.out.println("El valor que quiero es: " + String.valueOf(o));
		err = o - q;
		nPesos = new double[1];
		if (err != 0)
		{
			for (int i = 0; i < pesos.length; i++)
			{
				nPesos[i] = -0.002 * err * inn;
				nPesos[i] += pesos[i];
				System.out.println("El peso " + (i + 1) + " ajustado es: " + nPesos[i]);
			}
			return -1;
		}
		return err;
	}
}
