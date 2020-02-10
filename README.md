# Refatoramento - Code smells corrigidos:

***1 - DUPLICATE CODE:*** A classe StoreManager possuia muitas linhas de código por causa da repetição de vários blocos, como blocos de leitura e tratamento de inteiros, causando problema de legibilidade e manutenção.

Solução: Foi criada a classe AuxiliaryMethods, onde os métodos readNumber e readCpf foram adicionados para evitar essa repetição.


***2 - GOD CLASS:*** A classe StoreManager também era considerada uma god class, visto que possuia muitas linhas de código e muitos métodos e blocos repetidos, o que tornava o código menos legíveis e de difícil manutenção.

Solução: Aproveitei a classe AuxiliaryMethods e criei médotos auxiliares, como os que mostram as opções de menu, removendo blocos que ocupavam muitas linhas na classe original. Dessa forma, StoreManager passou de 541 para 287 linhas de código.


***3 - LAZY CLASS:*** A classe People, do pacote people, possuia poucos métodos e era pouco usada no código, sendo considerada uma Lazy Class.

Solução: A classe People foi excluída; Client e Employee, que herdavam People, receberam seus métodos e atributos. 


***Código original:*** https://github.com/paulov59/Projeto-OO
