# Atividades para Casa – Capítulo 8

## Atividade 1 – Reescrevendo código sem `goto`
Você recebeu o seguinte pseudocódigo, escrito de forma semelhante ao estilo das primeiras versões do Fortran, utilizando `goto`:

```text
i := 1
goto check

loop:
    print(i)
    i := i + 1

check:
    if (i <= 10) then
        goto loop
```

**Tarefas:**
1. Reescreva o código acima utilizando um laço de repetição pré-teste (`while`) em uma linguagem de sua escolha (C, Java, Python, etc.).
#include <stdio.h>

**Utilizando a linguagem C**

int main() {
    int i = 1;
    while (i <= 10) {
        printf("%d\n", i);
        i++;
    }
    return 0;
}
**______________________________________________________________________________**
2. Reescreva novamente utilizando um laço de repetição controlado por contador (`for`).

**Utilizando a linguagem C**

#include <stdio.h>

int main() {
    for (int i = 1; i <= 10; i++) {
        printf("%d\n", i);
    }
    return 0;
}
**______________________________________________________________________________**
3. Compare os três códigos (original com `goto`, versão com `while` e versão com `for`) e escreva um pequeno parágrafo discutindo qual forma é mais legível e por quê.

**Resposta**

O código original com goto é funcional, mas pouco legível, pois exige acompanhar saltos entre rótulos para compreender o fluxo de execução. Já a versão com while melhora a clareza, pois apresenta a condição de parada diretamente no laço, tornando a leitura mais natural. No entanto, a versão com for é ainda mais adequada nesse caso, já que concentra em uma única linha a inicialização, a condição e o incremento da variável de controle, expressando de maneira simples e direta a ideia de repetir de 1 até 10. Por isso, entre as três opções, a solução com for é a mais legível e intuitiva.
**______________________________________________________________________________**

## Atividade 2 – Seleção múltipla em diferentes linguagens
Muitos programas oferecem menus interativos. Suponha que você precisa implementar um menu com as seguintes opções:

1. Calcular o quadrado de um número.
2. Calcular o fatorial de um número.
3. Sair do programa.

**Tarefas:**
1. Implemente esse menu em **C** utilizando `switch/case`.

#include <stdio.h>

int fatorial(int n) {
    int fat = 1;
    for(int i = 1; i <= n; i++) {
        fat *= i;
    }
    return fat;
}

int main() {
    int opcao, numero;

    do {
        printf("\nMenu:\n");
        printf("1. Calcular o quadrado de um numero\n");
        printf("2. Calcular o fatorial de um numero\n");
        printf("3. Sair\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);

        switch(opcao) {
            case 1:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                printf("Quadrado: %d\n", numero * numero);
                break;

            case 2:
                printf("Digite um numero: ");
                scanf("%d", &numero);
                printf("Fatorial: %d\n", fatorial(numero));
                break;

            case 3:
                printf("Saindo...\n");
                break;

            default:
                printf("Opcao invalida!\n");
        }
    } while(opcao != 3);

    return 0;
}
**______________________________________________________________________________**

2. Implemente o mesmo menu em **Python**, utilizando apenas `if/elif/else`.

def fatorial(n):
    fat = 1
    for i in range(1, n + 1):
        fat *= i
    return fat

while True:
    print("\nMenu:")
    print("1. Calcular o quadrado de um número")
    print("2. Calcular o fatorial de um número")
    print("3. Sair")

    opcao = int(input("Escolha uma opção: "))

    if opcao == 1:
        numero = int(input("Digite um número: "))
        print("Quadrado:", numero ** 2)

    elif opcao == 2:
        numero = int(input("Digite um número: "))
        print("Fatorial:", fatorial(numero))

    elif opcao == 3:
        print("Saindo...")
        break

    else:
        print("Opção inválida!")
**______________________________________________________________________________**

3. Execute os dois programas e compare as soluções em relação à clareza e quantidade de código.

**C** com switch: Estrutura organizada para múltiplos casos, mas exige mais código (declaração de variáveis, funções auxiliares, etc.).

**Python** com if/elif/else: Mais simples e direto, sem necessidade de escrever muito código “cerimonial”.

**______________________________________________________________________________**

4. Escreva um comentário final destacando em qual linguagem foi mais simples de implementar e justificar o motivo.

**Resposta**
a implementação em Python foi mais simples e legível, pois a linguagem tem sintaxe mais enxuta e permite focar na lógica em vez de detalhes técnicos como declaração de variáveis e protótipos.
**______________________________________________________________________________**

## Atividade 3 – Explorando alternativas ao `goto`
Historicamente, o `goto` foi usado para resolver diferentes tipos de desvio. Hoje, a maioria das linguagens fornece alternativas como `break`, `continue` e `return`.

**Tarefas:**
1. Escreva um programa que percorra uma lista de números inteiros e:
   - Pare imediatamente a execução ao encontrar o número 0 (`break`).
   - Pule os números negativos sem processá-los (`continue`).
   - Retorne o dobro do primeiro número par encontrado (`return`).

   **Em C**
   #include <stdio.h>

// Função que processa a lista
int processa_lista(int lista[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        if (lista[i] == 0) {
            break; // Para imediatamente se encontrar 0
        }
        if (lista[i] < 0) {
            continue; // Pula os números negativos
        }
        if (lista[i] % 2 == 0) {
            return lista[i] * 2; // Retorna o dobro do primeiro número par
        }
    }
    return -1; // Caso não encontre nenhum número par
}

int main() {
    int valores[] = {5, -3, 7, -1, 8, 0, 10};
    int tamanho = sizeof(valores) / sizeof(valores[0]);

    int resultado = processa_lista(valores, tamanho);

    if (resultado != -1) {
        printf("Resultado: %d\n", resultado);
    } else {
        printf("Nenhum número par encontrado.\n");
    }

    return 0;
}
**______________________________________________________________________________**

2. Comente sobre como seria a implementação desse mesmo programa utilizando apenas `goto` e rótulos, destacando as vantagens da abordagem moderna.

**Resposta**
Se fosse feito com goto, precisaríamos de vários rótulos (labels) para simular os desvios. O código ficaria mais difícil de entender e manter, algo assim:

#include <stdio.h>

int processa_lista_goto(int lista[], int tamanho) {
    int i = 0;

inicio:
    if (i >= tamanho) goto fim;

    if (lista[i] == 0) goto fim;

    if (lista[i] < 0) {
        i++;
        goto inicio; // Pula os negativos
    }

    if (lista[i] % 2 == 0) {
        return lista[i] * 2; // Encerra com return
    }

    i++;
    goto inicio;

fim:
    return -1;
}

- O break vira goto fim.
- O continue vira goto inicio.
- O return ainda funciona normal, mas o código fica cheio de rótulos.

 Usar break, continue e return deixa o programa muito mais legível e próximo da intenção original.