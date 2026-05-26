# Motiva Verde - Sprint 2

## Integrantes

| Nome | RM |
|------|----|
| Arthur da Silva Alencar | 563684 |
| Felipe Paula Burba Molonhoni | 564395 |
| Lucas de Freitas Barbosa | 564685 |
| Pedro Del Neri Correia | 562168 |
| Vitor Limeira dos Santos | 565280 |

---

## Sobre o projeto

Este projeto faz parte do Challenge Motiva Verde, que tem como objetivo criar uma solução para auxiliar no monitoramento e na priorização da roçada de vegetação em rodovias.

O problema principal considerado no projeto é a dificuldade de manter a vegetação dos trechos rodoviários sempre abaixo de 30 cm. Quando a grama atinge ou ultrapassa esse limite, o trecho passa a exigir mais atenção, pois pode gerar riscos operacionais, prejudicar a visibilidade e aumentar a necessidade de manutenção urgente.

Nesta Sprint 2, o projeto foi evoluído com um motor de regras que analisa automaticamente os trechos cadastrados e gera um relatório de prioridade, indicando quais KMs precisam de intervenção.

---

## Objetivo da Sprint 2

O objetivo desta sprint foi aplicar conceitos de Programação Orientada a Objetos para criar uma lógica mais inteligente de análise dos trechos da rodovia.

Foram utilizados:

- Classes abstratas;
- Interfaces;
- Herança;
- Polimorfismo;
- Encapsulamento;
- Enums;
- Arrays;
- Organização em pacotes.

---

## Regras de prioridade

As prioridades foram definidas de acordo com a altura da vegetação:

| Altura da vegetação | Prioridade | Intervenção indicada |
|---|---|---|
| Até 15 cm | Baixa | Nenhuma intervenção imediata |
| Acima de 15 cm até 20 cm | Moderada | Nenhuma intervenção imediata |
| De 21 cm até 29 cm | Alta | Pulverização |
| 30 cm ou mais | Urgente | Roçada mecanizada |

A prioridade `URGENTE` foi criada porque o limite de 30 cm é o ponto principal do problema. A partir desse valor, o trecho precisa de uma intervenção mais direta.

---

## Principais classes

### TrechoRodovia

Representa um trecho da rodovia, contendo informações como quilômetro, altura da vegetação, condição de crescimento e equipe responsável.

### TrechoMonitorado

Representa um trecho com sensor IoT instalado. Ele herda de `TrechoRodovia` e implementa a interface `MonitoravelViaIoT`.

### MonitoravelViaIoT

Interface responsável por definir o comportamento de transmissão de dados por sensor.

Método principal:

```java
double transmitirDadosSensor();
```

### IntervencaoOperacional

Classe abstrata que representa uma intervenção operacional genérica. Ela possui o método abstrato `executarServico()`, que é implementado pelas classes filhas.

### RocadaMecanizada

Representa a roçada mecanizada. No projeto, é indicada para trechos com vegetação de 30 cm ou mais.

### Pulverizacao

Representa uma intervenção preventiva. No projeto, é indicada para trechos com vegetação entre 21 cm e 29 cm.

### MotorPrioridade

Classe responsável por percorrer o array de trechos, analisar a altura da vegetação, definir a prioridade e indicar a intervenção necessária.

---

## Funcionamento do sistema

O sistema cria um conjunto de trechos de rodovia em um array.

Alguns trechos são comuns e outros possuem monitoramento via IoT. Quando o trecho possui IoT, o sistema simula uma nova medição da altura da vegetação antes de gerar o relatório.

Depois disso, o `MotorPrioridade` analisa cada trecho e mostra no terminal:

- KM analisado;
- Altura atual da vegetação;
- Condição de crescimento;
- Equipe responsável;
- Prioridade;
- Intervenção indicada;
- Altura após a intervenção, quando houver serviço executado.

---

## Perguntas de reflexão

### Por que não faz sentido para a Motiva que uma equipe execute apenas uma "Intervenção Operacional" genérica sem especificar qual é?

Não faz sentido porque “Intervenção Operacional” é um conceito muito amplo. Na prática, a equipe precisa saber exatamente qual serviço será realizado.

Uma roçada mecanizada, por exemplo, exige equipamentos, operadores e planejamento diferentes de uma pulverização. Se o sistema informasse apenas que existe uma intervenção operacional genérica, a equipe não teria informação suficiente para executar o serviço corretamente.

Por isso, no projeto, `IntervencaoOperacional` foi criada como uma classe abstrata. Ela serve como modelo base, mas a execução real fica nas classes específicas, como `RocadaMecanizada` e `Pulverizacao`.

---

### Qual a diferença arquitetural entre fazer um trecho herdar de uma classe abstrata vs. implementar uma interface?

Herdar de uma classe abstrata significa que a classe faz parte de uma hierarquia. Ou seja, ela é um tipo mais específico daquela classe base.

Implementar uma interface significa assumir um comportamento. A interface define o que uma classe deve ser capaz de fazer, sem obrigar que ela pertença a uma hierarquia específica.

No projeto, `TrechoMonitorado` herda de `TrechoRodovia` porque ele continua sendo um trecho de rodovia. Porém, ele implementa `MonitoravelViaIoT` porque possui uma capacidade adicional: transmitir dados de sensores.

De forma simples:

- Herança representa o que a classe é;
- Interface representa o que a classe consegue fazer.

Essa separação deixa o sistema mais organizado e mais fácil de expandir no futuro.

---

## Testes conceituais

A classe `IntervencaoOperacional` não pode ser instanciada diretamente, pois é abstrata.

Exemplo inválido:

```java
// IntervencaoOperacional teste = new IntervencaoOperacional("Teste");
```

Também foi criado um mock simples da interface `MonitoravelViaIoT`, simulando a transmissão de dados de um sensor. Isso mostra que o sistema consegue trabalhar com qualquer objeto que implemente essa interface, sem depender diretamente de uma classe específica.

---

## Conclusão

Nesta Sprint 2, o projeto passou a ter uma lógica mais próxima de um sistema real de apoio à decisão. O motor de regras analisa os trechos da rodovia, considera dados simulados de sensores IoT e indica a prioridade de manutenção de acordo com a altura da vegetação.

Com isso, a solução ajuda a organizar melhor quais KMs precisam apenas de acompanhamento, quais precisam de ação preventiva e quais exigem intervenção urgente.
