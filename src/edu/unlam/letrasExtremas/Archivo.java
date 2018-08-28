package edu.unlam.letrasExtremas;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {
	
	public String path;
	public String name;
	private BufferedReader entradaBytes;
	private BufferedReader lector;

	public Archivo(String path, String name) {
		this.path = path;
		this.name = name;
		InputStream entradaBytes = ClassLoader.class.getResourceAsStream(this.path + this.name);
		this.lector = new BufferedReader(new InputStreamReader(entradaBytes));
	}

	public String leerSiguienteLinea() {
		String linea = null;
		try {
			if ((linea = this.lector.readLine()) != null) {
				return linea;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// significa fin de archivo
				if (linea == null) {
					this.lector.close();
					this.entradaBytes.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public void comienzo() throws IOException {
		this.lector.mark(0);
	}

	/**
	 * Comparador de archivos para los tests
	 * 
	 * @param otro
	 * 
	 * @return Si es igual
	 */
	public boolean equals(Object obj) {
		try {
			Archivo otro = (Archivo) obj;

			this.comienzo();
			otro.comienzo();

			String cadena1 = this.lector.readLine();
			String cadena2 = otro.lector.readLine();
			boolean iguales = true;

			while ((cadena1 != null) && (cadena2 != null) && iguales) {

				if (!cadena1.equals(cadena2)) {
					iguales = false;
				}

				cadena1 = this.lector.readLine();
				cadena2 = otro.lector.readLine();
			}

			this.lector.close();
			otro.lector.close();

			if ((iguales) && (cadena1 == null) && (cadena2 == null)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void imprimirOutput(ArrayList<String> out) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.path + this.name);
            pw = new PrintWriter(fichero);


            //TODO: imprimir

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
	}
	
	
}
