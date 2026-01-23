# Programação Dinâmica

## Classe Main
### Contém o algoritmo de recurção direta par calculo do fatorial de um número inteiro positivo.
<p>Contém o algoritmo de recursão direta para o cálculo do fatorial de um número inteiro positivo. 
Nesse algoritmo, enfrentamos o problema do uso de memória não otimizado, pois cada chamada recursiva é empilhada 
na memória de execução, o que pode levar ao erro de StackOverflow. 
Não foi possível calcular o fatorial de 100 por atingir o limite da memória.
</p>

## Classe Fatorial BottomUp e TopDown
### Contém os algoritmos correspondentes as abordagens topdown e bottom up da programação dinâmica.
<p> Foi possível calcular o fatorial do número 100 </p>

## Porque a programação dinâmica apresenta um melhor desempenho?
<p> Apresenta um melhor desempenho por armazenar e reutilizar resultados de subproblemas já resolvidos, 
evitando cálculos redundantes. </p>

## Complexidade de tempo:
<p> A complexidade de tempo é O(n). Isso ocorre porque o problema original é dividido em N subproblemas menores, 
onde cada subproblema (o cálculo de cada fatorial intermediário) é resolvido exatamente uma vez e reutilizado.
</p>