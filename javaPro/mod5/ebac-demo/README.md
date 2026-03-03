# AdotePet

## Descrição
<p>Sistema de cadastro de animais resgatados e que estão disponíveis para adoção.</p>

## Requisitos

### Requisitos Funcionais
<p>Projetar e construir uma API que permita o cadastro de animais resgatados pelo abrigo.</p>
<h4>Endpoints:</h4>

* Cadastro de animais
* Listagem de animais no abrigo que ainda não foram adotados, ordenado pela data de entrada no abrigo.
* Listagem de animais no abrigo que já foram adotados.

### Requisitos Não Funcionais

* Linguagem: Java
* Base de dados: H2
* Os serviços devem rodar em container.
* Autenticação e autorização não necessárias na primeira versão. 
* Larga escala: Não.
* APIs precisam receber e retornar dados no formato JSON.
* As APIs devem estar na arquitetura RESTful.
* O protocolo de comunicação deve ser HTTP.