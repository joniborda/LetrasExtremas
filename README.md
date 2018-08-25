# LetrasExtremas
Letras Extremas

## Descripción del problema
Un escritor quiere hacer una estadística un poco
particular.
Dada la lista de palabras utilizadas en su último
poema, quiere saber la letra extrema más
usada. Llama “extrema” a la letra inicial o
terminal de una palabra. Por ejemplo, las letras
extremas de arbol son la a y la l.
Además, para analizar cambios en el texto,
requiere que le listemos todas las palabras, en
cualquier orden, cuyas letras extremas coinciden
con la letra extrema más usada.
## Restricciones
Las letras utilizadas son sólo caracteres alfabéticos
en minúsculas, y sin acentos.
la cantidad N de palabras de la lista
 0 < N £ 250
el largo de una palabra £ 10
## Datos de entrada
Se recibe un archivo EXTREMAS.IN, ubicado
en el directorio actual, que contiene
· En la primera línea, la cantidad N de palabras
de la lista
En las N líneas siguientes, las palabras que
componen la lista de a una palabra  por línea.
## Datos de salida
El programa EXTREMAS.EXE debe generar el
archivo EXTREMAS.OUT, en el directorio actual,
informando:
1) En el primer renglón, la o las letras extremas
más frecuentes.
2) A continuación, deben listarse todas las
palabras que tengan por letra extrema a
alguna de las letras extremas más frecuentes,
o sea las listadas en el primer renglón. (de a
una palabra por línea y sin importar el orden
de las mismas, y sin repetir palabras)
En caso que hubiera empate, quiere aplicar su
análisis simultáneamente a todas las letras
empatadas.

## Ejemplo
Si EXTREMAS.IN contiene:

    6
    arbol
    orden
    susana
    otro
    listo
    nexos

Entonces, EXTREMAS.OUT podría contener:

    o
    orden
    otro
    listo
