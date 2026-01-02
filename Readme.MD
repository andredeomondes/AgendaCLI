# 📒 Agenda CLI - Estudo de Java Efetivo

Este projeto é uma aplicação de linha de comando (CLI) para gerenciamento de contatos, desenvolvida com o objetivo de
aplicar na prática os princípios do livro "Java Efetivo" (Joshua Bloch) e conceitos de alta performance em persistência
de dados.

## 🚀 Tecnologias Utilizadas

Java 17+

Jackson Databind: Manipulação eficiente de arquivos JSON.

Maven: Gerenciamento de dependências.

ANSI Escapes: Interface rica no terminal com cores e animações.

## 📚 Princípios do "Java Efetivo" Aplicados

Durante o desenvolvimento, os seguintes itens do livro foram implementados para garantir um código limpo e robusto:

Item 2: Considerar o padrão Builder quando confrontado com muitos parâmetros no construtor.

Utilizado na classe Contato para garantir a criação de objetos imutáveis de forma clara.

Item 5: Preferir injeção de dependência a recursos codificados rigidamente.

A AgendaService recebe o ContatoRepository via construtor, facilitando testes e trocas de banco de dados.

Item 17: Minimizar a mutabilidade.

A classe Contato é final e possui apenas campos final, prevenindo efeitos colaterais.

Item 49: Verificar a validade dos parâmetros.

Implementação de "Fail-Fast" na Service para validar nomes e telefones antes de processar.

Item 54: Retornar coleções vazias, não nulas.

O repositório retorna Collections.emptyList() em vez de null, evitando o temido NullPointerException.

## ⚡ Performance e UX no Terminal

Além da arquitetura, o projeto foca em:

Persistência Não-Bloqueante: Simulação de carregamento (Thread.sleep) para feedback visual ao usuário sem comprometer a
integridade dos dados.

Interface Colorida (CLI): Uso de padrões de cores para facilitar a leitura:

Verde: Sucesso nas operações.

Vermelho: Erros de validação ou sistema.

Amarelo Itálico: Entradas do usuário.

## 🛠️ Como Executar

Certifique-se de ter o arquivo database.json na pasta src/main/resources/.

O arquivo deve iniciar com pelo menos um par de colchetes vazios: [].

Execute a classe Main.java.

## Exemplo de Uso

```

=== 📒 AGENDA JAVA EFETIVA ===
1. Adicionar Contato
2. Listar Contatos
3. Remover Contato
4. Sair
   ➤ Escolha uma opção:
```

## 🛠️ O que foi aprendido?

Separação de camadas (UI -> Service -> Repository -> Model).

## Tratamento de exceções customizadas.

Manipulação de arquivos com caminhos relativos em Java.

Serialização e Deserialização de objetos imutáveis com Jackson.

Projeto desenvolvido para fins de estudo e aprimoramento técnico. 🐉

