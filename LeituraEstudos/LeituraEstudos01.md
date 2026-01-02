# Effective Java (Joshua Bloch)
## Criando e Destruindo Objetos (Itens 1–9)
(Resumindo use builder, adicione factory methods, singleton com enum e injeção de dependência)
Item 1: Métodos de Fábrica Estáticos vs. Construtores. Prefira métodos como valueOf ou of para maior clareza e controle de cache.

Item 2: Builder para muitos parâmetros. Evite o "Telescoping Constructor"; use o padrão Builder para objetos complexos.

Item 3: Singleton com Enums. A maneira mais segura de implementar um Singleton é via public enum { INSTANCE; }.

Item 5: Injeção de Dependência. Nunca "hardcode" recursos; passe-os no construtor para facilitar testes e flexibilidade.

Métodos Comuns a Todos os Objetos (Itens 10–12)
Item 10: equals(). Siga o contrato (reflexivo, simétrico, transitivo e consistente).

Item 11: hashCode(). Sempre sobrescreva hashCode se sobrescrever equals.

Item 12: toString(). Sempre forneça uma representação informativa para facilitar o debug.

## Classes e Interfaces (Itens 17–18)
(Resumindo prefira imutabilidade e composição sobre herança)
Item 17: Minimize a Mutabilidade. Classes imutáveis são mais simples, seguras e fáceis de compartilhar (ex: String, Integer).

Item 18: Composição sobre Herança. A herança quebra o encapsulamento. Prefira "wrapper classes" e delegue chamadas.

## Métodos e Exceções (Itens 49–55)
(Resumindo valide parâmetros, faça cópias defensivas, evite longas listas de parâmetros, retorne coleções vazias e use Optionals com cuidado)
Item 49: Valide parâmetros. Verifique se os argumentos são válidos logo no início do método (fail-fast).

Item 50: Cópias Defensivas. Proteja seus objetos imutáveis de modificações externas em campos mutáveis.

Item 51: Design da Assinatura de Métodos. Evite longas listas de parâmetros.

Item 54: Retorne coleções vazias, não null. Evite NullPointerException no cliente.

Item 55: Retorne Optionals com cuidado. Use para indicar que um resultado pode estar ausente sem forçar o uso de nulls.

# Java Performance
## Fundamentos (Capítulos 1–4)
Metodologias de Performance: Não otimize sem medir. Foque em métricas claras: Throughput (vazão), Latency (latência) e Footprint (memória).

Monitoramento da JVM: Uso de ferramentas como JVisualVM, JConsole e comandos jstat para entender o comportamento da aplicação em tempo real.

JIT (Just-In-Time) Compiler: Entender como a JVM compila bytecode para código nativo (C1/C2 compilers) e a importância do "warm-up" da aplicação.

Garbage Collection (GC) Basics: * Como a memória é dividida (Young Gen, Old Gen, Metaspace).

O impacto das pausas "Stop-the-World".

🛠️ Como aplicar este conhecimento
Revisão de Código: Utilize os itens do Effective Java como checklist em Pull Requests.

Profiling: Antes de mudar o código por performance, utilize ferramentas de perfilamento para identificar gargalos reais nos Cap. 1-4.

Próximo Passo: Gostaria que eu detalhasse algum desses itens específicos ou criasse um exemplo de código comparando o Item 18 (Composição vs Herança)?