package weka.classifiers.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;

import weka.classifiers.AbstractClassifier;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author César Ramírez
 * Implementación del algoritmo ID3 para construir un árbol de decisión.
 */
public class ID3 extends AbstractClassifier {

	private static final long serialVersionUID = 1789045553777829235L;
	private Nodo raiz;

	// Clase interna para representar los nodos del árbol
	private class Nodo {
		String atributo;
		Map<String, Nodo> hijos = new HashMap<>();
		double clase;
		boolean esHoja;

		Nodo(String atributo) {
			this.atributo = atributo;
			this.esHoja = false;
		}

		Nodo(double clase) {
			this.clase = clase;
			this.esHoja = true;
		}
	}

	@Override
	public void buildClassifier(Instances datos) throws Exception {
		// Construcción del árbol de decisión usando el algoritmo ID3
		datos.setClassIndex(datos.numAttributes() - 1);
		raiz = construirArbol(datos);
	}

	private Nodo construirArbol(Instances datos) {
		// Si todos los ejemplos tienen la misma clase, retornar un nodo hoja
		if (datos.numDistinctValues(datos.classIndex()) == 1) {
			return new Nodo(datos.instance(0).classValue());
		}

		// Si no quedan atributos para dividir, retornar una hoja con la clase mayoritaria
		if (datos.numAttributes() == 1) {
			return new Nodo(claseMayoritaria(datos));
		}

		// Calcular la ganancia de información para cada atributo
		double[] ganancias = gananciaInformacion(datos);

		// Encontrar el mejor atributo (el de mayor ganancia de información)
		int mejorAtributoIndex = Utils.maxIndex(ganancias);
		Attribute mejorAtributo = datos.attribute(mejorAtributoIndex);

		// Crear un nodo para el mejor atributo
		Nodo nodo = new Nodo(mejorAtributo.name());

		// Dividir los datos según los valores del mejor atributo y construir subárboles
		Enumeration<Object> valores = mejorAtributo.enumerateValues();
		while (valores.hasMoreElements()) {
			String valor = (String) valores.nextElement();
			Instances subconjunto = filtrarDatos(datos, mejorAtributoIndex, valor);

			if (subconjunto.numInstances() == 0) {
				nodo.hijos.put(valor, new Nodo(claseMayoritaria(datos)));
			} else {
				nodo.hijos.put(valor, construirArbol(subconjunto));
			}
		}

		return nodo;
	}

	private Instances filtrarDatos(Instances datos, int atributoIndex, String valor) {
		// Filtrar instancias según un valor del atributo
		Instances subconjunto = new Instances(datos, datos.numInstances());
		for (int i = 0; i < datos.numInstances(); i++) {
			if (datos.instance(i).stringValue(atributoIndex).equals(valor)) {
				subconjunto.add(datos.instance(i));
			}
		}
		subconjunto.compactify();
		return subconjunto;
	}

	private double entropia(Instances datos) {
		// Calcular la entropía del conjunto de datos
		double[] conteoClases = new double[datos.numClasses()];
		Enumeration<Instance> en = datos.enumerateInstances();
		while (en.hasMoreElements()) {
			Instance instancia = en.nextElement();
			conteoClases[(int) instancia.classValue()]++;
		}
		double entropia = 0.0;
		for (double count : conteoClases) {
			if (count > 0) {
				double probabilidad = count / datos.numInstances();
				entropia -= probabilidad * Utils.log2(probabilidad);
			}
		}
		return entropia;
	}

	private double[] gananciaInformacion(Instances datos) {
		// Calcular la ganancia de información para cada atributo
		double[] ganancias = new double[datos.numAttributes() - 1];
		double entropiaTotal = entropia(datos);
		Enumeration<Attribute> en = datos.enumerateAttributes();
		int attrIndex = 0;
		while (en.hasMoreElements()) {
			Attribute atributo = en.nextElement();
			double entropiaAtributo = 0.0;
			Enumeration<Object> valores = atributo.enumerateValues();
			while (valores.hasMoreElements()) {
				String valor = (String) valores.nextElement();
				Instances subconjunto = filtrarDatos(datos, atributo.index(), valor);
				entropiaAtributo += (subconjunto.numInstances() / (double) datos.numInstances()) * entropia(subconjunto);
			}
			ganancias[attrIndex++] = entropiaTotal - entropiaAtributo;
		}
		return ganancias;
	}

	private double claseMayoritaria(Instances datos) {
		// Encontrar la clase mayoritaria en el conjunto de datos
		double[] conteoClases = new double[datos.numClasses()];
		Enumeration<Instance> en = datos.enumerateInstances();
		while (en.hasMoreElements()) {
			Instance instancia = en.nextElement();
			conteoClases[(int) instancia.classValue()]++;
		}
		return Utils.maxIndex(conteoClases);
	}

	@Override
	public double classifyInstance(Instance instancia) throws Exception {
		// Clasificar una nueva instancia recorriendo el árbol de decisión
		return clasificar(instancia, raiz);
	}

	private double clasificar(Instance instancia, Nodo nodo) {
		if (nodo.esHoja) {
			return nodo.clase;
		} else {
			Attribute atributo = instancia.dataset().attribute(nodo.atributo);
			String valor = instancia.stringValue(atributo);
			Nodo hijo = nodo.hijos.get(valor);
			if (hijo != null) {
				return clasificar(instancia, hijo);
			} else {
				return Double.NaN; // No debería llegar aquí
			}
		}
	}

	@Override
	public String toString() {
		// Imprimir la representación del árbol de decisión
		return "Árbol de decisión";
	}
	public static void main(String[] args) throws Exception {
		ID3 id3 = new ID3();
	
		// Leer los datos de prueba
		DataSource source = new DataSource("weather.nominal.arff");
		Instances datos = source.getDataSet();
	
		// Establecer la clase objetivo
		datos.setClassIndex(datos.numAttributes() - 1);
	
		// Construir el clasificador
		id3.buildClassifier(datos);
	
		// Clasificar e imprimir solo la primera instancia
		Instance primeraInstancia = datos.instance(0); // Obtener la primera instancia
		double clase = id3.classifyInstance(primeraInstancia);
	
		// Construir la representación de la primera instancia
		StringBuilder instanceString = new StringBuilder();
		for (int j = 0; j < primeraInstancia.numAttributes(); j++) {
			if (j != datos.classIndex()) {
				instanceString.append(primeraInstancia.stringValue(j)).append(",");
			}
		}
	
		// Añadir la clase original al final
		instanceString.append(primeraInstancia.stringValue(datos.classIndex()));

		Instance instance = datos.instance(2);
		
		// Imprimir la instancia y su clasificación
		System.out.println(instanceString.toString());
		System.out.println("Classified instance as: " + clase);
		System.out.println(instance);
	}
}